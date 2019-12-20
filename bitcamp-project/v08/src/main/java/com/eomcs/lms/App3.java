package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

// 입력을 카운트하기
public class App3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    class Content {
      int no;
      String title;
      Date date;
      int viewCount;
    }
    
    final int SIZE = 100;
    Content[] contents = new Content[SIZE];
    
    String response;

    int count = 0;
    for (int i = 0; i < SIZE; i++) {
      count++;
      
      
      Content content = new Content();
      
      System.out.print("번호? ");
      content.no = keyboard.nextInt();
      keyboard.nextLine(); // 줄바꿈 기호 제거용

      System.out.print("내용? ");
      content.title = keyboard.nextLine();

      content.date = new Date(System.currentTimeMillis());
      content.viewCount = 0;
      
      contents[i] = content;
      
      
      System.out.println();

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }

    keyboard.close();

    System.out.println();

    for (int i = 0; i < count; i++) {
      Content content = contents[i];
      System.out.printf("%d, %s, %s, %d\n", 
          content.no, content.title, content.date, content.viewCount);
    }
  }
}