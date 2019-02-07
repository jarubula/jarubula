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
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./carsandBikes.jsp"></jsp:include>
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
		xmlhttp.open("GET", "./usedBikeCity.jsp?brandid=" + brand
				+ "&bikeModel=" + str, true);
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
		xmlhttp.open("GET", "./getBikeModel.jsp?brand=" + str, true);
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
					<h3>USED VEHICLE DEALER DASHBOARD</h3>
				</div>
				<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745; border-radius: 10px">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive">
								<form action="./SearchUDUsedBike" method="GET">
									<%
										String brandid = (String) request.getAttribute("brandid");
										String user_name = (String) request.getAttribute("user_name");
										String bikeModel = (String) request.getAttribute("bikeModel");
										String city = (String) request.getAttribute("city");
										String message = (String) request.getAttribute("message");
									%>

									<div class="col-md-12" align="center"
										style="background: #523f6d; color: #f1f1f1; border-radius: 10px">USED
										BIKES LIST</div>
									<div class="col-md-12">
										<br>
									</div>

									<div class="col-md-3">
										<label><b>Bike Brand</b></label>
										<jsp:include page="./getBikeBrand.jsp" /></td>
										</div>

									<div class="col-md-3">
										<label><b>Bike Model</b></label>
										<div id="txtHint1">
												<select name="bikeModel" class="form-control">
													<option value=""><%=(bikeModel==null || bikeModel=="")?"SELECT BIKE MODEL":bikeModel%></option>
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
				</div>
				<tr>
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
								ArrayList<UsedBike> al = new ArrayList<UsedBike>();
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

										al = (ArrayList<UsedBike>)request.getAttribute("success");

									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								int x = (maxrowsperpage * page1) - maxrowsperpage;
							%>
											<%
												ArrayList<UsedBike> bikeal = (ArrayList<UsedBike>) request.getAttribute("success");
											%>
											<tr>
												<th>PHOTO</th>
												<th>BIKE REGISTRATION NUMBER</th>
												<th>BIKE BRAND</th>
												<th>BIKE MODEL</th>
												<th>CURRENT MILEAGE</th>
												<th>STARTING SYSTEM</th>
												<th>FUELTANK CAPACITY</th>
												<th>COLOR</th>
												<th>KMs DRIVEN</th>
												<th>INSURANCE COMPANY NAME</th>
												<th>HYPOTHECATION</th>
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
												<th>PINCODE</th>
												<th>OFFER PRICE</th>
												<th>BIKE ID</th>
												<!-- 												<th>UPDATE</th> -->
												<th colspan=2>STATUS</th>
											<%
												int i = 1;
												int j = 1;
											%>
															<%
								if (bikeal.size() <= 0) {
							%>
							<tr>
								<td colspan="11" align="center"><font color=red>No
										Records Found</font></td>
							</tr>
							<%
								} else {
							%>
											<c:forEach var="bikeal" items="${success}">
												<tr>
													<td><a onclick="callMe('${bikeal.BIKE_NUMBER}');">
															<img
														class="colc2" src="data:image/png;base64,${bikeal.PHOTO1}"
														onmouseover="bigImg(this)" onmouseout="normalImg(this)"
														border="0" width="85px" height="85px" alt="No image"
														class="img-rounded"
														style="cursor: pointer; transition: all.20s ease-in-out">
													</a></td>
													<td><c:out value="${bikeal.BIKE_NUMBER}"></c:out></td>
													<td><c:out value="${bikeal.BIKE_BRAND}"></c:out></td>
													<td><c:out value="${bikeal.BIKE_MODEL}"></c:out></td>
													<td><c:out value="${bikeal.CURRENT_MILEAGE}"></c:out></td>
													<td><c:out value="${bikeal.STARTING_SYSTEM}"></c:out></td>
													<td><c:out value="${bikeal.FUELTANK_CAPACITY}"></c:out></td>
													<td><c:out value="${bikeal.COLOR}"></c:out></td>
													<td><c:out value="${bikeal.KMS_DRIVEN}"></c:out></td>
													<td><c:out value="${bikeal.INSURANCE_COMPANY_NAME}"></c:out></td>
													<td><c:out value="${bikeal.HYPOTHECATION}"></c:out></td>
													<td><c:out value="${bikeal.REGISTERED_YEAR}"></c:out>
													<td><c:out value="${bikeal.REGISTERED_STATE}"></c:out></td>
													<td><c:out value="${bikeal.REGISTERED_CITY}"></c:out></td>
													<td><c:out value="${bikeal.BIKE_OWNER_NAME}"></c:out></td>
													<td><c:out value="${bikeal.USED_BY}"></c:out></td>
													<td><c:out value="${bikeal.NO_OF_OWNERS}"></c:out></td>
													<td><c:out value="${bikeal.EMAIL_ID}"></c:out></td>
													<td><c:out value="${bikeal.MOBILE_NO}"></c:out></td>
													<td><c:out value="${bikeal.ADDRESS}"></c:out></td>
													<td><c:out value="${bikeal.CITY}"></c:out></td>
													<td><c:out value="${bikeal.STATE}"></c:out></td>
													<td><c:out value="${bikeal.DISTRICT}"></c:out></td>
													<td><c:out value="${bikeal.PINCODE}"></c:out></td>
													<td><c:out value="${bikeal.OFFER_PRICE}"></c:out></td>
													<td><c:out value="${bikeal.GEN_BIKE_ID}"></c:out></td>
													<td><a href="./updateUDUsedBike.jsp?id=${bikeal.GEN_BIKE_ID}"><b>UPDATE</b></a></td>
											<form action="./InactiveUsedBike" method="post">
												<input type="hidden" name="inactive" value="UD">
												<input type="hidden" name="brandid" value="<%=brandid%>">
												<input type="hidden" name="bikeModel" value="<%=bikeModel%>">
												<input type="hidden" name="city" value="<%=city%>">
												<input type="hidden" name="page" value="<%=page1%>">
												<input type="hidden" name="vehicle" value="${bikeal.GEN_BIKE_ID}" /> 
												<input type="hidden" name="status" value="${bikeal.STATUS}" />
												<c:set var="status" value='${bikeal.STATUS}'/>
													<%
														String status = (String) pageContext.getAttribute("status");
														if(status.equals("ACTIVE")){
														%>	
														<td colspan="25" align="right">
															<input type="submit" class="btn btn-primary active" style="border-radius: 10px" value="${bikeal.STATUS}">
														</td>
													<%	
													}else{%>
													<td colspan="25" align="right">
														<input type="submit" class="btn btn-warning" style="border-radius: 10px" value="${bikeal.STATUS}">
													</td>
													<% }%>
												<%-- <td colspan="25" align="right">
												<input type="submit" style="background-color: #a3b745;border-radius: 10px" value="${caral.STATUS}">
												</td> --%>
											</form>
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
													<td><a href="./SearchUDUsedBike?page=${x}&brandid=<%=brandid%>&user_name=<%=user_name%>&bikeModel=<%=bikeModel%>&city=<%=city%>">&nbsp;${x}&nbsp;</a></td>
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
	<script type="text/javascript">
		function callMe(myId) {
			var popup = window.open('./showBikeImage.jsp?photo=' + myId,'mywindow','width=2000,height=1000,titlebar=0,status=no,toolbar=no,location=no,directories=no');
		}
	</script>
</body>
</html>