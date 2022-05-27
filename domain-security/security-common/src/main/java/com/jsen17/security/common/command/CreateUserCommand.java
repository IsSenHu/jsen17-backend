package com.jsen17.security.common.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author HuSen
 * @since 2022/5/27 3:54 PM
 */
@Setter
@Getter
@ToString
public class CreateUserCommand implements Serializable {

    private String username;

    private String email;

    private String telephone;

    private LocalDateTime accountExpiredTime;

    private LocalDateTime credentialsExpiredTime;

    private String avatar;
}
