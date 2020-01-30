package com.eomcs.io.ex08;

import java.io.OutputStream;

public class DataOutputStream extends DecoratorOutputStream {

  public DataOutputStream(OutputStream out) {
    super(out); // 실제 쓰기 작업은 이 객체와 연결된 부품을 통해 수행한다.
  }

  public void writeUTF(String str) throws Exception {
    // 실제 쓰기 작업은 이 객체와 연결된 부품을 통해 수행한다.
    byte[] bytes = str.getBytes("UTF-8");
    연결된부품.write(bytes.length);
    연결된부품.write(bytes);
  }

  public void writeInt(int value) throws Exception {
    // 실제 쓰기 작업은 이 객체와 연결된 부품을 통해 수행한다.
    연결된부품.write(value >> 24);
    연결된부품.write(value >> 16);
    연결된부품.write(value >> 8);
    연결된부품.write(value);
  }

  public void writeLong(long value) throws Exception {
    // 실제 쓰기 작업은 이 객체와 연결된 부품을 통해 수행한다.
    연결된부품.write((int) (value >> 56));
    연결된부품.write((int) (value >> 48));
    연결된부품.write((int) (value >> 40));
    연결된부품.write((int) (value >> 32));
    연결된부품.write((int) (value >> 24));
    연결된부품.write((int) (value >> 16));
    연결된부품.write((int) (value >> 8));
    연결된부품.write((int) value);
  }

  public void writeBoolean(boolean value) throws Exception {
    // 생성자에서 받은 출력 객체의 write() 메서드를 사용하여 boolean 값 출력
    if (value)
      연결된부품.write(1);
    else
      연결된부품.write(0);
  }
}


