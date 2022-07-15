package com.example.calculator.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Long calculateOperation(Long first_num, Long second_num, String calculation) {
        Long result;
        if (calculation.equals("+")) {
            result = first_num + second_num;
            System.out.println("result = " + result);
        } else if (calculation.equals("-")) {
            result = first_num - second_num;
            System.out.println("result = " + result);
        } else if (calculation.equals("*")) {
            result = first_num * second_num;
            System.out.println("result = " + result);
        } else if (calculation.equals("/")) {
            result = first_num / second_num;
            System.out.println("result = " + result);
        } else {
            throw new IllegalStateException("사칙 연산만 가능합니다. +,-,*,/");
        }
        return result;
    }
}
