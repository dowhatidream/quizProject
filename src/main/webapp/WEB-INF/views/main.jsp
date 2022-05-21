<%--
  Created by IntelliJ IDEA.
  User: lsy
  Date: 2022/05/15
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메인화면</title>
    <script>
        function goLogin() {
            location.href = "/user/login.do";
        }

    </script>
</head>
<body>
    <h1>첫번째 메인화면입니다!</h1>
    <button type="button" onclick="goLogin()">로그인화면</button>
</body>
</html>
