window.addEventListener("load", function() {
  var button = document.getElementById("ageButton");
  button.addEventListener("click", function() {
    var ageOutputElement = document.getElementById("ageOutput");
    var monthElement = document.getElementById("monthInput");
    var dayElement = document.getElementById("dayInput");
    var nextBirthDay = new Date();
    nextBirthDay.setDate(parseInt(dayElement.value));
    nextBirthDay.setMonth(parseInt(monthElement.value) - 1);
    nextBirthDay.setHours(0);
    nextBirthDay.setMinutes(0);
    if (nextBirthDay.getTime() < Date.now()) {
      //It is on next year.
      nextBirthDay.setFullYear(nextBirthDay.getFullYear() + 1);
    }
    var milliseconds = nextBirthDay.getTime() - Date.now();
    var hours = Math.round(milliseconds / (1000 * 60 * 60));
    var days = Math.round(hours / 24);
    var result = hours + " hours (" + days + " days) left before birthday!";
    ageOutputElement.innerHTML = result;
  }, false);
}, false);
