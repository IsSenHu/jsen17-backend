package com.jsen17.terminal.helper;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Husen
 * @since 2022/11/26 23:02
 */
public class ConfigManager {

    private static final String CONFIG_DIR = System.getProperty("user.home") + File.separator + "terminal_helper";

    private static final String CONFIG_FILE = "config.json";

    static {
        File dir = new File(CONFIG_DIR);
        if (!dir.exists()) {
            boolean mkdir = dir.mkdir();
            System.out.printf("mkdir dir:%s %s %s", CONFIG_DIR, mkdir, System.lineSeparator());
        }
        Path path = Paths.get(CONFIG_DIR, CONFIG_FILE);
        File file = path.toFile();
        if (!file.exists()) {
            try {
                boolean newFile = file.createNewFile();
                System.out.printf("create config.json %s %s", newFile, System.lineSeparator());
                Config config = new Config();
                saveConfig(path, config);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private static void saveConfig(Path path, Config config) throws IOException {
        try (OutputStream out = Files.newOutputStream(path)) {
            byte[] bytes = JSON.toJSONString(config, true).getBytes(StandardCharsets.UTF_8);
            out.write(bytes);
            out.flush();
        }
    }

    public static void addHost(Host host) {
        Path path = Paths.get(CONFIG_DIR, CONFIG_FILE);

        try {
            Config config = loadConfig(path);

            Map<String, Host> hostMap = config.getHosts().stream().collect(Collectors.toMap(ConfigManager::hostKey, h -> h));
            hostMap.put(hostKey(host), host);
            config.setHosts(new ArrayList<>(hostMap.values()));

            saveConfig(path, config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Config loadConfig() throws IOException {
        Path path = Paths.get(CONFIG_DIR, CONFIG_FILE);
        return loadConfig(path);
    }

    private static Config loadConfig(Path path) throws IOException {
        Config config;
        try (InputStream in = Files.newInputStream(path)) {
            String json = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            config = JSON.parseObject(json, Config.class);
        }
        return config;
    }

    private static String hostKey(Host host) {
        return host.getIp() + ":" + host.getPort();
    }
}
