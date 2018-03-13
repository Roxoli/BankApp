package webapp.bankapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import webapp.bankapp.domain.BankAccount;
import webapp.bankapp.service.BankAccountService;

@Controller
public class IndexPageController {

    @Autowired
    private BankAccountService bankAccountService;

    public IndexPageController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

//    @RequestMapping("/history")
//    public String getHistoryPage(){
//        return "history";
//    }
//
//    @RequestMapping("/transaction")
//    public String getTransactionPage(){
//        return "transaction";
//    }
//
//    @RequestMapping("/constant_transaction")
//    public String getConstantTransactionPage(){
//        return "constant_transaction";
//    }
//
//    @RequestMapping("/index")
//    public String getIndexPage(@ModelAttribute("bankAccount") BankAccount bankAccount){
//        return "index";
//    }
}
