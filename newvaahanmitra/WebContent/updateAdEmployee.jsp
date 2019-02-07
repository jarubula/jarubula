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
<%@page import="com.vaahanmitra.model.Registration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<jsp:include page="./AdminMenu.jsp" />
<jsp:include page="./Admin-right-side.jsp" />

<script src="./css/countries.js" type="text/javascript"></script>

<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//geodata.solutions/includes/statecity.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#type")
								.change(
										function() {
											var val = $(this).val();
											if (val == "item1") {
												$("#size")
														.html(
																"<option value='test'>item1: test 1</option><option value='test2'>item1: test 2</option>");
											} else if (val == "item2") {
												$("#size")
														.html(
																"<option value='test'>item2: test 1</option><option value='test2'>item2: test 2</option>");
											} else if (val == "item3") {
												$("#size")
														.html(
																"<option value='test'>item3: test 1</option><option value='test2'>item3: test 2</option>");
											}
										});
					});
</script>
<script language="javascript">
	function validate() {

		if (document.getElementById("panNo").value.length >= 0) {

			if (document.getElementById("panNo").value.length == 0) {
			} else {
				var pan = document.getElementById("panNo").value;
				var panPat = /^([a-zA-Z]{5})(\d{4})([a-zA-Z]{1})$/;
				if (!panPat.test(pan)) {
					alert("Invalid Pan Number");
					document.getElementById("panNo").focus();
					return false;
				} else {
				}
			}
		}
		if (document.getElementById("bpincodeNo").value.length != 6) {
			alert("Please enter 6 digits PINCODE No");
			document.getElementById("bpincodeNo").focus();
			return false;
		}

		return true;
	}
</script>
<style type="text/css">
.multiselect {
	/* width: 200px; */
	
}

.selectBox {
	position: relative;
}

.selectBox select {
	width: 100%;
	font-weight: bold;
}

.overSelect {
	position: absolute;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
}

#checkboxes {
	display: none;
	border: 1px #dadada solid;
}

#checkboxes label {
	display: block;
}

#checkboxes label:hover {
	background-color: #1e90ff;
}
</style>
<script type="text/javascript">
	var expanded = false;

	function showCheckboxes() {
		var checkboxes = document.getElementById("checkboxes");
		if (!expanded) {
			checkboxes.style.display = "block";
			expanded = true;
		} else {
			checkboxes.style.display = "none";
			expanded = false;
		}
	}
</script>

<script>
	function NumAndTwoDecimals(event, obj) {
		reg = /[^0-9.,]/g;
		obj.value = obj.value.replace(reg, "");
	}
</script>
<script type="text/javascript">
	function checkSpcialChar(event) {
		if (!((event.keyCode >= 65) && (event.keyCode <= 90)
				|| (event.keyCode >= 97) && (event.keyCode <= 122) || (event.keyCode >= 48)
				&& (event.keyCode <= 57))) {
			event.returnValue = false;
			return;
		}
		event.returnValue = true;
	}
</script>
<script type="text/javascript">
	function ValidateSize(file) {
		var FileSize = file.files[0].size / 1024 / 1024; // in MB
		if (FileSize > 1) {
			alert('File size exceeds 1 MB');
			// $(file).val(''); //for clearing with Jquery
		} else {

		}
	}
</script>

<script>
	function svalidate() {
		if (document.myform.ownerName.value == "") {
			alert("Please enter OwnerName");
			document.getElementById("ownerName").focus();
			return false;
		}
		if (document.myform.usedBy.value == "") {
			alert("Please enter UsedBy");
			document.getElementById("usedBy").focus();
			return false;
		}
		if (document.myform.noOfOwners.value == "") {
			alert("Please enter NoOfOwners");
			document.getElementById("noOfOwners").focus();
			return false;
		}
		if (document.myform.emailId.value == "") {
			alert("Please enter EmailId");
			document.getElementById("emailId").focus();
			return false;
		}
		if (document.myform.mobileNo.value.length != 10) {
			alert("Please enter 10 digits in MobileNo");
			document.getElementById("mobileNo").focus();
			return false;
		}
		if (document.myform.address.value == "") {
			alert("Please enter Address");
			document.getElementById("address").focus();
			return false;
		}
		if (document.myform.city.value == ""
				|| document.myform.city.value == "null") {
			alert("Please enter City");
			document.getElementById("city").focus();
			return false;
		}
		if (document.myform.country2.value == "-1") {
			alert("Please Select State");
			document.getElementById("country2").focus();
			return false;
		}
		if (document.myform.state.value == "") {
			alert("Please Select District");
			document.getElementById("state").focus();
			return false;
		}
		if (document.myform.pincode.value == ""
				|| document.myform.pincode.value == "null"
				|| document.myform.pincode.value.length != 6) {
			alert("Please enter 6 digits in Pincode");
			document.getElementById("pincode").focus();
			return false;
		}
		if (document.myform.price.value == "") {
			alert("Please enter Price");
			document.getElementById("price").focus();
			return false;
		}
		if (document.myform.purchasedYear.value.length != 4) {
			alert("Please enter 4 digits YEAR");
			document.getElementById("purchasedYear").focus();
			return false;
		}
		var emailfilter = /^\w+[\+\.\w-]*@([\w-]+\.)*\w+[\w-]*\.([a-z]{2,4}|\d+)$/i
		var b = emailfilter.test(document.myform.emailId.value);
		if (b == false) {
			alert("Please Enter a valid Mail ID");
			document.myform.emailId.focus();
			return false;
		}
	}
</script>
<script type="text/javascript">
	function ShowHideDiv() {
		var chkYes = document.getElementById("chkYes");
		var dvPassport = document.getElementById("dvPassport");
		dvPassport.style.display = chkYes.checked ? "block" : "none";
	}
</script>

<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Vaahanmitra | Dashboard</title>
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
				style="background-color:#fff;border-radius:25px;"> <section
				class="section">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="">
								<form action="./AdAssignRoleToEmployee" name="myform" method="post"
									onSubmit="return validate()">
									<div class="container-fluid"></div>
									<br>
									<%
										String eid = request.getParameter("eid");
										String empId = request.getParameter("empId");
										if(empId==null){
											empId = (String)request.getAttribute("empId");
										}
										String message = (String) request.getAttribute("message");
										if (message != null) {
									%>
									<h5 style="color: blue"><%=message%>
									</h5>
									<%
										} else {
										}
									%>
									<div class="row">
										<div class="col-md-12">
											<h4 style="background: #f1f2f3; text-align: center;">ASSIGN
												ROLE</h4>
										</div>
										<br>
										<div class="col-lg-12">
											<div class="col-md-2"></div>
											<div class="col-md-4">
												<div class="col-md-12">
													<b>User Id:</b>
													<div>
														<input type="text" name="employeeId" value="<%=empId%>" readonly>
													</div>
												</div>
												<label for=""><b>Assign Role:</b></label>
												<div class="multiselect">
													<div class="selectBox">
														<label>
															<input type="checkbox" name="division" value="SC" />Add Service Center
														</label><br> 
														<label>
															<input type="checkbox" name="division" value="UD" />Add Used Vehicle Dealer
														</label><br>
														<label>
															<input type="checkbox" name="division" value="IO" />Add Individual Owner
														</label><br>
														<label>
															<input type="checkbox" name="division" value="SP" />Add SpareParts Shop
														</label><br> 
														<label>
															<input type="checkbox" name="division" value="DR" />Add Driver
														</label><br>
													</div>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label for=""></label>
													<div class="multiselect">
														<div class="selectBox">
															<span><b>Profile view:</b></span> <br> 
															<label>
																<input type="checkbox" name="view" value="view"/> view 
															</label><br>
														</div>
													</div>
												</div>
											</div>
											<div class="col-md-2"></div>
										</div>
										<div class="col-lg-12">
											<div class="col-md-2"></div>
											<div class="col-md-4">
												<div class="form-group">
													<label for=""><b>Status:</b></label>
													<div class="multiselect">
														<div class="selectBox">
															<label><input type="checkbox" name="status" value="AI" />ACTIVE / INACTIVE </label><br>
														</div>
													</div>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label for=""><b>Reports:</b></label>
													<div class="multiselect">
														<div class="selectBox">
															<label><input type="checkbox" name="reports" value="report1" />Report1</label><br> 
															<label><input type="checkbox" name="reports" value="report2" />Report2</label><br>
														</div>
													</div>
												</div>
											</div>
											<div class="col-md-2"></div>
										</div>
									</div>

									<div class="col-md-12">
										<div class="col-md-5"></div>
										<div class="col-md-4">
											<button type="submit" class="btn  btn-primary" style="border-radius:10px;">SUBMIT</button>
											<br>
										</div>
										<div class="col-md-12">
											<br>
										</div>
									</div>
								</form>
							</div>
							</section>
						</div>
						<div class="col-md-12 col-xs-12"></div>
					</div>
				</div>
			</div>
			</section></article>
		</div>
	</div>
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
		populateCountries("country", "state");
	</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>
</html>