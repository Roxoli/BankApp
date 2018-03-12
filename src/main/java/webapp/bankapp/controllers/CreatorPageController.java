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
public class CreatorPageController {

    @Autowired
    private final BankAccountService bankAccountService;

    public CreatorPageController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    @RequestMapping("/new_account")
    public String processAdd(@Valid @ModelAttribute("bankAccount") BankAccount bankAccount, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            log.info("An error during getting data from the form.");
            return "creator";
        }
        model.addAttribute("bankAccount", bankAccount);
        log.info("The data is correct.");
        bankAccountService.createNewAccount(bankAccount);
        return "new_account";
    }
}
