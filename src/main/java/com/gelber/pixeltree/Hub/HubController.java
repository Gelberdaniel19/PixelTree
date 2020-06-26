package com.gelber.pixeltree.Hub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hub")
public class HubController {
    @GetMapping
    public String get() {
        return "hub";
    }
}
