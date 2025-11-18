window.addEventListener("load", function() {
  var canvas = document.getElementById("html5canvas");
  var ctx = canvas.getContext("2d");

  //add a guide.
  ctx.fillStyle = "#DDDDFF"; //color
  ctx.fillRect(0, 0, 300, 50);

  //Solid fill
  ctx.fillStyle = "#FF3333"; //color
  // Fill Rectangle
  ctx.fillRect(10, 10, 80, 80);

  //Solid fill
  ctx.fillStyle = "rgba(0,0,0,0.3)"; //color
  // Fill Rectangle
  ctx.fillRect(100, 10, 80, 80);

  //Gradient fill
  var grd = ctx.createLinearGradient(200, 50, 280, 50);
  grd.addColorStop(0, "#000000");
  grd.addColorStop(0.30, "#33AA33");
  grd.addColorStop(1, "#FFFFFF");
  ctx.fillStyle = grd;
  ctx.fillRect(200, 10, 80, 80);

});

