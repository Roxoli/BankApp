package webapp.bankapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import webapp.bankapp.domain.BankAccount;
import webapp.bankapp.service.BankAccountService;

import javax.validation.Valid;

@Controller
public class IndexPageController {

    @Autowired
    private final BankAccountService bankAccountService;

    public IndexPageController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @RequestMapping("/history")
    public String getHistoryPage(@ModelAttribute("bankAccount") BankAccount bankAccount){
        return "history";
    }

    @RequestMapping("/transaction")
    public String getTransactionPage(@ModelAttribute("bankAccount") BankAccount bankAccount){
        return "transaction";
    }

    @RequestMapping("/constant_transaction")
    public String getConstantTransactionPage(@ModelAttribute("bankAccount") BankAccount bankAccount){
        return "constant_transaction";
    }

    @RequestMapping("/index")
    public String getIndexPage(@ModelAttribute("bankAccount") BankAccount bankAccount){
        return "index";
    }
}
