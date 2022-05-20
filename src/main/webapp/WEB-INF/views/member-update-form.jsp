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
<h2>This is Member-Update :)</h2>
<div class="container">
    <form action="/member-update" method="post" name="memberUpdateForm">
        id : <input class="form-control mb-2" type="text" name="Id" value="${updateMember.id}" readonly>
        memberId : <input class="form-control mb-2" type="text" name="memberId" value="${updateMember.memberId}"
                          readonly>
        memberName : <input class="form-control mb-2" type="text" name="memberName" value="${updateMember.memberName}"
                            readonly>
        memberPassword : <input class="form-control mb-2" type="text" name="memberPassword" placeholder="비번 입력하세요"
                                id="pwConfirm">
        memberAge : <input class="form-control mb-2" type="text" name="memberAge" value="${updateMember.memberAge}"
                           readonly>
        memberPhone : <input class="form-control mb-2" type="text" name="memberPhone"
                             value="${updateMember.memberPhone}" id="idUpdateMemberPhone">
        <input  type="button" value="update" onclick="update()">

    </form>
</div>


<script>
    const update = () => {
        const pwConfirm = document.getElementById("pwConfirm").value;
        const pwDB =
        ${updateMember.memberPassword}

        // 비밀번호 일치하면 update 완료 로 컨트롤러로 이동
        // 일치하지 않으면 얼럿 ! 마! 니 틀렸다!!

        if (pwDB == pwConfirm) {
            memberUpdateForm.submit(); //해당 폼을 submit 하는 함수
        } else {
            alert("비번이 틀렸습니다.")
        }
    }

</script>


</body>
</html>
