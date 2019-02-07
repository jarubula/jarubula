<%@page import="java.io.PrintWriter"%>
<%@ page language="java"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.8.2.js"></script>
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
#overlay {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%; /
	background-color: #000; /
	filter: alpha(opacity = 70);
	-moz-opacity: 0.7;
	-khtml-opacity: 0.7;
	opacity: 0.7;
	z-index: 100;
	display: none;
}

.cnt223 a {
	text-decoration: none;
}

.popup {
	width: 100%;
	margin: 0 auto;
	display: none;
	position: fixed;
	z-index: 101;
}

.cnt223 {
	width: 601px;
	/* min-height: 190px; */
	top: 90px;
	height: 199px;
	margin: 100px auto;
	background: rgb(255, 255, 255);
	position: relative;
	z-index: 149px;
	padding: 50px;
	border-radius: 15px;
	box-shadow: 0 1px 30px;
}

.cnt223 p {
	clear: both;
	color: #f94141;
	text-align: justify;
}

.cnt223 p a {
	color: #d91900;
	font-weight: bold;
}

.cnt223 .x {
	float: right;
	height: 34px;
	left: 49px;
	position: relative;
	top: -47px;
	width: 34px;
}

.cnt223 .x:hover {
	cursor: pointer;
}
.fade.in {
    opacity: 1;
    background: rgba(0,0,0,.7);
}
.car1{
    background: #fff;
    border-radius: 3px;
}
.animated {
	background-image: url(/css/images/logo.png);
	background-repeat: no-repeat;
	background-position: left top;
	padding-top: 95px;
	margin-bottom: 60px;
	-webkit-animation-duration: 10s;
	animation-duration: 1s;
	-webkit-animation-fill-mode: both;
	animation-fill-mode: both;
}


.bounceInDown {
	-webkit-animation-name: bounceInDown;
	animation-name: bounceInDown;
}
.tooltip1 {
    position: relative;
    display: inline-block;
    border-bottom: 1px dotted #fff;
}

.tooltip1 .tooltiptext1 {
    visibility: hidden;
    width: 200px;
    background-color: #555555bd;
    color: #fff;
    text-align: center;
    border-radius: 6px;
    padding: 5px 0;
    position: absolute;
    z-index: 1;
    bottom: 125%;
    left:1%;
    margin-left: -60px;
    opacity: 0;
    transition: opacity 0.3s;
}

.tooltip1 .tooltiptext1::after {
    content: "";
    position: absolute;
    top: 100%;
    left: 50%;
    margin-left: -5px;
    border-width: 5px;
    border-style: solid;
    border-color: #555 transparent transparent transparent;
}

.tooltip1:hover .tooltiptext1 {
    visibility: visible;
    opacity: 1;
}
:focus {
    outline: -webkit-focus-ring-color auto 0px !important;
}
.bo3 i {
    font-size:27px;
    color: #9a2220;
    margin: 6px 7px;
}
.bo8 {
    position: absolute;
    margin: -3px 10px;
    background: #000;
    width: 22px;
    height: 22px;
    border: 1px solid #000;
    border-radius: 41px;
    color: #fff;
    padding: 0px 6px 0px 6px;
    font-size: 16px;
}
.ow{
    font-size: 19px;
    color: #000;
    text-decoration: none;
    }
   input[type=checkbox] {
    display: block;
    width:22px;
    height:22px;
    background-repeat: no-repeat;
    background-position: center center;
    background-size: contain;
    -webkit-appearance:non !important;
    outline: 0;
} 
.pagination {
    display: inline-block;
    padding-left: 0;
    margin: 20px 0;
    border-radius: 4px;
    border: 1px solid #ccc;
}
.pagination>li:first-child>a, .pagination>li:first-child>span {
    margin-left: 0;
    border-top-left-radius: 0px;
    border-bottom-left-radius: 0px;
    border-right: 1px solid #ccc;
    border-radius: 1px;
}
.pagination > li > a {
    padding: 8px 14px;
    margin-left: 5px;
    background-color: transparent;
    border: 0;
    font-weight: 700;
    border-radius:0px !important;
    border-right: 1px solid #ccc !important;
}
.cart{
    border-radius: 3px;
    border: 1px solid #ccc;
    line-height:22px;
    padding: 0 5px;
    width: 80px;
    }
</style>
<script type='text/javascript'>
	$(function() {
		// var overlay = $('<div id="overlay"></div>');
		// overlay.show();
		// overlay.appendTo(document.body);
		$('.popup').show();
		$('.close').click(function() {
			$('.popup').hide();
			overlay.appendTo(document.body).remove();
			return false;
		});
		$('.x').click(function() {
			$('.popup').hide();
			overlay.appendTo(document.body).remove();
			return false;
		});
	});
<%String message1 = (String) request.getAttribute("message");
			//	String bikeId = (String) request.getAttribute("bikeId");
			//	if (message1 != null) {%>
	
</script>
<%
	if (message1 != null) {
%>
<div class='popup'>
	<div class='cnt223'>
		<img src='images/cancel.png' alt='quit' class='x' id='x' />
		<p>
			<%=message1%>
			<br /> <br />
			<!-- <a href='#' class='close'> <img src='images/OK.jpg' alt='quit' class='x' id='x' /></a> -->
		</p>
	</div>
</div>
<%
	} else {
	}
%>

<script type="text/javascript">
	function yesno(thecheckbox, thelabel) {
		var checkboxvar = document.getElementById(thecheckbox);
		var labelvar = document.getElementById(thelabel);
		if (checkboxvar.checked == false) {
			alert("ARE YOU SURE ACTIVE YOUR VEHICLE");
			labelvar.innerHTML = "ACTIVE";
			labelvar.style.color = "black";
		} else {
			alert("ARE YOU SURE INACTIVE YOUR VEHICLE");
			labelvar.innerHTML = "INACTIVE";
			labelvar.style.color = "red";
		}
	}
</script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Search</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<!-- Base Css -->
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/modalForm.css" rel="stylesheet" type="text/css" />
<%--  <% 
	String message = (String) request.getAttribute("message");
         if(message!=null){ %>
         <div class='popup'>
      <div class='cnt223'>
      <img src='images/cancel.png' alt='quit' class='x' id='x' />
      <p>
      <%=message%>
      <br/>
      <br/>
      <a href='#' class='close'>Close</a>
      </p>
      </div>
      </div>
      <%}else{} %> --%>
<script type="text/javascript">
	function callMe(myId) {

		var popup1 = window
				.open(
						'./DisplayCarImage.jsp?photo=' + myId,
						'mywindow',
						'width=2000,height=1000,titlebar=0,status=no,toolbar=no,location=no,directories=no')
		/* 	var n=window.open("DisplayCarImage.jsp?photo="+myId,"mywindow", " width=2000, height=1000"); */

	}
</script>
<script type="text/javascript">
	alert = function() {
	}
	function getCheckedCheckboxesFor(checkboxName) {

		var checkboxes = document.getElementsByName(checkboxName);

		var value1 = [];

		for (var i = 0; i < checkboxes.length; i++) {

			if (checkboxes[i].checked) {

				//     	 document.getElementById('checkboxName').appendChild(document.getElementById('hiddenArea'));

				value1.push(checkboxes[i].value);

			}
		}
		if (value1.length > 1 && value1.length < 4) {

			// 	 location.href="CompareUsedCar?compare="+value1;
			var n = window.open("CompareUsedCar?compare=" + value1, "myWin",
					"left=700, top=200, width=850, height=700");
		} else if (value1.length < 2) {

			/*  alert("please select maximum 3 checkboxes to compare your selection.."); */
			document.getElementById("msg").innerHTML = "please select maximum 3 Cars <br>to compare your selection..";

		} else if (value1.length > 3) {

			// 	 alert("you can not select more than  3 checkboxes to compare your selection..");
			document.getElementById("msg").innerHTML = "you can not select more than  3 Cars <br>to compare your selection..";

		}
		return value1;

	}
</script>

<style>
.content {
    padding: 0px !important;
}
.sticky + .content {
    padding-top:68px !important;
}
input[type=checkbox] {
	display: block;
	width: 21px;
	height:21px;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: contain;
	-webkit-appearance: non !important;
	outline: 0;
}
input[type=checkbox]:checked {
    background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" x="0px" y="0px" viewBox="0 0 512 512" enable-background="new 0 0 512 512" xml:space="preserve"><path id="checkbox-3-icon" fill="#000" d="M81,81v350h350V81H81z M227.383,345.013l-81.476-81.498l34.69-34.697l46.783,46.794l108.007-108.005 l34.706,34.684L227.383,345.013z"/></svg>');
}
input[type=checkbox]:not(:checked) {
    background-image: url('data:image/svg+xml;utf8,<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 512 512" enable-background="new 0 0 512 512" xml:space="preserve"> <path id="checkbox-9-icon" d="M391,121v270H121V121H391z M431,81H81v350h350V81z"></path> </svg>');
}
.boa h5{
    font-size: 21px;
    text-decoration: underline;
    color: #080808;
    font-family: inherit;
    }
   @media (min-width: 992px){
   .ore{
    width: 20% !important;
    } 
   } 
  .bo2{
    width: 20px;
    height: 20px;
    border: 1px solid #a7a1a1;
    background: #fff;
    border-radius: 2px;
    } 
    
  </style>
    </head>
    <body>
	<div class="se-pre-con"></div>
	<div id="page-content">
		<!-- navber -->
		    <nav id="mainNav" class="navbar navbar-fixed-top" style="background: #fff;">
			<jsp:include page="homeTop.jsp"></jsp:include>
		    </nav>
		      <div class="tour-inner" id="top2">
			  <div class="container-fluid">
			  <div class="row">
			
				<!--============================= search page ======================= -->
				
				      <div class="col-md-12" style="background: #fff; margin-bottom: 10px;">
                      <div class="col-sm-12 col-md-11 boa">
                      <h5>Search Results</h5>
                      </div>
                      <div class="col-sm-12 col-md-1 bo3">
                      <a href="#">
                      <div id="txtHint3" class="bo8">       
                        0
                      </div> 
                      <i class="fa fa-shopping-cart"></i><span>Cart</span>
                      </a>
                      </div>
                      </div>
				   <div class="clearfix" style="background: #fff;"> </div>
				<!--==================== end search page =========================  -->
				
				<!--========================= spare tooles ===================== -->

				    <div class="col-md-12 car1" style="background: #fff;">
				    <div class="row">
					<div class="col-sm-12 col-md-2" style="padding-right: 0px;">
						<form autocomplete="off"  action="./SearchHSpareParts" method="post">
							<div class="sidber-box cats-facility">
								<div class="cats-title">Filter</div>
								<div class="facility" style="padding:5px">

									<%
										String city = (String) request.getAttribute("city");
										String vehicleBrand = (String) request.getAttribute("vehicleBrand");
										String vehicleType = (String) request.getAttribute("vehicleType");
										String vehicleModel = (String) request.getAttribute("vehicleModel");
										String category = (String) request.getAttribute("category");
										String subCategory = (String) request.getAttribute("subCategory");
										String spName = (String) request.getAttribute("spName");
										String partNo = (String) request.getAttribute("partNo");
										String companyName = (String) request.getAttribute("companyName");
										String modelYear = (String) request.getAttribute("modelYear");
									%>
									<div class="select-filters" style="margin-bottom: 5px;">
										<select name="vehicleType" class="form-control" id="spBrand" onchange="getVehicleBrand(this.value)">
											<option style="display: none;" value="SELECT">Vehicle Type</option>
											<option value="4,2,">All</option>
											<option value="2,">TWO WHEELER</option>
											<option value="4,">FOUR WHEELER</option>
										</select>
									</div>
									<div class="select-filters" style="margin-bottom: 5px;" id="txtHint10">
										<select name="vehicleBrand" class="form-control">
											<option style="display: none;" value="SELECT"><%=((vehicleBrand.equals("SELECT")?"Vehicle Brand":vehicleBrand))%></option>
										</select>
									</div>
									<div class="select-filters" style="margin-bottom: 5px;" id="txtHint11">
										<select name="vehicleModel" class="form-control">
											<option style="display: none;" value="SELECT"><%=((vehicleModel.equals("SELECT")?"Vehicle Model":vehicleModel))%></option>
										</select>
									</div>
									<%
										GetSparePartsDetails spd = new GetSparePartsDetails();
										ArrayList<SpareParts> spC = spd.getCategory();
										Iterator itspc = spC.iterator();
									%>
									<div class="select-filters" style="margin-bottom: 5px;">
											<jsp:include page="./getCategory.jsp" />
									</div>
									<div class="select-filters" style="margin-bottom: 5px;" id="txtHint12">
										<select name="subCategory" class="form-control">
											<option style="display: none;" value="SELECT"><%=((subCategory.equals("SELECT")?"Sub Category":subCategory))%></option>
										</select>
									</div>
									<%
										ArrayList<BusinessOwnerRegister> spdAl = spd.getCity();
										Iterator itsp = spdAl.iterator();
										StringBuffer sb1 = new StringBuffer();
    									sb1.append("[");
    									for(int i=0;i<spdAl.size();i++)
    									{
    										BusinessOwnerRegister bocity = (BusinessOwnerRegister) spdAl.get(i);
    										sb1.append("\"").append(bocity.getB_CITY()).append("\"");
    							            if (i + 1 < spdAl.size()) {
    							                sb1.append(",");
    							            }
    									}
    									sb1.append("]");
    							        String bocities = sb1.toString();
									%>
									<%-- <div class="select-filters" style="margin-bottom: 5px;">
										<select name="city" class="form-control">
											<option value="SELECT" style="display: none;"><%=((city.equals("SELECT")?"City":city))%></option>
											<option value="All">All</option>
											<%
												while (itsp.hasNext()) {
													BusinessOwnerRegister spCity = (BusinessOwnerRegister) itsp.next();
											%>
											<option value="<%=spCity.getB_CITY()%>"><%=spCity.getB_CITY()%></option>
											<%
												}
											%>
										</select>
									</div> --%>
									
									
									 <div class="autocomplete" style="width:100%; border-radius: 4px;  border: 1px solid #ddd; padding:0px 4px; margin:5px 0;">
									 <input id="myInput" type="text" name="city" placeholder="City" style=" border: 1px solid #fff; margin:1px 0;">
                                     </div>
									
									<button type="submit"
										style="float: right; padding-top: 10px; padding-bottom: 10px; margin-bottom: 10px; padding-left: 10px; padding-right: 10px;"
										class="thm-btn">Go&nbsp;&rarr;</button>
									<br> <font><b>Advance Search</b></font>
									<!--================ autocomplate ==================-->
									    <div class="autocomplete" style="width:100%; border-radius: 4px;  border: 1px solid #ddd; padding:0px 4px; margin:5px 0;"> 
									    <input id="sort-price"
											onchange="this.form.submit()" type="text" name="spName" placeholder="Spare Part Name" style="width:100%; border-radius: 4px; border: 1px solid #fff; margin: 3px 0px;">
									    </div>
									<!--================ end autocomplate ====================-->
									<%
									ArrayList<SpareParts> spN = spd.getSparePartName();
									
									StringBuffer sb = new StringBuffer();
									sb.append("[");
									for(int i=0;i<spN.size();i++)
									{
										SpareParts spna = (SpareParts) spN.get(i);
										sb.append("\"").append(spna.getSP_NAME()).append("\"");
							            if (i + 1 < spN.size()) {
							                sb.append(",");
							            }
									}
									sb.append("]");
							        String spareparts = sb.toString();
									%>
									
									
									<%-- <div class="select-filters" style="margin-bottom: 5px;">
										<select name="spName" id="sort-price"
											onchange="this.form.submit()">
											<option selected disabled style="display: none;"><%=((spName==null?"Spare Part Name":spName))%></option>
											<!-- 											<option value="0">0 to 80000 Kms & above</option> -->
										<%
												Iterator ipNM = spN.iterator();
												while (ipNM.hasNext()) {
													SpareParts sppn = (SpareParts) ipNM.next();
													
											%>
											<option value="<%=sppn.getSP_NAME()%>"><%=sppn.getSP_NAME()%></option>
											<%
												}
											%>
										</select>
									</div> --%>
									<%
									ArrayList<SpareParts> spp = spd.getPartNo();
									Iterator ip = spp.iterator();
										
									%>
									<div class="select-filters" style="margin-bottom: 5px;">
										<select name="partNo" id="sort-price"
											onchange="this.form.submit()">
											<option selected disabled style="display: none;"><%=((partNo==null?"Part No":partNo))%></option>
											
											<%-- <%=((color==null?"Color":color)) %> --%>
											<%
												while (ip.hasNext()) {
													SpareParts sppn = (SpareParts) ip.next();
											%>
											<option value="<%=sppn.getPARTNO()%>"><%=sppn.getPARTNO()%></option>
											<%
												}
											%>
										</select>
									</div>
									<%
									ArrayList<SpareParts> spMc = spd.getCompanyName();
									Iterator ipM = spMc.iterator();
										
									%>
									<div class="select-filters" style="margin-bottom: 5px;">
										<select name="companyName" id="sort-price"
											onchange="this.form.submit()">
											<option selected disabled style="display: none;"><%=((companyName==null?"Manufacturer Name":companyName))%></option>
											<%
												while (ipM.hasNext()) {
													SpareParts sppn = (SpareParts) ipM.next();
											%>
											<option value="<%=sppn.getMANUFACTURE_COMPANY_NAME()%>"><%=sppn.getMANUFACTURE_COMPANY_NAME()%></option>
											<%
												}
											%>
										</select>
									</div>
									<%
									ArrayList<SpareParts> spMY = spd.getModelYear();
									Iterator ipMY = spMY.iterator();
									%>
									<div class="select-filters" style="margin-bottom: 5px;">
										<select name="modelYear" id="sort-price"
											onchange="this.form.submit()">
											<option selected disabled style="display: none;"><%=((modelYear==null?"Model Year":modelYear))%></option>
												<%
												while (ipMY.hasNext()) {
													SpareParts sppn = (SpareParts) ipMY.next();
											%>
											<option value="<%=sppn.getMODEL_YEAR()%>"><%=sppn.getMODEL_YEAR()%></option>
											<%
												}
											%>
						</select>
						</div>
						</div>
						</div>
						
						</form>

				<div class="sidber-box help-widget">
			    <i class="flaticon-photographer-with-cap-and-glasses"></i>
				<h4>Need <span>Help?</span>
				</h4>
				<a href="#" class="phone">040 - 48510133</a> <small>Monday
				to Saturday 9.00am - 7.30pm</small>
				</div>
				</div>
			    
         <!--========================= end side bar section ===================== -->

	<!--========================= left bar section ===================== -->		
			    <div class="col-sm-12 col-md-10" style="padding: 0 0;">
				<div class="col-md-12" style="padding: 0 0;">
				<%
					ArrayList<SpareParts> spDetails = (ArrayList<SpareParts>) request.getAttribute("spDetails");
					if (spDetails.isEmpty()) {
				%>
				<p style="color: red">Data Not available...</p>
				<%
					} else {
					}
				%>

				<%
					int j = 1,k=1;
				%>
				<c:forEach var="spDetails" items="${spDetails}">

					<%
						for (int i = 0; i < 1; i++) {
					%>
					
					<div class="col-xs-12 col-sm-6 col-md-2 ore" style="padding: 0 5px;">
					<div class="well8" style="background:white; padding: 0 0;">
						<%-- <img class="zoomin" src="data:image/png;base64,${spDetails.IMAGE}" style="width:100%;height:175px">
						<br> <br> 
<!-- 						<em	class="text-primary">Business Name:</em>  -->
						
						<a href="./DealerUsedCar?dealerName=<%=bean1.getEMAIL_ID() %>&vehicleType=<%=vehicleType1.equals("SELECT")?bean1.getVEHICLE_TYPE() :bean1.getVEHICLE_TYPE().equals("4,2,")?vehicleType1:bean1.getVEHICLE_TYPE() %>&name=<%=bean1.getNAME() %>" ><u><%=bean1.getNAME() %></u></a>
						
						<abbr title="clickme"><a data-toggle="modal" data-target="#myModal3<%=k%>">
						<b><c:out value="${spDetails.BUSINESS_NAME}"></c:out></b></a></abbr><br> --%>
						<div class="row">
						<div class="col-md-9 col-xs-8 box1">
						 <p class="spa"><em class=" p-3 mb-2 btn-warning text-white"> 
						<c:set var="price" value='${spDetails.PRICE}' />
						<%
							String price = (String) pageContext.getAttribute("price");
							%>
						<!-- &#8377; -->  <%=(price==""?"Call Us":"Price :<i class='fa fa-inr'></i> "+price)%> </em>
						</em></p>
						</div>
						<div class="col-md-2 col-xs-4 box1" style="margin: 6px 0;">
			            <input type="checkbox" title="Add to Cart" name="vehicle" onchange="addtocart(this.value)" value="1" class="bo2">
			            </div>
						</div>
						
						<div class="row" id="spe1">
						<em	class="text-primary">Name:</em>
						<a href="" data-toggle="modal" data-target="#myModal" style="font-size:15px; color:#000; text-decoration:underline;"><c:out value="${spDetails.SP_NAME}"></c:out></a>
						</div>
						
						<div class="row" id="spe1">
					   <em class="text-primary">SKU:</em>
						<c:out value="${spDetails.SKU}"></c:out>
						</div>
						
						<div class="row" id="spe1">
						<em class="text-primary">Brand: </em>
						<c:out value="${spDetails.VEHICLE_BRAND}"></c:out>
						</div>
						
						<div class="row" id="spe1">
						<em class="text-primary">Model:</em>
						<c:out value="${spDetails.VEHICLE_MODEL}"></c:out>
						</div>
						
						<div class="row" id="spe1">
						<em class="text-primary">Mfd. By:</em>
						<c:set var="mfdby1" value='${spDetails.MANUFACTURE_COMPANY_NAME}' />
						
						<%
						String mfdby = (String) pageContext.getAttribute("mfdby1");
						if(mfdby.length()>10)
						{
						%>
						<div class="tooltip1">
					   <span class="tooltiptext1"><%=mfdby%></span>
					   <%=mfdby.substring(0, 10)%>...
					   </div>
						<%
						}
						else
						{%>
							<c:out value="${spDetails.MANUFACTURE_COMPANY_NAME}"></c:out>
						<%}
						%>
						<c:out value="${spDetails.MANUFACTURE_COMPANY_NAME}"></c:out>
						
						</div>
						
						<div class="row" id="spe1">
						<em class="text-primary">Vehicle Type:</em>
						<c:out value="${spDetails.VEHICLE_TYPE}"></c:out>WHEELER 
						</div>
						
						<div class="row" id="spe1">
						<em class="text-primary">Category:</em>
						<c:out value="${spDetails.CATEGORY}"></c:out>
						</div>
						
						<div class="row" id="spe1">
						<em class="text-primary">Order Quantity:</em>
						<input type="text" id="username" name="username" placeholder="" class="cart">
						</div>
						
						
						<%-- <br><em style="color: red">Category:</em>
						<c:out value="${spDetails.USER_NAME}"></c:out> --%>
						<div class="row" align="center" style="margin:0px 0px; margin-top: 11px;">
						<a href="#myModal24<%=j%>" role="button" data-toggle="modal">
						<button type="button" class="btn btn-primary">More Details</button>
						</a>
						</div>
						
						<div id="myModal24<%=j%>" class="modal fade" role="dialog">
							<div class="modal-dialog">
								<div class="modal-content" style="80px">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class="modal-body">
										<c:set var="sku" value='${spDetails.SKU}'/>
										 <%
											String sku = (String) pageContext.getAttribute("sku");
													GetSparePartsDetails spde = new GetSparePartsDetails();
													SpareParts sps = spde.getSparePartDetails(sku);
										%>
										<!-- 																<div class="container"> -->

										<h2 align="center" style="color: #663399">SPARE PART
											DETAILS</h2>

										<table class="table table-striped" border="1">
											<tbody style="background-color: beige;">
												<tr>
													<th class="text-primary">PHOTO</th>
													<td><img class="colc2"
														src="data:image/png;base64,<%=sps.getIMAGE()%>"
														style="width: 100%; height: 100px" alt="No image"
														class="img-responsive"></td>
												</tr>
												<tr>
													<th class="text-primary"">SKU</th>
													<td><%=sps.getSKU()%></td>
												</tr>
												<tr>
													<th class="text-primary">PART NAME</th>
													<td><%=sps.getSP_NAME()%></td>
												</tr>
												<tr>
													<th class="text-primary">VEHICLE TYPE</th>
													<td><%=sps.getVEHICLE_TYPE()%>WHEELER</td>
												</tr>
												<tr>
													<th class="text-primary">VEHICLE BRAND</th>
													<td><%=sps.getVEHICLE_BRAND()%></td>
												</tr>
												<tr>
													<th class="text-primary">VEHICLE MODEL</th>
													<td><%=sps.getVEHICLE_MODEL()%></td>
												</tr>
												<tr>
													<th class="text-primary">MODEL YEAR</th>
													<td><%=sps.getMODEL_YEAR()%></td>
												</tr>
												<tr>
													<th class="text-primary">PART NO</th>
													<td><%=sps.getPARTNO()%></td>
												</tr>
												<tr>
													<th class="text-primary">COMPANY NAME</th>
													<td><%=sps.getMANUFACTURE_COMPANY_NAME()%></td>
												</tr>
												<tr>
													<th class="text-primary">CATEGORY</th>
													<td><%=sps.getCATEGORY()%></td>
												</tr>
												<tr>
													<th class="text-primary">SUB CATEGORY</th>
													<td><%=sps.getSUB_CATEGORY()%></td>
												</tr>
												<tr>
													<th class="text-primary">SPECIFICATIONS</th>
													<td><%=sps.getSPECIFICATIONS()%></td>
												</tr>
												<tr>
													<th class="text-primary">DESCRIPTION</th>
													<td><%=sps.getDESCRIPTION()%></td>
												</tr>
												<tr>
													<th class="text-primary">WARRANTY</th>
													<td><%=sps.getWARRANTY()%>yr</td>
												</tr>
												<tr>
													<th class="text-primary">PRICE</th>
													<td><%=sps.getPRICE()%></td>
												</tr>
												<tr>
													<th class="text-primary">DELIVERY METHOD</th>
													<td><%=sps.getDELEVERY_METHOD()%></td>
												</tr>
											</tbody>
										</table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div> 
						 <!-- Modal -->
						<div id="myModal3<%=k%>" class="modal fade" role="dialog">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class="modal-body">
													<c:set var="email" value='${spDetails.USER_NAME}' />
																<%
																	String email = (String) pageContext.getAttribute("email");
																BusinessOwnerService bos = new BusinessOwnerService();
																BusinessOwnerRegister bor = bos.getAddressDetails(email);
																%>
																
																	<h2 align="center" style="color: #663399">BUSENESS OWNER DETAILS</h2>
																
																<table class="table table-striped" border="1">
																	<tbody style="background-color: beige;">
																		<tr>
																			<th class="text-primary">PHOTO</th>
																			<td><img class="colc2"
																				src="data:image/png;base64, <%=bor.getPHOTO()%>"
																				style="width:100%;height:100px" alt="No image"
																				class="img-responsive"></td>
																		</tr>
																		<tr>
																			<th class="text-primary">BUSINESS NAME</th>
 																			<td><%=bor.getBUSINESS_NAME()%></td>
																		</tr>
																		<tr>
																			<th class="text-primary">ADDRESS</th>
																			<td><%=bor.getADDRESS()%></td>
																		</tr>
																		<tr>
																			<th class="text-primary">BUSINESS CITY</th>
 																			<td><%=bor.getB_CITY()%></td> 
																		</tr>
																		<tr>
																			<th class="text-primary">LOCATION</th>
																			<td><%=bor.getLOCATION()%></td>
																		</tr>
																		<tr>
																			<th class="text-primary">STATE</th>
																			<td><%=bor.getSTATE()%></td>
																		</tr>
																		<tr>
																			<th class="text-primary">DISTRICT</th>
																			<td><%=bor.getDISTRICT()%></td>
																		</tr>
																		<tr>
																			<th class="text-primary">OFFICE PHONE NO</th>
																			<td><%=bor.getOFFICE_PHONE_NO()%></td>
																		</tr>
																		<tr>
																			<th class="text-primary">PINCODE</th>
																			<td><%=bor.getOFFICE_PINCODE_NO()%></td>
																		</tr>
																	</tbody>
																</table>
															</div>
									<div class="modal-footer">
										<button class="btn btn-default" data-dismiss="modal"
											aria-hidden="true">Close</button>
									</div>
								</div>
							</div>
						</div>
						<br>
					</div>
					</div>
					<%
						j++;k++;
					%>
					<%
						}
					%>
				</c:forEach>
				</div>
			</div>
			</div>
			</div>
			
			</div>
			</div>
			</div>
			</div>
			
		<div class="clearfix"> </div>

	   <!--=============== end total section ================ -->  
	        <div class="col-md-2" style="padding:0px 0px;"></div>
	        	        <div class="col-md-10">
							     <br>
			<nav aria-label="Page navigation example">
			   <ul class="pagination justify-content-end">
			   <li class="page-item disabled">
			   <a class="page-link" href="#" tabindex="-1">Previous</a>
			   </li>
			   <li class="page-item"><a class="page-link" href="#">1</a></li>
			   <li class="page-item"><a class="page-link" href="#">2</a></li>
			   <li class="page-item"><a class="page-link" href="#">3</a></li>
			   <li class="page-item">
			   <a class="page-link" href="#">Next</a>
			   </li>
			   </ul>
			   </nav>
		</div>
	             <div class="clearfix"> </div>
	           <!--===============  section ================ -->   
			        
				  <%--   <c:forEach begin="1" end="${noOfPages}" var="m">
					<div class="col-sm-1 col-md-1" style="margin-left: -22px; width: 40px;">
				        <form id="myfor<%=i %>" method="post" action="./SearchUsedCar">
					    <input type="hidden" name="vehicleType" value="4" /> <input
						type="hidden" name="carBrand"
						value="<%=carBrand1==null?"SELECT":carBrand1%>" /> <input
						type="hidden" name="carModel"
						value="<%=carModel==null?"SELECT":carModel%>" /> <input
						type="hidden" name="carAge" value="<%=carAge%>" /> <input
						type="hidden" name="colors" value="<%=color%>" /> <input
						type="hidden" name="fuelType" value="<%=fuelType%>" />
					    <input type="hidden" name="kms" value="<%=kms%>" /> <input
						type="hidden" name="transmission"
						value="<%=transmission%>" /> <input type="hidden"
						name="carBudget"
						value="<%=budget==null?"SELECT":budget%>" /> <input
						type="hidden" name="city"
						value="<%=city1==null?"SELECT":city1%>" /> <input
						type="hidden" name="lHPrice" value="<%=range%>" /> <input
						type="hidden" name="page" value="${m}" /> <a
						onclick="document.getElementById('myfor<%=i %>').submit();"
						style="cursor: pointer;"><c:out value="${m}"></c:out>&nbsp;&nbsp;</a>
				        </form>
					</div>
				    </c:forEach> --%>
			       
			           
			              <!--=================== popup =================-->
			                 <div class="modal fade" id="myModal" role="dialog">
                             <div class="modal-dialog modal-sm">
                             <div class="modal-content">
                             <div class="modal-header">
                             <button type="button" class="close" data-dismiss="modal">&times;</button>
                             <h4 class="modal-title">Search spare parts</h4>
                             </div>
                             <div class="modal-body">
                             <img src="./images/s1.jpg" class="img-respance" style="padding: 0 60px;">
                             </div>
                             <div class="modal-footer">
                             <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						     </div>
						     </div>
						     </div>
						     </div>
             <!--=================== end popup =================-->
  
			    <!--=============== end section ================ -->    
      <div class="clearfix"> </div>
       <!--=============== footer section ================ -->  
		    <footer>
			<jsp:include page="footer.jsp"></jsp:include>
		    </footer>
	 <!--=============== end footer section ================ -->  
	 
	<script src="assets/js/jquery.min.js" type="text/javascript"></script>
	<!-- jquery ui js -->
	<script src="assets/js/jquery-ui.min.js" type="text/javascript"></script>
	<!-- bootstrap js -->
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- fraction slider js -->
	<script src="assets/js/jquery.fractionslider.js" type="text/javascript"></script>
	<!-- owl carousel js -->
	<script src="assets/owl-carousel/owl.carousel.min.js"
		type="text/javascript"></script>
	<!-- counter -->
	<script src="assets/js/jquery.counterup.min.js" type="text/javascript"></script>
	<script src="assets/js/waypoints.js" type="text/javascript"></script>
	<!-- filter portfolio -->
	<script src="assets/js/jquery.shuffle.min.js" type="text/javascript"></script>
	<script src="assets/js/portfolio.js" type="text/javascript"></script>
	<!-- magnific popup -->
	<script src="assets/js/jquery.magnific-popup.min.js"
		type="text/javascript"></script>
	<!-- range slider -->
	<script src="assets/js/ion.rangeSlider.min.js" type="text/javascript"></script>
	<script src="assets/js/jquery.easing.min.js" type="text/javascript"></script>
	<!-- custom -->
	<script src="assets/js/custom.js" type="text/javascript"></script>
	<!-- google map -->
	<script src="js/SparepartsAutocomplete.js" type="text/javascript"></script>
	<script>
		//range slide
		$("#range").ionRangeSlider({
			type : "double",
			grid : true,
			min : 0,
			max : 200,
			from : 50,
			to : 150,
			prefix : "$"
		});
	</script>
	<script>
		function getVehicleBrand(str) {
			if (str == "") {
				document.getElementById("txtHint10").innerHTML = "";
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
					document.getElementById("txtHint10").innerHTML = xmlhttp.responseText;
				}
			}
			xmlhttp.open("GET", "./vehicleSpBrand.jsp?spBrand=" + str, true);
			xmlhttp.send();
		}
	</script>
	<script>
		function getVehicleModel(str) {
			if (str == "") {
				document.getElementById("txtHint11").innerHTML = "";
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
					document.getElementById("txtHint11").innerHTML = xmlhttp.responseText;
				}
			}
			xmlhttp.open("GET", "./getVehicleModels.jsp?brand=" + str, true);
			xmlhttp.send();
		}
	</script>

	<script>
		function getSpSubCategory(str) {
			if (str == "") {
				document.getElementById("txtHint12").innerHTML = "";
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
					document.getElementById("txtHint12").innerHTML = xmlhttp.responseText;
				}
			}
			xmlhttp.open("GET", "./getSpSubCategory.jsp?spCategory=" + str, true);
			xmlhttp.send();
		}
	</script>
	

<!--======= auto ==============-->
  
<script>
function autocomplete(inp, arr) {
  /*the autocomplete function takes two arguments,
  the text field element and an array of possible autocompleted values:*/

  var currentFocus;
  /*execute a function when someone writes in the text field:*/
  inp.addEventListener("input", function(e) {
      var a, b, i, val = this.value;
      /*close any already open lists of autocompleted values*/
      closeAllLists();
      if (!val) { return false;}
      currentFocus = -1;
      /*create a DIV element that will contain the items (values):*/
      a = document.createElement("DIV");
      a.setAttribute("id", this.id + "autocomplete-list");
      a.setAttribute("class", "autocomplete-items");
      /*append the DIV element as a child of the autocomplete container:*/
      this.parentNode.appendChild(a);
      /*for each item in the array...*/
      for (i = 0; i < arr.length; i++) {
        /*check if the item starts with the same letters as the text field value:*/
        if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
          /*create a DIV element for each matching element:*/
          b = document.createElement("DIV");
          /*make the matching letters bold:*/
          b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
          b.innerHTML += arr[i].substr(val.length);
          /*insert a input field that will hold the current array item's value:*/
          b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
          /*execute a function when someone clicks on the item value (DIV element):*/
          b.addEventListener("click", function(e) {
              /*insert the value for the autocomplete text field:*/
              inp.value = this.getElementsByTagName("input")[0].value;
              /*close the list of autocompleted values,
              (or any other open lists of autocompleted values:*/
              closeAllLists();
          });
          a.appendChild(b);
        }
      }
  });
  /*execute a function presses a key on the keyboard:*/
  inp.addEventListener("keydown", function(e) {
      var x = document.getElementById(this.id + "autocomplete-list");
      if (x) x = x.getElementsByTagName("div");
      if (e.keyCode == 40) {
        /*If the arrow DOWN key is pressed,
        increase the currentFocus variable:*/
        currentFocus++;
        /*and and make the current item more visible:*/
        addActive(x);
      } else if (e.keyCode == 38) { //up
        /*If the arrow UP key is pressed,
        decrease the currentFocus variable:*/
        currentFocus--;
        /*and and make the current item more visible:*/
        addActive(x);
      } else if (e.keyCode == 13) {
        /*If the ENTER key is pressed, prevent the form from being submitted,*/
        e.preventDefault();
        if (currentFocus > -1) {
          /*and simulate a click on the "active" item:*/
          if (x) x[currentFocus].click();
        }
      }
  });
  function addActive(x) {
    /*a function to classify an item as "active":*/
    if (!x) return false;
    /*start by removing the "active" class on all items:*/
    removeActive(x);
    if (currentFocus >= x.length) currentFocus = 0;
    if (currentFocus < 0) currentFocus = (x.length - 1);
    /*add class "autocomplete-active":*/
    x[currentFocus].classList.add("autocomplete-active");
  }
  function removeActive(x) {
    /*a function to remove the "active" class from all autocomplete items:*/
    for (var i = 0; i < x.length; i++) {
      x[i].classList.remove("autocomplete-active");
    }
  }
  function closeAllLists(elmnt) {
    /*close all autocomplete lists in the document,
    except the one passed as an argument:*/
    var x = document.getElementsByClassName("autocomplete-items");
    for (var i = 0; i < x.length; i++) {
      if (elmnt != x[i] && elmnt != inp) {
        x[i].parentNode.removeChild(x[i]);
      }
    }
  }
  /*execute a function when someone clicks in the document:*/
  document.addEventListener("click", function (e) {
      closeAllLists(e.target);
  });
}

/*An array containing all the country names in the world:*/

var countries = <%=spareparts%>//["Afghanistan","Albania","Algeria","Andorra","Angola","Anguilla","Antigua & Barbuda","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia & Herzegovina","Botswana","Brazil","British Virgin Islands","Brunei","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Cayman Islands","Central Arfrican Republic","Chad","Chile","China","Colombia","Congo","Cook Islands","Costa Rica","Cote D Ivoire","Croatia","Cuba","Curacao","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Falkland Islands","Faroe Islands","Fiji","Finland","France","French Polynesia","French West Indies","Gabon","Gambia","Georgia","Germany","Ghana","Gibraltar","Greece","Greenland","Grenada","Guam","Guatemala","Guernsey","Guinea","Guinea Bissau","Guyana","Haiti","Honduras","Hong Kong","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Isle of Man","Israel","Italy","Jamaica","Japan","Jersey","Jordan","Kazakhstan","Kenya","Kiribati","Kosovo","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macau","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro","Montserrat","Morocco","Mozambique","Myanmar","Namibia","Nauro","Nepal","Netherlands","Netherlands Antilles","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","North Korea","Norway","Oman","Pakistan","Palau","Palestine","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Puerto Rico","Qatar","Reunion","Romania","Russia","Rwanda","Saint Pierre & Miquelon","Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Korea","South Sudan","Spain","Sri Lanka","St Kitts & Nevis","St Lucia","St Vincent","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Timor L'Este","Togo","Tonga","Trinidad & Tobago","Tunisia","Turkey","Turkmenistan","Turks & Caicos","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States of America","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Virgin Islands (US)","Yemen","Zambia","Zimbabwe"];

/*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
autocomplete(document.getElementById("sort-price"), countries);
</script>
<!--=========== end auto ==============-->
<!--============= city sction ================-->

<script>
function autocomplete1(inp, arr) {
  /*the autocomplete function takes two arguments,
  the text field element and an array of possible autocompleted values:*/
  var currentFocus;
  alert("Cities : "+bocities);
  /*execute a function when someone writes in the text field:*/
  inp.addEventListener("input", function(e) {
      var a, b, i, val = this.value;
      /*close any already open lists of autocompleted values*/
      closeAllLists();
      if (!val) { return false;}
      currentFocus = -1;
      /*create a DIV element that will contain the items (values):*/
      a = document.createElement("DIV");
      a.setAttribute("id", this.id + "autocomplete-list");
      a.setAttribute("class", "autocomplete-items");
      /*append the DIV element as a child of the autocomplete container:*/
      this.parentNode.appendChild(a);
      /*for each item in the array...*/
      for (i = 0; i < arr.length; i++) {
        /*check if the item starts with the same letters as the text field value:*/
        if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
          /*create a DIV element for each matching element:*/
          b = document.createElement("DIV");
          /*make the matching letters bold:*/
          b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
          b.innerHTML += arr[i].substr(val.length);
          /*insert a input field that will hold the current array item's value:*/
          b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
          /*execute a function when someone clicks on the item value (DIV element):*/
          b.addEventListener("click", function(e) {
              /*insert the value for the autocomplete text field:*/
              inp.value = this.getElementsByTagName("input")[0].value;
              /*close the list of autocompleted values,
              (or any other open lists of autocompleted values:*/
              closeAllLists();
          });
          a.appendChild(b);
        }
      }
  });
  /*execute a function presses a key on the keyboard:*/
  inp.addEventListener("keydown", function(e) {
      var x = document.getElementById(this.id + "autocomplete-list");
      if (x) x = x.getElementsByTagName("div");
      if (e.keyCode == 40) {
        /*If the arrow DOWN key is pressed,
        increase the currentFocus variable:*/
        currentFocus++;
        /*and and make the current item more visible:*/
        addActive(x);
      } else if (e.keyCode == 38) { //up
        /*If the arrow UP key is pressed,
        decrease the currentFocus variable:*/
        currentFocus--;
        /*and and make the current item more visible:*/
        addActive(x);
      } else if (e.keyCode == 13) {
        /*If the ENTER key is pressed, prevent the form from being submitted,*/
        e.preventDefault();
        if (currentFocus > -1) {
          /*and simulate a click on the "active" item:*/
          if (x) x[currentFocus].click();
        }
      }
  });
  function addActive(x) {
    /*a function to classify an item as "active":*/
    if (!x) return false;
    /*start by removing the "active" class on all items:*/
    removeActive(x);
    if (currentFocus >= x.length) currentFocus = 0;
    if (currentFocus < 0) currentFocus = (x.length - 1);
    /*add class "autocomplete-active":*/
    x[currentFocus].classList.add("autocomplete-active");
  }
  function removeActive(x) {
    /*a function to remove the "active" class from all autocomplete items:*/
    for (var i = 0; i < x.length; i++) {
      x[i].classList.remove("autocomplete-active");
    }
  }
  function closeAllLists(elmnt) {
    /*close all autocomplete lists in the document,
    except the one passed as an argument:*/
    var x = document.getElementsByClassName("autocomplete-items");
    for (var i = 0; i < x.length; i++) {
      if (elmnt != x[i] && elmnt != inp) {
        x[i].parentNode.removeChild(x[i]);
      }
    }
  }
  /*execute a function when someone clicks in the document:*/
  document.addEventListener("click", function (e) {
      closeAllLists(e.target);
  });
}

/*An array containing all the country names in the world:*/
var countries = <%=bocities%>//["Afghanistan","Albania","Algeria","Andorra","Angola","Anguilla","Antigua & Barbuda","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia & Herzegovina","Botswana","Brazil","British Virgin Islands","Brunei","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Cayman Islands","Central Arfrican Republic","Chad","Chile","China","Colombia","Congo","Cook Islands","Costa Rica","Cote D Ivoire","Croatia","Cuba","Curacao","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Falkland Islands","Faroe Islands","Fiji","Finland","France","French Polynesia","French West Indies","Gabon","Gambia","Georgia","Germany","Ghana","Gibraltar","Greece","Greenland","Grenada","Guam","Guatemala","Guernsey","Guinea","Guinea Bissau","Guyana","Haiti","Honduras","Hong Kong","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Isle of Man","Israel","Italy","Jamaica","Japan","Jersey","Jordan","Kazakhstan","Kenya","Kiribati","Kosovo","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macau","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro","Montserrat","Morocco","Mozambique","Myanmar","Namibia","Nauro","Nepal","Netherlands","Netherlands Antilles","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","North Korea","Norway","Oman","Pakistan","Palau","Palestine","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Puerto Rico","Qatar","Reunion","Romania","Russia","Rwanda","Saint Pierre & Miquelon","Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Korea","South Sudan","Spain","Sri Lanka","St Kitts & Nevis","St Lucia","St Vincent","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Timor L'Este","Togo","Tonga","Trinidad & Tobago","Tunisia","Turkey","Turkmenistan","Turks & Caicos","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States of America","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Virgin Islands (US)","Yemen","Zambia","Zimbabwe"];

/*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
autocomplete(document.getElementById("myInput"), countries);
</script>


<!--============ end city section ===============-->

</body>
</html>
