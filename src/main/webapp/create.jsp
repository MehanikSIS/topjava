<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 08.02.2023
  Time: 00:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Update</title>


</head>
<body>
<h2 style="align-content: center">Edit Meal</h2>
<form method="post">
    <h3 style="align-content: center">Datetime: <input type="datetime-local" name="datetime"></h3>
    <h3 style="align-content: center">Description: <input type="text" name="description"></h3>
    <h3 style="align-content: center">Calories: <input type="number" name="calories"></h3>
    <input value="Save" type="submit">
    <button onclick="window.history.back()" type="button">Cancel</button>
</form>
</body>
</html>
