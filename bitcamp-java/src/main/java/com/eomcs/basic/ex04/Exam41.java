package com.eomcs.basic.ex04;

public class Exam41 {
  public static void main(String[] args) {
    // 문자 변수 (2바이트)
    short s;
    char c;

    s = -32768;
    s = 32767;

    c = 0;
    c = 65535;

    char c1 = 65;
    char c2 = 0x41;
    char c3 = 0b0100_0001;
    char c4 = 'A'; //문자에 부여된 코드 저장 (유니코드 값을 저장 / USC 코드 값 / 2진수 //내부적으로 숫자로 저장)

    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    System.out.println(c4);
    
    int i1 = 'A'; //65 출력
    i1 = i1 + 10;
    System.out.println((char)i1);

    //A에서 Z까지 출력하는 방법
    for (int i = 65; i < 'A' + 26; i++){
      System.out.print((char)i);
    }
 
  }
}
  