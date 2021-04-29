package pl.arkadiusz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.arkadiusz.domain.CarDomain;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<CarDomain, Long> {
    CarDomain findCarDomainById(Long id);

    @Query(
            value = "SELECT id FROM cardomain car WHERE car.rented = false",
            nativeQuery = true)
    List<BigInteger> findAllIdsWhereCarIsNotRented();

    @Query(value = "SELECT * FROM cardomain car WHERE car.rented = false",
            nativeQuery = true)
    List<CarDomain> findAllCarDomainsWhereCarIsNotRented();
}
