<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
 <head>
   <title>Message page</title>
   <meta charset="utf-8">
 </head>
 <body>
<form action = <%=request.getContextPath() + "/api/message"%> method = "POST">
    <p>Message to: <input type="text" name="login" /></p>
    <p>Message content: <input type="text" name="message" /></p>
    <input type = "submit" value = "Send" />
  </form>

 </body>
</html>