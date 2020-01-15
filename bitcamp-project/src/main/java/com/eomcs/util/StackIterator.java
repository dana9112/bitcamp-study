package com.eomcs.util;

//List 객체에서 iterator규칙에 따라 값을 꺼내주는 클래스를 정의
public class StackIterator<E> implements Iterator<E>{
  
  Stack<E> stack;
  int cursor;
  
  public StackIterator(Stack<E> stack) {
    this.stack = stack.clone();
  }

  @Override
  public boolean hasNext() {
    return ! stack.empty();
  }
  
  @Override
  public E next() {
    return stack.pop();
  }
  

  
}
