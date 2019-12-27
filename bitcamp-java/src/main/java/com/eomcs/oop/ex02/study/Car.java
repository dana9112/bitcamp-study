package com.eomcs.oop.ex02.study;

public class Car {

  public static final int OIL = 1;
  public static final int GAS = 2;
  
  String name;  // 여러개의 필드를 받기 위해서는 static을 때야 함. / static을 붙이면 자동으로 필드가 만들어짐. test03
  int type;
  String color;
  int speed;
  int energy;
  int power;
  int cleanLevel;
  
  void speedUp() {
    //Car this = 메서드를 호출할 떄 넘겨준 인스턴스 주소; / 인스턴스 변수는 반드시 this라는 히든 변수가 있다.;/ static 변수에는 this 없다.
    if (this.speed >= 100)
      return;
    this.speed += 10;
  }

  int comparePower(Car c) {
    if (power > c.power)
      return -1;
    else if (power == c.power)
      return 0;
    else
      return 1;
  }
  
  
}
