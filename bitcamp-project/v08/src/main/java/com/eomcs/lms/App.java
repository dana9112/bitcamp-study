package com.eomcs.lms;


import java.sql.Date;
import java.util.Scanner;
public class App {
  public static void main(String[] args) {
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

    final int LESSON_SIZE = 100;
    Table[] tables = new Table[LESSON_SIZE];
    int lessonCount = 0;

    class Memory {
      int no1;
      String name;
      String email;
      String password;
      String photo;
      String tell;
      Date registeredDate;

    }

    final int MEMBER_SIZE = 100;
    Memory[] memories = new Memory[MEMBER_SIZE];
    int memberCount = 0;

    class Content {
      int no;
      String title;
      Date date;
      int viewCount;
    }

    final int CONTENT_SIZE = 100;
    Content[] contents = new Content[CONTENT_SIZE];
    int contentCount = 0;



    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "/lesson/add":

          Table table = new Table();

          System.out.print("번호? ");
          table.no= keyboard.nextInt();
          keyboard.nextLine();

          System.out.print("수업명? ");
          table.title = keyboard.nextLine();

          System.out.print("설명? ");
          table.description = keyboard.nextLine();

          System.out.print("시작일? ");
          table.startDate = Date.valueOf(keyboard.next());

          System.out.print("종료일? ");
          table.endDate = Date.valueOf(keyboard.next());

          System.out.print("총수업시간? ");
          table.totalHours = keyboard.nextInt();

          System.out.print("일수업시간? ");
          table.dayHours = keyboard.nextInt();
          keyboard.nextLine();

          tables[lessonCount++] = table;
          System.out.println("저장하였습니다.");

          break;

        case "/member/add":

          Memory memory = new Memory();

          System.out.print("번호? " );  
          memory.no1 = keyboard.nextInt();

          keyboard.nextLine(); //줄바꿈 기호 제거용

          System.out.print("이름? ");
          memory.name = keyboard.nextLine();

          System.out.print("이메일? ");
          memory.email = keyboard.nextLine();

          System.out.print("암호? ");
          memory.password = keyboard.nextLine();

          System.out.print("사진? ");
          memory.photo = keyboard.nextLine();

          System.out.print("전화? ");
          memory.tell = keyboard.nextLine();

          memory.registeredDate = new Date(System.currentTimeMillis());

          memories[memberCount++] = memory;
          System.out.println("저장하였습니다.");

          break;

        case "/board/add":

          Content content = new Content();

          System.out.print("번호? ");
          content.no = keyboard.nextInt();
          keyboard.nextLine(); 

          System.out.print("내용? ");
          content.title = keyboard.nextLine();

          content.date = new Date(System.currentTimeMillis());
          content.viewCount = 0;

          contents[contentCount++] = content;

          break;


        case "/lesson/list":

          for (int i = 0; i < lessonCount; i++) {
            Table l = tables[i];

            System.out.printf("%d, %s, %s ~ %s, %s\n",
                l.no, l.title, l.startDate, l.endDate, l.totalHours);
          }

          break;

        case "/member/list":

          for(int i = 0; i < memberCount; i++) {
            Memory m = memories[i];
            System.out.printf("%d, %s, %s, %s, %s\n",
                m.no1, m.name, m.email, m.tell, m.registeredDate);
          }
          break;

        case "/board/list":

          for (int i = 0; i < contentCount; i++) {
            Content c = contents[i];
            System.out.printf("%d, %s, %s, %d\n", 
                c.no, c.title, c.date, c.viewCount);
          }
          break;

        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          }

      }

    } while (!command.equalsIgnoreCase("quit"));

    System.out.println("안녕!");

    keyboard.close();
  }
}
