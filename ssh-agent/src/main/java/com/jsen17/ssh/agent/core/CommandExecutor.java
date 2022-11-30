package com.jsen17.ssh.agent.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Husen
 * @since 2022/11/30 21:45
 */
@Slf4j
@Component
public class CommandExecutor {

    public OutputStream exec(String command, OutputStream resultStream) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            InputStream inputStream = process.getInputStream();
            OutputStream outputStream = process.getOutputStream();
            InputStream errorStream = process.getErrorStream();
            inputStream.transferTo(resultStream);
            errorStream.transferTo(resultStream);
            return outputStream;
        } catch (IOException e) {
            log.info("exec command:{} failed.", command, e);
        }
        return null;
    }
}
