package com.eomcs.oop.ex03.test;

class Score {
  static int count; // 클래스 이름으로 접근하고 나머지는 인스턴스로 접근함. 
  
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
  
  Score() {
    System.out.println("Score() - 1"); 
    // 생성자는 인스턴스가 생성되면 자동으로 만들어 진다. 
    // 생성자 - 모니터 생각하기  -> 사용하기 위해서  유효한 값으로 세팅하기 
    // 인스턴스를 만들고나서 제대로 사용하기 위해서 유효한 값으로 초기화되어야 하는데 이를 인스턴스를 제대로 설정하기 위해서 "생성자"를 만드는 것임. 
    // 자바는 무조건 1개 이상의 생성자가 존재한다.
    Score.increase();
  }
  
  Score(String name, int kor, int eng, int math) {
    System.out.println("Score() - 2");
/*
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.compute();
    */
    
    Score.increase();
  }
  
  /*
  static void compute(Score s) { // 연산자
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
  }
  */
  
  
  static void increase() { //클래스 메소드(필드) = 스태틱 메소드(필드)
    Score.count++;
  }
  
  
  void compute() { // 연산자
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
  
}


public class Test01 {
  public static void main(String[] args) {
    Score s1 = new Score("홍길동", 100, 90, 80); // s1 로컬변수
   System.out.println("-----------");
    /*
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 80;
    s1.compute();
    */
    
    Score s2 = new Score("임꺽정", 90, 80, 70); // s1 로컬변수
   System.out.println("------------");
   
    
  }
}
