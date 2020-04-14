<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<h1>JSTL - c:if</h1>
<pre>
- 조건문을 만든다.
</pre>

<c:set var="name" value="홍길동"/><!-- session, application ... 이라고 지정하지 않을 경우는 page를 기본 값으로 한다.-->
<c:set var="age" value="16"/>
<c:set var="gender" value="man"/>

<c:if test="${not empty name}">
    <p>${name}님 환영합니다!
</c:if>
<c:if test="${age < 19}">
    <p>미성년입니다.</p>
</c:if>
<c:if test="${age >= 19}">
    <p>성년입니다.</p>
</c:if>

<hr>

<h2>조건문의 결과를 보관소에 저장하기</h2>
<pre>
var 속성으로 변수이름을 설정하면, 조건문의 테스트 결과는 지정된 이름으로 보관소에 저장된다.
</pre>
<c:if test="${gender == 'woman'}" var="r1"/>
${r1}<br>
${pageScope.r1 ? "여성" : "남성"}<br><!-- 조건 연산자:el => 값이 true이면 앞에 "여성" / false이면 "남성"자리 출력 -->

</body>
</html>












