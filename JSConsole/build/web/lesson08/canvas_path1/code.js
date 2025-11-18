window.addEventListener("load", function() {
  var canvas = document.getElementById("html5canvas");
  var ctx = canvas.getContext("2d");
  ctx.fillStyle = "#DDDDFF"; //color
  ctx.strokeStyle = "#222222";

  ctx.beginPath();
  ctx.moveTo(10, 110);
  ctx.lineTo(60, 10);
  ctx.lineTo(110, 110);
  ctx.lineTo(10, 110);
  ctx.fill();
  ctx.stroke();
});

