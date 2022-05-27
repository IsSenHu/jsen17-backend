package com.jsen17.security.domain.repository;

import com.jsen17.security.domain.po.UserPO;
import com.jsen17.security.infrastructure.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HuSen
 * @since 2022/5/27 11:57 AM
 */
@Repository
public interface UserRepository extends BaseRepository<UserPO, Long> {

}
