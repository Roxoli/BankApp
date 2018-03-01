package webapp.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import webapp.bankapp.domian.BankAccount;
import webapp.bankapp.repository.BankAccountRepository;

import java.util.Random;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private BankAccountRepository bankAccountRepository;
    private PasswordEncoder passwordEncoder;
    private String login = "";
    private Random random = new Random();

    @Autowired
    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, PasswordEncoder passwordEncoder) {
        this.bankAccountRepository = bankAccountRepository;
        this.passwordEncoder = passwordEncoder;
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
            bankAccount.setLogin(generateLogin(bankAccount));
            bankAccount.setPassword(passwordEncoder.encode(bankAccount.getPassword()));
        return bankAccountRepository.save(bankAccount);
    }
}
