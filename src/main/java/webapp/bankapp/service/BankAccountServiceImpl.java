package webapp.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.bankapp.domian.BankAccount;
import webapp.bankapp.repository.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccount createNewAccount(BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }
}
