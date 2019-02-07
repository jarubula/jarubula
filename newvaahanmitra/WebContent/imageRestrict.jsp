<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<input type="file" id="file">
	
	<input type="file" id="file1">
	
	
	<script type="text/javascript">
var uploadField = document.getElementById("file1");
uploadField.onchange = function() {
    if(this.files[0].size > 2005){
       alert("File is too big!");
       this.value = "";
    }
}</script>
	
	<script type="text/javascript">
var uploadField = document.getElementById("file");
uploadField.onchange = function() {
    if(this.files[0].size > 100000){
       alert("File is too big!");
       this.value = "";
    }
}</script>
</body>
</html>