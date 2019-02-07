<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Register</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<!-- Base Css -->
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/register-page.css" rel="stylesheet"
	type="text/css" />

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

.h1_bg_sel {
	background: url('https://imgct2.aeplcdn.com/images4/sel_car_h1_bg.png')
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
<script>
function toggle_it(itemID){ 
    // Toggle visibility between none and '' 
    if ((document.getElementById(itemID).style.display == 'none')) {
          document.getElementById(itemID).style.display = '' 
          event.preventDefault()
    } else { 
          document.getElementById(itemID).style.display = 'none'; 
          event.preventDefault()
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
		<!-- /.nav end -->

		<!-- service -->
		<section class="service-inner"
			style="margin-top: 40px; min-height: 600px;">
			<div class="container">
				<div class="row">
					<section class="sellUcarpg">
					
					
						<div class="col-lg-6 col-md-8 col-sm-10 col-xsm-10" style="margin-top:20px">
							<div class="auctionFormRight">
								<div class="auctionMainForm well" >
									<form name="sellfrm" id="sellfrm" method="POST" action="" onSubmit="return validate()">
						
								
										<div class="aucformFieldsBox nomargin">
												 <span class="termlabel">
												 
												<marquee><h4><font color="red">Feel free to contact us,We are always available for you..</font></h4></center></marquee>
												 
												<p align="justify" class="nomargin">
												<font size="3" style="color:#000">	 Unit - 602, Level 6,<br>
                									Manjeera Majestic Commercial,<br>
                									Hi-Tech City Road,KPHB,<br>
                									Hyderabad - 500072<br>
                									Telangana<br>
                									India<br>
              									<span style="font-weight:600;">  Ph: 040 - 40191909  |  E-Mail: <font color="#0a0ea0">info@vaahanmitra.com</font></span>
												</font></p>
											</span>
											<br>
											<br>
											
											<hr color="#000" style="height:1px">
											<br>
											<font size="3" style="color:#000"> OV Road,<br>
                							Opposite to SBH Bank,<br>
                							Kandukur -Prakasam -523105<br>
                							AndhraPradesh<br>
                							India<br>
             								<span style="font-weight:600;">  Ph: 08598 - 222283  | E-Mail:  <font color="#0a0ea0">info@vaahanmitra.com</font></span></font><br><br>
             								
             									<div class="col-lg-3 col-md-3 col-sm-3 col-xsm-3">
							<div class="aucformFieldsBox nomargin">
						<div>
							<a style="cursor: pointer;"><u>For Used Car</u></a><br>
							<a style="cursor: pointer;"><u>For Used Bike</u></a><br>
							<a style="cursor: pointer;"><u>For New Car</u></a><br>
							<a style="cursor: pointer;"><u>For New Bike</u></a><br>
							<a style="cursor: pointer;"><u>For Service Center</u></a><br>
							<a style="cursor: pointer;"><u>For Dealer</u></a><br>
							<a style="cursor: pointer;"><u>For Driver</u></a>
							<%-- <a id="toggle" href="javascript:toggle_it('<%="toggleText" %>')" ><u>For Used Car</u></a><br>
							<span id="<%="toggleText" %>" style="display: none">
							<input type="text" name="name" width="100"/><br>
							<input type="text" name="email"/><br>
							<textarea rows="2" cols="2" width="100"></textarea> <br>
							<input type="submit" value="Submit"/>
							</span> --%>
							</div>
							</div>
							</div>
             								
										</div>
									
									</form>
								</div>
							
							</div>
						
						</div>
					
						<div class="col-lg-6 col-md-6 col-sm-12 col-xsm-12" style="margin-top: 62px;">
							<div class="auctionFormLeft"
								style=" margin-right: 15px; padding: 0px 20px 0 0;">
									
								<img
									src="images/carImage.jpg"
									alt="" title="">
								<h1 class="h1_bg_sel">SELL YOUR CAR FOR FREE</h1>
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
									<!-- <li>
										<div class="sellIconImgWrapper">
											<span class="sellicon3"></span>
										</div>
										<div class="sellIconTxtWrapper">
											<h2>Speedy and Easy Process</h2>
											<p>List your car within 2 minutes and in 1 easy step</p>
										</div>
									</li> -->
									
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
							<!-- <input type="text" class="form-control"
								placeholder="Enter Your Email" name="q"> -->
							<div class="input-group-btn">
							<!-- 	<button class="btn btn-default" type="submit">
									<i class="flaticon-paper-plane"></i> Subscribe
								</button> -->
							</div>
						</div>

					</div>
				</div>
			</div>
		</section>
	</div>
	<!-- Footer Section -->
	<footer>
		<div class="container">
			<div class="row">
				<!-- Address -->
				<div class="col-sm-4 col-md-3">
					<div class="footer-box address-inner">
						<h4 style="color: #fff;">VaahanMitra</h4>
						<div class="address">
							<i class="flaticon-placeholder"></i>
							<p>
								Unit - 602, Level 6,<br> Manjeera Majestic Commercial,<br>
								Hi-Tech City Road,KPHB,<br> Hyderabad - 500072<br>
								Telangana<br> India
							</p>
						</div>
						<div class="address">
							<i class="flaticon-customer-service"></i>
							<p>040 - 40191909</p>
						</div>
						<div class="address">
							<i class="flaticon-mail"></i>
							<p>info@vaahanmitra.com</p>
						</div>
					</div>
				</div>
				<div class="col-sm-8 col-md-6">
					<div class="row">
						<div class="col-md-4 col-sm-4">
							<div class="footer-box">
								<h4 class="footer-title">Information</h4>
								<ul class="categoty">

									<li><a href="#">About us</a></li>
									<li><a href="#">Online Enquiry</a></li>
									<li><a href="#">Call us</a></li>
									<li><a href="#">Terms and Conditions</a></li>
									<li><a href="#">Privacy & Cookies Policy</a></li>
									<li><a href="#">Become a partner</a></li>
								</ul>
							</div>
						</div>
						<div class="col-md-4 col-sm-4">
							<div class="footer-box">
								<h4 class="footer-title">Our Parteners</h4>
								<ul class="categoty">
									<li><a href="#">Campusguide.in</a></li>
									<li><a href="#">Rythumitra.in</a></li>
									<li><a href="#">Frytemate.com</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<div class="sub-footer">
			<div class="container">
				<div class="row">
					<div class="col-sm-5">
						<p>Copyright © 2017. All rights reserved</p>
					</div>
					<div class="col-sm-7">
						<div class="footer-menu">
							<ul>
								<li><a href="#">Home</a></li>
								<li><a href="#">About</a></li>
								<li><a href="#">Service</a></li>
<!-- 								<li><a href="#">Blog</a></li> -->
								<li><a href="#">Shop</a></li>
								<li><a href="#">Forum</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
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

 document.getElementById('contactUs').className = 'active';

 </script>
</body>
</html>