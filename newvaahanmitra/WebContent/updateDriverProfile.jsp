<%@ page language="java" import="com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*,java.io.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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
<script type= "text/javascript" src = "./js/countries.js"></script>
<link rel="stylesheet" type="text/css" href="./css/myStyle.css" />
<link rel="stylesheet" type="text/css" href="./css/tcal.css" />
<script type="text/javascript" src="./js/tcal.js"></script>
<script src="./css/countries.js" type="text/javascript"></script>
<jsp:include page="./driverDashboard.jsp" />
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>AddServiceMechanic</title>
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
        
        
        	
		<script language="javascript">
		
  function validate() {
	  
   if(document.getElementById("licenceNo").value.length !=16 )
   {
     alert("Please enter 16 digits Lisence No");
     document.getElementById("licenceNo").focus();
     return false;
   }
   if(document.getElementById("mobileNo").value.length !=10 )
   {
    alert("Please enter 10 digits Mobile No");
    document.getElementById("mobileNo").focus();
    return false;
   }
   if(document.getElementById("adharNo").value.length >=0 ){
	   
	   if(document.getElementById("adharNo").value.length==0){
		   
	   }else if(document.getElementById("adharNo").value.length<12){ 
	    alert("Adhar number must be 12 digits");
	    document.getElementById("adharNo").focus();
	    return false;
	   }
	   }
  if(document.getElementById("panNo").value.length >=0 ){
	   
	   if(document.getElementById("panNo").value.length==0){
		   
	   }else{
		    var pan=document.getElementById("panNo").value;
		    var panPat = /^([a-zA-Z]{5})(\d{4})([a-zA-Z]{1})$/;
		    if(!panPat.test(pan)){
		    	alert("Invalid Pan Number");
		    	document.getElementById("panNo").focus();
		    	return false;
		    }else{}
	   }
		   }
   if(document.getElementById("country").value=="-1" )
   {
    alert("Please select state");
    document.getElementById("country").focus();
    return false;
   }
   if(document.getElementById("state").value == "")
   {
   alert("Please Select a District");
   document.getElementById("state").focus();
   return false;
   }
  /*  var fileUpload = document.getElementById("file");
   if (typeof (fileUpload.files) != "undefined") {
       var size = parseFloat(fileUpload.files[0].size / 1024).toFixed(2);
       
       if(size>2){
       alert(size + " KB.");
       }
       return false;
   } else {
       alert("This browser does not support HTML5.");
       return false;
   } */
   
   var oFile = document.getElementById("file").files[0]; 

   if (oFile.size > 2048) // 2 mb for bytes.
   {
       alert("Image size must under 2mb!");
       return false;
   }else{
	   
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
	
		<style>
	 :required:focus {
	   box-shadow: 0  0 6px rgba(255,0,0,0.5);
	   border: 1px red solid;
	   outline: 0;
	 }
	</style>
        
        
        
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">

			<header class="" style="font-family: 'Oswald', sans-serif;">
			<!-- <div class="col-md-6 col-sm-12 col-xs-12">
				<div class="brand" style="color: white; font-size: 23px;">
					<h2>
						Vaahan<span style="color: #fec107;">Mitra
					</h2>
					</span>
				</div>
			</div>
			<div class="col-md-4"></div>
			<div class="col-md-2 col-xs-12 col-sm-12">
				<div class="dropdown pull-right">
					<button class="btn  dropdown-toggle" type="button"
						data-toggle="dropdown" style="background-color: #fec107">
						Santhosh <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">

						<li><a class="dropdown-item" href="#"> <i
								class="fa fa-power-off icon"></i> Logout
						</a></li>
					</ul>
				</div>
			</div> --> <!-- <div class="header-block header-block-collapse hidden-lg-up">
					<button class="collapse-btn" id="sidebar-collapse-btn">
						<i class="fa fa-bars"></i>
					</button>
				</div> -->

			<div class="header-block header-block-nav">
				<!-- 					<ul class="nav-profile"> -->

				<!-- 						<li class="profile dropdown"><a -->
				<!-- 							class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" -->
				<!-- 							role="button" aria-haspopup="true" aria-expanded="false"> -->
				<!-- 								<div class="img" style=""></div> <span class="name"> -->
				<!-- 									Mohan Amasa</span> -->
				<!-- 						</a> -->
				<!-- 							<div class="dropdown-menu profile-dropdown-menu" -->
				<!-- 								aria-labelledby="dropdownMenu1"> -->

				<!-- 								<a class="dropdown-item" href="#"> <i -->
				<!-- 									class="fa fa-power-off icon"></i> Logout -->
				<!-- 								</a> -->
				<!-- 							</div></li> -->
				<!-- 					</ul> -->
			</div>
			</header>
			<br>

			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<%-- <div class="col-md-12 col-sm-12 col-xs-12">
					<%
					ArrayList<DriverBean> driverDetails=(ArrayList<DriverBean>)request.getAttribute("driverDetails");
					%>
					<div align="center">
						<h3>SERVICE CENTER DASHBOARD</h3>
					</div>
				</div> --%>
				<%
				ArrayList<DriverBean> driverDtl=(ArrayList<DriverBean>)request.getAttribute("driverDtl");					%>
				<div class="col-md-12 col-xs-12 col-sm-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="">
							<div class="">
							<form action="./UpdateDriverProfile" method="post" enctype="multipart/form-data" onSubmit="return validate()">

								<%-- 	<%
										if (message != null) {
									%>
									<h4 style="color: red"><%=message%>
									</h4>
									<%
										} else {
										}
									%> --%>

									<div class="col-md-12 col-sm-12 col-xs-12" align="center"
										style="text-align: center; background-color: #052963; color: #fff;height: 45px; padding: 10px;font-weight: bolder;">
										UPDATE DRIVER</div>
									<br>
									<br>
									<%-- <%
										String email = (String) session.getAttribute("user");
										BusinessOwnerService profile = new BusinessOwnerService();
										BusinessOwnerRegister view = profile.getProfileDetails(email);
									%> --%>
									<%String state=""; %>
									<c:forEach var="driverDetails" items="${driverDtl}">
									
									
									<c:set var="test" value="${driverDetails.STATE}"></c:set>
									<%
									state =(String)pageContext.getAttribute("test"); 
									%>
									
									
									<div class="col-md-12 col-xs-12 col-sm-12" align="right">
										          <img src="data:image/jpeg;base64,${driverDetails.PHOTO}" alt="No image" width="100px" height="100px">
                                                      <input type="hidden" name="photo" value="${driverDetails.PHOTO}"/>
                                                      
                                                      <input type="file" name="pic" value="upload" id="file" width="100%" height="100%" style="color: #000;background-color: #f9f9f9;border: none;"/>


									</div>
									
									<div class="col-md-12 col-sm-12 col-xs-12 well"
										style="font-weight: 700; font-size: 700; color: red; text-align: left;">

										BASIC DETAILS</div>


									<div class="col-md-12 col-xs-12 col-sm-12">
										<br>
										<br>
									</div>

									<div class="row">

										<div class="col-md-3">
											<b>FIRST NAME</b>

										</div>

										<div class="col-md-3">
											<div class="form-group">
											 <input type="text" name="fname" class="form-control input-sm" id="smallinput" value="${driverDetails.FIRST_NAME}" onkeypress="return checkSpcialChar(event)" required>
											</div>


										</div>
										<div class="col-md-3">
											<b>LAST NAME</b>

										</div>
										<div class="col-md-3" align="left">
											<div class="form-group">
											<input type="text" name="lname" class="form-control input-sm" id="smallinput" value="${driverDetails.LAST_NAME}" onkeypress="return checkSpcialChar(event)" required>
											</div>

										</div>
										<div class="col-md-3">
											<b>EMAIL</b>

										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="text" name="emailid" class="form-control input-sm" id="smallinput" value="${driverDetails.EMAIL}" readonly>
											</div>

										</div>
										<div class="col-md-3">
											<b>MOBILE NO</b>

										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="text" name="mobileNo" class="form-control input-sm" id="mobileNo" value="${driverDetails.MOBILE_NO}" maxlength="10" required onkeypress="CheckNumeric(event)">
											</div>

										</div>
										<div class="col-md-3">
											<b>DOB</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="text" name="date1" class="tcal" class="form-control input-sm" id="smallinput" style="color:#000" value="${driverDetails.DOB}" required>
											</div>
										</div>
										
										
										<div class="col-md-12"
											style="font-weight: 700; font-size: 700; color: red; text-align: left;">
											CONTACT DETAILS</div>
											
											<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
											<br>
										</div>
											
										
										<div class="col-md-3">
											<b>ADDRESS</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="text" name="address" class="form-control input-sm" id="smallinput" value="${driverDetails.ADDRESS}" required>
											</div>
										</div>

										<hr>
										<!-- <div class="col-md-12"
											style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;">
											BUSINESS ADDRESS</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
											<br>
										</div> -->
										<div class="col-md-3">
											<b>STREET</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="text" name="street" class="form-control input-sm" id="smallinput" value="${driverDetails.STREET}" required>
											</div>

										</div>
										<div class="col-md-6"></div>

										<div class="col-md-3">
											<b>CITY</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="text" name="city" class="form-control input-sm" id="smallinput" value="${driverDetails.CITY}" required>
											</div>
										</div>
										<div class="col-md-3">
											<b>STATE</b>
										</div>
										<div class="col-md-3">
										<select id="country" name ="country" class="form-control" ><option value="state">state</option></select>
										</div>
										<div class="col-md-3">
											<b>DISTRICT</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
											<select name ="state" id ="state" class="form-control" required><option>${driverDetails.DISTRICT}</option></select>
											</div>
										</div>
										<div class="col-md-3">
											<b>MANDAL</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="text" name="mandal" class="form-control input-sm" id="smallinput" value="${driverDetails.MANDAL}" required>
											</div>
										</div>
										
										<div class="col-md-12"
											style="font-weight: 700; font-size: 700; color: red; text-align: left;">
											DRIVING DETAILS</div>
											
											<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
											<br>
										</div>
											
										
										<div class="col-md-3">
											<b>LICENSE REGISTERED STATE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
	 													 <select  name="state1" class="form-control input-sm" id="smallinput" required>
																  	<option>${driverDetails.REGISTERED_STATE}</option>
																	<option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
																	<option value="Andhra Pradesh">Andhra Pradesh</option>
																	<option value="Arunachal Pradesh">Arunachal Pradesh</option>
																	<option value="Assam">Assam</option>
																	<option value="Bihar">Bihar</option>
																	<option value="Chandigarh">Chandigarh</option>
																	<option value="Chhattisgarh">Chhattisgarh</option>
																	<option value="Dadra and Nagar Haveli">Dadra and Nagar Haveli</option>
																	<option value="Daman and Diu">Daman and Diu</option>
																	<option value="Delhi">Delhi</option>
																	<option value="Goa">Goa</option>
																	<option value="Gujarat">Gujarat</option>
																	<option value="Haryana">Haryana</option>
																	<option value="Himachal Pradesh">Himachal Pradesh</option>
																	<option value="Jammu and Kashmir">Jammu and Kashmir</option>
																	<option value="Jharkhand">Jharkhand</option>
																	<option value="Karnataka">Karnataka</option>
																	<option value="Kerala">Kerala</option>
																	<option value="Lakshadweep">Lakshadweep</option>
																	<option value="Madhya Pradesh">Madhya Pradesh</option>
																	<option value="Maharashtra">Maharashtra</option>
																	<option value="Manipur">Manipur</option>
																	<option value="Meghalaya">Meghalaya</option>
																	<option value="Mizoram">Mizoram</option>
																	<option value="Nagaland">Nagaland</option>
																	<option value="Orissa">Orissa</option>
																	<option value="Pondicherry">Pondicherry</option>
																	<option value="Punjab">Punjab</option>
																	<option value="Rajasthan">Rajasthan</option>
																	<option value="Sikkim">Sikkim</option>
																	<option value="Tamil Nadu">Tamil Nadu</option>
																	<option value="Tripura">Tripura</option>
																	<option value="Uttaranchal">Uttaranchal</option>
																	<option value="Uttar Pradesh">Uttar Pradesh</option>
																	<option value="West Bengal">West Bengal</option>
																	</select></div>
										</div>
										<div class="col-md-3">
											<b>LICENSE NO</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="text" name="licenseNo" class="form-control input-sm" id="licenceNo" value="${driverDetails.LICENSE_NO}" maxlength="16" required>
											</div>
										</div>
										<div class="col-md-3">
											<b>LICENSE TYPE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
											<select name="licenseType" id="selector1" class="form-control" required>
											<option>${driverDetails.LICENSE_TYPE}</option>
											<option>HEAVY VEHICLE</option>
											<option>LIGHT VEHICLE</option>
											</select>
											</div>
										</div>
										<div class="col-md-3">
											<b>EXPIRY DATE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="text" name="date2" class="tcal" id="smallinput" style="color:#000" value="${driverDetails.EXPIRY_DATE}" required>
											</div>
										</div>
										<div class="col-md-3">
											<b>DRIVING EXPERIENCE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="text" name="exp" class="form-control input-sm" id="smallinput" value="${driverDetails.DRIVING_EXP}" required>
											</div>
										</div>
										<div class="col-md-3">
											<b>PERMIT TYPE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
											<select name="permitType" id="selector1" class="form-control" required>
											<option>${driverDetails.PERMIT_TYPE}</option>
											<option>Within State</option>
											<option>Other State</option>
											</select>
											</div>
										</div>
										<div class="col-md-3">
											<b>WITHIN RANGE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="text" name="range" class="form-control input-sm" id="smallinput" value="${driverDetails.WITHIN_RANGE}" required onkeypress="CheckNumeric(event)">
											</div>
										</div>
										<div class="col-md-3">
											<b>JOB TYPE</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
  											<select name="jobType" id="selector1" class="form-control" required>
											<option>${driverDetails.JOB_TYPE}</option>
											<option>Full Time</option>
											<option>On Demand</option>
											</select>
											</div>
										</div>
										
										<div class="col-md-12"
											style="font-weight: 700; font-size: 700; color: red; text-align: left;">
											OTHER DETAILS</div>
											
											<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
											<br>
										</div>
											
										<div class="col-md-3">
											<b>ADHAR CARD NO</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="text" name="adharNo" class="form-control input-sm" id="adharNo" value="${driverDetails.ADHAR_NO}" maxlength="12">
											</div>
										</div>
											<div class="col-md-3">
											<b>PAN CARD NO</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="text" name="panNo" class="form-control input-sm" id="panNo" value="${driverDetails.PAN_NO}" maxlength="10">
											</div>
										</div>
										
										<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
											<br>
										</div>
										
										<div class="col-md-12" style="font-weight: 700; font-size: 700; color: red; text-align: center;">
											<input type="submit" value="Update" class="btn btn-primary"/>
											</div>
										
									</div>	

  </c:forEach>


</form> 

									</div>






							</section>	
							</div>
							</div>
							</div>
							</div>
							</section>
						</div>
					</div>
				<!-- </div>
			</div> -->
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
		populateCountries("country", "state");
		</script>
		
		
<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> -->
	<script type="text/javascript">
	
// 	$("#country option[value='-1']").remove();
// $("#country").append('<option value="option5">option5</option>');
// $("#country option[value='-1']").val("name");
// $("#country option[value='-1']").val("state");
// $("#country option[value='-1']").text("state");
var state1="<%=state%>";
$("select[name=country] option:first").val(state1);
$("select[name=country] option:first").text(state1);
	
	</script>
	<pre>
 	</pre>
	<footer>Copyright &copy; vehicletracking.com</footer>
</body>
</html>