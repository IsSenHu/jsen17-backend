package com.jsen17.jpa.core;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * @author HuSen
 * @since 2022/5/27 6:14 PM
 */
public class EntityAuditorAware implements AuditorAware<Long> {

    @NonNull
    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.of(0L);
    }
}
