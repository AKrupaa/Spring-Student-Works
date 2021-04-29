package org.spring.plane.dao;

import org.spring.plane.domain.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
}
