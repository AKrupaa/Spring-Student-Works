package pl.arkadiusz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arkadiusz.domain.HistoryDomain;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface HistoryRepository extends JpaRepository<HistoryDomain, Long> {
    HistoryDomain findHistoryDomainById(long id);
}
