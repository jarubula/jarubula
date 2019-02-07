<%@ page language="java" import="com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*,java.io.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./DriverMenu.jsp" />
<jsp:include page="./topMenu1.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<link rel="stylesheet" type="text/css" href="./css/tcal.css" />
<script type="text/javascript" src="./js/tcal.js"></script>

<!-- Theme initialization -->
<script>
	var themeSettings = (localStorage.getItem('themeSettings')) ? JSON
			.parse(localStorage.getItem('themeSettings')) : {};
	var themeName = themeSettings.themeName || '';
	if (themeName) {
		document
				.write('<link rel="stylesheet" id="theme-style" href="css/app-' + themeName + '.css">');
	} else {
		document
				.write('<link rel="stylesheet" id="theme-style" href="css/app.css">');
	}
</script>
<style>
	.td{
	 font-size: small;
	}
	</style>
	<script
  src="https://code.jquery.com/jquery-2.1.3.js"
  integrity="sha256-goy7ystDD5xbXSf+kwL4eV6zOPJCEBD1FBiCElIm+U8="
  crossorigin="anonymous"></script>
<script type="text/javascript">

$(document).ready(function () {

    var hideOptions = function () {
        var $select = $('select');
        $select.find('option').show();
        $select.each(function () {
            var $this = $(this);
            var value = $this.val();
            var $options = $this.parents('div').find('select').not(this).find('option');
            var $option = $options.filter('[value="' + value + '"]');
            if (value) {
                $option.hide();
                $option.each(function () {
                    if (this.defaultSelected) {
                        $(this).parent('select').val('');
                    }
                });
            }
        });
    }

    hideOptions();

    $('select').on('change', function () {
        hideOptions();
    });
});

</script>

	<style>
	 :required:focus {
	   box-shadow: 0  0 6px rgba(255,0,0,0.5);
	   border: 1px red solid;
	   outline: 0;
	 }
	</style>

</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">


			<header class="">
			<div class="header-block header-block-collapse hidden-lg-up">
				<button class="collapse-btn" id="sidebar-collapse-btn">
					<i class="fa fa-bars"></i>
				</button>
			</div>

			<div class="header-block header-block-nav">
<!-- 				<ul class="nav-profile"> -->

<!-- 					<li class="profile dropdown"><a -->
<!-- 						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" -->
<!-- 						role="button" aria-haspopup="true" aria-expanded="false"> -->
<!-- 							<div class="img" style=""></div> <span class="name"> Mohan -->
<!-- 								Amasa</span> -->
<!-- 					</a> -->
<!-- 						<div class="dropdown-menu profile-dropdown-menu" -->
<!-- 							aria-labelledby="dropdownMenu1"> -->

<!-- 							<a class="dropdown-item" href="#"> <i -->
<!-- 								class="fa fa-power-off icon"></i> Logout -->
<!-- 							</a> -->
<!-- 						</div></li> -->
<!-- 				</ul> -->
			</div>
			</header>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content responsive-tables-page" style="background-color:#fff"> 
			<section class="section">
			<div class="row">
				<div class="col-md-12">
					<div class="card" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive">
								<%
								String message=(String)request.getAttribute("message");
								if(message!=null){
								%>	
								<%=message %>
								<% 	
								}
								%>
									<form action="./InsertOnDemandDriverRoutes" method="post">
									<div class="col-md-12" style="background: #052963;color: #fff;text-align: center;font-weight: bolder;height:44px;margin-top:8px;padding: 10px;">Preferred Routes</div>
									

<%
String email=(String)session.getAttribute("user");
GetDriverDetails gdd=new GetDriverDetails();
String jobType=gdd.getDriverJobType(email);
/* ArrayList<DriverBean> permitType=gdd.getDriverPermitType(email);
Iterator it=permitType.iterator();
DriverBean bean=null;
while(it.hasNext()){
	bean=(DriverBean)it.next();
}
if(bean.getPERMIT_TYPE()!=null && bean.getPERMIT_TYPE().equals("Within State")){ */
%>

<div class="col-md-2 col-xs-12 col-sm-6">
<div class="form-group">
<label for="exampleInputEmail1">FROM CITY</label>
<select id="fromCity" name ="fromCity" class="form-control input-sm"  class="preferenceSelect" required>
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
</select>
</div>
</div>

<div class="col-md-2 col-xs-12 col-sm-6">
<div class="form-group">
<label for="exampleInputEmail1">TO CITY</label>
<select id="toCity" name ="toCity" class="form-control input-sm"  class="preferenceSelect" >
  <option value="">Select City</option>
            <optgroup label="Top Cities">
            <option value="Any City">Any City</option>
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
</select>
</div>
</div>
<%-- <%}else{ %>
<td>FROM STATE<select id="state1" name ="fromState" class="form-control1"  class="preferenceSelect" required>
<option value="">------------Select State------------</option>
<option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
<option value="Andhra Pradesh">Andhra Pradesh</option>
<option value="Arunachal Pradesh">Arunachal Pradesh</option>
<option value="Assam">Assam</option>
<option value="Bihar">Bihar</option>
<option value="Chandigarh">Chandigarh</option>
<option value="Chhattisgarh">Chhattisgarh</option>
<option value="Dadra and Nagar Haveli">Dadra and Nagar Haveli</option>
<option value="Daman and Diu">Daman and Diu</option>
<option value="Delhi">Delhi</option>
<option value="Goa">Goa</option>
<option value="Gujarat">Gujarat</option>
<option value="Haryana">Haryana</option>
<option value="Himachal Pradesh">Himachal Pradesh</option>
<option value="Jammu and Kashmir">Jammu and Kashmir</option>
<option value="Jharkhand">Jharkhand</option>
<option value="Karnataka">Karnataka</option>
<option value="Kerala">Kerala</option>
<option value="Lakshadweep">Lakshadweep</option>
<option value="Madhya Pradesh">Madhya Pradesh</option>
<option value="Maharashtra">Maharashtra</option>
<option value="Manipur">Manipur</option>
<option value="Meghalaya">Meghalaya</option>
<option value="Mizoram">Mizoram</option>
<option value="Nagaland">Nagaland</option>
<option value="Orissa">Orissa</option>
<option value="Pondicherry">Pondicherry</option>
<option value="Punjab">Punjab</option>
<option value="Rajasthan">Rajasthan</option>
<option value="Sikkim">Sikkim</option>
<option value="Tamil Nadu">Tamil Nadu</option>
<option value="Tripura">Tripura</option>
<option value="Uttaranchal">Uttaranchal</option>
<option value="Uttar Pradesh">Uttar Pradesh</option>
<option value="West Bengal">West Bengal</option>
</select>
</td>
													
<td>
TO STATE<select id="state2" name ="toState" class="form-control1" class="preferenceSelect">
<option value="">------------Select State------------</option>
<option value="AnyState">Any State</option>
<option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
<option value="Andhra Pradesh">Andhra Pradesh</option>
<option value="Arunachal Pradesh">Arunachal Pradesh</option>
<option value="Assam">Assam</option>
<option value="Bihar">Bihar</option>
<option value="Chandigarh">Chandigarh</option>
<option value="Chhattisgarh">Chhattisgarh</option>
<option value="Dadra and Nagar Haveli">Dadra and Nagar Haveli</option>
<option value="Daman and Diu">Daman and Diu</option>
<option value="Delhi">Delhi</option>
<option value="Goa">Goa</option>
<option value="Gujarat">Gujarat</option>
<option value="Haryana">Haryana</option>
<option value="Himachal Pradesh">Himachal Pradesh</option>
<option value="Jammu and Kashmir">Jammu and Kashmir</option>
<option value="Jharkhand">Jharkhand</option>
<option value="Karnataka">Karnataka</option>
<option value="Kerala">Kerala</option>
<option value="Lakshadweep">Lakshadweep</option>
<option value="Madhya Pradesh">Madhya Pradesh</option>
<option value="Maharashtra">Maharashtra</option>
<option value="Manipur">Manipur</option>
<option value="Meghalaya">Meghalaya</option>
<option value="Mizoram">Mizoram</option>
<option value="Nagaland">Nagaland</option>
<option value="Orissa">Orissa</option>
<option value="Pondicherry">Pondicherry</option>
<option value="Punjab">Punjab</option>
<option value="Rajasthan">Rajasthan</option>
<option value="Sikkim">Sikkim</option>
<option value="Tamil Nadu">Tamil Nadu</option>
<option value="Tripura">Tripura</option>
<option value="Uttaranchal">Uttaranchal</option>
<option value="Uttar Pradesh">Uttar Pradesh</option>
<option value="West Bengal">West Bengal</option>
</select>
</td>		
<%} %> --%>

<div class="col-md-2 col-xs-12 col-sm-6">
<div class="form-group">
<label for="exampleInputEmail1">PickUp Date</label>
<input type="date" name="date" placeholder="Date" class="form-control input-sm"  required/>
</div>
</div>

<div class="col-md-2 col-xs-12 col-sm-6">
<div class="form-group">
<label for="exampleInputEmail1">Available Time</label>
<input type="time" name="time" contenteditable="true" class="form-control input-sm" required/>
</div>
</div>
																
 	<div class="col-md-4 col-xs-12 col-sm-6">
					<br>
					
					<div class="form-group" style="position: relative;top:5px;"><input type="submit" value="Submit" class="btn btn-primary"/></div>
					
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
	<!-- Reference block for JS -->
	<div class="ref" id="ref">
		<div class="color-primary"></div>
		<div class="chart">
			<div class="color-primary"></div>
			<div class="color-secondary"></div>
		</div>
	</div>
	<script language="javascript">
		populateBrands("brand", "model");
 	</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>

</html>