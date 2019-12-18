package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

/*
과제1

 *
 **
 ***
 ****
 *****

반복문을 사용할 때는 while 또는 do ~ while 문만을 사용하라!

 */
public class Test01 {
  public static void main(String[] args) {
    
    int width = inputInt();
    int line = 0;
    while (line++ < width) {
      drawLine(line);
      System.out.println();
    }
  }
  
  static int inputInt() {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변 길이? ");
    int width = keyScan.nextInt();
    keyScan.close();
    return width;
  }
  
  static void drawLine(int length) {
    int x = 1;
    while (x++ <= length){ 
      System.out.print("*");

    }

  } //main
} //class
