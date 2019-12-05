package com.ohoracs.basic.ex03;

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

    System.out.println(0b01001110); //16진수
  }
}