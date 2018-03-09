package webapp.bankapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginPageController {

    @RequestMapping("/creator")
    public String getCreateAccountPage(){
        return "creator";
    }
}
