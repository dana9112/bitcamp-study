package com.eomcs.oop.ex02.study;

public class GasStation {
  
  //인스턴스 변수
  int type; 
  String name;

  // 인스턴스 메소드를 만들었음
  int refuel(Car c) { 
    if (c.type != this.type)
      return 0;

    int amount = 100 - c.energy;
    c.energy = 100;
    return amount;
  }

  static void clean(Car c) { 
    // int type의 변수를 사용하지 않기 떄문에 static을 굳이 제거할 필요가 없다. 
    // 인스턴스 필드를 사용하지 않는 인스턴스 메소드로 만들 필요가 없다.  
    c.cleanLevel = 0;
  }
}


