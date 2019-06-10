data = "";
		submit = function() {
			$.ajax({
				url : 'saveOrUpdate',
				type : 'POST',
				data : { userId:$('#userId').val(), username:$('#name').val(), emailId:$('#email').val() },
				success : function(response) {
					alert(response.message);
					load();
				}
			});
		}

		delete_ = function(id) {
			$.ajax({
				url : 'delete',
				type : 'POST',
				data : { userId : id },
				success : function(response) {
					alert(response.message);
					load();
				}
			});
		}

		edit = function(index) {
			$("#userId").val(data[index].userId);
			$("#name").val(data[index].username);
			$('#email').val(data[index].email);
		}

		load = function() {
			$.ajax({
				url : 'list',
				type : 'POST',
				success : function(response) {
					data = response.data;
					$('.tr').remove();
					for (i = 0; i < response.data.length; i++) {
						$("#users").append( "<tr class='tr'> <td>"+response.data[i].userId+"</td><td> " + response.data[i].username + " </td><td> " + response.data[i].emailId + " </td> <td> <a href='#' onclick= edit(" + i + ");>Edit</a></td></td><td><a href='#' onclick='delete_(" + response.data[i].userId + ");'>Delete </a> </td> </tr>")
					}
				}
			});
		}