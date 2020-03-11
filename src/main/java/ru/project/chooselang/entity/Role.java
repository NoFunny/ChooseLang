package ru.project.chooselang.entity;

import org.springframework.security.core.GrantedAuthority;


/**
 * This class represents a enum role system for a
 * role system in Spring Security
 * @author skwardlow
 * @version 1.0
 * @see GrantedAuthority

 */

public enum  Role implements GrantedAuthority {
    USER;

    /**
     *
     * @return
     */

    @Override
    public String getAuthority() {
        return name();
    }
}
