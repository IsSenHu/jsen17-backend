package com.jsen17.terminal.helper.impl;

import com.jsen17.terminal.helper.CommandProcessor;
import com.jsen17.terminal.helper.ConfigManager;
import com.jsen17.terminal.helper.Host;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Husen
 * @since 2022/11/26 23:17
 */
public class LoginCommandProcessor implements CommandProcessor {

    @Override
    public void processing(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Host> hosts = ConfigManager.loadConfig().getHosts();
        System.out.println("please select host to login.");
        for (int i = 1; i <= hosts.size(); i++) {
            Host host = hosts.get(i - 1);
            System.out.printf("%s: ip:%s port:%s user:%s pwd:%s", i, host.getIp(), host.getPort(), host.getUsername(), host.getPassword());
            System.out.println();
        }
        int index = Integer.parseInt(scanner.nextLine());
        if (index < 1 || index > hosts.size()) {
            System.out.println("input error.");
            return;
        }
        Host host = hosts.get(index - 1);
        String cmd = String.format("ssh -p %s %s@%s%n", host.getPort() + "", host.getUsername(), host.getIp());
        System.out.println(cmd);
    }
}
