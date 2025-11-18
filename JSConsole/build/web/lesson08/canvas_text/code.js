window.addEventListener("load", function() {
  var canvas = document.getElementById("html5canvas");
  var ctx = canvas.getContext("2d");
  ctx.fillStyle = "#000033"; //color
  ctx.strokeStyle = "#222222";

  ctx.font = "12px Arial";
  ctx.fillText("HELLO!", 10, 10);

  //paint some guides
  ctx.strokeStyle = "#CCCCCC";
  ctx.beginPath();
  ctx.moveTo(0, 10);
  ctx.lineTo(200, 10);
  ctx.moveTo(10, 0);
  ctx.lineTo(10, 200);
  ctx.stroke();
});

