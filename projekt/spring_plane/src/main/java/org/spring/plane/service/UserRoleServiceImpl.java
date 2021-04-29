package org.spring.plane.service;

import org.spring.plane.dao.UserRoleRepository;
import org.spring.plane.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService{

    UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void addUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    @Override
    public List<UserRole> listUserRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole getUserRole(long id) {
        return userRoleRepository.getOne(id);
    }
}
