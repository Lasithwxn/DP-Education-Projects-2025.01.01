var lion_bg = createSprite(300, 50);
lion_bg.setAnimation("lion_bg");
lion_bg.scale = 0.1;
var G_O = createSprite(350, 350);
G_O.setAnimation("G&O");
G_O.scale = 0.1;

var H_YellowN = createSprite(100, 350);
H_YellowN.setAnimation("horizontal.y");
H_YellowN.scale = 0.2;
var H_YellowS = createSprite(100, 380);
H_YellowS.setAnimation("horizontal.y");
H_YellowS.scale = 0.2;

var V_YellowR = createSprite(100, 50);
V_YellowR.setAnimation("vertical_yellow");
V_YellowR.scale = 0.2;
var V_YellowL = createSprite(70, 50);
V_YellowL.setAnimation("vertical_yellow");
V_YellowL.scale = 0.2;

var part1 = 1;
var part2 = 1;
var part3 = 1;
var part4 = 1;
var part5 = 1;
var part6 = 1;

function draw() {
  drawSprites();
  if (mousePressedOver(G_O)) {
    G_O.scale = 0.3;
    G_O.x = 86;
    G_O.y = 200;
    part1 = 0;
  }
  if (mousePressedOver(lion_bg) && part1 == 0) {
    lion_bg.x = 244;
    lion_bg.y = 200;
    part2 = 0;
    lion_bg.scale = 0.3;
  }
  if ((mousePressedOver(V_YellowR) || mousePressedOver(V_YellowL)) && (part1 == 0) && (part2 == 0)) {
    V_YellowR.scale = 0.3;
    V_YellowL.scale = 0.3;
    V_YellowR.x = 31;
    V_YellowR.y = 200;
    V_YellowL.x = 359;
    V_YellowL.y = 200;
    part3 = 0;
    part4 = 0;
  }
  
  if ((mousePressedOver(H_YellowN) || mousePressedOver(H_YellowS)) && (part1 == 0 && (part2 == 0 && (part3 == 0 && part4 == 0)))) {
    H_YellowN.scale = 0.497;
    H_YellowS.scale = 0.497;
    H_YellowN.x = 198;
    H_YellowN.y = 280;
    H_YellowS.x = 198;
    H_YellowS.y = 120;
    part3 = 0;
    part4 = 0;
  }
}
