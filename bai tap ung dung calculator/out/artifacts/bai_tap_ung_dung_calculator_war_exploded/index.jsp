<%--
  Created by IntelliJ IDEA.
  User: Dinh Phu
  Date: 6/17/2020
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="calculator" method="POST">
    <fieldset>
      <legend>Calculator</legend>
      <label>First Operand</label>
      <input type="text" name="first_operand"><br>
      <label>Operation</label>
      <select name="operation" >
        <option value="add">Add</option>
        <option value="sub">Sub</option>
        <option value="multiple">Mul</option>
        <option value="divide">Div</option>
      </select><br>
      <label>Second Operand</label>
      <input type="text" name="second_operand"><br>
      <button>Submit</button>
    </fieldset>
  </form>
  <p>Result is: ${result}</p>
  </body>
</html>
