package com.eomcs.basic.ex04;

public class Exam23 {
  public static void main(String[] args) {
    // 크기가 다른 변수끼리 값 저장하기
    byte b = 100; 
    short s = 100;
    int i = 100;
    long l = 100;
    
    byte b2;
    short s2;
    int i2;
    long l2;

    // 큰 메모리의 값을 작은 메모리에 저장하려 할 때
    // - 컴파일 오류가 발생한다.
    // long ==> *
    //b2 = l; 오류
    //s2 = l; 오류
    //i2 = l; 오류
    //l2 = l; 실행

    // int ==>*
    //b2 = i; 오류
    //s2 = i; 오류
    //i2 = i; 실행
    //l2 = i; 실행

    // short ==> *
    //b2 = s; 오류
    //s2 = s; 실행
    //i2 = s; 실행
    //l2 = s; 실행

    // byte ==> *
    //b2 = b; 실행
    //s2 = b; 실행
    //i2 = b; 실행
    //l2 = b; 실행


  }
}
  