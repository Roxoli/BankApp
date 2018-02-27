package webapp.bankapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webapp.bankapp.domian.BankAccount;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
}
