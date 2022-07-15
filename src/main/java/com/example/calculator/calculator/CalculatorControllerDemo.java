package com.example.calculator.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//모든 로직을 javascript로 구현

@Controller
@RequestMapping("/demo")
public class CalculatorControllerDemo {

    @GetMapping
    public String calculator2() {
        return "calculator/calculatorDemo.html";
    }
}
