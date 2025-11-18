var timeoutId;
var intervalId;
function startTimeout() {
  console.log("setting timeout");
  timeoutId = setTimeout(function() {
    console.log("TIMEOUT!");
  }, 3000);
  console.log("After Timeout");
  console.log("timeout set:" + timeoutId);
}
function cancelTimeout() {
  clearTimeout(timeoutId);
}
function startInterval() {
  if (!intervalId) {
    console.log("setting interval");
    intervalId = setInterval(function() {
      console.log("INTERVAL!");
    }, 1000);
    console.log("After Interval");
    console.log("interval set:" + intervalId);
  }
}
function cancelInterval() {
  clearInterval(intervalId);
  intervalId = undefined;
}