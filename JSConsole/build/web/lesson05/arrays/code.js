window.addEventListener("load", function() {
  var button = document.getElementById("listButton");
  button.addEventListener("click", function() {
    var outputElement = document.getElementById("outputElement");
    var listElement = document.getElementById("listElement");
    var result = [];
    for (var i = 0; i < listElement.length; i++) {
      if (listElement[i].selected) {
        result.push(listElement[i].value);
      }
    }
    outputElement.innerHTML = result.join(", ");
  }, false);
}, false);
