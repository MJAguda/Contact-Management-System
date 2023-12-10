// Get the current URL endpoint
var currentEndpoint = window.location.pathname;

// Define a function to set the text based on the endpoint
function setPageTitle() {
    if (currentEndpoint.includes("/add-contact")) {
        // Change the text for page title
        $("#pageTitle").text("Add Contact");

        // Change Action URL for the form
        $("contact-form").attr("action", "/add-contact");

        // Change value of the button
        $('.btn-success').val('Add');
    } else if (currentEndpoint.includes("/update-contact")) {
        // Change text for page title
        $("#pageTitle").text("Update Contact");

        // Change Action URL for the form
        $(".contact-form").attr("action", "/update-contact");

        // Change value of the button
        $('.btn-success').val('Update');
    } else if (currentEndpoint.includes("/details-contact")) {
        
        // Change the text for page title
        $("#pageTitle").text("Contact Details");

        // Change Action URL for the form
        $(".contact-form").attr("action", "/");
        // Change Action URL for the form dynamically based on the current endpoint

        // Disable the input fields
        // $("#id").prop('disabled', true);
        $("#firstName").prop('disabled', true);
        $("#lastName").prop('disabled', true);
        $("#address").prop('disabled', true);
        $("#email").prop('disabled', true);
        $("#contactNumber").prop('disabled', true);

        // Change value of the button
        $('.btn-success').val('Home');
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
  