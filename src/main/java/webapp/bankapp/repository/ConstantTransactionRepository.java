package webapp.bankapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webapp.bankapp.domian.ConstantTransaction;

@Repository
public interface ConstantTransactionRepository extends CrudRepository<ConstantTransaction, Long> {
}
