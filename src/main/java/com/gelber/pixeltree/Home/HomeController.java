package com.gelber.pixeltree.Home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomepage(Model model, HttpSession session) {
        return "index";
    }

}
