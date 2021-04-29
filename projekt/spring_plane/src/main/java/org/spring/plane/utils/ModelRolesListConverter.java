package org.spring.plane.utils;

import org.spring.plane.domain.UserRole;
import org.spring.plane.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

public class ModelRolesListConverter implements Converter<String[], Set<UserRole>> {

    private final UserRoleService userRoleService;

    @Autowired
    public ModelRolesListConverter(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Override
    public Set<UserRole> convert(String[] strings) {

        Set<UserRole> carTypeDomains = new HashSet<>(0);

        for (int i = 0; i < strings.length; i++) {
            carTypeDomains.add(userRoleService.getUserRole(Integer.parseInt(strings[i])));
        }
        return carTypeDomains;
    }
}
