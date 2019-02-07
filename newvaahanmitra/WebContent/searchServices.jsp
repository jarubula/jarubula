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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./carMenu.jsp" />
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
						<h3>SERVICE CENTER DASHBOARD</h3>
					</div>
				</div>


				<div class="col-md-12 col-xs-12 col-sm-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;border-radius:10px">
							<section class="example">
							<div class="table-responsive well">
								<form action="./SearchServices" method="post">
									<div class="col-md-12" style="background-color: #523f6d;">
										<div align="center"
											style="text-align: center; background-color: #523f6d; color: #fff;">
											SEARCH SERVICES
											<%
												String serviceId = (String)request.getAttribute("serviceId");
												String message = (String) request.getAttribute("message");
												String email = (String) session.getAttribute("user");
												GetServiceCenterDetails requester = new GetServiceCenterDetails();
												Set<ServiceType> serviceType = requester.getServiceId(email);
												Iterator it = serviceType.iterator();
											%>
											</div>
										</div>
										<br>
										<br>
										<div class="col-md-12"></div>
									<div class="col-md-3 col-sm-12" align="center" style="margin-bottom:6px"><b>SERVICE ID</b></div>
									<div class="col-md-3 col-sm-12 " style="margin-bottom: 6px">
										<div class="form-group">
											<select name="serviceId" class="form-control" required oninvalid="this.setCustomValidity('Please select Service Id')" oninput="setCustomValidity('')">
												<option value=""><%=(serviceId == null || serviceId.equals("null")) ? "Service Id": serviceId%></option>
												<option value="All">All</option>
												<%
													while (it.hasNext()) {
														ServiceType service = (ServiceType) it.next();
												%>
												<option><%=service.getSERVICE_ID()%></option>
												<%} %>
											</select>
										</div>
									</div>

									<div class="col-md-3 col-sm-12 " align="center">
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
											<h6 style="color: #ff7916"><%=message%>
											</h6>
											<%
												} else {
												}
											%>
									</div>
								</form>
							</div>
							</section>
						</div>
					</div><br>
				</div>
				<div class="row">
					<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;border-radius: 10px">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;border-radius: 10px">
							<section class="example">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<%
										ArrayList<ServiceType> services = (ArrayList<ServiceType>) request.getAttribute("services");
									%>
									<tr>
										<th>SERVICE ID</th>
										<th>SEERVIE TYPE</th>
										<th>VEHICLE TYPE</th>
										<th>VEHICLE BRAND</th>
										<th>PRICE</th>
										<th>DISCOUNT</th>
										<th>FINAL PRICE</th>
										<th>SERVICE DESCRIPTION</th>
									</tr>
									<c:forEach var="services" items="${services}">
										<tr>
											<td><c:out value="${services.SERVICE_ID}"></c:out></td>
											<td><c:out value="${services.SERVICE_TYPE}"></c:out></td>
											<td><c:out value="${services.VEHICLE_TYPE}"></c:out></td>
											<td><c:out value="${services.VEHICLE_BRAND}"></c:out></td>
											<td><c:out value="${services.PRICE}"></c:out></td>
											<td><c:out value="${services.DISCOUNT}"></c:out></td>
											<td><c:out value="${services.PRICE-service.DISCOUNT}"></c:out></td>
											<td><c:out value="${services.SERVICE_DESCRIPTION}"></c:out></td>
										</tr>
									</c:forEach>
								</table>
							</div>
							</section>
						</div>
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