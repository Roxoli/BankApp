package webapp.bankapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import webapp.bankapp.domain.BankAccount;

@Slf4j
@Controller
public class LoginPageController {

    @RequestMapping("/creator")
    public String getCreateAccountPage(@ModelAttribute("bankAccount") BankAccount bankAccount){
        return "creator";
    }
}
