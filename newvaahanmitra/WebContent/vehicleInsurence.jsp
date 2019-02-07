<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Vehicle Insurence.jsp</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<!-- Base Css -->
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/register-page.css" rel="stylesheet"
	type="text/css" />

<style type="text/css">
.element {
  display: inline-block;
  background-color: #0074d9;
  height: 100px;
  width: 100px;
  font-size: 1px;
  padding: 1px;
  color: white;
  margin-right: 5px;
  margin-left: 5px;
  animation: roll 3s infinite;
  transform: rotate(30deg);
  opacity: .7;
}

@keyframes roll {
  0% {
    transform: rotate(0);
  }
  100% {
    transform: rotate(360deg);
  }
}







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
					<br>
					<div class="well col-md-12">
					<div class="col-md-12 col-xs-12 ">
					<h1 class="text-center white0">Vehicle Insurence Providers and Agents</h1>
					</div>
					
					<div class="col-md-12 col-xs-12">
					
					<div class="col-md-12" >
					<h3>COMMING SOON....</h3>
					</div>
					<div class="col-md-12 col-xs-12" align="center">
					<div class="element">
                    </div>
                     <div class="element">
                        </div>
                     <div class="element">
                            </div>
					</div>
					
					
					</div>
					</div>
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

 document.getElementById('contactUs').className = 'active';

 </script>
</body>
</html>