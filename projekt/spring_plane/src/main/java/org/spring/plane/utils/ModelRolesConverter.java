package org.spring.plane.utils;

import org.spring.plane.domain.UserRole;
import org.spring.plane.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;


public class ModelRolesConverter implements Converter<String, UserRole> {

    private final UserRoleService userRoleService;

    @Autowired
    public ModelRolesConverter(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Override
    public UserRole convert(String s) {

//        Set<UserRole> userRoles = new HashSet<>(0);
//        userRoles.add(userRoleService.getUserRole(Long.parseLong(s.trim())));
        return userRoleService.getUserRole(Integer.parseInt(s));
    }
}
