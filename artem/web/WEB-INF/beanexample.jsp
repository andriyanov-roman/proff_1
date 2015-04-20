<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 15.03.15
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>TestBean</title>
</head>
<jsp:useBean id="goodinfo" class="test.bean.GoodsBean" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="goodinfo"/>
<body>
<form name="goodinfo"  method="post" action ="<%= goodinfo.getPage()%>">
  Good Name: <input type="text" name="name"><br>
  Good Type: <input type="text" name="type"><br>
  Good Number: <input type="text" name="number"><br>
  Good Barcode: <input type="text" name="barcode"><br>
  <jsp:setProperty name="goodinfo" property="name"/>
  <jsp:setProperty name="goodinfo" property="type"/>
  <jsp:setProperty name="goodinfo" property="number"/>
  <jsp:setProperty name="goodinfo" property="barcode"/>
  <input type="submit" value="add">
</body>
</html>
