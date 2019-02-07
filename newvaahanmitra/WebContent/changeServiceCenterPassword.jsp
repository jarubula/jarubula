<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./carMenu.jsp"/>
<%-- <jsp:include page="./carsandBikes.jsp" /> --%>
<jsp:include page="./topMenu.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>ShowUsedCarsList</title>
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
        #individual1{
        border-radius: 7px;
        box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15);
        border-bottom: 3px solid #a3b745 !important;
        }
        #one1{
	    text-align: center;
	    font-size: 21px;
	    color: #373a3c;
	    font-family: sans-serif;
	    }
	    .form-control {
    display: block;
    width: 100%;
    padding: .15rem .75rem;
    font-size: 1rem;
    line-height: 1.5;
    color: #55595c;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: .25rem;
}
label {
    display: inline-block;
    margin-bottom: .5rem;
    font-size: 17px;
    font-weight: 400;
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
		<div  align="center"><h3>SERVICE CENTER DASHBOARD</h3></div>
		</div>
					<div class="col-md-12 col-xs-12 col-sm-12">
						<div class="card" id="individual1">
							<div class="card-block">
							<div class="">
							<form name="f1" action="./ChangeServiceCenterPasswordController"
									onsubmit="return pass_validation()" method="post">
										<% if(message!=null){%>
                    	<h5 style="color:red"><%= message %> </h5>    
                        <%}else{}%> 
											<div class="col-md-12">
											<div align="center" style="text-align: center;
                                                  background-color: #523f6d;color: #fff;border-radius: 5px;line-height: 28px; font-size: 18px;">
												UPDATE PASSWORD 
											</div>
											
										</div>
										<br><br>
										     <div class="row">
							<div class="col-sm-4 form-group">
							<label>Current Password : </label>
							<input type="password" name="cpwd" id="cpwd"
													class="form-control" placeholder="Enter Old Password" required>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>New Password :</label>
							<input type="password" name="password1"
													id="password1" required class="form-control" placeholder="Enter New Password" required>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>Re-enter Password :</label>
							<input type="password" name="password2"
													id="password2" required class="form-control" placeholder="Re enter Password" required>
							</div>
						    </div>
						    
						    <div class="row">
							<div class="col-sm-4 form-group"></div>
							 <div class="col-sm-3 form-group"> <button type="submit" value="RESET" class="btn btn-info btn-block" style="border: 1px solid #fff; border-radius: 6px;">CHANGE</button></div>
							<div class="col-sm-4 form-group"></div>
							</div>
							
									</form>
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