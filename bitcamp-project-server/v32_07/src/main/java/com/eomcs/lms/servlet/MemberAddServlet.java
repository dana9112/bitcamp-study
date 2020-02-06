package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.MemberObjectFileDao;
import com.eomcs.lms.domain.Member;

public class MemberAddServlet implements Servlet {

  MemberObjectFileDao memberDao;

  public MemberAddServlet(MemberObjectFileDao memberDao) {
    this.memberDao = memberDao;
  }


  // 커맨드 패턴이란 메소드를 객
  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    Member member = (Member) in.readObject();


    if (memberDao.insert(member) > 0) {
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("같은 번호의 회원이 있습니다.");
    }
  }

}
