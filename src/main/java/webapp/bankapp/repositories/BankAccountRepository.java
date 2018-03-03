package webapp.bankapp.repositories;

import org.springframework.data.repository.CrudRepository;
import webapp.bankapp.domian.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount,Long> {
}
