package com.jsen17.security.application.service.impl;

import com.jsen17.commons.model.Result;
import com.jsen17.security.application.service.UserService;
import com.jsen17.security.application.transform.UserTransform;
import com.jsen17.security.common.dto.UserDTO;
import com.jsen17.security.domain.dobj.UserDomain;
import com.jsen17.security.domain.po.UserPO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HuSen
 * @since 2022/5/27 1:35 PM
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserTransform userTransform;
    private final UserDomain userDomain;

    public UserServiceImpl(UserTransform userTransform, UserDomain userDomain) {
        this.userTransform = userTransform;
        this.userDomain = userDomain;
    }

    @Override
    public Flux<Result<List<UserDTO>>> findAll() {
        Flux<UserPO> findAll = userDomain.findAll();
        return findAll.buffer().map(users -> Result.of(users.stream().map(userTransform::po2Dto).collect(Collectors.toList())));
    }
}
