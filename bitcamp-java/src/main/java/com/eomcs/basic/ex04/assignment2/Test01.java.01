package com.eomcs.basic.ex04.assignment2;

import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    System.out.print("값1? ");
    int value1 = keyboard.nextInt();

    System.out.print("값2? ");
    int value2 = keyboard.nextInt();
    
    keyboard.nextLine();

    System.out.print("연산자(+,-,*,./)? ");
    String operator = keyboard.nextLine();

    keyboard.close();

    if (operator.equals ("+")) {
      System.out.printf(value1 + "+" + value2 + "=" + (value1 + value2));
    } else if(operator.equals ("-")) {
      System.out.printf(value1 + "-" + value2 + "=" + (value1 - value2));
    } else if(operator.equals ("*")) {
      System.out.printf(value1 + "*" + value2 + "=" + (value1 * value2));
    } else if(operator.equals ("/")) {
      System.out.printf(value1 + "/" + value2 + "=" + (value1 / value2));
    } else {
      System.out.println("잘못 입력하셨습니다. +, -, *, / 중 하나를 입력하세요.");
    }
    


  }//main

}// class
