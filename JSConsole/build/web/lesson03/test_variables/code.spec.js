describe("Variables test", function() {
  it("#1 - Should check that variable a is Undefined type", function() {
    expect(a).toBeUndefined();
  });
  it("#1 - Should check that variable b is Null type", function() {
    expect(b).toBeNull();
  });
  it("#1 - Should check that variable c is Boolean type", function() {
    expect(c).toEqual(jasmine.any(Boolean));
  });
  it("#1 - Should check that variable d is String type", function() {
    expect(d).toEqual(jasmine.any(String));
  });
  it("#1 - Should check that variable e is Number type", function() {
    expect(e).toEqual(jasmine.any(Number));
  });
});
