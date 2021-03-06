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
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<h2>Member-Delete 을 봅시다~</h2>


<h3>삭제 회원 상세 정보</h3>




<div class="container">
    <table class="table">
        <tr>
            <th>id</th>
            <th>memberId</th>
            <th>memberPassword</th>
            <th>memberName</th>
            <th>memberAge</th>
            <th>memberPhone</th>
        </tr>
        <tr>
            <td> ${detailMember.id}</td>
            <td> ${detailMember.memberId}</td>
            <td> ${detailMember.memberPassword}</td>
            <td> ${detailMember.memberName}</td>
            <td> ${detailMember.memberAge}</td>
            <td> ${detailMember.memberPhone}</td>
        </tr>
    </table>
</div>

<h2>삭제 후 회원 리스트</h2>

<div class="container">
    <table class="table">
        <tr>
            <th>id</th>
            <th>memberId</th>
            <th>memberPassword</th>
            <th>memberName</th>
            <th>memberAge</th>
            <th>memberPhone</th>
            <th>조회</th>
            <th>삭제</th>
        </tr>
        <c:forEach var="member" items="${memberList}">
            <tr>
                <td>${member.id}</td>
                <td>${member.memberId}</td>
                <td>${member.memberPassword}</td>
                <td>${member.memberName}</td>
                <td>${member.memberAge}</td>
                <td>${member.memberPhone}</td>
                <td><a href="/member-detail?id=${member.id}">조회</a></td>
                <td><a href="/member-delete?id=${member.id}">삭제</a></td>
                    <%--                클릭한 회원의 정보를 DB에서 가져와서 detail.jsp 에 출력--%>
            </tr>
        </c:forEach>
    </table>
</div>

<br><br><br>

<a href="member-index">멤버 인덱스로 이동</a>


</body>
</html>
