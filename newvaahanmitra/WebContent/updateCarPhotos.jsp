<%
	try {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		if (session.getAttribute("user") == null) {
%>
<jsp:forward page="./login3.jsp"></jsp:forward>
<%
	} else {
		}
	} catch (Exception ex) {
		out.println(ex);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.vaahanmitra.model.Registration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<jsp:include page="./carsandBikes.jsp" />
<jsp:include page="./topMenu.jsp" />

<script src="./css/countries.js" type="text/javascript"></script>

<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
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
</head>
<body>
	<div class="main-wrapper">
		<div class="app" id="app">

			<header class="">
			<div class="header-block header-block-nav"></div>
			</header>
			<br>

			<article class="content responsive-tables-page"
				style="background-color:#fff">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div align="center" style="font-size: 25px">USED VEHICLE
					DEALER DASHBOARD</div>
			</div>
			<section class="section">

			<div class="row">

				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive">
								<form action="./UpdateCarPhotos" enctype="multipart/form-data"
									method="post">
									<div class="col-md-12 col-xs-12"
										style="background-color: #2A3F54">
										<div align="center" style="text-align: center; color: #fff;">
											<h5>UPDATE CAR PHOTOS</h5>
											<%
												String message = (String) request.getAttribute("message");
												String carNo = (String) request.getAttribute("carNo");
												String email = (String) session.getAttribute("user");
												GetUsedCarDetails requester = new GetUsedCarDetails();
												ArrayList<UsedCar> car = requester.getUsedCarNo(email);
												Iterator it = car.iterator();
											%>
										</div>
									</div>
									<br>

									<div class="col-md-12">
										<br>
									</div>
									<div class="col-md-3 col-sm-12 col-xs-12" align="center"
										style="margin-bottom: 6px">
										<b>CAR REGISTRATION NO</b>
									</div>
									<div class="col-md-3 col-sm-12 col-xs-12"
										style="margin-bottom: 6px">
										<%=carNo%>


										<%-- <select name="carNo" class="form-control" 
													oninvalid="this.setCustomValidity('Please select Car No.')"
													oninput="setCustomValidity('')">
													<option value="">Select Car ID</option>
													<div class="form-group">
														<%
																while (it.hasNext()) {
																	for (int i = 0; i < car.size(); i++) {
																		UsedCar ac = (UsedCar) it.next();
															%>
														<option><%=ac.getCAR_NUMBER()%></option>
														<%
																}
																}
															%>
													</div>
												</select> --%>
									</div>

									<div class="col-md-12 col-xs-12">
										<div class="card"
											style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15);">
											<div class="card-block">
												<div id="printableArea" style="overflow-x: auto;">
													<input type="hidden" name="carNo" value="<%=carNo%>">
													<div class="col-md-12">
														<br>
													</div>
													<div class="col-md-12">
														<div class="col-md-2 col-sm-12 col-xs-12">
															<input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" id="file1"
																placeholder="Select Image" required>
														</div>
														<div class="col-md-2 col-sm-12 col-xs-12">
															<input type="file" name="photo2" accept="image/*"
																onchange="return svalidate('file2')" id="file2" 
																placeholder="Select Image">
														</div>
														<div class="col-md-2 col-sm-12 col-xs-12">
															<input type="file" name="photo3" accept="image/*"
																onchange="return svalidate('file3')" id="file3" 
																placeholder="Select Image">
														</div>
														<div class="col-md-2 col-xs-12">
															<input type="file" name="photo4" accept="image/*"
																onchange="return svalidate('file4')"
																id="file4" placeholder="Select Image">
														</div>
														<div class="col-md-2 col-xs-12">
															<input type="file" name="photo5" accept="image/*"
																onchange="return svalidate('file5')" id="file5" placeholder="Select Image">
														</div>
													</div>
													<div class="col-md-12">
														<br>
													</div>
													<div class="col-md-12">
														<div class="col-md-2 col-xs-12">
															<input type="file" name="photo6" accept="image/*"
																onchange="return svalidate('file6')" id="file6" placeholder="Select Image">
														</div>
														<div class="col-md-2 col-sm-12 col-xs-12">
															<input type="file" name="photo7" accept="image/*"
																onchange="return svalidate('file7')" id="file7" placeholder="Select Image">
														</div>
														<div class="col-md-2 col-sm-12 col-xs-12">
															<input type="file" name="photo8" accept="image/*"
																onchange="return svalidate('file8')" id="file8" placeholder="Select Image">
														</div>
														<div class="col-md-2 col-sm-12 col-xs-12">
															<input type="file" name="photo9" accept="image/*"
																onchange="return svalidate('file9')" id="file9" placeholder="Select Image">
														</div>
														<div class="col-md-2 col-sm-12 col-xs-12">
															<input type="file" name="photo10" accept="image/*"
																onchange="return svalidate('file10')" id="file10" placeholder="Select Image">
														</div>
													</div>
													<div class="col-md-12">
														<br>
													</div>

													<div class="col-md-12 col-xs-12" align="center">
														<button TYPE="submit" onclick="return(svalidate())"
															style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
															class="btn btn-primary">SUBMIT</button>
													</div>
													<div class="col-md-2 col-xs-12"></div>
													<br> <br>
													<div class="col-md-12" align="center">
														<%
															if (message != null) {
														%>
														<h5 style="color: #ff5400">
															<%=message%>
														</h5>
														<%
															} else {
															}
														%>
													</div>
												</div>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /page content --> <!-- footer content --> <footer class="footer">
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
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
	<script>
		function svalidate(id) {
			var fileUpload = document.getElementById(id);
		    //Check whether the file is valid Image.
		    var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(.jpg|.png|.gif)$");
		    if (regex.test(fileUpload.value.toLowerCase())) {
		 
		        //Check whether HTML5 is supported.
		        if (typeof (fileUpload.files) != "undefined") {
		            //Initiate the FileReader object.
		            var reader = new FileReader();
		            //Read the contents of Image File.
		            reader.readAsDataURL(fileUpload.files[0]);
		            reader.onload = function (e) {
		                //Initiate the JavaScript Image object.
		                var image = new Image();
		 
		                //Set the Base64 string return from FileReader as source.
		                image.src = e.target.result;
		                       
		                //Validate the File Height and Width.
		                image.onload = function () {
		                    var height = this.height;
		                    var width = this.width;
		                    if (height > 350 || width > 500) {
		                    	document.getElementById(id).value = '';
		                        alert("Upload image with Height 350px and Width must not exceed 500px.");
		                        return false;
		                    }
		                    return true;
		                };
		 
		            }
		        } else {
		            alert("This browser does not support HTML5.");
		            return false;
		        }
		    } else {
		        alert("Please select a valid Image file.");
		        return false;
		    }
		}
	</script>
</body>
</html>