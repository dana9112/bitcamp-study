// 람다(lambda)
package com.eomcs.oop.ex12;

public class Exam0114 {

  static interface Player {
    void play();
  }

  public static void main(String[] args) {

    // 람다 문법
    // => 파라미터가 없다고 괄호를 생략해서는 안된다. (파라미터가 있을 경우는 생략 가능)
    Player p1 = -> System.out.println("실행!"); // 컴파일 오류

    p1.play();
  }

}


