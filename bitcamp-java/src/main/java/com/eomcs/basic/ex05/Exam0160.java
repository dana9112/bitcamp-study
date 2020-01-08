package com.eomcs.basic.ex05;

//# 산술 연산자 : 암시적 형변환과 연산 우선순위
public class Exam0160 {
  public static void main(String[] args) {
    float r1 = 5 / 2 + 3.1f;
    // 계산 순서:
    // r1 = int(5) / int(2) + float(3.1);
    // r1 = int(2) + float(3.1);
    // r1 = float(2.0) + float(3.1);
    // r1 = float(5.1);
    // => 연산 우선 순위에 따라 계산하는 순간에 암시적 형변환이 이루어진다. 
    // => 모든 값을 최종 결과 타입으로 바꾸고 계산하지 않는다. 
    System.out.println(r1);
    
    float r2 = 3.1f + 5 / 2;
    // 계산 순서:
    // r1 = float(3.1) + int(5) / int(2);
    // r1 = float(3.1) + int(2);
    // r1 = float(3.1) + float(2.0);
    // r1 = float(5.1);
    System.out.println(r2);

  }
}

// 정리!
// - 연산은 항상 같은 타입끼리만 가능하다.
// - 다른 타입끼리 연산을 할 때는 둘 중 한개의 타입을 다른 타입을 
//   바꿔야 한다.
// - 타입을 바꾸는 것을 내부적인 규칙에 따라 자동으로 처리한다고 해서
//   "암시적 형변환(implicit type conversion)"이라 부른다.
// - 암시적 형변환 규칙
//   다음과 같이 오른쪽 타입의 값으로 자동 변환시킨다.
//   byte,short,char => int => long => float => double
//
// - 정수와 부동소수점에 대해서만 암시적 형변환이 일어난다.
//   그 외 다른 타입은 불가능하다!