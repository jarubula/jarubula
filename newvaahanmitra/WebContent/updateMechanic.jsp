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
<%@page
	import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./css/countries.js" type="text/javascript"></script>
<jsp:include page="./carMenu.jsp" />
<jsp:include page="./topMenu.jsp" />
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>AddServiceMechanic</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<!-- Theme initialization -->
<script>
function NumAndTwoDecimals(event , obj){
	reg = /[^0-9.,]/g;
	obj.value =  obj.value.replace(reg,"");
 }
</script>
<script language="javascript">
 	function validate() {
 		if(document.getElementById("phoneNo").value.length !=10 )
		 {
		  alert("Please enter 10 digits Mobile No");
		  document.getElementById("phoneNo").focus();
		  return false;
		 }
 		if(document.getElementById("pincodeNo").value.length !=6 )
		 {
		  alert("Please enter 6 digits PINCODE No");
		  document.getElementById("pincodeNo").focus();
		  return false;
		 }

 		if(document.getElementById("panno").value.length !=10 )
 		{
 			alert("Please enter 10 digits in PANno.");
 			document.getElementById("panno").focus();
 			return false;
 		}
 		return true;
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

			<header class="" style="font-family: 'Oswald', sans-serif;">


			<div class="header-block header-block-nav"></div>
			</header>
			<br>

			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div align="center">
						<h3>SERVICE CENTER DASHBOARD</h3>
					</div>
				</div>


				<div class="col-md-12 col-xs-12 col-sm-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="">
							<div class="">
								<form name="frm" action="./UpdateMechanic" method="post"
									onSubmit="return validate()">
									<%
									String message = (String) request.getAttribute("message");
									String emailId = request.getParameter("eid");
									if(emailId == null){
										emailId = (String)request.getAttribute("eid");
									}
									GetMechanicDetails  md= new GetMechanicDetails();
									MechanicProfile mechanic = md.getMechanicDetails(emailId);
									
										if (message != null) {
									%>
									<h6 style="color: red"><%=message%>
									</h6>
									<%
										} else {
										}
									%>
									<div class="col-md-12 col-sm-12 col-xs-12" align="center"
										style="text-align: center; background-color: #523f6d; color: #fff;">
										UPDATE MECHANIC</div>
									<br>
									<br>
									<div class="col-md-12 col-sm-12 col-xs-12 well"
										style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;">

										CONTACT ADDRESS</div>
									<div class="col-md-12 col-xs-12 col-sm-12">
										<br>
										<br>
									</div>

									<div class="row">

										<div class="col-md-3">
											<b>Name</b>

										</div>

										<div class="col-md-3">
											<div class="form-group">
												<input type="text" name="name" class="form-control" value="<%=mechanic.getNAME()%>"
													placeholder="Enter First Name" required>
											</div>

										</div>
										<div class="col-md-3">
											<b>Email</b>

										</div>
										<div class="col-md-3" align="left">
											<div class="form-group">
												<input type="email" autocomplete="off" name="emailId" readonly="readonly" value="<%=mechanic.getEMAIL()%>"
													class="form-control" placeholder="Enter Email" required>
											</div>

										</div>
										<div class="col-md-3">
											<b>Mobile No</b>

										</div>
										<div class="col-md-3">
											<div class="form-group">
												<input autocomplete="off" type="text" class="form-control" value="<%=mechanic.getMOBILE_NO()%>"
													name="phoneNo" id="phoneNo" pattern="[1-9]{1}[0-9]{9}"
													title="Enter 10 digit mobile number"
													placeholder="Mobile Number" maxlength="10" required>
											</div>
										</div>
										<div class="col-md-3">
											<b>Qualification</b>

										</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" class="form-control" value="<%=mechanic.getQUALIFICATION()%>"
													placeholder="Enter Qualification" name="qualification"
													required>
											</div>

										</div>
										<div class="col-md-3">
											<b>Address</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" name="address" value="<%=mechanic.getADDRESS()%>"
													placeholder="Enter Address" class="form-control" required>
											</div>
										</div>
										<div class="col-md-3">
											<b>City</b>
										</div>
										<div class="col-md-3">
											<select name="city" required class="form-control" id="city" 
												onchange="show_voucher_cities(this.value);clear_expected_price();">
												<option value="<%=mechanic.getCITY()%>"><%=mechanic.getCITY()%></option>
												<optgroup label="Top Cities">
													<option value="New Delhi">New Delhi</option>
													<option value="Mumbai">Mumbai</option>
													<option value="Bangalore">Bangalore</option>
													<option value="Pune">Pune</option>
													<option value="Chennai">Chennai</option>
													<option value="Kolkata">Kolkata</option>
													<option value="Hyderabad">Hyderabad</option>
													<option value="Ahmedabad">Ahmedabad</option>
													<option value="Chandigarh">Chandigarh</option>
													<option value="Gurgaon">Gurgaon</option>
													<option value="Noida">Noida</option>
													<option value="Navi Mumbai">Navi Mumbai</option>
													<option value="Thane">Thane</option>
													<option value="Cochin">Cochin</option>
													<option value="Faridabad">Faridabad</option>
													<option value="Ghaziabad">Ghaziabad</option>
												</optgroup>
												<optgroup label="All Other Cities">
													<option value="Agra">Agra</option>
													<option value="Ahmednagar">Ahmednagar</option>
													<option value="Ajmer">Ajmer</option>
													<option value="Akola">Akola</option>
													<option value="Alappuzha">Alappuzha</option>
													<option value="Aligarh">Aligarh</option>
													<option value="Allahabad">Allahabad</option>
													<option value="Alwar">Alwar</option>
													<option value="Amalapuram">Amalapuram</option>
													<option value="Ambala">Ambala</option>
													<option value="Amravati">Amravati</option>
													<option value="Amritsar">Amritsar</option>
													<option value="Anand">Anand</option>
													<option value="Anantapur">Anantapur</option>
													<option value="Aurangabad">Aurangabad</option>
													<option value="Bareilly">Bareilly</option>
													<option value="Bathinda">Bathinda</option>
													<option value="Beed">Beed</option>
													<option value="Belgaum">Belgaum</option>
													<option value="Bellary">Bellary</option>
													<option value="Bharuch">Bharuch</option>
													<option value="Bhavnagar">Bhavnagar</option>
													<option value="Bhilai">Bhilai</option>
													<option value="Bhilwara">Bhilwara</option>
													<option value="Bhimavaram">Bhimavaram</option>
													<option value="Bhopal">Bhopal</option>
													<option value="Bhubaneswar">Bhubaneswar</option>
													<option value="Bhuj">Bhuj</option>
													<option value="Bikaner">Bikaner</option>
													<option value="Bilaspur">Bilaspur</option>
													<option value="Bulandshahar">Bulandshahar</option>
													<option value="Chidambaram">Chidambaram</option>
													<option value="Chittoor">Chittoor</option>
													<option value="Coimbatore">Coimbatore</option>
													<option value="Cuddalore">Cuddalore</option>
													<option value="Davangere">Davangere</option>
													<option value="Dehradun">Dehradun</option>
													<option value="Dhanbad">Dhanbad</option>
													<option value="Dharwad">Dharwad</option>
													<option value="Dibrugarh">Dibrugarh</option>
													<option value="Dindigul">Dindigul</option>
													<option value="Durg">Durg</option>
													<option value="Durgapur">Durgapur</option>
													<option value="Eluru">Eluru</option>
													<option value="Erode">Erode</option>
													<option value="Firozabad">Firozabad</option>
													<option value="Gandhidham">Gandhidham</option>
													<option value="Gandhinagar">Gandhinagar</option>
													<option value="Goa">Goa</option>
													<option value="Gorakhpur">Gorakhpur</option>
													<option value="Gulbarga">Gulbarga</option>
													<option value="Guntur">Guntur</option>
													<option value="Gurdaspur">Gurdaspur</option>
													<option value="Guwahati">Guwahati</option>
													<option value="Gwalior">Gwalior</option>
													<option value="Haldwani">Haldwani</option>
													<option value="Hapur">Hapur</option>
													<option value="Himmatnagar">Himmatnagar</option>
													<option value="Hissar">Hissar</option>
													<option value="Hoshiarpur">Hoshiarpur</option>
													<option value="Hospet">Hospet</option>
													<option value="Hosur">Hosur</option>
													<option value="Howrah">Howrah</option>
													<option value="Hubli">Hubli</option>
													<option value="Idukki">Idukki</option>
													<option value="Indore">Indore</option>
													<option value="Jabalpur">Jabalpur</option>
													<option value="Jagdalpur">Jagdalpur</option>
													<option value="Jaipur">Jaipur</option>
													<option value="Jalandhar">Jalandhar</option>
													<option value="Jalgaon">Jalgaon</option>
													<option value="Jammu">Jammu</option>
													<option value="Jamnagar">Jamnagar</option>
													<option value="Jamshedpur">Jamshedpur</option>
													<option value="Jodhpur">Jodhpur</option>
													<option value="Kadapa">Kadapa</option>
													<option value="Kakinada">Kakinada</option>
													<option value="Kannur">Kannur</option>
													<option value="Kanpur">Kanpur</option>
													<option value="Karimnagar">Karimnagar</option>
													<option value="Karnal">Karnal</option>
													<option value="Karur">Karur</option>
													<option value="Kasaragod">Kasaragod</option>
													<option value="Khammam">Khammam</option>
													<option value="Khanna">Khanna</option>
													<option value="Kolar">Kolar</option>
													<option value="Kolhapur">Kolhapur</option>
													<option value="Kollam">Kollam</option>
													<option value="Kota">Kota</option>
													<option value="Kottayam">Kottayam</option>
													<option value="Kozhikode">Kozhikode</option>
													<option value="Kurnool">Kurnool</option>
													<option value="Kurukshetra">Kurukshetra</option>
													<option value="Latur">Latur</option>
													<option value="Lucknow">Lucknow</option>
													<option value="Ludhiana">Ludhiana</option>
													<option value="Madurai">Madurai</option>
													<option value="Malappuram">Malappuram</option>
													<option value="Mandi">Mandi</option>
													<option value="Mangalore">Mangalore</option>
													<option value="Mathura">Mathura</option>
													<option value="Meerut">Meerut</option>
													<option value="Mehsana">Mehsana</option>
													<option value="Moga">Moga</option>
													<option value="Mohali">Mohali</option>
													<option value="Moradabad">Moradabad</option>
													<option value="Muzaffarnagar">Muzaffarnagar</option>
													<option value="Mysore">Mysore</option>
													<option value="Nadia">Nadia</option>
													<option value="Nagercoil">Nagercoil</option>
													<option value="Nagpur">Nagpur</option>
													<option value="Namakkal">Namakkal</option>
													<option value="Nanded">Nanded</option>
													<option value="Nashik">Nashik</option>
													<option value="Nellore">Nellore</option>
													<option value="Neyveli">Neyveli</option>
													<option value="Nizamabad">Nizamabad</option>
													<option value="Ongole">Ongole</option>
													<option value="Palakkad">Palakkad</option>
													<option value="Palwal">Palwal</option>
													<option value="Panchkula">Panchkula</option>
													<option value="Panipat">Panipat</option>
													<option value="Pathanamthitta">Pathanamthitta</option>
													<option value="Pathankot">Pathankot</option>
													<option value="Patiala">Patiala</option>
													<option value="Patna">Patna</option>
													<option value="Pimpri-Chinchwad">Pimpri-Chinchwad</option>
													<option value="Pollachi">Pollachi</option>
													<option value="Pondicherry">Pondicherry</option>
													<option value="Port Blair">Port Blair</option>
													<option value="Raipur">Raipur</option>
													<option value="Rajahmundry">Rajahmundry</option>
													<option value="Rajkot">Rajkot</option>
													<option value="Ranchi">Ranchi</option>
													<option value="Ratlam">Ratlam</option>
													<option value="Ratnagiri">Ratnagiri</option>
													<option value="Rohtak">Rohtak</option>
													<option value="Roorkee">Roorkee</option>
													<option value="Saharanpur">Saharanpur</option>
													<option value="Salem">Salem</option>
													<option value="Sangli">Sangli</option>
													<option value="Sangrur">Sangrur</option>
													<option value="Satara">Satara</option>
													<option value="Shillong">Shillong</option>
													<option value="Shimla">Shimla</option>
													<option value="Shimoga">Shimoga</option>
													<option value="Sikar">Sikar</option>
													<option value="Siliguri">Siliguri</option>
													<option value="Sivakasi">Sivakasi</option>
													<option value="Solan">Solan</option>
													<option value="Solapur">Solapur</option>
													<option value="Sonipat">Sonipat</option>
													<option value="Sri Ganganagar">Sri Ganganagar</option>
													<option value="Srinagar">Srinagar</option>
													<option value="Surat">Surat</option>
													<option value="Surendranagar">Surendranagar</option>
													<option value="Thanjavur">Thanjavur</option>
													<option value="Thiruvalla">Thiruvalla</option>
													<option value="Thoothukudi">Thoothukudi</option>
													<option value="Thrissur">Thrissur</option>
													<option value="Tiruchirapalli">Tiruchirapalli</option>
													<option value="Tirunelveli">Tirunelveli</option>
													<option value="Tirupati">Tirupati</option>
													<option value="Tirupur">Tirupur</option>
													<option value="Tiruvalla">Tiruvalla</option>
													<option value="Tiruvallur">Tiruvallur</option>
													<option value="Trivandrum">Trivandrum</option>
													<option value="Tumkur">Tumkur</option>
													<option value="Tuticorin">Tuticorin</option>
													<option value="Udaipur">Udaipur</option>
													<option value="Udumalpet">Udumalpet</option>
													<option value="Udupi">Udupi</option>
													<option value="Ujjain">Ujjain</option>
													<option value="Vadodara">Vadodara</option>
													<option value="Valsad">Valsad</option>
													<option value="Vapi">Vapi</option>
													<option value="Varanasi">Varanasi</option>
													<option value="Vellore">Vellore</option>
													<option value="Vijayawada">Vijayawada</option>
													<option value="Viluppuram">Viluppuram</option>
													<option value="Visakhapatnam">Visakhapatnam</option>
													<option value="Visnagar">Visnagar</option>
													<option value="Vizianagaram">Vizianagaram</option>
													<option value="Warangal">Warangal</option>
													<option value="Wayanad">Wayanad</option>
													<option value="Yamunanagar">Yamunanagar</option>
													<option value="Zirakpur">Zirakpur</option>
												</optgroup>
											</select>
										</div>
										<div class="col-md-12"></div>
										<div class="col-md-3"><b>State</b></div>
										<div class="col-md-3">
											<div class="form-group">
												<select id="country1" name="state1"
													class="form-control" required>
													<option value="">Select State</option>
												</select>
											</div>
										</div>
										<div class="col-md-3"><b>District</b></div>
										<div class="col-md-3">
											<div class="form-group">
												<select id="state1" required name="district1"
													class="form-control" required>
													<option value="<%=mechanic.getDISTRICT()%>"><%=mechanic.getDISTRICT()%></option>
												</select>
											</div>
										</div>
										<div class="col-md-3"><b>Pincode No</b></div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" class="form-control" value="<%=mechanic.getPINCODE()%>"
													placeholder="Enter Pincode No" name="pincodeNo" maxlength="6"
													id="pincodeNo" onkeyup="NumAndTwoDecimals(event , this);" required>
											</div>
										</div>
										<div class="col-md-6"></div>


										<div class="col-md-12"
											style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;">
											WORK EXPERIENCE</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
											<br>
										</div>
										<div class="col-md-3">
											<b>Experience</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" class="form-control" value="<%=mechanic.getEXPERIENCE()%>"
													placeholder="Enter Experience" name="experience" required>
											</div>

										</div>


										<div class="col-md-3">
											<b>Specialized In</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<select name="specilzed" 
													class="form-control" required>
													<option value="<%=mechanic.getSPECIALIZED_IN()%>"><%=mechanic.getSPECIALIZED_IN()%></option>
													<option value="FOUR WHEELER">FOUR WHEELER</option>
													<option value="TWO WHEELER">TWO WHEELER</option>
													<option value="TWO WHEELER,FOUR WHEELER">BOTH</option>
												</select>
											</div>
										</div>
										<div class="col-md-12">
											<br>
										</div>
										<div class="col-md-3">
											<b>Brand Name</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" class="form-control" value="<%=mechanic.getBRAND_NAME()%>"
													placeholder="Enter BrandName" name="brandName" required>
											</div>
										</div>
										<div class="col-md-3">
											<b>Experience With Companies</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" class="form-control" value="<%=mechanic.getEXPERIENCE_WITH_COMPANIES()%>"
													placeholder="Enter Experience" name="expCompanies" required>
											</div>
										</div>
										<div class="col-md-3">
											<b>Worked In Companies</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<input type="text" class="form-control" value="<%=mechanic.getWORKED_IN_COMPANIES()%>"
													placeholder="Enter Experience" name="workedCompanies"
													required>
											</div>
										</div>
										<div class="col-md-12"></div>
										<div class="col-md-12" align="center">
											<button TYPE="submit" onclick="return(svalidate1())"
														style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
											class="btn btn-primary">UPDATE MECHANIC</button>

										</div>
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

			<!-- /.modal -->

			<!-- /.modal -->
		</div>
	</div>

	<div class="ref" id="ref">
		<div class="color-primary"></div>
		<div class="chart">
			<div class="color-primary"></div>
			<div class="color-secondary"></div>
		</div>
	</div>
	<script language="javascript">
			populateCountries("country", "state");
		</script>
	<script language="javascript">
			populateCountries("country1", "state1");
		</script>
	
	<script>
			var state1="<%=mechanic.getSTATE()%>";
$("select[name=state1] option:first").val(state1);
$("select[name=state1] option:first").text(state1);
</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>
</html>