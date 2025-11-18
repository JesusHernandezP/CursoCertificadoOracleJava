console.log("**Static Object Methods**");
// Static Object Methods
var obj = {a: 45};
Object.defineProperty(obj, "double_a", {get: function() {
    return this.a * 2;
  }});
Object.defineProperty(obj, "modify_a", {set: function(x) {
    this.a -= x;
  }});

console.log("obj.a => " + obj.a);
console.log("obj.double_a => " + obj.double_a);
obj.modify_a = 40;
console.log("obj.a => " + obj.a);
console.log("obj.double_a => " + obj.double_a);

