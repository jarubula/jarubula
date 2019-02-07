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
<title>VaahanMitra | Home</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
	<script src="./css/countries.js" type="text/javascript"></script>
	<jsp:include page="./AdminMenu.jsp" />
	<jsp:include page="./Admin-right-side.jsp" />
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <!-- Place favicon.ico in the root directory -->
        <link rel="stylesheet" href="css/vendor.css">
        <!-- Theme initialization -->
        <script language="javascript">
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
        <script src="./css/countries.js" type="text/javascript"></script>
	<script language="javascript">
 	function validate() {
 		if(document.getElementById("pincodeNo").value!="")
 			{
 		if(document.getElementById("pincodeNo").value.length !=6 )
		 {
		  alert("Please enter 6 digits PINCODE No");
		  document.getElementById("pincodeNo").focus();
		  return false;
		 }
 			}
 		if(document.getElementById("phoneNo").value.length !=11 )
		 {
		  alert("Please enter 11 digits PHONE No.");
		  document.getElementById("phoneNo").focus();
		  return false;
		 }
 		if(document.getElementById("bpincodeNo").value.length !=6 )
		 {
		  alert("Please enter 6 digits BUSINESS PINCODE No");
		  document.getElementById("bpincodeNo").focus();
		  return false;
		 }
 		if(document.getElementById("mobileNo").value!="" )
		 {
 		if(document.getElementById("mobileNo").value.length !=10 )
		 {
		  alert("Please enter 10 digits PHONE No.");
		  document.getElementById("mobileNo").focus();
		  return false;
		 }
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
	</script>
    </head>

    <body>
        <div class="main-wrapper">
            <div class="app" id="app">
                
                
                <header class="header">
                    <div class="header-block header-block-collapse hidden-lg-up"> <button class="collapse-btn" id="sidebar-collapse-btn">
    			<i class="fa fa-bars"></i>
    		</button> </div>
                    
                <div class="header-block header-block-nav">
<!--                         <ul class="nav-profile"> -->
                            
<!--                             <li class="profile dropdown"> -->
<!--                                 <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"> -->
<!--                                     <div class="img" style=""> </div> <span class="name"> Mohan Amasa</span> </a> -->
<!--                                 <div class="dropdown-menu profile-dropdown-menu" aria-labelledby="dropdownMenu1"> -->
                                   
<!--                                     <a class="dropdown-item" href="#"> <i class="fa fa-power-off icon"></i> Logout </a> -->
<!--                                 </div> -->
<!--                             </li> -->
<!--                         </ul> -->
                    </div>
                </header>
                <div class="sidebar-overlay" id="sidebar-overlay"></div>
                <article class="content responsive-tables-page" style="background-color:#fff">
                    <section class="section">
                        <div class="row">
                            <div class="col-md-12">
                                <!-- <div class="card" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-bottom: 3px solid #a3b745;">
                                    <div class="card-block" style="border-bottom: 3px solid #a3b745;">
                                    </div>
                                </div> -->
                                        <section class="example">
                                            <div class="table-responsive">
                             <form name="frm" action="./AddBusinessOwner" method="post" onSubmit="return validate()">
                                              <div class="container col-lg-10 col-md-10 col-sm-12 col-xsm-12"> 
                                              <div class="form-group">
                              <div class="col-sm-12"> 
                                 <label for="email"><strong><u><i>Add Service Centre</i></u></strong></label>
                            					</div>
                              </div>
                              <div class="form-group">
                              <div class="col-sm-12"> 
                                 <label for="email"><%try{if(request.getAttribute("message")!=null){out.println(request.getAttribute("message"));}}catch(Exception e){} %></label>
                            					</div>
                              </div>
                              <div class="form-group"> 
                              <div class="col-sm-12"> 
                                 <label for="email">BUSINESS NAME <span style="color: red">*</span></label>
                                 <input type="hidden" name="usertype" value="SERVICEMECHANIC">
                                 <input type="text" class="form-control underlined" name="businessName" required placeholder="Enter Business Name">
                                 </div>
                              </div>
                           	  <div class="form-group">
                                        <div class="col-sm-6"> 
                                        <label for="password">PANCARD NO</label>
                                            <input type="text" class="form-control underlined" name="pancardNo" placeholder="Enter Pancard No."> 
                                        </div>
                                        <div class="col-sm-6"> 
                                        <label for="password">VEHICLE TYPE</label><br>
                                            <input type="checkbox" class="" name="vehicletype" value="4">FOUR WHEELER&nbsp;&nbsp;&nbsp;
                                            <input type="checkbox" class="" name="vehicletype" value="2">TWO WHEELER 
                                        </div>
                                    </div>
                               <div class="form-group">
                                        <div class="col-sm-12"> 
                                            <label><strong><u><i>BUSINESS ADDRESS</i></u></strong></label>
                                        </div>
                               </div>
                                <div class="form-group">
                                        <div class="col-sm-6"> 
                                            <label>ADDRESS<span style="color: red">*</span></label>
                                             <input class="form-control underlined" type="text" placeholder="Enter Address" name="address" required >
                                        </div>
                                        <div class="col-sm-6"> <label for="password">CITY<span style="color: red">*</span></label>
                                            <select class="form-control underlined" name="bcity" required
												id="city"
												onchange="show_voucher_cities(this.value);clear_expected_price();">
												<option value="">Select City</option>
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
                                        </div>
                                    <div class="form-group">     
                                        <div class="col-sm-6"> 
                                            <label>STATE<span style="color: red">*</span></label>
                                            <select class="form-control underlined"  id="country" name="state" required>
                                                    <option value="">Select State</option>                                     
                                            </select> 
                                        </div>
                            
                              <div class="col-sm-6"> 
                                 <label for="email">DISTRICT<span style="color: red">*</span></label>
                                 <select class="form-control underlined" id="state" name="district" required>
                                                     <option value="">Select District</option>                                                          
                                             </select> 
                              </div>
                              </div>
                              <div class="form-group">
                              <div class="col-sm-6"> 
                                 <label for="email">PINCODE<span style="color: red">*</span></label>
                                 <input class="form-control underlined" type="text" placeholder="Enter Pincode no" name="bpinNo" required id="bpincodeNo" onkeypress="CheckNumeric(event)">
                              </div>
                              <div class="col-sm-6"> 
                                 <label for="email">OFFICE PHONE NO.<span style="color: red">*</span></label>
                                  <input class="form-control underlined" type="text" required name="phoneNo" id="phoneNo" maxlength="11" placeholder="Enter Office Phone no."onkeypress="CheckNumeric(event)">
                              </div>
                              </div>
                              <div class="form-group">
                              <div class="col-sm-12"> 
                                            <label><strong><u><i>CONTACT INFORMATION</i></u></strong></label>
                                        </div>
                              </div>
                              <div class="form-group"> 
                              <div class="col-sm-6"> 
                                 <label for="email">NAME</label>
                                <input class="form-control underlined" type="text" placeholder="Enter Name" name="name" id="name">
                              </div>
                              <div class="col-sm-6"> 
                                 <label for="email">MOBILE</label>
                                 <input class="form-control underlined" type="text" placeholder="Enter Mobile No." name="mobileNo" id="mobileNo" maxlength="10" onkeypress="CheckNumeric(event)"> 
                              </div>
                              </div>
                              <div class="form-group">
                              <div class="col-sm-6"> 
                                            <label>CITY</label>
                                            <select name="city"
												id="city" class="form-control underlined"
												onchange="show_voucher_cities(this.value);clear_expected_price();">
												<option value="">Select City</option>
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
                                        <div class="col-sm-6"> <label for="password">PINCODE</label>
                                               <input class="form-control underlined" type="text" placeholder="Enter Pincode no" name="pinNo" id="pincodeNo" onkeypress="CheckNumeric(event)">
                                        </div>
                              </div>
                              <!-- <div class="form-group"> 
                              	<div class="col-sm-6">
                                 <label for="email">EMAIL</label>
                                 <input class="form-control underlined" type="text" placeholder="Enter EmailId" name="email" id="email" required> 
                              </div>
                              <div class="col-sm-6"> 
                                 <label for="email">PASSWORD</label>
                                 <input class="form-control underlined" type="password" required placeholder="Enter Password" name="password"> 
                              </div>
                              </div> -->
                             <div class="form-group">
                                        <div class="col-sm-6"> <button type="submit" class="btn btn-block btn-primary">Register</button>
                                        </div>
                                        <div class="col-sm-6"> 
                                           <button type="reset" class="btn btn-block btn-primary">Reset</button>
                                        </div>
                             </div>
                            </div>
                                                 </form>
                                            </div>
                                        </section>
                                        
                            </div>
                        </div>
                    </section>
                </article>
                <footer class="footer">
                    <div class="footer-block buttons"></div>
                    <div class="footer-block author">
                        <ul>
                            <li> created by <a href="#">Kosuri Soft Pvt Ltd</a> </li>
                            <li> <a href="www.kosurisoft.com">get in touch</a> </li>
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
			populateCountries("country", "state");
		</script>
		<script language="javascript">
			populateCountries("country1", "state1");
		</script>
        <script src="js/vendor.js"></script>
        <script src="js/app.js"></script>
    </body>
</html>