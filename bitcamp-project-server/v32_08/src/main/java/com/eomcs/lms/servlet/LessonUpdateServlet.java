package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.LessonObjectFileDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateServlet implements Servlet {

  LessonObjectFileDao lessonDao;

  public LessonUpdateServlet(LessonObjectFileDao lessonDao) {
    this.lessonDao = lessonDao;
  }


  // 커맨드 패턴이란 메소드를 객
  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {

    Lesson lesson = (Lesson) in.readObject();


    if (lessonDao.update(lesson) > 0) {
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 수업이 없습니다.");
    }
  }
}
