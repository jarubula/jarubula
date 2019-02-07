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

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@page import="com.vaahanmitra.model.Registration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*"
	%>
<!DOCTYPE html >
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
	<style>
		label, .control-label {
    font-weight: inherit;
    float: left;
    font-size: 15px;
    font-family: sans-serif;
    line-height: 7px;
    color: #5e6061; 
}
.form-control {
    display: block;
    width: 100%;
    height: 30px;
    /* padding: 6px 12px; */
    font-size: 14px;
    line-height: 1.42857143;
    color: #555;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
    -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
    transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
}
#b1{
    border: 1px solid #fff;
    border-radius: 5px;
    }
    h4{
    font-size:23px;
    color: #efa844;
    font-weight: 500;
    font-family: sans-serif;
    
    }
    .form-control.boxed {
    border-radius: 0;
    box-shadow: none;
    border-radius: 3px;
    line-height: 15px;
    font-size: 13px;
}
.nav-tabs>li.active>a, .nav-tabs>li.active>a:focus, .nav-tabs>li.active>a:hover {
    color: #fff;
    cursor: default;
    background-color: #523f6d;
    border: 1px solid #523f6d;
    border-bottom-color: transparent;
    font-size: 21px;
    line-height: 15px;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
     width:300px;
     text-align: center;
}
.nav-tabs>li>a {
    margin-right: 2px;
    line-height: 1.42857143;
    border: 1px solid transparent;
    border-radius: 4px 4px 0 0;
    background: #f5f5f5;
    color: #000;
    line-height: 14px;
     border-top-left-radius: 5px;
    border-top-right-radius: 5px;
      width:300px;
     text-align: center;
}
h4 {
    font-size: 23px;
    color: #efa844;
    font-weight: 500;
    font-family: sans-serif;
    text-align: center;
}
@media  (max-width:767px){

.nav-tabs>li.active>a, .nav-tabs>li.active>a:focus, .nav-tabs>li.active>a:hover {
    color: #fff;
    cursor: default;
    background-color: #523f6d;
    border: 1px solid #523f6d;
    border-bottom-color: transparent;
    font-size: 21px;
    line-height: 15px;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
     width:100%;
     text-align: center;
}
.nav-tabs>li>a {
    margin-right: 2px;
    line-height: 1.42857143;
    border: 1px solid transparent;
    border-radius: 4px 4px 0 0;
    background: #f5f5f5;
    color: #000;
    line-height: 14px;
     border-top-left-radius: 5px;
    border-top-right-radius: 5px;
   width:100%;
   text-align: center;
}


}
ul.tabs{
			margin: 0px;
			padding: 0px;
			list-style: none;
		}
		ul.tabs li{
			background: none;
			color: #222;
			display: inline-block;
			padding: 10px 15px;
			cursor: pointer;
		}

		ul.tabs li.current{
			background: #ededed;
			color: #222;
		}
ul.tabs li.current {
    background: #523f6d;
    color: #222;
    border-radius: 7px 7px 0 0;
    line-height: 14px;
    padding: 10px 52px 10px 52px;
    border: 1px solid #fff;
}
ul.tabs li {
 background: #8b9cb1;
    border-radius: 7px 7px 0 0;
    line-height: 14px;
    padding: 10px 52px 10px 52px;
    border: 1px solid #fff;
    color: #222;
    display: inline-block;
    cursor: pointer;
}
		.tab-content{
			display: none;
			
			padding: 15px;
		}

		.tab-content.current{
			display: inherit;
		}
		.c-1{
		color:#fff !important;
		}
	</style>	
		
		
		
		
<script type="text/javascript">
	$(document).ready(function () {
    $("#type").change(function () {
        var val = $(this).val();
        if (val == "item1") {
            $("#size").html("<option value='test'>item1: test 1</option><option value='test2'>item1: test 2</option>");
        } else if (val == "item2") {
            $("#size").html("<option value='test'>item2: test 1</option><option value='test2'>item2: test 2</option>");
        } else if (val == "item3") {
            $("#size").html("<option value='test'>item3: test 1</option><option value='test2'>item3: test 2</option>");
        }
    });
});
	</script>
	<style type="text/css">
		.multiselect {
  width: 200px;
}

.selectBox {
  position: relative;
}

.selectBox select {
  width: 100%;
  font-weight: bold;
}

.overSelect {
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
}

#checkboxes {
  display: none;
  border: 1px #dadada solid;
}

#checkboxes label {
  display: block;
}

#checkboxes label:hover {
  background-color: #1e90ff;
}
	</style>
	<script type="text/javascript">
		var expanded = false;

function showCheckboxes1() {
  var checkboxes = document.getElementById("checkboxes");
  if (!expanded) {
    checkboxes.style.display = "block";
    expanded = true;
  } else {
    checkboxes.style.display = "none";
    expanded = false;
  }
}
	</script>
  <script type="text/javascript">
    var expanded = false;

function showCheckboxes2() {
  var checkboxes = document.getElementById("checkboxes");
  if (!expanded) {
    checkboxes.style.display = "block";
    expanded = true;
  } else {
    checkboxes.style.display = "none";
    expanded = false;
  }
}
  </script><script type="text/javascript">
	$(document).ready(function () {
    $("#type").change(function () {
        var val = $(this).val();
        if (val == "item1") {
            $("#size").html("<option value='test'>item1: test 1</option><option value='test2'>item1: test 2</option>");
        } else if (val == "item2") {
            $("#size").html("<option value='test'>item2: test 1</option><option value='test2'>item2: test 2</option>");
        } else if (val == "item3") {
            $("#size").html("<option value='test'>item3: test 1</option><option value='test2'>item3: test 2</option>");
        }
    });
});
	</script>
	<style type="text/css">
		.multiselect {
  width: 200px;
}

.selectBox {
  position: relative;
}

.selectBox select {
  width: 100%;
      font-weight: normal;
    height: 30px;
    padding: 4px 6px;
}

.overSelect {
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
}

#checkboxes {
  display: none;
  border: 1px #dadada solid;
}

#checkboxes label {
  display: block;
}

#checkboxes label:hover {
    background-color: #f1f2f3;
}
.app .content {
    padding: 74px 30px 90px 50px;
    min-height: 100vh;
}
	</style>
	<script type="text/javascript">
		var expanded = false;

function showCheckboxes1() {
  var checkboxes = document.getElementById("checkboxes");
  if (!expanded) {
    checkboxes.style.display = "block";
    expanded = true;
  } else {
    checkboxes.style.display = "none";
    expanded = false;
  }
}
	</script>
  <script type="text/javascript">
    var expanded = false;

function showCheckboxes2() {
  var checkboxes = document.getElementById("checkboxes");
  if (!expanded) {
    checkboxes.style.display = "block";
    expanded = true;
  } else {
    checkboxes.style.display = "none";
    expanded = false;
  }
}
  </script>
</head>
<body>
	<div class="center-block">
		<div class="main-wrapper">
			<div class="app" id="app">
				
				  <header class="">
			<div class="header-block header-block-nav"></div>
			</header>
			<br>
				<article class="content responsive-tables-page" style="background-color:#fff">
				<section class="section">
				
				 
				<div class="row">
			
				<h3 style="text-align: center; font-size: 33p">ADD CAR MASTER</h3>
					<div class="col-md-12" style="background: #fff;     border-radius: 5px; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-bottom: 3px solid #a3b745;     padding-left: 0;">
								
								 <%
 	                 String str = (String) request.getAttribute("success");
                     if(str!=null){%> <%=str%><%}else{} %>
						<div class="">
							<div class=""><!-- card-block -->
		                               <!---------------- new tabs ----------------->
		     <div class="col-md-12" style="padding-left: 0px; padding-right: 0px;" >
		     	<p></p>
				   <ul class="tabs" style="margin: 0 2%;">
                   <li  class="tab-link current" data-tab="tab-1"><a class="c-1" >Basic Fields</a></li>
                   <li class="tab-link" data-tab="tab-2"><a class="c-1" >Add More Fields</a></li>
                   </ul>
          
			      <div  style="">
			      <div  id="tab-1" class="tab-content current" style="padding-left: 0px;padding-right: 0px;">
			       <div class="table-responsive">
										<form action="./AdminAddCar" method="post" enctype="multipart/form-data">
											<div class="col-md-12">
												<h4>Engine and Transmission</h4>
											</div>
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span> Car Brand : </label>
                                               <input type="text" name="carBrand" class="form-control boxed" placeholder="Enter Car Brand" required>
                                                </div>
											</div>
											
											<!-- <div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span> Car Brand : </label>
                                              <input type="file" name="filename" accept="image/gif, image/jpeg, image/png">
                                                </div>
											</div> -->
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"> </span> Car Model : </label>
                                               <input type="text" name="carModel" class="form-control boxed" placeholder="Enter Car Model" required>   
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Model Variant Name: </label>
                                               <input type="text" name="variantName" class="form-control boxed" placeholder="Enter Variant Name" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>No of Gears : </label>
                                             <input type="text" name="gears" class="form-control boxed" placeholder="Enter No of Gears" onkeypress="CheckNumeric(event)" required>
                                                </div>
											</div>
											
											
						
											
										<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>No of Colors : </label>
                                              <input type="text" name="color" class="form-control boxed" placeholder="Enter Color"  required>
                                              </div></div>
											
											
											
											
											
										
											
														<div class="col-md-4">
											  <div class="form-group"> 	 
                                              <!--  <label for="firstname"><span class="req"></span>No of Colors : </label> -->
                                               <label for="firstname"><span class="req"> </span> Car Make Year : </label><br>
        <select id="makeYear" class="form-control boxed" name="makeYear" required="required">
                                                         <option>SELECT YEAR</option>
                                                 </select>

    </div>
                                                </div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Engine Type : </label>
                                               <input type="text" name="engineType" class="form-control boxed" placeholder="Enter Engine Type" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Engine Displacement(cc) : </label>
                                               <input type="text" name="displacement" class="form-control boxed" placeholder="Displacement" required>
                                                </div>
											</div> 
                                             
                                             <div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>No.of.Cylinders : </label>
                                               <input type="text" name="cylinders" class="form-control boxed" placeholder="Enter Cylinders" required>
                                                </div>
											</div>

											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Value per Cylinder : </label>
                                               <input type="text" name="vpCylinders" class="form-control boxed" placeholder="Enter Valves per cylinder" required>
                                                </div>
											</div>

											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Max Power : </label>
                                              <input type="text" name="maxPower" class="form-control boxed" placeholder="Enter Max Power" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Max Torque : </label>
                                              <input type="text" name="maxTorque" class="form-control boxed" placeholder="Enter Max Torque" required>
                                                </div>
											</div>

											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"> </span> Fuel supply System : </label>
                                               <input type="text" name="fuelSupplySystem" class="form-control boxed" placeholder="Enter Fuel supply System" required>   
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Transmission Type : </label>
                                             <select  class="form-control boxed" name="transmissionType" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="automatic">AUTOMATIC</option>
															<option value="manual">MANUAL</option>
													</select>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Gear Box : </label>
                                               <input type="text" name="gearBox" class="form-control boxed" placeholder="Enter Gear Box" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Wheel Drive : </label>
                                               <input type="text" name="wDrive" class="form-control boxed" placeholder="Enter Wheel Drive" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											<div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Body Type : </label>
                                               <input type="text" name="b_type" class="form-control boxed" placeholder="Enter Body Type" required>
                                            </div>
											</div>
											
											<div class="col-md-4"></div>
											
											<div class="col-md-12">
											  <h4>Suspension and Steering</h4>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Front Suspension : </label>
                                               <input type="text" name="frontSuspension" class="form-control boxed" placeholder="Enter Front Suspension" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Rear Suspension : </label>
                                               <input type="text" name="rearSuspension" class="form-control boxed" placeholder="Enter Rear Suspension" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Steering Type : </label>
                                               <input type="text" name="steeringType" class="form-control boxed" placeholder="Enter Steering Type" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Minimum Turning Radius(Wheel) : </label>
                                               <input type="text" name="turningRadions" class="form-control boxed" placeholder="Enter Turning Radions" required>
                                                </div>
											</div>
											
											
											<div class="col-md-12">
											  <h4>Fuel and Performance</h4>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Mileage(kmpl) : </label>
                                              <input type="text" name="mileage" class="form-control boxed" placeholder="Enter Mileage" required>
                                                </div>
											</div>
											
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Fuel Type : </label>
                                               <select  class="form-control boxed" name="fuelType" style=" height:28px;" required>
															<option style="display:none; " value="">Select</option>
															<option value="PETROL">PETROL</option>
															<option value="DIESEL">DIESEL</option>
															<option value="CNG">CNG</option>
															<option value="LPG">LPG</option>
															<option value="ELECTIC">ELECTIC</option>
													</select>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Fuel Tank Capacity : </label>
                                             <input type="text" name="tankCapacity" class="form-control boxed" placeholder="Enter Tank Capacity in Liters" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Top Speed : </label>
                                             <input type="text" name="topSpeed" class="form-control boxed" placeholder="Enter Top Speed" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Acceleration(0-100Kms) : </label>
                                             <input type="text" name="acceleration" class="form-control boxed" placeholder="Enter Acceleration" required>
                                                </div>
											</div>
											
											
											<div class="col-md-12">
											  <h4>Brake and Tyres</h4>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Tyre Type : </label>
                                               <input type="text" name="t_type" class="form-control boxed" placeholder="Enter Tyre Type" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Front Brake Type : </label>
                                                 <select  class="form-control boxed" name="frontBrakeType" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Drum">Drum</option>
															<option value="Disk">Disk</option>
													</select>
													
													
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Rear Brake Type : </label>
                                                <select  class="form-control boxed" name="rareBrakeType" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Drum">Drum</option>
															<option value="Disk">Disk</option>
													</select>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Anti Lock Braking System : </label>
                                               <select  class="form-control boxed" name="brakingSystem" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Tyre Size : </label>
                                               <input type="text" name="tyreSize" class="form-control boxed" placeholder="Enter Tyre Size" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Wheel Size : </label>
                                               <input type="text" name="wheelSize" class="form-control boxed" placeholder="Enter Wheel Size" required>
                                                </div>
											</div>
											
										
											<div class="col-md-12">
											  <h4>Comfort and Convenience</h4>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Power Steering : </label>
                                                <select  class="form-control boxed" name="powerSteering" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                                </div>
											</div>
											
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Air Conditioner : </label>
                                               <input type="text" name="airConditioner" class="form-control boxed" placeholder="Enter Air Conditioner" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Rear A/C : </label>
                                               <input type="text" name="rearAC" class="form-control boxed" placeholder="Enter Air Rear AC" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Steering Adjustment : </label>
                                               <input type="text" name="steeringAdjustment" class="form-control boxed" placeholder="Enter Steering Adjustment" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Keyless Start/Button Start : </label>
                                                 <select  class="form-control boxed" name="keylessStart" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Parking Sensors : </label>
                                               <input type="text" name="parkingSensors" class="form-control boxed" placeholder="Enter Parking Sensors" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Parking Assist : </label>
                                               <input type="text" name="parkingAssist" class="form-control boxed" placeholder="Enter Parking Assist" required>
                                                </div>
											</div>
											
											<div class="col-md-12">
											  <h4>Safety</h4>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                              	 	<label for="firstname"><span class="req"></span>Air Bags : </label>
                                               		<input type="text" name="airBags" class="form-control boxed" placeholder="Enter Air Bags" required>
                                              </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                              	 	<label for="firstname"><span class="req"></span>Seat Belt Warning : </label>
                                               		  <select  class="form-control boxed" name="seatBeltWarning" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                              </div>
											</div>
											
											 <div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Photo : </label>
                                               <input type="file" class="form-control boxed" name="photo" accept="image/*" placeholder="Select Image" required>
                                                </div>
											</div>
									
											<div class="col-md-12">
											   <div class="col-md-4"></div>
											   <div class="col-md-2" style="padding:0 0;"><button type="submit" class="btn btn-primary  btn-block" id="b1">ADD CAR</button></div>
											    <div class="col-md-1"></div>
											   <div class="col-md-2" style="padding:0 0;"><button type="reset" class="btn btn-danger  btn-block" id="b1">RESET</button></div>
											   <div class="col-md-5"></div>
											</div>
										</form>
								</div>
			      </div>
			      <div id="tab-2" class="tab-content" style="padding-left: 0px;padding-right: 0px;" >
			      <div class="table-responsive">
										<form action="./NewCarSpecifications" method="post">
										
										<%
											AdminService as = new AdminService();
											ArrayList<AddCar>  crId  = as.getNewCarId();
											Iterator it = crId.iterator();
										%>
									
										<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname" style=" margin: 10px 0;  "><span class="req"></span>Select CarId : </label>
                                               <select  class="form-control boxed" name="carId" style=" height:29px;" id="vType" onchange="getNewVcleBrand(this.value)" required>
															<br>
															<option value="">Select Car ID</option>
														<%
																while (it.hasNext()) {
																	for (int i = 0; i < crId.size(); i++) {
																		AddCar ac = (AddCar) it.next();
															%>
														<option value="<%=ac.getNEW_CAR_ID()%>"><%=ac.getNEW_CAR_ID()%></option>
														<%
																}
																}
															%>
												</select>
                                                </div>
											</div>
											<div class="col-md-4"></div>
											<div class="col-md-4"></div>
										<div class="col-md-12"  id="txtHint20">
											 
											</div>
										
										<div class="col-md-12">
											  <h4>Locking Security</h4>
											</div>
											 
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                              	 	<label for="firstname"><span class="req"></span>Engine Immobilizer : </label>
                                               		  <select  class="form-control boxed" name="engineImmobilizer" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                              </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                              	 	<label for="firstname"><span class="req"></span>Central Locking System : </label>
                                               		<input type="text" name="centralLockingSystem" class="form-control boxed" placeholder="Enter Central Locking System" required>
                                              </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                              	 	<label for="firstname"><span class="req"></span>Child Locking System : </label>
                                                      <select  class="form-control boxed" name="childlockingSystem" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                              </div>
											</div>
											
											<div class="col-md-12">
											  <h4>Lamp</h4>
											</div>
										
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Automatic Head Lamps: </label>
                                                <select  class="form-control boxed" name="headLamps" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                               </div>
											   </div>
											   
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Fog Lamps: </label>
                                               <input type="text" name="forLamps" class="form-control boxed" placeholder="Enter For lamps" required>
                                               </div>
											   </div>
											   
											    <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Tail Lamps: </label>
                                               <input type="text" name="tailLamps" class="form-control boxed" placeholder="Enter Tail lamp" required>
                                               </div>
											   </div>
											   
											    <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Head Lamps: </label>
                                               <input type="text" name="headLight" class="form-control boxed" placeholder="Enter Head Lamps" required>
                                               </div>
											   </div>
												
												 <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Head Light Adjuster: </label>
                                                <select  class="form-control boxed" name="heightAdjuster" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                               </div>
											   </div>
											   
											  <div class="col-md-12">
											  <h4>Entertainment Information</h4>
											  </div>
										
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Integrated Music System: </label>
                                               <select  class="form-control boxed" name="musicSystem" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                               </div>
											   </div>
											   
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Display: </label>
                                               <input type="text" name="display" class="form-control boxed" placeholder="Enter Display" required>
                                               </div>
											   </div>
											   
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Display Screen for Rear Passengers: </label>
                                                <select  class="form-control boxed" name="screenRearPassengers" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                               </div>
											   </div>
											   
											    <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>GPS Navigation System: </label>
                                                <select  class="form-control boxed" name="navigationSystem" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                               </div>
											   </div>
											   
											    <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Speakers : </label>
                                               <input type="text" name="speakers" class="form-control boxed" placeholder="Enter Speakers" required>
                                               </div>
											   </div>
											   
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>USB compatibility : </label>
                                               <select  class="form-control boxed" name="USBcompatibility" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
													</div>
											   </div>
											   
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>MP3 Player : </label>
                                                 <select  class="form-control boxed" name="MP3" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                               </div>
											   </div>
											   
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>CD Player : </label>
                                                 <select  class="form-control boxed" name="CDPlayer" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                               </div>
											   </div>
											   
											    <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>DVD Player : </label>
                                                 <select  class="form-control boxed" name="DVDPlayer" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
													</div>
											   </div>
											   
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>FM/AM Radio : </label>
                                                <select  class="form-control boxed" name="FMAMRadio" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                               
                                               </div>
											   </div>
											   
											    <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Bluetooth Compatibility : </label>
                                                <select  class="form-control boxed" name="bluetooth" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                               
                                               </div>
											   </div>
											   
											   
											   
											   
											   
											  <div class="col-md-12">
											  <h4>Dimensions and Weight</h4>
											  </div>
										
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Length : </label>
                                               <input type="text" name="length" class="form-control boxed" placeholder="Enter Length" required>
                                               </div>
											   </div>
											   
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Width : </label>
                                               <input type="text" name="width" class="form-control boxed" placeholder="Enter Width" required>
                                               </div>
											   </div>
											   
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Height : </label>
                                               <input type="text" name="height" class="form-control boxed" placeholder="Enter Height" required>
                                               </div>
											   </div>
											   
										       <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Wheel base : </label>
                                               <input type="text" name="wheelbase" class="form-control boxed" placeholder="Enter Wheel base" required>
                                               </div>
											   </div>
											   
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Ground Clearance : </label>
                                               <input type="text" name="groundClearance" class="form-control boxed" placeholder="Enter Ground Clearance" required>
                                               </div>
											   </div>
											   
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Boot Space: </label>
										       <input type="text" name="boot_space" class="form-control boxed" placeholder="Enter Boot Space" required>
                                               </div>
											   </div>
											   
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Krab weight: </label>
										       <input type="text" name="Krab_weight" class="form-control boxed" placeholder="Enter Krab weight" required>
                                               </div>
											   </div>
											   
											
											   
											   <div class="col-md-12">
											  <h4>Instrumentation</h4>
											  </div>
										
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Clock : </label>
                                               <input type="text" name="clock" class="form-control boxed" placeholder="Enter Clock " required>
                                               </div>
											   </div>
											   
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Low Fuel level Waring : </label>
                                               <select  class="form-control boxed" name="lowFuellevelWaring" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                               </div>
											   </div>
											   
											    <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Door Ajar Waring : </label>
                                                <select  class="form-control boxed" name="doorCloseWaring" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                               </div>
											   </div>
											   
											       <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Trip Meter : </label>
													 <input type="text" name="trip_meter" class="form-control boxed" placeholder="Enter Trip Meter" required>
                                               </div>
											   </div>
											   
											       <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Gear Shift Indicator : </label>
                                                <select  class="form-control boxed" name="gear_shift_indicator" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                               </div>
											   </div>
											
											  <div class="col-md-12">
											  <h4>Door, Window, Mirrors and Wipers</h4>
											  </div>
										
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Power Windows : </label>
                                               <input type="text" name="powerWindows" class="form-control boxed" placeholder="Enter Power Windows" required>
                                               </div>
											   </div>
											   
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Rear Defogger : </label>
                                                 <select  class="form-control boxed" name="rearDetogger" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                               </div>
											   </div>
											   
											    <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Rear Wiper : </label>
                                                 <select  class="form-control boxed" name="rearWiper" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                               </div>
											   </div>
											   
											    <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Rain Sensing Wiper : </label>
                                                <select  class="form-control boxed" name="rainSensingWiper" style=" height: 30px;" required>
															<option style="display: none;" value="">Select</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
													</select>
                                               </div>
											   </div>
											   
											    <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>No of Doors : </label>
										       <input type="text" name="noOfDoors" class="form-control boxed" placeholder="Enter No Of Doors" required>
                                               </div>
											   </div>
											
											   
											  <div class="col-md-12">
											  <h4>Seating</h4>
											  </div>
										
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Seating Capacity : </label>
                                               <input type="text" name="seatingCapacity" class="form-control boxed" placeholder="Enter Seating Capacity" required>
                                               </div>
											   </div>
											   
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Front Passenger Seat Adjustment : </label>
                                               <input type="text" name="passengerSeatAdjustment" class="form-control boxed" placeholder="Enter Passenger Seat Adjustment" required>
                                               </div>
											   </div>
											   
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Folding Rear Seat : </label>
                                               <input type="text" name="foldingRearSeat" class="form-control boxed" placeholder="Enter Folding Rear Seat" required>
                                               </div>
											   </div>
											   
											    <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Split Rear Seat : </label>
                                               <input type="text" name="splitRearSeat" class="form-control boxed" placeholder="Enter Split Rear Seat" required>
                                               </div>
											   </div>
											   
											     <div class="col-md-12">
											  <h4>Warranty</h4>
											  </div>
										
											   <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Warranty (Years) : </label>
                                               <input type="text" name="warranty(Years)" class="form-control boxed" placeholder="Enter Warranty (Years) " required>
                                               </div>
											   </div>
											   
											     <div class="col-md-4">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Warranty (Kms) : </label>
                                               <input type="text" name="warranty(Kms)" class="form-control boxed" placeholder="Enter Warranty (Kms) " required>
                                               </div>
											   </div>
											   
									
											   
											   <div class="col-md-12">
											   <div class="col-md-4"></div>
											   <div class="col-md-2" style="padding:0 0;"><button type="submit" class="btn btn-primary  btn-block" id="b1">UPDATE CAR</button></div>
											  <div class="col-md-1"></div>
											   <div class="col-md-2" style="padding:0 0;"><button type="reset" class="btn btn-danger  btn-block" id="b1">RESET</button></div>
											   <div class="col-md-5"></div>
											</div>
										</form>
								</div>
			      </div>  
			      </div>
	          </div>
	          <!---------------- end new tabs ----------------->
								<section class="example">
								
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
			</div>
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
		populateBrands("brand", "model");
 	</script>
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
	xmlhttp.open("GET","./getAdminNewVecleBrand.jsp?carId="+str,true);   
	xmlhttp.send();    
	}
	</script>
	<pre>
 	</pre>
	<footer>Copyright &copy; vehicletracking.com</footer>
	
	<script type="text/javascript">
	
	$(document).ready(function(){
		
		$('ul.tabs li').click(function(){
			var tab_id = $(this).attr('data-tab');

			$('ul.tabs li').removeClass('current');
			$('.tab-content').removeClass('current');

			$(this).addClass('current');
			$("#"+tab_id).addClass('current');
		})

	}) 
	</script>
		<script>
	
 var start = 2017;
var end = new Date().getFullYear();
var options = "";

for(var year = start ; year <=end; year++){
  options += "<option value="+year+">"+ year +"</option>";
}
document.getElementById("makeYear").innerHTML = options;
</script>
</body>
</html>