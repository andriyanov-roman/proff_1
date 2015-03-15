
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show goods</title>
</head>
<jsp:useBean id="goodinfo" class="test.bean.GoodsBean"></jsp:useBean>
<jsp:setProperty property="*" name="goodinfo"/>
<body>
<p>Goods Name:
  <jsp:getProperty name="goodinfo" property="name"/>
</p>
<p>Goods type:
  <jsp:getProperty name="goodinfo" property="type"/>
</p>
<p>Goods number:
  <jsp:getProperty name="goodinfo" property="number"/>
</p>
<p>Goods barcode:
  <jsp:getProperty name="goodinfo" property="barcode"/>
</p>
</body>
</html>
