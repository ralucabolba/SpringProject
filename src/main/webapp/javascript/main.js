$(document).ready(function(){
	$(document).ready(function() {
		$('#pw1Input, #pw2Input').keyup(function() {
			if ($('#pw1Input').val() == $('#pw2Input').val()) {
				$('#message').html('Matching').css('color', 'green');
			} else
				$('#message').html('Not Matching').css('color', 'red');
		});
		
		var $selectedRow;
		
		/*Fade in the Add New Product div when pressing the 'Add product' button*/
		$("#addProduct").click(function(){
			$("#add-div").fadeIn();
		});
		
		/*Fade in the Add New Product div when pressing the close button*/
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
					//BootstrapDialog.confirm('Product added successfully');
					location.reload();
				}
				
			});
			
		});
		
		/*Get the selected table row when pressing the Delete button*/
		$(".rowDelete").click(function(event){
			event.preventDefault();
			$selectedRow = $(this).closest("tr"); //get the row for the product to be deleted
		});
		
		/*Get the selected table row when pressing the Update button*/
		$(".rowUpdate").click(function(event){
			event.preventDefault();
			$selectedRow = $(this).closest("tr"); //get the row for the product to be updated
			
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
	
		var header = $("meta[name='_csrf_header']").attr("content");
		var token = $("meta[name='_csrf']").attr("content");
		
		/*Delete the product when confirming from delete dialog*/
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
			  		//$selectedRow.fadeOut();
			  		//$("#delete-dialog").modal('toggle');
			  	}
			});
		});
		
		/*Updating the product when pressing the Save button from update modal*/
		$("#update-form").submit(function(event){
			event.preventDefault();
			
			/*Get the data introduce by user*/
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
					/*$("#update-dialog").modal('toggle');
					
					Update the table row
					$selectedRow.find(".idProduct").text(id);
					$selectedRow.find(".nameProduct").text(name);
					$selectedRow.find(".priceProduct").text(price);
					$selectedRow.find(".quantityProduct").text(quantity);
					$selectedRow.find(".userIdProduct").text(userId);*/
				}
			});
			
		});
	})
})