package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class MemberSearchFormServlet {

  MemberService memberService;

  public MemberSearchFormServlet(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/search")
  public void service(Map<String, String> params, PrintStream out) throws Exception {

    int no = Integer.parseInt(params.get("no"));

    Member member = memberService.get(no);

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>회원정보 찾기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원정보 찾기</h1>");


    if (member == null) {
      out.println("<p>해당 번호의 회원이 없습니다.</p>");
      return;
    }
    out.println("</body>");
    out.println("</html>");
  }
}
