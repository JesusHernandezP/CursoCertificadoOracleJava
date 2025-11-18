function createIncrementByNumber(number) {
  return function(x) {
    return number + x;
  };
}

var inc = createIncrementByNumber(2);
console.log("inc(3)=" + inc(3)); // 5
console.log("inc(10)=" + inc(10)); //12

var inc2 = createIncrementByNumber(10);
console.log("inc2(3)=" + inc2(3)); // 13
console.log("inc2(10)=" + inc2(10)); // 20
