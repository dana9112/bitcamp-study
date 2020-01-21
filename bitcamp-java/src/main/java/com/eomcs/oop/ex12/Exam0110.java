// 람다(lambda)
package com.eomcs.oop.ex12;

public class Exam0110 {

  static interface Player {
    void play();
  }

  public static void main(String[] args) {
    Player p1;

    // 로컬클래스
    class MyPlayer implements Player { // 플레이어를 활용한 구현체
      @Override
      public void play() {
        System.out.println("실행!");

      }
    }

    p1 = new MyPlayer(); // 플레이어 구현객체
    p1.play();
  }

}


