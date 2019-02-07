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
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta charset="utf-8">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./sparePartsMenu.jsp"/>
<jsp:include page="./topMenu.jsp"/>
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>ShowUsedCarsList</title>
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
	function pass_validation() {
		var currentpassword = document.f1.cpwd.value;
		var firstpassword = document.f1.password1.value;
		var secondpassword = document.f1.password2.value;

		if (firstpassword != secondpassword) {
			alert("New Password & Re-enter Password doesn't not match...Please TryAgain");
			return false;
		}
		if (currentpassword == firstpassword) {
			alert("Current Password & NewPassword have matched");
			return false;
		}
		return true;
	}
</script>
<style>
.td {
	font-size: small;
}
</style>
</head>

<body>
<%String message =(String)request.getAttribute("success"); %>
	<div class="main-wrapper">
		<div class="app" id="app">

			<header class="" style="font-family: 'Oswald', sans-serif;">

			<div class="header-block header-block-collapse hidden-lg-up">
				<!-- <button class="collapse-btn" id="sidebar-collapse-btn">
					<i class="fa fa-bars"></i>
				</button> -->
			</div>

			<div class="header-block header-block-nav">
			</div>
			</header>
			<br>

			<article class="content responsive-tables-page"
					style="background-color:#fff"> <section class="section">
				<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
		<div  align="center"><h3>SPARE PARTS DASHBOARD</h3></div>
		</div>
					<div class="col-md-12 col-xs-12 col-sm-12">
						<div class="card"
							style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
							<div class="card-block" style="border-bottom: 3px solid #a3b745;">
								<section class="example">
								<div class="table-responsive">
								<form name="f1" action="./ChangeSpPassword"
									onsubmit="return pass_validation()" method="post">
										<% if(message!=null){%>
                    	<h5 style="color:red"><%= message %> </h5>    
              <%}else{}%> 
											<div class="col-md-12">
											<div align="center" style="text-align: center; background-color: #523f6d; color: #fff;">
												UPDATE PASSWORD 
											</div>
										</div>
										<br><br>
										<div class="col-md-12"></div>
										<div class="col-md-2 col-sm-12">
											Current Password
										</div>
										<div class="col-md-4 col-sm-12">
											<input type="password" name="cpwd" id="cpwd"
													class="form-control" placeholder="Enter Old Password"
													required>
											</input>
										</div>
										<div class="col-md-12"><br></div>
										<div class="col-md-2 col-sm-12">
											New Password
										</div>
										<div class="col-md-4 col-sm-12">
											<input type="password" name="password1"
													id="password1" required class="form-control"
													placeholder="Enter New Password" required>
											</input>
										</div>
										<div class="col-md-12"><br></div>
										<div class="col-md-2 col-sm-12">
											Re-enter Password
										</div>
										<div class="col-md-4 col-sm-12">
											<input type="password" name="password2"
													id="password2" required class="form-control"
													placeholder="Re enter Password" required>
											</input>
										</div>
										<div class="col-md-12 col-sm-12 "><br><br></div>
										<div class="col-md-6 col-sm-12 " align="center">
											<button TYPE="submit"
															style="background-color: #a3b745; border: 1px solid #a3b745; align: center; border-radius:10px"
															class="btn btn-primary">CHANGE
											</button>
										</div>
										<div class="col-md-6"></div>
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
	<footer>Copyright &copy; vehicletracking.com</footer>
</body>
</html>