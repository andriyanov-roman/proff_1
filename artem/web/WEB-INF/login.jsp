<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 25.02.15
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<title>Log in</title>
<html>
<head>
</head>
<link rel="stylesheet" href="css/style.css">
<body>
<div>
    <form name="login" method="post" action="login">
        <p class="txt">Login:</p>  <input class="entered" type="text" name="username"/>
        <p class="txt"> Password:</p> <input type="password" name="password"/> <br/>
        <input type="submit" value="Submit" class="button"/>
    </form>
</div>

</body>
</html>
