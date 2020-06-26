package com.gelber.pixeltree.CreateAccount;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateAccountController {

    private CreateAccountService createAccountService;

    public CreateAccountController(CreateAccountService createAccountService) {
        this.createAccountService = createAccountService;
    }

    @GetMapping("/create")
    public String getCreate(){
        return "create";
    }

    @PostMapping("/create")
    public String submitAccount(@RequestParam(required = true) String email,
                                @RequestParam(required = true) String username,
                                @RequestParam(required = true) String password){
        createAccountService.createAccount(email, username, password);
        return "redirect:/";
    }


}
