<%@page import="com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl"%>
<%@page import="com.vaahanmitra.dao.BusinessOwnerRegisterDao,com.vaahanmitra.service.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			</div><br>
			<br><br>
			
			<%
			String email=(String)session.getAttribute("user"); 
			System.out.print("email"+email);
			BusinessOwnerService dao = new BusinessOwnerService();
			String carStatus="4,";
			String bikeStatus="2,";
			String car_status = dao.searchAuthentication(email,carStatus);
			String bike_status = dao.searchAuthentication(email,bikeStatus);
			%>
				<nav class="menu">
				<ul class="nav metismenu" id="sidebar-menu">
					<li><a href="./index.jsp"> <i class="fa fa-home"></i>HOME</a></li>
					<li><a href=""> <i class="fa fa-table"></i>PROFILE<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./viewUsedVehicleProfileH.jsp'>View</a></li>
							<li><a href='./updateUsedVehicleProfileH.jsp'>Update</a></li>
							<li><a href='./changeUsedVehicleDealerPassword.jsp'>Change Password</a></li>
						</ul></li>
					<li><a href=""> <i class="fa fa-car"></i>CAR<i
							class="fa arrow"></i>
					</a>
						<ul>
							<!-- <li><a href='./addDashboard2UsedCar.jsp'>Add Used Car</a></li> -->
 							<li><a href='./addUDUsedCar.jsp'>Add Used Car</a></li>
 							<%-- <%if(status!=null && !status.equals("null") && status.equals("No")){ %> --%>
 							<%if(car_status.equals("")){ %>
 								<li><a href='./addUDNewCar.jsp'>Add New Car</a></li>
							<%}else{ %>
								<li><a href="./addNewCarPrice.jsp">Add New Car Price</a></li>
								<li><a href="./newCarOffers.jsp">New Car Offers</a></li>
							<%} %>
							<li><a href="./addUDCarPhotos.jsp">Update Car Photos</a></li>
							<li><a href='./showDashboard2UsedCarsList.jsp'>Show Used Cars List</a></li>
							<!-- <li><a href='./udAdvdSearchCar.jsp'>Advanced Search</a></li> -->
						</ul></li>
					<li><a href=""> <i class="fa fa-motorcycle"></i>BIKE<i class="fa arrow"></i>
					</a>
						<ul>
<!-- 							<li><a href='./addDashboard2UsedBike.jsp'>Add Used Bike</a></li> -->
							<li><a href='./addUDUsedBike.jsp'>Add Used Bike</a></li>
			 				<%if(bike_status.equals("")){ %>
 								<li><a href='./addUDNewBike.jsp'>Add New Bike</a></li>
							<%}else{ %>
								<li><a href="./addNewBikePrice.jsp">Add New Bike Price</a></li>
								<li><a href="./newBikeOffers.jsp">New Bike Price</a></li>
							<%} %>
			 				
			 				<li><a href='./showDashboard2UsedBikeList.jsp'>Show Used Bike List </a></li>
			 				<li><a href="./addUDBikePhotos.jsp">Update Bike Photos</a></li>
							<!-- <li><a href='./udAdvdSearchBike.jsp'>Advanced Search</a></li> -->
						</ul></li>
						<li><a href=""> <i class="fa fa-envelope-square"></i>GET CARS & BIKES REQUESTER<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./usedVehicleGetRequester.jsp'>Search By Car ID</a></li>
							<li><a href='./usedVehicleDate.jsp'>Search Car By DATE </a></li>
							<li><a href='./usedVehicleBikeRequest.jsp'>Search By Bike ID</a></li>
							<li><a href='./usedVehicleBikeDate.jsp'>Search Bike By DATE </a></li>
						</ul></li>
					<li><a href=""><i class="fa fa-envelope-square"></i>REQUESTER CAR/BIKE<i
							class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./searchUDCarRequester.jsp'>Requested Cars</a></li>
							<li><a href='./searchUDBikeRequester.jsp'>Requested Bikes</a></li>
						</ul></li>
						
<!-- 						<li><a href='./logout.jsp'> <i class="fa fa-user"></i>Logout<i></i> -->

					<li><a href='./searchUDServiceApptOnDate.jsp'>REQUEST TO SERVICE CENTER </a></li>
					<li><a href='./searchUDDriverRequest.jsp'>REQUEST TO DRIVER </a></li>
					<li><a href='./driverUDEndUserReports.jsp'>REPORTS FROM DRIVER </a></li>
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