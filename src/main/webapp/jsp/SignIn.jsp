<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
 <head>
   <title>Sign In page</title>
   <meta charset="utf-8">
 </head>
 <body>
 <form action = <%=request.getContextPath() + "/api/login"%> method = "POST">
    <p>Login: <input type="text" name="login" /></p>
    <p>Password: <input type="text" name="password" /></p>

<input type = "submit" value = "Sign In" />
</form>
 </body>
</html>