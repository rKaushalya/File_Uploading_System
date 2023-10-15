let Base_URL = "http://localhost:8080/fileUploading/";

$("#btnSave").click(function (){
    let fileName = $("#file").val();
    $.ajax({
        url : Base_URL + "image?file=" + fileName,
        method : "post",
        success : function (res) {
            alert(res.message);
        },
        error : function (e) {
            alert(e.responseJSON.message);
        }
    });
});