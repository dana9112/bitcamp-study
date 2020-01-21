// 람다(lambda)
package com.eomcs.oop.ex12;

public class Exam0230 {

  static interface Player {
    void play();

    // 추상 메서드가 2개 올 수 없다. 인터페이스 1개만 가능
    void stop() {}

    static String info() {
      return "OK!";
    }
  }

  public static void main(String[] args) {
    Player p1 = () -> System.out.println("Hello"); // 컴파일 오류!
    p1.play();

  }
}

