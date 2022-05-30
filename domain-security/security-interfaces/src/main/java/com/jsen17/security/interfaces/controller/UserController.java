package com.jsen17.security.interfaces.controller;

import com.jsen17.commons.model.Result;
import com.jsen17.security.application.service.UserService;
import com.jsen17.security.application.validator.CreateUserCommandValidator;
import com.jsen17.security.common.command.CreateUserCommand;
import com.jsen17.security.common.dto.UserDTO;
import com.jsen17.webflux.annotation.AccessLog;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

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

    @AccessLog
    @GetMapping("/findAll")
    public Result<List<UserDTO>> findAll() {
        return Result.of(userService.findAll());
    }

    @PostMapping
    public Result<Boolean> create(@RequestBody CreateUserCommand command) {
        Assert.isTrue(createUserCommandValidator.check(command), "参数异常");
        return Result.of(userService.create(command));
    }
}
