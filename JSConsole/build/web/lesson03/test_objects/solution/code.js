// Solution Test case # 1 - Objects
var emptyObject1 = {};
var emptyObject2 = new Object();
var emptyObject3 = Object.create(null);

// Solution Test case #2
function Hat(type, size) {
  this.type = type;
  this.size = size;
}

// Solution Test case # 3
name = myObject["name"];
// or 
name = myObject.name;

// Solution Test case # 4
type = myObject["specs"]["type"];
// or 
type = myObject.specs.type;

// Solution Test case # 5
delete myObject.height;

// Solution Test case # 6
Object.defineProperty(myObject, "sold", {value: false});

// Solution Test case # 7
var myNumbers = ['one', 2, "three"];
// or
var myNumbers = new Array('one', 2, "three");

// Solution Test case # 8
fruit = myArray[3];

// Solution Test case # 9
for (var i = 0; i < 200; i += 1) {
  myTwoHundredArray.push(i);
}

