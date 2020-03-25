package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;

@Component
public class LessonListServlet {

  LessonService lessonService;

  public LessonListServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/list")
  public void service(Map<String, String> params, PrintStream out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("   <meta charset ='UTF-8'>");
    out.println("   <title> 수업 목록 </title>");
    out.println("</head>");
    out.println("<body>");
    out.println("   <h1> 수업 목록 </h1>");
    out.println("   <a href='/board/addForm'>수업추가</a><br>");
    out.println("   <table border='1'>");
    out.println("   <tr>");
    out.println("   <th>번호</th>");
    out.println("   <th>내용</th>");
    out.println("   <th>수업기간</th>");
    out.println("   <th>총수업시간</th>");
    out.println("   </tr>");


    List<Lesson> lessons = lessonService.list();
    for (Lesson l : lessons) {
      out.printf("<tr><td>%d</td>, <td>%s</td>, <td>%s ~ %s</td>, <td>%d</td>\n", l.getNo(),
          l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours());
    }
  }
}
