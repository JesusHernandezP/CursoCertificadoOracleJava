function validateEmail() {
  var emailElement = document.getElementById("email");
  var outputElement = document.getElementById("output");
  var emailString = emailElement.value;
  var regex = /[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}/i;
  if (regex.test(emailString)) {
    outputElement.innerHTML = "VALID EMAIL";
  } else {
    outputElement.innerHTML = "INVALID EMAIL";
  }
}

