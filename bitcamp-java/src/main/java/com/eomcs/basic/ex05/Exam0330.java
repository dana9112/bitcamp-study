package com.eomcs.basic.ex05;

//# 논리 연산자 : && vs &
public class Exam0330 {
    public static void main(String[] args) {
        boolean a = false;
        boolean b = false;
        boolean r = a && (b = true); 
        // 계산 순서
        System.out.printf("a=%b, b=%b, r=%b\n", a, b, r);

        a = false;
        b = false;
        r = a & (b = true);
        System.out.printf("a=%b, b=%b, r=%b\n", a, b, r);
    }
}
// &&, ||
// - 앞의 피연산자의 값으로 결과를 알 수 있다면 뒤의 명령은 실행하지 않는다.
// 
// &, |
// - 앞의 피연산자로 결과를 알 수 있을 지라도, 
//   뒤에 놓은 명령까지 모두 실행한다.