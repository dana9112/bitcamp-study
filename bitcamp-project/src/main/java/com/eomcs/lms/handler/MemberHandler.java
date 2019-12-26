package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberHandler {

  // 인스턴스 필드 = 논-스태틱 필드
  // => 개별적으로 관리해야 하는 변수
  // => new 명령을 통해 생성된다.
  Member[] memories = new Member[MEMBER_SIZE];
  int memberCount = 0;
  
  // 클래스 필드 = 스태틱 필드
  // => 공유하는 변수
  // => 클래스가 메모리에 로딩될 때 자동으로 생성된다.
  //
  static final int MEMBER_SIZE = 300;
  public static Scanner keyboard;
  
  public static void addMember(MemberHandler memberHandler) {
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

    memberHandler.memories[memberHandler.memberCount++] = Member;
    System.out.println("저장하였습니다.");
  } // addMemeber end
  
  public static void listMember(MemberHandler memberHandler) {
    for (int i = 0; i < memberHandler.memberCount; i++) {
      Member m = memberHandler.memories[i];
      System.out.printf("%d, %s, %s, %s, %s\n",
          m.no, m.name, m.email, m.tell, m.registeredDate);
    }
  } //listMember end
  
  
  
}
