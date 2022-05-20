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
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
</head>
<body>
<h2>This is Member-Main (로그인 성공)</h2><br>

로그인 회원 정보 : ${memberList} <br>
세션에 담은 memberId : ${sessionScope.LoginMemberId} <br>
세션에 담은 Id : ${sessionScope.LoginId}<br>
<a href="member-index">멤버 인덱스로 이동</a><br>
<br><br><br>
<button class="btn btn-primary" onclick="location.href='/member-update-form'">주소 호출 방식 수정</button>
<br><br><br>
<button class="btn btn-danger" onclick="memberUpdateForm()">함수 호출 방식 수정</button>

<script>
    // function memberUpdateForm(){
    //
    // }

    const memberUpdateForm = () =>{
        location.href="/member-update-form"
    }

</script>


</body>
</html>
