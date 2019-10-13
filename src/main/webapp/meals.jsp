<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12.10.2019
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
    <table border="1" cols="4">
        <tr bgcolor='#87cefa'>
            <td>Date|Time</td>
            <td>Description</td>
            <td>Calories</td>
            <td>Excess</td>
        </tr>
        <c:forEach var="meal" items="${requestScope.allMeals}">
            <tr bgcolor='#ffffe0'>
                <td><c:out value="${formatterDateTime.format(parserDateTime.parse(meal.dateTime))}" /></td>
                <td width="100" align="right"><c:out value="${meal.description} " /></td>
                <td width="50" align="right"><c:out value="${meal.calories} " /></td>
                <td width="100" style="color: <c:out value="${meal.excess ? 'red': 'green'}"/>"><c:out value="${meal.excess ? 'exceeded': 'not exceeded'}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
