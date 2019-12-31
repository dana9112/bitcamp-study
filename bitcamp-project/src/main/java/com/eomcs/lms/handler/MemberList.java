package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Member;

public class MemberList {

  static final int DEFAULT_CAPACITY = 3;

  Member[] list;
  int size = 0;

  public MemberList() {
    this.list = new Member[DEFAULT_CAPACITY];
  }

  public MemberList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Member[DEFAULT_CAPACITY];
    else 
      this.list = new Member[capacity];
  }

  public Member[] toArray() {
    Member[] arr = new Member[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }

  public void add(Member board) {
    this.list[this.size++] = board;
  }
  
  public Member get(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i].getNo() == no) {
        return this.list[i];
      }
    }
    return null;
  }
  
}

