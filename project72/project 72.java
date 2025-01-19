var bg = createSprite(200, 200);
var rocketL = createSprite(220, 100);
var rocketR = createSprite(170, 100);
var corestage = createSprite(80, 80);
var upperstage = createSprite(270, 80);
var launchbutton = createSprite(330, 350);

launchbutton.setAnimation("launchbutton");
launchbutton.scale = 0.05;
bg.setAnimation("bg");
rocketR.setAnimation("rightbooster");
rocketL.setAnimation("leftbooster");
corestage.setAnimation("corestage");
upperstage.setAnimation("upperstage");

rocketR.scale = 0.4;
rocketL.scale = 0.4;
corestage.scale = 0.4;
upperstage.scale = 0.4;

launchbutton.visible = false;

var part1 = true;
var part2 = true;
var part3 = true;
var part4 = true;

var time = 0;
var launchtime = 0;
var countdown = 0;
var launch = false;
var launchsuccessful = false;

function draw() {
  if (mousePressedOver(corestage)) {
    corestage.x = 165;
    corestage.y = 260;
    part1 = false;
  }
 
  if ((mousePressedOver(rocketL) || mousePressedOver(rocketR)) && !part1) {
    rocketR.x = 192;
    rocketR.y = 240;
    rocketL.x = 130;
    rocketL.y = 240;
    part2 = false;
    part3 = false;
  }
 
  if (mousePressedOver(upperstage) && !part1 && !part2 && !part3) {
    upperstage.x = 162;
    upperstage.y = 185;
    part4 = false;
  }
 
  if (!part1 && !part2 && !part3 && !part4) {
    launchbutton.visible = true;
  }
 
  time = World.seconds;
 
  if (mousePressedOver(launchbutton)) {
    launchbutton.destroy();
    launchtime = time;
    playSound("10-To-1-Countdown.mp3", false);
    launch = true;
  }
 
  countdown = time - launchtime;
 
  if (countdown > 10 && launch) {
    playSound("rocket-loop-99748.mp3", true);
    rocketR.setAnimation("rightboosterwithflame");
    rocketL.setAnimation("leftboosterwithflame");
    corestage.setAnimation("corestagewithflame");
 
    rocketR.scale = 0.09;
    rocketL.scale = 0.09;
    corestage.scale = 0.3;
    upperstage.scale = 0.3;
 
    upperstage.velocityY = -20;
    corestage.velocityY = -20;
    rocketL.velocityY = -20;
    rocketR.velocityY = -20;
  }
 
  if (corestage.y < -5) {
    corestage.x = 100;
    corestage.y = 240;
    corestage.rotation = 315;
 
    rocketR.x = 106;
    rocketR.y = 202;
    rocketR.rotation = 316;
 
    rocketL.x = 62;
    rocketL.y = 250;
    rocketL.rotation = 315;
 
    upperstage.x = 52;
    upperstage.y = 188;
    upperstage.rotation = 315;
    launchsuccessful = "true";
    
  }
  if (launchsuccessful == "true") {
    bg.setAnimation("bgblack");
    bg.scale = 4;
    stopSound("rocket-loop-99748.mp3");
 
    playSound("rocket-landing-38715.mp3", false);
    // Stop all velocities to freeze rockets
    corestage.velocityY = 0;
    upperstage.velocityY = 0;
    rocketL.velocityY = 0;
    rocketR.velocityY = 0;
 
    // Ensure all rotations and positions are frozen
    corestage.rotation = 315;
    upperstage.rotation = 315;
    rocketL.rotation = 315;
    rocketR.rotation = 316;
  }
 
  drawSprites();
}
