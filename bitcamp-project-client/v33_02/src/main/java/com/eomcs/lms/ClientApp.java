// LMS 클라이언트
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.eomcs.lms.dao.proxy.BoardDaoProxy;
import com.eomcs.lms.dao.proxy.LessonDaoProxy;
import com.eomcs.lms.dao.proxy.MemberDaoProxy;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;
import com.eomcs.util.Prompt;

public class ClientApp {

  Scanner keyboard = new Scanner(System.in);
  Prompt prompt = new Prompt(keyboard);

  String host; // 인스턴스 변수에 저장되어 다른 메소드에서도 쓸 수 있도록
  int port;

  HashMap<String, Command> commandMap = new HashMap<>();

  Deque<String> commandStack; // 필드만 선언하고 생성자에서 보관을 하도록 두는 거임
  // *Deque<String> commandStack = new ArrayDeque<>(); (이렇게 작성해도 되는 거지만 객체 준비를 위해서 분리해둠)*
  Queue<String> commandQueue;

  public ClientApp() {
    // 생성자?
    // => 객체가 작업할 때 사용할 자원들을 준비하는 일을 한다.

    // 사용자가 입력한 명령어를 보관할 객체 준비
    commandStack = new ArrayDeque<>();
    commandQueue = new LinkedList<>();

    // 서버와 포트를 받을 준비를 하자!
    try {
      host = prompt.inputString("서버? ");
      port = prompt.inputInt("포트? ");

    } catch (Exception e) {
      System.out.println("서버 주소 또는 포트 번호가 유효하지 않습니다!");
      keyboard.close();
      return;
    }

    // DAO 프록시 객체 준비
    // 3. 프록시 객체를 생성자에 준비하기
    BoardDaoProxy boardDao = new BoardDaoProxy(host, port);
    LessonDaoProxy lessonDao = new LessonDaoProxy(host, port);
    MemberDaoProxy memberDao = new MemberDaoProxy(host, port);

    // 사용자 명령을 처리할 Command 객체 준비
    commandMap.put("/board/list", new BoardListCommand(boardDao));
    commandMap.put("/board/add", new BoardAddCommand(boardDao, prompt));
    commandMap.put("/board/detail", new BoardDetailCommand(boardDao, prompt));
    commandMap.put("/board/update", new BoardUpdateCommand(boardDao, prompt));
    commandMap.put("/board/delete", new BoardDeleteCommand(boardDao, prompt));

    commandMap.put("/lesson/list", new LessonListCommand(lessonDao));
    commandMap.put("/lesson/add", new LessonAddCommand(lessonDao, prompt));
    commandMap.put("/lesson/detail", new LessonDetailCommand(lessonDao, prompt));
    commandMap.put("/lesson/update", new LessonUpdateCommand(lessonDao, prompt));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(lessonDao, prompt));

    commandMap.put("/member/list", new MemberListCommand(memberDao));
    commandMap.put("/member/add", new MemberAddCommand(memberDao, prompt));
    commandMap.put("/member/detail", new MemberDetailCommand(memberDao, prompt));
    commandMap.put("/member/update", new MemberUpdateCommand(memberDao, prompt));
    commandMap.put("/member/delete", new MemberDeleteCommand(memberDao, prompt));

    commandMap.put("/server/stop", () -> {
      try {
        try (Socket socket = new Socket(host, port);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

          out.writeUTF("/server/stop");
          out.flush();
          System.out.println("서버: " + in.readUTF());
          System.out.println("안녕!");
        }
      } catch (Exception e) {
        //
      }
    });
  }



  public void service() {

    while (true) {
      String command;
      command = prompt.inputString("\n명령> ");

      if (command.length() == 0)
        continue;

      if (command.equals("history")) {
        printCommandHistory(commandStack.iterator());
        continue;
      } else if (command.equals("history2")) {
        printCommandHistory(commandQueue.iterator());
        continue;
      } else if (command.equals("quit")) {
        break;
      }

      commandStack.push(command);
      commandQueue.offer(command);

      processCommand(command);


    }
    keyboard.close();
  }

  private void processCommand(String command) {

    Command commandHandler = commandMap.get(command); // 그 명령어를 처리할 커맨드 객체를 찾는다.
    if (commandHandler == null) { // 값이 null인 것은 값이 없다는 거임.
      System.out.println("실행할 수 없는 명령입니다.");
      return;
    }
    commandHandler.execute(); // 정상적이라면 실행해라.

  }

  private void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      count++;

      if ((count % 5) == 0) {
        String str = prompt.inputString(":");
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.println("클라이언트 수업 관리 시스템입니다.");

    ClientApp app = new ClientApp();
    app.service();
  }
}
