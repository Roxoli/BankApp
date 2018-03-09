package webapp.bankapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import webapp.bankapp.domain.BankAccount;
import webapp.bankapp.service.BankAccountService;

import javax.validation.Valid;

@Slf4j
@Controller
public class CreatorController {

    @Autowired
    private final BankAccountService bankAccountService;

    public CreatorController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String processAdd(@Valid @ModelAttribute("bankAccount") BankAccount bankAccount, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("An Error");
        }
        model.addAttribute("bankAccount", bankAccount);
        return "login";
    }


}
