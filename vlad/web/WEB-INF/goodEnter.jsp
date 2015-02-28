<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<title>Enter good</title>
<meta charset="utf-8">
<link rel="stylesheet" href="goodEnter.css">
<body>
<div class="frm">
    <form name="goodForm" method="post" action="add">
        Good name: <input type="text" name="name"/> <br/>
        Quantity: <input type="text" name="quantity"/> <br/>
        Barcode: <input type="text" name="barcode"/> <br/>
        Type: <input type="text" name="type"/> <br/>

        <div class="btn"><input type="submit" value="Submit" class="button"/></div>
    </form>

</div>
</body>
</html>
