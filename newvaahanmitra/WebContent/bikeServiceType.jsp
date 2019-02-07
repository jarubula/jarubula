<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<jsp:include page="./carMenu.jsp" />
<jsp:include page="./topMenu.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Add Car</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<!-- Theme initialization -->
<script type="text/javascript">
	function setAction(nPage){
		document.forms[0].action = nPage;
	}
</script>


<script language="javascript">
	function validate() {
		document.getElementById("msg1").innerHTML = "";
		document.getElementById("msg2").innerHTML = "";
		document.getElementById("msg3").innerHTML = "";
		document.getElementById("msg4").innerHTML = "";
		document.getElementById("msg5").innerHTML = "";
		if (document.frm.servieID.value == '') {
			document.getElementById("msg1").innerHTML = "Please Enter Service ID";
			return false;
		}
		
		if (document.frm.serviceType.value == '') {
			document.getElementById("msg2").innerHTML = "Please Enter Service Type";
			return false;
		}
		if (document.frm.serviceDescription.value == '') {
			document.getElementById("msg3").innerHTML = "Please Enter Service Description";
			return false;
		}

		return true;
	}
	
	function CheckNumeric(e) {
  
    if (window.event) // IE 
    {
        if ((e.keyCode < 48 || e.keyCode > 57) & e.keyCode != 20) {
            event.returnValue = false;
            return false;

        }
    }
    else { // Fire Fox
        if ((e.which < 48 || e.which > 57) & e.which != 20) {
            e.preventDefault();
            return false;

        }
    }
}
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
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">


			<header class="header">
			<div class="header-block header-block-collapse hidden-lg-up">
				<button class="collapse-btn" id="sidebar-collapse-btn">
					<i class="fa fa-bars"></i>
				</button>
			</div>

			<div class="header-block header-block-nav">
				<!--                         <ul class="nav-profile"> -->

				<!--                             <li class="profile dropdown"> -->
				<!--                                 <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"> -->
				<!--                                     <div class="img" style=""> </div> <span class="name"> Mohan Amasa</span> </a> -->
				<!--                                 <div class="dropdown-menu profile-dropdown-menu" aria-labelledby="dropdownMenu1"> -->

				<!--                                     <a class="dropdown-item" href="#"> <i class="fa fa-power-off icon"></i> Logout </a> -->
				<!--                                 </div> -->
				<!--                             </li> -->
				<!--                         </ul> -->
			</div>
			</header>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<form action="./serviceTypeController" name="frm" method="post"
										onSubmit="return validate()">
										<thead>
											<tr>
												<th colspan="4"
													style="text-align: center; background-color: #523f6d; color: #fff;">SERVICE
													TYPE</th>
											</tr>
											
										</thead><% 
											String message = (String)request.getAttribute("message");
											if(message!=null){
											%>
												<h6 style="color:green;"><b><%=message%></b></h6>
												<%}else{
											}
										%>
										<tbody>
											<tr>
												<td>Vehicle Type</td>
												<td>
													<div class="form-group">
														<select name="vehicleType" onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);">
															<option value="bikeServiceType.jsp"> TWO WHEELER </option>
															<option value="carServiceType.jsp"> FOUR WHEELER </option>
														</select>
													</div>
												</td>
											</tr>
											<tr>
												<td>Vehicle Brand</td>
												<td><div class="form-group">
														<select name="make" id="make"
															onchange="setmodels(this.value);clear_expected_price();">
															<option value="">SELECT BIKE BRAND</option>
															<option>All</option>
															<option value="HONDA">Honda</option>
															<option value="ROYAL ENFIELD">Royal Enfield</option>
															<option value="TVS">TVS</option>
															<option value="BAJAJ">Bajaj</option>
															<option value="YAMAHA">Yamaha</option>
															<option value="HERO">Hero</option>
															<option value="KTM">KTM</option>
															<option value="SUZUKI">Suzuki</option>
															<option value="MAHINDRA">Mahindra</option>
															<option value="HARLEY DAVIDSON">Harley Devidson</option>
															<option value="DUCATI">Ducati</option>
															<option value="KAWASAKI">Kawasaki</option>
															<option value="UM MOTERCYCLES">Um Motercycles</option>
															<option value="EIDER(DEFUNCT)">Eider(Defunct)</option>
															<option value="BENALLI">Bennalli</option>
															<option value="HYOSUNG">Hyosung</option>
															<option value="TRIUMPH">Triumph</option>
															</optgroup>
														</select></select></div></td>
											</tr>
											<tr>
												<td>Service ID</td>
												<td>
													<div class="form-group">
														<input type="text" class="form-control boxed"
															name="serviceId" required>
													</div>
												</td>
											</tr>
											<tr>
												<td>Service Type</td>
												<td>
													<div class="form-group">
														<input type="text" class="form-control boxed"
															name="serviceType" required>
													</div>
												</td>
											</tr>
											


											<tr>
												<td>Service Description</td>
												<td>
													<div class="form-group">
														<textarea rows=5 columns=5 class="form-control boxed"
															name="serviceDescription" required></textarea>
													</div>
												</td>
											</tr>
											<tr>
												<td colspan="4" style="text-align: center;">
													<button
														style="background-color: #a3b745; border: 1px solid #a3b745;"
														class="btn btn-primary">ADD</button>
												</td>
											</tr>
										</tbody>
									</form>
								</table>
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
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>

</html>