try {
  fun();
} catch (e) {
  console.log("error with function:" + e);
}
try {
  varfun();
} catch (e) {
  console.log("error with function as variable: " + e);
}

var varfun = function() {
  console.log("function as variable");
};

function fun() {
  console.log("Function");
}

try {
  fun();
} catch (e) {
  console.log("error with function:" + e);
}
try {
  varfun();
} catch (e) {
  console.log("error with function as variable: " + e);
}

// inner function
console.log("*inner function*");
function outer() {
  var x = "I am declared in the outer function";
  function inner() {
    console.log(x);
  }
  inner();
}

outer();

console.log("*call and apply methods*");
// call and apply methods
function myFunction() {
  console.log(this.myProperty);
}
var myObj = {
  myProperty: 15
};

myFunction.call(myObj); // 15
myFunction.apply(myObj); // 15



console.log("**Function Methods**");
// Function Methods
// Function.prototype.toString()
console.log("*Function.prototype.toString()*");
console.log("outer.toString() => " + outer.toString());
// Function.prototype.bind()
console.log("*Function.prototype.bind()*");
var myObj = {
  myVar: "Hello there!",
  greet: function() {
    innerGreet = function(name) {
      console.log(this.myVar + name);
    };
    innerGreet.bind(this, " Duke")();
  }
};

myObj.greet();