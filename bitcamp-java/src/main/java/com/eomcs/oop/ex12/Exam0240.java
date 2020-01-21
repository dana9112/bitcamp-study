// 람다(lambda)
package com.eomcs.oop.ex12;

public class Exam0240 {

  // 추상메서드 1개자리 인터페이스
  static abstract class Player {
    public abstract void play();
  }

  public static void main(String[] args) {
    Player p1 = () -> System.out.println("Hello"); // 컴파일 오류
    p1.play();

  }
}

