package com.gelber.pixeltree.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String getLoginPage(HttpSession session) {
        // If they're logged in, redirect them to the hub
        if (session.getAttribute("user") != null) {
            return "redirect:/hub";
        }
        return "login";
    }
}
