function replaceText() {
  // create a paragraph element, the variable contains a reference to the p element
  var newParagraphElement = document.createElement("p");
  var text = "This is the new Text";
  // create a text node
  var newTextElement = document.createTextNode(text);
  // insert the newly created text node into the node tree of paragraph
  newParagraphElement.appendChild(newTextElement);

  var currentParagraphElement = document.getElementById("p-1");
  // get parent node
  var parentNode = currentParagraphElement.parentNode;
  parentNode.replaceChild(newParagraphElement, currentParagraphElement);
}

function removeText() {
  var currentParagraphElement = document.getElementById("p-2");
  // get parent node
  var parentNode = currentParagraphElement.parentNode;
  parentNode.removeChild(currentParagraphElement);
}

function duplicateText() {
  var currentParagraphElement = document.getElementById("p-3");
  // clone node 
  var clonedNode = currentParagraphElement.cloneNode(true);
  // get parent node
  var parentNode = currentParagraphElement.parentNode;
  // insert the newly created node into the node tree of paragraph
  parentNode.appendChild(clonedNode);
}

function insertTextBefore() {

  // create a paragraph element, the variable contains a reference to the p element
  var newParagraphElement = document.createElement("p");
  var text = "This is the new Text";
  // create a text node
  var newTextElement = document.createTextNode(text);
  // insert the newly created text node into the node tree of paragraph
  newParagraphElement.appendChild(newTextElement);

  var currentParagraphElement = document.getElementById("p-3");
  // get parent node
  var parentNode = currentParagraphElement.parentNode;
  // insert the newly created node into the node tree of paragraph
  parentNode.insertBefore(newParagraphElement, currentParagraphElement);
}