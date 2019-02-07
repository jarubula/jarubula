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
<link href="assets/css/register-page.css" rel="stylesheet"
	type="text/css" />

<style type="text/css">

.h1_bg_sel {
	background: url(https://imgct2.aeplcdn.com/images4/sel_car_h1_bg.png)
		no-repeat;
	height: 59px;
	line-height: 47px !important;
	line-height: 47px;
	color: #fff;
	font-size: 15px !important;
	text-align: center;
	font-weight: bold;
    background-size: 100% 100%;
}
a:focus {
    outline: 0px auto -webkit-focus-ring-color;
    outline-offset: -2px;
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
	/* width: 235px; */
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
.modal-open .modal{
background: rgba(54, 56, 58, 0.78);
}

#top2 {
    margin-top: -4%;
}
.auctionMainForm #sellfrm {
    padding: 0px;
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
 		if(document.getElementById("pinNo").value.length !=6 )
		 {
		  alert("Please enter 6 digits PINCODE No");
		  document.getElementById("pinNo").focus();
		  return false;
		 }
 		var emailfilter=/^\w+[\+\.\w-]*@([\w-]+\.)*\w+[\w-]*\.([a-z]{2,4}|\d+)$/i
 			var b=emailfilter.test(document.getElementById("emailId").value);
 			if(b==false)
 			{
 			alert("Please Enter a valid Mail ID");
 			document.getElementById("emailId").focus();
 			return false;
 			}
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

						<div class="col-lg-6 col-md-6 col-sm-12 col-xsm-12">
							<div class="auctionFormLeft"
								style=" margin-right: 15px; padding: 0px 20px 0 0;margin-top: 0px;">
								
								<img src="assets/images/cars.png"	alt="" title="">
									
						<div class="col-md-12 col-xs-12 res3" style="padding-top:30px"><h1 class="h1_bg_sel">SELL YOUR CAR FOR FREE</h1></div>
		 
		<br><br><br>
		 <ul class="sellCarInfolist res3">
									<li>
										<!-- <div class="sellIconImgWrapper">
											<span class="sellicon1"></span>
										</div> -->
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
		
								<!-- <h1 class="h1_bg_sel">SELL YOUR CAR FOR FREE</h1> -->
								
							</div>
						</div>
						<%
							String message = (String) request.getAttribute("existemail");
						%>
						<div class="col-lg-6 col-md-6 col-sm-12 col-xsm-12">
							<div class="auctionFormRight" style="margin-top: 34px;">
							
								<div class="col-md-1 col-xs-12"></div>
								<div class="auctionMainForm col-md-10 col-xs-12">
									<form name="sellfrm" id="sellfrm" method="POST"
										action="./individualOwnerRegisterController"
										onSubmit="return validate()">
										<%
											if (message != null) {
										%>
										<h4 style="color: red"><%=message%>
										</h4>
										<%
											} else {
											}
										%>
										<div >
											<h2 class="aucformTitle" style="margin-bottom: 15px; text-align: center; ">
											Just Fill in Your Details & Get Started</h2>
											
											<!-- <div class="col-md-12" style="text-align: center;
                                     font-size: 22px; color: #f94141;">
										   <label style="font-size: 15px;
                                            font-weight: 500; color: #333;"><input type="checkbox" value="4"
													name="vehicleType" checked style="width: 16px; height: 16px;"> FOUR WHEELER</label>
											&nbsp; &nbsp;<label style="font-size: 15px;
                                            font-weight: 500; color: #333;"><input type="checkbox" value="2"
													name="vehicleType" style="width: 16px; height: 16px;"> TWO WHEELER </label>
										</div> -->
										
                                            <div class="margin0" style="text-align: center; line-height: 5px;">
											<label style="font-size: 16px;
                                            font-weight: 600; color: #333;"><input type="radio" name="type" value="individual" checked style="width: 16px; height: 16px;"> INDIVIDUAL OWNER</label>
											&nbsp; &nbsp;<label style="font-size: 16px;
                                            font-weight: 600; color: #333;"><input type="radio" style="width: 16px; height: 16px;" name="type" value="business" onclick="location.href='userType.jsp'"> BUSINESS OWNER </label>
											<!-- <label>
									<input type="radio" name="type" value="DR" onClick="location.href='driverRegistration.jsp'"><b>DRIVER </b>
									</label> -->
									</div>
										</div>

										<div class="aucformFieldsBox" style="margin-top: 15px" style="text-align: center;  font-size: 22px; color: #f94141;">
							
											<div class="aucformFieldsBox">
											 <div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">Pancard</label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon">
											<i class="fa fa-mobile" aria-hidden="true"></i>
											</span>
								            <input class="form-control" type="text" id="panNo" placeholder="Enter Pancard No." name="panno">
								            </div></div>
								            </div>
								            </div>
											</div>
											
										    <div class="aucformFieldsBox">
											<div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">City <span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon">
											<i class="fa fa-map-marker" aria-hidden="true"></i>
											</span>
								            <input type="text" name="city" id="city" class="form-control" placeholder="Enter City" required>
								            </div></div>
								            </div>
								            </div>
											</div>
											
											<div class="aucformFieldsBox">
											<div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">Pincode<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon">
											<i class="fa fa-street-view" aria-hidden="true"></i>
											</span>
								           <input class="form-control" autocomplete="off" type="text" name="pincode"
											     placeholder="Enter Pincode No" required onkeyup="NumAndTwoDecimals(event , this);" id="pinNo" maxlength="6"></div>
										
								            </div></div>
								            </div>
								            </div>
											</div>
											
											<!-- 	<div class="col-md-6 col-sm-6">
											<label>City<span style="color: red">*</span></label>
											</div>
												<div class="col-md-6 col-sm-6">
												<input type="text" name="city" id="city" class="form-control" placeholder="Enter City" required>
											</div>
										</div>
										<div class="aucformFieldsBox">
											<div class="col-md-6 col-sm-6 col-xs-12">
											<label>Pincode<span style="color: red">*</span></label>
											</div>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<div class="aucformFieldsBox">
												
												<input class="form-control" autocomplete="off" type="text" name="pincode"
											     placeholder="Enter Pincode No" required onkeyup="NumAndTwoDecimals(event , this);" id="pinNo" maxlength="6"></div>
											</div>
											<div class="clr"></div>
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
										
										<div class="clearfix"></div>
									<!-- 	<div class="aucformFieldsBox">
											<label>VEHICLE TYPE :</label><br>
										</div>
										<div>
											<td><label><input type="checkbox" value="4"
													name="vehicleType" checked> FOUR WHEELER</label></td>
											<td><label><input type="checkbox" value="2"
													name="vehicleType"> TWO WHEELER </label></td>
										</div> -->
										<div class="frmsubhead" style="text-align: center; font-size: 20px;">
											Contact Information<span style="color: #D10"></span>
										</div>
										
										    <div class="aucformFieldsBox">
											<div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">FullName<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon">
											<i class="fa fa-user" aria-hidden="true"></i>
											</span>
								            <input class="form-control"	type="text" required placeholder="Enter Name" name="name" id="name"></div>
								            </div></div>
								            </div>
								            </div>
											
											
											<div class="aucformFieldsBox">
											<div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">Mobile No<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon">
											<i class="fa fa-mobile" aria-hidden="true"></i>
											</span>
								            	<input class="form-control" type="text" placeholder="Enter Mobile No." name="mobileNo"
												id="mobileNo" maxlength="10" required pattern="[1-9]{1}[0-9]{9}" autocomplete="off"
												title="Enter 10 digit mobile number" placeholder="Mobile Number" maxlength="10"></div>
								            </div></div>
								            </div>
								            </div>
											
											
											<div class="aucformFieldsBox">
											<div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">Email<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon">
											<i class="fa fa-envelope fa" aria-hidden="true"></i>
											</span>
								            <input class="form-control" type="text" placeholder="Enter EmailId" name="email" id="emailId" required></div>
								            </div></div>
								            </div>
								            </div>
											
											
											<div class="aucformFieldsBox">
											<div class="col-md-12 col-sm-12">
											<div class="row form-group">
								            <label class="col-md-2 control-label" style="font-size: 17px;color: #020202; font-family: sans-serif;">Password<span style="color: red">*</span></label>  
								            <div class="col-md-8">
											<div class="input-group">
											<span class="input-group-addon">
											<i class="fa fa-key" aria-hidden="true"></i>
											</span>
								             <input class="form-control" type="password" required placeholder="Enter Password" name="password"
												style="position: relative; border-radius: 0px 4px 4px 0px; padding-bottom: 8px;" placeholder="Enter Password"></div>
								            </div></div>
								            </div>
								            </div>
											
											
										<!-- <div class="aucformFieldsBox">
											<div class="col-md-6 col-sm-6">
											<label>FullName<span style="color: red">*</span></label> 
											</div>
											<div class="col-md-6 col-sm-6">
											<input class="form-control"	type="text" required placeholder="Enter Name" name="name" id="name">
												</div>
										</div> -->
										<!-- <div class="aucformFieldsBox">
											<div class="col-md-6 col-sm-6">
											<label>Mobile no.<span style="color: red">*</span></label>
											</div>
											<div class="col-md-6 col-sm-6">
											
											
											<input class="form-control" type="text" placeholder="Enter Mobile No." name="mobileNo"
												id="mobileNo" maxlength="10" required pattern="[1-9]{1}[0-9]{9}" autocomplete="off"
												title="Enter 10 digit mobile number" placeholder="Mobile Number" maxlength="10">
												</div>
										</div> -->
										<!-- <div class="aucformFieldsBox">
											<div class="col-md-6 col-sm-6">
											<label>Email<span style="color: red">*</span></label> 
											</div>
											<div class="col-md-6 col-sm-6">
											<input class="form-control" type="text" placeholder="Enter EmailId" name="email" id="emailId" required>
												</div>
										</div>
 -->
										<!-- <div class="aucformFieldsBox">
											<div class="col-md-6 col-sm-6">
											<label>Password<span style="color: red">*</span></label>
											</div>
											<div class="col-md-6 col-sm-6">
											 <input class="form-control" type="password" required placeholder="Enter Password" name="password"
												style="position: relative;  padding-bottom: 8px;" placeholder="Enter Password"></div>
										</div> -->
										<div class="aucformFieldsBox nomargin">
											<input type="checkbox" name="check_agree" id="check_agree"	required value="y" style="width: 20px;
                                           height: 20px; margin: 0 16px !important;">
												 <span class="ter">
												<a href="#" data-toggle="modal" data-target="#myModal"  target="_blank" class="ul" >
3												I agree to the Terms & Conditions
												</a></span>
											
											<!-- start pop up -->	
											<div class="modal fade" id="myModal" role="dialog">
                                         <div class="modal-dialog modal-lg">
                                          <div class="modal-content">
                                               <div class="modal-header">
                                         <button type="button" class="close" data-dismiss="modal">&times;</button>
                                           <h4 class="modal-title">Rules</h4>
                                            </div>
                                         <div class="modal-body">
                                         <p>terms and conditions.</p>
                                               </div>
                                         <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                          </div>
                                        </div>
                                           </div>
                                          </div>
											
                                   <!-- end pop up -->	
										
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
													<h4>										
										<input class="btn" type="submit" value="REGISTER" style="width:100px;background-color: red; color: white;padding-bottom: 6px;">
										</h4>
											</h4>
										</div> -->
									</form>
								</div>
							</div>
						</div>
						
						<!-- <div class="col-md-6 col-xs-12">
						
						<div class="col-md-12 col-xs-12" style="padding-top:30px"><h1 class="h1_bg_sel">SELL YOUR CAR FOR FREE</h1></div>
		<ul class="sellCarInfolist">
		<br><br><br>
		 <ul class="sellCarInfolist">
									<li>
										<div class="sellIconImgWrapper">
											<span class="sellicon1"></span>
										</div>
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
									<li>
										<div class="sellIconImgWrapper">
											<span class="sellicon4"></span>
										</div>
										<div class="sellIconTxtWrapper">
											<h2>Your Used Car stays listed till the car is sold</h2>
										</div>
									</li>
								</ul>
		</div> -->
						
                 <div class="col-md-12 col-xs-12">
										<br>
										</div>
					</section>
				</div>
				
				
				


			</div>
			
			
			
		</section>


		<!-- blog section -->

		<!-- Newsletter -->
		
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
	<script type="text/javascript">

 document.getElementById('register1').className = 'active';

 </script>
</body>
</html>
									 