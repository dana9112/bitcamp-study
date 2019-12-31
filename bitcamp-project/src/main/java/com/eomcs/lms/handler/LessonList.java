package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;

public class LessonList {

  static final int DEFAULT_CAPACITY = 3;

  Lesson[] list;
  int size = 0;

  public LessonList() {
    this.list = new Lesson[DEFAULT_CAPACITY];
  }

  public LessonList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Lesson[DEFAULT_CAPACITY];
    else 
      this.list = new Lesson[capacity];
  }

  public Lesson[] toArray() {
    Lesson[] arr = new Lesson[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }

  public void add(Lesson board) {
    this.list[this.size++] = board;
  }
  
  public Lesson get(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i].getNo() == no) {
        return this.list[i];
      }
    }
    return null;
  }
  
}

