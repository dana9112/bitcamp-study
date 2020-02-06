package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.json.BoardJsonFileDao;

public class BoardListServlet implements Servlet {

  BoardJsonFileDao boardDao;

  public BoardListServlet(BoardJsonFileDao boardDao) {
    this.boardDao = boardDao;
  }

  // 커맨드 패턴이란 메소드를 객
  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(boardDao.findAll());
  }

}
