package pl.arkadiusz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.arkadiusz.domain.CarTypeDomain;

@Repository
@Transactional
public interface CarTypesRepository extends JpaRepository<CarTypeDomain, Long> {
    CarTypeDomain findByDescription(String description);

    void removeByDescription(String description);
}
