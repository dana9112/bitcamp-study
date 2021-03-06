// 비트 이동 연산자 : >>, >>>, << 
package com.eomcs.basic.ex05;

public class Exam0430 {
    public static void main(String[] args) {
      // >>> 비트 이동 연산자 사용법
      // 오른쪽으로 이동 후, 
      // - 왼쪽 쪽 빈자리 : 원래 숫자와 같은 부로 값으로 채운다.
      // - 양수면 0, 음수면 1을 채운다.
      // 오른쪽 경계를 넘어간 비트 : 자른다.
      
      int i = 0b01101001; // 105
      System.out.println(i); 
      // 00000000 00000000 00000000 01101001


      System.out.println(i >>> 1); 
      // x0000000 00000000 00000000 00110100|1
      // 00000000 00000000 00000000 00110100   => 52

      System.out.println(i >>> 2); 
      // xx000000 00000000 00000000 00011010|01
      // 00000000 00000000 00000000 00011010   => 26


      System.out.println(i >>> 3); 
      // xxx00000 00000000 00000000 00001101|001
      // 00000000 00000000 00000000 00001101   => 13

      System.out.println(i >>> 4); 
      // xxxx0000 00000000 00000000 00000110|1001
      // 00000000 00000000 00000000 00000110   => 6


      // 음수를 이동
      // - 왼쪽 빈자리는 숫자의 부호비트로 채운다.
      //   음수니까 1로 채운다.
      // - 2로 나눈 후에 소수점이 있으면 
      //   그 수보다 더 작은 정수값이 되는 결과가 나온다.


      i = 0b11111111_11111111_11111111_10101001; // -87
      
      System.out.println(i); 
      System.out.println(i >>> 1); 
      // x1111111 11111111 11111111 11010100|1
      // 01111111 11111111 11111111 11010100     => 2147483604

      System.out.println(i >>> 2); 
      // xx111111 11111111 11111111 x1101010|01
      // 00111111 11111111 11111111 11101010     => 1073741802
      
      System.out.println(i >>> 3); 
      // xxx11111 11111111 11111111 11110101|001
      // 00011111 11111111 11111111 11110101    => 536870901

      System.out.println(i >>> 4);
      // xxxx1111 11111111 11111111 11111010|1001
      // 00001111 11111111 11111111 11111010    => 268435450
    }
}
