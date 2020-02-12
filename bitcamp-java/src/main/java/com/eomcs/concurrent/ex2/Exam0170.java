// "system" 스레드 그룹에 소속된 스레드들
package com.eomcs.concurrent.ex2;

public class Exam0170 {

  public static void main(String[] args) {
    Thread main = Thread.currentThread();
    ThreadGroup mainGroup = main.getThreadGroup();
    ThreadGroup systemGroup = mainGroup.getParent();

    Thread[] arr = new Thread[100];
    int count = systemGroup.enumerate(arr, false);

    System.out.println("system 스레드 그룹에 소속된 스레드들:");
    for (int i = 0; i < count; i++) {
      System.out.println("   =>" + arr[i].getName());
    }
  }
}

// JVM의 스레드 계층도:
// system(TG)
// => Reference Handler(T) // 인스턴스 주소 관리
// => Finalizer(T) // 가비지 컬렉터
// => Signal Dispatcher(T) // 내부적으로 부가적인 이벤트(키보드 등) 처리하는 것
// => main(TG)
// ...=> main(T) : main() 메서드를 호출한다.
// => InnocuousThreadGroup(TG)
