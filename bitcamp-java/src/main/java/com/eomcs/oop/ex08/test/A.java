package com.eomcs.oop.ex08.test;

// package member class
class A1 {
  
}

// package member class
class A2 {
  
}

// package member class
public class A {
  
  // nested class
  // => non-static nested class = inner class (중첩클래스)
  class X {}
  
  // static nested class
  static class X2 {}

  class Y {}
  
  // anonymous class (익명클래스)
  Object obj = new Object() {
    @Override
    public String toString() {
      return "익명클래스";
    }
  };
  
  void m() {
    // 메소드 안에 있는 클래스 = local class
    
    
    
  }
  
}
