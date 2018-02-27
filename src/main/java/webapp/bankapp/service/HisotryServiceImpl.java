package webapp.bankapp.service;

import webapp.bankapp.domian.History;
import webapp.bankapp.repository.HistoryRepository;

public class HisotryServiceImpl implements HistoryService {

   private HistoryRepository historyRepository;

    public HisotryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public History addHistory(History history) {
        return historyRepository.save(history);
    }
}
