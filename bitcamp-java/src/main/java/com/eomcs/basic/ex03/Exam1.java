package com.eomcs.basic.ex03;


public class Exam1 {
  public static void main(String[] args) {
    //정수 리터럴
    System.out.println(78); 

    System.out.println(+78);  //10진수
    System.out.println(-78);  //10진수

    System.out.println(0116); //8진수
    System.out.println(-0116); //8진수
    
    //출력할때는 무조건 10진수로 출력이된다. 

    System.out.println(0x4e); //16진수
    System.out.println(-0x4e); //16진수

    System.out.println(0b01001110); //8진수
    
    //부동소수점 리터럴
    System.out.println(3.14); //고정소수점
    System.out.println(0.314e1 /*  *10*/ );
    System.out.println(31.4e-1);

    //논리 리터럴
    System.out.println(true);
    System.out.println(false);

    //문자 리터럴
    System.out.println('A');
    System.out.println('가');

    //문자열 리터럴
    System.out.println("안녕하세요! 비트캠프!");
    






  }
}