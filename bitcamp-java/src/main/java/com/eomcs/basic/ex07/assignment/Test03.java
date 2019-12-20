package com.eomcs.basic.ex07.assignment;

public class Test01 {
  public static void main(String[] args) {
    // 배열의 들어 있는 값의 순서를 거꾸로 변경하라
    // => 
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
    reverse(values); 
    
    for (int value : values) {
      System.out.println(value);
    }
    
  }
  // 출력결과:
  // -22, 0, 45, 22, 12, 78, -3, 4, 34
  
}
