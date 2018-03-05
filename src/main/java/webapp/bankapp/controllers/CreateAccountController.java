package webapp.bankapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @RequestMapping("/create_account")
    public String createAccount(@ModelAttribute("bankAccount") BankAccount bankAccount){
        bankAccountService.createNewAccount(bankAccount);
        return "login";
    }

    @GetMapping("/create_account")
    public String createNewAccountForm(Model model){
        model.addAttribute("bankAccount", new BankAccount());
        return "create_account";
    }

    @PostMapping("/create_account")
    public String createAccountSubmit(@ModelAttribute BankAccount bankAccount){
        return "login";
    }
}
