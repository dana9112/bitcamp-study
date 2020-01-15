// 인터페이스 구현 - 직접 인터페이스를 구현하기 보다 추상 클래스를 상속 받는다.
package com.eomcs.oop.ex10.b;

// 인터페이스를 직접 구현하면 인터페이스에 선언된 모든 메서드를 구현해야 하지만,
// 미리 인터페이스의 몇몇 메서드를 구현한 추상클래스(AbstractServlet)를 상속 받는다면
// 서브 클래스는 좀 더 쉽게 인터페이스를 구현할 수 있다.

public class Exam03 extends AbstractServlet {
  
  // Servlet 인터페이스에 선언된 메서드 중에서 
  // 추상 클래스가 구현하지 않은 메서드만 정의하면 된다.
  // 매우 편리하다.
  public void service() {}
}
// 즉 이렇게 인터페이스의 메서드가 많을 경우 
// 일부 메서드를 미리 구현함으로써 
// 개발자가 좀 더 쉽게 인터페이스를 구현할 수 있게 도와주는 용도로
// "추상 클래스" 문법을 사용할 수 있다!







 