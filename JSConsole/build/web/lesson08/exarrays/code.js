function Item(name, price, tags) {
  this.name = name;
  this.price = price;
  this.tags = tags;
}
var items = [];
items.push(new Item("Cellphone", 99.99, ["electronics", "computing"]));
items.push(new Item("Computer", 250.54, ["computing"]));
items.push(new Item("Book", 15.25, ["printed material"]));
items.push(new Item("Magazine", 8.52, ["printed material"]));
items.push(new Item("Tablet", 150.54, ["electronics", "computing"]));
items.push(new Item("Speaker", 55.21, ["electronics"]));

// Calculate the total of all items.
var total;
// Calculate the total of all electronics.
var electronicsTotal;
// Create an object with the count of all the tags.
var allTags = {};
