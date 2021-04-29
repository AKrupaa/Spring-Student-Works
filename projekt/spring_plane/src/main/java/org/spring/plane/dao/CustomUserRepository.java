package org.spring.plane.dao;

import org.spring.plane.domain.CustomUserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CustomUserRepository extends JpaRepository<CustomUserDomain, Long> {
    CustomUserDomain findByLogin(String login);
}
