package com.gelber.pixeltree.Hub;

import com.gelber.pixeltree._Model.CreditCard;
import com.gelber.pixeltree._Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Controller
@RequestMapping("/hub")
public class HubController {

    private HubService hubService;

    public HubController(HubService hubService) {
        this.hubService = hubService;
    }

    @GetMapping
    public String get() {
        return "hub";
    }

    @PostMapping("/username")
    public String changeUsername(Model model, HttpSession session,
                                 @RequestParam String username) {
        String res = hubService.changeUsername((User)session.getAttribute("user"), username);
        model.addAttribute("profileError", res);
        model.addAttribute("targetTab", "profile");
        return "hub";
    }

    @PostMapping("/email")
    public String changeEmail(Model model, HttpSession session,
                                 @RequestParam String email) {
        String res = hubService.changeEmailToken((User)session.getAttribute("user"), email);
        model.addAttribute("profileError", res);
        if (res == null) model.addAttribute("emailSuccess", true);
        model.addAttribute("targetTab", "profile");
        return "hub";
    }

    @GetMapping("/email/{token}")
    public String changeEmailConfirm(Model model, @PathVariable String token) {
        hubService.changeEmail(token);

        return "redirect:/logout";
    }

    @PostMapping("/password")
    public String changePassword(Model model, HttpSession session,
                                 @RequestParam String password) {
        String res = hubService.changePassword((User)session.getAttribute("user"), password);
        model.addAttribute("profileError", res);
        if (res == null) model.addAttribute("passwordSuccess", true);
        model.addAttribute("targetTab", "profile");
        return "hub";
    }

    @PostMapping("/buy/{amount}")
    public String buyCredits(HttpSession session,
                                         @PathVariable int amount, CreditCard card) {
        User user = (User)session.getAttribute("user");
        hubService.buyCredits(amount, card, user);
        return "redirect:/hub";
    }
}
