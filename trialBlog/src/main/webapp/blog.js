$(document).ready(
		function() {
			$("#showBlog").hide();
			$("#getAllBlog").show();
			$("#addBlog").hide();
			
			globaldata=[];
			
			getByID = function(index) {
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
				
//				$.ajax({
//				    type: 'POST',
//				    url: url,
//				    data: {"name":"jonas"},
//				    success: function(data) { alert('data: ' + data); },
//				    contentType: "application/json",
//				    dataType: 'json'
//				});
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

		});