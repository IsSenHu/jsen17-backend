package com.jsen17.security.application.service.impl;

import com.jsen17.commons.constants.Constants;
import com.jsen17.commons.utils.BeanCopyUtils;
import com.jsen17.commons.utils.UUIDUtils;
import com.jsen17.security.application.service.UserService;
import com.jsen17.security.application.transform.UserTransform;
import com.jsen17.security.common.command.CreateUserCommand;
import com.jsen17.security.common.dto.UserDTO;
import com.jsen17.security.domain.dobj.UserDomain;
import com.jsen17.security.domain.po.UserPO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(rollbackFor = Exception.class)
    public Boolean create(CreateUserCommand command) {
        UserPO po = BeanCopyUtils.copy(command, new UserPO());
        if (command.getAccountExpiredTime() == null) {
            po.setAccountExpiredTime(Constants.SYSTEM_END_TIME);
        }
        if (command.getCredentialsExpiredTime() == null) {
            po.setCredentialsExpiredTime(Constants.SYSTEM_END_TIME);
        }
        if (StringUtils.isBlank(command.getUsername())) {
            po.setUsername(UUIDUtils.uid());
        }
        if (StringUtils.isBlank(command.getTelephone())) {
            po.setTelephone(Constants.TODO);
        }
        if (StringUtils.isBlank(command.getEmail())) {
            po.setEmail(Constants.TODO);
        }
        // 设置默认值
        po.fillingDefaultFieldVal();
        return userDomain.insert(po);
    }

    @Override
    public List<UserDTO> findAll() {
        return userDomain.findAll().stream().map(userTransform::po2Dto).collect(Collectors.toList());
    }
}
