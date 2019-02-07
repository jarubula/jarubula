<%@ page language="java" import="com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*,java.io.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" trimDirectiveWhitespaces="true"%>

<!doctype html>
<html class="no-js" lang="en">

    <head>
    
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>VEHICLE TRACKING | Dashbord</title>
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
		<div class="overlay"></div>
            <div class="app" id="app">
                
                <%-- <aside class="sidebar">
                    <div class="sidebar-container">
                        <div class="sidebar-header">
                            <div class="brand" style="color:white;font-size: 23px;">VAAHAN <span style="color:#fec107;">MITRA</span></div>
                        </div>
                       <nav class="menu">
					<ul class="nav metismenu" id="sidebar-menu">
				<li><a href='./index.jsp'> <i class="fa fa-home"></i>Home</a></i>
					<li><a href="#"> <i class="fa fa-table"></i>PROFILE<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./ViewDriverProfile'>View</a></li>
							<li><a href='./UpdateDriverProfile'>Update</a></li>
							<li><a href='./driverChangePsw.jsp'>Change Password</a></li>
						</ul></li>
					<li><a href="./DriverAvailabilityd"> <i class="fa fa-car"></i>UPDATE DRIVER AVAILABILITY<i class="fa arrow"></i></a></li>

						<li><a href="./dExpectedSal.jsp"> <i class="fa fa-motercycle"></i>EXPECTED SALARY<i class="fa arrow"></i></a></li>
						
						<li><a href="./updateDriverSal.jsp"> <i class="fa fa-motercycle"></i>UPDATE SALARY<i class="fa arrow"></i></a></li>

										<%
 										String email=(String)session.getAttribute("user");
										GetDriverDetails gdd=new GetDriverDetails();
									String jobType=gdd.getDriverJobType(email);
										
										if(jobType!=null && jobType.equals("On Demand")){
										%>
						
						<li><a href="#"> <i class="fa fa-table"></i>On Demand<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href='./onDemandPreferredRoutes.jsp'>PREFERRED ROUTES</a></li>
							<li><a href='./UpdateOnDemandDriverRoutes'>UPDATE PREFERRED<br> ROUTES</a></li>	
						</ul></li>
						
						<%}else{ %>
 						<li><a href="./InsertDriverPreferredRoutes"> <i class="fa fa-motercycle"></i>PREFERRED ROUTES<i class="fa arrow"></i></a></li>
						
 						<li><a href="./UpdateDriverRoutes"> <i class="fa fa-motercycle"></i>UPDATE PREFERRED<br> ROUTES<i class="fa arrow"></i></a></li> 
						<%} %>
						
						
					<li><a href="./logout.jsp"> <i class="fa fa-motercycle"></i>Logout<i class="fa arrow"></i></a></li>
				</ul>
				</nav>
                    </div>
                </aside>  --%>
                <div class="sidebar-overlay" id="sidebar-overlay"></div>
              </div>
        </div>
		  <div class="main-wrapper">
            <div class="app" id="app">
                
                
                <header class="header" style="background-color: #523f6d">
				
                    <div class="header-block header-block-collapse hidden-lg-up"> <button class="collapse-btn" id="sidebar-collapse-btn">
    			<i class="fa fa-bars"></i>
    		</button>
			
			</div>
               
                <div class="header-block header-block-nav">
				 <%
				 	HttpSession sion = request.getSession(false);
        			String str = (String)sion.getAttribute("user"); 
        			String email=(String)session.getAttribute("user");
					GetDriverDetails gdd=new GetDriverDetails();
					String jobType=gdd.getDriverJobType(email);
        			if(jobType!=null && jobType.equals("On Demand")){
        			%>
        			
        			<div style="text-align: center;color: #fe974b;">On Demand Driver Dash Board</div>
        			
        			<%}else if(jobType!=null && jobType.equals("Full Time")){ %>
        			
        			  <div style="text-align: center;color: #fe974b;">Full Time Driver Dash Board</div>
        			
        			
        			<%} %>
        			
                        <ul class="nav-profile">
                            
                            <li class=" dropdown">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    <div class="img" > </div> <span class="name" style="color:#f5f5f5;"><b><%= str %></b> </span> </a>
                                <div class="dropdown-menu profile-dropdown-menu" aria-labelledby="dropdownMenu1">
                                   <a class="dropdown-item" href="./logout.jsp"> <i class="fa fa-power-off icon"></i> Logout </a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </header>
        <!-- Reference block for JS -->
		<div class="ref" id="ref">
            <div class="color-primary"></div>
            <div class="chart">
                <div class="color-primary"></div>
                <div class="color-secondary"></div>
            </div>
        </div>
		<footer class="footer">
                    <div class="footer-block buttons"></div>
                    <div class="footer-block author">
                        <ul>
                            <li> created by <a href="#">Kosuri Soft Pvt Ltd</a> </li>
                            <li> <a href="www.kosurisoft.com">get in touch</a> </li>
                        </ul>
                    </div>
                </footer>
				</div>
				</div>
				</body>
        <script src="js/vendor.js"></script>
        <script src="js/app.js"></script>
    </body>

</html>