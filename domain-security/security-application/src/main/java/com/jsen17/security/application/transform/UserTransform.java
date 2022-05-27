package com.jsen17.security.application.transform;

import com.jsen17.commons.func.Transform;
import com.jsen17.commons.utils.BeanCopyUtils;
import com.jsen17.security.common.dto.UserDTO;
import com.jsen17.security.domain.po.UserPO;
import org.springframework.stereotype.Component;

/**
 * @author HuSen
 * @since 2022/5/27 3:42 PM
 */
@Component
public class UserTransform implements Transform<UserDTO, UserPO> {

    @Override
    public UserPO dto2Po(UserDTO dto) {
        return BeanCopyUtils.copy(dto, new UserPO());
    }

    @Override
    public UserDTO po2Dto(UserPO po) {
        return BeanCopyUtils.copy(po, new UserDTO());
    }
}
