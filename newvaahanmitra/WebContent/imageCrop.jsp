<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="my-image"></div>
<script>
$('.my-image').croppie({
    url: './WebContent/images/A3Sedan.jpg',
});
</script>
<!-- or even simpler -->
<img class="my-image" src="./WebContent/images/A3Sedan.jpg" />
<script>
$('.my-image').croppie();
</script>
</body>
</html>