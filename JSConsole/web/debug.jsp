<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <c:url value="/css/theme/jquery-ui-1.10.4.custom.css" var="jqueryStyles"
           /><c:url value="/css/main.css" var="mainCss"
           />
    <link rel="stylesheet" href="${jqueryStyles}">
    <link rel="stylesheet" href="${mainCss}">
  </head>
  <body>
    <h1>Debug!</h1>
    <ul>
      <c:forEach items="${demoList.demos}" var="demo">
        <li><myTags:renderDebug item="${demo}"/></li>
      </c:forEach>
    </ul>
  </body>
</html>
