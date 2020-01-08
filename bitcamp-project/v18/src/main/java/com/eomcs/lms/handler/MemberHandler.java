package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.ArrayList;

public class MemberHandler {

  public Scanner input;
  ArrayList<Member/*클래스 이름만 와야함*/> memberList;


  public MemberHandler(Scanner input) {
    this.input = input;
    memberList = new ArrayList<>();
  }

  public void listMember() {
    // Member 객체의 목록을 저장할 배열을 넘기는데 크기가 0인 배열을 넘긴다.
    // toArray()는 내부에서 새 배열을 만들고, 값을 복사한 후 리턴한다. 
    Member[] arr = this.memberList.toArray(new Member[] {});
    // 위의 문장과 같음
    // Member[] arr = memberList.toArray(Member[].class/*class는 변수명, 확장자가 아님!! : 클래스에대한 정보를 넘겨라.(무조건 .class 넣어줘야 함) */);
    for (Member m : arr) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          m.getNo(), m.getName(), m.getEmail(), m.getTel(), m.getRegisteredDate());
    }
  }

  public void addMember() {
    Member member = new Member();

    System.out.print("번호? ");
    member.setNo(input.nextInt());
    input.nextLine(); // 줄바꿈 기호 제거용

    System.out.print("이름? ");
    member.setName(input.nextLine());

    System.out.print("이메일? ");
    member.setEmail(input.nextLine());

    System.out.print("암호? ");
    member.setPassword(input.nextLine());

    System.out.print("사진? ");
    member.setPhoto(input.nextLine());

    System.out.print("전화? ");
    member.setTel(input.nextLine());

    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(member);
    System.out.println("저장하였습니다.");
  }
}
