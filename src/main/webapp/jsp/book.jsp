<%--
  Created by IntelliJ IDEA.
  User: Mihail
  Date: 19.08.2023
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Book</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>

<nav class="nav">
    <a class="nav-link disabled"><s:message code="label.head"/></a>
    <a class="nav-link" href="http://localhost:8080/mvc_war_exploded?lang=en"><s:message code="label.eng"/></a>
    <a class="nav-link" href="http://localhost:8080/mvc_war_exploded?lang=ru"><s:message code="label.rus"/></a>
</nav>


<form method="post" action="/mvc_war_exploded/">
    <input type="text" name="bookSearch"><br>
    <input type="submit" value="Search">
</form>

<table>
    <tr>
        <td>Author</td>
        <td>Book Name</td>
    </tr>
<c:forEach var="book" items="${bookSearch}" >
    <tr>
        <td>${book.author}</td>
        <td>${book.bookName}</td>
    </tr>
</c:forEach>
</table>

${error}
<sf:form action="book" method="post" modelAttribute="book">
    Author: <sf:input path="author"/><sf:errors path="author"/><br>
    Book: <sf:input path="bookName"/><sf:errors path="bookName"/><br>
    <sf:button>Save</sf:button>
</sf:form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
