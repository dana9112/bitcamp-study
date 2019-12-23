package com.eomcs.basic.ex07.assignment;

public class Test03 {
  public static void main(String[] args) {
    // 배열의 들어 있는 값의 순서를 거꾸로 변경하라
    // => 
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
    reverse(values); 
    printValues(values);
    
  } // main() end
 
  
  static void reverse(int[] values) {
    int count = values.length >> 1; // 비트연산자 활용
    int temp = 0;
    int endPos = values.length - 1;
    for (int i = 0, j = values.length - 1; i < count; i++, j--) {
      temp = values[i];
      values[i] = values[endPos - i];
      values[j] = temp;
      System.out.printf("%3d ", values[i]);
    }
    System.out.println();
  }
  
  static void printValues(int[] values) {
    for (int i = 0; i < values.length; i++) {
      System.out.printf("%3d ", values[i]);
    }
    System.out.println();
  }
  
}// class() end
