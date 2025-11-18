window.addEventListener("load", function() {
  var canvas = document.getElementById("html5canvas");
  var ctx = canvas.getContext("2d");

  //Set Stroke properties
  ctx.strokeStyle = "#FF3333"; //color
  ctx.lineWidth = 10; //line width
  ctx.lineCap = "butt"; //line cap
  // Paint a line
  ctx.beginPath();
  ctx.moveTo(10, 10);
  ctx.lineTo(10, 110);
  ctx.stroke();

  //Set Stroke properties
  ctx.strokeStyle = "#DD4444"; //color
  ctx.lineWidth = 10; //line width
  ctx.lineCap = "round"; //line cap
  // Paint a line
  ctx.beginPath();
  ctx.moveTo(30, 10);
  ctx.lineTo(30, 110);
  ctx.stroke();

  //Set Stroke properties
  ctx.strokeStyle = "#DD5533"; //color
  ctx.lineWidth = 10; //line width
  ctx.lineCap = "square"; //line cap
  // Paint a line
  ctx.beginPath();
  ctx.moveTo(50, 10);
  ctx.lineTo(50, 110);
  ctx.stroke();

  //paint some guides.
  ctx.strokeStyle = "#444444";
  ctx.lineWidth = 1; //line width
  ctx.lineCap = "butt"; //line cap
  ctx.beginPath();
  ctx.moveTo(0, 10);
  ctx.lineTo(60, 10);
  ctx.moveTo(0, 110);
  ctx.lineTo(60, 110);
  ctx.stroke();

});

