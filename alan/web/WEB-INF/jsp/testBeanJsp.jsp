<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<title>Enter good</title>
<meta charset="utf-8">
<body>
<div class="frm">
    <form name="goodForm" method="post" action="goodJSP.jsp">
        Good name: <input type="text" name="name"/> <br/>
        Quantity: <input type="text" name="quantity"/> <br/>
        Barcode: <input type="text" name="barcode"/> <br/>
        Type: <input type="text" name="type"/> <br/>
        <input type="submit" value="register" class="button"/>
    </form>

</div>
</body>
</html>
