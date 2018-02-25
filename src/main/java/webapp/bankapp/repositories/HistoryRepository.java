package webapp.bankapp.repositories;

import org.springframework.data.repository.CrudRepository;
import webapp.bankapp.domian.History;

public interface HistoryRepository extends CrudRepository<History,Long> {
}
