// Create sprites for moon phases and button
var moon = createSprite(200, 200); // Main moon sprite representing the large moon
var FM = createSprite(350, 200); // Full Moon sprite
var WNG = createSprite(300, 100); // Waning Gibbous sprite
var LQM = createSprite(200, 50); // Last Quarter Moon sprite
var WNC = createSprite(100, 100); // Waning Crescent sprite
var NM = createSprite(50, 200); // New Moon sprite
var WXC = createSprite(100, 300); // Waxing Crescent sprite
var FQM = createSprite(200, 350); // First Quarter Moon sprite
var WXG = createSprite(300, 300); // Waxing Gibbous sprite
var button = createSprite(350, 30); // Button sprite for interaction indicator

// Set animations for each sprite
moon.setAnimation("moon"); // Animation for the main moon
FM.setAnimation("FM"); // Animation for Full Moon
WNG.setAnimation("WNG"); // Animation for Waning Gibbous
LQM.setAnimation("LQM"); // Animation for Last Quarter Moon
WNC.setAnimation("WNC"); // Animation for Waning Crescent
NM.setAnimation("NM"); // Animation for New Moon
WXC.setAnimation("WXC"); // Animation for Waxing Crescent
FQM.setAnimation("FQM"); // Animation for First Quarter Moon
WXG.setAnimation("WXG"); // Animation for Waxing Gibbous
button.setAnimation("button"); // Animation for the button

// Scale sprites to appropriate sizes for visibility
moon.scale = 2; // Larger size for the main moon
FM.scale = 0.5; // Smaller size for moon phase sprites
WNG.scale = 0.5;
LQM.scale = 0.5;
WNC.scale = 0.5;
NM.scale = 0.5;
WXC.scale = 0.5;
FQM.scale = 0.5;
WXG.scale = 0.5;
button.scale = 0.12; // Small button

// Set initial visibility for sprites
moon.visible = 1; // Main moon is visible
FM.visible = 1; // Full Moon starts visible
WNG.visible = 0; // Other phases start hidden
LQM.visible = 0;
WNC.visible = 0;
NM.visible = 0;
WXC.visible = 0;
FQM.visible = 0;
WXG.visible = 0;
button.visible = 0; // Button starts hidden

function draw() {
  background("BLACK"); // Set background color to black for a night theme

  // Display instructions for users
  fill("white"); // White text for contrast
  text("HOVER OVER THE SMALL MOON TO SEE THE PHASE & ITS NAME", 10, 385);

  // Interaction logic for Full Moon
  if (mouseIsOver(FM)) {
    button.visible = 1; // Show the button
    moon.setFrame(0); // Display the Full Moon frame
    moon.pause(); // Pause animation
    WNG.visible = 1; // Show Waning Gibbous
    text("FULL MOON", 10, 20); // Display phase name
  }

  // Interaction logic for Waning Gibbous
  if (mouseIsOver(WNG)) {
    moon.setFrame(2); // Display Waning Gibbous frame
    LQM.visible = 1; // Show Last Quarter Moon
    FM.visible = 0; // Hide Full Moon
    text("WANING GIBBOUS", 10, 20); // Display phase name
  }

  // Interaction logic for Last Quarter Moon
  if (mouseIsOver(LQM)) {
    moon.setFrame(5); // Display Last Quarter Moon frame
    WNC.visible = 1; // Show Waning Crescent
    WNG.visible = 0; // Hide Waning Gibbous
    text("LAST QUARTER MOON", 10, 20); // Display phase name
  }

  // Interaction logic for Waning Crescent
  if (mouseIsOver(WNC)) {
    moon.setFrame(10); // Display Waning Crescent frame
    NM.visible = 1; // Show New Moon
    LQM.visible = 0; // Hide Last Quarter Moon
    text("WANING CRESCENT", 10, 20); // Display phase name
  }

  // Interaction logic for New Moon
  if (mouseIsOver(NM)) {
    moon.setFrame(15); // Display New Moon frame
    WXC.visible = 1; // Show Waxing Crescent
    WNC.visible = 0; // Hide Waning Crescent
    text("NEW MOON", 10, 20); // Display phase name
  }

  // Interaction logic for Waxing Crescent
  if (mouseIsOver(WXC)) {
    moon.setFrame(17); // Display Waxing Crescent frame
    FQM.visible = 1; // Show First Quarter Moon
    NM.visible = 0; // Hide New Moon
    text("WAXING CRESCENT", 10, 20); // Display phase name
  }

  // Interaction logic for First Quarter Moon
  if (mouseIsOver(FQM)) {
    moon.setFrame(24); // Display First Quarter Moon frame
    WXG.visible = 1; // Show Waxing Gibbous
    WXC.visible = 0; // Hide Waxing Crescent
    text("FIRST QUARTER MOON", 10, 20); // Display phase name
  }

  // Interaction logic for Waxing Gibbous
  if (mouseIsOver(WXG)) {
    moon.setFrame(30); // Display Waxing Gibbous frame
    FM.visible = 1; // Show Full Moon
    FQM.visible = 0; // Hide First Quarter Moon
    text("WAXING GIBBOUS", 10, 20); // Display phase name
  }

  // Reset interaction logic for Full Moon
  if (mouseIsOver(FM)) {
    button.visible = 1; // Show button
    moon.setFrame(0); // Reset to Full Moon frame
    moon.pause(); // Pause animation
    WNG.visible = 1; // Show Waning Gibbous
    WXG.visible = 0; // Hide Waxing Gibbous
    text("FULL MOON", 10, 20); // Display phase name
  }

  // Draw all sprites on the canvas
  drawSprites();
}
