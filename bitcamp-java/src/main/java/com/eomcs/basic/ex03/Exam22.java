package com.eomcs.basic.ex03;


public class Exam22 {
  public static void main(String[] args) {
    //10진수 리터럴
    System.out.println(235_000_000);
    System.out.println(2_3500_0000);
    System.out.println(2_35_000_000);

    //System.out.println(_235_000_000); 불가
    //System.out.println(235_000_000_); 불가

    //8진수 리터럴
    System.out.println(01_44);
    System.out.println(0_144);
    //System.out.println(0144_); 불가

    //2진수 리터럴
    System.out.println(0b0110_0100);
    //System.out.println(0b_0110_0100); 불가
    //System.out.println(0b0110_0100_); 불가

    //16진수 리터럴
    System.out.println(0x00_64);
    //System.out.println(0x_0064); 불가
    //System.out.println(0x0064_); 불가
    //System.out.println(_0x0064); 불가
    



  }
}