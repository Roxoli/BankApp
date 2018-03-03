package webapp.bankapp.repositories;

import org.springframework.data.repository.CrudRepository;
import webapp.bankapp.domian.ConstantTransaction;

public interface ConstantTransactionRepository extends CrudRepository<ConstantTransaction, Long> {
}
