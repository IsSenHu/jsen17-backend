package com.jsen17.security.application.service;

import com.jsen17.security.common.command.CreateUserCommand;
import com.jsen17.security.common.dto.UserDTO;

import java.util.List;

/**
 * @author HuSen
 * @since 2022/5/27 1:35 PM
 */
public interface UserService {

    List<UserDTO> findAll();

    Boolean create (CreateUserCommand command);
}
