<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
function ValidateSize(file) {
    var FileSize = file.files[0].size / 1024 / 1024; // in MB
    if (FileSize > 1) {
        alert('File size exceeds 1 MB');
       // $(file).val(''); //for clearing with Jquery
    } else {

    }
}
</script>
</head>
<body>
<!-- 	<input type="file" id="fileUpload" /> -->
	<input type="button" id="upload" value="Upload" />
	
	<input type="file" name="photo" accept="image/*"  placeholder="Select Image" required onchange="ValidateSize(this)"> 
													<!--  -->
</body>
</html>