console.log("**Defining Functions**");
// Defining Functions
function multiply(x, y) {
  var result = x * y;
  return result;
}

var total = multiply(135, 6);
console.log("total => " + total);

console.log("**Anonymous Functions**");
// Anonymous Functions
var multiply = function(x, y) {
  var result = x * y;
  return result;
};

console.log("multiply(135, 6) => " + multiply(135, 6));

console.log("**Calling a Function**");
// Calling a Function
console.log("*function as a method*");
// function as a method
var myObj = {
  name: "Hello World!",
  print: function(message) {
    console.log(this.name + message);
  }
};

myObj.print(' JS Robot');

console.log("*function as a constructor*");
// function as a constructor
function Tree(type, height) {
  this.type = type;
  this.height = height;
}

Tree.prototype.getType = function() {
  return this.type;
};

var myTree = new Tree("Big Leaf Maple", 80);

console.log("myTree.getType() => " + myTree.getType()); // "Big Leaf Maple"

console.log("**The arguments variable**");
// The arguments variable
function sum() {
  var total = 0;
  for (var i = 0, l = arguments.length; i < l; i++) {
    total += arguments[i];
  }
  return total;
}

console.log("sum(1,2,3,4,5) => " + sum(1, 2, 3, 4, 5)); //15

console.log("**Recursion**");
// Recursion
function factorial(number) {
  if (number < 2)
    return 1;
  return number * factorial(number - 1);
}

function fibonacci(number) {
  return (number < 2) ? number : fibonacci(number - 1) + fibonacci(number - 2);
}

console.log("factorial(10) => " + factorial(10));
console.log("fibonacci(10) => " + fibonacci(10));

console.log("**Scopes**");
// Scopes
console.log("*global scope*");
var x = "I am a global var!";
function printVar()
{
  console.log(x);
}

printVar();
console.log("window.x => " + window.x);

// function scope
console.log("*function scope*");
function declareVariable() {
  if (true) {
    var x = "Declared in a block of code";
  }
  console.log("Value of x: " + x);
}

declareVariable();
