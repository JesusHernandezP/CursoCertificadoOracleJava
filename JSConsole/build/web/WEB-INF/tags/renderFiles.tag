<%@tag pageEncoding="UTF-8"%>
<%@attribute name="item" required="true" type="com.oracle.html5.demoframework.FileView"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags" %>
<li>
  <c:if test="${item.directory}">
    <span class="ui-icon ui-icon-folder-open" style="display: inline-block;"></span>
  </c:if><c:if test="${not item.directory}">
    <span class="ui-icon ui-icon-document" style="display: inline-block;"></span>
  </c:if>
  ${item.name}
  <c:if test="${not empty item.files}">
    <ul>
      <c:forEach items="${item.files}" var="file">
        <myTags:renderFiles item="${file}"/>
      </c:forEach>
    </ul>
  </c:if>
</li>