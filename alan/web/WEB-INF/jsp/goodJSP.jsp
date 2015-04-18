<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Java Beans for Goods</title>
</head>
<body>
<h2>Welcome</h2>
<jsp:useBean id="mybean" class="GoodBean.GoodBean" scope="page"></jsp:useBean>
<jsp:setProperty name="good" property="*"></jsp:setProperty>

<p>Good name:
    <jsp:getProperty name="good" property="name"/>
</p>

<p>Good quantity:
    <jsp:getProperty name="good" property="quantity"/>
</p>

<p>Barcode:
    <jsp:getProperty name="good" property="code"/>
</p>

<p>Type:
    <jsp:getProperty name="good" property="type"/>
</p>


</body>
</html>
