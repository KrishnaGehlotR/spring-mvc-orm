<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body onload="load();">

	<input type="hidden" id="userId"> Name:
	<input type="text" id="name" required="required" name="username">
	<br> Email:
	<input type="email" id="email" required="required" name="emailId">
	<br>
	<button onclick="submit();">Submit</button>

	<table id="table" border=1>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	</table>

	<script type="text/javascript">
data="";
submit=function(){
	$.ajax({
		url:'saveOrUpdate',
		type:'POST',
		data:{userId:$("#userId").val(),username:$('#name').val(),email:$('#email').val()},
		success:function(response){
			alert(response.message);
			load();
		}
	});
}

delete_ = function(id){
	$.ajax({
		url:'delete',
		type:'POST',
		data:{userId:id},
		success: function(response){
			alert(response.message);
			load();
		}
	});
}

edit = function(index){
	$("#userId").val(data[index].userId);
	$("#name").val(data[index].username);
	$('#email').val(data[index].email);
}

load = function(){
	$.ajax({
		url:'list',
		type:'POST',
		success: function(response){
			data = response.data;
			$('.tr').remove();
			for(int i=0;i<response.data.length; i++){
				$("#table").append("<tr class='tr'> <td> "+response.data[i].username+" </td><td> </td> "+response.dat[i].email+" <td> <a href='#' onclick= edit("+i+");>Edit</a></td></td><td><a href='#' onclick='delete("+response.data[i].userId+");'>Delete </a> </td> </tr>")
			}
		}
	});
}
</script>
</body>
</html>