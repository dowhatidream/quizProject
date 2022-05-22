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
    System.out.println("세션:: " + session.getAttributeNames());
    String id = (String) session.getAttribute("id");
%>
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
    <h1>메인화면입니다!</h1>
    <p>현재 로그인 유저 정보:
        <c:if test="${not empty id}">${id}</c:if>
        <c:if test="${empty id}">없음</c:if>
    </p>
    <button type="button" onclick="goLogin()">로그인화면</button>
</body>
</html>
