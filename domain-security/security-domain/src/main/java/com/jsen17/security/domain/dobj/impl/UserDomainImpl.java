package com.jsen17.security.domain.dobj.impl;

import com.jsen17.security.domain.dobj.UserDomain;
import com.jsen17.security.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

/**
 * 用户领域
 *
 * @author HuSen
 * @since 2022/5/27 11:59 AM
 */
@Component
public class UserDomainImpl implements UserDomain {

    private final UserRepository userRepository;

    public UserDomainImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
