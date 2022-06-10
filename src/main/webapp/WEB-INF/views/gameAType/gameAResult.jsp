<%--
  Created by IntelliJ IDEA.
  User: jeoungha
  Date: 2022/06/07
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function addTest(){
            $.ajax({
                url: "/gameAType/addTest.ajax",
                type: "POST",
                // data: $("#gameA").serialize(),
                dataType: "text",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                success: function (data) {
                    console.log("success");
                },
                errors: function (data) {
                    console.log("errors!");
                }
            })
        }
    </script>
</head>
<body>
  질문 처리됨.
  <br/>
  ${vo.title}
<input type="button" id="btn1" onclick="addTest()" value="가져오기">
</body>
</html>
