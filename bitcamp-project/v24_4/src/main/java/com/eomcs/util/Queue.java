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
    
    // local class : 특정 메서드 안에서만 사용하는 중첩 클래스라면 그 메서드 안에 둔다.
    class QueueIterator<T> implements Iterator<T>{
      
      Queue<T> queue;
      
      @SuppressWarnings("unchecked")
      public QueueIterator(Queue<T> queue) {
        this.queue = (Queue<T>) Queue.this.clone(); // 바깥 클래스의 this (주소)를 사용하고 싶을때 바깥 "클래스명. this" 를 사용해야 함
      }

      @Override
      public boolean hasNext() {
        return queue.size() > 0;
      }
      
      
      @Override
      public T next() {
        return queue.poll();
      }
    }
    // 로컬 클래스는 인스턴스 멤버가 아니다.
    // 따라서 로컬 클래스의 생성자를 호출할 때 앞쪽에 this을 지정해서는 안된다. 
    return new QueueIterator<>(this);
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




