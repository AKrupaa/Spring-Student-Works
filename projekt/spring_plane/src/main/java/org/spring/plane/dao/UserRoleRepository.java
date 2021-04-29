package org.spring.plane.dao;

import org.spring.plane.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByRole(String role);
}
