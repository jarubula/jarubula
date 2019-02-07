<%
try {
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
    if (session.getAttribute("user")==null) {
    	%>
<jsp:forward page="./login3.jsp" ></jsp:forward>   <% }
    else {}
}
catch(Exception ex) {
    out.println(ex);
}
%>
<%@page import="com.vaahanmitra.model.Registration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<jsp:include page="./AdminMenu.jsp" />
<jsp:include page="./Admin-right-side.jsp" />

<script src="./css/countries.js" type="text/javascript"></script>

<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<!-- Theme initialization -->
<script>
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
 #baki1{
     background: #fff;
    box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15);
    border-bottom: 3px solid #a3b745;
    border-radius: 5px;
    padding-left: 0;
    }
    .baki2{
    font-size: 23px;
    color: #efa844;
    font-weight: 500;
    font-family: sans-serif;
        text-align: center;
    }
    label {
    display: inline-block;
    margin-bottom: .2rem;
    font-weight: 500 !important;
    font-size: 16px;
    color: #000;
}
.form-control {
    padding: 0 5px;
    display: block;
    width: 100%;
    font-size: 1rem;
    line-height: 1.5;
    color: #55595c;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: .25rem;
    height:29px !important;
    font-size: 15px !important;
}
/* .form-control.underlined {
     padding-left: 0;
    padding-right: 0;
    padding-left: 0;
    padding-right: 0;
    border-radius: 0;
    border: none;
    border-radius: 0;
    box-shadow: none;
    border-bottom: 1px solid #ffffff;
   
} */

 .form-control.underlined {
        padding-left: 5px;
    padding-right: 0;
    }

.select-filters select {
    background: 0 0;
    width: 100%;
    padding: 7px -1px 0px 10px;
    border: 0;
    border-radius: 0;
    height: 28px;
    margin: 0;
    /* font-size: 12px; */
    color: #888;
    font-weight: 400;
    -moz-appearance: window;
    -webkit-appearance: none;
    cursor: pointer;
}
.select-filters {
       width: 100%;
    overflow: hidden;
    height: 29px;
    background: url(../images/down-arrow.png) right center no-repeat #fff;
    margin: 0;
    padding: 0;
    border: 1px solid #ddd;
    display: block;
    border-radius: 3px;
  
}
#b1{
    border-radius: 5px;
    border: 1px solid #fff;
    line-height: 19px;
    }

 </style>
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">

			<header class="">
			
			<div class="header-block header-block-nav">
			</div>
			</header>
			<br>

			<article class="content responsive-tables-page"
				style="background-color:#fff">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div align="center" style="font-size: 25px">ADMIN DASHBOARD</div>
			</div>
			<section class="section">

			<div class="row">
			<%
									String message = (String) request.getAttribute("success");
								%>
							

				
						<div class="col-md-12 col-xs-12" align="center">
										<%
												if (message != null) {
											%>
											<h5 style="color: red"><%=message%>
											</h5>
											<%
												} else {
												}
											%>
									</div>
					
					<div class="col-md-12"><p></p></div>
					
					<!-- --------------------------- new section ------------------ -->
					
					
					<%
					ArrayList <AddBike> alistb=new ArrayList<>();
					alistb=(ArrayList<AddBike>)request.getAttribute("list_details");
					Iterator iterator=alistb.iterator();
					while(iterator.hasNext()){
						AddBike bike=(AddBike)iterator.next();	
					%>
					<div class="col-md-12 col-xs-12 col-sm-12" id="baki1">
				<div class="row">
					<div class="col-md-12 col-xs-12 col-sm-12">
						<div class="">
							<div class="">
								<section class="example">
								<div class="table-responsive">
										<form action="./aUpdateNewBikeDetails" method="post" >
											<p></p>
											<div class="col-md-12 baki2">
											  <h4>Basic Details</h4>
											</div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Brand : </label>
                                                 <input type="text" name="brand" class="form-control" value="<%=bike.getBIKE_BRAND()%>" placeholder="Enter Brand" required>
                                                 </div>
											     </div>
									             
									             <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Model : </label>
                                                 <input type="text" name="model" class="form-control" value="<%=bike.getBIKE_MODEL()%>" placeholder="Enter Model" required>
                                                 </div>
											     </div>
											     
											       <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Variant Name : </label>
                                                 <input type="text" name="variantname" class="form-control" value="<%=bike.getVARIANT_NAME()%>" placeholder="Enter Variant" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Color  : </label>
                                                 <input type="text" name="color" class="form-control" value="<%=bike.getCOLOR()%>"" placeholder="Enter Color" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Bike Make Year : </label>
                                                 <%-- <input type="text" name="productionYear" class="form-control" value="<%=bike.getBIKE_PRODUCTION_YEAR()%>" placeholder="Enter Bike Make Year" required> --%>
                                                <select id="productionYear" class="form-control boxed" name="productionYear" required>
                                                        <option style="display: none;"><%=bike.getBIKE_PRODUCTION_YEAR()%></option>
                                                         <option style="display: none;">SELECT YEAR</option>
                                                 </select>
                                                 </div>
											     </div>
											
											
											
											
											<div class="col-md-12 baki2">
											  <h4>Engine And Transmission</h4>
											</div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Engine Type : </label>
                                                 <input type="text" name="engineType" class="form-control" value="<%=bike.getENGINE_TYPE()%>" placeholder="Enter Engine Type" required>
                                                 </div>
											     </div>
									             
									             <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Displacement(CC) : </label>
                                                 <input type="text" name="displacement" class="form-control" value="<%=bike.getDISPLACEMENT_CC() %>" placeholder="Enter Displacement(CC)" required>
                                                 </div>
											     </div>
											     
											       <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Power : </label>
                                                 <input type="text" name="power" class="form-control" value="<%=bike.getMAX_POWER()%>" placeholder="Enter Power" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Torque : </label>
                                                 <input type="text" name="torque" class="form-control" value="<%=bike.getMAX_TORQUE()%>" placeholder="Enter Torque" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Bore : </label>
                                                 <input type="text" name="bore" class="form-control" value="<%=bike.getBORE()%>" placeholder="Enter Bore" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Stroke : </label>
                                                 <input type="text" name="stroke" class="form-control" value="<%=bike.getSTROKE()%>" placeholder="Enter Stroke" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Fuel System : </label>
                                                 <input type="text" name="fuel_system" class="form-control" value="<%=bike.getFUEL_SYSTEM()%>" placeholder="Enter Fuel System" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Fuel Type : </label>
                                                 <input type="text" name="fuel_type" class="form-control" value="<%=bike.getFUEL_SYSTEM()%>" placeholder="Enter Fuel Type" required>
                                                 </div>
											     </div>
									
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Ignition : </label>
                                                 <input type="text" name="ignition" class="form-control" value="<%=bike.getIGNITION()%>" placeholder="Enter Ignition" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Digital Fuel Indicator : </label>
                                                    <select id="country" name="digital_fuel_indicator" class="form-control" style="padding: 3px 8px;
                                                  font-size: 14px; ">
                                                  <option style="display: none;"><%=bike.getDIGITAL_FUEL_INDICATOR()%></option>  
					                            <option style="display: none;">Select</option>
					                            <option value="YES">Yes</option>
					                            <option value="NO">No</option></select>
                                                 
                                                 </div>
											     </div>
											     
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Strating Type : </label>
                                                 <select id="country" name="electric_start" class="form-control" style="padding: 3px 8px;
                                                  font-size: 14px; ">
                                                  <option style="display: none;"><%=bike.getENGINE_STARTING()%></option>
					                            <option style="display: none;">Select</option>
					                            <option value="Kick Start">Kick Start</option>
					                            <option value="Kick & Self Start">Kick & Self Start</option>
					                            </select>
                                                 </div>
											     </div>
										
										         <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>No Of Gears : </label>
                                                 <input type="text" name="no_of_gears" class="form-control" value="<%=bike.getNO_OF_GEARS()%>" placeholder="Enter No Of Gears" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-12">
											     <h4>Brakes</h4>
											     </div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Brakes Front : </label>
                                                 <select id="country" name="brakes_front" class="form-control" style="padding: 3px 8px;
                                                  font-size: 14px; ">
                                                   <option style="display: none;"><%=bike.getFRONT_BRAKE() %></option>
					                            <option style="display: none;">Select </option>
					                            <option value="Drum">Drum</option>
					                            <option value="Disk">Disk</option></select>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Brakes Rear : </label>
                                                 <select id="country" name="brakes_rear" class="form-control" style="padding: 3px 8px;
                                                  font-size: 14px; ">
                                                   <option style="display: none;"><%=bike.getREAR_BRAKE()%> </option>
					                            <option style="display: none;">Select </option>
					                            <option value="Drum">Drum</option>
					                            <option value="Disk">Disk</option></select>
                                                 </div>
											     </div>
											     
												  <div class="col-md-12 baki2">
												  <h4>Performance And Fuel Econams</h4>
												  </div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Milleage : </label>
                                                 <input type="text" name="milleage" class="form-control" value="<%=bike.getMILEAGE()%>" placeholder="Enter Milleage " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Top Speed (Km/n) : </label>
                                                 <input type="text" name="top_speed" class="form-control" value="<%=bike.getTOP_SPEED()%>" placeholder="Enter Top Speed (Km/n) " required>
                                                 </div>
											     </div>
											     
											      <div class="col-md-12">
												  <h4>Chassis And Suspension</h4>
												  </div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Chassis Type : </label>
                                                 <input type="text" name="chassis_type" class="form-control" value="<%=bike.getCHASSIS_TYPE()%>" placeholder="Enter Chassis Type " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Suspension Front : </label>
                                                 <input type="text" name="suspension_front" class="form-control" value="<%=bike.getFRONT_SUSPENSION()%>" placeholder="Enter Suspension Front " required>
                                                 </div>
											     </div>
											     
											      <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Suspension Rear : </label>
                                                 <input type="text" name="suspension_rear" class="form-control" value="<%=bike.getREAR_SUSPENSION()%>" placeholder="Enter Suspension Rear " required>
                                                 </div>
											     </div>
											     
											     
											      <div class="col-md-12">
												  <h4>Tyre And Wheels</h4>
												  </div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Tyre Type : </label>
                                                 <input type="text" name="tyre_type" class="form-control" value="<%=bike.getTYRE_TYPE()%>" placeholder="Enter Tyre Type " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Tyre Size (Front) : </label>
                                                 <input type="text" name="tyre_size_front" class="form-control"  value="<%=bike.getFRONT_TYRE()%>" placeholder="Enter Tyre Size (Front) " required>
                                                 </div>
											     </div>
											     
											      <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Tyre Size (Rear) : </label>
                                                 <input type="text" name="tyre_size_rear" class="form-control" value="<%=bike.getREAR_TYRE()%>" placeholder="Enter Tyre Size (Rear)" required>
                                                 </div>
											     </div>
											 
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Wheel Size : </label>
                                                 <input type="text" name="wheel_size" class="form-control" value="<%=bike.getWHEEL_SIZE()%>" placeholder="Enter Wheel Size" required>
                                                 </div>
											     </div>
											     
											        <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Wheel Type : </label>
                                                 <input type="text" name="wheel_type" class="form-control" value="<%=bike.getWHEEL_TYPE()%>" placeholder="Enter Wheel Type" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-12">
												  <h4>Dimensions</h4>
												  </div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Length : </label>
                                                 <input type="text" name="length" class="form-control" value="<%=bike.getLENGTH()%>" placeholder="Enter Length " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Width : </label>
                                                 <input type="text" name="width" class="form-control" value="<%=bike.getWIDTH()%>" placeholder="Enter Width " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Height : </label>
                                                 <input type="text" name="height" class="form-control" value="<%=bike.getHEIGHT()%>" placeholder="Enter Hight " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Wheel Base : </label>
                                                 <input type="text" name="wheel_base" class="form-control" value="<%=bike.getWHEEL_BASE()%>" placeholder="Enter Wheel base " required>
                                                 </div>
											     </div>
											     
											       <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Ground Clearance : </label>
                                                 <input type="text" name="ground_clearance" class="form-control" value="<%=bike.getGROUND_CLEARANCE()%>" placeholder="Enter Ground Clearance " required>
                                                 </div>
											     </div>
											     
											       <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Fuel Capacity : </label>
                                                 <input type="text" name="fuel_capacity" class="form-control" value="<%=bike.getFUEL_CAPACITY()%>" placeholder="Enter Fuel Capacity " required>
                                                 </div>
											     </div>
											     
											       <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Kerb Weight : </label>
                                                 <input type="text" name="kerb_weight" class="form-control" value="<%=bike.getKERBWEIGHT()%>" placeholder="Enter Kerb Weight" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-12 baki2">
												  <h4>Electricals</h4>
												  </div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Battery : </label>
                                                 <input type="text" name="battery" class="form-control" value="<%=bike.getBATTERY_CAPACITY()%>" placeholder="Enter Battery " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Head Lamp : </label>
                                                 <input type="text" name="head_lamp" class="form-control" value="<%=bike.getHEAD_LAMP()%>" placeholder="Enter Head Lamp " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-12">
												  <h4>Warranty</h4>
												  </div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Standard Warranty (years) : </label>
                                                 <input type="text" name="standard_warranty_years" class="form-control" value="<%=bike.getSTANDARD_WARRANTY_YEARS()%>" placeholder="Enter Standard Warranty " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Standard Warranty (Kms) : </label>
                                                 <input type="text" name="standard_warranty_kms" class="form-control" value="<%=bike.getSTANDARD_WARRANTY_KMS()%>" placeholder="Standard Warranty (Kms) : " required>
                                                <input type="hidden" value="<%=bike.getNEW_BIKE_ID()%>" name="bike_id">
                                                 </div>
											     </div>
											     
											   
												
											<div class="col-md-12">
											   <div class="col-md-4"></div>
											   <div class="col-md-3"><button type="submit" class="btn btn-primary  btn-block" id="b1">Update</button></div>
											   <div class="col-md-5"></div>
											</div>
										</form>
										
								</div>
								</section>
							</div>
						</div>
					</div>
				</div>									
					</div>
					
					<!-- -------------------------end new section -------------------- -->
				
				
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
	<!-- Reference block for JS -->
	<div class="ref" id="ref">
		<div class="color-primary"></div>
		<div class="chart">
			<div class="color-primary"></div>
			<div class="color-secondary"></div>
		</div>
	</div>
	
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
	
	
	      <script>
	function getVehicleModels(str) {
		var vType ="2,";
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
		xmlhttp.open("GET", "./getADNewVecleModel.jsp?vBrand="+str+ "&vType="+ vType, true);
		xmlhttp.send();
	}
</script>

	        <script>
	function getVehicleVariant(str) {
		var vType ="2,";
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
		xmlhttp.open("GET", "./getADNewVecleVariant.jsp?vmodel="+str+ "&vType="+ vType, true);
		xmlhttp.send();
	}
</script>
<script type="text/javascript">
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
<!-- productionYear start-->
	<script>
 var start = 2017;
var end = new Date().getFullYear();
var options = "";
options += "<option style='display:none;' value="+ <%=bike.getBIKE_PRODUCTION_YEAR()%>+">"+ <%=bike.getBIKE_PRODUCTION_YEAR()%> +"</option>";
for(var year = start ; year <=end; year++){
	

  options += "<option value="+ year +">"+ year +"</option>";
}
document.getElementById("productionYear").innerHTML = options;
</script>
<!-- productionYear end -->
<%} %>
</body>
</html>