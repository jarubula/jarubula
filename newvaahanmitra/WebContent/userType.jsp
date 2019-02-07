<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<script src="https://www.w3schools.com/lib/w3.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
	$(document).ready(function () 
			 { 
			  $("#watch-me").click(function()
			  {
			    $("#show-me:hidden").show('slow');
			   $("#show-me-two").hide();
			   $("#show-me-three").hide();
			   });
			   $("#watch-me").click(function()
			  {
			    if($('watch-me').prop('checked')===false)
			   {
			    $('#show-me').hide();
			   }
			  });
			  
			  
			  $("#see-me").click(function()
			  {
			    $("#show-me-two:hidden").show('slow');
			   $("#show-me").hide();
			   $("#show-me-three").hide();
			   });
			   $("#see-me").click(function()
			  {
			    if($('see-me-two').prop('checked')===false)
			   {
			    $('#show-me-two').hide();
			   }
			  });
			  
	</script>
<style type="text/css">
#margin-right{
	margin-right: 10px;
	}
								
.h1_bg_sel {
	background: url(https://imgct2.aeplcdn.com/images4/sel_car_h1_bg.png)
		no-repeat;
	height: 59px;
	line-height: 47px !important;
	line-height: 47px;
	color: #fff;
	font-size: 15px !important;
	text-align: center;
	background-size:100% 100%;
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

/* .aucformFieldsBox input[type="text"], .aucformFieldsBox select {
	width: 235px;
} */

/* .aucformFieldsBox select {
	width: 235px;
} */

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
.aucformFieldsBox input[type="text"], .aucformFieldsBox select {
    background: #FFFFFF;
    color: #888888;
    /* float: right; */
    height: 31px !important;
    margin: 0 0 0px !important;
    padding: 8px;
    border-radius: 0px 4px 4px 0px !important;
}
.input-group {
    position: relative;
    display: table;
    border-collapse: separate;
    width: 100%;
}
.input-group-addon {
     padding: 4px 11px;
    font-size: 16px !important;
    font-weight: 400;
    line-height: 1;
    color: #fff !important;
    text-align: center;
    background-color: #9a2220 !important;
    border: 1px solid #9a2220 !important;
    border-radius: 4px 0 0 4px !important;
}
.ter a{
        margin: 0px 0px;
    position: absolute;
    font-size: 16px;
    text-decoration: underline;
    }
    .input-group-addon{
        width: 38px;
    
    }
    .auctionMainForm #sellfrm {
    padding: 0px !important;
}
#one{
font-size: 17px;color: 
#020202;
line-height: 1;
 font-family: sans-serif;
}
@media  (max-width:767px){
#one{
font-size: 17px;color: 
#020202;
line-height: 1;
 font-family: sans-serif;
 width:100%;
}
}





.reveal-if-active {
  opacity: 0;
  max-height: 0;
  overflow: hidden;
}
input[type="radio"]:checked ~ .reveal-if-active,
input[type="checkbox"]:checked ~ .reveal-if-active {
  opacity: 1;
  max-height: 100px; /* little bit of a magic number :( */
  overflow: visible;
}

.reveal-if-active {
  opacity: 0;
  max-height: 0;
  overflow: hidden;
  transform: scale(0.8);
  transition: 0.5s;
  input[type="radio"]:checked ~ &,
  input[type="checkbox"]:checked ~ & {
    opacity: 1;
    max-height: 100px;
    overflow: visible;
    padding: 10px 20px;
    transform: scale(1);
  }
}
</style>
<!-- Base Css -->
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/register-page.css" rel="stylesheet"
	type="text/css" />
	<script src="./css/countries.js" type="text/javascript"></script>
	<script language="javascript">
 	function validate() {
 		
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
 		if(document.getElementById("pancardNo").value.length !=10 )
		 {
		  alert("Please enter 10 digits for PANCARD");
		  document.getElementById("pancardNo").focus();
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
	<!-- page loader -->
	<div class="se-pre-con"></div>
	<div id="page-content">
		<!-- navber -->
			<jsp:include page="./homeTop.jsp"></jsp:include>
			<!-- /.container -->
		<!-- /.nav end -->
      
		<!-- service -->
		<section class="service-inner" id="top2">
			<div class="container">
				<div class="row">
					<section class="sellUcarpg">

						<div class="col-lg-6 col-md-6 col-sm-12 col-xsm-12" >
							<div class="auctionFormLeft"
								style=" margin-right: 15px; padding: 0px 20px 0 0;margin-top: 0px;">
								
								<img src="assets/images/cars.png"	alt="" title="">
								<h1 class="h1_bg_sel res3">SELL YOUR CAR FOR FREE</h1>
								<ul class="sellCarInfolist res3">
									<li>
										<div class="sellIconImgWrapper">
											<span class="sellicon1"></span>
										</div>
									</li>
									<li>
										<!-- <div class="sellIconImgWrapper">
											<span class="sellicon2"></span>
										</div> -->
										<div class="sellIconTxtWrapper">
											<h2>Genuine Buyers</h2>
											<p>We let the buyers get in touch with you directly</p>
										</div>
									</li>
									<li>
										<!-- <div class="sellIconImgWrapper">
											<span class="sellicon4"></span>
										</div> -->
										<div class="sellIconTxtWrapper">
											<h2>Your Used Car stays listed till the car is sold</h2>
										</div>
									</li>
								</ul>
							</div>
						</div>
						<%String message =(String)request.getAttribute("existemail"); %>
						<div class="col-lg-6 col-md-6 col-sm-12 col-xsm-12">
							<div class="auctionFormRight" style="margin-top: 24px;">
							
								<div class="col-md-1 col-xs-12"></div>
								<div class="auctionMainForm col-md-10 col-xs-12">
									<form name="sellfrm" id="sellfrm" method="POST" action="./businessOwnerRegisterController" onSubmit="return validate()">
									<% if(message!=null){%>
                    	<h4 style="color:red"><%= message %> </h4>    
              			<%}else{}%>
              			<div align="center">
											<h2 class="aucformTitle" style="margin-bottom: 15px; text-align: center; ">
											Just fill in your details and get started</h2>

											<!-- <label id="margin-right"><input type="radio" name="type"
												value="individual" onClick="location.href='register.jsp'"><b> INDIVIDUAL OWNER
											</b></label>
											<label id="margin-right"><input type="radio" name="type"
												value="business" checked><b>
													BUSINESS OWNER </b></label>
													 -->
													
													  <div class="margin0" style="text-align: center; line-height: 5px;">
											<label id="margin-right" style="font-size: 16px;
                                            font-weight: 600; color: #333;"><input type="radio" name="type"
												value="individual" onClick="location.href='register.jsp'" style="width: 16px; height: 16px;"> INDIVIDUAL OWNER</label>
											&nbsp; &nbsp;<label id="margin-right" style="font-size: 16px;
                                            font-weight: 600; color: #333;"><input type="radio" name="type"
												value="business" checked style="width: 16px; height: 16px;"> BUSINESS OWNER </label>
											<!-- <label>
									<input type="radio" name="type" value="DR" onClick="location.href='driverRegistration.jsp'"><b>DRIVER </b>
									</label> -->
									</div>
											<!-- <label id="margin-right">
									<input type="radio" name="type" value="DR" onClick="location.href='driverRegistration.jsp'"><b>DRIVER </b>
									</label> -->
										</div>
										<br>
										   <div class="col-md-12" style=" font-size: 19px; color: #f94141;">
										  <span>User Type</span>
										  </div>
										
										    <div class="margin0" style="line-height: 5px; margin: 0 10px;">
											<input type="radio" onclick="w3.hide('#London')" name="userType" value="SC" checked /> <label id="margin-right" style=" font-size: 14px;font-weight: 600; color: #333;"> SERVICE CENTER </label>
										    <input type="radio" onclick="w3.hide('#London')" name="userType" value="UD"/>  <label id="margin-right" style="font-size: 14px;font-weight: 600; color: #333;"> VEHICLE DEALER </label>
											<input type="radio" onclick="w3.show('#London')" name="userType" value="SP" id="choice-animals-dogs"/> <label id="margin-right" style="font-size: 14px;font-weight: 600; color: #333;"> SPARE PARTS SHOP</label>
									        </div>
									
											<br>
											
											<div id="London" class="city">
											<div class="aucformFieldsBox">
                                             <div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; line-height: 1;font-family: sans-serif;">Business Type
								            </label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon">
											<i class="fa fa-user" aria-hidden="true"></i>
											</span>
								            <select class="form-control"  id="" name="state" required>
                                            <option value="">---- Select Business Type ----</option>  
                                            <option value="">Manufacturer</option>  
                                            <option value="">Distributor</option>  
                                           <option value="">Retailer</option>                                     
                                            </select>
								            </div></div>
								            </div>
								            </div>
                                            </div>	
											</div>
											
											
											
										  <!--   <div class="aucformFieldsBox">
											<div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; line-height: 1;font-family: sans-serif;">Business Type
								            </label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon">
											<i class="fa fa-user" aria-hidden="true"></i>
											</span>
								            <select class="form-control"  id="" name="state" required>
                                            <option value="">---- Select Business Type ----</option>  
                                            <option value="">Manufacturer</option>  
                                            <option value="">Distributor</option>  
                                           <option value="">Retailer</option>                                     
                                            </select>
								            </div></div>
								            </div>
								            </div>
											</div> -->
											
											<div id="Paris" class="city">
											<div class="aucformFieldsBox">
											<div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" id="one">Business Name<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon">
											<i class="fa fa-user" aria-hidden="true"></i>
											</span>
								            <input class="form-control" autofocus="autofocus" type="text" name="businessName" required placeholder="Enter Business Name">
								            </div></div>
								            </div>
								            </div>
											</div>
											
											<!-- <div class="aucformFieldsBox">
												<div class="col-md-6 col-xs-12 col-sm-6">
												<label>Business Name<span style="color:red">*</span></label>
												</div>
												<div class="col-md-6 col-xs-12 col-sm-6">
												 <input class="form-control" type="text" name="businessName" required placeholder="Enter Business Name">
													</div>
											</div> -->
											
											
											<div class="aucformFieldsBox">
											 <div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">GST No</label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon">
											<i class="fa fa-columns" aria-hidden="true"></i>
											</span>
								            <input type="text" class="form-control" name="GSTNo" id="GSTNo" placeholder="Enter GST No." maxlength="16">
								            </div></div>
								            </div>
								            </div>
											</div>
											
											<!-- <div class="aucformFieldsBox">
											<div class="col-md-6 col-xs-12 col-sm-6">	
											<label>GST No<span style="color:red"></span></label>
											</div>	
												<div class="col-md-6 col-xs-12 col-sm-6">
												 <input type="text" class="form-control" name="GSTNo" id="GSTNo" placeholder="Enter GST No." maxlength="16">
													</div>
											</div> -->
											
											<div class="aucformFieldsBox">
											 <div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">City<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon" style="padding: 6px 10px;">
											<i class="fa fa-road" aria-hidden="true"></i>
											</span>
								            <input type="text" name="city" id="city" class="form-control" placeholder="Enter City" required>
								            </div></div>
								            </div>
								            </div>
											</div>
											
											<!-- <div class="col-md-6 col-xs-12 col-sm-6">
											<label>City<span style="color:red">*</span></label> 
											</div>
											<div class="col-md-6 col-xs-12 col-sm-6">
												<input type="text" name="city" id="city" class="form-control" placeholder="Enter City" required>
											</div> -->
										 
										 <div class="aucformFieldsBox">
											 <div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">Pincode<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon">
											<i class="fa fa-street-view" aria-hidden="true"></i>
											</span>
								           <input class="form-control" type="text" placeholder="Enter Pincode no"
												name="pinNo" required id="pincodeNo" onKeyPress="CheckNumeric(event)">
								            </div></div>
								            </div>
								            </div>
											</div>
										
										
									<!-- 	<div class="aucformFieldsBox">
											<div class="aucformFieldsBox">
											<div class="col-md-6 col-xs-12 col-sm-6">
											<label>Pincode<span style="color:red">*</span></label> 
											</div>
											<div class="col-md-6 col-xs-12 col-sm-6">
											<input class="form-control" type="text" placeholder="Enter Pincode no"
												name="pinNo" required id="pincodeNo" onKeyPress="CheckNumeric(event)">
												</div>
										</div> -->
										
											<div class="col-md-12" style="font-size: 19px; color: #f94141;">
										    <span>Vehicle Type</span>
										    </div>
										
										   <div class="col-md-12" style="  margin: 0 6px; font-size: 22px; color: #f94141;line-height: 5px;">
										   <label style="font-size: 14px;font-weight: 600; color: #333;"><input type="checkbox" value="4"
													name="vehicleType" checked> FOUR WHEELER</label>
											&nbsp; &nbsp;<label style="font-size: 14px;font-weight: 600; color: #333;"><input type="checkbox" value="2"
													name="vehicleType" > TWO WHEELER </label>
										   </div>
										
										
									<!-- 	<div class="aucformFieldsBox">
										
											<label><b style="color: red; font-size: 15px">VEHICLE
													TYPE :</b></label><br>
										</div>
										<div>
											<td><label><input type="checkbox" value="4"
													name="vehicleType" checked><b> FOUR WHEELER</b></label></td>
											<td><label><input type="checkbox" value="2"
													name="vehicleType"><b>TWO WHEELER</b> </label></td>
										</div> -->
										<div class="clearfix"></div>
										<div class="frmsubhead" style="text-align: center; font-size: 20px;">
											BUSINESS ADDRESS<span style="color: #D10"></span>
										</div>
										
										<!-- <div class="clearfix"></div>
										<div class="frmsubhead">
											BUSINESS ADDRESS <span style="color: #D10"></span>
										</div> -->
										
										    <div class="aucformFieldsBox">
											<div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">Address<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon">
											<i class="fa fa-map-marker" aria-hidden="true"></i>
											</span>
								            <input class="form-control" type="text" placeholder="Enter Address" name="address" required >
								            </div></div>
								            </div>
								            </div>
											</div>
											
										<!-- <div class="aucformFieldsBox">
											<div class="aucformFieldsBox">
											<div class="col-md-6 col-xs-12 col-sm-6">
											<label>Address<span style="color:red">*</span></label>
											</div>
											<div class="col-md-6 col-xs-12 col-sm-6">
											
											 <input class="form-control" type="text" placeholder="Enter Address"
												name="address" required >
												</div>
										</div>
										</div> -->
										
										    <div class="aucformFieldsBox">
											<div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">Location<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon">
											<i class="fa fa-map-marker" aria-hidden="true"></i>
											</span>
								            <input class="form-control" type="text" placeholder="Enter Location" name="location1" required >
								            </div></div>
								            </div>
								            </div>
											</div>
											
										<!-- <div class="aucformFieldsBox">
										<div class="col-md-6 col-xs-12 colsm-6">
											<label>Location<span style="color:red">*</span></label>
											</div>
											<div class="col-md-6 col-xs-12 colsm-6">
											 <input class="form-control" type="text" placeholder="Enter Location"
												name="location1" required >
												</div>
										</div> -->
										
										    <div class="aucformFieldsBox">
										    <div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">City<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon" style="padding: 6px 8px;">
											<i class="fa fa-road" aria-hidden="true"></i>
											</span>
								            <input type="text" name="bcity" id="city" class="form-control" placeholder="Enter City" required>
								            </div></div>
								            </div>
								            </div>
											</div>
											
										<!-- <div class="aucformFieldsBox">
										<div class="col-md-6 col-xs-12 colsm-6">
											<label>City<span style="color:red">*</span></label>
											</div>
											<div class="col-md-6 col-xs-12 colsm-6">
 												<input type="text" name="bcity" id="city" class="form-control" placeholder="Enter City" required>
											</div>
										</div> -->
										
										    <div class="aucformFieldsBox">
											<div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">State<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon">
											<i class="fa fa-map-marker" aria-hidden="true"></i>
											</span>
								            <select class="form-control"  id="country" name="state" required>
                                            <option value="">Select State</option>                                     
                                            </select>
								            </div></div>
								            </div>
								            </div>
											</div>
											
                                            <div class="aucformFieldsBox">
											<div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">District<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon">
											<i class="fa fa-map-marker" aria-hidden="true"></i>
											</span>
								            <select class="form-control" id="state" name="district" required>
                                            <option value="">Select District</option>                                                          
                                            </select>
								            </div></div>
								            </div>
								            </div>
											</div>
											
                                       <!--  <div class="aucformFieldsBox"> 
                                        <div class="col-md-6 col-xs-12 colsm-6">
											<label>District<span style="color:red">*</span></label>
											</div>
											<div  class="col-md-6 col-xs-12 colsm-6">
											 <select class="form-control" id="state" name="district" required>
                                                     <option value="">Select District</option>                                                          
                                             </select>
                                             </div>
                                         </div> -->
                                         
                                            <div class="aucformFieldsBox">
										    <div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" id="one">Office Phone no<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon" style="padding: 6px 14px;">
											<i class="fa fa-mobile" aria-hidden="true"></i>
											</span>
								            <input class="form-control" type="text" required
											name="phoneNo" id="phoneNo" maxlength="11" placeholder="Enter Office Phone no."onkeypress="CheckNumeric(event)">
								            </div></div>
								            </div>
								            </div>
											</div>
											
											
                                        <!-- <div class="aucformFieldsBox">
                                        <div class="col-md-6 col-xs-12 colsm-6">
											<label>Office Phone no.<span style="color:red">*</span></label> 
											</div>
											<div class="col-md-6 col-xs-12 colsm-6">
											<input class="form-control" type="text" required
												name="phoneNo" id="phoneNo" maxlength="11" placeholder="Enter Office Phone no."onkeypress="CheckNumeric(event)">
										</div>
										</div> -->
										
										    <div class="aucformFieldsBox">
										    <div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">Pincode <span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon" style="padding: 6px 10px;">
											<i class="fa fa-street-view" aria-hidden="true"></i>
											</span>
								            <input class="form-control" type="text" placeholder="Enter Pincode no"
												name="bpinNo" required id="bpincodeNo" onKeyPress="CheckNumeric(event)">
								            </div></div>
								            </div>
								            </div>
											</div>
											
											
                                        <!--  <div class="aucformFieldsBox">
                                         <div class="col-md-6 col-xs-12 colsm-6">
											<label>Pincode<span style="color:red">*</span></label> 
											</div>
											<div class="col-md-6 col-xs-12 colsm-6">
											<input class="form-control" type="text" placeholder="Enter Pincode no"
												name="bpinNo" required id="bpincodeNo" onKeyPress="CheckNumeric(event)">
												</div>
										</div> -->
										
										<div class="clearfix"></div>
										<div class="frmsubhead" style="text-align: center; font-size: 20px;">
											CONTACT INFORMATION<span style="color: #D10"></span>
										</div>
										
										<!-- <div class="frmsubhead">
											CONTACT INFORMATION<span style="color: #D10"></span>
										</div> -->
										
										    <div class="aucformFieldsBox">
										 	<div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">Name<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon" style="padding: 6px 12px;">
											<i class="fa fa-user" aria-hidden="true"></i>
											</span>
								            <input class="form-control"  type="text" placeholder="Enter Name" name="name" id="name" required>
								            </div></div>
								            </div>
								            </div>
											</div>
											
										<!-- <div class="aucformFieldsBox">
										<div class="col-md-6 col-xs-12 colsm-6">
											<label>Name<span style="color:red">*</span></label>
											</div>
											<div class="col-md-6 col-xs-12 colsm-6">
											 <input class="form-control"  type="text" placeholder="Enter Name"
												name="name" id="name" required>
												</div>
                                           </div> -->
                                           
                                            <div class="aucformFieldsBox">
										    <div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">Mobile no<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon" style="padding: 6px 14px;">
											<i class="fa fa-mobile" aria-hidden="true"></i>
											</span>
								            <input class="form-control" type="text" placeholder="Enter Mobile No."
												name="mobileNo" id="mobileNo" maxlength="10" required onKeyPress="CheckNumeric(event)">
								            </div></div>
								            </div>
								            </div>
											</div>
											
											
										<!-- <div class="aucformFieldsBox">
										<div class="col-md-6 col-xs-12 colsm-6">
											<label>Mobile no.<span style="color:red">*</span></label> 
											</div>
											<div class="col-md-6 col-xs-12 colsm-6">
											<input class="form-control" type="text" placeholder="Enter Mobile No."
												name="mobileNo" id="mobileNo" maxlength="10" required onKeyPress="CheckNumeric(event)">
										</div>
										</div> -->
										
										    <div class="aucformFieldsBox">
											<div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">Email<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon" style="padding: 6px 10px;">
											<i class="fa fa-envelope fa" aria-hidden="true"></i>
											</span>
								          <input class="form-control" type="text" placeholder="Enter EmailId"
												name="email" id="email" required>
								            </div></div>
								            </div>
								            </div>
											</div>
											
										<!-- <div class="aucformFieldsBox">
										<div class="col-md-6 col-xs-12 colsm-6">
											<label>Email<span style="color:red">*</span></label> 
											</div>
											<div class="col-md-6 col-xs-12 colsm-6">
											<input class="form-control" type="text" placeholder="Enter EmailId"
												name="email" id="email" required>
												</div>
										</div> -->
										
										<div class="aucformFieldsBox">
											 <div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">Password<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon" style="padding: 6px 10px;">
											<i class="fa fa-key" aria-hidden="true"></i>
											</span>
								         <input class="form-control" type="password" required
												placeholder="Enter Password" name="password"  placeholder="Enter EmailId" name="email" style=" border-radius: 0px 4px 4px 0px;">
								            </div></div>
								            </div>
								            </div>
											</div>
											</div>
											
										<!-- <div class="aucformFieldsBox">
										<div class="col-md-6 col-xs-12 colsm-6">
											<label>Password<span style="color:red">*</span></label> 
											</div>
											<div class="col-md-6 col-xs-12 colsm-6">
											<input class="form-control" type="password" required
												placeholder="Enter Password" name="password"  placeholder="Enter EmailId" name="email">
										</div>
										</div> -->
										
										
										<div class="aucformFieldsBox nomargin">
											<input type="checkbox" name="check_agree" id="check_agree"	required value="y" style="width: 20px;
                                           height: 20px; margin: 0 16px !important;">
                                           <span class="ter">
												<a href="condtions.jsp" target="_blank" class="ul">
												i agree to the terms and conditions
												</a>
											
											</span>
										
										
										<div class="aucformFieldsBox col-md-12 col-xs-12">
										
											<div class="col-md-12 col-xs-12 text-center">
											<br>
											<h4>										
										<input class="btn" type="submit" value="REGISTER" style=" width: 120px;
                                          background-color: #f0ad4e; color: white; padding-bottom: 6px;font-size: 17px; line-height: 19px; border: 1px solid #f0ad4e;">
										</h4>
											
											</div>
											
										</div>
										</div>
										<!-- <div class="aucformFieldsBox" align="center">
											<h4 align="center">
													<input class="btn" type="submit" value="REGISTER" style="width:100px;background-color: red; color: white;padding-bottom: 6px;">
											</h4>
										</div> -->
										
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
			<input type="text" class="form-control" placeholder="Enter Your Email" name="q">
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
	<script language="javascript">
			populateCountries("country", "state");
	</script>
	<script src="assets/js/custom.js" type="text/javascript"></script>
	<script type="text/javascript">
     document.getElementById('register1').className = 'active';
    </script>
    
    <script>
    var FormStuff = {
    		  
    		  init: function() {
    		    // kick it off once, in case the radio is already checked when the page loads
    		    this.applyConditionalRequired();
    		    this.bindUIActions();
    		  },
    		  
    		  bindUIActions: function() {
    		    // when a radio or checkbox changes value, click or otherwise
    		    $("input[type='radio'], input[type='checkbox']").on("change", this.applyConditionalRequired);
    		  },
    		  
    		  applyConditionalRequired: function() {
    		    // find each input that may be hidden or not
    		    $(".require-if-active").each(function() {
    		      var el = $(this);
    		      // find the pairing radio or checkbox
    		      if ($(el.data("require-pair")).is(":checked")) {
    		        // if its checked, the field should be required
    		        el.prop("required", true);
    		      } else {
    		        // otherwise it should not
    		        el.prop("required", false);
    		      }
    		    });
    		  }

    		};

    		FormStuff.init();
    </script>
</body>
</html>

											