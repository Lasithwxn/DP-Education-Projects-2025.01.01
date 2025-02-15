// Define molecular compositions for ethene and water
var ethene = [24.02, 4.04, 0.00]; // Ethene consists of carbon and hydrogen
var water = [0.00, 2.02, 16.00]; // Water consists of hydrogen and oxygen

// Initialize element counts
var carbon = 0;
var hydrogen = 0;
var oxygen = 0;

// Initialize molecule counters
var ethenemolaculs = 0;
var watermolaculs = 0;

// Event listener for the 'Start' button
onEvent("btnStart", "click", function() {
  setScreen("RecuiredElements"); // Switches to the required elements screen
});

// Event listener for the 'Mix' button
onEvent("btnMix", "click", function() {
  setScreen("Molecules"); // Switches to the molecules screen
});

// Event listener for the 'Let's Make' button
onEvent("btnLetsMake", "click", function() {
  setScreen("mixing"); // Switches to the mixing screen
});

// Show ethene description when hovering over the ethene image
onEvent("imgEthene", "mouseover", function() {
  showElement("labelEtheneDesc");
});

// Hide ethene description when the mouse leaves the ethene image
onEvent("imgEthene", "mouseout", function() {
  hideElement("labelEtheneDesc");
});

// Show water description when hovering over the water image
onEvent("imgWater", "mouseover", function() {
  showElement("labelWaterDesc");
});

// Hide water description when the mouse leaves the water image
onEvent("imgWater", "mouseout", function() {
  hideElement("labelWaterDesc");
});

// Increment ethene molecule count when the ethene image is clicked
onEvent("imgEthene", "click", function() {
  ethenemolaculs = ethenemolaculs + 1;
  setText("labelEthene", ethenemolaculs + "\tEthene"); // Update ethene count label
});

// Increment water molecule count when the water image is clicked
onEvent("imgWater", "click", function() {
  watermolaculs = watermolaculs + 1;
  setText("labelWater", watermolaculs + "\twater"); // Update water count label
});
