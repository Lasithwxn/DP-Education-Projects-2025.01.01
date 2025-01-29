var button = createSprite(350, 20);
button.setAnimation("button.png");
button.scale = 0.4;

var butterfly = createSprite(200, 200);
butterfly.setAnimation("butterfly");
butterfly.scale = 0.5;

var b1 = createSprite(350, 250);
b1.setAnimation("Z1.png_1");
b1.scale = 0.5;
var b2 = createSprite(350, 180);
b2.setAnimation("Z2.png_1");
b2.scale = 0.5;

var b3 = createSprite(320, 80);
b3.setAnimation("Z3.png_1");
b3.scale = 0.5;

var b4 = createSprite(200, 40);
b4.setAnimation("Z4.png_1");
b4.scale = 0.5;

var b5 = createSprite(100, 90);
b5.setAnimation("Z5.png_1");
b5.scale = 0.5;

var b6 = createSprite(70, 170);
b6.setAnimation("Z6.png_1");
b6.scale = 0.5;

var b7 = createSprite(40, 260);
b7.setAnimation("Z7.png_1");
b7.scale = 0.5;

var b8 = createSprite(140, 330);
b8.setAnimation("Z8.png_1");
b8.scale = 0.4;

var b9 = createSprite(270, 340);
b9.setAnimation("Z9.png_1");
b9.scale = 0.4;

// Set visibility correctly (1 = true, 0 = false)
b1.visible = true;
b2.visible = false;
b3.visible = false;
b4.visible = false;
b5.visible = false;
b6.visible = false;
b7.visible = false;
b8.visible = false;
b9.visible = false;

function draw() {
  background("black");
  fill("white");
  textSize(15);
  text("The life cycle of the Butterfly", 5, 395);
  
  drawSprites();
  
  if (mouseIsOver(b1)) {
    b2.visible = true;
    butterfly.setFrame(0);
    butterfly.pause();
    text("The egg", 0, 20);
    b9.visible = false;
  }
  
  if (mouseIsOver(b2)) {
    b3.visible = true;
    butterfly.setFrame(1);
    butterfly.pause();
    b1.visible = false;
    text("The caterpillar 1", 0, 20);
  }
  
  if (mouseIsOver(b3)) {
    b4.visible = true;
    butterfly.setFrame(2);
    butterfly.pause();
    b2.visible = false;
    text("The caterpillar 2", 0, 20);
  }
  
  if (mouseIsOver(b4)) {
    b5.visible = true;
    butterfly.setFrame(3);
    butterfly.pause();
    b3.visible = false;
    text("The pupa 1", 0, 20);
  }
  
  if (mouseIsOver(b5)) {
    b6.visible = true;
    butterfly.setFrame(4);
    butterfly.pause();
    b4.visible = false;
    text("The pupa 2", 0, 20);
  }
  
  if (mouseIsOver(b6)) {
    b7.visible = true;
    butterfly.setFrame(5);
    butterfly.pause();
    b5.visible = false;
    text("The pupa 3", 0, 20);
  }
  
  if (mouseIsOver(b7)) {
    b8.visible = true;
    butterfly.setFrame(6);
    butterfly.pause();
    b6.visible = false;
    text("The emerging butterfly", 0, 20);
  }
  
  if (mouseIsOver(b8)) {
    b9.visible = true;
    butterfly.setFrame(7);
    butterfly.pause();
    b7.visible = false;
    text("The adult butterfly", 0, 20);
  }
  
  if (mouseIsOver(b9)) { 
    butterfly.setFrame(0);
    butterfly.pause();
    b8.visible = false;
    b1.visible = true;  // Restart cycle
    text("The butterfly", 5, 20);
  }
  if (mouseIsOver(button)) {
    butterfly.play();
    butterfly.visible = 1;
    b1.visible = true;
b2.visible = false;
b3.visible = false;
b4.visible = false;
b5.visible = false;
b6.visible = false;
b7.visible = false;
b8.visible = false;
b9.visible = false;
  }
}
