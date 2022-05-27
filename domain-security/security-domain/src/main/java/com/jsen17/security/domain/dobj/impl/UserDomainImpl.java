package com.jsen17.security.domain.dobj.impl;

import com.jsen17.commons.constants.Constants;
import com.jsen17.security.domain.dobj.UserDomain;
import com.jsen17.security.domain.po.UserPO;
import com.jsen17.security.domain.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

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
        po.fillingDefaultFieldVal();
        Assert.isTrue(!userRepository.existsByUsername(po.getUsername()), "用户名重复");
        Assert.isTrue(!StringUtils.equals(po.getTelephone(), Constants.TODO)
                && !userRepository.existsByTelephone(po.getTelephone()), "手机号重复");
        Assert.isTrue(!StringUtils.equals(po.getEmail(), Constants.TODO)
                && !userRepository.existsByEmail(po.getEmail()), "邮箱重复");
        return userRepository.save(po).getId() != null;
    }
}
