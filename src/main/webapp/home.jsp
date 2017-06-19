<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/global.css">
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	
	<title>Drag&Drop</title>
</head
>
<body>
<center>
	<h1>Drag and drop your file!</h1>
	<div id="uploads"></div>
	<div class="dropzone" id="dropzone">Drop csv file to analyse</div>
	
	<script>
		(function() {
			var dropzone = document.getElementById("dropzone");
			
			var upload = function(files) {
				var formData = new FormData(),
					xhr = new XMLHttpRequest();
					//x;
				
				formData.append("file", files[0]);					
				
				//for(x=0; x<files.length; x=x+1) {
				//	formData.append("file[]", files[x]);					
				//}
				
				//xhr.onload = function() { //maybe not important. to be deleted
				//	var data = this.responseText;
				//}
				
				xhr.open("post", "FinancialsUpload");
				xhr.send(formData);
			}
			
			dropzone.ondrop = function(e) {
				e.preventDefault();
				this.className = "dropzone";
				upload(e.dataTransfer.files);
				document.location.href='./FinancialsDashboard';
			};
			
			dropzone.ondragover = function() {
				this.className = "dropzone dragover";
				return false;
			};
			
			dropzone.ondragleave = function() {
				this.className = "dropzone";
				return false;
			};
		}());
	</script>
</center>

</body>

</html>