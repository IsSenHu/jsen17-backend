package com.jsen17.security.interfaces.controller;

import com.jsen17.commons.model.Result;
import com.jsen17.security.application.service.UserService;
import com.jsen17.security.application.validator.CreateUserCommandValidator;
import com.jsen17.security.common.command.CreateUserCommand;
import com.jsen17.security.common.dto.UserDTO;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author HuSen
 * @since 2022/5/27 1:34 PM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final CreateUserCommandValidator createUserCommandValidator;

    public UserController(UserService userService, CreateUserCommandValidator createUserCommandValidator) {
        this.userService = userService;
        this.createUserCommandValidator = createUserCommandValidator;
    }

    @GetMapping("/findAll")
    public Mono<Result<List<UserDTO>>> findAll() {
        return Mono.just(Result.of(userService.findAll()));
    }

    @PostMapping
    public Mono<Result<Boolean>> create(@RequestBody CreateUserCommand command) {
        Assert.isTrue(createUserCommandValidator.check(command), "参数异常");
        return Mono.just(Result.of(userService.create(command)));
    }
}
