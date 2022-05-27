package com.jsen17.security.application.validator;

import com.jsen17.commons.func.Validator;
import com.jsen17.security.common.command.CreateUserCommand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author HuSen
 * @since 2022/5/27 4:02 PM
 */
@Component
public class CreateUserCommandValidator implements Validator<CreateUserCommand> {

    @Override
    public Boolean apply(CreateUserCommand createUserCommand) {
        boolean hasUserUniqueId = !StringUtils.isBlank(createUserCommand.getUsername())
                || !StringUtils.isBlank(createUserCommand.getTelephone())
                || !StringUtils.isBlank(createUserCommand.getTelephone());

        Assert.isTrue(hasUserUniqueId, "用户名/手机号/邮箱不能全为空");
        return true;
    }
}
