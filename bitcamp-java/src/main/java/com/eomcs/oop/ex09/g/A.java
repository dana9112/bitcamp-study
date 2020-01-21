package com.eomcs.oop.ex09.g;

public interface A {
  /* public abstract */ void m1();

  default void m2() {} // 규칙을 추가하되 이전에 만들어논 클래스에 영향을 끼치지 않기 위해서 default를 사용한다.

  static void m3() {
    System.out.println("오호라");
  }

}
