package com.eomcs.util;
//
public abstract class AbstractList1_1<E> implements List<E> {
  protected int size;

  public int size() {
    return size;
  }


  /* 다음은 로컬 클래스에 대한 
   * '의미 전달을 위해서 간략하게 작성한 코드(pseudo;의사코드=가짜코드)' 이다.

 ## 클래스 멤버:

   class 클래스 {
     필드 선언(스태틱, 인스턴스)
     초기화 블록(스태틱, 인스턴스)
     생성자
     메서드(스태틱, 인스턴스) {
       this. 사용
       로컬 변수
       블록 {

       }
       로컬(중첩) 클래스(= 여기서는 로컬 클래스라고 함) {
          바깥클래스.this 사용
          로컬 변수 접근 가능
       }
     }

     중첩클래스(스태틱, 인스턴스) {
       바깥클래스.this 사용
     }
    }


   */


  @SuppressWarnings("unchecked")
  @Override
  public Iterator<E> iterator() {
    // this = 인스턴스주소;


    // anonymous class : 인스턴스는 "한 개"만 생성할 거면 익명 클래스로 정의하라.
    // 정의하자마자 즉시 인스턴스를 만들어 줘야 함.
    // 바깥 클래스의 파라미터를 만들어 줘야 함.
     Iterator<E> obj = new Iterator<E>() { // 얘는 수퍼클래스 아니면 인터페이스다. () -> 생성자는 Object의 디폴트 값을 받는다.

      List<E> list;
      int cursor;
      
      // 익명 클래스는 생성자를 만들 수 없기 때문에
      // 인스턴스 필드를 초기화시키기 위해서는
      // 다음과 같이 인스턴스 블록을 사용해야 한다. 
      // (물론 단순히 값을 할당하는 경우에는 인스턴스 블록에 넣지 않고,
      // 필드 선언에 바로 할당 연산자를 사용할 수 있다.)
      { 
        // 로컬 클래스는 인스턴스 멤버가 아니기 때문에 
        this.list = (List<E>) AbstractList1_1.this;
      }

      @Override
      public boolean hasNext() {
        return cursor < this.list.size();
      }

      @Override
      public E next() {
        return list.get(cursor++);
      }
    }; // 클래스를 정의함과 동시에 인스턴스를 값을 할당했기 때문에 ;를 무조건 넣어줘야 한다. 

    // 로컬 클래스는 인스턴스 멤버가 아니기 떄문에
    // 앞쪽에 인스턴스 주소를 전달해서는 안된다.
    // 즉 this. 을 붙여서는 안된다.
    return obj; 
  }

}






