<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*"
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
				<%
					String userEmail = (String) session.getAttribute("user");
					EmployeeDao dao = new EmployeeDaoImpl();
					String roles = dao.getAssignRole(userEmail);
					System.out.println("roles"+roles);
					String SC=null,IO=null,UD=null,SP=null,DR=null;
					String[] role=roles.split(",");//splits the string based on whitespace  
					//using java foreach loop to print elements of string array  
					for(String r:role){  
						if(r.equals("SC")){
							SC="SC";
						}else if(r.equals("IO")){
							IO="IO";
						}else if(r.equals("UD")){
							UD="UD";
						}else if(r.equals("SP")){
							SP="SP";
						}else if(r.equals("DR")){
							DR="DR";
						}
					}  
				%>
				<ul class="nav metismenu" id="sidebar-menu">
				<li><a href="./index.jsp"> <i class="fa fa-home"></i>HOME</a></li>
					<li><a href=""> <i class="fa fa-table"></i>PROFILE<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='#'>View</a></li>
							<li><a href='#'>Update</a></li>
							<li><a href='#'>Change Password</a></li>
						</ul></li>
					<li><a href=""> <i class="fa "></i>SERVICES<i
							class="fa arrow"></i>
					</a>
						<ul>
							<%if(SC!=null){ %>
							<li><a href='./emAddServiceCenter.jsp'>Add Service Center</a></li>
							<%}if(IO!=null){%>
							<li><a href='./emAddIOwner.jsp'>Add Individual Owner</a></li>
							<%}if(UD!=null){%>
							<li><a href='./emAddDealer.jsp'>Add Dealer</a></li>
							<%}if(DR!=null){%>
							<li><a href='#'>Add Driver</a></li>
							<%}if(SP!=null){%>
							<li><a href='./emAddSparePartsShop.jsp'>Add Spare Parts Shop</a></li>
							<%}%>
						</ul></li>
					<li><a href=""> <i class="fa "></i>SEARCH SERVICES<i
							class="fa arrow"></i>
					</a>
						<ul>
							<%if(SC!=null){ %>
							<li><a href='./EMSearchBSOwner?k=SC'>Search Service Center</a></li>
							<%}if(IO!=null){%>
							<li><a href='./EMSearchIOwner?k=IO'>Search Individual Owner</a></li>
							<%}if(UD!=null){%>
							<li><a href='./EMSearchBSOwner?k=UD'>Search Dealer</a></li>
							<%}if(DR!=null){%>
							<li><a href='#'>Search Driver</a></li>
							<%}if(SP!=null){%>
							<li><a href='./EMSearchBSOwner?k=SP'>Search Spare Parts Shop</a></li>
							<%}%>
						</ul></li>
					<li><a href=""> <i class="fa "></i>REPORTS<i
							class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='#'>Report1</a></li>
							<li><a href='#'>Report2</a></li>
						</ul></li>
					
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