/* Test case #1 - Functions.
 Create a function named "sum" that sums two parameters and returns the result
 
 Note: You can create the function as a function without a name and assign the
 returned value to a variable named "sum", or make a function called "sum".
 */
var a = 15;
var b = 67;

// Add sum function here

var result = sum(a, b);

/* Test case #2
 Create a function named "sum" that sums two parameters and returns the result.
 But this time as a method of myObject.
 */
var myObject = {
  // Add sum method    
};

result = myObject.sum(a, b);

/* Test case #3
 Add a function named sum to the prototype of Operation
 */
var Operation = function() {
};

var myFunction = new Operation();

//Add prototype here

result = myFunction.sum(a, b);

/* Test case #4
 Complete the function below to throw an exception
 */
var myErrorFunction = function() {
  // Add code here
};