$(document).ready(function() {
  $("#myText").bind("click", function() {
    $("#myText").addClass("increased-size");
  });

  $("#myParagraphs").delegate("p", "mouseover", function() {
    $(this).addClass("increased-size");
  });

  // Uncomment to try the on() method

  /* $("#myText").on("click", function() {
   $("#myText").addClass("change-color");
   });
   
   $("#myParagraphs").on("mouseover", "p", function()
   {
   $(this).addClass("change-color");
   }); */

  // Uncomment to try the trigger() method

  // $( "#myText" ).trigger( "click" );

});