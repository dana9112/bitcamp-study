package com.eomcs.reflect.ex06.b;

import java.lang.reflect.Proxy;

// 호출되는 방법을
public class Exam0110 {
  public static void main(String[] args) {

    MyInterface obj = (MyInterface) Proxy.newProxyInstance(//
        Exam0110.class.getClassLoader(), // 클래스를 메모리에 로딩하는 일을 할 객체
        new Class[] {MyInterface.class},
        // 자동 생성할 클래스가 구현해야 하는 인터페이스 목록
        // 변수 선언을 하지 않았을때는 생성자 생략 불가능 (무조건 new ~~ 만들어야함)
        new MyInvocationHandler());

    obj.m1();
    obj.m2();
  }
}

