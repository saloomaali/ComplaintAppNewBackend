package com.Nest.ComplaintBackend.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ComplaintController {

    @CrossOrigin(origins = "*")
    @PostMapping("/")
    public String adminLogin(){
        return "admin";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public String userRegister(){
        return "register";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/userLogin")
    public String userLogin(){
        return "user";
    }


}
