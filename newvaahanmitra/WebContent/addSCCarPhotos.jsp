<%
try {
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
    if (session.getAttribute("user")==null) {
    	%>
<jsp:forward page="./login3.jsp" ></jsp:forward>   <% }
    else {}
}
catch(Exception ex) {
    out.println(ex);
}
%>
<%@page import="com.vaahanmitra.model.Registration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<jsp:include page="./carMenu.jsp" />
<jsp:include page="./topMenu.jsp" />

<script src="./css/countries.js" type="text/javascript"></script>

<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<!-- Theme initialization -->
<script>
            var themeSettings = (localStorage.getItem('themeSettings')) ? JSON.parse(localStorage.getItem('themeSettings')) :
            {};
            var themeName = themeSettings.themeName || '';
            if (themeName)
            {
                document.write('<link rel="stylesheet" id="theme-style" href="css/app-' + themeName + '.css">');
            }
            else
            {
                document.write('<link rel="stylesheet" id="theme-style" href="css/app.css">');
            }
        </script>
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">

			<header class="">
			
			<!-- <div class="header-block header-block-collapse hidden-lg-up">
					<button class="collapse-btn" id="sidebar-collapse-btn">
						<i class="fa fa-bars"></i>
					</button>
				</div> -->

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
			<br>

			<article class="content responsive-tables-page"
				style="background-color:#fff">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div align="center" style="font-size: 25px">SERVICE CENTER DASHBOARD</div>
			</div>
			<section class="section">

			<div class="row">

				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive">
								<%
									String message = (String) request.getAttribute("success");
								%>
								<form action="./AddCarPhotos" enctype="multipart/form-data" method="post">
									<div class="col-md-12 col-xs-12" style="background-color: #2A3F54">
										<div align="center"
											style="text-align: center;  color: #fff;">
											<h5>UPDATE CAR PHOTOS</h5>
											<%
												String email = (String) session.getAttribute("user");
												GetUsedCarDetails requester = new GetUsedCarDetails();
												ArrayList<UsedCar> car = requester.getUsedCarNo(email);
												Iterator it = car.iterator();
											%>
										</div>
										</div>
										<br>
										<input type="hidden" name="userType" value="SC">
										<div class="col-md-12"><br></div>
									<div class="col-md-3 col-sm-12 col-xs-12" align="center" style="margin-bottom:6px"><b>CAR REGISTRATION NO</b></div>
									<div class="col-md-3 col-sm-12 col-xs-12" style="margin-bottom:6px">
												<select name="carNo" class="form-control" required >
													<option value="">Select Car ID</option>
														<%
																while (it.hasNext()) {
																	for (int i = 0; i < car.size(); i++) {
																		UsedCar ac = (UsedCar) it.next();
															%>
														<option><%=ac.getCAR_NUMBER()%></option>
														<%
																}
																}
															%>
												</select>
											</div>

											<div class="col-md-3 col-sm-12 col-xs-12 " align="center">
												<button TYPE="submit"
													style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
													class="btn btn-primary">SUBMIT</button>
											</div>
											<div class="col-md-2 "></div>
											<br><br>
											<div class="col-md-12 col-xs-12" align="center">
										<%
												if (message != null) {
											%>
											<h5 style="color: red"><%=message%>
											</h5>
											<%
												} else {
												}
											%>
									</div></form>
									</div>
						</div></div>
					</div>
				</div>
         </div>
        <!-- /page content -->
        <!-- footer content -->
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
			populateCountries("country2", "state");
		</script>
	<script language="javascript">
			populateCountries("country1", "state1");
		</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>
</html>