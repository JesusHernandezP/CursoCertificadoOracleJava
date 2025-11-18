window.addEventListener("load", function() {
  var canvas = document.getElementById("html5canvas");
  var ctx = canvas.getContext("2d");
  ctx.fillStyle = "#333333"; //color

  ctx.strokeStyle = "#000000";
  ctx.beginPath();
  ctx.moveTo(10, 10);
  ctx.quadraticCurveTo(30, 50, 100, 10);
  ctx.stroke();
  paintDotText(ctx, "#00FF00", 10, 10);
  paintDotText(ctx, "#FF0000", 100, 10);
  paintDotText(ctx, "#0000FF", 30, 50);

  ctx.beginPath();
  ctx.moveTo(210, 40);
  ctx.bezierCurveTo(230, 150, 280, 50, 300, 110);
  ctx.stroke();
  paintDotText(ctx, "#00FF00", 210, 40);
  paintDotText(ctx, "#FF0000", 300, 110);
  paintDotText(ctx, "#3333FF", 230, 150);
  paintDotText(ctx, "#000033", 280, 50);



});

function paintDotText(ctx, color, x, y) {
  ctx.fillStyle = color;
  ctx.fillRect(x - 1, y - 1, 3, 3);
  ctx.fillStyle = "#333333";
  ctx.fillText(x + "," + y, x - 10, y + 10);
}