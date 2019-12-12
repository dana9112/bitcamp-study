package com.eomcs.basic.ex04;

public class Exam16 {
  public static void main(String[] args) {
    // 변수 종류
    // => primitive data type (자바 원시 데이터 타입)
    // 정수값을 담을 수 있는 메모리
    byte b; // 1바이트 크기를 갖는 메모리
    short s; // 2
    int i; // 4
    long l; // 8

    // 부동소수점을 담을 수 있는 메모리
    float f; // 4
    double d; // 8

    // 논리값 저장 (true, false)
    boolean bool; //jvm에서 int로 취급
    
    char c; // 2

    // => reference : 다른 메모리의 주소를 저장하는 변수
    String str;
    Thread t;
    java.sql.Date date;
    java.net.Socket socket; //네트워크 소켓에 저장되어 있는 
    int [] arr; // => reference로 취급

  }
}
