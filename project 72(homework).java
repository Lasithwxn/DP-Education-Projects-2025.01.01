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
