<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./css/countries.js" type="text/javascript"></script>
<jsp:include page="./carMenu.jsp" />
<jsp:include page="./topMenu.jsp" />
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<!-- Theme initialization -->

<script language="javascript">
 	function validate() {
 		document.getElementById("msg5").innerHTML = "";
 		if(document.getElementById("mobileNo").value.length !=10 )
		 {
		  alert("Please enter 10 digits Mobile No");
		  document.getElementById("mobileNo").focus();
		  return false;
		 }
 		if(document.getElementById("pincodeNo").value.length !=6 )
		 {
		  alert("Please enter 6 digits PINCODE No");
		  document.getElementById("pincodeNo").focus();
		  return false;
		 }

 		if(document.getElementById("panno").value.length !=10 )
 		{
 			alert("Please enter 10 digits in PANno.");
 			document.getElementById("panno").focus();
 			return false;
 		}
 		if(document.getElementById("bPhoneNo").value.length !=11 )
 		{
 		  alert("Please enter 11 digits Office Phone No only");
 		  document.getElementById("bPhoneNo").focus();
 		  return false;
 		}
 		if(document.getElementById("bpincodeNo").value.length !=6 )
 		{
 		  alert("Please enter 6 digits PINCODE No");
 		  document.getElementById("bpincodeNo").focus();
 		  return false;
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
        
         <style>
        #individual1{
        border-radius: 7px;
        box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15);
        border-bottom: 3px solid #a3b745 !important;
        }
        #one1{
	    text-align: center;
	    font-size: 21px;
	    color: #373a3c;
	    font-family: sans-serif;
	    }
	    .form-control {
    display: block;
    width: 100%;
    padding: .15rem .75rem;
    font-size: 1rem;
    line-height: 1.5;
    color: #55595c;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: .25rem;
}
label {
    display: inline-block;
    margin-bottom: .5rem;
    font-size: 17px;
    font-weight: 400;
}
      </style>
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">

			<header class="" style="font-family: 'Oswald', sans-serif;">
			</header>
			
			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<%
						String message = (String) request.getAttribute("success");
					%>
					<div align="center">
						<h3>SERVICE CENTER DASHBOARD</h3>
					</div>
				</div>
				<div class="col-md-12 col-xs-12 col-sm-12">
					<div class="card" id="individual1">
						<div class="card-block">
							<div class="">
								<form action="./updateUsedVehicleProfileController"
									method="post" onSubmit="return validate()">
									<%
										if (message != null) {
									%>
									<h4 style="color: red"><%=message%>
									</h4>
									<%
										} else {
										}
									%>

								<!-- 	<div class="col-md-12 col-sm-12 col-xs-12" align="center"
										style="text-align: center; background-color: #523f6d; color: #fff;">
										VIEW SERVICE CENTER</div> -->
									
									<%
										String email = (String) session.getAttribute("user");
										BusinessOwnerService profile = new BusinessOwnerService();
										BusinessOwnerRegister view = profile.getProfileDetails(email);
									%>
								   <div class="col-md-12" id="one1">CONTACT ADDRESS</div>
									
								  <div class="col-md-12 col-xs-12 col-sm-12" align="right">
								  <img src="data:image/png;base64,<%=view.getPHOTO()%>" class="img-rounded" alt="No image" width="150px" height="120px">
								  </div>

                            <div class="row">
							<div class="col-sm-4 form-group">
							<label>Name : </label>
							<span class="form-control"><%=view.getNAME()%></span>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>Email :</label>
							<span class="form-control"><%=view.getEMAIL_ID()%></span>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>Pancard No :</label>
							<span class="form-control"><%=view.getPANCARD_NO()%></span>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>Mobile No :</label>
							<span class="form-control"><%=view.getMOBILE_NO()%></span>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>City :</label>
							<span class="form-control"><%=view.getCITY()%></span>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>Pincode No :</label>
							<span class="form-control"><%=view.getPINCODE_NO()%></span>
							</div>
						    </div>
                              
                            <div class="col-md-12" id="one1">BUSINESS ADDRESS</div>
											     
                            <div class="row">
							<div class="col-sm-4 form-group">
							<label>Business Name : </label>
							<span class="form-control"><%=view.getBUSINESS_NAME()%></span>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>Address :</label>
							<span class="form-control"><%=view.getADDRESS()%></span>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>City :</label>
							<span class="form-control"><%=view.getB_CITY()%></span>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>State :</label>
							<span class="form-control"><%=view.getSTATE()%></span>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>District :</label>
							<span class="form-control"><%=view.getDISTRICT()%></span>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>Office Phone No :</label>
							<span class="form-control"><%=view.getOFFICE_PHONE_NO()%></span>
							</div>
						
							<div class="col-sm-4 form-group">
							<label>Pincode :</label>
							<span class="form-control"><%=view.getOFFICE_PINCODE_NO()%></span>
							</div>
						    </div>      
										
								</form>
							</div>
							
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