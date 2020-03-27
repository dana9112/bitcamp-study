// Apache HttpComponents 사용법 : HttpClient5 - Get 요청하기 IV
package com.eomcs.httpcomponents.client;

import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;

public class Exam0140 {

  public static void main(String[] args) throws Exception {
    // 더 간결하게 HTTP 요청하기 (융통성은 조금 떨어짐)
    // => httpclient-fluent 라이브러리를 추가해야 한다.
    Content result = Request.get("https://daum.net").execute().returnContent();
    System.out.println(result.toString());
  }

}
