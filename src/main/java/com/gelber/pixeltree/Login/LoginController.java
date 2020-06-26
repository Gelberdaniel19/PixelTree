package com.gelber.pixeltree.Login;

import com.gelber.pixeltree._Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
