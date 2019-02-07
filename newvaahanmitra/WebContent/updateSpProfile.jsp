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
<jsp:include page="./sparePartsMenu.jsp" />
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
<script type="text/javascript">
    function formSubmit()
    {
    
      var x=document.forms["signup_form"]["bName"].value.replace(/^\s+|\s+$/g, '')
      var y=document.forms["signup_form"]["name"].value.replace(/^\s+|\s+$/g, '')
      if (x == "" || y=="")
      {
      alert("Space not allowed! Please fill the field...");
      return false;
      }
      return true;
    }
 </script>
<script>
function NumAndTwoDecimals(event , obj){
	reg = /[^0-9.,]/g;
	obj.value =  obj.value.replace(reg,"");
 }
</script>

<script language="javascript">
 	function validate() {
 		
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
 		
 		
 		if(document.getElementById("pincodeNo").value.length !=6 )
		 {
		  alert("Please enter 6 digits PINCODE No");
		  document.getElementById("pincodeNo").focus();
		  return false;
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
 		if(document.getElementById("mobileNo").value.length !=10 )
		 {
		  alert("Please enter 10 digits PHONE No.");
		  document.getElementById("mobileNo").focus();
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
	</script>
</head>
<body>
	<%
		String message = (String) request.getAttribute("message");
	%>

	<div class="main-wrapper">
		<div class="app" id="app">

			<header class="" style="font-family: 'Oswald', sans-serif;">

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
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div align="center">
						<h3>SPARE PARTS DASHBOARD</h3>
					</div>
				</div>

				<div class="col-md-12 col-xs-12 col-sm-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="">
							<div class="">
										<%
										if (message != null) {
									%>
										<h6 style="color: red"><%=message%>
										</h6>
										<%
											} else {
											}
										%>
								<form action="./UpdateSpProfile" name="signup_form"
									method="post" onSubmit="return validate()">

									<div class="col-md-12 col-sm-12 col-xs-12" align="center"
										style="text-align: center; background-color: #523f6d; color: #fff;">
										UPDATE PROFILE

									</div>
									<br>
									<br>
									<%
										String email = (String) session.getAttribute("user");
										BusinessOwnerService bDao = new BusinessOwnerService();
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
										<div class="col-md-3">
											<b>BUSINESS NAME</b>
										</div>

										<div class="col-md-3">
											<input type="text" name="bName"
												value="<%=bor.getBUSINESS_NAME()%>"
												class="form-control " required></input>
												<!-- onkeypress="return checkSpcialChar(event)" -->
 										</div>
										<div class="col-md-3">
											<b>PANCARD</b>

										</div>
										<div class="col-md-3" align="left">
											<input type="text" name="pancard" class="form-control "
												id="panNo" value="<%=bor.getPANCARD_NO()%>" required></input>

										</div>
										<div class="col-md-3">
											<b>NAME</b>

										</div>
										<div class="col-md-3">
											<input type="text" value="<%=bor.getNAME()%>"
												class="form-control " name="name" required> 
<!-- 												onkeypress="return checkSpcialChar(event)" -->
										</div>
										<div class="col-md-3">
											<b>MOBILE NO</b>
										</div>
										<div class="col-md-3">
											<input autocomplete="off" type="text"
												value="<%=bor.getMOBILE_NO()%>" class="form-control "
												name="phoneNo" maxlength="10" class="form-control "
												name="mobileNo" id="mobileNo" pattern="[1-9]{1}[0-9]{9}"
												title="Enter 10 digit mobile number"
												placeholder="Mobile Number" maxlength="10"required">

										</div>
										<div class="col-md-3">
											<b>EMAIL</b>
										</div>
										<div class="col-md-3">
											<input type="text" value="<%=bor.getEMAIL_ID()%>" disabled
												class="form-control " name="email" id="email">
										</div>
										<div class="col-md-3"></div>
										<div class="col-md-3"></div>
										<div class="col-md-12 col-sm-12 col-xs-12"></div>
										<div class="col-md-3">
											<b>CITY</b>
										</div>
										<div class="col-md-3">
											<input type="text" class="form-control" id="city" name="city" value="<%=bor.getCITY()%>" required>
										</div>
										<div class="col-md-3">
											<b>PINCODE</b>
										</div>
										<div class="col-md-3">
											<input type="text" value="<%=bor.getPINCODE_NO()%>"
												class="form-control " name="pinNo" required maxlength="6"
												id="pincodeNo" onkeyup="NumAndTwoDecimals(event , this);">
											<h1 class="text-center"></h1>
										</div>
										<div class="col-md-12 col-sm-12 col-xs-12 well"
											style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;">
											BASIC INFORMATION</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
											<br>
										</div>
										<div class="col-md-3">
											<b>ADDRESS</b>
										</div>
										<div class="col-md-3">
											<input type="text" name="address" class="form-control "
												class="form-control " value="<%=bor.getADDRESS()%>" required></input>
										</div>
										<div class="col-md-3">
											<b>CITY</b>
										</div>
										<div class="col-md-3">
										<input type="text" class="form-control" id="city" name="bcity" value="<%=bor.getB_CITY()%>" required>
										</div>
										<div class="col-md-3">
											<b>STATE</b>
										</div>
										<div class="col-md-3">
											<select id="country" name="state" class="form-control "
												required>
												<option value="<%=bor.getSTATE()%>"><%=bor.getSTATE()%></option>
											</select>
										</div>
										<div class="col-md-3">
											<b>DISTRICT</b>
										</div>
										<div class="col-md-3">
											<select id="state" name="district" class="form-control "
												required>
												<option value="<%=bor.getDISTRICT()%>"><%=bor.getDISTRICT()%></option>
											</select>
										</div>
										<div class="col-md-3">
											<b>OFFICE PHONE NO.</b>
										</div>
										<div class="col-md-3">
											<input type="text" required class="form-control "
												name="bphoneNo" id="phoneNo" maxlength="11"
												value="<%=bor.getOFFICE_PHONE_NO()%>"
												onkeyup="NumAndTwoDecimals(event , this);">
										</div>
										<div class="col-md-3">
											<b>PINCODE</b>
										</div>
										<div class="col-md-3">
											<input type="text" value="<%=bor.getOFFICE_PINCODE_NO()%>"
												class="form-control " name="bpinNo" required maxlength="6"
												id="bpincodeNo" onkeyup="NumAndTwoDecimals(event , this);">
										</div>
										<div class="col-md-12">
											<br>
											<br>
										</div>
										<div class="col-md-12 col-sm-12 col-xs-12" align="center">
											<button TYPE="submit" onclick="return(formSubmit())"
												style="background-color: #a3b745; border: 1px solid #a3b745;border-radius:10px"
												class="btn btn-primary">UPDATE</button>
										</div>

										<div class="col-md-6 col-sm-6 col-xs-12" align="center">
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
			var state="<%=bor.getSTATE()%>";
			$("select[name=state] option:first").val(state);
			$("select[name=state] option:first").text(state);
			</script>
	</script>
	<pre>
 	</pre>
	<footer>Copyright &copy; vehicletracking.com</footer>
</body>
</html>
