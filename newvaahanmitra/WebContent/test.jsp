<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>

<div class="well">
    <b> With select all and filter:</b>
<select id="ddlCars2" multiple="multiple">
<option value="Accord">Accord</option>
<option value="Duster">Duster</option>
<option value="Esteem">Esteem</option>
<option value="Fiero">Fiero</option>
<option value="Lancer">Lancer</option>
<option value="Phantom">Phantom</option>
</select>
</div>

</body>
<script>
 $('#ddlCars2').multiselect({ 
         includeSelectAllOption: true,
           enableFiltering:true         
           
     });
 </script>
</html>