package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    class Memory {
      int no;
      String name;
      String email;
      String password;
      String photo;
      String tell;
      Date registeredDate;
      
    }
    
    final int Size = 300;
    Memory[] memories = new Memory[300];
  
    int count = 0; 
    for (int i = 0; i < Size; i++) {
      count++;
     
      Memory memory = new Memory();
      

      System.out.print("번호? " );  
      memory.no = keyboard.nextInt();

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
      
      memories[i] = memory;
      
      
      System.out.println("계속 입력하시겠습니까?(Y/n) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y"))
        break;
    }
    keyboard.close();
    
    System.out.println();

    for (int i = 0; i < count; i++) {
      Memory memory = memories[i];
      System.out.printf("%d, %s, %s, %s, %s\n",
          memory.no, memory.name, memory.email, memory.tell, memory.registeredDate);
    }
  } // main end
} //class end