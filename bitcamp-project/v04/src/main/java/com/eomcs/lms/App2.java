package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    
    System.out.print("번호? " );  
    int no = keyboard.nextInt();
    
    keyboard.nextLine(); //줄바꿈 기호 제거용
    
    System.out.print("이름? ");
    String name = keyboard.nextLine();
    
    System.out.print("이메일? ");
    String email = keyboard.nextLine();
    
    System.out.print("암호? ");
    String password = keyboard.nextLine();
    
    System.out.print("사진? ");
    String photo = keyboard.nextLine();
    
    System.out.print("전화? ");
    String phone = keyboard.nextLine();
    
    Date registeredDate = new Date(System.currentTimeMillis());
    
    
    System.out.println();
    
    keyboard.close();
    
    System.out.printf("번호: %d\n", no);
    System.out.printf("이름: %s\n", name);
    System.out.printf("이메일: %s\n", email);
    System.out.printf("암호: %s\n", password);
    System.out.printf("사진: %s\n", photo);
    System.out.printf("전화: %s\n", phone);
    System.out.printf("가입일: %s\n", registeredDate);
    
    
    
    
    
    
     
    
  }

}