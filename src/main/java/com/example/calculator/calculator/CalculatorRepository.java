package com.example.calculator.calculator;

import com.example.calculator.calculator.entity.Calculator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorRepository extends JpaRepository<Calculator, Long> {

}
