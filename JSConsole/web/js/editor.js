$(function() {
  var codeMirrors = [];
  var layout = $('body').layout({
    north: {resizable: false, closable: false, spacing_open: 0, size: 40},
    south: {size: 220, onresize: resizePanes},
    east: {size: "50%", onresize: resizePanes, maskContents:true},
    center: {onresize: resizePanes},
    enableCursorHotkey: false
  });

  if (document.getElementById("rightTabsNav")) {
    $("#rightTabs").tabs({
      collapsible: false});
    eastPadding = 150;
  }


  function resizePanes(name) {
    if (name === "south") {
      $("#debugConsole").height(layout.panes.south.height() - 120);
      $("#fileList").height(layout.panes.south.height() - 120);
    }
    if (name === "east") {
      $("#iframeRunner").height(layout.panes.east.height() - 60);
      $("#iframeRunner").width($("#previewArea").width());
      $("#instructions").height(layout.panes.east.height() - 70);
    }
    if (name === "center") {
      $(".fileContainer").height(layout.panes.center.height() - 50);
      $(".read-only-file").height(layout.panes.center.height() - 70);
      $(".file").height(layout.panes.center.height() - 70);
    }
  }

  $("#bottomTabs").tabs({
    collapsible: false});


  var selectedTab;
  $(".file").each(function() {
    var solutionDiv = $(this).children(".solution");
    solutionDiv.dialog({autoOpen: false, width: "auto"});
    var fileEditor = $(this).children(".fileEditor");
    var fileName = $(this).children(".fileName").val();
    var cmOptions = getOptions(fileName);
    var codeMirror = CodeMirror.fromTextArea(fileEditor[0], cmOptions);
    codeMirrors.push(codeMirror);
    $(this).data("fileName", fileName);
    $(this).data("codeMirror", codeMirror);
    this.IDE_save = function() {
      $(this).data("codeMirror").save();
      save($(this).children(".fileEditor").val(), $(this).children(".fileName").val());
    };
    this.IDE_revert = function() {
      if (confirm("Are you sure you want to revert the file?")) {
        save("", fileName);
        $.ajax({
          url: jspVars.viewLink + fileName,
          async: false,
          success: function(data) {
            codeMirror.setValue(data);
            codeMirror.save();
          }
        });
      }
    };
    if (solutionDiv.length > 0) {
      this.IDE_showSolution = function() {
        solutionDiv.dialog("open");
      };
    } else {
      this.IDE_showSolution = undefined;
    }
  });
  $(".read-only-file").each(function() {
    var fileName = $(this).children(".fileName").val();
    var cmOptions = getOptions(fileName);
    cmOptions.readOnly = "true";
    var fileEditor = $(this).children(".fileEditor");
    CodeMirror.fromTextArea(fileEditor[0], cmOptions);
  });
  $("#saveAll").button().click(function() {
    saveAll();
  });
  $("#playButton").button().click(function() {
    saveAll();
  });
  $("#viewButton").button().click(function() {
    $("#viewLink")[0].click();
  });
  $("#clearConsole").button().click(function() {
    document.getElementById("debugConsole").innerHTML = "";
  });
  var saveAll = function() {
    $(".file").each(function() {
      $(this)[0].IDE_save();
    });
    document.getElementById("iframeRunner").contentDocument.location.reload(true);
  };
  $("#backButton").button().click(function() {
    window.location.href = jspVars.homeLink;
  });
  $("#infoButton").button();
  $("#solutionButton").button({disabled: true}).click(function() {
    selectedTab.IDE_showSolution();
  });
  $("#revertButton").button({disabled: true}).click(function() {
    selectedTab.IDE_revert();
  });
  $("#stopButton").button().click(function(){
    exit();
  });

  $("#tabs").tabs({
    collapsible: false,
    activate: function(event, ui) {
      selectedTab = ui.newPanel.children(".file")[0];
      $("#solutionButton").button("option", "disabled", selectedTab === undefined || selectedTab.IDE_showSolution === undefined);
      $("#revertButton").button("option", "disabled", selectedTab === undefined || selectedTab.IDE_revert === undefined);
    },
    create: function(event, ui) {
      selectedTab = ui.panel.children(".file")[0];
      $("#solutionButton").button("option", "disabled", selectedTab === undefined || selectedTab.IDE_showSolution === undefined);
      $("#revertButton").button("option", "disabled", selectedTab === undefined || selectedTab.IDE_revert === undefined);
    }
  });

  $(".solutions").dialog({
    autoOpen: false
  });

  $("#sidebar").accordion({
    heightStyle: "content"
  });


  resizePanes("south");
  if (layout.panes.east) {
    resizePanes("east");
  }
  resizePanes("center");

});
function save(content, fileName) {
  $.ajax({
    url: jspVars.editLink + fileName,
    async: false,
    data: content,
    contentType: 'text/plain',
    type: "POST"
  });
}
function endsWith(str, suffix) {
  return str.indexOf(suffix, str.length - suffix.length) !== -1;
}

function setDebugConsole() {
  var iframe = document.getElementById("iframeRunner");
  var iDocument = (iframe.contentWindow || iframe.contentDocument);
  var iconsole = iDocument.console;
  doLog('<hr>');
  function logMeThis(fn1, fn2, console) {
    return function(message) {
      fn1.call(console, message);
      fn2.call(console, message);
    };
  }
  iconsole.log = logMeThis(iconsole.log, elementLog, iconsole);
  iconsole.debug = logMeThis(iconsole.debug, elementLog, iconsole);
  iconsole.info = logMeThis(iconsole.info, elementLog, iconsole);
  iconsole.error = logMeThis(iconsole.error, elementLog, iconsole);

  function elementLog(message) {
    var err = new Error('');

    //IE
    if (!err.stack) {
      try {
        throw err;
      } catch (e) {
        err = e;
      }
    }
    var log = message + '<br>';
    if (err.stack) {
      console.log(err.stack);
      var stack = err.stack.split('\n');
      while (stack.length > 0 && stack[0].trim() === "") {
        stack.splice(0, 1);
      }
      while (stack.length > 0 && stack[stack.length - 1].trim() === "") {
        stack.pop();
      }
      //replace(/^[^\(]+?[\n$]/gm, '')
      //        .replace(/^\s+at\s+/gm, '')
      //        .replace(/^Object.<anonymous>\s*\(/gm, '{anonymous}()@')
      if (stack.length > 0) {
        var lastItem = stack[stack.length - 1];
        lastItem = lastItem.substring(lastItem.lastIndexOf('/'));
        if (lastItem.indexOf(':') !== -1) {
          var lineItems = lastItem.split(":");
          log = "[" + lineItems[0] + ":" + lineItems[1] + "] " + log;
        } else {
          log = "[" + lastItem + "] " + log;
        }
      }
    }
    doLog(log);
  }

  function doLog(message) {
    var debugConsole = $('#debugConsole');
    var atBottom = (debugConsole.scrollTop() + debugConsole.height() > debugConsole[0].scrollHeight - 10);
    debugConsole.append(message);
    if (atBottom) {
      debugConsole.scrollTop(debugConsole[0].scrollHeight);
    }
  }
  $(".file").each(function() {
    var errors = $(this).data("errors");
    if (errors) {
      var codeMirror = $(this).data("codeMirror");
      for (i = 0; i < errors.length; i++) {
        codeMirror.removeLineClass(errors[i], 'background', 'line-error');
      }
      $(this).data("errors", []);
    }
  });

  iframe.contentWindow.onerror = function(message, uri, lineNumber) {
    var errFile = uri.substring(uri.lastIndexOf("/"));
    $(".file").filter(function() {
      var fileName = $(this).data("fileName");
      fileName = fileName.substring(fileName.lastIndexOf("/"));
      return errFile === fileName;
    }).each(function() {
      var actualLineNumber = lineNumber - 1;

      var errors = $(this).data("errors") || [];
      errors.push(actualLineNumber);
      $(this).data("errors", errors);

      var codeMirror = $(this).data("codeMirror");
      codeMirror.addLineClass(actualLineNumber, 'background', 'line-error');
    });
    doLog("<span class=\"errorMessage\">ERROR <b>" + errFile + " [" + lineNumber + "]</b>: " + message + "</span>");
    return false;
  };
}

function getOptions(fileName) {
  var cmOptions = {lineNumbers: true, tabSize: 2, lineWrapping: true};
  if (endsWith(fileName, ".css")) {
    cmOptions.mode = "css";
    cmOptions.matchBrackets = true;
    cmOptions.autoCloseBrackets = true;
  } else if (endsWith(fileName, ".java")) {
    cmOptions.mode = "text/x-java";
    cmOptions.matchBrackets = true;
    cmOptions.autoCloseBrackets = true;
  } else if (endsWith(fileName, ".js")) {
    cmOptions.mode = "javascript";
    cmOptions.matchBrackets = true;
    cmOptions.autoCloseBrackets = true;
  } else if (endsWith(fileName, ".html")) {
    cmOptions.mode = "htmlmixed";
    cmOptions.matchTags = {bothTags: true};
    cmOptions.matchBrackets = true;
    extraKeys = {
      "Ctrl-Space": function(cm) {
        CodeMirror.showHint(cm, CodeMirror.hint.html, {});
      }
    };
    //cmOptions.autoCloseTags = true;
  }
  return cmOptions;
}


function exit( status ) {
    if (typeof status === 'string') {
        alert(status);
    }
    window.addEventListener('error', function (e) {e.preventDefault();e.stopPropagation();}, false);
    var handlers = [
        'copy', 'cut', 'paste',
        'beforeunload', 'blur', 'change', 'click', 'contextmenu', 'dblclick', 'focus', 'keydown', 'keypress', 'keyup', 'mousedown', 'mousemove', 'mouseout', 'mouseover', 'mouseup', 'resize', 'scroll',
        'DOMNodeInserted', 'DOMNodeRemoved', 'DOMNodeRemovedFromDocument', 'DOMNodeInsertedIntoDocument', 'DOMAttrModified', 'DOMCharacterDataModified', 'DOMElementNameChanged', 'DOMAttributeNameChanged', 'DOMActivate', 'DOMFocusIn', 'DOMFocusOut', 'online', 'offline', 'textInput',
        'abort', 'close', 'dragdrop', 'load', 'paint', 'reset', 'select', 'submit', 'unload'
    ];
    function stopPropagation (e) {
        e.stopPropagation();
        // e.preventDefault(); // Stop for the form controls, etc., too?
    }
    for (var i=0; i < handlers.length; i++) {
        window.addEventListener(handlers[i], function (e) {stopPropagation(e);}, true);
    }

    if (window.stop) {
        window.stop();
    }

    throw '';
}
