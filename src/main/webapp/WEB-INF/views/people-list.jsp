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
<h2>List.jsp</h2>

<c:forEach var="people" items="${peopleList}">
    ${people.name}
    ${people.age}<br>
</c:forEach>


</body>
</html>
