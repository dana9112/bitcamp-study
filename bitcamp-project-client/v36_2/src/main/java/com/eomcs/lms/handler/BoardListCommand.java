package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

// "/board/list" 명령어 처리
public class BoardListCommand implements Command {

  BoardDao boardDao; // 1. 입출력 지우고 삽입해줌

  public BoardListCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute() {

    try {
      List<Board> boards = boardDao.findAll();

      for (Board board : boards) { // 데이터를 한 개 가져왔으면 true를 리턴한다.
        System.out.printf("%d, %s, %s, %d\n", //
            board.getNo(), //
            board.getTitle(), //
            board.getDate(), //
            board.getViewCount()); //
      }

    } catch (Exception e) {
      System.out.println("목록 조회 실패!");
    }
  }
}


