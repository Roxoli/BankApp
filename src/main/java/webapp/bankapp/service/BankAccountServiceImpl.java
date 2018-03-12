package webapp.bankapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import webapp.bankapp.domain.BankAccount;
import webapp.bankapp.repository.BankAccountRepository;

import javax.validation.Valid;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
public class BankAccountServiceImpl implements BankAccountService {

    private BankAccountRepository bankAccountRepository;
    private PasswordEncoder passwordEncoder;
    private String login = "";
    private Random random = new Random();
    private Boolean isLogin = false;
    private long i;

    @Autowired
    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, PasswordEncoder passwordEncoder) {
        this.bankAccountRepository = bankAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private String generateLogin(BankAccount bankAccount) {
        login += bankAccount.getFirstName().substring(0, 3).toLowerCase()
                + bankAccount.getLastName().substring(0, 3).toLowerCase()
                + random.nextInt(10) + 1
                + random.nextInt(10) + 1
                + random.nextInt(10) + 1
                + random.nextInt(10) + 1;
        return login;
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
        bankAccount.setPassword(passwordEncoder.encode(bankAccount.getPassword()));
        bankAccount.setAccountNumber(generateAccountNumber());

        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public Boolean login(BankAccount bankAccount) {
        log.info("login service");
        for (long i=0; i<bankAccountRepository.count(); i++) {
            if (bankAccountRepository.findById(i).get().getLogin() == bankAccount.getLogin() &&
                    passwordEncoder.encode(bankAccountRepository.findById(i).get().getPassword()) ==
                    passwordEncoder.encode(bankAccount.getPassword())) {
                isLogin = true;
            }
        }
        return isLogin;
    }
}
