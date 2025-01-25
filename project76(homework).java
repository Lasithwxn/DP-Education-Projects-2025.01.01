var birthday;
var currentyear = 2023;
var age = 0;
var height;
var weight;
var bmi = 0;

onEvent("btnGenerate", "click", function() {
  birthday = parseInt(getText("inputBirthday"));
  if (isNaN(birthday)) {
    setText("labelID", "Invalid Birth Year");
    return;
  }
 
  age = currentyear - birthday;
 
  height = getNumber("inputHeight");
  weight = getNumber("inputWeight");
 
  if (height <= 0 || weight <= 0) {
    setText("labelID", "Invalid Height or Weight");
    return;
  }
 
  // Convert height from feet to meters
  height = height * 0.3048;
 
  // Calculate BMI
  bmi = weight / (height * height);
  bmi = Math.round(bmi);
 
  // Hide all images before showing the correct one
  hideElement("image1");
  hideElement("image2");
  hideElement("image3");
  hideElement("image4");
  hideElement("image5");
 
  if (bmi < 18.5) {
    setImageURL("image5", "underweight.png");
    showElement("image5");
  } else if (bmi >= 18.5 && bmi <= 24.9) {
    setImageURL("image1", "Normal.png");
    showElement("image1");
  } else if (bmi >= 25 && bmi <= 29.9) {
    setImageURL("image3", "OverWeight.png");
    showElement("image3");
  } else if (bmi >= 30 && bmi <= 34.9) {
    setImageURL("image4", "Obese.png");
    showElement("image4");
  } else if (bmi >= 35) {
    setImageURL("image2", "ExtremelyObese.png");
    showElement("image2");
  }
 
  setText("labelID", "ID : " + getText("inputID"));
  setText("labelAge", "Age : " + age);
  setText("labelName", "Name : " + getText("inputName"));
  setText("labelBMI", "BMI : " + bmi);
  setScreen("screen2");
});
