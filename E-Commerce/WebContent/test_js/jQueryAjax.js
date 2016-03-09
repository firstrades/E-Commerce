

function insertdata() {
	
	var Checkbox = $.trim($("#checkbox").val());
	var Checkbox1 = $.trim($("#checkbox1").val());
	var Email = $.trim($("#email").val());
	var First_name = $.trim($("#first_name").val());
	var Last_name = $.trim($("#last_name").val());
	
	alert("hello"+Checkbox+"sf"+Checkbox1+"email"+Email+"first_name"+First_name+"last_name"+Last_name);
	
	$.ajax({
		
		type: "POST",
		url: "User",
		data: "checkbox="+Checkbox+"&checkbox1="+Checkbox1+"&email="+Email+"&first_name="+First_name+"&last_name="+Last_name,
		dataType: "html",
		success: function(response) {
			document.getElementById('insertdata').innerHTML=response;
		},
		error: function(e) {
			document.getElementById('insertdata').innerHTML="<font color='red'>Technical Error.Try again..</font>";
        }
	});
}