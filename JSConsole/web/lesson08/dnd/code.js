function drag(event) {
  event.dataTransfer.setData("Text", "Dragged");
}

function dragOver(event) {
  event.preventDefault();
}

function drop(event) {
  event.preventDefault();
  alert(event.dataTransfer.getData("Text"));
}
