// final 사용법: 상수 필드 만들기 Ⅱ
package com.eomcs.oop.ex06.e;

// 클래스에 final을 붙이면 이 클래스의 서브 클래스를 만들 수 없다.
public final class Exam0220 {
  // 상수 필드는 보통 인스턴스 마다 개별적으로 관리하지 않기 때문에
  // 보통 스태틱 필드(클래스 필드)로 맏늗나.
  // 공개할 경우 public으로 선언한다.
  //
  public static final int a = 100;

}
