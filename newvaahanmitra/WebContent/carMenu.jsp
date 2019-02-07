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
				<nav class="menu">
				
				<ul class="nav metismenu" id="sidebar-menu">
				<li><a href="./index.jsp"> <i class="fa fa-home"></i>HOME</a></li>
					<li><a href=""> <i class="fa fa-table"></i>PROFILE<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./viewServiceCenterProfile.jsp'>View</a></li>
							<li><a href='./addServiceMechanic.jsp'>Update</a></li>
							<li><a href='./changeServiceCenterPassword.jsp'>Change Password</a></li>
						</ul></li>
					<li><a href=""> <i class="fa fa-car"></i>CAR<i
							class="fa arrow"></i>
					</a>
						<ul>
							<!-- <li><a href='./addCar.jsp'>Add Car</a></li> -->
<!-- 							<li><a href='./addUsedCar.jsp'>Add Used Car</a></li> -->
							<li><a href='./addSCUsedCar.jsp'>Add Used Car</a></li>
							<!-- <li><a href='./showCarModel.jsp'>Show Car Model</a></li>
							<li><a href='./showCarBrand.jsp'>Show Car Brand</a></li> -->
							<li><a href='./showUsedCarsList.jsp'>Show Used Cars List</a></li>
							<li><a href="./addSCCarPhotos.jsp">Update Car Photos</a></li>
						</ul></li>
					<li><a href=""> <i class="fa fa-motorcycle"></i>BIKE<i
							class="fa arrow"></i>
					</a>
						<ul>
<!-- 							<li><a href='./addBike.jsp'>Add Bike</a></li> -->
<!-- 							<li><a href='./addUsedBike.jsp'>Add Used Bike</a></li> -->
							<li><a href='./addSCUsedBike.jsp'>Add Used Bike</a></li>
							<!-- <li><a href='./showBikeBrand.jsp'>Show Bike Brand</a></li>
							<li><a href='./showBikeModel'>Show Bike Model</a></li> -->
							<li><a href='./showUsedBikeList.jsp'>Show Used Bike List </a></li>
							<li><a href='./addSCBikePhotos.jsp'>Update Bike Photos</a></li>
						</ul></li>
					<li><a href=""> <i class="fa fa-wrench"></i>SPARE PARTS<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./serviceCarSpareParts.jsp'>Add Spare Parts</a></li>
							<li><a href='./searchServiceSpareParts.jsp'>Search Spare Parts</a></li>
							<li><a href='./updateSCSparePartPrice.jsp'>Update Spare Parts Price</a></li>
						</ul></li>
					<li><a href=""> <i class="fa fa-cog"></i>SERVICE CENTERS<i
							class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./addServiceMechanic.jsp'>Update Service Center</a></li>
							<li><a href='./addMechanic.jsp'>Add Mechanic</a></li>
							<li><a href='./SearchServiceMechanic'>Update Mechanic</a></li>
							<li><a href='./ServiceCenterVehicleTypeController'>Vehicle Type</a></li>
							<li><a href='./carServiceType.jsp'>ServiceType</a></li>
							<li><a href='./getServiceType'>Update Service Price</a></li>
							<li><a href='./searchServices.jsp'>Search My Service</a></li>
						</ul></li>
					
					
					<li><a href=""> <i class="fa fa-envelope-square"></i>APPOINTMENT REQUESTER<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./searchServiceApptOnDate.jsp'>Search By Date</a></li>
							
						</ul></li>
					<li><a href=""> <i class="fa fa-envelope-square"></i>GET REQUESTER<i class="fa arrow"></i>
  					</a>
      					<ul>
       						<li><a href='./scSearchCarId.jsp'>Search By Car ID</a></li>
       						<li><a href='./scSearchCarDate.jsp'>Search Car By DATE </a></li>
       						<li><a href='./scSearchBikeId.jsp'>Search By Bike ID</a></li><!-- ./scSearchBikeId.jsp -->
       						<li><a href='./scSearchBikeDate.jsp'>Search Bike By DATE </a></li><!--./scSearchBikeDate.jsp-->
      					</ul></li>
      				
      				<li><a href=""> <i class="fa fa-envelope-square"></i>VEHICLE SERVICE<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./searchCarService.jsp'>Car Service</a></li>
							<li><a href='./searchBikeService.jsp'>Bike Service</a></li>
<!-- 							<li><a href='./billModification.jsp'>Bill Modification</a></li> -->

					</ul></li>
					<li><a href=""><i class="fa fa-envelope-square"></i>YOUR REQUESTER CAR/BIKE<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./searchSCCarRequester.jsp'>Your Request to Car</a></li>
							<li><a href='./searchSCBikeRequester.jsp'>Your Request to Bike</a></li>
						</ul></li>
						<li><a href='./searchSCServiceApptOnDate.jsp'>YOUR REQUEST TO SERVICE CENTER</a></li>
						<li><a href='./searchSCDriverRequest.jsp'>YOUR REQUEST TO DRIVER</a></li>
						<li><a href='./driverSCEndUserReports.jsp'>REPORTS FROM DRIVER</a></li>
					
<!-- 		<li><a href='./logout.jsp'> <i class="fa fa-user"></i>Logout<i></i> -->
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