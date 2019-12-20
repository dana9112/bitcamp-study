package com.eomcs.basic.ex07.assignment;

public class Test01 {
  public static void main(String[] args) {
    // 배열에 들어가 있는 오름 차순으로 정렬하라
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
    sort(values); // 
    
    for (int value : values) {
      System.out.println(value);
    }
    
  }
  
  
}
