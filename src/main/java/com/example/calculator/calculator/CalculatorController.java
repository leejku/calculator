package com.example.calculator.calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class CalculatorController {


    //이거 내용 확인
    private final CalculatorRepository calculatorRepository;
    private final CalculatorService calculatorService;

//    @Autowired
//    public CalculatorController(CalculatorRepository calculatorRepository, CalculatorService calculatorService) {
//        this.calculatorRepository = calculatorRepository;
//        this.calculatorService = calculatorService;
//    }

    @PostMapping("/calculator")
    //요청 데이터를 dto에 담는다.
    public Calculator put(@RequestBody CalculatorRequestDto calculatorRequestDto) {

        //dto에 담겨진 데이터들을 꺼내서 각 변수에 넣는다.
        Long first_num = calculatorRequestDto.getFirst_num();
        Long second_num = calculatorRequestDto.getSecond_num();
        String calculation = calculatorRequestDto.getCalculation();


        //CalculatorResponseDto를 new키워드로 새로 객체화 한다. 응답값인 결과값을 담는다.
        CalculatorResponseDto calculatorResponseDto = new CalculatorResponseDto();

        //계산
        //리팩토링 포인트 : 서비스 로직을 controller에서 분리시켜야함
        Long result = calculatorService.calculateOperation(first_num, second_num, calculation);

        //result 결과값을 응답 DTO에 담는다.
        calculatorResponseDto.setResult(result);


        //DB 저장을 위해서 entity에 값들을 다 넣는다.
//        Calculator calculator =new Calculator();
//        calculator.setFirst_num(first_num);
//        calculator.setSecond_num(second_num);
//        calculator.setCalculation(calculation);
//        calculator.setResult(result);

        Calculator builderCalculator = Calculator.builder()
                .first_num(first_num)
                .calculation(calculation)
                .second_num(second_num)
                .result(result)
                .build();


        //save로 저장한다.
        return calculatorRepository.save(builderCalculator);
    }


    @GetMapping("/calculator/all")
    public String list(){

        String result = "";
        for (Calculator calculator : calculatorRepository.findAll()) {
            result += "[" + calculator.getId() + "] " + calculator.getFirst_num() + " "
                    + calculator.getCalculation() + " " + calculator.getSecond_num() + " "
                    + "= " + calculator.getResult() + " , ";
        }

        // 리팩토링 포인트? : 리스트로 넣어서 뽑기
//        List<Calculator> calculator2 = calculatorRepository.findAll();
//        System.out.println("calculator2 = " + calculator2);
        return result;
    }
}

