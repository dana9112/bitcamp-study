package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberHandler {

  static final int MEMBER_SIZE = 300;
  static Member[] memories = new Member[MEMBER_SIZE];
  static int memberCount = 0;
  public static Scanner keyboard;
  
  public static void addMember() {
    Member Member = new Member();

    System.out.print("번호? " );  
    Member.no = keyboard.nextInt();

    keyboard.nextLine(); 

    System.out.print("이름? ");
    Member.name = keyboard.nextLine();

    System.out.print("이메일? ");
    Member.email = keyboard.nextLine();

    System.out.print("암호? ");
    Member.password = keyboard.nextLine();

    System.out.print("사진? ");
    Member.photo = keyboard.nextLine();

    System.out.print("전화? ");
    Member.tell = keyboard.nextLine();

    Member.registeredDate = new Date(System.currentTimeMillis());

    memories[memberCount++] = Member;
    System.out.println("저장하였습니다.");
  } // addMemeber end
  
  public static void listMember() {
    for (int i = 0; i < memberCount; i++) {
      Member m = memories[i];
      System.out.printf("%d, %s, %s, %s, %s\n",
          m.no, m.name, m.email, m.tell, m.registeredDate);
    }
  } //listMember end
  
  
  
}
