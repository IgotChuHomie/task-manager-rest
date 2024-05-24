package com.taskifyrestapi.application.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMINISTRATOR, MEMBER, TEAMLEADER;

    @Override
    public String getAuthority(){
        return this.name();
    }
}

