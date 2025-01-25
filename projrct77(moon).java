// Create sprites for moon phases and button
var moon = createSprite(200, 200); // Main moon sprite
var FM = createSprite(350, 200); // Full Moon
var WNG = createSprite(300, 100); // Waning Gibbous
var LQM = createSprite(200, 50); // Last Quarter Moon
var WNC = createSprite(100, 100); // Waning Crescent
var NM = createSprite(50, 200); // New Moon
var WXC = createSprite(100, 300); // Waxing Crescent
var FQM = createSprite(200, 350); // First Quarter Moon
var WXG = createSprite(300, 300); // Waxing Gibbous
var button = createSprite(350, 30); // Button sprite for interaction

// Set animations for each sprite
moon.setAnimation("moon");
FM.setAnimation("FM");
WNG.setAnimation("WNG");
LQM.setAnimation("LQM");
WNC.setAnimation("WNC");
NM.setAnimation("NM");
WXC.setAnimation("WXC");
FQM.setAnimation("FQM");
WXG.setAnimation("WXG");
button.setAnimation("button");

// Scale sprites to appropriate sizes
moon.scale = 2;
FM.scale = 0.5;
WNG.scale = 0.5;
LQM.scale = 0.5;
WNC.scale = 0.5;
NM.scale = 0.5;
WXC.scale = 0.5;
FQM.scale = 0.5;
WXG.scale = 0.5;
button.scale = 0.12;

// Set initial visibility for sprites
moon.visible = 1;
FM.visible = 1;
WNG.visible = 0;
LQM.visible = 0;
WNC.visible = 0;
NM.visible = 0;
WXC.visible = 0;
FQM.visible = 0;
WXG.visible = 0;
button.visible = 0;

function draw() {
  background("BLACK"); // Set background color

  // Display instructions
  fill("white");
  text("HOVER OVER THE SMALL MOON TO SEE THE FACE & IT'S NAME", 10, 385);

  // Interaction logic for Full Moon
  if (mouseIsOver(FM)) {
    button.visible = 1;
    moon.setFrame(0);
    moon.pause();
    WNG.visible = 1;
    text("FULL MOON", 10, 20);
  }

  // Interaction logic for Waning Gibbous
  if (mouseIsOver(WNG)) {
    moon.setFrame(2);
    LQM.visible = 1;
    FM.visible = 0;
    text("WANING GIBBOUS", 10, 20);
  }

  // Interaction logic for Last Quarter Moon
  if (mouseIsOver(LQM)) {
    moon.setFrame(5);
    WNC.visible = 1;
    WNG.visible = 0;
    text("LAST QUARTER HALF MOON", 10, 20);
  }

  // Interaction logic for Waning Crescent
  if (mouseIsOver(WNC)) {
    moon.setFrame(10);
    NM.visible = 1;
    LQM.visible = 0;
    text("WANING CRECENT", 10, 20);
  }

  // Interaction logic for New Moon
  if (mouseIsOver(NM)) {
    moon.setFrame(15);
    WXC.visible = 1;
    WNC.visible = 0;
    text("NEW MOON", 10, 20);
  }

  // Interaction logic for Waxing Crescent
  if (mouseIsOver(WXC)) {
    moon.setFrame(17);
    FQM.visible = 1;
    NM.visible = 0;
    text("MEXING CRECENT", 10, 20);
  }

  // Interaction logic for First Quarter Moon
  if (mouseIsOver(FQM)) {
    moon.setFrame(24);
    WXG.visible = 1;
    WXC.visible = 0;
    text("FRIST QUARTEN HALF MOON", 10, 20);
  }

  // Interaction logic for Waxing Gibbous
  if (mouseIsOver(WXG)) {
    moon.setFrame(30);
    FM.visible = 1;
    FQM.visible = 0;
    text("WANING GIBBOUS", 10, 20);
  }

  // Reset interaction for Full Moon
  if (mouseIsOver(FM)) {
    button.visible = 1;
    moon.setFrame(0);
    moon.pause();
    WNG.visible = 1;
    WXG.visible = 0;
    text("FULL MOON", 10, 20);
  }

  // Draw all sprites on the canvas
  drawSprites();
}
