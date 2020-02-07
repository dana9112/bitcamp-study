// 서버 + 키보드 입력
package com.eomcs.net.ex01;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Receiver2 {

  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행!");
    Scanner keyScan = new Scanner(System.in);

    ServerSocket serverSocket = new ServerSocket(8888);
    Socket socket = serverSocket.accept();

    PrintStream out = new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());
    // 소켓으로 들어 올 수 있는 인풋 스트림을 가지고 올 수 있다.
    // 인풋 스트림은 1바이트로 단순하게 들어오고 작업하기 때문에 헬퍼와 데코레이터가 필요 (스케너 헬퍼)

    // 클라이언트가 보낸 문자열을 수신한다.
    String str = in.nextLine();
    System.out.println(str); // 프린트 데코레이터를 붙이고

    // 키보드 입력을 받아서 클라이언트로 송신한다.
    System.out.print("입력> ");
    str = keyScan.nextLine();
    out.println(str);

    in.close();
    out.close();
    socket.close();
    serverSocket.close();
    keyScan.close();
  }

}


