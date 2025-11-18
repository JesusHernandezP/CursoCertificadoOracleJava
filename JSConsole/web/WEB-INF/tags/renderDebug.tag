<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="item" required="true" type="com.oracle.html5.demoframework.Demo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags" %>
Title: <code>${item.title}</code><br/>
Description:<code>${item.desc}</code><br/>
Instructions: <code>${item.instructions}</code><br/>
Path: <code>${item.path}</code><br/>
Main: <code>${item.main}</code><br/>
PreviewHidden: <code>${item.previewHidden}</code><br/>
<c:if test="${not item.files.isEmpty()}">
  <c:forEach items="${item.files}" var="file">
    <div style="border-top: 1px solid #666666; border-bottom: 1px solid #cccccc; padding-left: 10px;">
      local:<code>${file.localFilePath}</code><br/>
      Original:<code>${file.originalPath}</code><br/>
      solution:<code>${file.solutionPath}</code><br/>
      name:<code>${file.name}</code><br/>
      hidden:<code>${file.hidden}</code><br/>
      readOnly:<code>${file.readOnly}</code><br/>
    </div>
  </c:forEach>
</c:if>
<c:if test="${not item.demos.isEmpty()}">
  <ul>
    <c:forEach items="${item.demos}" var="demo">
      <li><myTags:renderDebug item="${demo}"/></li>
      </c:forEach>
  </ul>
</c:if>

