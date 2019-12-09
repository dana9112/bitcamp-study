package com.eomcs.basic.ex03;

//부동 소수점 리터럴 - 메모리 크기

public class Exam32 {
  public static void main(String[] args) {

    //부동소수점 : 4바이트, 8바이트(기본)
    System.out.println(3.141592653589793); //8바이트 부동소수점  
    System.out.println(3.141592653589793D); //8바이트 부동소수점
    System.out.println(3.141592653589793d); //8바이트 부동소수점

    //4바이트 부동소수점
    // 컴파일 오류가 발생하지 x -> 그냥 값이 짤려서 들어감
    System.out.println(3.141592653589793F);
    System.out.println(3.141592653589793f); 

  }
}