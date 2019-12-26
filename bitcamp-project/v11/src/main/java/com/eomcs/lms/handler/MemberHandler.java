package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;

public class MemberHandler {
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
  public static Scanner keyboard;
  
  public static void addMember() {
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
    System.out.println("저장하였습니다.");
  } // addMemeber end
  
  public static void listMember() {
    for (int i = 0; i < memberCount; i++) {
      Memory m = memories[i];
      System.out.printf("%d, %s, %s, %s, %s\n",
          m.no, m.name, m.email, m.tell, m.registeredDate);
    }
  } //listMember end
  
  
  
}
