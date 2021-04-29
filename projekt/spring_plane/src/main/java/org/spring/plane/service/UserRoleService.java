package org.spring.plane.service;

import org.spring.plane.domain.UserRole;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface UserRoleService {

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void addUserRole(UserRole userRole);
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<UserRole> listUserRoles();
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    UserRole getUserRole(long id);
}
