var lens = createSprite(380, 200);
lens.setAnimation("lens.png_1");
lens.scale = 0.3;
var line = createSprite(200, 200);
line.setAnimation("line.png_1");
line.scale = 0.3;
var c = createSprite(197, 230);
c.setAnimation("c.png_1");
c.scale = 0.4;
var fr1 = createSprite(20, 230);
fr1.setAnimation("2f.png_1");
fr1.scale = 0.4;
var fl1 = createSprite(280, 230);
fl1.setAnimation("f.png_1");
fl1.scale = 0.4;
var fr2 = createSprite(105, 230);
fr2.setAnimation("f.png_1");
fr2.scale = 0.4;
var fr3 = createSprite(380, 230);  // Changed to fr3 to avoid overwriting fr2
fr3.setAnimation("2f.png_1");
fr3.scale = 0.4;

// New lens setup
var lens2 = createSprite(205, 280);
lens2.setAnimation("lens.png_1");
lens2.scale = 0.3;

var line2 = createSprite(200, 280);
line2.setAnimation("line.png_1");
line2.scale = 0.3;

var c2 = createSprite(197, 310);
c2.setAnimation("c.png_1");
c2.scale = 0.3;

var fr4 = createSprite(20, 310);  // Corrected from f2r2
fr4.setAnimation("2f.png_1");
fr4.scale = 0.4;

var fr5 = createSprite(380, 310);  // Corrected from f212
fr5.setAnimation("2f.png_1");
fr5.scale = 0.4;

var f12 = createSprite(290, 310);
f12.setAnimation("f.png_1");
f12.scale = 0.4;
var button = createSprite(350, 380);
button.setAnimation("button.png");
button.scale = 0.2;

var candle = createSprite(400, 235);
candle.setAnimation("candle.png");
candle.scale = 0.25;

var rays = createSprite(300, 185);
rays.setAnimation("rays.png");
rays.scale = 0.4;

var normal = createSprite(196, 230);
normal.setAnimation("Picture1 dm.png_1");
normal.scale = 0.5;

var rays2 = createSprite(98, 295);
rays2.setAnimation("Picture1 rays.png_1");
rays2.scale = 0.5;

var rays3 = createSprite(192, 295);
rays3.setAnimation("Picture1rays 1234567890.png_1");
rays3.scale = 0.5;

var rays2_d = createSprite(285, 110);
rays2_d.setAnimation("line orange.png_1");
rays2_d.scale = 0.4;

var rays3_d = createSprite(278, 110);
rays3_d.setAnimation("1234.png_1");
rays3_d.scale = 0.4;

var candle_2 = createSprite(310, 155);
candle_2.setAnimation("black.png_1");
candle_2.scale = 0.36;

lens2.visible = false;
line2.visible = false;
c2.visible = false;
fr4.visible = false;
fr5.visible = false;
f12.visible = false;
button.visible = false;
candle.visible = false;
rays.visible = false;
rays2.visible = false;
normal.visible = false;
rays3.visible = false;
rays2_d.visible = false;
rays3_d.visible = false;
candle_2.visible = false;

var display = "";

function draw() {
  background("blue");
  lens.velocityX = -1;
 
  if (lens.x < 390 && lens.x > 206) {
    display = "The Location Is Wrong";
    lens.velocityX = -1;
  }
 
  if (lens.x == 205) {
    lens.velocityX = 0;
    display = "The Location is Correct";
    button.visible = true;
  }
 
  if (mousePressedOver(button)) {
    lens.destroy();
    c.destroy();
    fr3.destroy();
    fr5.destroy();
    fr1.destroy();
    fl1.destroy();
    line.destroy();
 
    lens2.visible = true;
    line2.visible = true;
    c2.visible = true;
    fr4.visible = true;
    f12.visible = true;
    fr5.visible = true;
    button.visible = true;
    candle.visible = true;
    normal.visible = true;
  }
 
  candle.velocityX = -0.5;
 
  if (candle.x == 240) {
    candle.velocityX = 0;
    rays.visible = true;
    rays2.visible = true;
    normal.visible = true;
    rays3.visible = true;
    rays2_d.visible = true;
    rays3_d.visible = true;
    candle_2.visible = true;
  }
 
  fill("white");
  textSize(20);
  textFont("Arial");
  text(display, 100, 20);
  drawSprites();
}
