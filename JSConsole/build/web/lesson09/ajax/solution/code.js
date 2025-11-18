function loadData() {
  document.getElementById("content").innerHTML = "LOADING";
  var xmlhttp = new XMLHttpRequest();
  xmlhttp.open("GET", "data/data.json", true);
  xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
      var personData = JSON.parse(xmlhttp.responseText);
      var text = "Name:";
      text += personData.name;
      text += "<br>";
      text += "Age:";
      text += personData.age;
      text += "<br>";
      text += "Hobbies:";
      text += personData.hobbies.join(", ");
      document.getElementById("content").innerHTML = text;
    }
  };
  xmlhttp.send();
}
