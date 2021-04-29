package pl.arkadiusz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.arkadiusz.domain.UserDomain;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserDomain, Long> {
}
