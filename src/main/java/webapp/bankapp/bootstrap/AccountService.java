package webapp.bankapp.bootstrap;

import java.util.concurrent.ThreadLocalRandom;

public class AccountService {

    public String generateAccountNumber(){
        String prefix; // first two letters from the IBAN Number
        int kontrolNumber; // 3 and 4 number from the IBAN
        int bankNumber; // 8 Numbers from the Bank
        long generatedNumber; // 12 Number generated for the IBAN (the 12 last numbers from the Account Number)

        prefix = "PL";
        kontrolNumber = ThreadLocalRandom.current().nextInt(11, 99);
        bankNumber = 10501214; //ING Bank number
        generatedNumber =  ThreadLocalRandom.current().nextLong(100000000000L,999999999999L);


        return prefix + kontrolNumber + bankNumber + generatedNumber;

    }
}
