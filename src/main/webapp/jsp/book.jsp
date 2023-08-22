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
</head>
<body>

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

</body>
</html>
