<%@ page language="java"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Search Bike</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<!-- Base Css -->
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/modalForm.css" rel="stylesheet" type="text/css" />

<script>
function getNewVcleBrand(str)
{
	if (str=="")  
	{  
		document.getElementById("txtHint20").innerHTML="";  
		return;  
		}  
	if (window.XMLHttpRequest)  
	{
		// code for IE7+, Firefox, Chrome, Opera, Safari  
		xmlhttp=new XMLHttpRequest();  
		}
	else  
	{
		// code for IE6, IE5  
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
	xmlhttp.onreadystatechange=function()  
	{  
		if (xmlhttp.readyState==4 && xmlhttp.status==200)    
		{    
			document.getElementById("txtHint20").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./getADNewVecleBrand.jsp?vType="+str,true);   
	xmlhttp.send();    
	}
	</script>
<script>
	function getVehicleModels(str) {
		var vType = document.getElementById("vType").value;
		if (str == "") {
			document.getElementById("txtHintD").innerHTML = "";
			return;
		}
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari  
			xmlhttp = new XMLHttpRequest();
		} else {
			// code for IE6, IE5  
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("txtHintD").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./getADNewHVecleModel.jsp?vBrand="+str+ "&vType="+ vType, true);
		xmlhttp.send();
	}
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

<style type="text/css">

bootstrap.css:1417
ol, ul {
    margin-top: 0;
    margin-bottom: 10px;
}
.button1 {
	display: block;
	width: 180px;
	height: 40px;
	background: #356e9f;
	padding: 10px;
	text-align: center;
	border-radius: 5px;
	color: white;
	font-weight: bold;
}
.content {
    padding: 1px !important;
/*     display: none; */
} 
.sticky + .content {
    padding-top: 100px !important;
}
label{
    font-size: 16px;
    color: #555;
    font-weight: 500;
    }
       #search1 {
  max-width: 100%;
  
  -moz-transition: all 0.3s;
  -webkit-transition: all 0.3s;
  transition: all 0.3s;
}

.top {
    margin-top: 0px;
}
.form-group {
    margin-bottom: 25px;
}
.car1{
 color: #467aa1;
    font-size: 28px;
    font-weight: 500;
    margin: 10px 0px;
    padding: 0;
    }
    .car2{
    color: #ff7607;
    font-size: 23px;
    font-weight: 400;
    margin: 4px 0;
    }
    .car3{
    margin-top: 5px;
    font-family: Verdana;
    font-size: 15px;
    color: #443c3c;
    }
    .car4{
    margin-top: 5px;
    font-family: Verdana;
    font-size: 14px;
    color: #797474;
    }
    .one{
        padding: 0 0;
        }
</style>
</head>
<body>
	<% int fourWheeler = 0,twoWheeler = 0;%>
	<!-- page loader -->
	<div class="se-pre-con"></div>
	<div id="page-content">
		<!-- navber -->
		<jsp:include page="./homeTop.jsp"></jsp:include>
		<!-- /.nav end -->

		<!-- service -->

		<%  
		String vid = request.getParameter("vid");
		System.out.print(vid);
		GetNewBikeDetails gcd = new GetNewBikeDetails();
		ArrayList<AddBike> bikeDetails = gcd.getBikeDetails(vid);
		AddBike bike = null;
		if(bikeDetails.size()>=1){
		bike = bikeDetails.get(0);
		System.out.print(bike);
    }else{}
    request.setAttribute("bike", bike);
    %>
    <section class="service-inner">
			<div class="container">
			<div class="col-md-12">
				<form action="./SearchNewVehicle" method="post">
					<div class="row top">
					<div class="col-md-2" style="padding:0 0px;">
						<div class="col-md-12 col-sm-12 col-xsm-12">
							<label>Vehicle Type :</label>
								<select class="form-control" name="vType" id="vType" onchange="getNewVcleBrand(this.value)" required>
									<option value="" style="display: none;">VEHICLE TYPE</option>
									<option value="2,">TWO WHEELER</option>
									<option value="4,">FOUR WHEELER(Light Vehicle)</option>
								</select>
						</div>
						</div>
						
						<div class="col-md-8" style="padding:0 0px;">
						<div class="col-md-3 col-sm-6 col-xsm-12">
							<label>Vehicle Brand :</label>
								<div id="txtHint20">
									<select name="vehicleBrand" class="form-control">
										<option value="SELECT" style="display: none;">VEHICLE BRAND</option>
									</select>
								</div>
						</div>
						<div class="col-md-3 col-sm-6 col-xsm-12">
							<div class="">
									<label for="email">Vehicle Model :</label>
									<!-- filters select -->
									<div id="txtHintD">
										<select name="vehicleModel" class="form-control">
											<option value="SELECT" style="display: none;">VEHICLE MODEL</option>
										</select>
									</div>
								</div>
						</div>
						  <div class="col-md-3 col-sm-6 col-xsm-12">
							<div class="">
									<label for="email">Variant :</label>
									<!-- filters select -->
									<div id="txtHintV">
											<select name="vvariant" class="form-control">
											<option value="SELECT" style="display: none;">Vehicle Variant</option>
										</select>
									</div>
								</div>
						    </div>
						     <div class="col-md-3 col-sm-6 col-xsm-12">
							<div class="form-group">
									<label for="email">Make Year :</label>
									<!-- filters select -->
									<div id="txtHintD">
										<select name="makeYear" class="form-control">
							              <option value="SELECT" style="display: none;">SELECT YEAR</option>
										
										   <%
	                                            Date today = new Date();
	                                            Calendar cal = Calendar.getInstance();
	                                            cal.setTime(today);
	                                            int currentyear = cal.get(Calendar.YEAR);
	                                            int previous =currentyear-1;
	                                            %>
	                                            <option value="<%=currentyear%>">Current Year</option>
	                                            <option value="<%=previous%>">Previous Year</option>
										</select>
										   <input type="hidden" name="spage" value="result">
	                                            <input type="hidden" name="bodyType" value="SELECT">
	                                            <input type="hidden" name="fuelType" value="SELECT">
	                                            <input type="hidden" name="transmission" value="SELECT">
	                                            <input type="hidden" name="color" value="SELECT">
	                                            <input type="hidden" name="budget" value="SELECT">
	                                            <input type="hidden" name="vType" value="2,">
									</div>
								</div>
						     </div></div>
						     
						    <div class="col-md-2" style="padding:0 0px;">
						<div class="col-md-12 col-sm-12 col-xsm-12"
							style="margin-top:28px;">
                             <button type="submit" class="btn btn-primary btn-block">Search</button>
						</div>
						<div class="col-md-1 col-sm-6 col-xsm-12">	
						</div>
					</div></div>
				</form>
				</div>
		
			<div class="col-md-12 one"> 
                <div class="col-md-12" style="text-align: center; margin: 8px 0;"><span class="car1">${bike.VARIANT_NAME}</span></div>
                
                  <div class="col-md-6 one">
                  <div class="col-md-12"><p class="car2">General Specifications</p></div>
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Last new price :</div>
                  <div class="col-md-6 col-xs-6 car4">NA</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Brand :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.BIKE_BRAND}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Mileage :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.MILEAGE}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Engine Type :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.ENGINE_TYPE}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Color :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.COLOR}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Fuel Type :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.FUEL_TYPE}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Bike production year :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.BIKE_PRODUCTION_YEAR}</div>
                  </div>
                  
                  <div class="col-md-12"><p class="car2">Engine</p></div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Engine Type :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.ENGINE_TYPE}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Displacement (cc) :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.DISPLACEMENT_CC}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Maximum Torque :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.MAX_TORQUE}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Max Power :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.MAX_POWER}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Bore :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.BORE}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Stroke:</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.STROKE}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Ignition  :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.IGNITION}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Electric Start :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.ENGINE_STARTING}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">No Of Gears :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.NO_OF_GEARS}</div>
                  </div>
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Mileage :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.MILEAGE}</div>
                  </div>
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Top Speed :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.TOP_SPEED}</div>
                  </div>
                  
                  <div class="col-md-12"><p class="car2">Fuel</p></div>
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Fuel System :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.FUEL_SYSTEM}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Fuel Type :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.FUEL_TYPE}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Digital Fuel Indicator :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.DIGITAL_FUEL_INDICATOR}</div>
                  </div>
                  </div>
                  
                  
                  
                  
                  <div class="col-md-6 one">
                   <div class="col-md-12"><p class="car2">Brakes</p></div>
                   
                    <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Front Brakes :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.FRONT_BRAKE}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Rear Brakes :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.REAR_BRAKE}</div>
                  </div> </div>
                  
                      <div class="col-md-6 one">
                   <div class="col-md-12"></br></div>
                   
                  <div class="col-md-12"><p class="car2"> ${bike.VARIANT_NAME}</p></div>
                  <div class="col-md-12 col-xs-12 one">
                  <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/AOJPraw-1BQ" frameborder="0" allow="autoplay; encrypted-media" encrypted-media" encrypted-media" style="border: 2px solid #fff;  border-radius: 15px; padding: 0px 19px; height: 281px; width: 100%;"></iframe>
                  <!-- <img src="images/bike1.jpg" style="border: 2px solid #fff;  border-radius: 15px; padding: 0px 19px; height: 281px; width: 100%;"> -->
                  </div>
                     </div>
                  
                  
                   
                   
                <div class="col-md-6 one">
                   <div class="col-md-12"><p class="car2">Tyres</p></div>
                   
                      <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Tyre Type:</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.TYRE_TYPE}</div>
                  </div>
                    <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Front Tyre :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.FRONT_TYRE}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Rear Tyre :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.REAR_TYRE}</div>
                  </div>
                    <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Wheel Type :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.WHEEL_TYPE}</div>
                  </div>
                   
                     <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Wheel Size :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.WHEEL_SIZE}</div>
                  </div>
                   <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Wheel Base :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.WHEEL_BASE}</div>
                  </div>
                  </div>
                  
               
                   
                   
                   
                    <div class="col-md-6 one">
                   <div class="col-md-12"><p class="car2">Chassis</p></div>
                      
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Chassis Type :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.CHASSIS_TYPE}</div>
                  </div>
                  
                     <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Front Suspension :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.FRONT_SUSPENSION}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Rear Suspension :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.REAR_SUSPENSION}</div>
                  </div>
                   </div>
                   
                    
                     
                    <div class="col-md-6 one">
                   <div class="col-md-12"><p class="car2">Dimensions</p></div>
                   
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Length :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.LENGTH}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Width :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.WIDTH}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Height :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.HEIGHT}</div>
                  </div>
                   <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Ground Clearance :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.GROUND_CLEARANCE}</div>
                  </div>
                  
                  </div>
                  
                 
                 
                  
                   <div class="col-md-6 one">
                  
                  <div class="col-md-6"><p class="car2">Electricals</p></div>
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">battery:</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.BATTERY_CAPACITY}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Head Lamp :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.HEAD_LAMP}</div>
                  </div>
                  </div>
                   <div class="col-md-6 one">
                   <div class="col-md-6"><p class="car2">Warranty</p></div>
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Standard Warranty (years) :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.STANDARD_WARRANTY_YEARS}</div>
                  </div>
                  
                  <div class="col-md-12 col-xs-12 one">
                  <div class="col-md-6 col-xs-6 car3">Standard warranty (kms) :</div>
                  <div class="col-md-6 col-xs-6 car4">${bike.STANDARD_WARRANTY_KMS}</div>
                  </div>
                  
                  </div>
                   <div class="col-md-12"><br><br></div>
                        
             <div class="col-md-12">
              <iframe frameBorder="0" class="col-md-12 col-sm-12 col-xs-12" src="standard.jsp"  style="min-height:580px; background: #fff;"></iframe>
             </div>
             
            </div>
		
			</div>
		</section>
	</div>

	<!-- blog section -->

	<!-- Newsletter -->
	<section class="get-offer">
		<div class="container">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-5" style="text-align: center;">
					<span>Subscribe to our Newsletter</span>
					<h2>& Discover the best offers!</h2>
				</div>
				<div class="col-sm-4">
					<div class="input-group">
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
<script>
	function getVehicleVariant(str) {
		
		var vbrand = document.getElementById("vehicleBrand").value;
		var vmodel = document.getElementById("vehicleModel").value;
		var vType = document.getElementById("vType").value;
		
		if (str == "") {
			document.getElementById("txtHintV").innerHTML = "";
			return;
		}
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari  
			xmlhttp = new XMLHttpRequest();
		} else {
			// code for IE6, IE5  
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("txtHintV").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./getVariantbyBrandModel.jsp?vbrand="+vbrand+ "&vmodel="+vmodel+"&vType="+vType, true);
		xmlhttp.send();
	}
</script>

</body>
</html>