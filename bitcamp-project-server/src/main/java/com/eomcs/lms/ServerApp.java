// LMS 서버
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.domain.Board;

public class ServerApp {

  // 옵저버 관련 코드
  Set<ApplicationContextListener> listeners = new HashSet<>();
  Map<String, Object> context = new HashMap<>();


  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  private void notifyApplicationInitialized() { // 어플리케이션 실행할 때 옵저버 실행
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
  }

  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(context);
    }
  }
  // 옵저버 관련 코드 끝



  public void service() {

    notifyApplicationInitialized();


    try (
        // 서버쪽 연결 준비
        // => 클라이언트의 연결을 9999번 포트에서 기다린다.
        ServerSocket serverSocket = new ServerSocket(9999);) {

      System.out.println("클라이언트 연결 대기중...");

      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println("클라이언트와 연결되었음!");

        processRequest(socket); // 접속순서대로 처리를 한다.

        System.out.println("-------------------------");
      }

    } catch (Exception e) {
      System.out.println("서버 준비 중 오류 발생!");

    }


    notifyApplicationDestroyed();

  } // service()

  @SuppressWarnings("unchecked")
  void processRequest(Socket clientSocket) {
    try (

        Socket socket = clientSocket;
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());) { // 전체를 가지고 올 수
                                                                                      // 있는

      System.out.println("통신을 위한 입출력 스트림을 준비하였음!");

      String request = in.readUTF();
      System.out.println("클라이언트가 보낸 메시지를 수신하였음!");

      List<Board> boards = (List<Board>) context.get("boardList");

      if (request.equals("/board/list")) {
        out.writeUTF("OK");
        out.writeObject(context.get("boardList")); // hashmap에 list들이 모두 들어 있기 때문에 hashmap을 통해 꺼냄

      } else if (request.equals("/board/add")) {
        Board board = (Board) in.readObject();
        boards.add(board);

      } else {
        out.writeUTF("FAIL");
        out.writeObject(context.get("boardList"));
      }

      System.out.println("클라이언트로 메시지를 전송하였음");

    } catch (Exception e) {
      System.out.println("예외발생");
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    System.out.println("서버 수업 관리 시스템입니다.");

    ServerApp app = new ServerApp();
    app.addApplicationContextListener(new DataLoaderListener());
    app.service();

  }

}
