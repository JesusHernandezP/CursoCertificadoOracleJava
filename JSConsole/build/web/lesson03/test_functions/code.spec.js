describe("Functions test", function() {
  it("#1 - Should check that there is a function called sum that sums a and b variables ", function() {
    expect(a + b).toEqual(sum(a, b));
  });
  it("#2 - Should check that there is a method in myObject called sum that sums a and b variables ", function() {
    expect(a + b).toEqual(myObject.sum(a, b));
  });
  it("#3 - Should check that there is a function named sum in the prototype of Operation that sums a and b variables ", function() {
    expect(Operation.prototype.sum).toBeDefined();
    expect(a + b).toEqual(myFunction.sum(a, b));
  });
  it("#4 - Should check that the function throws an exception", function() {
    expect(myErrorFunction).toThrow();
  });
});
