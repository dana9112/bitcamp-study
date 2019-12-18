package com.eomcs.basic.ex06.assignment;

public class Test04 {
//사용자로부터 나이를 입력 받아 성년/미성년 엽를 출력하라!
  public static void main(String[] args) {

    int age = Console.inputInt("나이? ");

// 만 18세 미만 : 미성년
// 만 18세 이상 : 성년
    
    
    if (age < 18 ) {
      System.out.println("미성년입니다.");
    } else 
      System.out.println("성년입니다.");

  } // main

} // class
