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
<!doctype html>
<html class="no-js" lang="en">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*"
	pageEncoding="ISO-8859-1"%>
<head>
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<style type="text/css">
.box {
	padding: 20px;
	/* 	display: none; */
	margin-top: 20px;
}

.red {
	background:;
}

.green {
	background:;
}

.blue {
	background:;
}
</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js"></script>
<!-- <script language="javascript"> -->
<!-- // 	function validate() { -->
<!-- // 		var chks = document.getElementsByName('vehicle'); -->
<!-- // 		var hasChecked = false; -->
<!-- // 		for (var i = 0; i < chks.length; i++) { -->
<!-- // 			if (chks[i].checked) { -->
<!-- // 				hasChecked = true; -->
<!-- // 				break; -->
<!-- // 			} -->
<!-- // 		} -->
<!-- // 		if (hasChecked == false) { -->
<!-- // 			alert("Please select at least one."); -->
<!-- // 			return false; -->
<!-- // 		} -->
<!-- // 		return true; -->
<!-- // 	} -->
<!-- </script> -->
<meta charset="utf-8">
<jsp:include page="./carMenu.jsp" />
<jsp:include page="./topMenu.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>VAAHANMITRA</title>
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
	function showBrand(str) {
		if (str == "") {
			document.getElementById("txtHint1").innerHTML = "";
			return;
		}
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("txtHint1").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./bikeModels.jsp?brandid=" + str, true);
		xmlhttp.send();

	}
</script>
<script>
	function displayBikeModels(str) {
		if (str == "") {
			document.getElementById("bikeModelBlock").innerHTML = "";
			return;
		}
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari  
			xmlhttp = new XMLHttpRequest();
		} else {
			// code for IE6, IE5  
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("bikeModelBlock").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./bikeModels.jsp?bikeBrand=" + str, true);
		xmlhttp.send();
	}
</script>
</head>

<body>
	<%
		String msg = (String) request.getAttribute("true");
	%>
	<div class="main-wrapper">
		<div class="app" id="app">
			<header class="header">
				<div class="header-block header-block-collapse hidden-lg-up">
					<button class="collapse-btn" id="sidebar-collapse-btn">
						<i class="fa fa-bars"></i>
					</button>
				</div>

				<div class="header-block header-block-nav">
					<!-- 					<ul class="nav-profile"> -->

					<!-- 						<li class="profile dropdown"><a -->
					<!-- 							class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" -->
					<!-- 							role="button" aria-haspopup="true" aria-expanded="false"> -->
					<!-- 								<div class="img" style=""></div> <span class="name"> -->
					<!-- 									Mohan Amasa</span> -->
					<!-- 						</a> -->
					<!-- 							<div class="dropdown-menu profile-dropdown-menu" -->
					<!-- 								aria-labelledby="dropdownMenu1"> -->

					<!-- 								<a class="dropdown-item" href="#"> <i -->
					<!-- 									class="fa fa-power-off icon"></i> Logout -->
					<!-- 								</a> -->
					<!-- 							</div></li> -->
					<!-- 					</ul> -->
				</div>
			</header>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content responsive-tables-page">
				<section class="section">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-block"
									style="border-bottom: 3px solid #a3b745;">
									<section class="example">
										<div class="table-responsive">
											<form name="form1" action="./VehicleTypeController"
												method="post" onSubmit="return validate()">
												<table
													class="table table-striped table-bordered table-hover">
													<thead>
														<tr>
															<th colspan="4"
																style="text-align: center; background-color: #523f6d; color: #fff;">VEHICLE
																TYPES</th>
														</tr>
														<%
															if (msg != null) {
														%>
														<h4 style="color: red"><%=msg%>
														</h4>
														<%
															} else {
															}
														%>
													</thead>
													<tbody>
														<tr>
															<td>Choose Vehicle Type</td>
															<td>
																<div class="form-group">
																	<label><input type="radio" name="vehicleType"
																		value="FOUR" onclick="location.href='carType2.jsp'"
																		checked> FOUR WHEELER </input></label> <label><input
																		type="radio" name="vehicleType" value="TWO"
																		onclick="location.href='bikeType2.jsp'" checked>
																		TWO WHEELER </input></label>
																</div>
															</td>
														</tr>
														<tr>
															<td>Bike Brand</td>
															<td><jsp:include page="./getBikeBrand.jsp" /></td>
														</tr>
														<tr>
															<td colspan="2">
																<div id="bikeModelBlock"></div>
															</td>
														</tr>
														<tr>
															<td colspan="2" style="text-align: center;"><input
																type="submit" value="SUBMIT" class="btn-sm btn-primary" /></td>
														</tr>
													</tbody>
												</table>
											</form>
										</div>
									</section>
								</div>
							</div>
						</div>
					</div>
				</section>
			</article>
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
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>

</html>