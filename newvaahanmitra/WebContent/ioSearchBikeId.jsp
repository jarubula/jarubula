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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<jsp:include page="./individualOwner.jsp" />
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
						<h3>INDIVIDUAL OWNER DASHBOARD</h3>
					</div>
				</div>


				<div class="col-md-12 col-xs-12 col-sm-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745; border-radius: 10px">
						<div class="card-block"
							style="border-bottom: 3px solid #a3b745; border-radius: 10px">
							<section class="example">
							<div class="table-responsive well">
								<%
									String message = (String) request.getAttribute("failure");
								%>
								<form action="./IOSearchBikeIdController" method="post">
									<div class="col-md-12"
										style="background-color: #523f6d; border-radius: 10px;">
										<div align="center"
											style="background: #523f6d; color: #f1f1f1;">
											SEARCH BIKE REQUESTER
											<%
											String email = (String) session.getAttribute("user");
											GetBikeBrands requester = new GetBikeBrands();
											ArrayList<UsedBike> bike = requester.getUsedBikeId(email);
											Iterator it = bike.iterator();
										%>
										</div>
									</div>
									<br> <br>
									<div class="col-md-12"></div>
									<div class="col-md-3 col-sm-12" align="center"
										style="margin-bottom: 6px">
										<b>BIKE ID</b>
									</div>
									<div class="col-md-3 col-sm-12 " style="margin-bottom: 6px">
										<select name="bikeId" class="form-control" required
											oninvalid="this.setCustomValidity('Please select BikeId')"
											oninput="setCustomValidity('')">
											<option value="">Select Bike ID</option>
											<option value="all">ALL</option>
											<div class="form-group">
												<%
													while (it.hasNext()) {
														for (int i = 0; i < bike.size(); i++) {
															UsedBike ub = (UsedBike) it.next();
												%>
												<option><%=ub.getGEN_BIKE_ID()%></option>
												<%
													}
													}
												%>
											</div>
										</select>
									</div>

									<div class="col-md-3 col-sm-12 " align="center">
										<button TYPE="submit"
											style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
											class="btn btn-primary">SEARCH</button>
									</div>
									<div class="col-md-2"></div>
									<br>
									<br>
									<div class="col-md-12" align="center">
										<%
											if (message != null) {
										%>
										<h5 style="color: red"><%=message%>
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

	<div class="ref" id="ref">
		<div class="color-primary"></div>
		<div class="chart">
			<div class="color-primary"></div>
			<div class="color-secondary"></div>
		</div>
	</div>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
	<script language="javascript">
		populateBrands("brand", "model");
	</script>
	<pre>
 	</pre>
	<footer>Copyright &copy; vehicletracking.com</footer>
</body>
</html>