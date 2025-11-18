console.log("**Creating and Array and an Object**");
// Creating and Array and an Object
var courses = ["Java", "JavaScript", "Web Services"];
var students = [12, 5, 7];

console.log("courses array => " + courses);
console.log("students array => " + students);

var course = {name: "JavaScript", students: 5, frequency: "daily"};

console.log("course object => " + course);

var students_new = new Array();
var students_new_init = new Array(12, 5, 7);

console.log("students_new array => " + students_new);
console.log("students_new_init array => " + students_new_init);

function Courses() {
}

var courses_new = new Courses();
var courses_new_init = new Courses(12, 5, 7);

console.log("courses_new object => " + courses_new);
console.log("courses_new_init object => " + courses_new_init);

console.log("**Accessing an Array and an Object**");
// Accessing an Array and an Object
var myObject = {
  name: "Ring",
  diameter: 12,
  specs: {
    material: "Wood",
    waterProof: false
  }
};
var myArray = ["one", "two", 3, "four", 5];
console.log("myObject.diameter => " + myObject.diameter);
console.log("myObject.specs.waterProof => " + myObject.specs.waterProof);
console.log("myObject['diameter'] => " + myObject["diameter"]);
console.log("myObject['specs]['material'] => " + myObject["specs"]["material"]);
console.log("myArray[0] => " + myArray[0]);
console.log("myArray[5] => " + myArray[5]);

console.log("**Creating and Calling a Function**");
// Creating and Calling a Function
function multiply(x, y) {
  var result = x * y;
  return result;
}

var total = multiply(135, 6);
console.log("total: " + total);

console.log("**Operators**");
// Operators
console.log("9 - 5 => " + (9 - 5));
console.log("[9] * ['5'] => " + [9] * ['5']);
console.log("'9' + 5 => " + "9" + 5);
console.log("9 == '9' => " + (9 == '9'));
console.log("9 === '9' => " + (9 === '9'));
console.log("'string' && 'another' => " + "string" && "another");
console.log("'string' || 'another' => " + "string" || "another");
console.log("!'string' => " + !"string");
var a, b = 5, x = 100;
console.log("a = b => " + (a = b));
console.log("x += 1 => " + (x += 1));
console.log("5 & 6 => " + (5 & 6));
var age = 18;
var status = (age >= 18) ? "major" : "minor";
console.log("status => " + status);

console.log("**Special Operators**");
// Special Operators
for (var i = 0, j = 9; i <= 9; i++, j--)
  console.log(i + " , " + j);

var i = {a: 5, s: "String", b: 15};
delete i.s;
console.log("'b' in i => " + ("b" in i));
console.log("'s' in i => " + ("s" in i));

var i = [5, "String", 15];
delete i[1];
console.log("0 in i => " + (0 in i));
console.log("1 in i => " + (1 in i));

var a = [1, 2, 3, 4];
console.log("typeof undefined => " + typeof undefined);
console.log("typeof 'Hello' => " + typeof "Hello");
console.log("typeof a => " + typeof a);
console.log("typeof a[0] => " + typeof a[0]);