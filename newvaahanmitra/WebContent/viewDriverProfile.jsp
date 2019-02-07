<%@ page language="java" import="com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*,java.io.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" trimDirectiveWhitespaces="true" errorPage="./errorPage.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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

<script src="./css/countries.js" type="text/javascript"></script>
<jsp:include page="./driverDashboard.jsp" />
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<!-- Theme initialization -->
<script language="javascript">

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

			<header class="" style="font-family: 'Oswald', sans-serif;">
			<!-- <div class="col-md-6 col-sm-12 col-xs-12">
				<div class="brand" style="color: white; font-size: 23px;">
					<h2>
						Vaahan<span style="color: #fec107;">Mitra
					</h2>
					</span>
				</div>
			</div>
			<div class="col-md-4"></div>
			<div class="col-md-2 col-xs-12 col-sm-12">
				<div class="dropdown pull-right">
					<button class="btn  dropdown-toggle" type="button"
						data-toggle="dropdown" style="background-color: #fec107">
						Santhosh <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">

						<li><a class="dropdown-item" href="#"> <i
								class="fa fa-power-off icon"></i> Logout
						</a></li>
					</ul>
				</div>
			</div> --> <!-- <div class="header-block header-block-collapse hidden-lg-up">
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
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<%-- <div class="col-md-12 col-sm-12 col-xs-12">
					<%
					ArrayList<DriverBean> driverDetails=(ArrayList<DriverBean>)request.getAttribute("driverDetails");
					%>
					<div align="center">
						<h3>SERVICE CENTER DASHBOARD</h3>
					</div>
				</div> --%>
				<%
					ArrayList<DriverBean> driverDetails=(ArrayList<DriverBean>)request.getAttribute("driverDetails");
					%>
				<div class="col-md-12 col-xs-12 col-sm-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="">
							<div class="" >
								<!-- <form action="./updateUsedVehicleProfileController"
									method="post" onSubmit="return validate()"> -->
								<%-- 	<%
										if (message != null) {
									%>
									<h4 style="color: red"><%=message%>
									</h4>
									<%
										} else {
										}
									%> --%>

									<div class="col-md-12 col-sm-12 col-xs-12" align="center"
										style="text-align: center; background-color: #052963; color: #fff;height: 45px; padding: 10px;font-weight: bolder;">
										 DRIVER PROFILE</div>
									<br>
									<br>
									<%-- <%
										String email = (String) session.getAttribute("user");
										BusinessOwnerService profile = new BusinessOwnerService();
										BusinessOwnerRegister view = profile.getProfileDetails(email);
									%> --%>
									
									 <c:forEach var="driverDetails" items="${driverDetails}">
									
									
									<div class="col-md-12 col-xs-12 col-sm-12" align="right">
										<img src="data:image/png;base64,${driverDetails.PHOTO}"
											alt="No image" width="150px" height="120px">


									</div>
									
									<div class="col-md-12 col-sm-12 col-xs-12 well"
										style="font-weight: 700; font-size: 700; color: red; text-align: left;">

										BASIC DETAILS</div>


									<div class="col-md-12 col-xs-12 col-sm-12">
										<br>
										<br>
									</div>

									<div class="row">

										<div class="col-md-3">
											<b>FIRST NAME</b>

										</div>

										<div class="col-md-3">
											<div class="form-group">
												<c:out value="${driverDetails.FIRST_NAME}"></c:out>
											</div>


										</div>
										<div class="col-md-3">
											<b>LAST NAME</b>

										</div>
										<div class="col-md-3" align="left">
											<div class="form-group">
												<c:out value="${driverDetails.LAST_NAME}"></c:out>
											</div>

										</div>
										<div class="col-md-3">
											<b>EMAIL</b>

										</div>
										<div class="col-md-3">
											<div class="form-group">
												<c:out value="${driverDetails.EMAIL}"></c:out>
											</div>

										</div>
										<div class="col-md-3">
											<b>MOBILE NO</b>

										</div>
										<div class="col-md-3">
											<div class="form-group">
												<c:out value="${driverDetails.MOBILE_NO}"></c:out>
											</div>

										</div>
										<div class="col-md-3">
											<b>DOB</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<c:out value="${driverDetails.DOB}"></c:out>
											</div>
										</div>
										
										
										<div class="col-md-12"
											style="font-weight: 700; font-size: 700; color: red; text-align: left;">
											CONTACT DETAILS</div>
											
											<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
											<br>
										</div>
											
										
										<div class="col-md-3">
											<b>ADDRESS</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												 <c:out value="${driverDetails.ADDRESS}"></c:out>
											</div>
										</div>

										<hr>
										<!-- <div class="col-md-12"
											style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;">
											BUSINESS ADDRESS</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
											<br>
										</div> -->
										<div class="col-md-3">
											<b>STREET</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<c:out value="${driverDetails.STREET}"></c:out>
											</div>

										</div>
										<div class="col-md-6"></div>

										<div class="col-md-3">
											<b>CITY</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<c:out value="${driverDetails.CITY}"></c:out>
											</div>
										</div>
										<div class="col-md-3">
											<b>STATE</b>
										</div>
										<div class="col-md-3">
											 <c:out value="${driverDetails.STATE}"></c:out>
										</div>
										<div class="col-md-3">
											<b>DISTRICT</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<c:out value="${driverDetails.DISTRICT}"></c:out>
											</div>
										</div>
										<div class="col-md-3">
											<b>MANDAL</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<c:out value="${driverDetails.MANDAL}"></c:out>
											</div>
										</div>
										
										<div class="col-md-12"
											style="font-weight: 700; font-size: 700; color: red; text-align: left;">
											DRIVING DETAILS</div>
											
											<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
											<br>
										</div>
											
										
										<div class="col-md-3">
											<b>LICENSE REGISTERED STATE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<c:out value="${driverDetails.REGISTERED_STATE}"></c:out>
											</div>
										</div>
										<div class="col-md-3">
											<b>LICENSE NO</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<c:out value="${driverDetails.LICENSE_NO}"></c:out>
											</div>
										</div>
										<div class="col-md-3">
											<b>LICENSE TYPE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												 <c:out value="${driverDetails.LICENSE_TYPE}"></c:out>
											</div>
										</div>
										<div class="col-md-3">
											<b>EXPIRY DATE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<c:out value="${driverDetails.EXPIRY_DATE}"></c:out>
											</div>
										</div>
										<div class="col-md-3">
											<b>DRIVING EXPERIENCE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												 <c:out value="${driverDetails.DRIVING_EXP}"></c:out>
											</div>
										</div>
										<div class="col-md-3">
											<b>PERMIT TYPE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<c:out value="${driverDetails.PERMIT_TYPE}"></c:out>
											</div>
										</div>
										<div class="col-md-3">
											<b>WITHIN RANGE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												 <c:out value="${driverDetails.WITHIN_RANGE}"></c:out>
											</div>
										</div>
										<div class="col-md-3">
											<b>JOB TYPE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<c:out value="${driverDetails.JOB_TYPE}"></c:out>
											</div>
										</div>
										
										<div class="col-md-12"
											style="font-weight: 700; font-size: 700; color: red; text-align: left;">
											OTHER DETAILS</div>
											
											<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
											<br>
										</div>
											
										<div class="col-md-3">
											<b>ADHAR CARD NO</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<c:out value="${driverDetails.ADHAR_NO}"></c:out>
											</div>
										</div>
											<div class="col-md-3">
											<b>PAN CARD NO</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<c:out value="${driverDetails.PAN_NO}"></c:out>
											</div>
										</div>
										
										
									</div>	

  </c:forEach>




									</div>






								<!-- </form> -->
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