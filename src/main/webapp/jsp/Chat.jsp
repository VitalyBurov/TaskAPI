<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>

<html>
 <head>
   <title>Chat page</title>
   <meta charset="utf-8">
 </head>
 <body>
      <c:choose>
          <c:when test="${messages.size() > 0}">
              <p>Your messages:</p></br>
              <c:forEach var="message" items="${messages}">
              <p><c:out value="${message}"/></p>
              </c:forEach>
          </c:when>
          <c:otherwise>
              <p>No massages for you!</p>
          </c:otherwise>
      </c:choose>
 </body>
</html>