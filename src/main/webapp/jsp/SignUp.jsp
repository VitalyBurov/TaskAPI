<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>

<html>
 <head>
   <title>Sign Up page</title>
   <meta charset="utf-8">
 </head>
 <body>
<form action = <%=request.getContextPath() + "/api/user"%> method = "POST">    <p>Login: <input type="text" name="login" /></p>
    <p>Password: <input type="text" name="password" /></p>
    <p>Last name: <input type="text" name="lastName" /></p>
    <p>First name: <input type="text" name="firstName" /></p>
    <p>Birthday: <input type="date" name="dateOfBirthday" /></p>
    </form>
      <form>
       <input type="submit" value="Sign Up"></p>
      </form>
 </body>
</html>