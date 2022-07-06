<%--
  Created by IntelliJ IDEA.
  User: prefe
  Date: 2022-05-16
  Time: 오후 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>This is Member Index</h2>

로그인 회원 정보 : ${memberList}<br>
세션에 담은 memberId : ${sessionScope.LoginMemberId}<br>
세션에 담은 Id : ${sessionScope.LoginId}<br>

<a href="/member-save-form">회원가입으로 이동</a> <br>
<a href="/member-login">로그인으로 이동</a> <br>
<a href="/member-list">회원 목록 보기</a> <br>
<a href="/member-main">회원 전용 페이지</a> <br>
<a href="/member-response-test1">ResponseBody1</a> <br>
<a href="/member-response-test2">ResponseBody2</a> <br>


</body>
</html>
