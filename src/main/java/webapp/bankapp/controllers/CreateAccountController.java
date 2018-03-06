package webapp.bankapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webapp.bankapp.domain.BankAccount;
import webapp.bankapp.service.BankAccountService;

@Slf4j
@Controller
public class CreateAccountController {

    private final BankAccountService bankAccountService;

    public CreateAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    @RequestMapping("/create_account_new")
    public String createNewAccountForm(Model model){
        model.addAttribute("bankAccount", new BankAccount());
        return "create_account_new";
    }

    @PostMapping("/create_account_new")
    public String createAccountSubmit(@ModelAttribute BankAccount bankAccount){
        return "login";
    }
}
