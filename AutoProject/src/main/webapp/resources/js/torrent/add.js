/**
 * 
 */

function getSucc(msg) {
	alert("Aaa");
}
$(document).ready(function() {
});

function getProgramList() {
	// $(".frm").submit();

	var form = new FormData(document.getElementById('frm'));
	$.ajax({
		url :"/fileAjax.do",
		data : form,
		dataType : 'json',
		processData : false,
		contentType : false,
		type : 'POST',
		success : function(response) {
			alert("success");
			console.log(response);
		},
		error : function(jqXHR) {
			alert(jqXHR.responseText);
		}
	});

	// $(frm).remove();
}
