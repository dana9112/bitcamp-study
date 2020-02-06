package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface Servlet { // 이 메소드는 예외가 발생할 수 있는 메소드이다.
  void service(ObjectInputStream in, ObjectOutputStream out) throws Exception;


}
