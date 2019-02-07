<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function validate(){
var size=102113;

var file_size=document.getElementById('file_upload').files[0].size;
if(file_size>=size){
    alert('File too large');
    return false;
}
}</script>
</head>
<body>
	<form action="check.php" method="post" enctype="multipart/form-data">
<label>Upload An Image</label>
<input type="file" id="file_upload" name="file_upload"/>
<input type="submit" onClick="return validate()"/>
</form>


</body>
</html>