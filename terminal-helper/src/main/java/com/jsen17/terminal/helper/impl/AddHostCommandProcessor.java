package com.jsen17.terminal.helper.impl;

import com.jsen17.terminal.helper.CommandProcessor;
import com.jsen17.terminal.helper.ConfigManager;
import com.jsen17.terminal.helper.Host;

import java.util.Scanner;

/**
 * @author Husen
 * @since 2022/11/26 22:58
 */
public class AddHostCommandProcessor implements CommandProcessor {

    @Override
    public void processing(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input host or ip:");
        String ip = scanner.nextLine();
        System.out.println("please input port:");
        int port = Integer.parseInt(scanner.nextLine());
        System.out.println("please input username:");
        String username = scanner.nextLine();
        System.out.println("please input password:");
        String password = scanner.nextLine();
        Host host = new Host();
        host.setIp(ip);
        host.setPort(port);
        host.setUsername(username);
        host.setPassword(password);

        ConfigManager.addHost(host);
    }
}
