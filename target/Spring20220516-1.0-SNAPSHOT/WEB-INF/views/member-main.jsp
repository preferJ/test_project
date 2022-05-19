<%--
  Created by IntelliJ IDEA.
  User: prefe
  Date: 2022-05-16
  Time: 오후 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>This is Member-Main (로그인 성공)</h2>

로그인 회원 정보 : ${memberList}
세션에 담은 memberId : ${sessionScope.LoginMemberId}
세션에 담은 Id : ${sessionScope.LoginId}






</body>
</html>
