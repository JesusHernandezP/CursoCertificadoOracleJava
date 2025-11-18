<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Editing: ${editor.selected.title}</title>
    <c:url value="/css/theme/jquery-ui-1.10.4.custom.css" var="jqueryStyles"
           /><c:url value="/css/codemirror.css" var="codemirrorCss"
           /><c:url value="/css/show-hint.css" var="showHintCss"
           /><c:url value="/css/main.css" var="mainCss"
           /><c:url value="/css/editor.css" var="editorCss"
           /><c:url value="/css/layout.css" var="layoutCss"
           /><c:url value="/js/jquery-1.10.2.js" var="jqueryJS"
           /><c:url value="/js/jquery-ui-1.10.4.custom.min.js" var="jqueryUIJS"
           /><c:url value="/js/jquery.layout.js" var="layoutJS"
           /><c:url value="/js/codemirror.js" var="codemirrorJs"
           /><c:url value="/js/mode/htmlmixed/htmlmixed.js" var="cmModeHtmlMixed"
           /><c:url value="/js/mode/javascript/javascript.js" var="cmModeJS"
           /><c:url value="/js/mode/css/css.js" var="cmModeCss"
           /><c:url value="/js/mode/xml/xml.js" var="cmModeXml"
           /><c:url value="/js/mode/clike/clike.js" var="cmModeCLike"
           /><c:url value="/js/mode/vbscript/vbscript.js" var="cmModeVbs"
           /><c:url value="/js/addon/fold/xml-fold.js" var="cmXmlFold"
           /><c:url value="/js/addon/hint/show-hint.js" var="cmHintShow"
           /><c:url value="/js/addon/hint/css-hint.js" var="cmHintCss"
           /><c:url value="/js/addon/hint/html-hint.js" var="cmHintHtml"
           /><c:url value="/js/addon/hint/javascript-hint.js" var="cmHintJs"
           /><c:url value="/js/addon/edit/closebrackets.js" var="cmEditCloseBracket"
           /><c:url value="/js/addon/edit/closetag.js" var="cmEditCloseTag"
           /><c:url value="/js/addon/edit/matchbrackets.js" var="cmEditBrackets"
           /><c:url value="/js/addon/edit/matchtags.js" var="cmEditTags"
           /><c:url value="/js/editor.js" var="editorJs"
           /><c:url value="/edit" var="editLink"
           /><c:url value="/solution" var="solutionLink"
           /><c:url value="/view" var="viewLink"
           /><c:url value="/" var="homeUrl"
           /><c:url value="/images/back.svg" var="backImgUrl"
           /><c:url value="/view/${editor.selected.main}" var="viewUrl"/>
    <link rel="stylesheet" href="${jqueryStyles}">
    <link rel="stylesheet" href="${codemirrorCss}">
    <link rel="stylesheet" href="${showHintCss}">
    <link rel="stylesheet" href="${mainCss}">
    <link rel="stylesheet" href="${editorCss}">
    <link rel="stylesheet" href="${layoutCss}">
    <script>
      var jspVars = {
        editLink: "${editLink}",
        viewLink: "${viewLink}",
        homeLink: "${homeUrl}",
        solutionLink: "${solutionLink}"
      };
    </script>  
    <script src="${jqueryJS}"></script>
    <script src="${jqueryUIJS}"></script>
    <script src="${layoutJS}"></script>
    <script src="${codemirrorJs}"></script>
    <script src="${cmModeXml}"></script>
    <script src="${cmModeJS}"></script>
    <script src="${cmModeCss}"></script>
    <script src="${cmModeVbs}"></script>
    <script src="${cmModeHtmlMixed}"></script>
    <script src="${cmModeCLike}"></script>
    <script src="${cmXmlFold}"></script>
    <script src="${cmHintShow}"></script>
    <script src="${cmHintCss}"></script>
    <script src="${cmHintHtml}"></script>
    <script src="${cmHintJs}"></script>
    <script src="${cmEditCloseBracket}"></script>
    <script src="${cmEditCloseTag}"></script>
    <script src="${cmEditBrackets}"></script>
    <script src="${cmEditTags}"></script>
    <script src="${editorJs}"></script>
  </head>
  <body class="ui-widget">
    <div class="ui-layout-north" style="margin:0; padding:0"><div class="toolbar ui-widget-header ui-corner-all" style="margin:0; padding:0">
        <button id="backButton" title="Back">
          <span class="ui-icon ui-icon-triangle-1-w"></span>
        </button>
        <button id="playButton" title="Run">
          <span class="ui-button-icon-primary ui-icon ui-icon-play"></span>
        </button>
        <button id="infoButton" title="Info">
          <span class="ui-button-icon-primary ui-icon ui-icon-info"></span>
        </button>
        <button id="solutionButton" title="View Solution">
          <span class="ui-button-icon-primary ui-icon ui-icon-comment"></span>
        </button>
        <button id="revertButton" title="Revert to Original">
          <span class="ui-button-icon-primary ui-icon ui-icon-arrowreturnthick-1-w"></span>
        </button>
        <span style="font-size: 1.5em;">&nbsp;${editor.selected.title} &nbsp;</span>
      </div></div>

    <div class="ui-layout-center" style="padding:0;margin:0">
      <div id="tabs" style="padding:0;margin:0">
        <ul>
          <c:forEach items="${editor.selected.visibleFiles}" var="file" varStatus="stats">
            <li>
              <a href="#tabs-${stats.index}">${file.name}</a>
              <c:if test="${file.readOnly}"><span class="ui-icon ui-icon-locked" style="display: inline-block"></span></c:if>
              <c:if test="${not file.readOnly}"><span class="ui-icon ui-icon-pencil" style="display: inline-block"></span></c:if>
              </li>
          </c:forEach>
        </ul>
        <c:forEach items="${editor.selected.visibleFiles}" var="file" varStatus="stats">
          <c:if test="${file.readOnly}"><c:set var="listedFileStyle" value="read-only-file"/></c:if>
          <c:if test="${not file.readOnly}"><c:set var="listedFileStyle" value="file"/></c:if>
          <div id="tabs-${stats.index}" class="fileContainer" style="padding:0; margin:0;">
            <div>${file.originalPath}</div>
            <div class="${listedFileStyle}">
              <input type="hidden" class="fileName" value="${file.originalPath}">
              <textarea class="fileEditor">${fn:escapeXml(fileManager.getContent(file))}</textarea>
              <c:if test="${not empty file.solutionPath}">
                <div class="solution" title="Solution: ${file.name}"><pre>${fn:escapeXml(fileManager.getSolution(file))}</pre></div>
                  </c:if>
          </div>
        </div>
        </c:forEach>
      </div>
    </div>
    
    <c:if test="${editor.selected.previewHidden && empty editor.selected.instructions}"><c:set var="previewClazz" value="preview-hidden"/></c:if>
    <c:if test="${not editor.selected.previewHidden || not empty editor.selected.instructions}"><c:set var="previewClazz" value="ui-layout-east"/></c:if>

    <div id="previewArea" class="${previewClazz}" style="margin:0; padding:0px;">
      <div id="rightTabs" style="margin:0; padding:0">
        <c:if test="${not editor.selected.previewHidden || not empty editor.selected.instructions}">
        <ul id="rightTabsNav">
          <c:if test="${not editor.selected.previewHidden}">
          <li><a href="#iframeRunner">Preview</a></li>
          </c:if>
          <c:if test="${not empty editor.selected.instructions}">
          <li><a href="#instructions">Instructions</a></li>
          </c:if>
        </ul>
        </c:if>
        <c:if test="${not editor.selected.previewHidden}"><c:set var="displayPreview" value=""/></c:if>
        <c:if test="${editor.selected.previewHidden}"><c:set var="displayPreview" value="display:none;"/></c:if>
        <div id="previewArea" style="${displayPreview}">
          <iframe src="${viewUrl}" id="iframeRunner"></iframe>
        </div>
        <c:if test="${not empty editor.selected.instructions}">
        <div id="instructions">${fileManager.getInstructions(editor.selected)}</div>
        </c:if>
      </div>
    </div>

    <div class="ui-layout-south" style="padding:0; margin: 0;">
      <div class="toolbar ui-widget-header ui-corner-all" style="padding:0;margin:0">
        <button id="saveAll">
          <span class="ui-icon ui-icon-play" style="display: inline-block"></span> Run
        </button>
        <button id="clearConsole">
          <span class="ui-icon ui-icon-document" style="display: inline-block"></span> Clear Console
        </button>
        <button id="viewButton">
          <span class="ui-icon ui-icon-newwin" style="display: inline-block"></span> Run in New Window
        </button>
        <a href="${viewUrl}" target="viewWindow" id="viewLink" style="display:none">link</a>
      <div id="bottomTabs" style="padding:0;margin:0">
        <ul>
          <li><a href="#debugConsole">Console</a></li>
          <li><a href="#fileList">Files</a></li>
        </ul>

        <div id="debugConsole"></div>

        <div id="fileList" style="padding:0;margin:0">
          <ul style="padding:0;margin:0">
              <c:forEach items="${editor.selected.fileViewRoot.files}" var="viewFile">
                <myTags:renderFiles item="${viewFile}"/>
              </c:forEach>
          </ul>
        </div>
      </div>
    </div>
  </body>
</html>
