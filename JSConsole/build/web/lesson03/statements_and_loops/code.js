console.log("**Statements**");
// Statements
for (var i = 0; i < 10; i++) {
  if (i === 5)
    continue;
  console.log("This number is:" + i);
}


console.log("**while loop**");
// while loop
var i = 0;
while (i < 10) {
  console.log(i += 1);
}


var i = 0;
do {
  console.log(i += 1);
} while (i < 10);

console.log("**for loop**");
// for loop
for (var i = 1; i <= 10; i += 1) {
  console.log(i);
}

var myObject = {
  one: "value of property one",
  two: "value of property two"
};

for (var myVar in myObject) {
  if (myObject.hasOwnProperty(myVar)) {
    console.log(myVar);
  }
}