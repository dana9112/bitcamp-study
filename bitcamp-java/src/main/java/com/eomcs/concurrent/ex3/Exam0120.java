// Thread를 상속 받기 - 익명 클래스로 구현하기 (실무에서 많이 볼 수 있음)
package com.eomcs.concurrent.ex3;

public class Exam0120 {

  public static void main(String[] args) {
    new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 1000; i++) {
          System.out.println("===> " + i);
        }
      }
    }.start();

    for (int i = 0; i < 1000; i++) {
      System.out.println(">>>> " + i);
    }

  }

}
