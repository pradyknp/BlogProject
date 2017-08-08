$(document).ready(
		function() {
			main();

		});


function main(){
	
	 $("#getAllBlog").empty();
	$("#showBlog").hide();
	$("#getAllBlog").show();
	$("#addBlog").hide();
	
	var username = "pradyknp";
	
	var globaldata=[];
	
	$("#viewAll").click(function() {
		$("#showBlog").hide();
		$("#getAllBlog").show();
		$("#addBlog").hide();
	});
	
	var getByID = function(index) {
		console.log(globaldata[index]);
		$("#bodyread").html(globaldata[index].body);
		$("#titleread").html(globaldata[index].title);
		$("#createread").html("April 25 2017");
		
		$("#showBlog").show();
		$("#getAllBlog").hide();
		$("#addBlog").hide();
	}
	
	$("#createPost").click(function() {
		$("#showBlog").hide();
		$("#getAllBlog").hide();
		$("#addBlog").show();
	});
	
	 addPost =function(){
		console.log("in add post");
		var url = "myBlog/blog";
		var title = $("#title").val();
		var body =  $("#body").val();
		var category = $('#category option:selected').val();
		var id=globaldata.length+1;
		var createdDate ="2017-07-20T10:55:23"
		var modifiedDate= "2017-07-20T10:55:23"
			
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1; //January is 0!

		var yyyy = today.getFullYear();
		if(dd<10){
		    dd='0'+dd;
		} 
		if(mm<10){
		    mm='0'+mm;
		} 
		var today = dd+'/'+mm+'/'+yyyy;
		
		var data = "{\"title\":\""+title+"\",\"body\":\""+body+"\",\"category\":\""+category+"\",\"id\":"+id+",\"username\":\""+username+"\",\"createdDate\":\""+createdDate+"\",\"modifiedDate\":\""+modifiedDate+"\"}";
		
		
		$.ajax({
		    type: 'POST',
		    url: url,
		    data: data,
		    success: function(data) {
		    	console.log(data) 
		    	main();
		    },
		    contentType: "application/json",
		    Accept:"application/json",
		    dataType: 'json'
		});
	}

	var url = "myBlog/blog/getAll";
	$.getJSON(url, function(data) {
		console.log(data);
		
		for (var i = 0; i < data.length; i++) {
			globaldata[i]=data[i];
			var newParagraphdiv = $(document.createElement('div'))
					.attr("class", "allBlogs").attr("id",
							"Blog" + data[i].id);
			newParagraphdiv.after().html(
					'<h2><a href="#" onClick="getByID('+i+')" style="overflow:hidden;">'
							+ data[i].title + '</a> </h2><p>'
							+ data[0].body.substr(0, 64) + '...</p>');

			newParagraphdiv.appendTo("#getAllBlog");
		}
	});
}