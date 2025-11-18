console.log("**Creating Arrays**");
// Creating Arrays
var myNewEmptyArray = [];
console.log("myNewEmptyArray => " + myNewEmptyArray);

var numbers = [1, 2, 3, 4, 'five'];
console.log("numbers => " + numbers);

// Creating array with new
var myNewEmptyArray = new Array();
console.log("myNewEmptyArray => " + myNewEmptyArray);

var myNewNonEmptyArray = new Array(15);
console.log("myNewNonEmptyArray => " + myNewNonEmptyArray);

var numbers = new Array(1, 2, 3, 4, 'five');
console.log("numbers => " + numbers);

console.log("**Accessing Array Elements**");
// Accessing Array Elements
var c = ["blue", "red", "green", "purple"];
console.log("c.length => " + c.length);
c[20] = "white";
console.log("c.length => " + c.length);

// iterating arrays
// prints all the elements in the array, including undefined
for (var i = 0; i < c.length; i += 1) {
  console.log(c[i]);
}

// prints the elements not undefined in the array
for (var i in c) {
  console.log(c[i]);
}

console.log("**Multi-dimensional Arrays**");
// Multi-dimensional Arrays
var myArr = new Array(10);
for (i = 0; i < 10; i++) {
  myArr[i] = new Array(10);
  for (j = 0; j < 10; j++) {
    myArr[i][j] = "[" + i + j + "]";
  }
}

console.log("myArr => " + myArr);

var tic_tac_toe = [
  [0, 0, 'X'],
  ['X', 0, 'X'],
  ['X', 0, 0]
];

console.log("tic_tac_toe => " + tic_tac_toe);
