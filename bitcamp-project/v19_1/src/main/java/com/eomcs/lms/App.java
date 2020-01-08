package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  
  public static void main(String[] args) {
    
    // BoardHandler의 메서드가 사용할 메모리만 게시판 마다 따로 생성한다.
    BoardHandler boardHandler = new BoardHandler(keyboard);
    LessonHandler lesssonHandler = new LessonHandler(keyboard);
    MemberHandler memberHandler = new MemberHandler(keyboard);
    String command;
    
    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();
      
      switch (command) {
        case "/lesson/add":
          lesssonHandler.addLesson();
          break;
        case "/lesson/list":
          lesssonHandler.listLesson();
          break;
        case "/lesson/detail":
          lesssonHandler.detailLesson();
          break;
        case "/lesson/update":
          lesssonHandler.updateLesson();
          break;
        case "/lesson/delete":
          lesssonHandler.deleteLesson();
          break;
        case "/member/add":
          memberHandler.addMember();
          break;
        case "/member/list":
          memberHandler.listMember();
          break;
        case "/member/detail":
          memberHandler.detailMember();
          break;
        case "/member/update":
          memberHandler.updateMember();
          break;
        case "/member/delete":
          memberHandler.deleteMember();
          break;
        case "/board/add":
          boardHandler.addBoard();
          break;
        case "/board/list":
          boardHandler.listBoard();
          break;
        case "/board/detail":
          boardHandler.detailBoard();
          break;
        case "/board/update":
          boardHandler.updateBoard();
          break;  
        case "/board/delete":
          boardHandler.deleteBoard();
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






