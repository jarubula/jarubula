<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.awt.Image,
 java.awt.image.BufferedImage,
java.io.ByteArrayInputStream,
 java.io.ByteArrayOutputStream,
 java.io.IOException,
 java.io.InputStream, javax.imageio.ImageIO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./carMenu.jsp"></jsp:include>
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
<script>
	function bigImg(x) {
		x.style.height = "100px";
		x.style.width = "100px";
	}

	function normalImg(x) {
		x.style.height = "80px";
		x.style.width = "80px";
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
			<header class="">
			<div class="header-block header-block-collapse hidden-lg-up">
				<button class="collapse-btn" id="sidebar-collapse-btn">
					<i class="fa fa-bars"></i>
				</button>
			</div>

			<div class="header-block header-block-nav"></div>
			</header>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<div class="col-md-12" align="center">
					<h3>SERVICE CENTER DASHBOARD</h3>
				</div>
				<div class="col-md-12">
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;border-radius: 10px">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;border-radius: 10px">
							<section class="example">
							<div class="col-md-12" align="center"
										style="background: #523f6d; color: #f1f1f1; border-radius: 10px">MECHANICS LIST</div>
							<div class="table-responsive"><br>
										<%
											String message = (String) request.getAttribute("message");
												if (message != null) {
											%>
												<h5 align="center"   class="text-primary"><%=message%></h5>
											<%
												} else {
												}
											%>
								<table class="table table-striped table-bordered table-hover">
									<%
										ArrayList<MechanicProfile> allMechanics = (ArrayList<MechanicProfile>) request.getAttribute("allMechanics");
									%>
									<tr>
										<th>NAME</th>
										<th>EMAIL ID</th>
										<th>MOBILE NO</th>
										<th>QUALIFICATION</th>
										<th>ADDRESS</th>
										<th>STATE</th>
										<th>DISTRICT</th>
										<th>EXPERIENCE</th>
										<th>SPECIALIZED IN</th>
										<th>UPDATE</th>
									</tr>
									<c:forEach var="allMechanics" items="${allMechanics}">
										<tr>
											<td><c:out value="${allMechanics.NAME}"></c:out></td>
											<td><c:out value="${allMechanics.EMAIL}"></c:out></td>
											<td><c:out value="${allMechanics.MOBILE_NO}"></c:out></td>
											<td><c:out value="${allMechanics.QUALIFICATION}"></c:out></td>
											<td><c:out value="${allMechanics.ADDRESS}"></c:out></td>
											<td><c:out value="${allMechanics.STATE}"></c:out></td>
											<td><c:out value="${allMechanics.DISTRICT}"></c:out></td>
											<td><c:out value="${allMechanics.EXPERIENCE}"></c:out></td>
											<td><c:out value="${allMechanics.SPECIALIZED_IN}"></c:out></td>
											<td><a href="./updateMechanic.jsp?eid=${allMechanics.EMAIL}" class="btn btn-primary" style="border-radius: 10px;">UPDATE</a></td>
										</tr>
									</c:forEach>
									</table>
								</div>
							</section>
						</div>
					</div>
				</div>
			</div>
		</section>
		</article>
		</div>

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
	<script type="text/javascript">
		function callMe(myId) {
			var popup = window.open('./showCarImage.jsp?photo=' + myId,'mywindow','width=2000,height=1000,titlebar=0,status=no,toolbar=no,location=no,directories=no');
		}
	</script>
</body>
</html>