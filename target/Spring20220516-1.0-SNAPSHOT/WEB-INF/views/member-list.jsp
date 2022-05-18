<%--
  Created by IntelliJ IDEA.
  User: prefe
  Date: 2022-05-18
  Time: 오후 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>member List 를 봅시다~</h2>


<c:forEach var="member" items="${memberList}">
    ${member.memberId}
    ${member.memberPassword}
    ${member.memberName}
    ${member.memberAge}
    ${member.memberPhone}

</c:forEach>


</body>
</html>
