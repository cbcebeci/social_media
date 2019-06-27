package socialMediaProject.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {


    @GetMapping(path = "/login")
    public String welcome(){
        return "login";
    }
}
