package ExchangeMoney.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeMoneyController {

    @GetMapping("/")
    public String input() {
        return "login";
    }

    @PostMapping("/login")
    public String exchangeMoney(@RequestParam double usd, @RequestParam double vnd, Model model) {
        double usdToVnd = 23000 * vnd;
        double vndToUsd = usd / 23000;
        model.addAttribute("usd1", usdToVnd);
        model.addAttribute("vnd1", vndToUsd);
        return "result";
    }
}
