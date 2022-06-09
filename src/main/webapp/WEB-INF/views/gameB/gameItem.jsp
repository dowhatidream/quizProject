<%--
  Created by IntelliJ IDEA.
  User: lsy
  Date: 2022/06/04
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String gId = null;
  if (request.getAttribute("gId") != null) {
    gId = (String) request.getAttribute("gId");
  }
%>
<html>
<head>
    <title>게임아이템</title>
    <script>
      function insertGameItem() {
        $.ajax({
          url: "/gameB/insertGameItem.ajax",
          type: "POST",
          data: $("#gameItemForm").serialize(),
          dataType: "json",
          contentType: "application/x-www-form-urlencoded;charset=UTF-8",
          success: function (data) {
            alert(data.msg);
            let serial = $("#serial");
            $("#serial").val(serial++);

          },
          error: function (data) {
            alert(data.msg);
          }
        });
      }

      function goGameItem(gId) {
        location.href = "/gameB/gameItem.do?gId=" + gId;
      }
    </script>
    <script src="/js/jquery-3.6.0.js"></script>
</head>
<body>

<form name="gameItemForm" id="gameItemForm">
    <input type="hidden" id="serial" name="serial" value="1">
    <input type="hidden" id="gId" name="gId" value="${gId}">

    <label>질문</label>
    <input type="text" name="subTitle" id="subTitle"><br>

    <label>첫번째 선택지</label>
    <input type="text" id="content" name="content">
    <input type="text" id="score" name="score" placeholder="점수"><br>

<%--    <label>두번째 선택지</label>--%>
<%--    <input type="text" id="content2" name="content2">--%>
<%--    <input type="text" id="score2" name="score2" placeholder="점수"><br>--%>

    <button type="button" onclick="insertGameItem()">문제 완성</button>

    <c:if test="${order eq 3}">
      <button type="button">퀴즈 완성</button>
    </c:if>

  </form>
</body>
</html>
