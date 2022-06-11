<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jeoungha
  Date: 2022/06/10
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>선택한 게임 플레이</title>
</head>
<body>
<h2>${vo.title}</h2>
${vo.intro}<br/>
<form id="playA" action="addPlay.do">
<%--    <h4>문제: ${item_vo}</h4><br/>--%>
<%--    <c:forEach items="${item_vo}" var="item_vo">--%>
<%--        ${item_vo.subtitle}<br/>--%>
<%--    </c:forEach>--%>
<%--    <br/>--%>
<%--    대답:--%>
<%--    <input type="text">--%>
    1))<br/>
    ${item_vo0.subTitle}
    <br/><br/>

    2))<br/>
    ${item_vo1}
</form>
</body>
</html>
