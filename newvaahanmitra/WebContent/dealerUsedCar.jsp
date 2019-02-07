<%@page import="com.vaahanmitra.model.Registration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<jsp:include page="./carsandBikes.jsp" />
<jsp:include page="./topMenu.jsp" />

<script src="./css/countries.js" type="text/javascript"></script>

<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//geodata.solutions/includes/statecity.js"></script>

<style type="text/css">
.box {
	padding: 20px;
	margin-top: 20px;
}

.red {
	
}

.green {
	
}

label {
	margin-right: 15px;
}
</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $('input[type="radio"]').click(function(){
        var inputValue = $(this).attr("value");
        var targetBox = $("." + inputValue);
        $(".box").not(targetBox).hide();
        $(targetBox).show();
    });
});
</script>
<script>
function NumAndTwoDecimals(event , obj){
	reg = /[^0-9.,]/g;
	obj.value =  obj.value.replace(reg,"");
 }
</script>
<script type="text/javascript">
         function checkSpcialChar(event){
            if(!((event.keyCode >= 65) && (event.keyCode <= 90) || (event.keyCode >= 97) && (event.keyCode <= 122) || (event.keyCode >= 48) && (event.keyCode <= 57))){
               event.returnValue = false;
               return;
            }
            event.returnValue = true;
         }
 </script>
<!-- <script type="text/javascript">
function ValidateSize(file) {
    var FileSize = file.files[0].size / 1024 / 1024; // in MB
    if (FileSize > 1) {
        alert('File size exceeds 1 MB');
       // $(file).val(''); //for clearing with Jquery
    } else {

    }
}
</script> -->

<script language="javascript">
	function validate() {
		/* if(document.getElementById("mobileNo").value.length !=10 )
		 {
		  alert("Please enter 10 digits Mobile No");
		  document.getElementById("mobileNo").focus();
		  return false;
		 } */
		if(document.getElementById("purchasedYear").value.length !=4 )
		 {
		  alert("Please enter 4 digits YEAR");
		  document.getElementById("purchasedYear").focus();
		  return false;
		 }
		return true;
 	}
	function yesnoCheck() {
	    if (document.getElementById('yesCheck').checked) {
	        document.getElementById('ifYes').style.display = 'block';
	    }
	    else document.getElementById('ifYes').style.display = 'none';
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
<script>
function svalidate()
{
	var fileUpload = document.getElementById("fileUpload");
	 
    //Check whether the file is valid Image.
    var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(.jpg|.png|.gif)$");
    if (regex.test(fileUpload.value.toLowerCase())) {
 
        //Check whether HTML5 is supported.
        if (typeof (fileUpload.files) != "undefined") {
            //Initiate the FileReader object.
            var reader = new FileReader();
            //Read the contents of Image File.
            reader.readAsDataURL(fileUpload.files[0]);
            reader.onload = function (e) {
                //Initiate the JavaScript Image object.
                var image = new Image();
 
                //Set the Base64 string return from FileReader as source.
                image.src = e.target.result;
                       
                //Validate the File Height and Width.
                image.onload = function () {
                    var height = this.height;
                    var width = this.width;
                    if (width > 500 || height > 350) {
                        alert("Upload image with Height 350px and Width must not exceed 500px.");
                        return false;
                    }
//	                    alert("Uploaded image has valid Height and Width.");
                    return true;
                };
 
            }
        } else {
            alert("This browser does not support HTML5.");
            return false;
        }
    } else {
        alert("Please select a valid Image file.");
        return false;
    }
	
	if(document.myform.ownerName.value=="")
	{
		alert("Please enter OwnerName");
		document.getElementById("ownerName").focus();
		return false;
	}
	/* if(document.myform.usedBy.value=="")
	{
		alert("Please enter UsedBy");
		document.getElementById("usedBy").focus();
		return false;
	}
	if(document.myform.noOfOwners.value=="")
	{
		alert("Please enter NoOfOwners");
		document.getElementById("noOfOwners").focus();
		return false;
	} */
	if(document.myform.emailId.value=="")
	{
		alert("Please enter EmailId");
		document.getElementById("emailId").focus();
		return false;
	}
	if(document.myform.mobileNo.value.length!=10)
	{
		alert("Please enter 10 digits in MobileNo");
		document.getElementById("mobileNo").focus();
		return false;
	}
	if(document.myform.address.value=="")
	{
		alert("Please enter Address");
		document.getElementById("address").focus();
		return false;
	}
	if(document.myform.city.value=="" || document.myform.city.value== "null")
	{
		alert("Please enter City");
		document.getElementById("city").focus();
		return false;
	}
	 if(document.myform.country2.value=="-1")
	{
		alert("Please Select State");
		document.getElementById("country2").focus();
		return false;
	}
	if(document.myform.state.value=="")
	{
		alert("Please Select District");
		document.getElementById("state").focus();
		return false;
	} 
	if(document.myform.pincode.value=="" || document.myform.pincode.value== "null" || document.myform.pincode.value.length!=6)
	{
		alert("Please enter 6 digits in Pincode");
		document.getElementById("pincode").focus();
		return false;
	}
	if(document.myform.price.value=="")
	{
		alert("Please enter Price");
		document.getElementById("price").focus();
		return false;
	}
	if(document.myform.purchasedYear.value.length !=4 )
	 {
	  alert("Please enter 4 digits YEAR");
	  document.getElementById("purchasedYear").focus();
	  return false;
	 }
	var emailfilter=/^\w+[\+\.\w-]*@([\w-]+\.)*\w+[\w-]*\.([a-z]{2,4}|\d+)$/i
		var b=emailfilter.test(document.myform.emailId.value);
		if(b==false)
		{
		alert("Please Enter a valid Mail ID");
		document.myform.emailId.focus();
		return false;
		}
}
</script>
<script>
function svalidate1()
{
	
	var fileUpload = document.getElementById("fileUpload1");
	 
    //Check whether the file is valid Image.
    var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(.jpg|.png|.gif)$");
    if (regex.test(fileUpload.value.toLowerCase())) {
 
        //Check whether HTML5 is supported.
        if (typeof (fileUpload.files) != "undefined") {
            //Initiate the FileReader object.
            var reader = new FileReader();
            //Read the contents of Image File.
            reader.readAsDataURL(fileUpload.files[0]);
            reader.onload = function (e) {
                //Initiate the JavaScript Image object.
                var image = new Image();
 
                //Set the Base64 string return from FileReader as source.
                image.src = e.target.result;
                       
                //Validate the File Height and Width.
                image.onload = function () {
                    var height = this.height;
                    var width = this.width;
                    if (width > 500 || height > 350) {
                        alert("Upload image with Height 350px and Width must not exceed 500px.");
                        return false;
                    }
//	                    alert("Uploaded image has valid Height and Width.");
                    return true;
                };
 
            }
        } else {
            alert("This browser does not support HTML5.");
            return false;
        }
    } else {
        alert("Please select a valid Image file.");
        return false;
    }
	
	if(document.myform.ownerName1.value=="")
	{
		alert("Please enter OwnerName");
		document.getElementById("ownerName1").focus();
		return false;
	}
	/* if(document.myform.usedBy1.value=="")
	{
		alert("Please enter UsedBy");
		document.getElementById("usedBy1").focus();
		return false;
	}
	if(document.myform.noOfOwners1.value=="")
	{
		alert("Please enter NoOfOwners");
		document.getElementById("noOfOwners1").focus();
		return false;
	} */
	if(document.myform.emailId1.value=="")
	{
		alert("Please enter EmailId");
		document.getElementById("emailId1").focus();
		return false;
	}
	if(document.myform.mobileNo1.value.length!=10)
	{
		alert("Please enter 10 digits in MobileNo");
		document.getElementById("mobileNo1").focus();
		return false;
	}
	if(document.myform.address1.value=="")
	{
		alert("Please enter Address");
		document.getElementById("address1").focus();
		return false;
	}
	if(document.myform.city1.value=="")
	{
		alert("Please enter City");
		document.getElementById("city1").focus();
		return false;
	}
	if(document.myform.country1.value=="-1")
	{
		alert("Please Select State");
		document.getElementById("country1").focus();
		return false;
	}
	if(document.myform.state1.value=="")
	{
		alert("Please Select District");
		document.getElementById("state1").focus();
		return false;
	}
	if(document.myform.pincode1.value=="" || document.myform.pincode1.value.length!=6 )
	{
		alert("Please enter 6 digits in Pincode");
		document.getElementById("pincode1").focus();
		return false;
	}
	if(document.myform.price1.value=="")
	{
		alert("Please enter Price");
		document.getElementById("price1").focus();
		return false;
	}
	var emailfilter=/^\w+[\+\.\w-]*@([\w-]+\.)*\w+[\w-]*\.([a-z]{2,4}|\d+)$/i
		var b=emailfilter.test(document.myform.emailId1.value);
		if(b==false)
		{
		alert("Please Enter a valid Mail ID");
		document.myform.emailId1.focus();
		return false;
		}
}
</script>
<script language="Javascript" type="text/javascript">
	var counter = 1;
 	var limit = 12;
	function addInput(divName){
	     if (counter == limit)  {
	          alert("You have reached the limit of adding " + counter + " inputs");
     }
	     else {
	          var newdiv = document.createElement('div');
 	          newdiv.innerHTML = "Entry " + (counter + 1) + " <br><input type='file' name='photo"+counter+"' accept='image/*' placeholder='Select Image'>";
	          document.getElementById(divName).appendChild(newdiv);
 	          document.getElementById("counter").value=counter;
 	          counter++;
     }
	}
</script>
<script type="text/javascript">
    function ShowHideDiv() {
        var chkYes = document.getElementById("chkYes");
        var dvPassport = document.getElementById("dvPassport");
        dvPassport.style.display = chkYes.checked ? "block" : "none";
    }
</script>

<script>
	function showModel(str) {
		if (str == "") {
			document.getElementById("txtHint1").innerHTML = "";
			return;
		}
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("txtHint1").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./getNewCarModel.jsp?brand=" + str, true);
		xmlhttp.send();
	}
</script>

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
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">

			<header class="">
			
			<!-- <div class="header-block header-block-collapse hidden-lg-up">
					<button class="collapse-btn" id="sidebar-collapse-btn">
						<i class="fa fa-bars"></i>
					</button>
				</div> -->

			<div class="header-block header-block-nav">
				<!-- 					<ul class="nav-profile"> -->

				<!-- 						<li class="profile dropdown"><a -->
				<!-- 							class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" -->
				<!-- 							role="button" aria-haspopup="true" aria-expanded="false"> -->
				<!-- 								<div class="img" style=""></div> <span class="name"> -->
				<!-- 									Mohan Amasa</span> -->
				<!-- 						</a> -->
				<!-- 							<div class="dropdown-menu profile-dropdown-menu" -->
				<!-- 								aria-labelledby="dropdownMenu1"> -->

				<!-- 								<a class="dropdown-item" href="#"> <i -->
				<!-- 									class="fa fa-power-off icon"></i> Logout -->
				<!-- 								</a> -->
				<!-- 							</div></li> -->
				<!-- 					</ul> -->
			</div>
			</header>
			<br>

			<article class="content responsive-tables-page"
				style="background-color:#fff">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div align="center" style="font-size: 25px">USED VEHICLE DEALER DASHBOARD</div>
			</div>
			<section class="section">

			<div class="row">

				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive">
								<form action="./AddDealerUsedCar" name="myform"
									enctype="multipart/form-data" method="post"
									onsubmit="return validateform()">
									<%
					String message = (String) request.getAttribute("success");
				%>
									<%
										if (message != null) {
									%>
									<h4 style="color: red"><%=message%>
									</h4>
									<%
										} else {
										}
									%>
									<div class="row table-hover">
										<div class="container-fluid">
											<div class="col-md-12"
												style="text-align: center; background-color: #523f6d; color: #fff;">
												USED CAR</div>
										</div>
										<br>
										<br>
										<%
											String emailId = (String) session.getAttribute("user");
											BusinessOwnerService ios = new BusinessOwnerService();
											BusinessOwnerRegister ior = ios.getProfileDetails(emailId);
										%>
										
										<input type="hidden" name="counter" value="0" id="counter">
										<div class="col-md-12"></div>
										<div class="col-md-2">Car Registration Number<span style="color:red">*</span></div>
										<div class="col-md-4">
											<input type="text" class="form-control form-control-sm"
												onkeypress="return checkSpcialChar(event)" required
												name="carNumber" placeholder="Enter Number" maxlength="10">
										</div>
										<div class="col-md-6"></div>
										<div class="col-md-12 col-xs-12 col-sm-12">
											<br>
										</div>

										<div class="col-md-2">Car Brand<span style="color:red">*</span></div>
										<div class="col-md-4">
											<jsp:include page="./getNewCarBrand.jsp" />
										</div>
										<div class="col-md-2">Car Model<span style="color:red">*</span></div>
										<div class="col-md-4">
											<div id="txtHint1">
												<select name="carModel" class="form-control form-control-sm" required>
													<option value="">SELECT MODEL</option>
												</select>
											</div>
										</div>
										<div class="col-md-12 col-xs-12 col-sm-12">
											<br>
										</div>
										
										<div class="col-md-2">Model Year<span style="color:red">*</span></div>
										<div class="col-md-4">
											<div class="form-group">
												<select id="year1" class="form-control form-control-sm" name="year1" required>
													<option>SELECT YEAR</option>
												</select>
												<!-- <input type="text" name="KMsDriven" required maxlength="10"
													onkeyup="NumAndTwoDecimals(event , this);"
													class="form-control" placeholder="Enter Year"> -->
											</div>
										</div>
										
										<div class="col-md-2">Current Mileage</div>
										<div class="col-md-4">
											<div class="form-group">
												<input type="text" name="currentMileage" maxlength="2"
													class="form-control form-control-sm" 
													onkeyup="NumAndTwoDecimals(event , this);"
													placeholder="Enter Current Mileage">
											</div>
										</div>
										<div class="col-md-2">Fuel Type<span style="color:red">*</span></div>
										<div class="col-md-4">
											<select class="form-control form-control-sm" name="fuelType" required>
												<option value="">Select Fuel Type</option>
												<option value="PETROL">PETROL</option>
												<option value="DIESEL">DIESEL</option>
												<option value="CNG">CNG</option>
												<option value="LPG">LPG</option>
												<option value="ELECTIC">ELECTIC</option>
											</select>
										</div>
										<div class="col-md-2">Body Type</div>
										<div class="col-md-4">
											<select class="form-control form-control-sm" name="bodyType">
												<option value="">Select Body Type</option>
												<option value="HATCHBACK">HATCHBACK </option>
												<option value="COUPE">COUPE</option>
												<option value="SUV/MUV">SUV/MUV</option>
												<option value="STATION WAGON">STATION WAGON</option>
												<option value="SEDAN">SEDAN</option>
												<option value="CONVERTIBLE">CONVERTIBLE</option>
											</select>
										</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
										</div>
										<div class="col-md-2">Transmission</div>
										<div class="col-md-4">
											<select class="form-control form-control-sm" name="transmission">
												<option value="">Select Transmission</option>
												<option value="AUTOMATIC">AUTOMATIC</option>
												<option value="MANUAL">MANUAL</option>
											</select>

										</div>
										<div class="col-md-2">KM Driven</div>
										<div class="col-md-4">
											<div class="form-group">
												<input type="text" name="KMsDriven" maxlength="10"
													onkeyup="NumAndTwoDecimals(event , this);"
													class="form-control form-control-sm" placeholder="Enter KMs">
											</div>
										</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
										</div>

										<div class="col-md-2">Color</div>
										<div class="col-md-4">
											<div class="form-group">
												<select class="form-control form-control-sm" name="color">
													<option value="">Select Color</option>
													<option value="WHITE">WHITE</option>
													<option value="BLACK">BLACK</option>
													<option value="SILVER">SILVER</option>
													<option value="RED">RED</option>
													<option value="BLUE">BLUE</option>
													<option value="GREY">GREY</option>
													<option value="BEIGE">BEIGE</option>
													<option value="BROWN">BROWN</option>
													<option value="GOLD/YELLOW">GOLD/YELLOW</option>
													<option value="GREEN">GREEN</option>
													<option value="PURPLE">PURPLE</option>
													<option value="MAROON">MAROON</option>
													<option value="ORANGE">ORANGE</option>
													<option value="VIOLET">VIOLET</option>
											</select>
											</div>

										</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
										</div>
										<div class="col-md-2">
											Insurance Company Name
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<input type="text" name="companyName" class="form-control form-control-sm"
													placeholder="Enter Insurance Company Name">
											</div>
										</div>
										<div class="col-md-2">Certified Company Name</div>
										<div class="col-md-4">
											<div class="form-group">
												<input type="text" name="cetifiedCompanyName"
													class="form-control form-control-sm"
													placeholder="Enter Certified Company Name">
											</div>
										</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
										</div>
										<div class="col-md-2">Registered Year</div>
										<div class="col-md-4">
											<div class="form-group">
											<select id="year" class="form-control form-control-sm" name="year"></select>
											</div>
										</div>
										<div class="col-md-2">Registered State</div>
										<div class="col-md-4">
											<div class="form-group">
												<input type="hidden" name="country" id="countryId"
													value="IN"/> <select name="tstate"
													class="states order-alpha form-control form-control-sm" id="stateId">
													<option value="">Select State</option>
												</select>
											</div>
										</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
										</div>

										<div class="col-md-2">Registered City</div>
										<div class="col-md-4">
											<div class="form-group">
												<select name="tcity" class="cities order-alpha form-control form-control-sm"
													id="cityId">
													<option value="">Select City</option>
												</select>
											</div>
										</div>
										<!-- <div class="col-md-2">Photo<span style="color:red">*</span></div>
										<div class="col-md-4">
											<div class="form-group" id="dynamicInput">
												<input type="file" name="photo" accept="image/*"  placeholder="Select Image"
													required> 
													onchange="ValidateSize(this)"
											</div>
											<input type="button" value="Add another PHOTO"
												onClick="addInput('dynamicInput');">
										</div> -->
										

										<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
										</div>
										<div class="row">
										<div class="col-md-12" align="center"
											style="font-weight: 700; font-size: 700; color: #523f6d; background: #eceeef">
											<em> CONTACT ADDRESS </em>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-md-4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label><input type="radio" value="red"
												name="contactAddress" checked> &nbsp;&nbsp;Contact
												Address Same as Profile</label>

										</div>
										<div class="col-md-3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label><input type="radio" value="green"
												name="contactAddress"> Different </label>
										</div>
									</div>
										<div class="red box">
											<div class="col-md-12 col-sm-12 col-xs-12">
											</div>
											<div class="col-md-2">Car Owner Name<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
													<input type="text" name="ownerName" id="ownerName"
														value="<%=ior.getNAME()%>" class="form-control form-control-sm"
														placeholder="Enter Owner Name">
												</div>
											</div>

											<div class="col-md-2">Used By</div>
											<div class="col-md-4">
												<div class="form-group">
													<input type="text" name="usedBy" id="usedBy"
														class="form-control form-control-sm" placeholder="Enter Used By">
												</div>

											</div>

											<div class="col-md-12 col-sm-12 col-xs-12">
											</div>
											<div class="col-md-2">No of Owners</div>
											<div class="col-md-4">
												<div class="form-group">
													<input type="text" name="noOfOwners" maxlength="2"
														class="form-control form-control-sm" id="noOfOwners"
														onkeyup="NumAndTwoDecimals(event , this);"
														placeholder="Enter No of Owners">
												</div>
											</div>
											<div class="col-md-6"></div>
											<div class="col-md-12 col-sm-12 col-xs-12">
											</div>


											<div class="col-md-2">Email Id<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
													<input type="text" name="emailId" id="emailId" 
														value="<%=ior.getEMAIL_ID()%>" class="form-control form-control-sm" 
														 readonly/>
												</div>
											</div>
											<div class="col-md-2">Mobile No<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
													<input type="text" name="mobileNo" id="mobileNo"
														placeholder="Enter MobileNo." maxlength="10" 
														value="<%=ior.getMOBILE_NO()%>" class="form-control form-control-sm"
														pattern="[1-9]{1}[0-9]{9}" autocomplete="off">
												</div>

											</div>
											<div class="col-md-12 col-sm-12 col-xs-12">
											</div>
											<div class="col-md-2">Address<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
													<input type="text" name="address" id="address" value="<%=ior.getADDRESS()%>"
														placeholder="Enter Address" class="form-control form-control-sm">
												</div>
											</div>
											<div class="col-md-2">City<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
													<input type="text" name="city" class="form-control form-control-sm"
														id="city" placeholder="Enter City"
														value="<%=ior.getCITY() == null ? "" : ior.getCITY()%>">
												</div>

											</div>
											<div class="col-md-2">State<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
													<select id="country2" name="country2"
													class="form-control form-control-sm">
													<option value="">Select State</option>
												</select>
												</div>
											</div>
											<div class="col-md-2">District<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
												<select id="state" name="state"
													class="form-control form-control-sm">
													<option value="<%=ior.getDISTRICT()%>"><%=ior.getDISTRICT()%></option>
												</select>
												</div>

											</div>
											<div class="col-md-2">Pincode<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
													<input type="text" name="pincode" id="pincode"
														value="<%=ior.getPINCODE_NO() == 0 ? "" : ior.getPINCODE_NO()%>"
														maxlength="6" class="form-control form-control-sm"
														placeholder="Enter Pincode"
														onkeyup="NumAndTwoDecimals(event , this);">
												</div>
											</div>
											<div class="col-md-6"></div>
											<div class="col-md-12 col-sm-12 col-xs-12">
											</div>
											<div class="col-md-12 col-sm-12 col-xs-12"
												style="font-weight: 700; background-color: #E4ECF2; font-size: 700; color: #000; text-align: center;">
												PRICE</div>

											<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
											</div>

											<div class="col-md-2">Offer Price<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
													<input class="form-control form-control-sm" type="text" name="price" maxlength="15"
														style="width: 250px" id="price" placeholder="Enter Price "
														onkeyup="NumAndTwoDecimals(event , this);">
												</div>
											</div>
											
											<div class="col-md-2">
											Photo<span style="color:red">*</span>
											</div>
											<div class="col-md-4">
												<input type="file" name="photo1" accept="image/*" id="fileUpload" placeholder="Select Image"> 
												</div>
											<div class="col-md-12 col-sm-12 col-xs-12">
											</div>
											
											<div class="col-md-6"></div>

											<div class="col-md-12 col-sm-12 col-xs-12">
												<br>
											</div>
											<div class="col-md-4"></div>
											<div class="col-md-4">
												<div class="text-center">
													<button TYPE="submit" onclick="return(svalidate())"
														style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
											class="btn btn-primary">ADD CAR</button>												</div>
											</div>
											<div class="col-md-4">
												<div class="text-center">
													<input
														style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
														type="reset" value="RESET" class="btn btn-primary" />
												</div>
											</div>
											<div class="col-md-12 col-sm-12 col-xs-12">
												<br>
											</div>
										</div>
										<div class="green box" style="display: none;">
											<div class="col-md-12 col-sm-12 col-xs-12">
											</div>
											<div class="col-md-2">Car Owner Name<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
													<input type="text" name="ownerName1" id="ownerName1"
														class="form-control form-control-sm"
														onkeypress="return checkSpcialChar(event)"
											placeholder="Enter Owner Name">
												</div>
											</div>

											<div class="col-md-2">Used By</div>
											<div class="col-md-4">
												<div class="form-group">
													<input type="text" name="usedBy1" id="usedBy1"
														onkeypress="return checkSpcialChar(event)"
														class="form-control form-control-sm" placeholder="Enter Used By">
												</div>

											</div>

											<div class="col-md-12 col-sm-12 col-xs-12">
											</div>
											<div class="col-md-2">No of Owners</div>
											<div class="col-md-4">
												<div class="form-group">
													<input type="text" name="noOfOwners1" maxlength="2"
														class="form-control form-control-sm" id="noOfOwners1"
														onkeyup="NumAndTwoDecimals(event , this);"
														placeholder="Enter No of Owners">
												</div>
											</div>
											<div class="col-md-6"></div>
											<div class="col-md-12 col-sm-12 col-xs-12">
											</div>
											<div class="col-md-2">Email Id<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
													<input type="text" name="emailId1" id="emailId1" value="<%=ior.getEMAIL_ID()%>" 
														 readonly class="form-control form-control-sm">
												</div>
											</div>
											<div class="col-md-2">Mobile No<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
													<input type="text" name="mobileNo1" id="mobileNo1"
														placeholder="Enter MobileNo." maxlength="10"
														class="form-control form-control-sm"
														onkeyup="NumAndTwoDecimals(event , this);">
												</div>

											</div>
											<div class="col-md-12 col-sm-12 col-xs-12">
											</div>
											<div class="col-md-2">Address<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
													<input type="text" name="address1" id="address1"
														placeholder="Enter Address" class="form-control form-control-sm">

												</div>
											</div>
											<div class="col-md-2">City<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
													<input type="text" name="city1" class="form-control form-control-sm"
														id="city1" placeholder="Enter City">
												</div>

											</div>
											<div class="col-md-2">State<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
												<select id="country1" name="country1"
													class="form-control form-control-sm">
													<option value="">Select State</option>
												</select>
												</div>
											</div>
											<div class="col-md-2">District<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
													<select id="state1" name="state1"
													class="form-control form-control-sm">
													<option value="">Select District</option>
												</select>
												</div>

											</div>
											<div class="col-md-2">Pincode<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
													<input type="text" name="pincode1" id="pincode1"
														maxlength="6" class="form-control form-control-sm"
														placeholder="Enter Pincode"
														onkeyup="NumAndTwoDecimals(event , this);">
												</div>
											
											</div>
											<div class="col-md-6"></div>
											<div class="col-md-12 col-sm-12 col-xs-12">
											</div>
											<div class="col-md-12 col-sm-12 col-xs-12"
												style="font-weight: 700; background-color: #E4ECF2; font-size: 700; color: #000; text-align: center;">
												PRICE</div>

											<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
											</div>

											<div class="col-md-2">Offer Price<span style="color:red">*</span></div>
											<div class="col-md-4">
												<div class="form-group">
													<input class="form-control form-control-sm" type="text" name="price1" maxlength="15"
														style="width: 250px" id="price1" placeholder="Enter Price "
														onkeyup="NumAndTwoDecimals(event , this);">
												</div>
											</div>
											
											<div class="col-md-2">
											Photo<span style="color:red">*</span>
											</div>
											<div class="col-md-4">
												<input type="file" name="photo1" accept="image/*" id="fileUpload" placeholder="Select Image"> 
												</div>
											<div class="col-md-12 col-sm-12 col-xs-12">
											</div>
										
											<div class="col-md-6"></div>

											<div class="col-md-12 col-sm-12 col-xs-12">
												<br>
											</div>
											<div class="col-md-4"></div>
											<div class="col-md-4">
												<div class="text-center">
													<button TYPE="submit" onclick="return(svalidate1())"
														style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
											class="btn btn-primary">ADD CAR</button>												</div>
											</div> 
											<div class="col-md-4">
												<div class="text-center">
													<input
														style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
														type="reset" value="RESET" class="btn btn-primary" />
												</div>
											</div>
											<div class="col-md-12 col-sm-12 col-xs-12">
												<br>
											</div>
										</div>
									</div>
								</form>
							</div>
							</section>
						</div>
					</div>
				</div>
			</div>
			</section>
		</article>
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
	<!-- Reference block for JS -->
	<div class="ref" id="ref">
		<div class="color-primary"></div>
		<div class="chart">
			<div class="color-primary"></div>
			<div class="color-secondary"></div>
		</div>
	</div>
	<script language="javascript">
			populateCountries("country2", "state");
		</script>
	<script language="javascript">
			populateCountries("country1", "state1");
		</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
	<script>
	var start = 1970;
var end = new Date().getFullYear();
var options = "";
for(var year = start ; year <=end; year++){
  options += "<option>"+ year +"</option>";
}
document.getElementById("year").innerHTML = options;
</script>
<script>
var country2="<%=ior.getSTATE()%>";
	$("select[name=country2] option:first").val(country2);
	$("select[name=country2] option:first").text(country2);
</script>

<script>
	var start = 1970;
var end = new Date().getFullYear();
var options = "";
for(var year = start ; year <=end; year++){
  options += "<option>"+ year +"</option>";
}
document.getElementById("year1").innerHTML = options;
</script>
</body>
</html>