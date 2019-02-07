<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Vaahanmitra | Register</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<!-- Base Css -->
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/register-page.css" rel="stylesheet" type="text/css" />
<script type= "text/javascript" src = "./js/countries.js"></script>
<link rel="stylesheet" type="text/css" href="./css/myStyle.css" />
<link rel="stylesheet" type="text/css" href="./css/tcal.css" />
<script type="text/javascript" src="./js/tcal.js"></script>
<style>
.h1_bg_sel {
	background: url(https://imgct2.aeplcdn.com/images4/sel_car_h1_bg.png)
		no-repeat;
	height: 59px;
	line-height: 47px !important;
	line-height: 47px;
	color: #fff;
	background-size: 100% 100%;
	font-size: 15px !important;
	text-align: center;
	font-weight: bold;
}

.headeradwrap {
	padding: 20px 20px 8px !important;
}

#rightPriceDetails {
	clear: both;
	color: red;
	font-weight: bold;
	font-size: 17px;
	text-align: center;;
}

.protr {
	background: #ffffff;
	padding: 3px;
	-webkit-box-shadow: 1px 2px 4px 0px rgba(0, 0, 0, 0.65) -moz-box-shadow:
	1px 2px 4px 0px rgba(0, 0, 0, 0.65);
	box-shadow: 1px 2px 4px 0px rgba(0, 0, 0, 0.65);
	border: 1px #e1e1e1 solid;
	overflow: hidden;
	margin-bottom: 10px;
	margin-right: 4px;
}

.aucformFieldsBox input[type="text"], .aucformFieldsBox select {
	/* width: 235px; */
}

.aucformFieldsBox select {
	
	    width: 100%;
}

#rightPriceDetails span {
	font-size: 12px;
	color: #737373;
	font-weight: normal;
}

.crlgo {
	float: left;
	width: 135px;
	font-size: 13px;
	background: url() no-repeat center 0px;
	padding-top: 22px;
	background-size: 100px;
}
</style>
<style type="text/css">
.box {
	padding: 0px;
	margin-top: -3px
}

.four {
	
}

.two {
	
}

label {
	margin-right: 15px;
}
</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('input[type="radio"]').click(function() {
			var inputValue = $(this).attr("value");
			var targetBox = $("." + inputValue);
			$(".box").not(targetBox).hide();
			$(targetBox).show();
		});
	});
</script>
<!--  <script language="javascript">
 
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
	</script> -->
	
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
		   
	   }else if(document.getElementById("adharNo").value.length <12 || document.getElementById("adharNo").value.length>12){ 
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
function ValidateSize(file) {
    var FileSize = file.files[0].size / 2048 / 2048; // in MB
    if (FileSize > 2) {
        alert('File size exceeds 2 MB');
       // $(file).val(''); //for clearing with Jquery
    } else {
  
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
	
<!-- 	<script type="text/javascript">
         function checkSpcialChar(event){
            if(!((event.keyCode >= 65) && (event.keyCode <= 90) || (event.keyCode >= 97) && (event.keyCode <= 122) || (event.keyCode >= 48) && (event.keyCode <= 57))){
               event.returnValue = false;
               return;
            }
            event.returnValue = true;
         }
 </script> -->
 
 
 
 
  <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

  
   <script>
  
  $(function(){
    
    $('#datepicker').datepicker({
        dateFormat: 'dd-mm-yy',
        altField: '#thealtdate',
        altFormat: 'yy-mm-dd'
    });
    
});

  </script>
  
    <script>
  
  $(function(){
    
    $('#datepicker1').datepicker({
        dateFormat: 'dd-mm-yy',
        altField: '#thealtdate',
        altFormat: 'yy-mm-dd'
    });
    
});

  </script>
	
</head>
<body>
	<!-- page loader -->
	<div class="se-pre-con"></div>
	<div id="page-content">
		<!-- navber -->
		<jsp:include page="./homeTop.jsp"></jsp:include>
		<!-- /.nav end -->

		<!-- service -->
		<section class="service-inner" id="top2">
			<div class="container">
				<div class="row">
					<section class="sellUcarpg">

						<div class="col-lg-6 col-md-6 col-sm-12 col-xsm-12">
						<div class="auctionFormLeft" 
						style="margin-right: 15px; padding: 30px 20px 0 0;margin-top: 60px;">
								
								<img
									src="images/carImage.jpg"
									alt="" title="">
								<h1 class="h1_bg_sel res3">SELL YOUR CAR FOR FREE</h1>
								<ul class="sellCarInfolist res3">
									<li>
										<div class="sellIconImgWrapper">
											<span class="sellicon1"></span>
										</div>
										<!-- <div class="sellIconTxtWrapper">
											<h2>The largest number of buyers</h2>
											<p>Over 2.5 million used car buyers visit our site every
												month looking for a used car!</p>
										</div> -->
									</li>
									<li>
										<div class="sellIconImgWrapper">
											<span class="sellicon2"></span>
										</div>
										<div class="sellIconTxtWrapper">
											<h2>Genuine Buyers</h2>
											<p>We let the buyers get in touch with you directly</p>
										</div>
									</li>
								<!-- 	<li>
										<div class="sellIconImgWrapper">
											<span class="sellicon3"></span>
										</div>
										<div class="sellIconTxtWrapper">
											<h2>Speedy and Easy Process</h2>
											<p>List your car within 2 minutes and in 1 easy step</p>
										</div>
									</li> -->
									<li>
										<div class="sellIconImgWrapper">
											<span class="sellicon4"></span>
										</div>
										<div class="sellIconTxtWrapper">
											<h2>Your Used Car stays listed till the car is sold</h2>
										</div>
									</li>
									<!--<li>
        <div class="sellIconImgWrapper"> <span class="sellicon5"></span> </div>
        <div class="sellIconTxtWrapper">
          <h2>Get Buyers&rsquo; Details via SMS and Email</h2>
        </div>
      </li>-->
								</ul>
							</div>
						</div>
						<%String message =(String)request.getAttribute("existemail"); %>
						<div class="col-lg-6 col-md-6 col-sm-12 col-xsm-12" >
							<div class="auctionFormRight" style="margin-top:24px; ">
								<div class="auctionMainForm" >
									<form name="sellfrm" id="sellfrm" method="POST" action="./DriverRegistration" enctype="multipart/form-data" onSubmit="return validate()">
									<% if(message!=null){%>
                    	<h4 style="color:red"><%= message %> </h4>    
              			<%}else{}%>
									<h2 class="aucformTitle" style="margin-bottom: 15px" align="center">Just fill in your details and get
										started</h2>
										
										<div align="center">
										<label>
										<input type="radio" name="type" value="individual" onclick="location.href='register.jsp'"><b>INDIVIDUAL OWNER </b> 
										</label>
										<label>
										<input type="radio" name="type" value="business" onclick="location.href='userType.jsp'"><b>BUSINESS OWNER </b>
										</label>
										<label>
										<input type="radio" name="driver" value="DR" checked><b>Driver </b>
										</label>
										</div>
										
										<div class="aucformFieldsBox">
											<label><b style="color: red; font-size: 15px">Basic
													Details :</b></label><br>
										</div>
										<div class="aucformFieldsBox" >
										
										<div class="col-md-4 col-xs-12"><label>First Name<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox col-md-8 col-xs-12" align="right">
											 
											<input class="form-control" type="text" required placeholder="First Name" name="fname" onkeypress="return checkSpcialChar(event)" required>
										</div>
											
										</div>
										<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>Last Name<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox col-md-8 col-xs-12" align="right">
											<input class="form-control" autocomplete="off" type="text" name="lname" onkeypress="return checkSpcialChar(event)" placeholder="Last Name" required>
											</div>
											<div class="clr"></div>
										</div>
										<div class="aucformFieldsBox email"  >
											<div class="col-md-4 col-xs-12"><label>Email<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox col-md-8 col-xs-12" align="right">
												<input class="form-control" autocomplete="off" type="email" name="emailid"  placeholder="Email Id"  required ><!-- onkeypress="return checkSpcialChar(event)" -->
											</div>
											<div class="clr"></div>
										</div>
										<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>Mobile No.<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox col-md-8 col-xs-12" align="right">
												<input class="form-control" autocomplete="off" type="text" name="mobileNo"  id="mobileNo" pattern="[1-9]{1}[0-9]{9}" title="Enter 10 digit mobile number" placeholder="Mobile Number" maxlength="10" required>
											</div>
											<div class="clr"></div>
										</div>
										<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>Date of birth<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox col-md-8 col-xs-12" align="right">
												<input  autocomplete="off" type="text" name="date1" placeholder="DD-MM-YYYY" id="datepicker" class="form-control" required>
											</div>
											<div class="clr"></div>
										</div>
										<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>Password<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox col-md-8 col-xs-12" align="right">
												<input class="form-control" autocomplete="off" type="password" name="psw"  placeholder="password"  required>
											</div>
											<div class="clr"></div>
										</div>
										<div class="clearfix"></div>
										<div class="aucformFieldsBox">
											<label><b style="color: red; font-size: 15px">Contact Details :</b></label><br>
										</div>
										<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>Address<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox col-md-8 col-xs-12" align="right">
												<input class="form-control" autocomplete="off" type="text" name="address"  placeholder="Address" required>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>Street<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox col-md-8 col-xs-12" align="right">
												<input class="form-control" autocomplete="off" type="text" name="street"  placeholder="Street" required>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>City<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox col-md-8 col-xs-12" align="right">
												<input class="form-control" autocomplete="off" type="text" name="city"  placeholder="City" required>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>State<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox col-md-8 col-xs-12" align="right">
												<select class="form-control" autocomplete="off"  name="country" id="country" placeholder="State" required >
<!-- 												<option>Select State</option> -->
												</select>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>District<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox col-md-8 col-xs-12" align="right">
												<select class="form-control" autocomplete="off" name="state" id ="state" placeholder="District"><option style="Display:none;">District</option></select>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>Mandal<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox col-md-8 col-xs-12" align="right">
												<input class="form-control" autocomplete="off" type="text" name="mandal"  placeholder="Mandal" required>
											</div>
											<div class="clr"></div>
										</div>
										<div class="aucformFieldsBox" >
											<label><b style="color: red; font-size: 15px">Driving Details :</b></label><br>
										</div>
											<div class="aucformFieldsBox">
											<div class="col-md-4 col-xs-12"><label>License Registered State<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox  col-md-8 col-xs-12" align="right">
<!-- 												<input  autocomplete="off" type="text" name="state1"  placeholder="License Registered State" required> -->
												<select class="form-control" id="state1" name ="state1" required>
													<option value="">------------Select State------------</option>
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
													</select>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>License No.<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox col-md-8 col-xs-12" align="right">
												<input class="form-control" autocomplete="off" type="text" name="licenseNo" id="licenceNo" placeholder="License Number" maxlength="16" required>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>License Type<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox col-md-8 col-xs-12" align="right">
												<select name="licenseType"  placeholder="License Type" required oninvalid="this.setCustomValidity('Please select License Type')" oninput="setCustomValidity('')">
												<option value="">Select</option>
												<option>Heavy Vehicle</option>
												<option>Light Vehicle</option>
												</select>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>Expiry Date<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox  col-md-8 col-xs-12" align="right">
												<input  type="text" name="date2" placeholder="DD-MM-YYYY" id="datepicker1" class="form-control" required>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox"  >
											<div class="col-md-4 col-xs-12"><label>Driving Experience(In Year)<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox  col-md-8 col-xs-12" align="right">
												<input class="form-control" type="text" name="exp"  placeholder="Driving Experience" required onkeypress="CheckNumeric(event)">
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox"  >
											<div class="col-md-4 col-xs-12"><label>Worked Location<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox  col-md-8 col-xs-12" align="right">
												<select class="form-control" name="permitType"  placeholder="Permit Type" required oninvalid="this.setCustomValidity('Please select Permit Type')" oninput="setCustomValidity('')">
												<option value="">Select</option>
												<option>Within State</option>
												<option>Other State</option>
												</select>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>Available Within Range<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox  col-md-8 col-xs-12" align="right">
												<input class="form-control" autocomplete="off" type="text" name="range"  placeholder="Within Range(In Km)" required onkeypress="CheckNumeric(event)">
											</div>
											<div class="clr"></div>
										</div>
										<div class="aucformFieldsBox">
											<label><b style="color: red; font-size: 15px">Other
													Details :</b></label><br>
										</div>
											<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>Job Type<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox  col-md-8 col-xs-12" align="right">
												<select class="form-control" name="jobType"  placeholder="Permit Type" required oninvalid="this.setCustomValidity('Please select Job Type')" oninput="setCustomValidity('')">
												<option value="">Select</option>
												<option>Full Time</option>
												<option>On Demand</option>
												</select>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>Adhar No.</label></div>
											<div class="aucformFieldsBox  col-md-8 col-xs-12" align="right">
												<input class="form-control" autocomplete="off" type="text" name="adharNo" id="adharNo"  pattern="[0-9]{12}" title="Enter 12 digit mobile numbe" placeholder="Adhar Card Number" maxlength="12" >
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>Pan No.</label></div>
											<div class="aucformFieldsBox  col-md-8 col-xs-12" align="right">
												<input class="form-control" autocomplete="off" type="text" name="panNo" id="panNo" placeholder="Pan Card Number" maxlength="10" >
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>Upload License Document<span style="color:red">*</span></label></div>
											<div class="aucformFieldsBox  col-md-8 col-xs-12" align="right">
												<input class="form-control" autocomplete="off" type="file" onchange="ValidateSize(this)" name="doc" required id="file"/>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox" >
											<div class="col-md-4 col-xs-12"><label>Upload Photo<span style="color:red"></span></label></div>
											<div class="aucformFieldsBox  col-md-8 col-xs-12" align="right">
												<input class="form-control" autocomplete="off" type="file" onchange="ValidateSize(this)" name="pic">
											</div>
											<div class="clr"></div>
											<div class="col-md-12 col-xs-12">
											<br>
											</div>
										</div>
									
										<div class="aucformFieldsBox nomargin">
											<input  type="checkbox" name="check_agree" id="check_agree"
												value="y" required> <span class="termlabel">
												    <a class="ul" href="condtions.jsp">
													I authorize vaahanmitra.com to call/SMS me in connection with
													my application &amp; agree to the Privacy Policy and Terms
													of use</a>
												
											</span>
										</div>
										<div class="aucformFieldsBox" align="center">
											<h4>
												<input class="btn" type="submit" value="REGISTER" style="width:100px;background-color: red; color: white;padding-bottom: 6px;">
											</h4>
										</div>
									</form>
									 
								</div>
							</div>
						</div>
                      <div class="col-md-12 col-xs-12">
										<br>
										</div>
					</section>
				</div>


			</div>
		</section>


		<!-- blog section -->

		<!-- Newsletter -->
		<section class="get-offer">
			<div class="container">
				<div class="row">
					<div class="col-sm-5">
						<span>Subscribe to our Newsletter</span>
						<h2>& Discover the best offers!</h2>
					</div>
					<div class="col-sm-7">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Enter Your Email" name="q">
							<div class="input-group-btn">
								<button class="btn btn-default" type="submit">
									<i class="flaticon-paper-plane"></i> Subscribe
								</button>
							</div>
						</div>

					</div>
				</div>
			</div>
		</section>
	</div>
	<!-- Footer Section -->
	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
	<!-- jQuery -->
	<script src="assets/js/jquery.min.js" type="text/javascript"></script>
	<!-- jquery ui js -->
	<script src="assets/js/jquery-ui.min.js" type="text/javascript"></script>
	<!-- bootstrap js -->
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- fraction slider js -->
	<script src="assets/js/jquery.fractionslider.js" type="text/javascript"></script>
	<!-- owl carousel js -->
	<script src="assets/owl-carousel/owl.carousel.min.js"
		type="text/javascript"></script>
	<!-- counter -->
	<script src="assets/js/jquery.counterup.min.js" type="text/javascript"></script>
	<script src="assets/js/waypoints.js" type="text/javascript"></script>
	<!-- filter portfolio -->
	<script src="assets/js/jquery.shuffle.min.js" type="text/javascript"></script>
	<script src="assets/js/portfolio.js" type="text/javascript"></script>
	<!-- magnific popup -->
	<script src="assets/js/jquery.magnific-popup.min.js"
		type="text/javascript"></script>
	<!-- range slider -->
	<script src="assets/js/ion.rangeSlider.min.js" type="text/javascript"></script>
	<script src="assets/js/jquery.easing.min.js" type="text/javascript"></script>
	<!-- custom -->
	<script src="assets/js/custom.js" type="text/javascript"></script>
	<script language="javascript">
	populateCountries("country", "state");
	</script>
	<script type="text/javascript">

 document.getElementById('register1').className = 'active';

 </script>
</body>
</html>