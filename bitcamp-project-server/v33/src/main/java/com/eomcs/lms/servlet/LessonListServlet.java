package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.LessonDao;

public class LessonListServlet implements Servlet {

  LessonDao lessonDao;

  public LessonListServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }


  // 커맨드 패턴이란 메소드를 객
  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(lessonDao.findAll());
  }

}
