package com.eomcs.oop.ex03.test;

public class Car {
  
  boolean on;
  int speed;
  String model;
  String maker; 
  Engine engine;
  int distance;
  //↑ 메모리를 사용할때 부분(데이터)
  
  Car() { //자동차 객체가 엔진 연산자의 유효한 값으로 적절하게 동작될 수 있도록 셋팅하는게 생성자. 
    this.engine = new Engine(4, 16,1980);
  }
  
  void start() {
   this.on = true; // 모든 인스턴스 메소드는 그 메소드를 호출할때 넘겨준 인스턴트 주소이며 내장된 히든 변수(this)로 호출한다. (!인스턴스 주소 없이는 호출 불가!)
  } //메모리(데이터)를 다루기 위한 연산자
  
  void stop() {
   this.on = false;
  } //메모리(데이터)를 다루기 위한 연산자
  
  void check() {
    if (this.engine.oilState == 0) { //this는 Car의 인스턴스 메소드이다.  //엔진의 데이터에 대해서 엔진 메소드를 조회하는 것이기 때문에 가능
      this.engine.cleanOil();
      System.out.println("자동차의 엔진 오일을 교환했습니다!");
    }
    System.out.println("자동차를 정비했습니다!");
  }
  /* 엔진 데이터는 엔진 클래스에 위치해있음으로 변경이 불가능
  void cleanOil() {
    this.engine.oilState = 10; //
  }
  */ 
}



