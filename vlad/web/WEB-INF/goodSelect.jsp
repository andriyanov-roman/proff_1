<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.ResultSetMetaData" %>
<%@ page import="shop.db_access.GoodDAO" %>
<%@ page import="shop.db_access.DBAccessProcessor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<title>Goods</title>
<meta charset="utf-8">
<link rel="stylesheet" href="goodSelect.css">
<body>
<div class="tbl">
<table width="59%" border="1">
    <%
        ResultSet r = DBAccessProcessor.getDBConnection().prepareStatement(GoodDAO.selectAll).executeQuery();
        ResultSetMetaData metaData = r.getMetaData();
        while(r.next())
        {
    %>
    <tr>
        <%
            for(int i = 1; i<=metaData.getColumnCount();i++)
            { %>
        <td>
            <%= r.getString(i)%>
        </td>
        <%
            }
        %>
    </tr>
    <%
        }
    %>
</table>

    <form action="menu.jsp">
    <div class="btn"><input type="submit" value="Back" class="button"/></div></form></div>
</body>
</html>