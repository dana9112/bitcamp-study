package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.util.List;
import com.eomcs.lms.domain.Board;

// "/board/list" 명령어 처리
public class BoardListCommand implements Command {

  PrintStream out;
  ObjectInputStream in;



  // 사용할 수 밖에 없는것
  // 외부에서 의존객체를 주입한다 -> dependency injection (의존성 주입) = DI
  public BoardListCommand(PrintStream out, ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void execute() {

    try {
      out.println("/board/list");
      String response = in.readUTF();
      if (response.contentEquals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }

      List<Board> boards = (List<Board>) in.readObject();
      for (Board b : boards) {
        System.out.printf("%d, %s, %s, %d\n", b.getNo(), b.getTitle(), b.getDate(),
            b.getViewCount());
      }

    } catch (Exception e) {
      System.out.println("통신 오류 발생!");
    }
  }
}


