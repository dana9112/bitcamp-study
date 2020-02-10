// 클라이언트와 입출력 테스트 - byte stream : 바이트 배열 주고 받기
package com.eomcs.net.ex03;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0120 {
  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)) {

      System.out.println("클라이언트의 연결을 기다리고 있음.");

      try (Socket socket = serverSocket.accept();
          OutputStream out = socket.getOutputStream();
          InputStream in = socket.getInputStream()) {

        System.out.println("대기열에서 클라이언트 정보를 꺼내 소켓을 생성하였음.");
        System.out.println("클라이언트와 통신할 입출력 스트림이 준비되었음.");


        System.out.println("클라이언트가 보낸 100바이트를 기다리고 있음!");
        // => 클라이언트가 100바이트를 보낼때까지 리턴하지 않는다.
        byte[] buf = new byte[100];
        int size = in.read(buf); // blocking 모드로 작동한다.
        System.out.printf("읽은 바이트 수 %d\n", size);

        // 서버가 데이터를 보내지 않으면 클라이언트의 read()는 리턴하지 않는다.
        // 이를 확인하기 위해 잠시 실행을 멈춘다.
        System.out.print("데이터를 보내기 전에 잠깐!");
        keyboard.nextLine();

        // => 클라이언트에게 받은 문자열을 그대로 보낸다.
        // 물론 클라이언트가 보낸 데이터를 다 읽을 때까지 리턴하지 않는다.
        out.write(request);
        System.out.println("클라인트에게 데이터를 보냈음.");

      }
      System.out.println("클라이언트와의 연결을 끊었음.");

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 종료!");
  }

}

