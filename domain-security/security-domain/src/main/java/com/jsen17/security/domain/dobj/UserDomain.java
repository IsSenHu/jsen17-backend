package com.jsen17.security.domain.dobj;

import com.jsen17.security.domain.po.UserPO;
import reactor.core.publisher.Flux;

/**
 * @author HuSen
 * @since 2022/5/27 11:59 AM
 */
public interface UserDomain {

    Flux<UserPO> findAll();
}
