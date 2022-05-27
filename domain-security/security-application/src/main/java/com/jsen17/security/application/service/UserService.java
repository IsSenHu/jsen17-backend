package com.jsen17.security.application.service;

import com.jsen17.commons.model.Result;
import com.jsen17.security.common.dto.UserDTO;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author HuSen
 * @since 2022/5/27 1:35 PM
 */
public interface UserService {

    Flux<Result<List<UserDTO>>> findAll();
}
