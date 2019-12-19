package com.eomcs.lms;


import java.sql.Date;
import java.util.Scanner;
public class App {
  public static void main(String[] args) {
    //키보드에서 사용자가 입력한 값을 읽어 문자열이나 정수, 부동소수점 등으로 리턴하는 역할
    Scanner keyboard = new java.util.Scanner(System.in);
    
    class Table {
      int no;
      String title;
      String description;
      Date startDate;
      Date endDate;
      int totalHours;
      int dayHours;
    }
    
    final int SIZE = 100;
    Table[] tables = new Table[SIZE];
    
    int count = 0;
    for (int i = 0; i < SIZE; i++) {
      
      Table table = new Table();
      
      count++;
      
      System.out.print("번호? ");
      table.no= keyboard.nextInt();

      keyboard.nextLine(); //nextInt() 후에 남아있는 줄바꿈 기호를 제거한다.

      System.out.print("수업명? ");
      table.title = keyboard.nextLine();

      System.out.print("설명? ");
      table.description = keyboard.nextLine();

      System.out.print("시작일? ");
      // "yyyy-MM-dd" 형태로 입력된 문자열을 날짜 정보로 바꾼다. 
      table.startDate = Date.valueOf(keyboard.next());

      System.out.print("종료일? ");
      table.endDate = Date.valueOf(keyboard.next());

      System.out.print("총수업시간? ");
      table.totalHours = keyboard.nextInt();
            
      System.out.print("일수업시간? ");
      table.dayHours = keyboard.nextInt();
      keyboard.nextLine(); // 일 수업시간 입력 값 다음에 남아 있는 줄바꿈 값 제거
      
      tables[i] = table;
      
      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y"))
        break;
      
    }
    System.out.println();
    
    
    for (int i = 0; i < count; i++) {
      Table table = tables[i];
      
      System.out.printf("%d, %s, %s ~ %s, %s\n",
           table.no, table.title, table.startDate, table.endDate, table.totalHours);
    }
    
    keyboard.close(); //자원을 안 돌려주는데 프로그램을 종료하면 돌려줌

  }
}
