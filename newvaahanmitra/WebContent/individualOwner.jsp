<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./Js/Vmenu.js"></script>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>VAAHANMITRA | Dashbord</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
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
				<nav class="menu">
				<ul class="nav metismenu" id="sidebar-menu">
				
					<li><a href="./index.jsp"> <i class="fa fa-home"></i>HOME</a></li>
					<li><a href=""> <i class="fa fa-table"></i>PROFILE<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./viewIndividualOwnerProfile.jsp'>View</a></li>
							<li><a href='./updateIndividualProfile.jsp'>Update</a></li>
							<li><a href='./changeIndividualOwnerPassword.jsp'>Change Password</a></li>
						</ul></li>
					<li><a href=""><i class="fa fa-automobile"></i> ADD USED CAR / BIKE<i class="fa arrow"></i>
					</a>
						<ul>
<!-- 							<li><a href='./individualUsedCar.jsp'>Used Car</a></li> -->
							<li><a href='./addIOUsedCar.jsp'>Used Car</a></li>
							<li><a href='./addlOUsedBike.jsp'>Used Bike</a></li>
<!-- 							<li><a href='./individualUsedBike.jsp'>Used Bike</a></li> -->

						</ul></li>
					<li><a href=""><i class="fa fa-search"></i>SEARCH CAR / BIKE<i
							class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./searchIndividualUsedCar.jsp'>Used Car</a></li>
							<li><a href="./addIOCarPhotos.jsp">Update Car Photos</a></li>
							<li><a href='./searchIndividualUsedBike.jsp'>Used Bike</a></li>
							<li><a href="./addIOBikePhotos.jsp">Update Bike Photos</a></li>
							<!-- <li><a href='./#'>Service Center</a></li>
							<li><a href='./searchIndividualSparepartShop.jsp'>SpareParts Shop</a></li>
							<li><a href='./searchIndividualServiceMechanic.jsp'>Service Mechanic</a></li> -->
						</ul></li>
					<li><a href=""><i class="fa fa-envelope-square"></i>GET REQUESTER<i
							class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./ioSearchCarId.jsp'> Search By Car ID  </a></li>
							<li><a href='./ioSearchCarDate.jsp'>Search Car By DATE</a></li>
							<li><a href='./ioSearchBikeId.jsp'> Search By Bike ID  </a></li>
							<li><a href='./ioSearchBikeDate.jsp'>Search Bike By DATE</a></li>
						</ul></li>
					<li><a href=""><i class="fa fa-envelope-square"></i>REQUESTER CAR/BIKE<i
					class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./searchIOCarRequester.jsp'>Request to Car</a></li>
							<li><a href='./searchIOBikeRequester.jsp'>Request to Bike</a></li>
						</ul></li>
					<!-- 						<li><a href='./logout.jsp'> <i class="fa fa-user"></i>Logout<i></i></a></li> -->
						<li><a href='./searchINOServiceApptOnDate.jsp'> <i class="fa fa-user"></i>REQUEST TO SERVICE CENTER<i></i></a></li>
						<li><a href='./searchIODriverRequest.jsp'> <i class="fa fa-user"></i>REQUEST TO DRIVER<i></i></a></li>
						<li><a href='./driverIOEndUserReports.jsp'> <i class="fa fa-user"></i>REPORTS FROM DRIVER<i></i></a></li>
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