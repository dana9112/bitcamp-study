package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.BoardObjectFileDao;

public class BoardDeleteServlet implements Servlet {

  BoardObjectFileDao boardDao;

  public BoardDeleteServlet(BoardObjectFileDao boardDao) {
    this.boardDao = boardDao;
  }


  // 커맨드 패턴이란 메소드를 객체화 시키는 것
  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {

    int no = in.readInt();
    Board originBoard = boardDao.findAll(no);

    if (originBoard !=null) { // 삭제하려는 번호의 게시물을 찾았다면
      boardDao.delete(no);
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 게시물이 없습니다.");
    }

  }
}
