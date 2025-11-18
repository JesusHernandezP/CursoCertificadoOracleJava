var storedObject = {};
window.addEventListener("load", function() {
  //Get the stored object from the localStorage and parse using JSON
  var storedData = localStorage.getItem("storedObject");
  storedObject = JSON.parse(storedData);
  if (!storedObject) {
    storedObject = {};
  }
  document.getElementById("storage").innerHTML = JSON.stringify(storedObject);
});
function addProperty() {
  var name = document.getElementById("name").value;
  var value = document.getElementById("value").value;
  //set the property in the stored object and save the JSON representation in the
  //Local Storage
  storedObject[name] = value;
  localStorage.setItem("storedObject", JSON.stringify(storedObject));
}
function removeProperty() {
  var name = document.getElementById("name").value;
  //Remove the property in the stored object and save the JSON representation in the
  //Local Storage
  delete storedObject[name];
  localStorage.setItem("storedObject", JSON.stringify(storedObject));
}

