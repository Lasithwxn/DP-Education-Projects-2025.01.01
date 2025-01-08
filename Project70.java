// Initialize variables
var time = 0; // Tracks time
var bg = createSprite(200, 200); // Background sprite
bg.setAnimation("bg");
bg.scale = 1.25;

var astronaut = createSprite(50, 340); // Astronaut sprite
astronaut.setAnimation("astronautrunning");
astronaut.scale = 0.3;

var ufo = createSprite(350, 50); // UFO sprite
ufo.setAnimation("ufo");
ufo.scale = 0.3;

var alien = createSprite(350, 340); // Alien sprite
alien.setAnimation("alien");
alien.scale = 0.1;
alien.visible = 0; // Alien initially hidden

var bullet = createSprite(200, 80); // Bullet sprite
bullet.setAnimation("fire");
bullet.scale = 0.3;
bullet.visible = 0; // Bullet initially hidden

// Initialize game variables
var angle = 100; 
var score = 0; 
var hit = "fales"; // Tracks if the game is over
var finish = "fales"; // Tracks if the game is won

// Main game loop
function draw() {
  // UFO movement and animation change
  ufo.velocityY = 30;
  if (ufo.y > 250) {
    ufo.setAnimation("ufowithlight");
    ufo.velocityY = 0;
    time = World.seconds; // Start timer
  }

  // After 1 second, UFO moves up and alien appears
  if (time > 1) {
    ufo.setAnimation("ufo");
    ufo.velocityY = -10;
    alien.visible = 1;
    alien.velocityX = -10; // Alien moves left
    score = World.seconds - 2; // Update score
  }

  // Reset bullet position when off-screen
  if (bullet.y > randomNumber(400, 800)) {
    bullet.x = 100;
    bullet.y = 80;
    angle = angle - 5; // Adjust bullet angle
  }

  // Restrict UFO to the top of the screen
  if (ufo.y < 50) {
    ufo.y = 50;
    ufo.velocityX = -10;
    ufo.velocityY = 0;
  }

  // When UFO reaches a certain position, enable bullet
  if (ufo.x < 200) {
    ufo.x = 200;
    ufo.velocityX = 0;
    bullet.visible = 1; 
    bullet.rotation = 100;
    bullet.setSpeedAndDirection(5, bullet.rotation);
  }

  // Reset alien position when it goes off-screen
  if (alien.x < 0) {
    alien.x = randomNumber(1200, 1600);
  }

  // Astronaut movement controls
  if (keyWentDown("right")) {
    astronaut.x += 50;
  }
  if (keyWentDown("left")) {
    astronaut.x -= 50;
  }

  // Check for collisions
  if (astronaut.isTouching(alien) || astronaut.isTouching(bullet)) {
    astronaut.destroy();
    alien.destroy();
    ufo.destroy();
    hit = "true"; // Game over
  }

  // Astronaut jump
  if (keyWentDown("up")) {
    astronaut.velocityY = -20;
    astronaut.setAnimation("astronautjumping");
  }

  // Reset astronaut position after jump
  if (astronaut.y < 100) {
    astronaut.velocityY = 20;
  }
  if (astronaut.y > 368) {
    astronaut.y = 368;
    astronaut.velocityY = 0;
    astronaut.setAnimation("astronautrunning");
  }

  // Draw all sprites
  drawSprites();

  // Display score
  fill("yellow");
  textSize(30);
  textFont("brush script mt");
  text("Score" + score, 10, 30);

  // Display "Game Over" if hit
  if (hit == "true") {
    fill("red");
    textSize(60);
    text("Game over", 100, 150);
  }

  // Display "You Win" if score reaches 50
  if (score > 49) {
    finish = "true";
    astronaut.destroy();
    ufo.destroy();
    alien.destroy();
    fill("red");
    text("you win", 100, 150);
    textSize(60);
  }
}
