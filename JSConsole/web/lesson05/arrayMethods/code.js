// Array Methods

//push
console.log("*push*");
var months = ["Jan", "Feb", "Mar"];
console.log("months => " + months);
months.push("Apr", "May", "Jun");
console.log("months => " + months); // ["Jan", "Feb", "Mar", "Apr", "May", "Jun"]

//pop
console.log("*pop*");
var shapes = ["triangle", "circle", "square"];
console.log("shapes => " + shapes);
var shape = shapes.pop();
console.log("shape => " + shape);  // "square"
console.log("shapes => " + shapes); // ["triangle", "circle"]

//splice
console.log("*splice*");
var elements = ["fire", "water", "earth", "air"];
console.log("elements => " + elements);
var elem_deleted = elements.splice(1, 2);
console.log("elem_deleted => " + elem_deleted);  // ["water", "earth"]
console.log("elements => " + elements);   // ["fire", "air"]

//shift
console.log("*shift*");
var shapes = ["triangle", "circle", "square"];
console.log("shapes => " + shapes);
var shape = shapes.shift();
console.log("shape => " + shape); // "triangle"
console.log("shapes => " + shapes); // ["circle", "square"]

//unshift
console.log("*unshift*");
var elements = ["fire", "water", "earth", "air"];
console.log("elements => " + elements);
elements.unshift("fifth element");
console.log("elements => " + elements); // ["fifth element", "fire", "water",  "earth", "air"]

//reduce
console.log("*reduce*");
var numbers = [100, 10, 10, 10, 5];
console.log("numbers => " + numbers);
var result = numbers.reduce(function(prevValue, currentValue) {
  return prevValue - currentValue;
});
console.log("result => " + result);  // 65

//indexOf
console.log("*indexOf*");
var items = ["pencil", "scissors", "eraser", "tape"];
console.log("items => " + items);
var index = items.indexOf("eraser");
console.log("index => " + index);  // 2
index = items.indexOf("glue");
console.log("index => " + index);  // -1
