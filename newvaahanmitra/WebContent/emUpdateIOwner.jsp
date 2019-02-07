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
<%@page import="com.vaahanmitra.model.IndividualOwnerRegister"%>
<%@page import="com.vaahanmitra.service.IndividualOwnerProfile"%>
<%@page import="com.vaahanmitra.model.EmployeeBean"%>
<%@page import="com.vaahanmitra.service.EmployeeService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./css/countries.js" type="text/javascript"></script>
<jsp:include page="./employeeMenu.jsp" />
<jsp:include page="./topMenu.jsp" />
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Vaahanmitra | AddServiceCentre</title>
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
<script src="./css/countries.js" type="text/javascript"></script>
<script language="javascript">
 	function validate() {
 		if(document.getElementById("pincodeNo").value!="")
 			{
 		if(document.getElementById("pincodeNo").value.length !=6 )
		 {
		  alert("Please enter 6 digits PINCODE No");
		  document.getElementById("pincodeNo").focus();
		  return false;
		 }
 			}
 		if(document.getElementById("phoneNo").value.length !=11 )
		 {
		  alert("Please enter 11 digits PHONE No.");
		  document.getElementById("phoneNo").focus();
		  return false;
		 }
 		if(document.getElementById("bpincodeNo").value.length !=6 )
		 {
		  alert("Please enter 6 digits BUSINESS PINCODE No");
		  document.getElementById("bpincodeNo").focus();
		  return false;
		 }
 		if(document.getElementById("mobileNo").value!="" )
		 {
 		if(document.getElementById("mobileNo").value.length !=10 )
		 {
		  alert("Please enter 10 digits PHONE No.");
		  document.getElementById("mobileNo").focus();
		  return false;
		 }
		 }
 		return true;
 	}

	function CheckNumeric(e) {
		  
	    if (window.event) // IE 
	    {
	        if ((e.keyCode < 48 || e.keyCode > 57) & e.keyCode != 8) {
	            event.returnValue = false;
	            return false;

	        }
	    }
	    else { // Fire Fox
	        if ((e.which < 48 || e.which > 57) & e.which != 8) {
	            e.preventDefault();
	            return false;

	        }
	    }
	}
	</script>
<style type="text/css">
.r_1 {
	border-radius: 10%;
	margin-top: 10px;
}
</style>
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">


			<header class="header">
			<div class="header-block header-block-collapse hidden-lg-up">
				<button class="collapse-btn" id="sidebar-collapse-btn">
					<i class="fa fa-bars"></i>
				</button>
			</div>

			<div class="header-block header-block-nav">
				<!--                         <ul class="nav-profile"> -->

				<!--                             <li class="profile dropdown"> -->
				<!--                                 <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"> -->
				<!--                                     <div class="img" style=""> </div> <span class="name"> Mohan Amasa</span> </a> -->
				<!--                                 <div class="dropdown-menu profile-dropdown-menu" aria-labelledby="dropdownMenu1"> -->

				<!--                                     <a class="dropdown-item" href="#"> <i class="fa fa-power-off icon"></i> Logout </a> -->
				<!--                                 </div> -->
				<!--                             </li> -->
				<!--                         </ul> -->
			</div>
			</header>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<div class="col-md-12">
					<!-- <div class="card" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-bottom: 3px solid #a3b745;">
                                    <div class="card-block" style="border-bottom: 3px solid #a3b745;">
                                    </div>
                                </div> -->
					<section class="example">
					<div class="table-responsive">
						<form name="frm" action="./UpdateIOwner" method="post"
							onSubmit="return validate()">
							<div class="container col-lg-10 col-md-10 col-sm-12 col-xsm-12">
								<div class="form-group">
									<div class="col-sm-12">
										<h5 align="center">
											<u>Add Individual Owner</u>
										</h5>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-12">
										<label for="email">
											<%try{if(request.getAttribute("message")!=null){out.println(request.getAttribute("message"));}}catch(Exception e){} %>
										</label>
									</div>
									<%
					                String email = request.getParameter("id");
									if(email == null || email.equals("null")){
										email = (String)request.getAttribute("id");
									}
					            	String message = (String)request.getAttribute("message");
					                /* String key=request.getParameter("k"); */
					                IndividualOwnerProfile bo=new IndividualOwnerProfile();
					                IndividualOwnerRegister ior=bo.getProfileDeatils(email);
					                %>
								</div>

								<div class="form-group">

									<div class="col-sm-6">
										<label for="email">FULL NAME <span style="color: red">*</span></label>
										 <input	type="text" class="form-control underlined" name="name"
											required value="<%=ior.getNAME() %>"  placeholder="Enter Full Name">
									</div>
									<input type="hidden" name="sid" value="<%=ior.getSEQUENTIAL_NO()%>">
									<div class="col-sm-6">
										<label for="password">EMAIL</label> <input type="text"
											class="form-control underlined" name="email" value="<%=ior.getEMAIL_ID()%>" 
											placeholder="Enter Email.">
									</div>

								</div>
								<div class="col-md-12"></div>
								<div class="form-group">
									<div class="col-sm-6">
										<label for="password">MOBILE NO</label> <input type="text"
											class="form-control underlined" name="mobileNo" value="<%=ior.getMOBILE_NO()%>"
											placeholder="Enter MobileNo.">
									</div>

									<div class="col-sm-6">
										<label for="password">PANCARD NO</label> <input type="text"
											class="form-control underlined" name="pancard" value="<%=ior.getPANCARD_NO()%>"
											placeholder="Enter Pancard">
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-6">
										<label>CITY<span style="color: red">*</span></label> <input
											class="form-control underlined" type="text" value="<%=ior.getCITY()%>"
											placeholder="Enter City" name="city" required>
									</div>

									<div class="col-sm-6">
										<label>PIN CODE<span style="color: red">*</span></label> <input
											class="form-control underlined" type="text" value="<%=ior.getPINCODE_NO()%>"
											placeholder="Enter Pincode" name="pincode" required>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-12">
										<label for="email">VEHICLE TYPE :<span
											style="color: red">*</span></label> <br> <input
											class=" underlined" type="checkbox" 
											name="vehicleType" id="vehicleType" value="2"> Two Wheeler <input
											class=" underlined" type="checkbox"
											name="vehicleType" id="vehicleType" value="4"> Four Wheeler
									</div>
									<div class="form-group">
										<div class="col-sm-12" align="center">
											<button type="submit" class="btn btn-primary r_1">Update</button>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
					</section>

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
	<!-- Reference block for JS -->
	<div class="ref" id="ref">
		<div class="color-primary"></div>
		<div class="chart">
			<div class="color-primary"></div>
			<div class="color-secondary"></div>
		</div>
	</div>
	<script language="javascript">
			populateCountries("country", "state");
		</script>
	<script language="javascript">
			populateCountries("country1", "state1");
		</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>
</html>