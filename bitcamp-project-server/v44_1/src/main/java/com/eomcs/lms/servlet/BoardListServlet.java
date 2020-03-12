package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

public class BoardListServlet implements Servlet {

  BoardService boardService;

  public BoardListServlet(BoardService boardService) {
    this.boardService = boardService;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    // Application Server 아키텍처에서는
    // 클라이언트가 출력할 내용을 서버에게 보내주는 것이 핵심이다.
    // 왜?
    // 클라이언트의 역할은 서버가 보낸 데이터를 단순히 출력하는 것이기 때문이다.
    // 이렇게 함으로써 출력 내용을 변경할 때 서버 쪽만 변경하면 된다.
    // 클라이언트는 그대로 출력하는 것이기 때문에 변경할 필요가 없다.
    //
    List<Board> boards = boardService.list();
    for (Board board : boards) {
      out.printf("=> %d, %s, %s, %d\n", //
          board.getNo(), //
          board.getTitle(), //
          board.getDate(), //
          board.getViewCount() //
      );
    }
  }
}
