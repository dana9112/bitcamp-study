package com.eomcs.oop.ex05.test;

public class A {
  int v1;
  
  A() {
    this(100); //생성자에서 다른 생성자의 값을 호출하는 this이다. 
    System.out.println("A()");
  }
  
  A(int v1) {
    this.v1 = v1;
    System.out.println("A(int)");
  }
  
  
}
