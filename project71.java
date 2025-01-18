var bg = createSprite(200, 200);
var rocketL = createSprite(220, 100);
var rocketR = createSprite(170, 100);
var corestage = createSprite(80, 80);
var upperstage = createSprite(270, 80);

bg.setAnimation("bg");
rocketL.setAnimation("leftbooster");
rocketR.setAnimation("rightbooster");
corestage.setAnimation("corestage");
upperstage.setAnimation("upperstage");

rocketL.scale = 0.4;
rocketR.scale = 0.4;
corestage.scale = 0.4;
upperstage.scale = 0.4;

// Track assembly progress
var part1 = 1;
var part2 = 1;
var part3 = 1;

function draw() {
  drawSprites();

  // Attach corestage
  if (mousePressedOver(corestage)) {
    corestage.x = 165;
    corestage.y = 260;
    part1 = 0; // Corestage attached
  }

  // Attach left and right rockets after corestage
  if ((mousePressedOver(rocketL) || mousePressedOver(rocketR)) && part1 === 0) {
    rocketL.x = 192;
    rocketL.y = 240;
    rocketR.x = 130;
    rocketR.y = 240;
    part2 = 0; // Rockets attached
  }

  // Attach upperstage after rockets
  if (mousePressedOver(upperstage) && part1 === 0 && part2 === 0) {
    upperstage.x = 162;
    upperstage.y = 185;
    part3 = 0; // Upperstage attached
  }

  // Check if assembly is complete
  if (part1 === 0 && part2 === 0 && part3 === 0) {
    console.log("Assembly Complete!");
  }
}
