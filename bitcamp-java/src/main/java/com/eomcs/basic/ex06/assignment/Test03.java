package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

/*

 *
 ***
 *****

 */
public class Test03 {

  public static void main(String[] args) {

    Scanner stdIn = new Scanner(System.in);
    int n;

    System.out.println("피라미드 모양으로 나타냅니다.");

    do {
      System.out.print("단수는 ：");
      n = stdIn.nextInt();
    } while (n <= 0);

    drawStarPyramid(n);         // 피라미드를 콘솔에 출력
  }

  private static void drawStarPyramid(int n) {
    for (int i = 1; i <= n; i++) {                      // i행 (i = 1, 2, … ,n)
      for (int j = 1; j <= n - i; j++) {              // n-i개의 " "를 나타냄
        System.out.print(" ");
      }           
      for (int j = 1; j <= (i - 1) * 2 + 1  ; j++) {  // (i-1)*2+1개의 '*'를 나타냄
        System.out.print("*");                      
      }
      System.out.println();                           // 개행(줄변환)
    }
  }

}
