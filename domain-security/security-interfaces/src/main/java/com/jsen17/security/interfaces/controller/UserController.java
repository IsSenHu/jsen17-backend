package com.jsen17.security.interfaces.controller;

import com.jsen17.commons.model.Result;
import com.jsen17.security.application.service.UserService;
import com.jsen17.security.common.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author HuSen
 * @since 2022/5/27 1:34 PM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public Flux<Result<List<UserDTO>>> findAll() {
        return userService.findAll();
    }
}
