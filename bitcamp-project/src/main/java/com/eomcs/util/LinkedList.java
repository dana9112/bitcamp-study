package com.eomcs.util;

import java.lang.reflect.Array;

public class LinkedList<E> {
  
  Node<E> first;
   
  Node<E> last;
  
  int size;
  
  // 손코딩 하기 딱 좋은...ㅋㅋ
  public void add(E value) {
    Node<E> newNode = new Node<>();
    newNode.value = value;
    
    if (/*this. 생략*/first == null) {
      last = first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    this.size++;
  }
  
  
  // 손코딩 하기 좋음...ㅋㅋ
  public E get(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node<E> cursor = first;
    for (int i = 0 ; i < index; i++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }
  
  public void add(int index, E value) {
    if (index < 0 || index >= size)
      return;
    
    Node<E> newNode = new Node<>();
    newNode.value = value;
    
    Node<E> cursor = first;
    for (int i = 0 ; i < index - 1; i++) {
      cursor = cursor.next;
    }
    
    if (index == 0) {
      newNode.next = first;
      first = newNode;
    } else {
      
      newNode.next = cursor.next;
      cursor.next = newNode;
    }
    

    this.size++;
  }
  
  public E remove(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node<E> cursor = first;
    for (int i = 0 ; i < index-1; i++) {
      cursor = cursor.next;
    }
    
    Node<E> deletedNode = null;
    if (index == 0) {
      deletedNode = first;
      first = deletedNode.next;
    } else {
      deletedNode = cursor.next;
      cursor.next = deletedNode.next;
    }
    
    deletedNode.next = null;
    size--;
    
    return deletedNode.value;
  }
  
  public E set(int index, E value) {
    if (index < 0 || index >= size)
      return null;
    
    Node<E> cursor = first;
    for (int i = 0 ; i < index; i++) {
      cursor = cursor.next;
    }
    
    E oldValue = cursor.value;
    cursor.value = value;
    
    return oldValue;
  }
  
  public Object[] toArray() {
    Object[] arr = new Object[size];
    
    
    Node<E> cursor = first;
    for (int i = 0 ; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {

    if (arr.length < size) {
      // (arr.get) 까지는 배열을...;;배열은 배열인데 한 항목의 타입을 리턴해줌
      arr = (E[]) Array.newInstance(arr.getClass().getComponentType(), size);
    }
      
    Node<E> cursor = first;
    for (int i = 0 ; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }
  
  public int size() {
    return this.size;
  }
  
  
  static class Node<T> {
    T value;
    Node<T> next;
  }
}
