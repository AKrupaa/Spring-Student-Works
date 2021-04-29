package pl.arkadiusz.service;

import pl.arkadiusz.domain.HistoryDomain;

import java.util.List;

public interface HistoryService {
    List<HistoryDomain> getHistories();

    HistoryDomain getHistory(long id);

    void removeHistory(long id);

    void editHistory(HistoryDomain historyDomain);

    void addHistory(HistoryDomain historyDomain);
}
