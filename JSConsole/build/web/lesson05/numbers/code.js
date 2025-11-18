window.addEventListener("load", function() {
  var button = document.getElementById("ageButton");
  button.addEventListener("click", function() {
    var ageOutputElement = document.getElementById("ageOutput");
    var ageTextElement = document.getElementById("ageInput");
    var ageTextValue = ageTextElement.value;
    var age = parseInt(ageTextValue, 10);
    var result = "";
    if (isNaN(age)) {
      result = "Input a number please.";
      ageTextElement.value = "";
    } else {
      result = ((100 - age) + " years before you turn 100!");
    }
    console.log(result);
    ageOutputElement.innerHTML = result;
  }, false);
}, false);

window.addEventListener("load", function() {
  var button = document.getElementById("tipButton");
  button.addEventListener("click", function() {
    var tipOutputElem = document.getElementById("tipOutput");
    var tipTotalBillElem = document.getElementById("tipTotalBill");
    var tipNumberOfPeopleElem = document.getElementById("tipNumberOfPeople");
    var billTotal = parseFloat(tipTotalBillElem.value);
    var people = parseFloat(tipNumberOfPeopleElem.value);
    //add the tip
    var totalWithTip = billTotal + (billTotal * 0.1);
    //divide the total
    var dividedTotal = totalWithTip / people;
    if (isNaN(dividedTotal)) {
      tipOutputElem.innerHTML = "Please input numbers.";
    } else if (isFinite(dividedTotal)) {
      tipOutputElem.innerHTML = "Each of you will pay:" + dividedTotal;
    } else {
      tipOutputElem.innerHTML = "Can't divide by 0.";
    }
  }, false);
}, false);

window.addEventListener("load", function() {
  var button = document.getElementById("numberButton");
  button.addEventListener("click", function() {
    var numberOutput = document.getElementById("numberOutput");
    var numberElem = document.getElementById("numberText");
    numberOutput.innerHTML = numberElem.value + 20;
  }, false);
}, false);
