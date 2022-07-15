package com.example.calculator.calculator.controller;

import com.example.calculator.calculator.entity.Calculator;
import com.example.calculator.calculator.CalculatorRepository;
import com.example.calculator.calculator.CalculatorService;
import com.example.calculator.calculator.dto.CalculatorRequestDto;
import com.example.calculator.calculator.dto.CalculatorResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class CalculatorController {


    //이거 내용 확인
    private final CalculatorRepository calculatorRepository;
    private final CalculatorService calculatorService;


    @PostMapping("/calculator")
    //요청 데이터를 dto에 담는다.
    public Calculator put(@RequestBody CalculatorRequestDto calculatorRequestDto) {


        //CalculatorResponseDto를 new키워드로 새로 객체화 한다. 응답값인 결과값을 담는다.
        CalculatorResponseDto calculatorResponseDto = new CalculatorResponseDto();

        //계산
        //리팩토링 포인트 : 서비스 로직을 controller에서 분리시켜야함
        Long result = calculatorService.calculateOperation(calculatorRequestDto.getFirst_num(), calculatorRequestDto.getSecond_num(), calculatorRequestDto.getCalculation());


        //result 결과값을 응답 DTO에 담는다.
        calculatorResponseDto.setResult(result);

        Calculator builderCalculator = Calculator.builder()
                .first_num(calculatorRequestDto.getFirst_num())
                .calculation(calculatorRequestDto.getCalculation())
                .second_num(calculatorRequestDto.getSecond_num())
                .result(calculatorResponseDto.getResult())
                .build();

        //save로 저장한다.
        return calculatorRepository.save(builderCalculator);
    }

    @GetMapping("/calculator/all")
    public String historyAll(){
        String result = "";
        for (Calculator calculator : calculatorRepository.findAll()) {
            result += "[" + calculator.getId() + "] " + calculator.getFirst_num() + " "
                    + calculator.getCalculation() + " " + calculator.getSecond_num() + " "
                    + "= " + calculator.getResult() + " , ";
        }

        return result;
    }
}

