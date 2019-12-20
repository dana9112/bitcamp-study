package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  static class Lesson {
    int no;
    String title;
    String description;
    Date startDate;
    Date endDate;
    int totalHours;
    int dayHours;
  }
  static final int LESSON_SIZE = 100;
  static Lesson[] lessons = new Lesson[LESSON_SIZE];
  static int lessonCount = 0;

  static class Memory {
    int no;
    String name;
    String email;
    String password;
    String photo;
    String tell;
    Date registeredDate;
  }
  static final int MEMBER_SIZE = 300;
  static Memory[] memories = new Memory[MEMBER_SIZE];
  static int memberCount = 0;
  
  static class Board {
    int no;
    String title;
    Date date;
    int viewCount;
  } 
  static final int BOARD_SIZE = 100;
  static Board[] boards = new Board[BOARD_SIZE];
  static int boardCount = 0;

  
  public static void main(String[] args) {
    String command;
    do {
      System.out.print("\n입력? ");
      command = keyboard.nextLine();

      switch (command) {
        case "/lesson/add":
          // 분리된 코드(메서드)를 실행(호출)시킨다.
          // => 보통 "메서드를 호출한다" 라고 표현한다.
          addLesson();
          break;
        case "/lesson/list":
          listLesson();
          break;
        case "/member/add":
          addMember();
          break;
        case "/member/list":
          listMember();
          break;
        case "/board/add":
         addBoard();
          break;
        case "/board/list":
          listBoard();
          break;

        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          }
      }
    } while (!command.equalsIgnoreCase("quit"));
    System.out.println("안녕!");

    keyboard.close();
  } //main() end

  static void addLesson() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.no = keyboard.nextInt();

    keyboard.nextLine(); 
    System.out.print("수업명? ");
    lesson.title = keyboard.nextLine();

    System.out.print("설명? ");
    lesson.description = keyboard.nextLine();

    System.out.print("시작일? ");

    lesson.startDate = Date.valueOf(keyboard.next());

    System.out.print("종료일? ");
    lesson.endDate = Date.valueOf(keyboard.next());

    System.out.print("총수업시간? ");
    lesson.totalHours = keyboard.nextInt();

    System.out.print("일수업시간? ");
    lesson.dayHours = keyboard.nextInt();
    keyboard.nextLine();

    lessons[lessonCount++] = lesson;

  } //addLesson end

  static void listLesson() {
    for (int i = 0; i < lessonCount; i++) {
      Lesson l = lessons[i];
      System.out.printf("%d, %s, %s ~ %s, %d\n",
          l.no, l.title, l.startDate, l.endDate,  l.totalHours);
    } 

  } //listLesson end

  static void addMember() {
    Memory memory = new Memory();

    System.out.print("번호? " );  
    memory.no = keyboard.nextInt();

    keyboard.nextLine(); 

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
  } // addMemeber end

  static void listMember() {
    for (int i = 0; i < memberCount; i++) {
      Memory m = memories[i];
      System.out.printf("%d, %s, %s, %s, %s\n",
          m.no, m.name, m.email, m.tell, m.registeredDate);
    }
  } //listMember end
  

  static void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.no = keyboard.nextInt();
    keyboard.nextLine(); // 줄바꿈 기호 제거용

    System.out.print("내용? ");
    board.title = keyboard.nextLine();

    board.date = new Date(System.currentTimeMillis());
    board.viewCount = 0;

    boards[boardCount++] = board;
  } //addBoard end
  
  static void listBoard() {
    for (int i = 0; i < boardCount; i++) {
      Board b = boards[i];
      System.out.printf("%d, %s, %s, %d\n", 
          b.no, b.title, b.date, b.viewCount);
    }
  } //listBoard end
}// class() end