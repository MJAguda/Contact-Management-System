// Get the current URL endpoint
var currentEndpoint = window.location.pathname;

// Define a function to set the text based on the endpoint
function setPageTitle() {
    if (currentEndpoint.includes("/add-contact")) {
        $("#pageTitle").text("Add Contact");
    } else if (currentEndpoint.includes("/update-contact")) {
        $("#pageTitle").text("Update Contact");
    } else if (currentEndpoint.includes("/details-contact")) {
        $("#pageTitle").text("Contact Details");
    } else {
        // Handle other cases or set a default title
        $("#pageTitle").text("Default Title");
    }
}

// Call the function when the document is ready
$(document).ready(function () {
    setPageTitle();
});

// // Wait for the DOM to be ready
// $(document).ready(function () {
//         // Event handler for the Add button
//         $('#addButton').click(function () {
//             // Store a flag in localStorage
//             localStorage.setItem('isAddButtonClicked', 'true');
//         });
    
//         // Check if the flag is set in localStorage
//         if (localStorage.getItem('isAddButtonClicked') === 'true') {
//             // Set the h1 text
//             $('h1').text('Add Contact');
//             // Clear the flag
//             localStorage.removeItem('isAddButtonClicked');
//         }
    
//         // Event handler for the Update button
//         $('#updateButton').click(function () {
//                 // Store a flag in localStorage
//                 localStorage.setItem('isUpdateButtonClicked', 'true');
//             });
        
//             // Check if the flag is set in localStorage
//             if (localStorage.getItem('isUpdateButtonClicked') === 'true') {
//                 // Set the h1 text
//                 $('h1').text('Update Contact');
//                 // Clear the flag
//                 localStorage.removeItem('isUpdateButtonClicked');
//             }
    
//         // Event handler for the Details button
//         $('#detailsButton').click(function () {
//                 // Store a flag in localStorage
//                 localStorage.setItem('isDetailsButtonClicked', 'true');
//             });
        
//             // Check if the flag is set in localStorage
//             if (localStorage.getItem('isDetailsButtonClicked') === 'true') {
//                 // Set the h1 text
//                 $('h1').text('Contact Details');
//                 // Clear the flag
//                 localStorage.removeItem('isDetailsButtonClicked');
//             }
//     });
  