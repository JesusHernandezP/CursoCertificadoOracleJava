// Solution Test case # 1 - Functions
function sum(x, y) {
  return x + y;
}

// As a variable
/*var sum = function(x, y) {
 return x + y;
 };*/

// Solution Test case # 2
var myObject = {
  sum: function(x, y)
  {
    return x + y;
  }
};

// Solution Test case # 3
Operation.prototype.sum = function(x, y) {
  return  x + y;
};

// Solution Test case # 4
var myErrorFunction = function() {
  throw "myException";
};