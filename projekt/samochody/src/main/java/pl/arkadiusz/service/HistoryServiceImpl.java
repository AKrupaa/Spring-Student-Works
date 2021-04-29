package pl.arkadiusz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.arkadiusz.dao.HistoryRepository;
import pl.arkadiusz.domain.HistoryDomain;

import java.util.List;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<HistoryDomain> getHistories() {
        return historyRepository.findAll();
    }

    @Override
    public HistoryDomain getHistory(long id) {
        return historyRepository.findOne(id);
    }

    @Override
    public void removeHistory(long id) {
        historyRepository.delete(id);
    }

    @Override
    public void editHistory(HistoryDomain historyDomain) {
        historyRepository.save(historyDomain);
    }

    @Override
    public void addHistory(HistoryDomain historyDomain) {
        historyRepository.save(historyDomain);
    }
}
