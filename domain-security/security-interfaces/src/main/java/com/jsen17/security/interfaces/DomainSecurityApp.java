package com.jsen17.security.interfaces;

import com.jsen17.security.interfaces.controller.UserController;
import com.jsen17.webflux.utils.ContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HuSen
 * @since 2022/5/27 10:31 AM
 */
@SpringBootApplication
public class DomainSecurityApp {

    public static void main(String[] args) {
        SpringApplication.run(DomainSecurityApp.class, args);

        ContextUtils.getBean(UserController.class);
    }
}
