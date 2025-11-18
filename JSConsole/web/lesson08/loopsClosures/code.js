var functionArray = [];
for (i = 0; i < 5; i++) {
  functionArray.push(
          function() {
            console.log(i);
          });
}
for (t = 0; t < functionArray.length; t++) {
  functionArray[t](); // always prints 5!
}

console.log("FIXED VERSION");
var functionArray = [];
for (i = 0; i < 5; i++) {
  (function(number) {
    functionArray.push(
            function() {
              console.log(number);
            }
    );
  }(i));
}
for (t = 0; t < functionArray.length; t++) {
  functionArray[t](); // prints 0 to 4
}
