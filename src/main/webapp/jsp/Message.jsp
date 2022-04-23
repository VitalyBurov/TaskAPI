<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>

<html>
 <head>
   <title>Message page</title>
   <meta charset="utf-8">
 </head>
 <body>
  <form action= "${pageContext.request.contextPath}/api/login" method="POST">
    <p>Message to: <input type="text" name="login" /></p>
    <p>Message content: <input type="text" name="message" /></p>
  </form>
  <form>
        <input type="submit" value="Send"></p>
        </form>
 </body>
</html>