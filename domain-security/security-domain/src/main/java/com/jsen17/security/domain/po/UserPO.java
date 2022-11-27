package com.jsen17.security.domain.po;

import com.jsen17.commons.constants.Constants;
import com.jsen17.commons.utils.UUIDUtils;
import com.jsen17.jpa.core.BasePO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author HuSen
 * @since 2022/5/27 11:55 AM
 */
@Setter
@Getter
@ToString(callSuper = true)
@Entity
@Table(name = "t_user")
public class UserPO extends BasePO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, unique = true, nullable = false)
    private String username;

    @Column(length = 50, unique = true, nullable = false)
    private String email;

    @Column(length = 50, unique = true, nullable = false)
    private String telephone;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime accountExpiredTime;

    @Column(nullable = false)
    private LocalDateTime credentialsExpiredTime;

    @Column(nullable = false, length = 1)
    private Boolean accountNonLocked;

    @Column(nullable = false, length = 1)
    private Boolean enabled;

    @Column(nullable = false, length = 1)
    private Boolean initPasswordChanged;

    @Column
    private String avatar;

    @Override
    public void fillingDefaultFieldVal() {
        onNull(accountExpiredTime, () -> setAccountExpiredTime(Constants.SYSTEM_END_TIME));
        onNull(credentialsExpiredTime, () -> setCredentialsExpiredTime(Constants.SYSTEM_END_TIME));
        onNull(username, () -> setUsername(UUIDUtils.uid()));
        onNull(telephone, () -> setTelephone(Constants.TODO));
        onNull(email, () -> setEmail(Constants.TODO));
        onNull(password, () -> setPassword(Constants.Default.PASSWORD));
        onNull(accountNonLocked, () -> setAccountNonLocked(true));
        onNull(enabled, () -> setEnabled(true));
        onNull(initPasswordChanged, () -> setInitPasswordChanged(false));
    }
}
