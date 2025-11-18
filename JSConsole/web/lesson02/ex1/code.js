//Replace student with your name
var name = "student";

// The following code waits until the page load to put the name in the placeholder.
window.addEventListener("load", function() {
  var namePlace = document.getElementById("namePlaceHolder");
  var nameElement = document.createTextNode(name);
  namePlace.appendChild(nameElement);
});

console.log("Welcome " + name + "!");