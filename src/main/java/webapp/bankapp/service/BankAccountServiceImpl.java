package webapp.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webapp.bankapp.domian.BankAccount;
import webapp.bankapp.repository.BankAccountRepository;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

    public String generateAccountNumber() {
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
    public BankAccount createNewAccount(BankAccount source) {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setLogin(generateLogin(bankAccount));
            bankAccount.setPassword(passwordEncoder.encode(bankAccount.getPassword()));
            bankAccount.setFirstName(source.getFirstName());
            bankAccount.setLastName(source.getLastName());
            bankAccount.setAccountNumber(generateAccountNumber());
            bankAccount.setAddress(source.getAddress());
            bankAccount.setEmail(source.getEmail());
            bankAccount.setTown(source.getTown());

        return bankAccountRepository.save(bankAccount);
    }

}
