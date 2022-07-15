package com.example.calculator.calculator;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



//entity

@Data
@Getter
@ToString // 객체 값 확인
@Entity(name = "history_tb")
@Builder
public class Calculator {

    @Id //PK에 해당하는 컬럼 위에 Id어노테이션 표시
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //계산을 한번할때마다 자동으로 번호를 부여하여 DB에 저장합니다.

    private Long first_num; // 첫번째 값

    private Long second_num; // 두번째 값

    private String calculation; // 부호
    private Long result; // 결과


    // JPA에서 entity는 기본 생성자를 가지고 있어야 합니다.
    public Calculator() {}

    @Builder // sql 사용 시 파라미터에 값을 쉽게 넣어주기 위한 어노테이션
    public Calculator(Long id, Long first_num, Long second_num, String calculation, Long result) {
        this.id = id;
        this.first_num = first_num;
        this.second_num = second_num;
        this.calculation = calculation;
        this.result = result;
    }

}
