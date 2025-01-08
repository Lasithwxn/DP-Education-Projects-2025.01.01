var score = 0;
var time = 0;
var bg = createSprite(200, 200);
bg.setAnimation("background.jpg_1");
bg.scale = 2;

var trex = createSprite(80, 340);
trex.setAnimation("Trex1.png_1");
trex.scale = 0.5;

var tree = createSprite(350, 350);
tree.setAnimation("tree.png_1");
tree.scale = 0.5;

var bird = createSprite(400, 300);
bird.setAnimation("bird.png_1");
bird.scale = 0.5;

var astroid = createSprite(370, 60);
astroid.setAnimation("astroid.png_1");
astroid.scale = 0.5;

var meat = createSprite(200, 200);
meat.setAnimation("meat.png_1");
meat.scale = 0.5;
var gameOver = createSprite(200, 200);
gameOver.setAnimation("game_over.png_1");
gameOver.scale = 0.5;
gameOver.visible = 0;
function draw() {
  time = World.seconds;
  remainder = 26 % 6;
  tree.velocityX = -3;
  if (time % 8 == 7) {
    if (tree.x < -5) {
      tree.x = 400;
    }
  }
  
  meat.velocityX = -1;
  if (time % 20 == 10) {
    if (meat.x < -5) {
      meat.x = 400;
    }
  }
  
  astroid.velocityX = -1;
  astroid.velocityY = 1;
  if (time % 30 == 29) {
    if (astroid.x < -395) {
      astroid.x = 370;
      astroid.y = -5;
    }
  }
  
  bird.velocityX = -2;
  if (time % 8 == 7) {
    if (bird.x < -5) {
      bird.x = 400;
    }
  }
  if (keyWentDown("up")) {
    trex.velocityY = -5;
  }
  
  if (keyWentDown("down")) {
    trex.velocityY = 5;
  }
  
  if (keyWentDown("left")) {
    trex.velocityX = -5;
  }
  
  if (keyWentDown("right")) {
    trex.velocityX = 5;
  }
  
  if (trex.y < 100) {
    trex.velocityY = 0;
  }
  if (trex.isTouching(bird)) {
    terx.destroy();
    gameOver.visible = 1;
  }
  
   if (trex.isTouching(astroid)) {
    trex.destroy();
    gameOver.visible = 1;
  }
  
   if (trex.isTouching(bird)) {
    trex.destroy();
    gameOver.visible = 1;
  }
  
   if (trex.isTouching(bird)) {
    trex.destroy();
    gameOver.visible = 1;
  }
  
   if (trex.isTouching(tree)) {
    trex.destroy();
    gameOver.visible = 1;
  }
  if (trex.isTouching(meat)) {
    score = score + 10;
    meat.x = 550;
  }
  drawSprites();
  fill("yellow");
  text("Score ;" + score, 10, 25);
  textSize(20);
}
