package webapp.bankapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import webapp.bankapp.domain.BankAccount;
import webapp.bankapp.repository.BankAccountRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
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

    private String generateLogin(BankAccount bankAccount) {
        do {
            login += bankAccount.getFirstName().substring(0, 3).toLowerCase()
                    + bankAccount.getLastName().substring(0, 3).toLowerCase()
                    + ThreadLocalRandom.current().nextInt(1001, 9999);

            existAlready(login);
        } while (existAlready(login));
        return login;
    }

    private boolean existAlready(String login){
       if(bankAccountRepository.findOneByLogin(login)==null){
           return true;
        }
        return false;
    }

    private String generateAccountNumber() {
        String prefix; // first two letters from the IBAN Number
        int controlNumber; // 3 and 4 number from the IBAN
        int bankNumber; // 8 Numbers from the Bank
        long generatedNumber; // 12 Number generated for the IBAN (the 12 last numbers from the Account Number)

        prefix = "PL";
        controlNumber = ThreadLocalRandom.current().nextInt(11, 99);
        bankNumber = 10501214; //ING Bank number
        generatedNumber = ThreadLocalRandom.current().nextLong(100000000000L, 999999999999L);

        final String accountNumber = prefix + controlNumber + bankNumber + generatedNumber;

        return accountNumber;
    }

    @Override
    @Transactional
    public BankAccount createNewAccount(BankAccount bankAccount) {
        log.info("createNewAccount service.");
        bankAccount.setLogin(generateLogin(bankAccount));
        bankAccount.setPassword(BCrypt.hashpw(bankAccount.getPassword(),BCrypt.gensalt()));
        bankAccount.setAccountNumber(generateAccountNumber());

        return bankAccountRepository.save(bankAccount);
    }



    @Override
    @Transactional
    public Boolean login(BankAccount bankAccount) {
        Boolean isLogin = false;
        BankAccount user = bankAccountRepository.findOneByLogin(bankAccount.getLogin());
        log.info("login service.");
        if(user.getLogin().equals(bankAccount.getLogin()) &&
                BCrypt.checkpw(bankAccount.getPassword(), user.getPassword())) {
            return true;
        }
        return isLogin;
    }

    public BankAccount getBankAccountByLogin(String login) {
        return bankAccountRepository.findOneByLogin(login);
    }
}
