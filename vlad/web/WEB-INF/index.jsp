<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Coffee Advisor Output</h2>
<c:forEach var="type" items="${types}">
    <c:out value="${type}"/>
    <br/>
</c:forEach>
</body>
</html>
