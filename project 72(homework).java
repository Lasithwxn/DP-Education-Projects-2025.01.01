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
var bg = createSprite(200, 200);
var BG_1 = createSprite(200, 200);
BG_1.setAnimation("pine_trees_1");
BG_1.scale = 1;

var kids_1 = createSprite(370, 360);
kids_1.setAnimation("Kids1.png_1");
kids_1.scale = 0.4;

var kids_2 = createSprite(300, 350);
kids_2.setAnimation("Kids2.png_1");
kids_2.scale = 0.2;

var Air_B = createSprite(200, 200);
Air_B.setAnimation("Ari _B..png_1");
Air_B.scale = 1;

// State variables
var part1 = 1;
var part2 = 1;
var moving = false;
var windClicked = false;
var countdown = 0;
var playtime = 0;
var launch = false;

function draw() {
  background("white");
  
  // Step 1: Transition to BG_1
  if (part1 === 1) {
    BG_1.visible = true;
    bg.visible = false;
    if (mousePressedOver(kids_1)) {
      kids_1.x = 200;
      kids_1.y = 300;
      part1 = 0; // Mark part1 as done
    }
  }
  
  // Step 2: Transition to bg
  if (mousePressedOver(kids_2) && part1 === 0) {
    bg.visible = false;
    BG_1.visible = true;
    kids_2.x = 230;
    kids_2.y = 300;
    part2 = 0; // Mark part2 as done
  }
  
  // Step 3: Show wind PNG after both parts are done
  if (part1 === 0 && part2 === 0) {
    var wind = createSprite(350, 370);
    wind.setAnimation("wind.PNG_1");
    wind.scale = 0.5;
 
    if (mousePressedOver(wind)) {
      playtime = World.seconds;
      timd = playtime;
      moving = true;
      windClicked = true;
    playSound("sound://default.mp3", false);
    }
  }

  // Handle the countdown and velocity logic
  if (moving) {
    countdown = World.seconds - playtime;
    if (countdown > 5) {
      Air_B.velocityY = -10;
      kids_1.velocityY = -10;
      kids_2.velocityY = -10;
    }
  }

  // Reset when Air_B reaches a certain point
  if (Air_B.y < -5) {
    Air_B.x = 200;
    Air_B.y = 150;
    kids_1.x = 210;
    kids_1.y = 250;
    kids_2.x = 195;
    kids_2.y = 250;
    launch = true;
  }

  // Transition after launch
  if (launch) {
    // Ensure background switch is visible
    BG_1.destroy();  // Destroy previous background
    bg.setAnimation("sunshine_showers_1"); // Set new background
    bg.scale = 1;
    bg.visible = true;  // Make sure it's visible after setting animation
    Air_B.velocityY = 0;
    kids_1.velocityY = 0;
    kids_2.velocityY = 0;
  }

  drawSprites();
}
