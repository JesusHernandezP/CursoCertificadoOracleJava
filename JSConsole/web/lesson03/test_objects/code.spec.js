describe("Objects test", function() {
  it("#1 - Should check that the three objects are empty objects", function() {
    expect(Object.getOwnPropertyNames(emptyObject1).length).toEqual(0);
    expect(Object.getOwnPropertyNames(emptyObject2).length).toEqual(0);
    expect(Object.getOwnPropertyNames(emptyObject3).length).toEqual(0);
  });
  it("#2 - Should check that there is a constructor named 'Hat' with two parameters: type and size ", function() {
    expect(myHat.type).toEqual("Cowboy");
    expect(myHat.size).toEqual("medium");
  });
  it("#3 - Should check that variable name has assigned the value of the property name in myObject ", function() {
    expect(name).toEqual(myObject.name);
  });
  it("#4 - Should check that variable type has assigned the value of the property type in myObject ", function() {
    expect(type).toEqual(myObject.specs.type);
  });
  it("#5 - Should check that property height has been deleted from myObject", function() {
    expect(myObject.height).toBeUndefined();
  });
  it("#6 - Should check that there is a new property named 'sold' with value 'false' in myObject", function() {
    expect(myObject.sold).toEqual(false);
  });
  it("#7 - Should check that there is a new Array named myNumbers with values: 'one', 2 , 'three'", function() {
    expect(myNumbers.length).toEqual(3);
    expect(myNumbers[0]).toEqual("one");
    expect(myNumbers[1]).toEqual(2);
    expect(myNumbers[2]).toEqual("three");
  });
  it("#8 - Should check that variable fruit has assigned the value of the fourth element in myArray ", function() {
    expect(fruit).toEqual(myArray[3]);
  });
  it("#9 - Should check that the myTwoHundredArray is 200 length and that it contains numbers from 0 to 199", function() {
    expect(myTwoHundredArray.length).toEqual(200);
    expect(myTwoHundredArray[0]).toEqual(0);
    expect(myTwoHundredArray[199]).toEqual(199);
    expect(myTwoHundredArray[50]).toEqual(50);
  });
});
