let Base_URL = "";

$("#btnSave").click(function (){
    let fileName = $("#file").val();
    $.ajax({
        url : Base_URL + "fileUploading?file=" + fileName,
        method : "post",
        success : function (res) {
            alert(res.message);
        },
        error : function (e) {
            alert(e.responseJSON.message);
        }
    });
});