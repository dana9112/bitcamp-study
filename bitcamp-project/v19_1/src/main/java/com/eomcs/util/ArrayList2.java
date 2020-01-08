package com.eomcs.util;

public class ArrayList2 {

  public static final int DEFAULT_CAPACITY = 10;

  Object[] elementDate;
  int size;

  public ArrayList2() {
    this.elementDate = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList2(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementDate = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementDate = new Object[initialCapacity];
    }
  }
  

  
  /*
  public void add(Object e) {
    if (this.size == this.elementDate.length) {
      int oldSize = this.elementDate.length;
      int newSize = this.elementDate.length;
      
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementDate[i];
      }
    }
  
    this.elementDate[this.size++] = e;
  }
  */

  public Object get(int index) {
    return this.elementDate[index];
  }

  public void set(int index, Object e) {
    this.elementDate[index] = e;
  }

  public void remove(int index) {
    for (int i = index + 1; i < this.size; i++) {
      this.elementDate[index-1] = this.elementDate;
    }
    size--;
  }

}
