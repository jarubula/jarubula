<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="assets/css/modalForm.css" rel="stylesheet" type="text/css"/>
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

<title>Send Request</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
    <%
    String message=(String)request.getAttribute("message"); 
    String driverId=request.getParameter("driverId");
    %>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
<style type="text/css">
#overlay {
position: fixed;
top: 0;
left: 0;
width: 100%;
height: 100%;
<%if(message!=null){ %>
 background-color: #000;
 <%}%>
 filter:alpha(opacity=70); 
-moz-opacity:0.7;
-khtml-opacity: 0.7;
opacity: 0.7;
z-index: 100;
display: none;
}
.cnt223 a{
text-decoration: none;
}
.popup{
width: 100%;
margin: 0 auto;
display: none;
position: fixed;
z-index: 101;
}
.cnt223{
min-width: 600px;
width: 600px;
min-height: 150px;
margin: 100px auto;
background: #ddd;
position: relative;
z-index: 103;
padding: 70px;
border-radius: 5px;
box-shadow: 0 2px 5px #000;
}
.cnt223 p{
clear: both;
color: #f94141;
text-align: justify;
}
.cnt223 p a{
color: #d91900;
font-weight: bold;
}
.cnt223 .x{
float: right;
height: 35px;
left: 22px;
position: relative;
top: -25px;
width: 34px;
}
.cnt223 .x:hover{
cursor: pointer;
}
</style>

<script type='text/javascript'>
$(function(){
	<%if(message!=null){ %>
 var overlay = $('<div id="overlay"></div>');
 overlay.show();
 overlay.appendTo(document.body); 
 <%}%>
$('.popup').show();
$('.close').click(function(){
$('.popup').hide();
overlay.appendTo(document.body).remove();
return false;
});
$('.x').click(function(){
	$('.popup').hide();
	overlay.appendTo(document.body).remove();
	return false;
	});
	});
	</script>




</head>
<body style="background-color=#f5f5f5;">

      
        <%if(message!=null){ %>
   <div class='popup'>
<div class='cnt223'>
<img src='images/cancel.png' alt='quit' class='x' id='x' />
<p>
<%=message%>
<br/>
<br/>
<a href='#' class='close' style="margin-right: 100px;">OK</a>
</p>
</div>
</div>
<%}else{} %>

										<form action="./SendMultiDriverRequest" method="post">
										<input type="hidden" name="driverId" value="<%=driverId%>"/>
										<div class="container">
										<div class="row">

										<div class="col-md-3">
											<b>Person Name</b>

										</div>

										<div class="col-md-3">
											<div class="form-group">
											 <input type="text" name="name" class="form-control input-sm" id="smallinput" onkeypress="return checkSpcialChar(event)" required>
											</div>


										</div>
										
										
										<%
										
										HttpSession sion = request.getSession(false);
					        			String str = (String)sion.getAttribute("user");
										
					        			if(str!=null){}else{
										%>
										
										
										<div class="col-md-3">
											<b>Email</b>

										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="email" name="email" class="form-control input-sm" id="smallinput">
											</div>

										</div>
										
										<div class="col-md-3">
											<b>Password</b>

										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="password" name="psw" class="form-control input-sm" id="smallinput">
											</div>

										</div>
										
										<%} %>
										
										<div class="col-md-3">
											<b>Pick Up Address</b>

										</div>
										<div class="col-md-3">
											<div class="form-group">
											<textarea rows="2" cols="50" name="address" required></textarea>
											</div>

										</div>
										
										
										<div class="col-md-3">
											<b>Destination</b>

										</div>
										<div class="col-md-3">
											<div class="form-group">
 																<select  name="destination" class="form-control input-sm" id="smallinput" required>
 																<option value="">Destination</option>
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
																	</select>											</div>

										</div>
										
										<div class="col-md-3">
											<b>Mobile No</b>

										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="text" name="mobileNo" class="form-control input-sm" id="mobileNo" pattern="[1-9]{1}[0-9]{9}" title="Enter 10 digit mobile number" maxlength="10" required>
											</div>

										</div>
										<div class="col-md-3">
											<b>Date</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="date" name="apptDate" class="form-control input-sm" id="smallinput" style="color:#000" required>
											</div>
										</div>
										
										
										
										<div class="col-md-3">
											<b>Time</b>
										</div>
										<div class="col-md-3">
											<div class="form-group">
											<input type="time" name="apptTime" class="form-control input-sm" id="smallinput" required>
											</div>
										</div>

										<hr>
										<!-- <div class="col-md-12"
											style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;">
											BUSINESS ADDRESS</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
											<br>
											<br>
										</div> -->
										<div class="col-md-6"></div>
										<div class="col-md-12" style="font-weight: 700; font-size: 700; color: red; text-align: center;">
											<input type="submit" value="Submit" class="btn btn-primary"/>
											</div>
										
									</div>
									</div>	
									</form>
<!-- <a href='#' class='close'>OK</a>

</div>
</div> -->





<%

// String driverId=request.getParameter("driverId");

// GetDriverDetails driverDetails=new GetDriverDetails();
// List<DriverBean> driverBean=driverDetails.getDriverById(driverId);

// Iterator it=driverBean.iterator();

// while(it.hasNext()){
	
// DriverBean driver=(DriverBean)it.next();

// InsertDriverPreRtsAndSal sal=driverDetails.getDriverSalary(driver.getEMAIL());

// System.out.println(sal);

%>
<%-- <form>
<table>
<tr>
<td>NAME:</td><td></td>
</tr>
<tr>
<td>ADDRESS:</td><td></td>
</tr>
<tr>
<td>AMOUNT:</td><td><%= sal.getDEXPECTED_SAL()%></td>
</tr>
<tr>
<td>EMAIL:</td><td></td>
</tr>
<tr>
<td>MOBILE NO:</td><td></td>
</tr>
<%String verifiedEmail=(String)session.getAttribute("user"); %>
</table>
</form> --%>
<%-- <%String verifiedEmail=(String)session.getAttribute("user"); %> --%>
<!-- <table align="center">
<form action="">

<input type="text" name="name" placeholder="Person Name"/>
<input type="email" name="email" placeholder="Email"/>
<input type="password" name="psw" placeholder="Password"/>
<textarea rows="3" cols="2" placeholder="PickUp Address"></textarea>
<textarea rows="3" cols="2" placeholder="To Destination"></textarea>
<input type="text" name="mobileNo" placeholder="Mobile Number"/>
<input type="date" name="date" placeholder="Pick Up Date"/>
<input type="time" name="time" placeholder="Pick Up Time"/>
<input type="submit" name="" placeholder="Submit"/>

</form>
</table> -->
<%-- <% 
}


%> --%>



</body>
</html>