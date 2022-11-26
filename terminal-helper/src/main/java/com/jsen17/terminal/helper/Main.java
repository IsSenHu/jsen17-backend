package com.jsen17.terminal.helper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

/**
 * @author Husen
 * @since 2022/11/26 22:43
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
        if (args.length == 0) {
            return;
        }
        Command command = getCommand(args[0]);
        if (command == null) {
            return;
        }
        command.getProcessor().processing(args);
    }

    private static Command getCommand(String commandStr) {
        try {
             return Command.valueOf(commandStr.toUpperCase(Locale.ROOT));
        } catch (Exception e) {
            System.out.printf("unknown command:%s", commandStr);
        }
        return null;
    }
}