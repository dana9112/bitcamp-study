// 람다(lambda)
package com.eomcs.oop.ex12;

public class Exam0331 {

  static interface Calculator {
    int compute(int start, int end);
  }

  static void test(Calculator c) {
    System.out.printf("결과: %d\n", c.compute(1, 10));
  }

  public static void main(String[] args) {

    test(new Calculator() {
      @Override
      public int compute(int a, int b) {
        return a + b;
      }
    });


  }

}// class() end
