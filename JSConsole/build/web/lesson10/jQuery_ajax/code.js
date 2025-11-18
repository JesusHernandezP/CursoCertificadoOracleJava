$(document).ready(function() {
  $("#ajaxButton").on("click", function() {
    var request = $.ajax({
      url: "data/file_1.html",
      type: "GET",
      dataType: "html"
    });
    request.done(function(data) {
      $("#content").html(data);
    });
  });

  $("#loadButton").on("click", function() {
    $("#content").load("data/file_1.html");
  });

  $("#scriptButton").on("click", function() {
    $.getScript("scripts/myscript.js", function() {
      console.log("Here some actions after the script is loaded");
    });
  });

  $("#jsonButton").on("click", function() {
    $.getJSON("data/list.json", function(data) {
      $.each(data, function(key, val) {
        $("#content ul").append("<li id='" + key + "'>" + val + "</li>");
      });
    });
  });

  $("#getButton").on("click", function() {
    $.get("data/file_1.html", function(data) {
      $("#content").html(data);
    }, "html");
  });

  $("#clearButton").on("click", function() {
    $("#content").empty();
  });
});
