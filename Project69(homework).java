var time = 0;

// Background
var bg = createSprite(200, 200);
bg.setAnimation("background.jpg_1");

// Car
var car = createSprite(450, 220);
car.setAnimation("carSide.png_1");
car.scale = 0.37;

// Bus
var bus = createSprite(200, 200);
bus.setAnimation("bus.png");
bus.scale = 1;

// Traffic Lights
var greenColorLight = createSprite(360, 220);
greenColorLight.setAnimation("greenColorLight.png_1");
greenColorLight.visible = false;
greenColorLight.scale = 0.2;

var redColorLight = createSprite(360, 220);
redColorLight.setAnimation("redColorLight.png_1");
redColorLight.visible = false;
redColorLight.scale = 0.2;

// Child
var ChildStand = createSprite(20, 290);
ChildStand.setAnimation("ChildStand.png_1");
ChildStand.scale =0.5
ChildStand.visible = false;

function draw() {
  // Move bus
  bus.velocityX = -5;
  if (bus.x < 50) {
    bus.velocityX = 0;
    time = World.seconds;
  }
  
  drawSprites();
  
  // Show red light and wait for 2 seconds
  redColorLight.visible = true;
  if (time > 2) {
    ChildStand.visible = true;
    bus.velocityX = -5;
    car.velocityX = -0.1;
    redColorLight.visible = false;
    greenColorLight.visible = true;
  }
  
  // Remove the bus and reset child after 3 seconds
  if (time > 3) {
    bus.destroy();
    
  }
  
  // Move child with right arrow key
  if (keyDown("right")) {
    ChildStand.setAnimation("ChildWalking.png_1");
    ChildStand.x += 3; // Move child to the right
  }
  
  // Stop child when touching green light
  if (ChildStand.isTouching(greenColorLight)) {
    ChildStand.velocityX = 0;
    ChildStand.setAnimation("ChildStand.png_1");
  }
  
  // Reset car and light after 7 seconds
  if (time > 7) {
    car.velocityX = -1;
    redColorLight.visible = true;
    greenColorLight.visible = false;
  }
  
  // Stop car after 11 seconds and make it move vertically
  if (time > 11) {
    car.velocityX = 0;
    car.setAnimation("car.png_1");
    car.velocityY = 1;
  }
  
  // If the car touches the child
  if (car.isTouching(ChildStand)) {
    ChildStand.destroy();
    playSound("sound://category_alerts/vibrant_game_life_lost_1.mp3", false);
    playSound("sound://category_hits/puzzle_game_organic_metal_tile_hit_2.mp3", false);
  }
  // If the child touches the green light
if (ChildStand.isTouching(greenColorLight)) {
  ChildStand.velocityY = 1; // Move down
  ChildStand.setAnimation("ChildStand.png_1"); // Optional: Change to a walking animation
}

}
