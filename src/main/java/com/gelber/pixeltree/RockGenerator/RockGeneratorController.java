package com.gelber.pixeltree.RockGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RockGeneratorController {
    private RockGeneratorService rockGeneratorService;

    public RockGeneratorController(RockGeneratorService rockGeneratorService) {
        this.rockGeneratorService = rockGeneratorService;
    }

    @GetMapping("/rock/{size}/{scale}/{num}")
    public String get(@PathVariable int size, @PathVariable int scale, @PathVariable int num) {
        for (int i = 0; i < num; i++) {
            rockGeneratorService.generate(size, scale, i);
        }
        return "redirect:/";
    }
}
