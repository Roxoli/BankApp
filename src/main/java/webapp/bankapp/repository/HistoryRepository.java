package webapp.bankapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webapp.bankapp.domian.History;

@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {
}
