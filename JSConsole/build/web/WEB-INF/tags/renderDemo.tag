<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="item" required="true" type="com.oracle.html5.demoframework.Demo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags" %>
<c:url value="/edit/${item.path}" var="editUrl"
       /><c:url value="/view/${item.main}" var="viewUrl"
       /><c:url value="/revert/${item.path}" var="revertUrl"
       />
<div class="ui-widget-content" style="position: relative;">
  <div style="display: inline-block; vertical-align: top; padding-top: 3pt; padding-left: 2pt;">
    <span class="button" data-link="${editUrl}"><span class="ui-icon ui-icon-pencil"></span></span>
    <c:if test="${not item.runnable}">
      <span class="button"><span class="ui-icon ui-icon-triangle-1-e"></span></span>
    </c:if>
    <c:if test="${item.runnable}">
      <span class="button" data-link="${viewUrl}"><span class="ui-icon ui-icon-triangle-1-e"></span></span>
    </c:if>
  </div>
  <div style="display: inline-block">
    <span style="font-size: 1.7em;">${item.title}</span><br>
    ${item.desc}
  </div>
  <div style="display: inline-block; right: 0; top:4px; position: absolute;">
      <span class="button" data-link="${revertUrl}" title="Revert to Original"><span class="ui-icon ui-icon-arrowreturnthick-1-w"></span></span>
  </div>
</div>
<c:if test="${not item.demos.isEmpty()}">
  <c:forEach items="${item.demos}" var="demo">
    <myTags:renderDemo item="${demo}"/>
  </c:forEach>
</c:if>

