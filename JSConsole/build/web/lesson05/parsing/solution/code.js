var data = "John,Doe,32,1982,10,23,153.25,  A  ,";
var person = {};

var splitData = data.split(",");

person.firstName = splitData[0];
person.lastName = splitData[1];
person.age = parseInt(splitData[2]);
person.credit = parseFloat(splitData[6]);
person.rating = splitData[7].trim();
var year = parseInt(splitData[3]);
var month = parseInt(splitData[4]) - 1;
var day = parseInt(splitData[5]);
person.birthdate = new Date(year, month, day, 0, 0, 0, 0);

