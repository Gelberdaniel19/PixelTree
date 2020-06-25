package com.gelber.pixeltree.CreateAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/create")
public class CreateAccountController {

    @Autowired
    private CreateAccountService createAccountService;

}
