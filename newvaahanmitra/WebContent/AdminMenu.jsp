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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./Js/Vmenu.js"></script>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>VaahanMitra | Dashbord</title>
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
					<li><a href=""> <i class="fa fa-user"></i> Individual Owner<i
							class="fa arrow"></i>
					</a>
						<ul>
							<li><a href="./GetIndividualOwner">View All</a></li>
							<li><a href='./GetIndividualOwnerActina'>Active/Inactive</a></li>
							<li><a href='./AdSearchInOwner'>Search Owner</a></li>
						</ul></li>
					<li><a href=""> <i class="fa fa-wrench"></i> Spare Parts Shop<i
							class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./AdAddSparePartsShop.jsp'>Add Shop</a></li>
							<li><a href='./GetServiceMechanics?k=SP'>View Shops</a></li>
							<li><a href='./GetBusinessOwners?k=SP'>Active/Inactive</a></li>
							<li><a href='./AdSearchBsOwner?k=SP'>Search Service Center</a></li>
						</ul></li>
					<li><a href=""> <i class="fa fa-cog"></i> Service Center<i
							class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./AdAddServiceMechanic.jsp'>Add Service Center</a></li>
							<li><a href='./GetServiceMechanics?k=SC'>View All</a></li>
							<li><a href='./GetBusinessOwners?k=SC'>Active/Inactive</a></li>
							<li><a href='./AdSearchBsOwner?k=SC'>Search Service Center</a></li>
						</ul></li>
						<li><a href=""> <i class="fa fa-user"></i> Dealer<i
							class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./AdAddDealer.jsp'>Add Dealer</a></li>
							<li><a href='./GetServiceMechanics?k=UD'>View Dealer</a></li>
							<li><a href='./GetBusinessOwners?k=UD'>Active/Inactive</a></li>
							<li><a href='./AdSearchBsOwner?k=UD'>Search Vehicle Dealer</a></li>
							<li><a href='./AdSearchBsOwner?k=UD&j=UDB'>Assign Brands To Dealer</a></li>
						</ul></li>
						
					<li><a href=""> 
						<i class="fa fa-car"></i> Driver<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='#'>View Driver</a></li>
							<li><a href='#'>Active/Inactive</a></li>
							<li><a href='./adSearchDriver.jsp'>Search Driver List</a></li>
						</ul>
						</li>
					<li><a href=""> 
						<i class="fa fa-user"></i> User Management<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./adAddEmployee.jsp'>Add Employee</a></li>
							<li><a href='./AdAssignRole'>Assign Role</a></li>
						</ul>
						</li>
						<li><a href=""> 
						<i class="fa fa-car"></i> Car Master<i class="fa arrow"></i>
					</a>
						<ul>
							<!-- <li><a href='./AaddCar.jsp'>Add Car</a></li> -->
							<li><a href='./addNewCar.jsp'>Add New Car</a></li>
							<li><a href='./aUpdateNewCarDetails.jsp'>Update Car</a></li>
							<li><a href='./adNewCarPhotos.jsp'>Add Car Photos</a></li>
							<li><a href='./aAddExshowRoomPrice.jsp'>Add Exshowrrom price</a></li>
							<li><a href='./AddNewCars.jsp'>Add New Cars</a></li>
							<!-- <li><a href='./AshowCarModel.jsp'>Show Car Model</a></li>
							<li><a href='./AshowCarBrand.jsp'>Show Car Brand</a></li>
							<li><a href='./AshowUsedCarsList.jsp'>Show Used Cars List</a></li> -->
						</ul>
						</li>
						<li><a href=""> 
						<i class="fa fa-motorcycle"></i> Bike Master<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./AdAddBike.jsp'>Add New Bike</a></li>
							<li><a href='./aUpdateNewBikeDetails.jsp'>Update Bike</a></li>
							<li><a href='./adNewBikePhotos.jsp'>Add Bike Photos</a></li>
								<li><a href='./aAddBikeExshowRoomprice.jsp'>Add Exshowrrom price</a></li>
								<li><a href='./AddNewBikes.jsp'>Add New Bikes</a></li>
							<!-- <li><a href='#'>Show Bike Model</a></li>
							<li><a href='#'>Show Bike Brand</a></li>
							<li><a href='#'>Show Used Bikes List</a></li> -->
						</ul>
						</li>
						<li><a href=""> 
						<i class="fa fa-user"></i>Verified Dealer<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./dealerAuthentication.jsp'>Verified Dealer</a></li>
						</ul>
						</li>
						<li><a href=""> 
						<i class="fa fa-user"></i>Store Management<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./StoreLocator.jsp'>Store Locator</a></li>
						</ul>
						</li>
						<li><a href="./logout.jsp"> <i class="fa fa-user"></i>Logout</a> </li>
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