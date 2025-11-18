function createObject() {
  var value = 0;
  function sum(a, b) {
    return a + b;
  }
  ;
  return {
    add2: function(val) {
      return sum(2, val);
    }, add10: function(val) {
      return sum(10, val);
    },
    increment: function(val) {
      value += val;
    },
    getValue: function() {
      return value;
    }};
}
var object = createObject();
console.log(object.value); // undefined
console.log(object.getValue()); //0
console.log(object.increment(5));
console.log(object.getValue()); // 5
console.log(object.add2(5)); // 7
console.log(object.add10(10)); //20

