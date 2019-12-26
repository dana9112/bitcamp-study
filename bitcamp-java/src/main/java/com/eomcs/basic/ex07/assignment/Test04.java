package com.eomcs.basic.ex07.assignment;

import java.util.Scanner;

public class Test04 {

  public static void main(String[] args) {
    // 사용자로부터 정수 값을 입력 받는다. 
    Scanner keyboard = new Scanner(System.in);

    System.out.print("입력> ");
    int n = keyboard.nextInt();


    int result = factorial(n);


    System.out.printf("%d! = ", n);
    for (int i = 1; i < n; i++) {

      System.out.printf("%d * ", i);
    }
    System.out.printf("%d = ", n);
    System.out.println(result);


    keyboard.close();

  } // main() end 

  static int factorial(int n) {
    // 코드를 완성하시오!
    // 식 : f(n) = n * f(n-1)
    //
    if (n == 1)
      return 1;

    return n * factorial(n-1);
  }

} // class() end
