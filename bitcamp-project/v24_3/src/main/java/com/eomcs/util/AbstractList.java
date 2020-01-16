package com.eomcs.util;
//
public abstract class AbstractList<E> implements List<E> {
  protected int size;
  
  public int size() {
    return size;
  }
  
  
  @Override
  public Iterator<E> iterator() {
    
    // this = 인스턴스주소;
    // LinkedList에서 값을 꺼내주는 일을 할 Iterator 구현체를 준비하여 리턴한다.
    return this.new ListIterator<E>(); //(스태틱에서는 this를 붙이지 않는다.)
  }
  
  
  // non-static nested class = inner class
  class ListIterator<T> implements Iterator<T>{ //바깥 클래스와 구분하기 위해서 T로 변경
    
    List<T> list;
    int cursor;
    
    @SuppressWarnings("unchecked")
    public ListIterator() {
      this.list = (List<T>) AbstractList.this/*바깥 클래스의 정보를 받기 위해서 ab를 붙여준거임*/;
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
  
  
}






