package com.jsen17.security.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsen17.commons.constants.Constants;
import com.jsen17.commons.model.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author HuSen
 * @since 2022/5/27 3:12 PM
 */
@Setter
@Getter
@ToString(callSuper = true)
public class UserDTO extends BaseDTO {

    private Long id;

    private String username;

    private String email;

    private String telephone;

    private String password;

    @JsonFormat(pattern = Constants.Time.F1, timezone = Constants.Time.TIMEZONE_8)
    private LocalDateTime accountExpiredTime;

    @JsonFormat(pattern = Constants.Time.F1, timezone = Constants.Time.TIMEZONE_8)
    private LocalDateTime credentialsExpiredTime;

    private Boolean accountNonLocked;

    private Boolean enabled;

    private Boolean initPasswordChanged;

    private String avatar;
}
