console.log("**Creating Objects**");
// Creating Objects
var obj_1 = {};
var obj_2 = new Object();
var obj_3 = Object.create(null);

console.log("obj_1 => " + obj_1.toSource());
console.log("obj_2 => " + obj_2.toSource());
//console.log("obj_3 => " + obj_3); // obj_3 doesn't inherit anything

var person = {
  "full-name": "John Doe",
  age: 35,
  address: {
    address_line1: "Clear Trace, Glaslyn, Arkansas",
    "postal code": "76588-89"
  }
};

console.log("person => " + person.toSource());

// Creating an object with new
function Tree(type, height, age) {
  this.type = type;
  this.height = height;
  this.age = age;
}

var mapleTree = new Tree("Big Leaf Maple", 80, 50);

console.log("mapleTree => " + mapleTree.toSource());

//Creating an object with prototypes
var myChild = Object.create(Object.prototype); // Object {}
console.log("myChild => " + myChild.toSource());
myChild = Object.create({a: 10, b: 30}); // Object {a=10, b=30}
console.log("myChild => " + myChild);

var myObj = {
  a: 10,
  b: 30
};
myChild = Object.create(myObj);
console.log("myChild => " + myChild);
console.log("myChild.a => " + myChild.a); //10
console.log("myChild.b => " + myChild.b); //30

console.log("**Accessing Objects**");
// Creating Objects
var myObject = {
  name: "luggage",
  length: 75,
  specs: {
    material: "leather",
    waterProof: true
  }
};

console.log("myObject['name'] => " + myObject["name"]); //"luggage"
console.log("myObject.name => " + myObject.name); //"luggage"
console.log("myObject.specs.material => " + myObject.specs.material);  //"leather"
console.log("myObject['specs']['material'] => " + myObject["specs"]["material"]);      //"leather"
console.log("myObject.width => " + myObject.width); //undefined
// console.log("myObject.tags.number => " + myObject.tags.number); // TypeError thrown
// line commented to allow following commands to run
myObject["name"] = "suitcase";        // name : "suitcase"
console.log("myObject['name'] => " + myObject["name"]); //"suitcase"
myObject.name = "suitcase";           // name : "suitcase"
console.log("myObject.name => " + myObject.name); //"suitcase"
myObject.width = 40;            // creates a new property
console.log("myObject.width => " + myObject.width); // 40
//myObject.tags.number = 6;           // TypeError thrown
// line commented to allow following commands to run
console.log("**Working with Object Properties**");
// Working with Object Properties
console.log(delete myObject.length);
console.log(delete myObject.height);

var myObject = {
  one: "property value one",
  two: "property value two"
};

for (var myVar in myObject) {
  if (myObject.hasOwnProperty(myVar)) {
    console.log(myVar);
  }
}

console.log("**Accessing Object Properties**");
// Accessing Object Properties
var obj = {
  a: 45,
  get double_a() {
    return this.a * 2;
  },
  set modify_a(x) {
    this.a -= x;
  }
};

console.log("obj.a => " + obj.a); // 45
console.log("obj.double_a => " + obj.double_a); // 90
obj.modify_a = 40;
console.log("obj.a => " + obj.a); // 5
console.log("obj.double_a => " + obj.double_a); //10

console.log("**Object Methods**");
// Object Methods
var myObj = {
  print: function() {
    console.log("Hello World!");
  }
};
myObj.print();

