package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.json.BoardJsonFileDao;

public class BoardDeleteServlet implements Servlet {

  BoardJsonFileDao boardDao;

  public BoardDeleteServlet(BoardJsonFileDao boardDao) {
    this.boardDao = boardDao;
  }


  // 커맨드 패턴이란 메소드를 객체화 시키는 것
  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {


    int no = in.readInt();

    if (boardDao.delete(no) > 0) { // 삭제했다면,
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 게시물이 없습니다.");
    }

  }
}
