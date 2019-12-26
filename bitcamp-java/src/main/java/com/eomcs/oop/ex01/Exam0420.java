package com.eomcs.oop.ex01;

//# 클래스 사용 - 사용 범위
//

// 패키지 멤버 클래스
// => 패키지에 직접 소속된 클래스이다.
// => 다른 클래스들도 A 클래스를 사용할 수 있다.
// => bin/main/com/eomcs/oop/ex01/A.class
class A {}

public class Exam0420 {

  // 중첩 클래스(nested class)
  // => 다른 클래스 안에 정의된 클래스
  // => 그 클래스 안에서만 사용된다.
  // => bin/main/com/eomcs/oop/ex01/Exam0420$B.class
  class B {}

  public static void main(String[] args) {
    // 로컬 클래스(local class)
    // => 메서드 블록 안에 정의된 클래스
    // => 오직 그 메서드 블록 안에서만 사용된다.
    // => bin/main/com/eomcs/oop/ex01/Exam0420$1C.class
    // nested class이기도 함. 
    class C {}
  }

  public void m1() {
    A ref1;
    B ref2;
    //C ref3; // 컴파일 오류!, 다른 메소드에서 사용할 수 없기때문에 컴파일 오류가 생기는 것임
  }
}
