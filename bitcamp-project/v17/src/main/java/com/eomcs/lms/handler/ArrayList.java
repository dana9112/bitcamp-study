package com.eomcs.lms.handler;

import java.util.Arrays;

public class ArrayList {

  static final int DEFAULT_CAPACITY = 3;

  Object[] list;
  int size = 0;

  public ArrayList() {
    this.list = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Object[DEFAULT_CAPACITY];
    else 
      this.list = new Object[capacity];
  }

  public Object[] toArray() {
    return Arrays.copyOf(this.list, this.size); // 배열에 들어있응 갯수만큼 새 배열의 값만 복사한다. 
  }

  public void add(Object obj) {
    if (this.size == this.list.length) {
      // 현재 배열에 게시글 객체가 꽉 찼으면, 배열을 늘린다.
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
      System.out.printf("새 배열을 %d 개 생성하였음!", newCapacity);
    }
    this.list[this.size++] = obj;
  }
  
  public Object get(int idx) {
   if (idx>= 0 && idx < this.size) {
     return this.list[idx];
   }else {
     return null;
   }
  }
}

