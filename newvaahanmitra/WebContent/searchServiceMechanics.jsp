<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="./Css/carmodels1.js" type="text/javascript"></script>
	<div class="container">
		<div id="leftslider"></div>
		<div id="leftnav">
			<jsp:include page="./VehicleHome.jsp" />
		</div>
	</div>
</head>
<body>
 <center>
		<table>
			<h2 style="color: #008080">SEARCH SERVICE MECHANICS</h2>
			<form action="">
				<tr>
					<td> City </td>
					<td><input type="text" name="city" style="width: 100px" required> </td>
					<td> Location </td>
					<td><input type="text" name="location" style="width: 100px" required></td>
					<td>Car Brand</td>
					<td><select  required style="width: 100px" id="brand" name="brand">
							<option value="">select</option>
					</select></td>
					<td>Car Model</td>
					<td><select required style="width: 100px" id="model" name="model">
							<option value="">Select Model</option>
							<br>
					</select></td>
					</td>	
					<td></td>			
					<td><input style="width:80px" type="submit" value="SEARCH"></td>
				</tr>
			</form>
		</table>
	</center>
	<script language="javascript">
		populateBrands("brand", "model");
 	</script>
	
 	<pre>
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	</pre>
	<footer>Copyright &copy; vehicletracking.com</footer>
</body>
</html>