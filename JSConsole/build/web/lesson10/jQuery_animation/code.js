$(document).ready(function() {
  $("#myText").hide();
  $("#myButton").on("click", function() {
    $("#myText").show();
  });
  $("#myHideButton").on("click", function() {
    $("#myText").hide();
  });
  $("#myToggleButton").on("click", function() {
    $("#myText").toggle();
  });
  $("#mySlideButton").on("click", function() {
    $("#myText").slideDown();
  });
  $("#mySlideHideButton").on("click", function() {
    $("#myText").slideUp();
  });
  $("#myFadeButton").on("click", function() {
    $("#myText").fadeIn();
  });
  $("#myFadeHideButton").on("click", function() {
    $("#myText").fadeOut();
  });
  $("#myChainButton").on("click", function() {
    $("#myText").slideDown().slideUp().fadeIn().fadeOut();
  });
  $("#myAnimateButton").on("click", function() {
    $("#myImg").animate({height: 400, width: 400, opacity: "-=.75"}, 2000);
  });
  $("#myQueueAnimateButton").on("click", function() {
    $("#myImg")
            .animate({height: 400}, 1000)
            .animate({width: 400}, 1000)
            .animate({opacity: "-=.75"}, 1000);
  });

  $("#myManualQueueAnimateButton").on("click", function() {
    $("#myImg").queue(function() {
      $(this).animate({height: 400}, 1000);
      $(this).dequeue();
    });
    $("#myImg").queue(function() {
      $(this).animate({width: 400}, 1000);
      $(this).dequeue();
    });
    $("#myImg").queue(function() {
      $(this).animate({opacity: "-=.75"}, 1000);
      $(this).dequeue();
    });
  });

  $("#myNonQueueAnimateButton").on("click", function() {
    $("#myImg")
            .animate({
              height: 400
            }, {
              duration: 1000,
              queue: false,
              easing: "linear"
            })
            .animate({width: 400}, 1000)
            .animate({opacity: "-=.75"}, 1000);
  });

  $("#myStopButton").on("click", function() {
    $("#myImg").stop();
  });

  $("#myFinishButton").on("click", function() {
    $("#myImg").finish();
  });

  $("#myResetButton").on("click", function() {
    $("#myImg").css({height: "", width: "", opacity: ""});
  });
});
