package com.eomcs.basic.ex04.assignment2;

import java.util.Scanner;

public class Test02 {
  public static void main(String[] args) {

    


// 과제 1 : 가위,바위,보 게임 애플리케이션을 작성하라.
// - 실행1
// 가위,바위,보? 보
// 컴퓨터: 가위  (랜덤 값이 출력된다. 힌트: Math.random())
// => 졌습니다.
//

    Scanner keyboard = new Scanner(System.in);
      int comNum = (int)(Math.random()*3)+1;
      
      System.out.println("1:가위, 2: 바위, 3:보 입력하세요 ");
      int myNum = keyboard.nextInt();


      System.out.print("가위, 바위, 보? ");
      if (myNum == 1) {
        System.out.println("가위");
      } else if (myNum == 2){
        System.out.println("바위");
      } else if (myNum == 3){
        System.out.println("보");
      } 

      System.out.print("컴퓨터: ");
      if (comNum == 1) {
        System.out.println("가위");
      } else if (comNum == 2){
        System.out.println("바위");
      } else if (comNum == 3){
        System.out.println("보");
      } 


      if (comNum == myNum) {
        System.out.println("비겼습니다.");
      } else if ((comNum == 1 && myNum == 2)||(comNum == 2 && myNum == 3)||(comNum == 3 && myNum == 1)) {
        System.out.println("이겼습니다.");
      } else {
        System.out.println("졌습니다.");
      }

    keyboard.close();

// - 실행2
// 가위,바위,보? 바위
// 컴퓨터: 가위
// => 이겼습니다.
//

  

  }//main

}// class
