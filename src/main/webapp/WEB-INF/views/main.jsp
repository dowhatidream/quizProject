<%--
  Created by IntelliJ IDEA.
  User: lsy
  Date: 2022/05/15
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    session = request.getSession();
    String id = (String) session.getAttribute("id");
%>
<html>
<head>
    <title>메인화면</title>
    <script>
        function goLogin() {
            location.href = "/user/login.do";
        }

        function goGameB() {
            location.href = "/gameB/game.do";
        }

        function goGameA() {
            location.href = "/gameAType/gameACreate.do";
        }

        function goPlayGameA() {
            location.href = "/gameAType/gameAResult.do";
        }

    </script>
</head>
<body>
    <h1>메인화면입니다!</h1>
    <p>현재 로그인 유저 정보:
        <c:if test="${not empty id}">${id}</c:if>
        <c:if test="${empty id}">없음</c:if>
    </p>
    <button type="button" onclick="goLogin()">로그인화면</button>
    <br>
    <button type="button" onclick="goGameB()">게임하러 가기</button>
    <br>
    <button type="button" onclick="goGameA()">게임A생성하러 가기</button>
    <br>
    <button type="button" onclick="goPlayGameA()">게임A하러 가기</button>
</body>
</html>
