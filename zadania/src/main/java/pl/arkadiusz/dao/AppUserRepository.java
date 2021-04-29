package pl.arkadiusz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arkadiusz.domain.AppUser;

import javax.transaction.Transactional;
import java.util.List;

// DOA to data access object
// tranzakcja pieniezna, jak cos nie zadziala, cofa przeprowadzone akcje
// jest to DOA :)
@Transactional
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    List<AppUser> findByLastName(String lastName);
//    AppUser findFirstById(long id);
//    AppUser findFirstById(Long Id);
    AppUser findById(long id);
    AppUser findByLogin(String login);
}
