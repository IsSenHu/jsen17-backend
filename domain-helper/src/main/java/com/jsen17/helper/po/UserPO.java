package com.jsen17.helper.po;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author HuSen
 * @since 2022/5/27 2:48 PM
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "t_user")
public class UserPO {

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
}
