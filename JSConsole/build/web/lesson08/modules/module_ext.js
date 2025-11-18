var module = (function(module) {
  var name = "EXT 1";
  module.extension = function() {
    console.log("EXTENSION: " + name);
  };
  return module;
}(module || {}));