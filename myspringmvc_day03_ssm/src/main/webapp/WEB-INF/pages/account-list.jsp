<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/1/15
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果显示界面</title>
</head>
<body>
    <c:if test="${!empty requestScope.accounts}">
        <center>
            <table border="1" cellspacing="0" cellpadding="10">
                <thead>
                <th>ID</th>
                <th>NAME</th>
                <th>MONEY</th>
                </thead>
                <tbody>
                <c:forEach var="account" items="${requestScope.accounts}">
                    <tr>
                        <td>${account.id}</td>
                        <td>${account.name}</td>
                        <td>${account.money}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </center>
    </c:if>
</body>
</html>
