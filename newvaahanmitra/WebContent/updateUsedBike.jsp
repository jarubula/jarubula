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
	if(document.myform.usedBy.value=="")
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
	}
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
	if(document.myform.ownerName1.value=="")
	{
		alert("Please enter OwnerName Name");
		document.getElementById("ownerName1").focus();
		return false;
	}
	if(document.myform.usedBy1.value=="")
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
	}
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
		xmlhttp.open("GET", "./getNewBikeModel.jsp?brand=" + str, true);
		xmlhttp.send();
	}
</script>

<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>AddCar</title>
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
	<%
		String msg = (String) request.getAttribute("message1");
	%>
	<div class="main-wrapper">
		<div class="app" id="app">

			<header class="">



			<div class="header-block header-block-nav"></div>
			</header>
			<br>

			<article class="content responsive-tables-page"
				style="background-color:#fff;border-radius:25px;"> <section
				class="section">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div align="center" style="font-size: 25px">INDIVIDUAL OWNER
					DASHBOARD</div>
			</div>
			<div class="row">

				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive">
								<form action="./updateUsedBikeController" name="myform" method="post"
									onSubmit="return validate()">
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
									<div class="container-fluid">
										<div class="col-md-12"
											style="text-align: center; background-color: #523f6d; color: #fff;">
											UPDATE BIKE</div>
									</div>
									<br>
									<%
										UsedBike bike = null;
										String bikeId = request.getParameter("id");
										String bikeId1 = (String) request.getAttribute("bikeId");
										String bikeNo = (String) request.getAttribute("bikeNumber");
										GetBikeBrands dao = new GetBikeBrands();
										if (bikeId == null) {
											bike = dao.getUsedBikeDetails(bikeId1);
										} else {
											bike = dao.getUsedBikeDetails(bikeId);
										}
									%>
									<input type="hidden" name="counter" value="0" id="counter">
									<div class="row">
										<div class="col-md-3">Bike Registration Number</div>
										<%
											if (message == null) {
										%>
										<input type="hidden" name="bikeId" value="<%=bikeId%>">
										<%
											} else {
										%>
										<input type="hidden" name="bikeId" value="<%=bikeId1%>">
										<%
											}
										%>

										<div class="col-md-3">
											<input type="hidden" name="bikeUpdate" value="IO">
											<input type="text" name="bikeNo" class="form-control "
											value="<%=bike.getBIKE_NUMBER()%>" readonly onkeypress="return checkSpcialChar(event)" required
												placeholder="Enter Number" maxlength="10"></input>
										</div>
										<div class="col-md-6"></div>
									</div>
									<br>
									<div class="row">
										<div class="col-md-3">Bike Brand</div>
										<div class="col-md-3">
											<jsp:include page="./getNewBikeBrand.jsp" />
										</div>
										<div class="col-md-3">Bike Model</div>
										<div class="col-md-3">
											<div id="txtHint1">
												<select name="bikeModel" class="form-control" required>
													<option value="<%=bike.getBIKE_MODEL()%>"><%=bike.getBIKE_MODEL()%></option>
												</select>
											</div>

										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-md-3">Current Mileage</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" name="currentMileage" maxlength="2"
													class="form-control" required
													value="<%=bike.getCURRENT_MILEAGE()%>"
													onkeyup="NumAndTwoDecimals(event , this);"
													placeholder="Enter Current Mileage">
											</div>
										</div>
										<div class="col-md-3">Starting System</div>
										<div class="col-md-3">
											<div class="form-group">
												<%-- <input type="text" class="form-control "
													value="<%=bike.getSTARTING_SYSTEM()%>"
													name="startingSystem" placeholder="Enter Strating System"
													required> --%>
													<select class="form-control" name="startingSystem" required>
														<option value="<%=bike.getSTARTING_SYSTEM()%>"><%=bike.getSTARTING_SYSTEM()%></option>
														<option value="Kick">Kick</option>
														<option value="Kick&Self Start">Kick&Self Start</option>
													</select>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-3">FuelTank Capacity</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" class="form-control " onkeyup="NumAndTwoDecimals(event , this);"
													value="<%=bike.getFUELTANK_CAPACITY()%>"
													name="fueltankCapacity" placeholder="Enter Strating System"
													required>
											</div>

										</div>
										<div class="col-md-3">Color</div>
										<div class="col-md-3">
											<div class="form-group">
												<%-- <input type="text" class="form-control"
													value="<%=bike.getCOLOR()%>"
													onkeypress="return checkSpcialChar(event)" name="color"
													placeholder="Enter Color" required> --%>
												<select class="form-control form-control-sm" required name="color">
													<option value="<%=bike.getCOLOR()%>"><%=bike.getCOLOR()%></option>
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
									</div>
									<div class="row">
										<div class="col-md-3">KM Driven</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" name="kmsDriven" maxlength="10"
													value="<%=bike.getKMS_DRIVEN()%>"
													onkeyup="NumAndTwoDecimals(event , this);"
													class="form-control" placeholder="Enter KMs Driven"
													required>
											</div>
										</div>
										<div class="col-md-3">Registered Year</div>
										<div class="col-md-3">
											<div class="form-group">
												<select id="year" class="form-control" name="year"></select>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-3">Registered State</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="hidden" name="country" id="countryId"
													value="IN" /> <select name="tstate" required
													class="states order-alpha form-control" id="stateId">
													<option value="">Select State</option>
												</select>
											</div>
										</div>
										<div class="col-md-3">Registered City</div>
										<div class="col-md-3">
											<select name="tcity" class="cities order-alpha form-control"
												required id="cityId">
												<option value="<%=bike.getREGISTERED_CITY()%>"><%=bike.getREGISTERED_CITY()%></option>
											</select>
										</div>
									</div><br>
									<div class="row">
										<div class="col-md-12" align="center"
											style="font-weight: 700; font-size: 700; color: #523f6d; background: #eceeef">
											CONTACT ADDRESS</div>
									</div><br>
									<div class="col-md-12 col-sm-12 col-xs-12"></div>
									<div class="row">
										<div class="col-md-3">BIKE Owner Name</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" name="ownerName"
													value="<%=bike.getBIKE_OWNER_NAME()%>" id="ownerName"
													class="form-control"
													onkeypress="return checkSpcialChar(event)"
													placeholder="Enter Owner Name">
											</div>
										</div>
										<div class="col-md-3">Used By</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" name="usedBy" id="usedBy"
													value="<%=bike.getUSED_BY()%>"
													onkeypress="return checkSpcialChar(event)"
													class="form-control" placeholder="Enter Used By">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-3">No of Owners</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" name="noOfOwners" maxlength="2"
													class="form-control" id="noOfOwners"
													value="<%=bike.getNO_OF_OWNERS()%>"
													onkeyup="NumAndTwoDecimals(event , this);"
													placeholder="Enter No of Owners">
											</div>
										</div>
										<div class="col-md-3">Email ID</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" name="emailId" id="emailId"
													readonly="readonly" class="form-control"
													value="<%=bike.getEMAIL_ID()%>"
													placeholder="Enter Email ID">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-3">Mobile No</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" name="mobileNo" id="mobileNo"
													placeholder="Enter MobileNo." maxlength="10"
													value="<%=bike.getMOBILE_NO()%>" class="form-control"
													pattern="[1-9]{1}[0-9]{9}" autocomplete="off">
											</div>
										</div>
										<div class="col-md-3">Address</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" name="address"
													value="<%=bike.getADDRESS()%>" placeholder="Enter Address"
													class="form-control">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-3">City</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" name="city" value="<%=bike.getCITY()%>"
													placeholder="Enter City" class="form-control">
											</div>
										</div>
										<div class="col-md-3">State</div>
										<div class="col-md-3">
											<div class="form-group">
												<select id="country2" name="country2"
													class="form-control">
													<option value="">Select State</option>
												</select>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-3">District</div>
										<div class="col-md-3">
											<div class="form-group">
												<select id="state" name="state"
													class="form-control">
													<option value="<%=bike.getDISTRICT()%>"><%=bike.getDISTRICT()%></option>
												</select>
											</div>
										</div>
										<div class="col-md-3">Pincode</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" name="pincode" id="pincode"
													value="<%=bike.getPINCODE()%>" maxlength="6"
													class="form-control" placeholder="Enter Pincode"
													onkeyup="NumAndTwoDecimals(event , this);">
											</div>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-md-12" align="center"
											style="font-weight: 700; font-size: 700; color: #523f6d; background: #eceeef">
											PRICE</div>
									</div>
									<br>
									<div class="row">
										<div class="col-md-3">Offer Price</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" name="price" maxlength="15" id="price"
													placeholder="Enter Price"
													onkeyup="NumAndTwoDecimals(event , this);"
													class="form-control" value="<%=bike.getOFFER_PRICE()%>">
											</div>
										</div>
									</div>
									<div class="col-md-12 col-sm-12 col-xs-12">
										<br>
									</div>

									<div class="col-md-6"></div>

									<div class="col-md-12 col-sm-12 col-xs-12">
									</div>
									<div class="row" align="center">
										<div class="col-md-12">
											<button TYPE="submit" onclick="return(svalidate())"
												style="background-color: #a3b745; border: 1px solid #a3b745;border-radius:10px;"
												class="btn btn-primary">UPDATE BIKE</button>
										</div>
									</div><br>
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
	<script language="javascript">
			populateCountries("country2", "state");
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
<script>
	var brand="<%=bike.getBIKE_BRAND()%>";
	$("select[name=bikeBrand] option:first").val(brand);
	$("select[name=bikeBrand] option:first").text(brand);

	var country2="<%=bike.getSTATE()%>";
	$("select[name=country2] option:first").val(country2);
	$("select[name=country2] option:first").text(country2);

	var tstate="<%=bike.getREGISTERED_STATE()%>";
	$("select[name=tstate] option:first").val(tstate);
	$("select[name=tstate] option:first").text(tstate);
	
	var year="<%=bike.getREGISTERED_YEAR()%>";
	$("select[name=year] option:first").val(year);
	$("select[name=year] option:first").text(year);
	</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>

</html>