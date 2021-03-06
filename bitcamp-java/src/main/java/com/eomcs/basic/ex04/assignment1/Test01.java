package com.eomcs.basic.ex04.assignment1;

import java.util.Scanner;

/* 
 
  과제1. 입력받은 두 정수 사이의 합계를 구하라
  실행 예)
  입력? 2,5
 2에서 5까지의 합은 14이다.  
 
 */

public class Test01 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    System.out.printf("입력? ");
    int start = keyScan.nextInt();
    int end = keyScan.nextInt();
    
    int sum = 0;
    for (int no = start; no <= end; no++ ) {
      sum += no;
    }
    
    System.out.printf("%d에서 %d까지의 합은 %d입니다.\n", start, end, sum);
    
    
    keyScan.close();
    // 결과 피드백을 바탕으로 코드 수정
    // => 초기 입력 값이 문제 있음. 
    
  }

}
