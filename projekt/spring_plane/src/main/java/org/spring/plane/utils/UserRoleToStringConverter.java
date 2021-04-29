package org.spring.plane.utils;

import org.spring.plane.domain.UserRole;
import org.spring.plane.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.Set;

public class UserRoleToStringConverter implements Converter<UserRole, String> {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleToStringConverter(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Override
    public String convert(UserRole userRole) {
        return userRole.getRole();
    }
}
