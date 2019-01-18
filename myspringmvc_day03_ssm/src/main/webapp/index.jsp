<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/1/15
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="account/findAll" >查询所有用户信息</a>

<form action="account/transfer" method="post">
    转出ID:<input type="text" name="sourceId"><br>
    转入ID:<input type="text" name="targetId"><br>
    转款金额：<input type="text" name="money"><br>
    <input type="submit" value="确认转账">
</form>
</body>
</html>
