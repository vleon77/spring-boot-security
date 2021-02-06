package com.example.springsecurity.security;

import org.springframework.security.core.GrantedAuthority;

public enum ApplicationUserPermission {
    STUDENT_WRITE("student:write"),
    STUDENT_READ("student:read"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }


}
