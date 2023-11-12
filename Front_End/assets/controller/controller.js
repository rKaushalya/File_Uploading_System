let Base_URL = "http://localhost:8080/fileUploading/";

$("#btnSave").click(function (e){
    var file = $("#file")[0].files[0];
    var formData = new FormData();
    formData.append('file', file); // Create a new FormData object
    $.ajax({
        url: Base_URL+"image", // Specify the URL of the backend endpoint
        type: 'POST',
        data: formData,
        processData: false,
        contentType: false,
        success: function(response) {
            alert(response.message);
        },
        error: function (error) {
            console.log(error);
        }
    });
});