package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class MemberSearchServlet {

  MemberService memberService;

  public MemberSearchServlet(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/search")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    String keyword = params.get("검색어");

    if (keyword.length() > 0) {
      params.put("title", keyword);
    }


    List<Member> members = memberService.search(keyword);
    for (Member m : members) {
      out.printf("%d, %s, %s, %s, %s\n", //
          m.getNo(), //
          m.getName(), //
          m.getEmail(), //
          m.getTel(), //
          m.getRegisteredDate());
    }
  }
}
