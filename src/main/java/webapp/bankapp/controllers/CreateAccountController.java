package webapp.bankapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import webapp.bankapp.domian.BankAccount;
import webapp.bankapp.service.BankAccountService;

@Controller
public class CreateAccountController {

    private final BankAccountService bankAccountService;

    @Autowired
    public CreateAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @RequestMapping("/createAccount")
    public String createAccount(@ModelAttribute("bankAccount") BankAccount bankAccount){
        bankAccountService.createNewAccount(bankAccount);
        return "index";
    }
}
