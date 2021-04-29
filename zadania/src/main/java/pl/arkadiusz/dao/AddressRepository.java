package pl.arkadiusz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arkadiusz.domain.UserAddress;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface AddressRepository extends JpaRepository<UserAddress, Long> {
//    UserAddress find
//    List<UserAddress>
    UserAddress findById(long id);
}
