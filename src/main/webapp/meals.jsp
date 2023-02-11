<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 05.02.2023
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2 align="center">Meals</h2>
<table style="border: black" border="1" align="center">
    <tr style="align-content: center">
        <td>
            Дата
        </td>
        <td>
            Описание
        </td>
        <td>
            Калории
        </td>
        <td></td>
        <td></td>
    </tr>

    <jsp:useBean id="listMeals" scope="request" type="java.util.List"/>
    <c:forEach var="meal" items="${listMeals}">


        <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo"/>
        <tr align="center" style="background-color: ${meal.excess ? 'red' : 'greenyellow'}">
            <td><fmt:parseDate value="${meal.dateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both"/>
                <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${parsedDateTime}"/>
            </td>
            <td>${meal.description}
            </td>
            <td>${meal.calories}
            </td>
            <td><a href="meals?action=update&id=${meal.id}">Update</a></td>
            <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<p><a href="meals?action=insert">Add Meal</a> </p>
</body>
</html>
