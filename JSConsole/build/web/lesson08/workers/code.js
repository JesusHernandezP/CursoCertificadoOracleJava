function startWorker() {
  var worker = new Worker("worker.js");
  worker.onmessage = function(event) {
    console.log("Message from worker" + event.data);
  }
  console.log("Starting worker...");
  worker.postMessage("");
  for (i = 0; i < 10; i++) {
    console.log("Log:" + i);
  }
}
