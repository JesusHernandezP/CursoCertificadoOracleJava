<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSConsole Examples</title>
  </head>
  <body>
    <c:forEach items="${demoList.demos}" var="lesson">
      <c:if test="${lesson.hasPrintableDemos}">
        <h1>${lesson.title}</h1>
        <c:forEach items="${lesson.demos}" var="demo">
          <c:if test="${not demo.practice && demo.hasPrintableFiles}">
            <h2>${demo.title}</h2>
            <p>${demo.desc}</p>
            <c:forEach items="${demo.files}" var="file">
              <c:if test="${not file.hidden && not empty file.printedPath}">
                <h3>${file.originalPath}</h3>
                <pre>${fn:escapeXml(fileManager.getPrintVersion(file))}</pre>
              </c:if>
            </c:forEach>
          </c:if>
        </c:forEach>
      </c:if>
    </c:forEach>
  </body>
</html>
