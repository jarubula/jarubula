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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./AdminMenu.jsp" />
<jsp:include page="./Admin-right-side.jsp" />
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
	<center>
		<div class="main-wrapper">
			<div class="app" id="app">

         <header class="">
			<div class="header-block header-block-nav"></div>
			</header>
			<br>
				<%
									String message = (String) request.getAttribute("success");
								%>
				<article class="content responsive-tables-page" style="background-color:#fff">
				<section class="section">
				<div class="row">
					<%
												if (message != null) {
											%>
											<h5 style="color: red"><%=message%>
											</h5>
											<%
												} else {
												}
											%>
					<div class="col-md-12">
					<h3>ADD BIKE</h3>
						<div class="card" style="background: #fff;     border-radius: 5px; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-bottom: 3px solid #a3b745;">
							<div class="card-block">
								<section class="example">
								<div class="table-responsive">
										<form action="./addBikeController" method="post" enctype="multipart/form-data">
											
											<div class="col-md-12">
											  <h4>Basic Details</h4>
											</div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Brand : </label>
                                                 <input type="text" name="brand" class="form-control boxed" placeholder="Enter Brand" required>
                                                 </div>
											     </div>
									             
									             <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Model : </label>
                                                 <input type="text" name="model" class="form-control boxed" placeholder="Enter Model" required>
                                                 </div>
											     </div>
											     
											       <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Variant Name : </label>
                                                 <input type="text" name="variantname" class="form-control boxed" placeholder="Enter Variant Name" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Color  : </label>
                                                 <input type="text" name="color" class="form-control boxed" placeholder="Enter Color " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Bike Make Year : </label>
                                                 <!-- <input type="text" name="productionYear" class="form-control boxed" placeholder="Enter Bike Make Year" required> -->
                                                <select id="productionYear" class="form-control boxed" name="productionYear" required>
                                                         <option>SELECT YEAR</option>
                                                 </select>
                                                 </div>
											     </div>
											
											
											
											
											<div class="col-md-12">
											  <h4>Engine And Transmission</h4>
											</div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Engine Type : </label>
                                                 <input type="text" name="engineType" class="form-control boxed" placeholder="Enter Engine Type" required>
                                                 </div>
											     </div>
									             
									             <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Displacement(CC) : </label>
                                                 <input type="text" name="displacement" class="form-control boxed" placeholder="Displacement(CC)" required>
                                                 </div>
											     </div>
											     
											       <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Power : </label>
                                                 <input type="text" name="power" class="form-control boxed" placeholder="Enter Power" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Torque : </label>
                                                 <input type="text" name="torque" class="form-control boxed" placeholder="Enter Torque" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Bore : </label>
                                                 <input type="text" name="bore" class="form-control boxed" placeholder="Enter Bore" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Stroke : </label>
                                                 <input type="text" name="stroke" class="form-control boxed" placeholder="Enter Stroke" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Fuel System : </label>
                                                 <input type="text" name="fuel_system" class="form-control boxed" placeholder="Enter Fuel System" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Fuel Type : </label>
                                                 <input type="text" name="fuel_type" class="form-control boxed" placeholder="Enter Fuel Type" required>
                                                 </div>
											     </div>
									
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Ignition : </label>
                                                 <input type="text" name="ignition" class="form-control boxed" placeholder="Enter Ignition" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Digital Fuel Indicator : </label>
                                                 <select id="country" name="digital_fuel_indicator" class="form-control" style="padding: 3px 8px;
                                                  font-size: 14px; ">
					                            <option style="display: none;">Select</option>
					                            <option value="YES">Yes</option>
					                            <option value="NO">No</option></select>
                                                 </div>
											     </div>
											     
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Starting Type : </label>
                                                 <select id="country" name="electric_start" class="form-control" style="padding: 3px 8px;
                                                  font-size: 14px; ">
					                            <option style="display: none;">Select Start Type</option>
					                            <option value="Kick Start">Kick Start</option>
					                            <option value="Kick & Self Start">Kick & Self Start</option>
					                            </select>
                                                 </div>
											     </div>
										
										         <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>No Of Gears : </label>
                                                 <input type="text" name="no_of_gears" class="form-control boxed" placeholder="Enter No Of Gears" required>
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
					                            <option style="display: none;">Select </option>
					                            <option value="Drum">Drum</option>
					                            <option value="Disk">Disk</option></select>
                                                 </div>
											     </div>
											     
												  <div class="col-md-12">
												  <h4>Performance And Fuel Econams</h4>
												  </div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Milleage : </label>
                                                 <input type="text" name="milleage" class="form-control boxed" placeholder="Enter Milleage " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Top Speed (Km/n) : </label>
                                                 <input type="text" name="top_speed" class="form-control boxed" placeholder="Enter Top Speed (Km/n) " required>
                                                 </div>
											     </div>
											     
											      <div class="col-md-12">
												  <h4>Chassis And Suspension</h4>
												  </div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Chassis Type : </label>
                                                 <input type="text" name="chassis_type" class="form-control boxed" placeholder="Enter Chassis Type " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Suspension Front : </label>
                                                 <input type="text" name="suspension_front" class="form-control boxed" placeholder="Enter Suspension Front " required>
                                                 </div>
											     </div>
											     
											      <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Suspension Rear : </label>
                                                 <input type="text" name="suspension_rear" class="form-control boxed" placeholder="Enter Suspension Rear " required>
                                                 </div>
											     </div>
											     
											     
											      <div class="col-md-12">
												  <h4>Tyre And Wheels</h4>
												  </div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Tyre Type : </label>
                                                 <input type="text" name="tyre_type" class="form-control boxed" placeholder="Enter Tyre Type " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Tyre Size (Front) : </label>
                                                 <input type="text" name="tyre_size_front" class="form-control boxed" placeholder="Enter Tyre Size (Front) " required>
                                                 </div>
											     </div>
											     
											      <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Tyre Size (Rear) : </label>
                                                 <input type="text" name="tyre_size_rear" class="form-control boxed" placeholder="Enter Tyre Size (Rear)" required>
                                                 </div>
											     </div>
											 
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Wheel Size : </label>
                                                 <input type="text" name="wheel_size" class="form-control boxed" placeholder="Enter Wheel Size" required>
                                                 </div>
											     </div>
											     
											        <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Wheel Type : </label>
                                                 <input type="text" name="wheel_type" class="form-control boxed" placeholder="Enter Wheel Type" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-12">
												  <h4>Dimensions</h4>
												  </div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Length : </label>
                                                 <input type="text" name="length" class="form-control boxed" placeholder="Enter Length " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Width : </label>
                                                 <input type="text" name="width" class="form-control boxed" placeholder="Enter Width " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Height : </label>
                                                 <input type="text" name="height" class="form-control boxed" placeholder="Enter Hight " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Wheel Base : </label>
                                                 <input type="text" name="wheel_base" class="form-control boxed" placeholder="Enter Wheel base " required>
                                                 </div>
											     </div>
											     
											       <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Ground Clearance : </label>
                                                 <input type="text" name="ground_clearance" class="form-control boxed" placeholder="Enter Ground Clearance " required>
                                                 </div>
											     </div>
											     
											       <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Fuel Capacity : </label>
                                                 <input type="text" name="fuel_capacity" class="form-control boxed" placeholder="Enter Fuel Capacity " required>
                                                 </div>
											     </div>
											     
											       <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Kerb Weight : </label>
                                                 <input type="text" name="kerb_weight" class="form-control boxed" placeholder="Enter Kerb Weight" required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-12">
												  <h4>Electricals</h4>
												  </div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Battery : </label>
                                                 <input type="text" name="battery" class="form-control boxed" placeholder="Enter Battery " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Head Lamp : </label>
                                                 <input type="text" name="head_lamp" class="form-control boxed" placeholder="Enter Head Lamp " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-12">
												  <h4>Warranty</h4>
												  </div>
											
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Standard Warranty (years) : </label>
                                                 <input type="text" name="standard_warranty_years" class="form-control boxed" placeholder="Enter Standard Warranty " required>
                                                 </div>
											     </div>
											     
											     <div class="col-md-4">
											     <div class="form-group"> 	 
                                                 <label for="firstname"><span class="req"></span>Standard Warranty (Kms) : </label>
                                                 <input type="text" name="standard_warranty_kms" class="form-control boxed" placeholder="Standard Warranty (Kms) : " required>
                                                 </div>
											     </div>
											     
											   <div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Photo : </label>
                                              <input type="file" class="form-control boxed" name="photo" accept="image/*" placeholder="Select Image" >
                                                </div>
											  </div>
												
											<div class="col-md-12">
											   <div class="col-md-4"></div>
											   <div class="col-md-2" style=" padding: 0 0;"><button type="submit" class="btn btn-primary  btn-block" id="b1">ADD BIKE</button></div>
											   <div class="col-md-1"></div>
											   <div class="col-md-2" style=" padding: 0 0;"><button type="reset" class="btn btn-danger  btn-block" id="b1">RESET</button></div>
											   <div class="col-md-5"></div>
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
				
			</div>
		</div>
	</center>
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
<!-- productionYear start-->	
 <script>
 var start = 2017;
var end = new Date().getFullYear();
var options = "";
for(var year = start ; year <=end; year++){
  options += "<option value="+year+">"+ year +"</option>";
}
document.getElementById("productionYear").innerHTML = options;
</script>
<!-- productionYear end-->
	<pre>
 	</pre>
	<footer>Copyright &copy; vehicletracking.com</footer>
</body>
</html>