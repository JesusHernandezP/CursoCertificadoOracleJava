window.addEventListener("load", function() {
  console.log(module.getName());
  console.log(module.publicVariable);
  module.method();
  module.extension();
});