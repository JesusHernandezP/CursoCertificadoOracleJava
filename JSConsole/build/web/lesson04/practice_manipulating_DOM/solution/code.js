// Solution practice # 1 
var p1 = document.getElementById('p1');
p1.parentNode.replaceChild(newParagraphElement, p1);

// Solution practice # 2 
var p2 = document.getElementById('p2');
p2.parentNode.removeChild(p2);

// Solution practice # 3
document.getElementById('p3').parentNode.appendChild(newParagraphElement);

// Solution practice # 4
var p4 = document.getElementById('p4');
p4.parentNode.insertBefore(newParagraphElement, p4);

// Solution practice # 5
var p5 = document.getElementById('p5');
var cloned_node = p5.cloneNode(true);
p5.parentNode.appendChild(cloned_node);

// Solution practice # 6
var p6_1 = document.getElementById('p6-1');
document.getElementById('p6-2').parentNode.appendChild(p6_1);

// Solution practice # 7
var p7 = document.getElementById('p7');
p7.appendChild(document.createTextNode('This is the new Text'));
// or
p7.appendChild(newTextElement);