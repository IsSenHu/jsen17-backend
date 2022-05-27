package com.jsen17.security.domain.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * @author HuSen
 * @since 2022/5/27 11:55 AM
 */
@Setter
@Getter
@ToString
@Table(name = "t_user")
public class UserPO {

    @Id
    private Long id;

    private String username;

    private String email;

    private String telephone;

    private String password;

    private LocalDateTime accountExpiredTime;

    private LocalDateTime credentialsExpiredTime;

    private Boolean accountNonLocked;

    private Boolean enabled;

    private Boolean initPasswordChanged;

    private String avatar;
}
