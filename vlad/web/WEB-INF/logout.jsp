<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<title>Goodbye</title>
<meta charset="utf-8">
<link rel="stylesheet" href="logout.css">
<body>
<div class="main">
   <h3> Goodbye, <%= session.getAttribute("name") %>! </h3>
</div>
</body>
</html>