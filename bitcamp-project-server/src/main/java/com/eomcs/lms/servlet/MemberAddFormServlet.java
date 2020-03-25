package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.util.RequestMapping;

@Component
public class MemberAddFormServlet {

  @RequestMapping("/member/addForm")
  public void service(Map<String, String> params, PrintStream out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>회원정보 입력</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원정보 입력</h1>");
    out.println("<form action='/member/add'>");
    out.println("이   름: ");
    out.println(" <textarea name='name' rows='1' cols='60'> </textarea><br>");
    out.println("이메일: ");
    out.println(" <textarea name='email' rows='1' cols='60'> </textarea><br>");
    out.println("암   호: ");
    out.println(" <textarea name='password' rows='1' cols='60'> </textarea><br>");
    out.println("사   진: ");
    out.println(" <textarea name='photo' rows='1' cols='60'> </textarea><br>");
    out.println("전   화: ");
    out.println(" <textarea name='tel' rows='1' cols='60'> </textarea><br>");
    out.println("<br><button>제출</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");

  }
}
