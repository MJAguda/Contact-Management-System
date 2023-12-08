// Wait for the DOM to be ready
$(document).ready(function () {
        // Event handler for the Add button
        $('#addButton').click(function () {
            // Store a flag in localStorage
            localStorage.setItem('isAddButtonClicked', 'true');
        });
    
        // Check if the flag is set in localStorage
        if (localStorage.getItem('isAddButtonClicked') === 'true') {
            // Set the h1 text
            $('h1').text('Add Contact');
            // Clear the flag
            localStorage.removeItem('isAddButtonClicked');
        }
    
        // Event handler for the Update button
        $('#updateButton').click(function () {
                // Store a flag in localStorage
                localStorage.setItem('isUpdateButtonClicked', 'true');
            });
        
            // Check if the flag is set in localStorage
            if (localStorage.getItem('isUpdateButtonClicked') === 'true') {
                // Set the h1 text
                $('h1').text('Update Contact');
                // Clear the flag
                localStorage.removeItem('isUpdateButtonClicked');
            }
    
        // Event handler for the Details button
        $('#detailsButton').click(function () {
                // Store a flag in localStorage
                localStorage.setItem('isDetailsButtonClicked', 'true');
            });
        
            // Check if the flag is set in localStorage
            if (localStorage.getItem('isDetailsButtonClicked') === 'true') {
                // Set the h1 text
                $('h1').text('Contact Details');
                // Clear the flag
                localStorage.removeItem('isDetailsButtonClicked');
            }
    });
  