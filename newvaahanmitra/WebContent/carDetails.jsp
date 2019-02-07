<%@page import="javax.smartcardio.Card"%>
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
<title>search new car</title>
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
        @-webkit-keyframes zoom {
  from {
    -webkit-transform: scale(1, 1);
  }
  to {
    -webkit-transform: scale(1.5, 1.5);
  }
}

@keyframes zoom {
  from {
    transform: scale(1, 1);
  }
  to {
    transform: scale(1.5, 1.5);
  }
}

.carousel-inner .item > img {
  -webkit-animation: zoom 20s;
  animation: zoom 20s;
}
</style>
</head>
<body>
	<!-- page loader -->
	<div class="se-pre-con"></div>
	<div id="page-content">
		<!-- navber -->
		<jsp:include page="./homeTop.jsp"></jsp:include>
		<!-- /.nav end -->

		<!-- service -->

		<%
			String vid = request.getParameter("vid");
			GetNewCarDetails gcd = new GetNewCarDetails();
			ArrayList<AddCar> carDetails = gcd.getCarDetails(vid);
			AddCar car = null;
			if (carDetails.size() >= 1) {
				car = carDetails.get(0);
			} else {
			}
			request.setAttribute("car", car);
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
									<option value="" style="display: none;">Vehicle Type</option>
									<option value="2,">Two Wheeler</option>
									<option value="4,">Four Wheeler(Light Vehicle)</option>
								</select>
						</div>
						</div>
						
						<div class="col-md-8" style="padding:0 0px;">
						<div class="col-md-3 col-sm-6 col-xsm-12">
							<label>Vehicle Brand :</label>
								<div id="txtHint20">
									<select name="vehicleBrand" class="form-control">
										<option value="SELECT" style="display: none;">Vehicle Brand</option>
									</select>
								</div>
						</div>
						<div class="col-md-3 col-sm-6 col-xsm-12">
							<div class="">
									<label for="email">Vehicle Model :</label>
									<!-- filters select -->
									<div id="txtHintD">
										<select name="vehicleModel" class="form-control">
											<option value="SELECT" style="display: none;">Vehicle Model</option>
										</select>
									</div>
								</div>
								<input type="hidden" name="spage" value="result">
								                 <input type="hidden" >
	                                            <input type="hidden" name="bodyType" value="SELECT">
	                                            <input type="hidden" name="fuelType" value="SELECT">
	                                            <input type="hidden" name="transmission" value="SELECT">
	                                            <input type="hidden" name="color" value="SELECT">
	                                            <input type="hidden" name="budget" value="SELECT">
	                                            <input type="hidden" name="vType" value="4,">
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
							<div class="">
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
										     
									</div>
								</div>
						    </div>
						    </div>

						    <div class="col-md-2" style="padding:0 0px;">
						    <div class="col-md-12 col-sm-12 col-xsm-12"
							style="margin-top:28px;">
                             <button type="submit" class="btn btn-primary btn-block">Search</button>
						</div>
						</div>
						<div class="col-md-1 col-sm-6 col-xsm-12">	
						</div>
					</div>
				</form>
				</div>
		
			<div class="col-md-12 one"> 
                <div class="col-md-12" style="text-align: center; margin: 8px 0;"><span class="car1">${car.VARIANT_NAME}</span></div>
                  <div class="col-md-6 one">
                  <div class="col-md-12"><p class="car2">General Specifications</p></div>
                 	
                 	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Last new price :</div>
                  	 	<div class="col-md-6 col-xs-6 car4"><%-- <%=car.getPRICE() %> --%></div>
                  	</div>
                  
                  	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Brand :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.CAR_BRAND}</div>
                  	</div>
                  
                  	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Car Make Year :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.CAR_MAKE_YEAR}</div>
                  	</div>
                  
                  	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Seating Capacity :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.SEATING_CAPACITY}</div>
                  	</div>
                  
                  	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">No of Gears :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.NO_OF_GEARS}</div>
                  	</div>
                  	
                  	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Body Type :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.BODY_TYPE}</div>
                  	</div>
                  
                  	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Engine Type :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.ENGINE_TYPE}</div>
                  	</div>
                  
                  	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Displacement(cc) :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.ENGINE_DISPLACEMENT}</div>
                  	</div>
                  
                  	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">No.of.Cylinders :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.NO_OF_CYLINDERS}</div>
                  	</div>
                  
                  	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Valves per Cylinder :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.VALVES_PER_CYLINDERS}</div>
                  	</div>

                  	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Max Power :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.MAX_POWER}</div>
                  	</div>
                   
                   	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Max Torque :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.MAX_TORQUE}</div>
                  	</div>
                 
                   	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Fuel supply System :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.FUEL_SUPPLY_SYSTEM}</div>
                  	</div>
                  
                    <div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Transmission Type :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.TRANSMISSION_TYPE}</div>
                  	</div>
                  	
                  	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Wheel Drive :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.WHEEL_DRIVE}</div>
                  	</div>
                  
                  
                  <div class="col-md-12"><p class="car2">Fuel and Performance</p></div>
                  	
                  	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Mileage :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.MILEAGE}</div>
                  	</div>
                  	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Fuel Type :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.FUEL_TYPE}</div>
                  	</div>
                  	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Fuel Tank Capacity :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.FUELTANK_CAPACITY}</div>
                  	</div>
                  	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Top Speed :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.TOP_SPEED}</div>
                  	</div>
                  	<div class="col-md-12 col-xs-12 one">
                  		<div class="col-md-6 col-xs-6 car3">Acceleration(0-100Kms) :</div>
                  		<div class="col-md-6 col-xs-6 car4">${car.ACCELERATION}</div>
                  	</div>
    
                  	<div class="col-md-12"><p class="car2">Brake and Tyres</p></div>
                  	
                  	<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Tyre Type :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.TYRE_TYPE}</div>
                  		</div>
                  		
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Front Brake Type :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.ACCELERATION}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Rare Brake Type :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.RARE_BRAKE_TYPE}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Anti Lock Braking System :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.ANTI_LOCK_BRAKING_SYSTEM}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Tyre Size :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.TYRE_SIZE}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Wheel Size :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.WHEEL_SIZE}</div>
                  		</div>
                  
                  <div class="col-md-12"><p class="car2">Dimensions and Weight</p></div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Length :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.LENGTH}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Width :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.WIDTH}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Height :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.HEIGHT}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Wheel base :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.WHEEL_BASE}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Ground Clearance :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.GROUND_CLEARANCE}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Boot Space :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.BOOT_SPACE}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Krab Weight :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.KRAB_WEIGHT}</div>
                  		</div>
                  		
                  		<div class="col-md-12"><p class="car2">Lamp</p></div>
                  		<div class="col-md-12 col-xs-12 one">
                 			<div class="col-md-6 col-xs-6 car3">Automatic Head Lamps: :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.AUTOMATIC_HEAD_LAMPS}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Fog Lamps :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.FOR_LAMPS}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Tail Lamps :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.TAIL_LAMPS}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Head Lamps :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.HEAD_LIGHT}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Head Light Adjuster :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.HEIGHT_ADJUSTER}</div>
                  		</div>
                  		
                  		
                  		<div class="col-md-12"><p class="car2">Door, Window, Mirrors and Wipers</p></div>
                  		<div class="col-md-12 col-xs-12 one">
                 			<div class="col-md-6 col-xs-6 car3">Power Windows :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.POWER_WINDOWS}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Rear Defogger :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.REAR_DETOGGER}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Rear Wiper :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.REAR_WIPER}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Rain Sensing Wiper :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.RAIN_SENSING_WIPER}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">No of Doors :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.NO_OF_DOORS}</div>
                  		</div>
                  		
                  		<div class="col-md-12"><p class="car2">Instrumentation</p></div>
                  		<div class="col-md-12 col-xs-12 one">
                 			<div class="col-md-6 col-xs-6 car3">Clock :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.CLOCK}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Low Fuel level Waring :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.LOW_FUEL_LEVEL_WARNING}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Door Close Waring :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.DOOR_CLOSE_WARNING}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Trip Meter :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.TRIP_METER}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Gear Shift Indicator :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.GEAR_SHIFT_INDICATOR}</div>
                  		</div>
                  		
                  		<div class="col-md-12"><p class="car2">Warranty</p></div>
                  		<div class="col-md-12 col-xs-12 one">
                 			<div class="col-md-6 col-xs-6 car3">Warranty (Years) :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.WARRANTY_YEAR}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Warranty (Kms) :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.WARRANTY_KMS}</div>
                  		</div>
                  		
                  		</div>
                  <div class="col-md-6 one">
                  
                  <div class="col-md-12"><p class="car2">Suspension and Steering</p></div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Front Suspension :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.FRONT_SUSPENSION}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Rear Suspension :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.REAR_SUSPENSION}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Steering Type :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.STEERING_TYPE}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Turning Radions(Wheel) :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.TURNING_RADIONS}</div>
                  		</div>
                  
                   <div class="col-md-12"></br></div>
                   
                  <div class="col-md-12"><p class="car2">${car.VARIANT_NAME}</p></div>
                  <div class="col-md-12 col-xs-12 one">
                         <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/Nsec4hWZz2M" frameborder="0" allow="autoplay; encrypted-media" style="border: 2px solid #fff;  border-radius: 15px; padding: 0px 0px; height: 281px; width: 100%;"></iframe>
                 <!--  <img src="images/car1.jpg" style="border: 2px solid #fff;  border-radius: 15px; padding: 0px 19px; height: 281px; width: 100%;"> -->
                  </div>
                  
                  <div class="col-md-12"></br></div>
                  <div class="col-md-12"><p class="car2">Seating</p></div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Seating Capacity :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.SEATING_CAPACITY}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Passenger Seat Adjustment :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.ADJUST_PASSENGER_SEAT}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Folding Rear Seat :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.FOLDING_REAR_SEAT}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Split Rear Seat :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.SPLIT_RARE_SEAT}</div>
                  		</div>
                  
                      <div class="col-md-12"><p class="car2">Safety</p></div>
                  		<div class="col-md-12 col-xs-12 one">
                 			<div class="col-md-6 col-xs-6 car3">Air Bags  :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.AIR_BAGS}</div>
                  		</div>
                  
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Seat Belt Warning :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.SEAT_BELT_WARNING}</div>
                  		</div>
                  		
                  		<div class="col-md-12"><p class="car2">Locking Security</p></div>
                  		<div class="col-md-12 col-xs-12 one">
                 			<div class="col-md-6 col-xs-6 car3">Engine Immobilizer :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.ENGINE_IMMOBILIZER}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Central Locking System :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.CENTRAL_LOCKING_SYSTEM}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Child Locking System :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.CHILD_LOCKING_SYSTEM}</div>
                  		</div>
                  		
                  		<div class="col-md-12"><p class="car2">Comfort and Convenience</p></div>
                  		<div class="col-md-12 col-xs-12 one">
                 			<div class="col-md-6 col-xs-6 car3">Power Steering :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.POWER_STEERING}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Air Conditioner :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.AIR_CONDITIONER}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Rear A/C :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.REAR_AC}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Steering Adjustment :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.STEERING_ADJUSTMENT}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Keyless Start/Button Start :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.KEYLESS_START}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Parking Sensors :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.PARKING_SENSORS}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Parking Assist :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.PARKING_ASSIST}</div>
                  		</div>
                  		<div class="col-md-12"><p class="car2">Entertainment Information</p></div>
                  		<div class="col-md-12 col-xs-12 one">
                 			<div class="col-md-6 col-xs-6 car3">Integrated Music System :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.MUSIC_SYSTEM}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Display :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.DISPLAY}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Display Screen for Rear Passengers :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.DISPLAY_SCREEN_REAR_PASSENGERS}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">GPS Navigation System :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.GPS_NAVIGATION_SYSTEM}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Speakers :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.SPEAKERS}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">USB compatibility :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.USB_COMPATIBILITY}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">MP3 Player :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.MP3_PLAYER}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">CD Player :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.CD_PLAYER}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">DVD Player :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.DVD_PLAYER}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">FM/AM Radio :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.FM_RADIO}</div>
                  		</div>
                  		<div class="col-md-12 col-xs-12 one">
                  			<div class="col-md-6 col-xs-6 car3">Bluetooth Compatibility :</div>
                  			<div class="col-md-6 col-xs-6 car4">${car.BLUETOOTH}</div>
                  		</div>
                  		
                  		
                  		
                  		
                  		
                  </div>
                   <div class="col-md-12"><br><br></div>
                <!-- ------------------------------- slider ------------------------------------>
                        
             <div class="col-md-12">
             <div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
    <li data-target="#myCarousel" data-slide-to="4"></li>
    <li data-target="#myCarousel" data-slide-to="5"></li>
    <li data-target="#myCarousel" data-slide-to="6"></li>
    <li data-target="#myCarousel" data-slide-to="7"></li>
    <li data-target="#myCarousel" data-slide-to="8"></li>
    <li data-target="#myCarousel" data-slide-to="9"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
  	  <div class="item active">
  	    <img src="data:image/png;base64,${car.PHOTO1}" width="100%">
  	  </div>
 
 <c:choose>
 	<c:when test="${empty car.PHOTO2}">
  	  <div class="item">
  	    <img src="data:image/png;base64,${car.PHOTO1}" width="100%">
  	  </div>
   	</c:when>
    <c:otherwise>
  	 	<div class="item">
    	  <img src="data:image/png;base64,${car.PHOTO2}" width="100%">
    	</div>
    </c:otherwise>
 </c:choose>
 
 <c:choose>
 	<c:when test="${empty car.PHOTO3}">
  	  <div class="item">
  	    <img src="data:image/png;base64,${car.PHOTO1}" width="100%">
  	  </div>
   	</c:when>
    <c:otherwise>
  	 	<div class="item">
    	  <img src="data:image/png;base64,${car.PHOTO3}" width="100%">
    	</div>
    </c:otherwise>
 </c:choose>
 
 <c:choose>
 	<c:when test="${empty car.PHOTO4}">
  	  <div class="item">
  	    <img src="data:image/png;base64,${car.PHOTO1}" width="100%">
  	  </div>
   	</c:when>
    <c:otherwise>
  	 	<div class="item">
    	  <img src="data:image/png;base64,${car.PHOTO4}" width="100%">
    	</div>
    </c:otherwise>
 </c:choose>
 
 <c:choose>
 	<c:when test="${empty car.PHOTO5}">
  	  <div class="item">
  	    <img src="data:image/png;base64,${car.PHOTO1}" width="100%">
  	  </div>
   	</c:when>
    <c:otherwise>
  	 	<div class="item">
    	  <img src="data:image/png;base64,${car.PHOTO5}" width="100%">
    	</div>
    </c:otherwise>
 </c:choose>
 
 <c:choose>
 	<c:when test="${empty car.PHOTO6}">
  	  <div class="item">
  	    <img src="data:image/png;base64,${car.PHOTO1}" width="100%">
  	  </div>
   	</c:when>
    <c:otherwise>
  	 	<div class="item">
    	  <img src="data:image/png;base64,${car.PHOTO6}" width="100%">
    	</div>
    </c:otherwise>
 </c:choose>
 
  <c:choose>
 	<c:when test="${empty car.PHOTO7}">
  	  <div class="item">
  	    <img src="data:image/png;base64,${car.PHOTO1}" width="100%">
  	  </div>
   	</c:when>
    <c:otherwise>
  	 	<div class="item">
    	  <img src="data:image/png;base64,${car.PHOTO7}" width="100%">
    	</div>
    </c:otherwise>
 </c:choose>
 
  <c:choose>
 	<c:when test="${empty car.PHOTO8}">
  	  <div class="item">
  	    <img src="data:image/png;base64,${car.PHOTO1}" width="100%">
  	  </div>
   	</c:when>
    <c:otherwise>
  	 	<div class="item">
    	  <img src="data:image/png;base64,${car.PHOTO8}" width="100%">
    	</div>
    </c:otherwise>
 </c:choose>
 
  <c:choose>
 	<c:when test="${empty car.PHOTO9}">
  	  <div class="item">
  	    <img src="data:image/png;base64,${car.PHOTO1}" width="100%">
  	  </div>
   	</c:when>
    <c:otherwise>
  	 	<div class="item">
    	  <img src="data:image/png;base64,${car.PHOTO9}" width="100%">
    	</div>
    </c:otherwise>
 </c:choose>
 
  <c:choose>
 	<c:when test="${empty car.PHOTO10}">
  	  <div class="item">
  	    <img src="data:image/png;base64,${car.PHOTO1}" width="100%">
  	  </div>
   	</c:when>
    <c:otherwise>
  	 	<div class="item">
    	  <img src="data:image/png;base64,${car.PHOTO10}" width="100%">
    	</div>
    </c:otherwise>
 </c:choose>
 
    <%-- <div class="item active">
      <img src="data:image/png;base64,${car.PHOTO1}" width="100%">
    </div>
    
    <div class="item">
      <img src="data:image/png;base64,${car.PHOTO2}" width="100%">
    </div>
    
    <div class="item">
      <img src="data:image/png;base64,${car.PHOTO3}" width="100%">
    </div>
    
     <div class="item">
      <img src="data:image/png;base64,${car.PHOTO4}" width="100%">
    </div>

     <div class="item">
      <img src="data:image/png;base64,${car.PHOTO5}" width="100%">
    </div> --%>
    
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
        
             </div>
             <!-- ---------------------------------end slider ------------------------------- -->
             <div class="col-md-12"><br><br></div>
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


</body>
</html>