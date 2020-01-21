// 람다(lambda)
package com.eomcs.oop.ex12;

public class Exam0113 {

  static interface Player {
    void play();
  }

  public static void main(String[] args) {

    // 람다 문법
    Player p1 = () -> System.out.println("실행!");

    p1.play();
  }

}


