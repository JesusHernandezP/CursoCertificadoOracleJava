window.addEventListener("load", function() {
  alert("Window load event listener fired!");
}, false);

window.addEventListener("load", function() {
  document.getElementById("section-2").onclick = showWorkshopBanner;
  document.getElementById("headerProposal").addEventListener("click",
          showAbstractBanner, false);
}, false);

function showSpeakersBanner()
{
  alert("This year we'll have the best speakers in the region");
}
;

function showWorkshopBanner()
{
  alert("Our workshops are real hands-on!");
}

function showAbstractBanner()
{
  alert("Don't miss the opportunity to present your next big idea!");
}