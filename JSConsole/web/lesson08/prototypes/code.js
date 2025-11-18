function A() {
}
var inst1 = new A();
var inst2 = new A();
try {
  console.log(inst1.getName());
} catch (ex) {
  console.log("Function does not exist yet");
}
A.prototype.getName = function() {
  return "PROTO A";
};
console.log(inst1.getName());
console.log(inst2.getName());

function B() {
}
;
B.prototype = new A();
var b = new B();
console.log(b.getName());
