package com.jsen17.security.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author HuSen
 * @since 2022/5/27 3:12 PM
 */
@Data
public class UserDTO implements Serializable {

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
