package pl.arkadiusz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.arkadiusz.domain.UserAuthenticationCoreDomain;

@Repository
@Transactional
public interface UserAuthenticationCoreRepository extends JpaRepository<UserAuthenticationCoreDomain, Long> {

    UserAuthenticationCoreDomain findFirstByEmail(String email);
}
