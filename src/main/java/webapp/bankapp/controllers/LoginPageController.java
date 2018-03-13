package webapp.bankapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webapp.bankapp.domain.BankAccount;
import webapp.bankapp.service.BankAccountService;

import javax.validation.Valid;

@Slf4j
@Controller
public class LoginPageController {

    @Autowired
    private final BankAccountService bankAccountService;

    public LoginPageController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @RequestMapping("/creator")
    public String getCreateAccountPage(@ModelAttribute("bankAccount") BankAccount bankAccount) {
        return "creator";
    }

    @RequestMapping("/login")
    public String getLoginPage(@ModelAttribute("bankAccount") BankAccount bankAccount) {
        return "login";
    }

    @PostMapping
    @RequestMapping("/index")
    public String getIndexPageAfterLogin(@Valid @ModelAttribute("bankAccount") BankAccount bankAccount, BindingResult bindingResult, Model model) {
        String page;
        model.addAttribute("bankAccount", bankAccount);
        if (!bindingResult.hasErrors() && !bankAccountService.login(bankAccount)) {
            log.info("Login failed");
            page = "login";
        } else {
            log.info("Login successes.");
            page ="index";
            }
        return page;
    }

}