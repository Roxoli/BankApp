package webapp.bankapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicErrorController {

    @RequestMapping("/error")
    public String basicErrorController(){
        return "error";
    }
}
