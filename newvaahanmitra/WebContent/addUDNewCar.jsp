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
<jsp:include page="./carsandBikes.jsp" />
<jsp:include page="./topMenu.jsp" />


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
		xmlhttp.open("GET", "./getNewCarModel.jsp?brand=" + str, true);
		xmlhttp.send();
	}
</script>

<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
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
        <style>
        label, .control-label {
           font-weight: 500;
           font-size: 16px;
         }
         #one{
             border: 1px solid #fff;
             border-radius: 5px;
             line-height: 25px;
       }</style>
</head> 

<body>
	<div class="main-wrapper">
		<div class="app" id="app">
			<header class="">
			<div class="header-block header-block-nav">
			</div>
			</header>
			
			<article class="content responsive-tables-page"
				style="background-color:#fff">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div align="center" style="font-size: 25px"> VEHICLE DEALER DASHBOARD</div>
			</div>
			<section class="section">

			<div class="row">

				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<div class="">
								<form action="./AddUDDoucments" name="myform"
									enctype="multipart/form-data" method="post">
									<%
					String message = (String) request.getAttribute("success");
				%>
									<%
										if (message != null) {
									%>
									<h6 style="color: red"><%=message%>
									</h6>
									<%
										} else {
										}
									%>
									<div class="row table-hover">
										<div class="container-fluid">	</div>		

										<div class="col-md-12">
											<span style="font-size: 18px; color: #0275d8;">Are you Authorised Dealer? if yes upload your Documents here.</span>
										</div>
										 <br><br>
										<div class="col-sm-4 form-group">
										<label>Select Car Brand <span style="color:red;">*</span></label>
											<jsp:include page="./getNewCarBrand.jsp" />
									    </div>
								
								        <div class="col-sm-4 form-group">
										<label>Document Name :</label>
											<input type="text" name="documetName" class="form-control form-control-sm" placeholder="Enter Document Name" required>
									    </div>
									    
									    <div class="col-sm-4 form-group">
										<label>Upload Document :</label>
											<input type="file" class="form-control form-control-sm" name="file1" accept="image/*" id="file1" placeholder="Select Image" required> 
									     <input type="hidden" value="4," name="v_type">
									    </div>
									    
									      <div class="col-md-12">
										       <div class="col-md-5"></div>
										       <div class="col-md-2">
										       <button TYPE="submit" class="btn btn-primary btn-block" id="one">Submit</button>
										       </div>
										       <div class="col-md-5"></div>
										    </div>
										    
										   
										</div></form></div></div></div>
									</div>
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
			<li>created by <a href="#">Kosuri Soft Pvt Ltd</a>
			</li>
			<li><a href="www.kosurisoft.com">get in touch</a></li>
		</ul>
	</div>
	</footer>
	
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
</body>
</html>