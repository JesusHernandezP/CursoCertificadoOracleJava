window.addEventListener("load", function() {
  hideAll();
});

function showAdd() {
  hideAll();
  document.getElementById("sec_add").setAttribute("style", "");
}
function showList() {
  hideAll();
  document.getElementById("sec_loading").setAttribute("style", "");
  var xmlhttp = new XMLHttpRequest();
  xmlhttp.open("GET", "http://localhost:8080/JSConsole/rest/cars/", true);
  xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
      var cars = JSON.parse(xmlhttp.responseText);
      var listElement = document.getElementById("carList");
      while (listElement.firstChild) {
        listElement.removeChild(listElement.firstChild);
      }
      for (i = 0; i < cars.length; i++) {
        var listItem = document.createElement("li");
        var anchor = document.createElement("a");
        anchor.setAttribute("href", "#");
        (function(id) {
          anchor.addEventListener("click", function() {
            showDetail(id);
          });
        }(cars[i]));
        anchor.appendChild(document.createTextNode(cars[i]));
        listItem.appendChild(anchor);
        listElement.appendChild(listItem);
      }
      hideAll();
      document.getElementById("sec_list").setAttribute("style", "");
    }
  };
  xmlhttp.send();
}
function showDetail(id) {
  hideAll();
  document.getElementById("sec_loading").setAttribute("style", "");
  var xmlhttp = new XMLHttpRequest();
  xmlhttp.open("GET", "http://localhost:8080/JSConsole/rest/cars/" + id, true);
  xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
      var car = JSON.parse(xmlhttp.responseText);
      document.getElementById("updName").value = car.name;
      document.getElementById("updNameText").innerHTML = car.name;
      document.getElementById("updColor").value = car.color;
      document.getElementById("updModel").value = car.model;
      document.getElementById("updYear").value = car.year;
      hideAll();
      document.getElementById("sec_update").setAttribute("style", "");
    }
  };
  xmlhttp.send();
}

function add() {
  hideAll();
  document.getElementById("sec_loading").setAttribute("style", "");
  var xmlhttp = new XMLHttpRequest();
  xmlhttp.open("POST", "http://localhost:8080/JSConsole/rest/cars/", true);
  xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState === 4 && xmlhttp.status === 204) {
      showList();
    }
  };
  carObject = {};
  carObject.name = document.getElementById("addName").value;
  carObject.color = document.getElementById("addColor").value;
  carObject.model = document.getElementById("addModel").value;
  carObject.year = document.getElementById("addYear").value;
  xmlhttp.setRequestHeader("content-type", "application/json");
  xmlhttp.send(JSON.stringify(carObject));
}

function update() {
  var id = document.getElementById("updName").value;
  hideAll();
  document.getElementById("sec_loading").setAttribute("style", "");
  var xmlhttp = new XMLHttpRequest();
  xmlhttp.open("PUT", "http://localhost:8080/JSConsole/rest/cars/" + id, true);
  xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState === 4 && xmlhttp.status === 204) {
      showList();
    }
  };
  carObject = {};
  carObject.name = document.getElementById("updName").value;
  carObject.color = document.getElementById("updColor").value;
  carObject.model = document.getElementById("updModel").value;
  carObject.year = document.getElementById("updYear").value;
  xmlhttp.setRequestHeader("content-type", "application/json");
  xmlhttp.send(JSON.stringify(carObject));
}

function removeCar() {
  var id = document.getElementById("updName").value;
  hideAll();
  document.getElementById("sec_loading").setAttribute("style", "");
  var xmlhttp = new XMLHttpRequest();
  xmlhttp.open("DELETE", "http://localhost:8080/JSConsole/rest/cars/" + id, true);
  xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState === 4 && xmlhttp.status === 204) {
      showList();
    }
  };
  xmlhttp.send();
}

function hideAll() {
  document.getElementById("sec_add").setAttribute("style", "display:none");
  document.getElementById("sec_list").setAttribute("style", "display:none");
  document.getElementById("sec_update").setAttribute("style", "display:none");
  document.getElementById("sec_loading").setAttribute("style", "display:none");
}
