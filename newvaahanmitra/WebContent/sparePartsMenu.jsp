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
					            <li><a href="./index.jsp"><i class="fa fa-home"></i>HOME</a></li>
							    <li><a href=""> <i class="fa fa-table"></i>PROFILE<i class="fa arrow"></i></a>
								<ul>
									<li><a href='./viewSpProfile.jsp'>View</a></li>
									<li><a href='./updateSpProfile.jsp'>Update</a></li>
									<li><a href='./changeSpPassword.jsp'>Change Password</a></li>
								</ul></li>
								
							    <li><a href=""><i class="fa fa-wrench"></i>SPARE PARTS MANAGEMENT
							    <i class="fa arrow"></i></a>
								<ul>
									<li><a href='./spareParts.jsp'>Add Spare Parts</a></li>
									<li><a href='./searchSpareParts.jsp'>Search Spare Parts</a></li>
									<li><a href='./updateSparePartPrice.jsp'>Update Spare Parts Price</a></li>
									<li><a href='./UploadSpareParts.jsp'>Upload Spare Parts</a></li>
								</ul>
								</li>
								
								<li><a href=""><i class="fa fa-male"></i>ORDER MANAGEMENT
							    <i class="fa arrow"></i></a>
								<ul>
									<li><a href='./orderRequest.jsp'>Order Request</a></li>
									<li><a href='./updateorderrequest.jsp'>Update Order Request</a></li>
									<li><a href='./orderstatus.jsp'>Order Status</a></li>
								</ul>
								</li>
								
								<li><a href=""><i class="fa fa-envelope-square"></i>YOUR REQUESTER CAR/BIKE<i class="fa arrow"></i> </a>
								<ul>
									<li><a href='./searchSPCarRequester.jsp'>Your Request to Car</a></li>
									<li><a href='./searchSPBikeRequester.jsp'>Your Request to Bike</a></li>
								</ul></li>
                                <!-- <li><a href='./logout.jsp'> <i class="fa fa-user"></i>Logout<i></i> -->

									<li><a href='./searchSPServiceApptOnDate.jsp'><i class="fa fa-server"></i>YOUR REQUEST TO SERVICE CENTER</a></li>
									<li><a href='./searchSPDriverRequest.jsp'><i class="fa fa-dribbble"></i>YOUR REQUEST TO DRIVER</a></li>
									<li><a href='./driverSPEndUserReports.jsp'> <i class="fa fa-user"></i>REPORTS FROM DRIVER<i></i></a></li>
									
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
