$(document).ready(function() {
	/* Csrf parameter needed for spring security */
	var header = $("meta[name='_csrf_header']").attr("content");
	var token = $("meta[name='_csrf']").attr("content");
	
	$('#product-table').tablesorter();
	
	/* Check if the passwords match */
	$('#password-user, #confirmation-password-user').keyup(function() {
		if ($('#password-user').val() == $('#confirmation-password-user').val()) {
			$('#message').html('<span class="label label-success">Matching</span>');
		} else
			$('#message').html('<span class="label label-danger">Not matching</span>');
	});
	
	/* Signup user */
	$("#signup-form").submit(function(e){
		e.preventDefault();
		
		var name = $("#name-user").val();
		var age = $("#age-user").val();
		var salary = $("#salary-user").val();
		var username = $("#username-user").val();
		var password = $("#password-user").val();
		var confirmationPassword = $("#confirmation-password-user").val();
		
		var user = {
				"name" : name,
				"age" :age,
				"salary" : salary,
				"username" : username,
				"password" : password,
				"confirmationPassword" : confirmationPassword
		};
		
		$.ajax({
			url: "signup",
			data: JSON.stringify(user),
			type: "POST",
			
			beforeSend: function(xhr){
				xhr.setRequestHeader("Accept", "application/json");
		  		xhr.setRequestHeader("Content-Type", "application/json");
		  		xhr.setRequestHeader(header, token);
			},
			
			success: function(data){
				if(data.isValid){
					window.location = data.url;
				}
				else{
					$("#error-div").html('<div class="alert alert-dismissible alert-danger"> <button type="button" class="close" data-dismiss="alert">&times;</button> <strong>Error! </strong>' + data.error + '</div>' );
					//$("#error-message").html(data.error);
					// alert(data.error);
				}
			}
		});
	});
	
	var $selectedRow;
	
	/*
	 * Fade in the Add New Product div when pressing the 'Add product'
	 * button
	 */
	$("#addProduct").click(function(){
		$("#add-div").fadeIn();
	});
	
	/* Fade in the Add New Product div when pressing the close button */
	$("#closeAdd").click(function(event){
		event.preventDefault();
		$("#add-div").fadeOut();
	});

	$("#add-form").submit(function(e){
		e.preventDefault();
		
		var name = $("#nameAdd").val();
		var price = $("#priceAdd").val();
		var quantity = $("#quantityAdd").val();
		
		var product = {
				"name" : name,
				"price" : price,
				"quantity" : quantity
		};
		
		$.ajax({
			url: "success/add.json",
			data: JSON.stringify(product),
			type: "POST",
			
			beforeSend: function(xhr){
				xhr.setRequestHeader("Accept", "application/json");
		  		xhr.setRequestHeader("Content-Type", "application/json");
		  		xhr.setRequestHeader(header, token);
			},
			
			success: function(){
				// BootstrapDialog.confirm('Product added successfully');
				location.reload();
			}
			
		});
		
	});
	
	/* Get the selected table row when pressing the Delete button */
	$(".rowDelete").click(function(event){
		event.preventDefault();
		$selectedRow = $(this).closest("tr"); // get the row for the
												// product to be deleted
	});
	
	/* Get the selected table row when pressing the Update button */
	$(".rowUpdate").click(function(event){
		event.preventDefault();
		$selectedRow = $(this).closest("tr"); // get the row for the
												// product to be updated
		
		var id = $selectedRow.find(".idProduct").text();
		var name = $selectedRow.find(".nameProduct").text();
		var price = $selectedRow.find(".priceProduct").text();
		var quantity = $selectedRow.find(".quantityProduct").text();
		var userId = $selectedRow.find(".userIdProduct").text();
		
		$("#idInput").val(id);
		$("#nameInput").val(name);
		$("#priceInput").val(price);
		$("#quantityInput").val(quantity);
		$("#userIdInput").val(userId);
		
	});
	
	/* Delete the product when confirming from delete dialog */
	$("#dialog-delete").click(function(event) {
		event.preventDefault();
		var $id = $selectedRow.find(".idProduct").text();
		
		$.ajax({
			url: "success/delete/" + $id + ".json",
		  	type: "POST",

		  	beforeSend: function(xhr) {
		  		xhr.setRequestHeader("Accept", "application/json");
		  		xhr.setRequestHeader("Content-Type", "application/json");
		  		xhr.setRequestHeader(header, token);
		  	},
		  	
		  	success: function() {
		  		location.reload();
		  		// $selectedRow.fadeOut();
		  		// $("#delete-dialog").modal('toggle');
		  	}
		});
	});
	
	/* Updating the product when pressing the Save button from update modal */
	$("#update-form").submit(function(event){
		event.preventDefault();
		
		/* Get the data introduce by user */
		var id = $("#idInput").val();
		var name = $("#nameInput").val();
		var price = $("#priceInput").val();
		var quantity = $("#quantityInput").val();
		var userId = $("#userIdInput").val();
		
		var product = {
				"id" : id,
				"name" : name,
				"price" : price,
				"quantity" : quantity,
				"userId" : userId
		};
		
		$.ajax({
			url: "success/update.json",
			data: JSON.stringify(product),
			type: "POST",
			
			beforeSend: function(xhr){
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
				xhr.setRequestHeader(header, token);
			},
			
			success: function(){
				BootstrapDialog.confirm('Product updated successfully');
				location.reload();
				/*
				 * $("#update-dialog").modal('toggle');
				 * 
				 * Update the table row
				 * $selectedRow.find(".idProduct").text(id);
				 * $selectedRow.find(".nameProduct").text(name);
				 * $selectedRow.find(".priceProduct").text(price);
				 * $selectedRow.find(".quantityProduct").text(quantity);
				 * $selectedRow.find(".userIdProduct").text(userId);
				 */
				}
			});
			
		});
});