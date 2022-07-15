package com.example.calculator.calculator;

import lombok.Data;


@Data
public class CalculatorRequestDto {
    private Long first_num;
    private Long second_num;
    private String calculation;
}
