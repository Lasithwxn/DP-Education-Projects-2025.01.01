// Declare variables
var markofsub; 
var sub; 
var len; 
var total = 0; // Initialize total to 0
var ave = 0; // Initialize average to 0
var subject = []; // Array to store subjects
var mark = []; // Array to store marks

// Event listener for the Add button
onEvent("buttonAdd", "click", function() {
    sub = getText("inputSubject"); // Get subject input
    markofsub = getNumber("inputMark"); // Get mark input and convert to number
    
    appendItem(subject, sub); // Add subject to array
    appendItem(mark, markofsub); // Add mark to array
    
    setText("inputSubject", ""); // Clear subject input field
    setText("inputMark", ""); // Clear mark input field
});

// Event listener for the Generate button
onEvent("buttonGenerate", "click", function() {
    total = 0; // Reset total before calculation
    len = mark.length; // Get number of subjects
    
    if (len === 0) { // Prevent division by zero
        setText("labelTotal", "Total: 0");
        setText("labelAverage", "Average: 0");
        setText("labelHighestMark", "No marks entered.");
        return;
    }
    
    var highestmarksub = subject[0]; // Initialize highest mark subject
    var highestmark = mark[0]; // Initialize highest mark
    
    for (var i = 0; i < len; i++) {
        total += mark[i]; // Sum all marks
        if (highestmark < mark[i]) {
            highestmark = mark[i];
            highestmarksub = subject[i];
        }
    }
    
    ave = total / len; // Calculate average
    ave = Math.round(ave); // Round average to the nearest whole number
    
    // Display the results
    setText("labelTotal", "Total: " + total);
    setText("labelAverage", "Average: " + ave);
    setText("labelHighestMark", highestmarksub + " has the highest mark: " + highestmark);
    setText("labelName", getText("inputName")); // Display name
    setText("labelGrade", getText("inputGrade")); // Display grade
    
    setScreen("screen2"); // Switch to the results screen
});
