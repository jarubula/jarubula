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
<%@page import="com.vaahanmitra.model.BusinessOwnerRegister"%>
<%@page import="com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl"%>
<%@page import="com.vaahanmitra.dao.BusinessOwnerRegisterDao"%>
<%@page
	import="com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl.*,com.vaahanmitra.dao.BusinessOwnerRegisterDao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./carsandBikes.jsp" />
<jsp:include page="./topMenu.jsp" />
<script src="./css/countries.js" type="text/javascript"></script>
<script language="javascript">
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
</head>
<body>
	<div class="main-wrapper">
		<div class="app" id="app">

			<header class="" style="font-family: 'Oswald', sans-serif;">
			
			
			<div class="header-block header-block-nav">


				<button class="collapse-btn" id="sidebar-collapse-btn">
					<i class="fa fa-bars"></i>
				</button>
			</div>

			<div class="header-block header-block-nav">
			</div>
			</header>
			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div align="center">
						<h3>USED VEHICLE DEALER DASHBOARD</h3>
					</div>
				</div>


				<div class="col-md-12 col-xs-12 col-sm-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="">
							<div class="">
								<%
									String message = (String) request.getAttribute("failure");
								%>

								<form action="./updateUsedVehicleProfileController"
									method="post" onSubmit="return validate()">

									<div class="col-md-12 col-sm-12 col-xs-12" align="center"
										style="text-align: center; background-color: #523f6d; color: #fff;">
										VIEW PROFILE</div>
									<br>
									<br>
									<%
										String email = (String) session.getAttribute("user");
										BusinessOwnerRegisterDao bDao = new BusinessOwnerRegisterDaoImpl();
										BusinessOwnerRegister bor = bDao.getAddressDetails(email);
									%>
									<div class="col-md-12 col-sm-12 col-xs-12 well"
										style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;">

										BASIC INFORMATION</div>
									<div class="col-md-12 col-xs-12 col-sm-12">
										<br>
										<br>
									</div>

									<div class="row">
										<%-- <%
												String email = (String) session.getAttribute("user");
												GetBikeBrands requester = new GetBikeBrands();
												ArrayList<UsedBike> bike = requester.getUsedBikeId(email);
												Iterator it = bike.iterator();
											%> --%>
										<div class="col-md-3">
											<b>BUSINESS NAME</b>

										</div>

										<div class="col-md-3">
											<div class="form-group"><%=bor.getBUSINESS_NAME()%></div>


										</div>
										<div class="col-md-3">
											<b>PANCARD</b>

										</div>
										<div class="col-md-3" align="left">
											<div class="form-group"><%=bor.getPANCARD_NO()%></div>

										</div>
										<div class="col-md-3">
											<b>NAME</b>

										</div>
										<div class="col-md-3">
											<div class="form-group"><%=bor.getNAME()%></div>

										</div>
										<div class="col-md-3">
											<b>MOBILE NO</b>

										</div>
										<div class="col-md-3">
											<div class="form-group"><%=bor.getMOBILE_NO()%></div>

										</div>
										<div class="col-md-3">
											<b>EMAIL</b>
										</div>
										<div class="col-md-3">
											<div class="form-group"><%=bor.getEMAIL_ID()%></div>
										</div>
										<div class="col-md-3"></div>
										<div class="col-md-3"></div>

										<div class="col-md-3">
											<b>CITY</b>
										</div>
										<div class="col-md-3">
											<div class="form-group"><%=bor.getCITY()%></div>
										</div>
										<div class="col-md-3">
											<b>PINCODE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group"><%=bor.getPINCODE_NO()%></div>
										</div>
										<div class="col-md-12"
											style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;">
											BUSINESS INFORMATION</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
											<br>
										</div>
										<div class="col-md-3">
											<b>ADDRESS</b>
										</div>
										<div class="col-md-3">
											<div class="form-group"><%=bor.getADDRESS()%></div>
										</div>
										<div class="col-md-3">
											<b>CITY</b>
										</div>
										<div class="col-md-3">
											<div class="form-group"><%=bor.getCITY()%></div>
										</div>
										<div class="col-md-3">
											<b>STATE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group"><%=bor.getSTATE()%></div>
										</div>
										<div class="col-md-3">
											<b>DISTRICT</b>
										</div>
										<div class="col-md-3">
											<div class="form-group"><%=bor.getDISTRICT()%></div>
										</div>
										<div class="col-md-3">
											<b>OFFICE PHONE NO.</b>
										</div>
										<div class="col-md-3">
											<div class="form-group"><%=bor.getOFFICE_PHONE_NO()%></div>
										</div>
										<div class="col-md-3">
											<b>PINCODE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group"><%=bor.getOFFICE_PINCODE_NO()%></div>
										</div>
									</div>
								</form>
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
	</center>
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
			populateCountries("country", "state");
	</script>
	<pre>
 	</pre>
	<footer>Copyright &copy; vehicletracking.com</footer>
</body>
</html>