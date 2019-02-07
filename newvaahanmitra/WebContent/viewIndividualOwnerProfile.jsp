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
<%@page
	import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./individualOwner.jsp" />
<%-- <jsp:include page="./right-side.jsp" /> --%>
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
				
			</div>
			</header>
			<br>

			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<!-- <h3 style="">SPARE PARTS DASHBOARD</h3> -->
				<div> <h3 class="col-md-12" align="center">INDIVIDUAL OWNER DASHBOARD</h3></div>
				<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745; border-radius:4%">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive well" style="border-radius:4%">
								<form action="./updateUsedVehicleProfileController"
									method="post" onSubmit="return validate()">
									<div class="col-md-12">
										<div align="center"
											style="text-align: center; background-color: #523f6d; color: #fff;">
											VIEW PROFILE</div>
									</div>
									<br>
									<br>
									<div class="col-md-12">
										<div align="center"
											style="text-align: center; background-color: #f9f9f9; color: #000;">
											<b>BASIC INFORMATION</b></div>
									</div><br><br>

									<%
										String email = (String) session.getAttribute("user");
										IndividualOwnerService profile = new IndividualOwnerService();
										IndividualOwnerRegister view = profile.getProfileDetails(email);
									%>

									<div class="col-md-3">
										<b>NAME</b>
									</div>
									<div class="col-md-3">
										<div class="form-group"><%=view.getNAME()%></div>
									</div>
									<div class="col-md-3">
										<b>EMAIL ADDRESS</b>
									</div>
									<div class="col-md-3">
										<div class="form-group"><%=view.getEMAIL_ID()%></div>
									</div>
									<div class="col-md-3">
										<b>PANCARD</b>
									</div>
									<div class="col-md-3">
										<div class="form-group"><%=(view.getPANCARD_NO()== null || view.getPANCARD_NO().equals("null"))?"_":view.getPANCARD_NO()%></div>
									</div>
									<div class="col-md-3">
										<b>MOBILE NO</b>
									</div>
									<div class="col-md-3">
										<div class="form-group"><%=view.getMOBILE_NO()%></div>
									</div>
									<div class="col-md-3">
										<b>CITY</b>
									</div>
									<div class="col-md-3">
										<div class="form-group"><%=(view.getCITY()==null || view.getCITY().equals("null")?"_": view.getCITY())%></div>
									</div>
									<div class="col-md-3">
										<b>PINCODE</b>
									</div>
									<div class="col-md-3">
										<div class="form-group"><%=(view.getPINCODE_NO()==null || view.getPINCODE_NO().equals("null"))?"_":view.getPINCODE_NO()%></div>
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
		populateBrands("brand", "model");
 	</script>
	<pre>
 	</pre>
	<footer>Copyright &copy; vehicletracking.com</footer>
</body>
</html>