package com.eomcs.basic.ex99;

public class Exam231 {
  public static void main(String[] args) {
   java.util.Scanner scanner = new java.util.Scanner(System.in);
   
   //nextInt() 다음에 nextLin()을 호출할때 
   //공백 문자가 읽히는 문제해결

   System.out.print("입력>");
   int i1 = scanner.nextInt();
   int i2 = scanner.nextInt();
   
   //공백만 그냥 읽는다.
   //next()
   // => 한 개의 token을 읽는다.
   // => 공백을 만날 때 까지 읽는다.
   // => 물론 nextInt()와 달리 값을 읽은 후 공백을 제거한다. 
   String s1 = scanner.next();

   String s2 = scanner.next();

   int i3 = scanner. nextInt();

   String s3 = scanner.next();

   System.out.println("----------------------------------------------------");
   
   System.out.println(i1);
   System.out.println(i2);
   System.out.println(i3);
   System.out.println(s1);
   System.out.println(s2);
   System.out.println(s3);
   
   
   //nextInt()
   // => space, tab, new line을 만나면, 그 앞까지 입력한 문자열을 int값으로 바꿔 리턴한다.
   // => 입력한 문자열이 숫자를 의미하는 문자열이 아니라면 int 값으로 바꿀 수 없기 때문에 실행 오류가 생긴다. 


  }
}