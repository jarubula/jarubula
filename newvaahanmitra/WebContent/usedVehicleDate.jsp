<%
try {
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
    
    System.out.println(session.getAttribute("user"));
    
    if (session.getAttribute("user")==null) {
    	%>
<jsp:forward page="./login3.jsp" ></jsp:forward>   <% }
    else {}
}
catch(Exception ex) {
    out.println(ex);
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*,java.util.*"%>
<html>
<head>
<!-- bootstrap link start -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- bootstrap end -->
<meta charset="utf-8">
<jsp:include page="./carsandBikes.jsp" />
<jsp:include page="./topMenu.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<!-- Theme initialization -->
<script>
	var themeSettings = (localStorage.getItem('themeSettings')) ? JSON
			.parse(localStorage.getItem('themeSettings')) : {};
	var themeName = themeSettings.themeName || '';
	if (themeName) {
		document
				.write('<link rel="stylesheet" id="theme-style" href="css/app-' + themeName + '.css">');
	} else {
		document
				.write('<link rel="stylesheet" id="theme-style" href="css/app.css">');
	}
</script>

<style>
.td {
	font-size: small;
}
</style>
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">

			<header class="" style="font-family: 'Oswald', sans-serif;">

			<div class="header-block header-block-nav"></div>
			</header>
			<br>

			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div align="center">
						<h3>USED VEHICLE DEALER DASHBOARD</h3>
					</div>
				</div>
				<div class="col-md-12 col-xs-12 col-sm-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive well">
								<%
									String message = (String) request.getAttribute("failure");
								%>
								<form action="./UsedVehicleSearchByDateController" method="post">
									<div class="col-md-12" style="background-color: #523f6d;">
										<div align="center"
											style="text-align: center;  color: #fff;">
											SEARCH CAR REQUESTER</div>
										<%
											String email = (String) session.getAttribute("user");
											GetUsedCarDetails requester = new GetUsedCarDetails();
											ArrayList<UsedCar> car = requester.getUsedCarId(email);
											Iterator it = car.iterator();
										%>

									</div>
									<br>
									<br>
									<div class="col-md-12"></div>
									<div class="col-md-1 col-sm-12 col-xs-12" style="margin-bottom:6px"><b>CAR ID</b></div>
									<div class="col-md-2 col-sm-12 ">
										<select name="carId" class="form-control " required
											oninvalid="this.setCustomValidity('Please select CarId')"
											oninput="setCustomValidity('')">
											<option value="">Select Car ID</option>
											<option value="all">ALL</option>
											<div class="form-group">
												<%
													while (it.hasNext()) {
														for (int i = 0; i < car.size(); i++) {
															UsedCar ac = (UsedCar) it.next();
												%>
												<option><%=ac.getGEN_CAR_ID()%></option>
												<%
													}
													}
												%>
											</div>
										</select>
									</div>

									<div class="col-md-1 col-sm-12" style="margin-bottom:6px"><b>
										FROM DATE</b></div>

									<div class="col-md-2" style="margin-bottom:6px">
										<input type="date" name="fdate" class="form-control "
											placeholder="Enter From DATE"></input>
									</div>
									<div class="col-md-1" style="margin-bottom:6px"><b>TO DATE</b></div>
									<div class="col-md-2" style="margin-bottom:6px">
										<input type="date" name="tdate" class="form-control " style="margin-bottom:6px"
											placeholder="Enter To DATE"></input>
									</div>
									<div class="col-md-1" align="center">
										<button TYPE="submit"
													style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
													class="btn btn-primary">SEARCH</button>
									</div>
									<div class="col-md-2"></div>
											<br><br>
											<div class="col-md-12" align="center">
										<%
												if (message != null) {
											%>
											<h5 style="color: red"> <%=message%> 
											</h5>
											<%
												} else {
												}
											%>
									</div>
								</form>
							</div>
							</section>
						</div>
					</div>
				</div>
			</div>
			</section> </article>
			<footer class="footer">
			<div class="footer-block buttons"></div>
			<div class="footer-block author">
				<ul>
					<li>created by <a href="#">Kosuri Soft Pvt Ltd</a>
					</li>
					<li><a href="www.kosurisoft.com">get in touch</a></li>
				</ul>
			</div>
			</footer>

			<!-- /.modal -->

			<!-- /.modal -->
		</div>
	</div>
	<!-- Reference block for JS -->
	<div class="ref" id="ref">
		<div class="color-primary"></div>
		<div class="chart">
			<div class="color-primary"></div>
			<div class="color-secondary"></div>
		</div>
	</div>
	<script language="javascript">
		populateBrands("brand", "model");
	</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>

</html>