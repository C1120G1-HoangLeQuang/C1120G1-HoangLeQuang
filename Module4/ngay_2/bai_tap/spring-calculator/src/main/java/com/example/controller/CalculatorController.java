package com.example.controller;

import com.example.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/")
    public String getCalculator() {
        return "index";
    }

    @PostMapping("/calculator")
    public String calculation(@RequestParam(name = "first-operand") float firstOperand,
                              @RequestParam(name = "second-operand") float secondOperand,
                              @RequestParam(name = "operator") char operator,
                              Model model) {

        model.addAttribute("first-operand", firstOperand);
        model.addAttribute("second-operand", secondOperand);
        model.addAttribute("operator", operator);
        try {
            float result = calculatorService.calculate(firstOperand, secondOperand, operator);
            model.addAttribute("result", result);
        } catch (ArithmeticException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "index";
    }
}
