package com.dana.lms;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner keyboard = new java.util.Scanner(System.in);
    
    System.out.print("장르: ");
    String genre = keyboard.nextLine();
    
    System.out.print("공연명: ");
    String name = keyboard.nextLine();
    
    System.out.print("공연시작: ");
    String start = keyboard.nextLine();
    
    System.out.print("공연종료: ");
    String end = keyboard.nextLine();
    
    System.out.print("러닝타임: ");
    String runnigtime = keyboard.nextLine();
    
    System.out.print("관람연령: ");
    String age = keyboard.nextLine();
    
    System.out.print("공연소개: ");
    String introduce = keyboard.nextLine();
    
    keyboard.close();
    
    System.out.println();

    
    System.out.printf("장르: %s\n", genre);
    System.out.printf("공연명: %s\n", name);
    System.out.printf("공연일정: %s ~ %s\n", start, end);
    System.out.printf("러닝타임: %s\n", runnigtime);
    System.out.printf("관람연령: %s\n", age);
    System.out.printf("공연소개: %s\n", introduce);
    
    
    
    
    
    
  }
}
