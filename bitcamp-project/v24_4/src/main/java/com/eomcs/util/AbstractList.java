package com.eomcs.util;
//
public abstract class AbstractList<E> implements List<E> {
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
  
  
  @Override
  public Iterator<E> iterator() {
    // this = 인스턴스주소;
    
    // local class : 특정 메서드 안에서만 사용하는 중첩 클래스라면 그 메서드 안에 둔다.
    class ListIterator<T> implements Iterator<T>{ //바깥 클래스와 구분하기 위해서 T로 변경
      
      List<T> list;
      int cursor;
      
      @SuppressWarnings("unchecked")
      public ListIterator() {
        // 로컬 클래스는 인스턴스 멤버가 아니기 때문에 
        this.list = (List<T>) AbstractList.this;
      }
      
      @Override
      public boolean hasNext() {
        return cursor < this.list.size();
      }
      
      @Override
      public T next() {
        return list.get(cursor++);
      }
    }
    
    // 로컬 클래스는 인스턴스 멤버가 아니기 떄문에
    // 앞쪽에 인스턴스 주소를 전달해서는 안된다.
    // 즉 this. 을 붙여서는 안된다.
    return new ListIterator<E>(); 
  }
  
}






