package com.jsen17.security.application.service.impl;

import com.jsen17.security.application.service.UserService;
import com.jsen17.security.domain.dobj.UserDomain;
import org.springframework.stereotype.Service;

/**
 * @author HuSen
 * @since 2022/5/27 1:35 PM
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDomain userDomain;

    public UserServiceImpl(UserDomain userDomain) {
        this.userDomain = userDomain;
    }
}
