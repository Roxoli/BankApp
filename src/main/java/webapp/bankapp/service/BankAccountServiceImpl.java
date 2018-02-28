package webapp.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.bankapp.domian.BankAccount;
import webapp.bankapp.repository.BankAccountRepository;

import java.util.Random;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private BankAccountRepository bankAccountRepository;
    private String login = "";
    private Random random = new Random();

    @Autowired
    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    private String generateLogin(BankAccount bankAccount){
        login += bankAccount.getFirstName().substring(0,2)
                + bankAccount.getLastName().substring(0,2)
                + random.nextInt(10) + 1
                + random.nextInt(10) + 1
                + random.nextInt(10) + 1
                + random.nextInt(10) + 1;
        return login;
    }

    @Override
    public BankAccount createNewAccount(BankAccount bankAccount) {

        bankAccount.setLogin(generateLogin(BankAccount bankAccount));

        return bankAccountRepository.save(bankAccount);
    }
}
