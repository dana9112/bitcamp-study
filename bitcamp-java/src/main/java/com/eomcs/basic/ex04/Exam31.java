package com.eomcs.basic.ex04;

public class Exam31 {
  public static void main(String[] args) {
    // 부동소수점 변수 - 메모리 크기 (ex03-Exam31 참고) //부동소수점 나오면 그냥 double 쓰기
    float f;

    f = 3.141592f;
    System.out.println(f);

    f = 3.1415929f; // 소수점을 때고 8자리 수는 어떤 수는 되는 경우가 있고 안 되는 경우도 있다. 
    System.out.println(f);

    f = 0.0000003141592f; //소수점을 때고 0을 제외하고 7자리
    System.out.println(f);

    f = 0.00000031415929f;  //소수점 이하인 경우 앞의 0은 유효자리수에 포함 안함
    System.out.println(f);

    f = 314159200000.0f; // 소수점 이상인 경우 뒤의 0을 포함해서 유효자리수 계산
    System.out.println(f);


    double d;
    d = 9.87654321234567;
    System.out.println(d);

    d = 98765432.1234567;
    System.out.println(d);

    d = 98765432123456.7;
    System.out.println(d);

    d = 98765432123456.74; //16자리를 넘어가는 순간 안되는 숫자가 생긴다. 값이 왜곡된다.
    System.out.println(d);

    // 변수와 리터럴
    f = 99999.88f;
    System.out.println(f);

    f = 99999.88777f; // 이미 리터럴이 4바이트 유효자릿수를 넘어갔다. 
    System.out.println(f);

    d = 99999.88f; // 8바이트 메모리에 4바이트를 사용할때는 남은 8바이트의 메모리에 다른 숫자로 변환된다.
    System.out.println(d);

    d = 99999.88; // 따라서 4바이트는 4바이트에 넣고 8바이트는 8바이트에 넣어 정리한다. 
    System.out.println(d);

    float f1 = 99988.88f;
    float f2 = 11.11111f;
    System.out.println(f1);
    System.out.println(f2);

    float f3 = f1 + f2;
    System.out.println(f3);
    //  99988.88
    //     11.11111
    // -------------
    //  99999.99111 => 4바이트 숫자를 넘어가는 경우가 발생하기 때문에 값이 왜곡된다. 
    
    double r = f1 + f2; // float + float = float 이미 결과에서 값이 괘곡된다.
    System.out.println(r);

    double d1 = 99988.88;
    double d2 = 11.11111;
    System.out.println(f1);
    System.out.println(f2);

    double d3 = d1 + d2;
    System.out.println(d3);


    f1 = 3.1415929f;
    d1 = f1; //컴파일은 Ok. 단, 값은 왜곡될 수 있다. "명심할것"
    System.out.println(d1);

    //f1 = d1; //컴파일 오류!

  }
}
  