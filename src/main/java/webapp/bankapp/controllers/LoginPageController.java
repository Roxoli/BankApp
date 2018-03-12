package webapp.bankapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import webapp.bankapp.domain.BankAccount;
import webapp.bankapp.service.BankAccountService;

import javax.validation.Valid;

@Slf4j
@Controller
public class LoginPageController {

    @Autowired
    BankAccountService bankAccountService;

    @RequestMapping("/creator")
    public String getCreateAccountPage(@ModelAttribute("bankAccount") BankAccount bankAccount){
        return "creator";
    }

    @GetMapping
    @RequestMapping("/index")
    public String login(@Valid @ModelAttribute("bankAccount") BankAccount bankAccount){
        if(bankAccountService.login(bankAccount)) {
            log.info("Login successes.");
            return "index";
        } else {
            log.info("Login failed");
            return "login";
        }
    }

}
