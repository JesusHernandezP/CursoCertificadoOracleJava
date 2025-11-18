var module = (function(module) {
  module.publicVariable = "a";
  var name = "module 1";
  module.method = function() {
    console.log("METHOD!");
  };
  module.getName = function() {
    return name;
  };
  return module;
}(module || {}));