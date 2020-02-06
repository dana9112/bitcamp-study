package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.MemberObjectFileDao;

public class MemberListServlet implements Servlet {

  MemberObjectFileDao memberDao;

  public MemberListServlet(MemberObjectFileDao memberDao) {
    this.memberDao = memberDao;
  }



  // 커맨드 패턴이란 메소드를 객
  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(memberDao.findAll());
  }

}
