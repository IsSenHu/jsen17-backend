package com.jsen17.helper.repository;

import com.jsen17.helper.po.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author HuSen
 * @since 2022/5/27 2:54 PM
 */
public interface UserRepository extends JpaRepository<UserPO, Long> {

}
