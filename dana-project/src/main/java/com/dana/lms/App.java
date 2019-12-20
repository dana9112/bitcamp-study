package com.dana.lms;

public class App {
  public static void main(String[] args) {
    
    // 입력 값 : x, 리턴 값: x
    m1();
    
    // 입력 값 : o, 리턴 값: x
    m2("홍길동");
  
    String s;
    s = m3();
    System.out.println(s);
    
    
    
    
  
  } // main() end
  
  static void m1() {
    System.out.println("Hello!");
  }
  
  static void m2(String name) {
    
    // 함수 안에 선언된 변수를 "로컬변수"라 부른다.
    // 로컬 변수 중에서 함수(메서드)가 호출될 때 넘어 온 값을 
    // 받는 변수를 "파라미터"라 부른다. 
    // 함수를 호출할 때 넘겨주는 값을 "아규먼트"라 부른다. 
    
    System.out.println("Hello, " + name);
  }
  
  static String m3() {
    String message = "Hello!";
    return message;
  }
  
  
} // class() end







