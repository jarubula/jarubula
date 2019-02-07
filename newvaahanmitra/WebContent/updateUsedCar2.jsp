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
<jsp:include page="./individualOwner.jsp" />
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
<script type="text/javascript">
function ValidateSize(file) {
    var FileSize = file.files[0].size / 1024 / 1024; // in MB
    if (FileSize > 1) {
        alert('File size exceeds 1 MB');
       // $(file).val(''); //for clearing with Jquery
    } else {

    }
}
</script>

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
	if(document.myform.ownerName.value=="")
	{
		alert("Please enter OwnerName Name");
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
	/* if(document.myform.country2.value=="-1")
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
	} */
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

			<header class=""> <!-- <div class="header-block header-block-collapse hidden-lg-up">
					<button class="collapse-btn" id="sidebar-collapse-btn">
						<i class="fa fa-bars"></i>
					</button>
				</div> -->

			<div class="header-block header-block-nav">
			</div>
			</header>
			<br>

			<article class="content responsive-tables-page"
				style="background-color:#fff">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div align="center" style="font-size: 25px">INDIVIDUAL OWNER
					DASHBOARD</div>
			</div>
			<section class="section">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive">
								<form action="./updateUsedCarController" name="myform"
									 method="post">
									<%
										String message = (String) request.getAttribute("success");
										if (message != null) {
									%>
									<h6 style="color: red"><%=message%>
									</h6>
									<%
										} else {
										}
									%>

									<div class="col-md-12 text-center"
										style="background: #523f6d; color: #fff;" align="center">
										<h5>UPDATE CAR</h5>
										<%
												UsedCar car = null;
												String carId = request.getParameter("id");
												String carId1 = (String) request.getAttribute("carId");
												String carNo = (String) request.getAttribute("carNumber");
												GetUsedCarDetails dao = new GetUsedCarDetails();
												if (carId == null) {
													car = dao.getUsedCarDetails(carId1);
												} else {
													car = dao.getUsedCarDetails(carId);
												}
											%>

									</div>
									<br> <br>
									<input type="hidden" name="carUpdate" value="IO">
									<div class="row">
										<div class="col-md-3">Car Registration Number</div>
										<div class="col-md-3">
											<div class="form-group">
												<input class="form-control" type="text"
													value="<%=car.getCAR_NUMBER()%>" readonly name="carNo"
													placeholder="Enter Number" maxlength="10">
														<%
															if (message == null) {
														%>
														<input type="hidden" name="carId" value="<%=carId%>">
														<%
															} else {
														%>
														<input type="hidden" name="carId" value="<%=carId1%>">
														<%
															}
														%>
											</div>

										</div>
										<div class="col-md-6"></div>
									</div>
									<div class="row">
										<div class="col-md-3">
											Car Brand <span> <%-- </span><jsp:include page="./getNewCarBrand.jsp" /></span> --%>
										</div>
										<div class="col-md-3">
											<jsp:include page="./getNewCarBrand.jsp" />
										</div>
										<div class="col-md-3">Car Model</div>
										<div class="col-md-3">
											<div id="txtHint1">
												<select class="form-control" name="carModel" required>
													<option value="<%=car.getCAR_MODEL()%>"><%=car.getCAR_MODEL()%></option>
													<!-- 															<option value="">SELECT MODEL</option> -->
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-12">
										<br>
									</div>
									<div class="row">
										<div class="col-md-3">
											Current Mileage <span> <%-- </span><jsp:include page="./getNewCarBrand.jsp" /></span> --%>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<input class="form-control" type="text"
													name="currentMileage"
													value="<%=car.getCURRENT_MILEAGE()%>"
													onkeyup="NumAndTwoDecimals(event , this);"
													placeholder="Enter Current Mileage">
											</div>
										</div>
										<div class="col-md-3">Fuel Type</div>
										<div class="col-md-3">
											<select class="form-control" name="fuelType">
												<option value="<%=car.getFUEL_TYPE()%>"><%=car.getFUEL_TYPE()%></option>
												<option value="PETROL">PETROL</option>
												<option value="DIESEL">DIESEL</option>
												<option value="CNG">CNG</option>
												<option value="LPG">LPG</option>
												<option value="ELECTIC">ELECTIC</option>
											</select>
										</div>


									</div>
									<div class="row">

										<div class="col-md-3">Transmission</div>
										<div class="col-md-3">
											<div class="form-group">
												<select class="form-control"
													 name="transmission">
													<option value="<%=car.getTRANSIMISSION()%>"><%=car.getTRANSIMISSION()%></option>
													<option value="AUTOMATIC">AUTOMATIC</option>
													<option value="MANUAL">MANUAL</option>
												</select>
											</div>
										</div>
										<div class="col-md-3">KM Driven</div>
										<div class="col-md-3">
											<div class="form-group">
												<input class="form-control" type="text" name="KMsDriven"
													onkeyup="NumAndTwoDecimals(event , this);"
													value="<%=car.getKMS_DRIVEN()%>" placeholder="Enter KMs">
											</div>
										</div>

									</div>
									<div class="row">

										<div class="col-md-3">Color</div>
										<div class="col-md-3">
											<div class="form-group">
												<select class="form-control" name="color">
													<option value="<%=car.getCOLOR()%>"><%=car.getCOLOR()%></option>
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
										<div class="col-md-3">Insurance Company Name</div>
										<div class="col-md-3">
											<div class="form-group">
												<input class="form-control" type="text" name="companyName"
													class="form-control boxed" value="<%=car.getINSURANCE()%>"
													placeholder="EnterInsuranceCompanyName">
											</div>
										</div>

									</div>
									
									<div class="row">
									<div class="col-md-3">Model Year</div>
										<div class="col-md-3">
											<div class="form-group">
												<select id="year1" class="form-control" name="year1">
													<option>SELECT YEAR</option>
												</select>
												<!-- <input type="text" name="KMsDriven" required maxlength="10"
													onkeyup="NumAndTwoDecimals(event , this);"
													class="form-control" placeholder="Enter Year"> -->
											</div>
										</div>

										<div class="col-md-3">Registered Year</div>
										<div class="col-md-3">
											<div class="form-group">
												<select id="year" name="year" class="form-control" <%=car.getREGISTERED_YEAR() %>>
												</select>
											</div>
										</div>
									</div>

									<div class="row">
									<div class="col-md-3">Registered State</div>
										<div class="col-md-3">
											<div class="form-group">
												<input class="form-control" type="hidden" name="country"
													id="countryId" value="IN" />
													 <select  name="tstate" class="states order-alpha form-control" id="stateId">
													<option value="<%=car.getREGISTERED_STATE()%>"><%=car.getREGISTERED_STATE()%></option>
												</select>
											</div>
										</div>
										<div class="col-md-3">Registered City</div>
										<div class="col-md-3">
											<div class="form-group">
												<select name="tcity"
													class="cities order-alpha form-control" id="cityId">
													<option value="<%=car.getREGISTERED_CITY()%>"><%=car.getREGISTERED_CITY()%></option>
												</select>
											</div>
										</div>
										
									</div>
									<div class="row">
									<div class="col-md-3">Body Type</div>
										<div class="col-md-3">
											<select class="form-control" name="bodyType">
												<option value="<%=car.getBODY_TYPE()%>"><%=car.getBODY_TYPE()%></option>
												<option value="HATCHBACK">HATCHBACK </option>
												<option value="COUPE">COUPE</option>
												<option value="SUV/MUV">SUV/MUV</option>
												<option value="STATION WAGON">STATION WAGON</option>
												<option value="SEDAN">SEDAN</option>
												<option value="CONVERTIBLE">CONVERTIBLE</option>
											</select>
										</div>
									
									</div>
									<br>
									<div class="row " align="center" style="background: #523f6d;">
										<div class="col-md-12 col-sm-12 col-xs-12"
											style="font-weight: 700; background-color: #E4ECF2; font-size: 700; color: #000; text-align: center;">
											CONTACT ADDRESS</div>
									</div>
									<br>
									<div class="row">
										<div class="col-md-3">Car Owner Name</div>
										<div class="col-md-3">
											<div class="form-group">
												<input class="form-control" type="text" name="ownerName" id="ownerName"
															value="<%=car.getCAR_OWNER_NAME()%>" placeholder="Enter Owner Name">
											</div>
										</div>
										<div class="col-md-3">Used By</div>
										<div class="col-md-3">
											<div class="form-group">
												<input class="form-control" type="text" name="usedBy" id="usedBy"
															value="<%=(car.getUSED_BY() == null || car.getUSED_BY().equals(" ")) ? " " :car.getUSED_BY() %>"
															onkeypress="return checkSpcialChar(event)"
													placeholder="Enter Used By">
											</div>
										</div>
									</div>

									<div class="row">

										<div class="col-md-3">No of Owners</div>
										<div class="col-md-3">
											<div class="form-group">
												<input class="form-control" type="text" name="noOfOwners"
															value="<%=car.getNO_OF_OWNERS() == 0? " ":car.getNO_OF_OWNERS()%>"
															id="noOfOwners"
															onkeyup="NumAndTwoDecimals(event , this);"
															placeholder="Enter No of Owners">
											</div>
										</div>
										<div class="col-md-6"></div>
									</div>
									<div class="row">

										<div class="col-md-3">Email Id</div>
										<div class="col-md-3">
											<div class="form-group">
												<input class="form-control" type="text" name="emailId"
													id="emailId" readonly value="<%=car.getEMAIL_ID()%>"
													placeholder="Enter Email ID">
											</div>
										</div>
										<div class="col-md-3">Mobile No</div>
										<div class="col-md-3">
											<div class="form-group">
												<input class="form-control" type="text" name="mobileNo"
													id="mobileNo" placeholder="Enter MobileNo." maxlength="10"
													value="<%=car.getMOBILE_NO()%>" pattern="[1-9]{1}[0-9]{9}" autocomplete="off">
											</div>
										</div>
									</div>
									<div class="row">

										<div class="col-md-3">Address</div>
										<div class="col-md-3">
											<div class="form-group">
												<input class="form-control" type="text" name="address"
													id="address" value="<%=car.getADDRESS()%>"
													placeholder="Enter Address">
											</div>
										</div>
										<div class="col-md-3">City</div>
										<div class="col-md-3">
											<div class="form-group">
												<input class="form-control" type="text" name="city"
													id="city" placeholder="Enter City"
													value="<%=car.getCITY() == null ? "Enter City" : car.getCITY()%>">
											</div>
										</div>
									</div>
									<div class="row">

										<div class="col-md-3">State</div>
										<div class="col-md-3">
										
											<div class="form-group">
												<select class="form-control" id="country2" name="country2" required
													class="form-control form-control-sm">
													<option value="<%=car.getSTATE()%>"><%=car.getSTATE()%></option>
												</select>
											</div>
										</div>
										<div class="col-md-3">District</div>
										<div class="col-md-3">
											<div class="form-group">
												<select class="form-control" id="state" name="state" required
													class="form-control form-control-sm">
													<option value="<%=car.getDISTRICT()%>"><%=car.getDISTRICT()%></option>
												</select>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-3">Pincode</div>
										<div class="col-md-3">
											<div class="form-group">
												<input class="form-control" type="text" name="pincode"
													id="pincode"
													value="<%=car.getPINCODE() == null ? "" : car.getPINCODE()%>"
													maxlength="6" placeholder="Enter Pincode"
													onkeyup="NumAndTwoDecimals(event , this);">
											</div>

										</div>

									</div>

									<div class="row " align="center" style="background: #523f6d;">
										<div class="col-md-12 col-sm-12 col-xs-12"
											style="font-weight: 700; background-color: #E4ECF2; font-size: 700; color: #000; text-align: center;">
											PRICE</div>

									</div>
									<br>
									<div class="row">
										<div class="col-md-3">Offer Price</div>
										<div class="col-md-3">
											<div class="form-group">
												<input class="form-control" type="text" name="price"
													style="width: 250px" id="price" placeholder="Enter Price "
													value="<%=car.getOFFER_PRICE()%>"
													onkeyup="NumAndTwoDecimals(event , this);">
											</div>
										</div>
									</div><br>
									<div class="row" align="center">
										<div class="col-md-12">
											<button TYPE="submit" onclick="return(svalidate())"
												style="background-color: #a3b745; border: 1px solid #a3b745;border-radius:10px;"
												class="btn btn-primary">UPDATE CAR</button>
										</div>
									</div>
									<br>
								</form>
							</div>
							</section>
						</div>
					</div>
				</div>
			</div>
			</section></article>
		</div>
	</div>
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
	<script>
	var brand="<%=car.getCAR_BRAND()%>";
	$("select[name=brandid] option:first").val(brand);
	$("select[name=brandid] option:first").text(brand);

	var country2="<%=car.getSTATE()%>";
	$("select[name=country2] option:first").val(country2);
	$("select[name=country2] option:first").text(country2);

	var tstate="<%=car.getREGISTERED_STATE()%>";
	$("select[name=tstate] option:first").val(tstate);
	$("select[name=tstate] option:first").text(tstate);
	
	var year="<%=car.getREGISTERED_YEAR()%>";
	$("select[name=year] option:first").val(year);
	$("select[name=year] option:first").text(year);
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
<script>
	var start = 1970;
var end = new Date().getFullYear();
var options = "";
for(var year = start ; year <=end; year++){
  options += "<option>"+ year +"</option>";
}
document.getElementById("year").innerHTML = options;
</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>
</html>
