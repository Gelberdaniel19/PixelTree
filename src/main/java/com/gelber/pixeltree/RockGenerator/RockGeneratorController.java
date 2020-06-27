package com.gelber.pixeltree.RockGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RockGeneratorController {
    private RockGeneratorService rockGeneratorService;

    public RockGeneratorController(RockGeneratorService rockGeneratorService) {
        this.rockGeneratorService = rockGeneratorService;
    }

    @GetMapping("/rock")
    public String get() {
        rockGeneratorService.generate();
        return "redirect:/";
    }
}
