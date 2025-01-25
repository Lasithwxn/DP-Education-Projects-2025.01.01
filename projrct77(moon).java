var moon = createSprite(200, 200);
var FM = createSprite(350, 200);
var WNG = createSprite(300, 100);
var LQM = createSprite(200, 50);
var WNC = createSprite(100, 100);
var NM = createSprite(50, 200);
var WXC = createSprite(100, 300);
var FQM = createSprite(200, 350);
var WXG = createSprite(300, 300);
var button = createSprite(350, 30);
moon.setAnimation("moon");
FM.setAnimation("FM");
WNG.setAnimation("WNG");
LQM.setAnimation("LQM");
WNC.setAnimation("WNC");
NM.setAnimation("NM");
WXC.setAnimation("WXC");
FQM.setAnimation("FQM");
WXG.setAnimation("WXG");
button.setAnimation("button");
moon.scale = 2;
FM.scale = 0.5;
WNG.scale = 0.5;
LQM.scale = 0.5;
WNC.scale = 0.5;
NM.scale = 0.5;
WXC.scale = 0.5;
FQM.scale = 0.5;
WXG.scale = 0.5;
button.scale = 0.12;
moon.visible = 1;
FM.visible = 1;
WNG.visible = 0;
LQM.visible = 0;
WNC.visible = 0;
NM.visible = 0;
WXC.visible = 0;
FQM.visible = 0;
WXG.visible = 0;
button.visible = 0;
function draw() {
  background("BLACK");
  fill("white");
  text("HOVER OVER THE SMALL MOON TO SEE THE FACE & IT'S NAME", 10, 385);
  if (mouseIsOver(FM)) {
    button.visible = 1;
    moon.setFrame(0);
    moon.pause();
    WNG.visible = 1;
    text("FULL MOON", 10, 20);
  }
  if (mouseIsOver(WNG)) {
    moon.setFrame(2);
    LQM.visible = 1;
    FM.visible = 0;
    text("WANING GIBBOUS", 10, 20);
  }
  if (mouseIsOver(LQM)) {
    moon.setFrame(5);
    WNC.visible = 1;
    WNG.visible = 0;
    text("LAST QUARTER HALF MOON", 10, 20);
  }
  if (mouseIsOver(WNC)) {
    moon.setFrame(10);
    NM.visible = 1;
    LQM.visible = 0;
    text("WANING CRECENT", 10, 20);
  }
  if (mouseIsOver(NM)) {
    moon.setFrame(15);
    WXC.visible = 1;
    WNC.visible = 0;
    text("NEW MOON", 10, 20);
  }
  if (mouseIsOver(WXC)) {
    moon.setFrame(17);
    FQM.visible = 1;
    NM.visible = 0;
    text("MEXING CRECENT", 10, 20);
  }
  if (mouseIsOver(FQM)) {
    moon.setFrame(24);
    WXG.visible = 1;
    WXC.visible = 0;
    text("FRIST QUARTEN HALF MOON", 10, 20);
  }
  if (mouseIsOver(WXG)) {
    moon.setFrame(30);
    FM.visible = 1;
    FQM.visible = 0;
    text("WANING GIBBOUS", 10, 20);
  }
  if (mouseIsOver(FM)) {
    button.visible = 1;
    moon.setFrame(0);
    moon.pause();
    WNG.visible = 1;
    WXG.visible = 0;
    text("FULL MOON", 10, 20);
  }
  drawSprites();
}
