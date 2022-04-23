<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>

<html>
 <head>
   <title>Sign In page</title>
   <meta charset="utf-8">
 </head>
 <body>
  <form action= "${pageContext.request.contextPath}/api/login" method="POST">
    <p>Login: <input type="text" name="login" /></p>
    <p>Password: <input type="text" name="password" /></p>
  </form>
  <form>
        <input type="submit" value="Sign In"></p>
  </form>
 </body>
</html>