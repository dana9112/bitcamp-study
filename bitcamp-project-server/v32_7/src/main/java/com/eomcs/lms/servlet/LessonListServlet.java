package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.LessonObjectFileDao;

public class LessonListServlet implements Servlet {

  LessonObjectFileDao lessonDao;

  public LessonListServlet(LessonObjectFileDao lessonDao) {
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
