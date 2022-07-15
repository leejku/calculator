package com.example.calculator.calculator;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



//entity

@Getter
@Entity(name = "history_tb")
@Builder
@NoArgsConstructor
// 파라미터가 없는 기본 생성자
@AllArgsConstructor
// 모든 필드 값을 파라미터로 받는 생성자
public class Calculator {

    @Id //PK에 해당하는 컬럼 위에 Id어노테이션 표시
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //계산을 한번할때마다 자동으로 번호를 부여하여 DB에 저장합니다.

    private Long first_num; // 첫번째 값

    private Long second_num; // 두번째 값

    private String calculation; // 부호
    private Long result; // 결과


}
