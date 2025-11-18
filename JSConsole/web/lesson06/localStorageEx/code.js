var storedObject = {};
window.addEventListener("load", function() {
  //Get the stored object from the localStorage and parse using JSON
  //If nothing is stored set storedObject to an empty object.

  document.getElementById("storage").innerHTML = JSON.stringify(storedObject);
});
function addProperty() {
  var name = document.getElementById("name").value;
  var value = document.getElementById("value").value;
  //set the property in the stored object and save the JSON representation in the
  //Local Storage
}
function removeProperty() {
  var name = document.getElementById("name").value;
  //Remove the property in the stored object and save the JSON representation in the
  //Local Storage
}

