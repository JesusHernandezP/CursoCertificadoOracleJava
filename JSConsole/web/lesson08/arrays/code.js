function Person(name, age) {
  this.name = name;
  this.age = age;
}
Person.prototype.toString = function() {
  return this.name + "[" + this.age + "]";
}

var persons = [];
persons.push(new Person("Ed", 31));
persons.push(new Person("John", 22));
persons.push(new Person("Peter", 44));
persons.push(new Person("Joseph", 12));
persons.push(new Person("Richard", 18));
printArray("--unsorted--", persons);

// SORT BY NAME
persons.sort(function(personA, personB) {
  return personA.name > personB.name ? 1 : -1;
});
printArray("--Sorted by name--", persons);


// SORT BY AGE
persons.sort(function(personA, personB) {
  return personA.age > personB.age;
});
printArray("--Sorted by age--", persons);

var every10yo = persons.every(function(person) {
  return person.age > 10;
});
console.log("Everyone is at least 10 years old?: " + every10yo);

var some18yo = persons.some(function(person) {
  return person.age > 18;
});
console.log("Is someone over 18 years?: " + some18yo);

var grownUps = persons.filter(function(person) {
  return person.age > 18;
});
printArray("--grown ups--", grownUps);

var ages = persons.map(function(person) {
  return person.age;
});
printArray("--ages--", ages);

var totalAge = ages.reduce(function(prevValue, currValue) {
  return prevValue + currValue;
}, 0);
console.log("Total age:" + totalAge);

var grownUpAgeTotal = persons.filter(function(person) {
  return person.age > 18;
})
        .map(function(person) {
          return person.age;
        })
        .reduce(function(prevValue, currValue) {
          return prevValue + currValue;
        }, 0);
console.log("Total age of grown ups:" + grownUpAgeTotal);



//----- UTILITY METHODS 
function printArray(header, array) {
  console.log(header);
  array.forEach(function(item, index) {
    if (item.toString) {
      console.log(index + ":" + item.toString());
    } else {
      console.log(index + ":" + item);
    }
  });
}