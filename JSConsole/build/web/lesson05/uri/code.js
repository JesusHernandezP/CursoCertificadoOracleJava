var uri = "http://www.oracle.com/list?order:by name";
var encodedUri = encodeURI(uri);
console.log(encodedUri);
//http://www.oracle.com/list?order:by%20name
var decodedUri = decodeURI(encodedUri);
console.log(decodedUri);
//http://www.oracle.com/list?order:by name
