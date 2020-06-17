<%--
  Created by IntelliJ IDEA.
  User: Dinh Phu
  Date: 6/16/2020
  Time: 1:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>SQL Statement</h1>
    <%
      String sqlStatement=request.getParameter("sqlStatement");
      if (sqlStatement==null){
        sqlStatement="select * from customers";
      }
    %>
  <p>Enter an SQL statement and click to the button</p>
    <form action="get_sql" method="POST">
      <textarea name="sqlStatement" id="" cols="30" rows="10"><%=sqlStatement %></textarea>
      <br>
      <button>Execute</button>
    </form>
    <p>Sql results: </p>
    ${sqlResult}
  </body>
</html>
