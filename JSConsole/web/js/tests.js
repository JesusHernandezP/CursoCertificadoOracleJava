$(function() {
  $(".test-tip").each(function(){
    var container = $(this);
    container.hide();
    container.find(".test-popup").dialog({autoOpen:false, title:container.attr("title")});
  });
  $('body').on("jasmine:complete", function() {
    $(".resultLink").on("click", function() {
      var link = $(this);
      var dialog = $(".test-popup").filter(function() {
        return link.text() === $(this).dialog("option", "title");
      });
      dialog.dialog("option", "position", { my: "center", at: "center", of: link });
      dialog.dialog("open");
    });
    $(".resultLink").each(function() {
      var link = $(this);
      var container = link.parent();
      if (container.hasClass("failed")) {
        link.after($(".test-tip").filter(function() {
          return link.text() === $(this).attr("title");
        }).find(".test-description"));
      }
    });
    $(".summary").prepend($(".test-header"));
    $(".summary").append($(".test-footer"));
  });
});
