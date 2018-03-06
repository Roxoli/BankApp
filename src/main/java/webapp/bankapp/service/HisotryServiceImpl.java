package webapp.bankapp.service;

import org.springframework.stereotype.Service;
import webapp.bankapp.domain.History;
import webapp.bankapp.repository.HistoryRepository;

@Service
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
