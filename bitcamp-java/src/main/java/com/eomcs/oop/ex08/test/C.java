package com.eomcs.oop.ex08.test;

public class C {
  
  //method
  // 스태틱 멤버는 인스턴스 없이 호출한다.
  // 즉 스태틱 멤버(static context: 스태틱 환경)에서는 this 를 사용할 수 없다.
  static void m1() {  // 클래스 메서드 = 스태틱 메서드
    //Object obj = this; // this 변수가 없다.
  }
  
  static {
    //Object obj = this; // this 변수가 없다.
  }
  
  // 인스턴스 멤버는 인스턴스 주소가 있어야만 사용할 수 있다.
  // => 인스턴스 멤버를 사용할 때 넘겨준 인스턴스 주소는 내장변수 this에 저장된다. 
  int m2() {// 인스턴스 메서드 = 논스태틱 메서드
    Object obj = this; //OK!
     return 0;
    } 
  
  {
    Object obj = this; //OK!
  }
  
  C() {
    Object obj = this; //OK!
  }
  
}
