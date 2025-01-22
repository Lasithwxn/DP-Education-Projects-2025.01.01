var bg = createSprite(200, 200);
var rocketL = createSprite(220, 100);
var rocketR = createSprite(170, 100);
var corestage = createSprite(80, 80);
var upperstage = createSprite(270, 80);
var launchbutton = createSprite(330, 350);
var stage1 = createSprite(300, 175);
var stage2 = createSprite(300, 200);
var stage3 = createSprite(300, 225);
var stage4 = createSprite(300, 250);
var stage5 = createSprite(300, 275);
var payloadinside = createSprite(80, 220);
var lander = createSprite(60, 50);
var moon = createSprite(330, 500);
payloadinside.setAnimation("payload");
stage1.setAnimation("stage1");
stage2.setAnimation("stage2");
stage3.setAnimation("stage3");
stage4.setAnimation("stage4");
stage5.setAnimation("stage5");
rocketR.setAnimation("rightbooster");
bg.setAnimation("bg");
rocketL.setAnimation("leftbooster");
corestage.setAnimation("corestage");
upperstage.setAnimation("upperstage");
launchbutton.setAnimation("launchbutton");
lander.setAnimation("lander");
moon.setAnimation("moon");
lander.scale = 0.15;
moon.scale = 0.6;
rocketR.scale = 0.4;
rocketL.scale = 0.4;
corestage.scale = 0.4;
upperstage.scale = 0.4;
stage1.scale = 0.1;
stage2.scale = 0.0333;
stage3.scale = 0.1;
stage4.scale = 0.0333;
stage5.scale = 0.1;
payloadinside.scale = 0.2;
stage1.visible = 0;
stage2.visible = 0;
stage3.visible = 0;
stage4.visible = 0;
stage5.visible = 0;
launchbutton.scale = 0.05;
launchbutton.visible = 0;
payloadinside.visible = 0;
lander.visible = 0;
moon.visible = 0;
var part1 = 1;
var part2 = 1;
var part3 = 1;
var part4 = 1;
var time = 0;
var launchtime = 0;
var countdown = 0;
var launch = "false";
var launchSuccessful = "false";
var s1 = "fales";
var s3 = "fales";
function draw() {
  if (mousePressedOver(corestage)) {
    corestage.x = 165;
    corestage.y = 260;
    part1 = 0;
  }
  if ((mousePressedOver(rocketL) || mousePressedOver(rocketR)) && part1 == 0) {
    rocketR.x = 192;
    rocketR.y = 240;
    rocketL.x = 130;
    rocketL.y = 240;
    part2 = 0;
    part3 = 0;
  }
  if (mousePressedOver(upperstage) && (part1 == 0 && (part2 == 0 && part3 == 0))) {
    upperstage.x = 162;
    upperstage.y = 185;
    part4 = 0;
  }
  if ((part1 == 0 && part2 == 0) && (part3 == 0 && part4 == 0)) {
    launchbutton.visible = 1;
  }
  time = World.seconds;
  if (mousePressedOver(launchbutton)) {
    launchbutton.destroy();
    launchtime = time;
    playSound("10-To-1-Countdown.mp3", false);
    launch = "true";
  }
  countdown = time - launchtime;
  if (countdown > 10 && launch == "true") {
    playSound("Rocket-launch.mp3", false);
    rocketR.setAnimation("rightboosterwithflame");
    rocketL.setAnimation("leftboosterwithflame");
    corestage.setAnimation("corestagewithflame");
    rocketL.scale = 0.09;
    rocketR.scale = 0.09;
    corestage.scale = 0.3;
    upperstage.scale = 0.3;
    upperstage.velocityY = -20;
    corestage.velocityY = -20;
    rocketR.velocityY = -20;
    rocketL.velocityY = -20;
  }
  if (corestage.y < -5) {
    corestage.x = 100;
    corestage.y = 240;
    corestage.rotation = 315;
    rocketR.x = 106;
    rocketR.y = 202;
    rocketR.rotation = 315;
    rocketL.x = 62;
    rocketL.y = 250;
    rocketL.rotation = 315;
    upperstage.x = 52;
    upperstage.y = 188;
    upperstage.rotation = 315;
    launchSuccessful = "true";
    stage1.visible = 1;
  }
  if (launchSuccessful == "true") {
    bg.setAnimation("bgblack");
    bg.scale = 4.0;
    corestage.velocityY = 0;
    upperstage.velocityY = 0;
    rocketL.velocityY = 0;
    rocketR.velocityY = 0;
  }
  if (mousePressedOver(stage1)) {
    stage2.visible = 1;
    s1 = "true";
  }
  if (s1 == "true") {
    rocketR.setSpeedAndDirection(15, 80);
    rocketL.setSpeedAndDirection(15, 190);
  }
  if (mousePressedOver(stage2)) {
    upperstage.destroy();
    payloadinside.visible = 1;
    stage3.visible = 1;
  }
  if (mousePressedOver(stage3)) {
    stage4.visible = 1;
    s3 = "true";
  }
  if (s3 == "true") {
    corestage.setSpeedAndDirection(15, 135);
  }
  if (mousePressedOver(stage4)) {
    payloadinside.rotation = 315; // Rotate payload to northwest
    payloadinside.destroy();
    stage5.visible = 1;
    moon.visible = 1;
    lander.visible = 1;
  }
  if (mousePressedOver(stage5)) {
    lander.x = 250;
    lander.y = 300;
  }
  drawSprites();
}
