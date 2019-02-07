<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="./Css/carmodels.js" type="text/javascript"></script>
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
			<h2 style="color: #008080">TYPE OF CARS</h2>
			<form action="">
				<tr>
					<td>Car Brand</td>
					<td><select required style="width: 160px" id="country" name="country">
							<option value="">select</option>
					</select></td>
				</tr>
				<tr>
					<td>Car Model</td>
					<td><select required style="width: 160px" id="state" name="state">
							<option value="">Select Model</option>
							<br>
					</select></td>
					</td>
				</tr>
				<tr>	
				<td></td>
					<td><input style="width:125px" type="submit" value="SUBMIT"></td>
				</tr>
			</form>
		</table>
	</center>
	
	<script language="javascript">
		populateCountries("country", "state");
 	</script>
 	<pre>
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	</pre>
	<footer>Copyright &copy; vehicletracking.com</footer>
</body>
</html>