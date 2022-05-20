<%--
  Created by IntelliJ IDEA.
  User: prefe
  Date: 2022-05-17
  Time: 오후 2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <script src="../../resources/js/jquery.js"></script>

    <style>
        .container{
            max-width: 500px;
        }
    </style>

</head>

<body>


<h2>member-save-form</h2>
<div class="container">
    <form action="member-save" method="post">
        <input class="form-control mb-2" type="text" placeholder="memberId" name="memberId" onblur="duplicateIdCheck()" id="memberId">
        <span id="dupCheckResult"></span>
        <input class="form-control mb-2" type="text" placeholder="memberPassword" name="memberPassword">
        <input class="form-control mb-2" type="text" placeholder="memberName" name="memberName">
        <input class="form-control mb-2" type="text" placeholder="memberAge" name="memberAge">
        <input class="form-control mb-2" type="text" placeholder="memberPhone" name="memberPhone">
        <input type="submit" name="" id="" value="전송">
    </form>
</div>
</body>
<script>
const duplicateIdCheck = () => {
    const memberId = document.getElementById("memberId").value;
    const checkResult = document.getElementById("dupCheckResult");
    // ajax() : 사용
    $.ajax({
       type: "post", // http request method
        url: "member-duplicate-check", // 요청주소 (컨트롤러 주소값)
        data: {"memberId":memberId}, // 전송하는 파라미터
        dataType: "text", // 리턴받는 데이터 형식
        success : function (result){
           if(result == "OK"){
               checkResult.innerHTML = "사용 가능";
               checkResult.style.color = "green"
           }else{
               checkResult.innerHTML = "사용 불가";
               checkResult.style.color = "red"
           }
           alert("ajax 정상 동작")
        },
        error: function (){
           alert("오타체크")
        }


    });
    }
</script>
</html>
