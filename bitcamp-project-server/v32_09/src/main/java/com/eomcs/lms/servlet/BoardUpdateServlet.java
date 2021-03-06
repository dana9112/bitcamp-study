package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.json.BoardJsonFileDao;
import com.eomcs.lms.domain.Board;

public class BoardUpdateServlet implements Servlet {

  BoardJsonFileDao boardDao;

  public BoardUpdateServlet(BoardJsonFileDao boardDao) {
    this.boardDao = boardDao;
  }


  // 커맨드 패턴이란 메소드를 객체화 시키는 것
  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {

    Board board = (Board) in.readObject();


    if (boardDao.update(board) > 0) { // 오리진 보드가 널 값이 아니면 보드의 내용으로 업데이트 해라.
      out.writeUTF("OK");
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 게시물이 없습니다.");
    }
  }
}
