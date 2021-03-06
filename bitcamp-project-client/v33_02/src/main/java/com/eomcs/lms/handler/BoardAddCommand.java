// "/board/add" 명령어 처리
package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardAddCommand implements Command {


  Prompt prompt;
  BoardDao boardDao; // 1. 입출력 지우고 삽입해줌

  public BoardAddCommand(BoardDao boardDao, Prompt prompt) {
    this.boardDao = boardDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    Board board = new Board();

    board.setNo(prompt.inputInt("번호? "));
    board.setTitle(prompt.inputString("내용? "));
    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    try {
      boardDao.insert(board); // 보드 디에이오에서 인서트를 출력하여
      System.out.println("저장하였습니다. ");

    } catch (Exception e) {
      System.out.println("데이터 저장 실패!");

    }
  }

}


