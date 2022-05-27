package com.jsen17.security.domain.dobj.impl;

import com.jsen17.security.domain.dobj.UserDomain;
import com.jsen17.security.domain.po.UserPO;
import com.jsen17.security.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public List<UserPO> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Boolean insert(UserPO po) {
        return userRepository.save(po).getId() != null;
    }
}
