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
	import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.awt.Image,
 java.awt.image.BufferedImage,
java.io.ByteArrayInputStream,
 java.io.ByteArrayOutputStream,
 java.io.IOException,
 java.io.InputStream, javax.imageio.ImageIO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./individualOwner.jsp"></jsp:include>
<jsp:include page="./topMenu.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<!-- Theme initialization -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
<style>
.well {
    min-height: 20px;
    padding: 19px;
    margin-bottom: 20px;
    background-color: #f5f5f5;
    border: 1px solid #c0baba; !important;
    border-radius: 4px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
    box-shadow: rgba(0,0,0,.05);
    box-shadow: 0 1px 11px;  !important;
    border-radius: 7px; !important;
}

</style>
<%
String message1 = (String) request.getAttribute("popUpMessage");
//	String bikeId = (String) request.getAttribute("bikeId");
//	if (message1 != null) {
%>
<style type="text/css">
.w3-section, .w3-code {
    margin-top: 16px!important;
    margin-bottom: 16px!important;
    margin: 0 40px;
}
#overlay {
position: fixed;
top: 0;
left: 0;
width: 100%;
height: 100%;

 <%if(message1!=null){ %>
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
/*     width: 601px; */
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
    height: 34px;
    left: 49px;
    position: relative;
    top: -47px;
    width: 34px;
}
.cnt223 .x:hover{
cursor: pointer;
}
</style>
<script type='text/javascript'>
$(function(){
	 <%if(message1!=null){ %>
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
    <%if(message1!=null){ %>
  <div class='popup container'>
   <div class="col-md-3 col-sm-6"></div>
   <div class="col-md-6 col-sm-6">
<div class='cnt223 ' align="center">
<img src='images/cancel.png' alt='quit' class='x' id='x' />
<p>
<%=message1%>
<br/>
<br/>
<!-- <a href='#' class='close'> <img src='images/OK.jpg' alt='quit' class='x' id='x' /></a> -->
</p>
</div>
</div>
</div>
<%}else{} %>

<script>
	function bigImg(x) {
		x.style.height = "100px";
		x.style.width = "100px";
	}

	function normalImg(x) {
		x.style.height = "80px";
		x.style.width = "80px";
	}
</script>
<script>
	function showCity(str) {
		var brand = document.getElementById("brandid").value;
		if (str == "") {
			document.getElementById("txtHint2").innerHTML = "";
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
				document.getElementById("txtHint2").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./usedCarCity.jsp?brandid=" + brand + "&carModel="
				+ str, true);
		xmlhttp.send();
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
		xmlhttp.open("GET", "./getCarModel.jsp?brand=" + str, true);
		xmlhttp.send();
	}
</script>
<style>
.td {
	font-size: small;
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

			<div class="header-block header-block-nav"></div>
			</header>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<div class="col-md-12" align="center">
					<h3>INDIVIDUAL OWNER DASHBOARD</h3>
				</div>
				<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745; border-radius: 10px"">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive">
								<form action="./SearchIndividualUsedCarController" method="get">
									<div class="col-md-12" align="center"
										style="background: #523f6d; color: #f1f1f1; border-radius: 10px">USED
										CARS LIST</div>
									<%
										String brandid = (String) request.getAttribute("brandid");
										String user_name = (String) request.getAttribute("user_name");
										String carModel = (String) request.getAttribute("carModel");
										String city = (String) request.getAttribute("city");
										String message = (String) request.getAttribute("message");
									%>
									<div class="col-md-12">
										<br>
									</div>

									<div class="col-md-3">
										<label><b>Car Brand</b></label>
										<jsp:include page="./getCarBrand.jsp" />
									</div>

									<div class="col-md-3">
										<label><b>Car Model</b></label>
										<div id="txtHint1">
											<select name="carModel" class="form-control">
												<option value=""><%=(carModel==null || carModel=="")?"SELECT CAR MODEL":carModel%></option>
											</select>
										</div>
									</div>

									<div class="col-md-3">
										<label><b>City</b></label>
										<div id="txtHint2">
											<select name="city" class="form-control">
												<option value=""><%=(city==null || city=="")?"SELECT CITY":city %></option>
											</select>
										</div>
									</div>
									<div class="col-md-3" align="center">
										<br>
										<button
											style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
											class="btn btn-primary">SEARCH</button>
									</div>
									<br>
									<br>
									<br>&nbsp;
								</form>
							</div>
							</section>
						</div>
					</div>
				</div><tr>
					<td colspan="3"><center>
							<%
								if (message != null) {
							%>
							<h5 class="text-primary"><%=message%></h5>
							<%
								} else {
								}
							%>
						</center></td>
				</tr>
			<div class="row">
				<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;border-radius: 10px">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;border-radius: 10px">
							<section class="example">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<%
										int page1 = 0, noofrecords = 0, maxrowsperpage = 0;
										ArrayList<UsedCar> al = new ArrayList<UsedCar>();
									%>

									<%
										String returnString = "";
										try {
											returnString = request.getAttribute("returnString").toString();
											out.println(" <font color=green>" + returnString + "</font>");
										} catch (Exception e) {
										}
									%>
									<br>
									<%
										try {
											if (request.getAttribute("currentPage") != null) {
												page1 = Integer.parseInt(request.getAttribute("currentPage").toString());
												maxrowsperpage = Integer.parseInt(request.getAttribute("maxrowsperpage").toString());

												al = (ArrayList<UsedCar>) request.getAttribute("success");

											}
										} catch (Exception e) {
											e.printStackTrace();
										}
										int x = (maxrowsperpage * page1) - maxrowsperpage;
									%>
									<%
										ArrayList<UsedCar> caral = (ArrayList<UsedCar>) request.getAttribute("success");
									%>
									<tr>
										<th>PHOTO</th>
										<th>CAR REGISTRATION NUMBER</th>
										<th>CAR BRAND</th>
										<th>CAR MODEL</th>
										<th>MODEL YEAR</th>
										<th>CURRENT MILEAGE</th>
										<th>FUEL TYPE</th>
										<th>TRANSMISSION</th>
										<th>COLOR</th>
										<th>KMS DRIVEN</th>
										<th>INSURANCE COMPANY NAME</th>
										<th>REGISTERED YEAR</th>
										<th>REGISTERED STATE</th>
										<th>REGISTERED CITY</th>
										<th>CAR OWNER NAME</th>
										<th>USED BY</th>
										<th>NO OF OWNERS</th>
										<th>EMAILID</th>
										<th>MOBILE NO</th>
										<th>ADDRESS</th>
										<th>CITY</th>
										<th>STATE</th>
										<th>DISTRICT</th>
										<th>OFFER PRICE</th>
										<th>CAR ID</th>
										<th>UPDATE</th>
										<th colspan=2>STATUS</th>
									</tr>
									<%
										int i = 1;
										int j = 1;
									%>
									<%
										if (caral.size() <= 0) {
									%>
									<tr>
										<td colspan="11" align="center"><font color=red>No
												Records Found</font></td>
									</tr>
									<%
										} else {
									%>
									<c:forEach var="caral" items="${success}">
										<tr>
											<td><abbr title="clickme"><a
													onclick="callMe('${caral.CAR_NUMBER}');"> <img
														class="colc2" src="data:image/png;base64,${caral.PHOTO1}"
														onmouseover="bigImg(this)" onmouseout="normalImg(this)"
														border="0" width="85px" height="85px" alt="No image"
														class="img-responsive"
														style="cursor: pointer; transition: all.20s ease-in-out">
												</a></abbr></td>
											<td><c:out value="${caral.CAR_NUMBER}"></c:out></td>
											<td><c:out value="${caral.CAR_BRAND}"></c:out></td>
											<td><c:out value="${caral.CAR_MODEL}"></c:out></td>
											<td><c:out value="${caral.MODEL_YEAR}"></c:out></td>
											<td><c:out value="${caral.CURRENT_MILEAGE}"></c:out></td>
											<td><c:out value="${caral.FUEL_TYPE}"></c:out></td>
											<td><c:out value="${caral.TRANSIMISSION}"></c:out></td>
											<td><c:out value="${caral.COLOR}"></c:out></td>
											<td><c:out value="${caral.KMS_DRIVEN}"></c:out></td>
											<td><c:out value="${caral.INSURANCE}"></c:out></td>
											<td><c:out value="${caral.REGISTERED_YEAR}"></c:out>
											<td><c:out value="${caral.REGISTERED_STATE}"></c:out></td>
											<td><c:out value="${caral.REGISTERED_CITY}"></c:out></td>
											<td><c:out value="${caral.CAR_OWNER_NAME}"></c:out></td>
											<td><c:out value="${caral.USED_BY}"></c:out></td>
											<td><c:out value="${caral.NO_OF_OWNERS}"></c:out></td>
											<td><c:out value="${caral.EMAIL_ID}"></c:out></td>
											<td><c:out value="${caral.MOBILE_NO}"></c:out></td>
											<td><c:out value="${caral.ADDRESS}"></c:out></td>
											<td><c:out value="${caral.CITY}"></c:out></td>
											<td><c:out value="${caral.STATE}"></c:out></td>
											<td><c:out value="${caral.DISTRICT}"></c:out></td>
											<td><c:out value="${caral.OFFER_PRICE}"></c:out></td>
											<td><c:out value="${caral.GEN_CAR_ID}"></c:out></td>
											<td><a href="./updateUsedCar2.jsp?id=${caral.GEN_CAR_ID}"><b>UPDATE</b></a></td>
											<form action="./inactiveUsedCar" method="post">
												<input type="hidden" name="brandid" value="<%=brandid%>">
												<input type="hidden" name="carModel" value="<%=carModel%>">
												<input type="hidden" name="city" value="<%=city%>">
												<input type="hidden" name="page" value="<%=page1%>">
												<input type="hidden" name="inactive" value="IO">
												<input type="hidden" name="vehicle" value="${caral.GEN_CAR_ID}" /> 
												<input type="hidden" name="status" value="${caral.STATUS}" />
												<c:set var="status" value='${caral.STATUS}'/>
													<%
														String status = (String) pageContext.getAttribute("status");
														if(status.equals("ACTIVE")){
														%>	
														<td colspan="25" align="right">
															<input type="submit" class="btn btn-primary active" style="border-radius: 10px" value="${caral.STATUS}">
														</td>
													<%	
													}else{%>
													<td colspan="25" align="right">
														<input type="submit" class="btn btn-warning" style="border-radius: 10px" value="${caral.STATUS}">
													</td>
													<% }%>
												

												
												<%-- <td colspan="25" align="right">
												<input type="submit" style="background-color: #a3b745;border-radius: 10px" value="${caral.STATUS}">
												</td> --%>
											</form>
											
											<%-- <%
														String status = (String) pageContext.getAttribute("status");
														if(status.equals("ACTIVE")){
														%>	
														<td>
															<input type="submit" class="btn btn-primary active" style="border-radius: 10px" value="${spss1.STATUS}">
														</td>
													<%	
													}else{%>
													<td>
														<input type="submit" class="btn btn-warning" style="border-radius: 10px" value="${spss1.STATUS}">
													</td>
													<% }%> --%>
											
										</tr>
										<%
											i++;
													j++;
										%>
									</c:forEach>
								</table>
								<table>
									<tr>
										<td>Pages<b>:</b>
										</td>
										<c:forEach begin="1" end="${noOfPages}" var="x">
											<td><a
												href="./SearchIndividualUsedCarController?page=${x}&brandid=<%=brandid%>&user_name=<%=user_name%>&carModel=<%=carModel%>&city=<%=city%>">&nbsp;${x}&nbsp;</a></td>
										</c:forEach>
									</tr>
									<%
										}
									%>
								</table>
								</form>
							</div>
							</section>
						</div>
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
	<script type="text/javascript">
		function callMe(myId) {
			var popup = window.open('./showCarImage.jsp?photo=' + myId,'mywindow','width=2000,height=1000,titlebar=0,status=no,toolbar=no,location=no,directories=no');
		}
	</script>
</body>
</html>