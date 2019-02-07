<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html2/loose.dtd">
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
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./carMenu.jsp" />
  <%-- <jsp:include page="./right-side.jsp" /> --%>
  <jsp:include page="./topMenu.jsp" />
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
	function showBrand(str) {
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
		xmlhttp.open("GET", "./getCarModel.jsp?brandid=" + str, true);
		xmlhttp.send();

	}
</script>
<script>
	function showModel(str) {
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
		xmlhttp.open("GET", "./usedCarCity.jsp?carModel=" + str, true);
		xmlhttp.send();
	}
</script>
</head>
<body>


	<div class="main-wrapper">
		<div class="app" id="app">

			<header class="" style="font-family: 'Oswald', sans-serif;">
			<!-- <div class="col-md-6 col-sm-12 col-xs-12">
				<div class="brand" style="color: white; font-size: 23px;">
					<h2>
						Vaahan<span style="color: #fec107;">Mitra
					</h2>
					</span>
				</div>
			</div>
			<div class="col-md-4"></div>
			<div class="col-md-2 col-xs-12 col-sm-12">
				<div class="dropdown pull-right">
					<button class="btn  dropdown-toggle" type="button"
						data-toggle="dropdown" style="background-color: #fec107">
						Santhosh <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">

						<li><a class="dropdown-item" href="#"> <i
								class="fa fa-power-off icon"></i> Logout
						</a></li>
					</ul>
				</div>
			</div> -->
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
					style="background-color:#fff"> <section class="section">
				<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
		<div  align="center"><h3>SERVICE CENTER DASHBOARD</h3></div>
		</div>
						
			
					<div class="col-md-12 col-xs-12 col-sm-12">
						<div class="card"
							style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
							<div class="card-block" style="border-bottom: 3px solid #a3b745;">
								<section class="example">
								<div class="table-responsive">
								<%
									String message = (String) request.getAttribute("failure");
								%>
									<form action="./updateUsedVehicleProfileController"
										method="post" onSubmit="return validate()">
										<%-- <% if(message!=null){%>
                    	<h5 style="color:red"><%= message %> </h5>    
              <%}else{}%> --%>
										<div class="col-md-12">
										<div align="center" style="text-align: center; background-color: #523f6d; color: #fff;">
										CAR MODELS</div>
										<%
												String email = (String) session.getAttribute("user");
												GetUsedCarDetails requester = new GetUsedCarDetails();
												ArrayList<UsedCar> car = requester.getUsedCarId(email);
												Iterator it = car.iterator();
											%>
										</div>
										<br><br>
										<div class="col-md-12">
										
										</div>
										
										<%-- <%
												GetUsedCarDetails car = new GetUsedCarDetails();
												ArrayList<UsedCar> caral = car.getUsedCarCity();
												Iterator it = caral.iterator();
											%> --%>
										<div class="col-md-2 col-sm-12 col-xs-12" >
										Car Brand
										</div>
										<div class="col-md-4 col-sm-12 col-xs-12" >
										<jsp:include page="./getCarBrand.jsp" />
										</div>
										
										<div class="col-md-2 col-sm-12 col-xs-12" align="center" >
										Car Model
										</div>
										
										<div class="col-md-2 col-sm-12 col-xs-12" >
										<select name="carModel" class="form-control"
													id="txtHint1">
														<option value="SELECT">SELECT MODEL</option>
												</select>
										
										</div>
										<div class="col-md-2 col-sm-12 col-xs-12" align="center"  >
										<button TYPE="submit"
														style="background-color: #a3b725; border: 1px solid #a3b725;"
														class="btn btn-primary">SEARCH</button>
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
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
	<script language="javascript">
		populateBrands("brand", "model");
 	</script>
	<pre>
 	</pre>
	<footer>Copyright &copy; vehicletracking.com</footer>
</body>
</html>
