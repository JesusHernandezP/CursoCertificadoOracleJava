<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <c:url value="/css/theme/jquery-ui-1.10.4.custom.css" var="jqueryStyles"
           /><c:url value="/css/main.css" var="mainCss"
           /><c:url value="/js/jquery-1.10.2.js" var="jqueryJS"
           /><c:url value="/js/jquery-ui-1.10.4.custom.min.js" var="jqueryUIJS"
           />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSConsole</title>
    <link rel="stylesheet" href="${jqueryStyles}">
    <link rel="stylesheet" href="${mainCss}">
    <style>
      h3{margin: 0; padding: 0;}
    </style>
    <script src="${jqueryJS}"></script>
    <script src="${jqueryUIJS}"></script>
    <script>
      $(function() {
        $(".button").each(function() {
          $(this).button({disabled: !$(this).attr("data-link")}).click(function() {
            window.location.href = this.getAttribute("data-link");
          });
        })
        //$(".accordion").accordion({collapsible: true});
      });
    </script>
  </head>
  <body class="ui-widget" style="font-size: 8pt;">
    <h1>JavaScript Console</h1>
    <c:forEach items="${demoList.demos}" var="demo">
      <div class="accordion">
        <div class="ui-widget-header ui-corner-all">
          <h3 style="font-size: 2em;">${demo.title}</h3>
        </div>
        <div>
          <c:forEach items="${demo.demos}" var="item">
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
          </c:forEach>
        </div>
      </div>
    </c:forEach>
    <c:url value="lesson10/jQuery_ui/scripts/jquery-ui-1.11.1.custom/index.html" var="viewIndex"/>
    <div class="ui-widget-content">
      <div style="display: inline-block; vertical-align: top; padding-top: 3pt; padding-left: 2pt;">
        <span class="button" data-link="${viewIndex}"><span class="ui-icon ui-icon-triangle-1-e"></span></span>
      </div>
      <div style="display: inline-block">
        <span style="font-size: 1.7em;">jQuery UI Features Reference</span><br>
        Play with some features in jQuery UI from index.html file, provided by jQuery.
      </div>
    </div>
  </body>
</html>
