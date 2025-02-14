// [Protein, Vitamin, Calcium, Calories]
var pancake = [8, 2, 250, 120];
var egg = [11, 74, 200, 190];
var orange = [1, 70, 50, 60];
var milk = [8, 5, 300, 150];

var protein = 0;
var vitamin = 0;
var calcium = 0;
var calories = 0;

var n1 = 0; // Pancake count
var n2 = 0; // Egg count
var n3 = 0; // Orange count
var n4 = 0; // Milk count

onEvent("buttonstart", "click", function() {
  setScreen("Requirements");
});

onEvent("buttonnext", "click", function() {
  setScreen("Tiffin");
});

onEvent("Tapme", "click", function() {
  setScreen("Nutrition");
  setText("label5", "\n" + n1 + " Pancake\n" + n2 + " Eggs\n" + n3 + " Oranges\n" + n4 + " Milk\n");
});

onEvent("buttonhome1", "click", resetCounts);
onEvent("buttonhome2", "click", resetCounts);

function resetCounts() {
  setScreen("Home");
  n1 = 0;
  n2 = 0;
  n3 = 0;
  n4 = 0;
  updateNutrition();
}

onEvent("buttonback", "click", function() {
  setScreen("Tiffin");
});

onEvent("Pancake", "click", function() {
  n1++;
  updateNutrition();
});

onEvent("Egg", "click", function() {
  n2++;
  updateNutrition();
});

onEvent("Orange", "click", function() {
  n3++;
  updateNutrition();
});

onEvent("Milk", "click", function() {
  n4++;
  updateNutrition();
});

function updateNutrition() {
  protein = n1 * pancake[0] + n2 * egg[0] + n3 * orange[0] + n4 * milk[0];
  vitamin = n1 * pancake[1] + n2 * egg[1] + n3 * orange[1] + n4 * milk[1];
  calcium = n1 * pancake[2] + n2 * egg[2] + n3 * orange[2] + n4 * milk[2];
  calories = n1 * pancake[3] + n2 * egg[3] + n3 * orange[3] + n4 * milk[3];
  
  if (getText("nutritionLabel") !== undefined) {
    setText("nutritionLabel", "Protein: " + protein + "g\nVitamin: " + vitamin + "mg\nCalcium: " + calcium + "mg\nCalories: " + calories + " kcal");
  }
}
