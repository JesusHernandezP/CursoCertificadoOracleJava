window.addEventListener("load", function() {
  document.getElementById("cookie").innerHTML = document.cookie;
  var cookieStrings = document.cookie.split(";");
  var cookies = {};
  for (var i = 0; i < cookieStrings.length; i++) {
    var rawCookie = cookieStrings[i].trim().split("=");
    cookies[rawCookie[0]] = rawCookie[1];
    console.log(rawCookie[0] + " --> " + rawCookie[1]);
  }
});
function setCookie() {
  var name = document.getElementById("name").value;
  var value = document.getElementById("value").value;
  document.cookie = name + "=" + value;
}
function clearCookie() {
  var name = document.getElementById("name").value;
  document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:01 GMT;";
}

