package webapp.bankapp.service;

import webapp.bankapp.domain.BankAccount;

public interface BankAccountService {
    BankAccount createNewAccount(BankAccount bankAccount);

    Boolean login(BankAccount bankAccount);

    BankAccount getBankAccountByLogin(String login);
}
