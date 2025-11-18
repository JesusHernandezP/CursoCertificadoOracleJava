var animals = ["dog", "cat", "horse", "duck", "rabbit", "canary", "fox"];
var numbers = [1, 4, 7, 8, 1, 6, 4, 8, 3, 2, 1, 9, 6];
var floats = [1.5, 4.4, 7.8, 8.1, 1.6, 6.8, 4.4, 8.9];
var colors = ["red", "green", "blue", "yellow", "cyan", "magenta"];
var people = [{name: "Ed"}, {name: "John"}, {name: "Peter"}, {name: "Mike"}];
var functions = [];

animals.pop();
animals.pop();

numbers.push(10);

floats.splice(2, 1);

colors.splice(3, 1, "orange");

people = [];
// people.splice(0,people.length);
// people.length=0;
// while(people.length>0){people.pop();}

functions.push(function() {
  return true;
});
