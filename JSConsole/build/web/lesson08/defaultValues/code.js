function greet(message) {
  message = message || "NO MESSAGE";
  console.log("greet-->" + message);
}
greet();
greet(null);
greet("Hello!");
greet(false);
greet(true);
greet(123123);

function paramTest() {
  var message = "ParamTest-->";
  for (i = 0; i < arguments.length; i++) {
    message += "[" + arguments[i] + "]";
  }
  console.log(message);
}
paramTest();
paramTest(1, 2);
paramTest("a", null, undefined, false, 3);