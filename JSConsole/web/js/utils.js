(function() {
  var consoleElement = document.createElement("div");

  function logMeThis(fn1, fn2) {
    return function(message) {
      fn1.call(console, message);
      fn2.call(console, message);
    };
  }

  function elementLog(message) {
    consoleElement.appendChild(document.createTextNode(message));
    consoleElement.appendChild(document.createElement("br"));
  }

  console.log = logMeThis(console.log, elementLog);
  console.debug = logMeThis(console.debug, elementLog);
  console.info = logMeThis(console.info, elementLog);
  console.error = logMeThis(console.error, elementLog);

  window.addEventListener("load", function() {
    document.getElementsByTagName("body")[0].appendChild(consoleElement);
  });

}());


