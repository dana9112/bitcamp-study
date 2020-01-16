package com.eomcs.util;

public class Queue<E> extends LinkedList<E> implements Cloneable {
  
  public void offer(E value) {
    this.add(value);
  }
  
  public E poll() {
    return this.remove(0);
  }
  
  
  @Override
  public Queue<E> clone() {
    // 'deep copy' 수행
    // => 스택의 경우 배열을 복사하면 되기 때문에,
    //    기존의 'shallow copy'를 수행한 후 배열을 따로 복사하였다.
    // => LinkedList의 경우 노드와 노드 사이를 연결해야 하기 때문에 
    //    단순히 'shallow copy'를 수행해서는 안된다.
    // => 그냥 다음과 같이 새 Queue를 만들고, 
    //    기존 Queue에 저장된 값을 꺼내서 새 Queue에 저장해야 한다.
    //
    Queue<E> temp = new Queue<E>();
    
    for (int i = 0; i < this.size(); i++) {
      temp.offer(this.get(i));
    }
    return temp;
  }
  public Iterator<E> iterator() {
    // this = 인스턴스 주소;
    
    // annoymous class : 인스턴스를 한 개만 생성할 경우 로컬 클래스를 익명 클래스로 정의하라. 
    return new Iterator<E>() {
      
      Queue<E> queue = (Queue<E>) Queue.this.clone();
     
      @Override
      public boolean hasNext() {
        return queue.size() > 0;
      }
      
      
      @Override
      public E next() {
        return queue.poll();
      }
    };
  }
  
  
}

/*
 ## 클래스 멤머:
   
   class 클래스 {
     필드 선언(스태틱, 인스턴스)
     초기화 블록(스태틱, 인스턴스)
     생성자
     메서드(스태틱, 인스턴스)
     중첩클래스(스태틱, 인스턴스)
     }
     
 */




