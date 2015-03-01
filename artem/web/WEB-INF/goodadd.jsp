<%@ page import="shop.Good" %>
<%@ page import="shop.dao.GoodsDAO" %>
<%--
  Created by IntelliJ IDEA.
  User: Tatty
  Date: 22.02.2015
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="shop.*, java.util.*, java.io.*,shop.Good,shop.dao.GoodsDAO" contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Goods add</title>
</head>
<link rel="stylesheet" href="css/style.css">
<body>
<div>
    <form name="good" method="post" action="select">
        <p class="txt">Name of good:</p> <input class="entered" type="text" name="nameOfGood"><br/>

        <p class="txt">Type of good:</p> <input class="entered" type="text" name="typeOfGood"><br/>

        <p class="txt">Barcode of good:</p><input class="entered" type="text" name="barcodeOfGood"><br/>

        <p class="txt">Number of good:</p><input class="entered" type="text" name="numberOfGood"><br/>
        <input type="submit" value="Submit" class="button"/>
    </form>
</div>

</body>
</html>
