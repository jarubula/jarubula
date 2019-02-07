<%@ page language="java" import="com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*,java.io.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="./Js/Vmenu.js"></script>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>VAAHANMITRA | Dashbord</title>
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

			<aside class="sidebar">
			<div class="sidebar-container">
			<div class="col-md-12 col-xs-12 col-sm-12">
    <a class="navbar-brand" href="./index.jsp">
                           <h2 style="color:#fff;margin-top:4px;font-weight:600;">Vaahan<span style="margin-left:2px; color:#fec107;">Mitra</span></h2>
                        </a>
   </div><br><br><br>
				<nav class="menu">
				<ul class="nav metismenu" id="sidebar-menu">
				<li><a href='./index.jsp'> <i class="fa fa-home"></i>Home</a></i>
					<li><a href="#"> <!-- <i class="fa fa-table"></i> -->PROFILE<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./ViewDriverProfile'>View</a></li>
							<li><a href='./UpdateDriverProfile'>Update</a></li>
							<li><a href='./driverChangePsw.jsp'>Change Password</a></li>
						</ul></li>
						
						<%
						String email=(String)session.getAttribute("user");
						GetDriverDetails gdd=new GetDriverDetails();
						String jobType=gdd.getDriverJobType(email);
						String count=gdd.getDriverRequesterNotification(email);
						
						%>
						


										<%
										
										if(jobType!=null && jobType.equals("On Demand")){
										%>
						
						<li><a href="#"><!--  <i class="fa fa-table"></i> -->ON DEMAND<i class="fa arrow"></i>
					</a>
					
						<ul>
							<li><a href='./onDemandExpectedAmount.jsp'>Expected Amount</a></li>
							<li><a href='./updateOnDemandAmount.jsp'>Update Amount</a></li>
							<li><a href='./onDemandPreferredRoutes.jsp'>Preferred Routes</a></li>
							<li><a href='./UpdateOnDemandDriverRoutes'>Update Preferred<br> Routes</a></li>	
							<li><a href='./UpdateRequesterNotification'>Passenger Requester<font color="red"><%="+"+count %></font></a></li>
							<li><a href='./driverReports.jsp'>Reports</a></li>	
						</ul></li>
						
						<%}else{ %>
						<li><a href="./dExpectedSal.jsp"><!--  <i class="fa fa-motercycle"></i> -->EXPECTED SALARY<!-- <i class="fa arrow"></i> --></a></li>
						
						<li><a href="./updateDriverSal.jsp"> <!-- <i class="fa fa-motercycle"></i> -->UPDATE SALARY<!-- <i class="fa arrow"></i> --></a></li>
<!-- 						<li><a href="./InsertDriverPreferredRoutes"> <i class="fa fa-motercycle"></i>PREFERRED ROUTES<i class="fa arrow"></i></a></li>
						
						<li><a href="./UpdateDriverRoutes"> <i class="fa fa-motercycle"></i>UPDATE PREFERRED<br> ROUTES<i class="fa arrow"></i></a></li> -->
						<%} %>
						
							
							<li><a href="./DriverAvailabilityd"><!--  <i class="fa fa-car"></i> -->UPDATE DRIVER AVAILABILITY<!-- <i class="fa arrow"></i> --></a></li>
												
							<li><a href='./searchDriverServiceAppt.jsp'>YOUR REQUEST TO SERVICE CENTER</a></li>
							<li><a href='./searchDRDriverRequest.jsp'>YOUR REQUEST TO DRIVER</a></li>
							<li><a href='./driverEndUserReports.jsp'>REPORTS FROM DRIVER</a></li>
					<li><a href=""><i class="fa fa-envelope-square"></i>YOUR REQUESTER CAR/BIKE<i
							class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./searchDRCarRequester.jsp'>Your Request to Car</a></li>
							<li><a href='./searchDRBikeRequester.jsp'>Your Request to Bike</a></li>
						</ul></li>
						
					<li><a href="./logout.jsp"><!--  <i class="fa fa-motercycle"></i> -->Logout<!-- <i class="fa arrow"></i> --></a></li>
				</ul>
				</nav>
			</div>
			</aside>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>


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