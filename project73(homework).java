var background = createSprite(200, 200);
var missileLeft = createSprite(180, 100);
var missileRight = createSprite(220, 100);
var head = createSprite(120, 80);
var body = createSprite(200 , 100);
var chest = createSprite(310, 100);
var leftHand = createSprite(120, 300);
var rightHand = createSprite(280 , 300);
var leftLeg = createSprite(50 , 300);
var rightLeg = createSprite(350 , 300);
var powerButton = createSprite(340 , 30);
var flyButton = createSprite(50, 20);
var handMoveButton = createSprite(50, 50);
var missileButton = createSprite(50, 80);
var powerOffButton = createSprite(50, 110);
var iornmanFly = createSprite(200, 200);
var handMove = createSprite(200, 200);
var ironmanFly = createSprite(200, 200);

handMove.setAnimation("handMoveAni.png_1");
background.setAnimation("background.jpg_1");
missileLeft.setAnimation("missileWithFireLeft.png_1");
missileRight.setAnimation("missileWithFireRight.png_1");
iornmanFly.setAnimation("flying2.png_1");
head.setAnimation("offHead.png_1");
body.setAnimation("Body.png_1");
chest.setAnimation("offChest.png_1");
leftHand.setAnimation("offLeftHand.png_1");
rightHand.setAnimation("offRightHand.png_1");
leftLeg.setAnimation("Leg L.png_1");
rightLeg.setAnimation("Leg R.png_1");
powerButton.setAnimation("powerButton");
flyButton.setAnimation("fly.png_1");
handMoveButton.setAnimation("handMove.png_1");
missileButton.setAnimation("missile.png_1");
powerOffButton.setAnimation("powerOff.png_1");
background.scale = 2;
head.scale = 0.48;
body.scale = 0.57;
chest.scale = 0.35;
leftHand.scale = 0.45;
rightHand.scale = 0.45;
leftLeg.scale = 0.45;
rightLeg.scale = 0.45;
powerButton.scale = 0.2;
flyButton.scale = 0.1;
handMoveButton.scale = 0.1;
missileButton.scale = 0.1;
powerOffButton.scale = 0.1;
missileLeft.scale = 0.2;
missileRight.scale = 0.2;

var bodyPart = 1;
var chestPart = 1;
var headPart = 1;
var leftHandPart = 1;
var rightHandPart = 1;
var leftLegPart = 1;
var rightLegPart = 1;

powerButton.visible = 0;
flyButton.visible = 0;
handMoveButton.visible = 0;
missileButton.visible = 0;
powerOffButton.visible = 0;
ironmanFly.visible = 0;
missileLeft.visible = 0;
missileRight.visible = 0;
handMove.visible = 0;
iornmanFly.visible = 0;


function draw() {
  drawSprites();
  if (mousePressedOver(body)) {
    body.x = 200;
    body.y = 180;
    bodyPart = 0;
  }
  if (mousePressedOver(chest) && bodyPart == 0) {
    chest.x = 200;
    chest.y = 115;
    chestPart = 0;
  }
  if (mousePressedOver(head) && (chestPart == 0 && bodyPart == 0)) {
    head.x = 200;
    head.y = 40;
    headPart = 0;
  }
  if (mousePressedOver(leftHand) && (chestPart == 0 && (bodyPart == 0 && headPart == 0))) {
    leftHand.x = 120;
    leftHand.y = 140;
    leftHandPart = 0;
  }
  if (mousePressedOver(rightHand) && (chestPart == 0 && (bodyPart == 0 && (headPart == 0 && leftHandPart == 0)))) {
    rightHand.x = 280;
    rightHand.y = 140;
    rightHandPart = 0;
  }
  if (mousePressedOver(leftLeg) && (chestPart == 0 && (bodyPart == 0 && (headPart == 0 && (leftHandPart == 0 && rightHandPart == 0))))) {
    leftLeg.x = 148;
    leftLeg.y = 300;
    leftLegPart = 0;
  }
  if (mousePressedOver(rightLeg) && (chestPart == 0 && (bodyPart == 0 && (headPart == 0 && (leftHandPart == 0 && (rightHandPart == 0 && leftLegPart == 0)))))) {
    rightLeg.x = 250;
    rightLeg.y = 300;
    rightLegPart = 0;
    powerButton.visible = 1;
  }
  if (mousePressedOver(powerButton)) {
    powerButton.visible = 0;
    handMoveButton.visible = 1;
    missileButton.visible = 1;
    powerOffButton.visible = 1;
    flyButton.visible = 1;
    head.setAnimation("head.png_1");
    chest.setAnimation("chest.png_1");
    leftHand.setAnimation("Hand L.png_1");
    rightHand.setAnimation("Hand R.png_1");
    playSound("iron-man-repulsor-sound-1.mp3", false);
    playSound("ElevenLabs_2023-06-06T16_29_15.000Z_Jarvis_vnxRNKYYMyBCwfqdymnL.mp3", false);
  }
  if (mousePressedOver(flyButton)) {
    background.setAnimation("background2.jpeg_1");
    handMove.visible = 0;
    missileLeft.visible = 0;
    missileRight.visible = 0;
    background.scale = 2.5;
    head.visible = 0;
    chest.visible = 0;
    leftHand.visible = 0;
    rightHand.visible = 0;
    leftLeg.visible = 0;
    rightLeg.visible = 0;
    body.visible = 0;
    iornmanFly.visible = 1;
    iornmanFly.setSpeedAndDirection(1, 180);
  }
  if (mousePressedOver(handMoveButton)) {
    missileLeft.visible = 0;
    missileRight.visible = 0;
    iornmanFly.visible = 0;
    background.setAnimation("background2.jpeg_1");
    background.scale = 2.5;
    head.visible = 0;
    chest.visible = 0;
    leftHand.visible = 0;
    rightHand.visible = 0;
    leftLeg.visible = 0;
    rightLeg.visible = 0;
    body.visible = 0;
    handMove.visible = 1;
  }
  if (mousePressedOver(missileButton)) {
    background.setAnimation("background2.jpeg_1");
    background.scale = 2.5;
    handMove.visible = 0;
    iornmanFly.visible = 0;
    head.visible = 1;
    chest.visible = 1;
    leftHand.visible = 1;
    rightHand.visible = 1;
    leftLeg.visible = 1;
    rightLeg.visible = 1;
    body.visible = 1;
    missileLeft.visible = 1;
    missileRight.visible = 1;
    missileLeft.setSpeedAndDirection(1, 300);
    missileRight.setSpeedAndDirection(1, 240);
    playSound("missileSound.mp3", false);
  }
  if (mousePressedOver(powerOffButton)) {
    handMove.visible = 0;
    iornmanFly.visible = 0;
    head.visible = 1;
    chest.visible = 1;
    leftHand.visible = 1;
    rightHand.visible = 1;
    leftLeg.visible = 1;
    rightLeg.visible = 1;
    body.visible = 1;
    missileLeft.visible = 0;
    missileRight.visible = 0;
    head.setAnimation("offHead.png_1");
    chest.setAnimation("offChest.png_1");
    rightHand.setAnimation("offRightHand.png_1");
    leftHand.setAnimation("offLeftHand.png_1");
    playSound("iron-man-repulsor-sound-1.mp3", false);
    playSound("powerOff.mp3", false);
  }
}
