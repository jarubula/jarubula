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

<meta charset="utf-8">
<jsp:include page="./carMenu.jsp" />
<jsp:include page="./topMenu.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>AddCar</title>
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
			<header class="" style="font-family: 'Oswald', sans-serif;">
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
						<div class="card"
							style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
							<div class="card-block" style="border-bottom: 3px solid #a3b745;">
								<section class="">
								<div class="">
								<form action="./serviceTypeController" name="frm" method="post"
									onSubmit="return validate()">
									<div class="col-md-12 col-sm-12 col-xs-12" align="center" style="text-align: center; background-color: #523f6d; color: #fff;">
										SERVICE TYPE
										</div><br><br><% 
											String message = (String)request.getAttribute("message");
											if(message!=null){
											%>
												<h6 style="color:green;"><b><%=message%></b></h6>
												<%}else{
											}
										%>
											<div class="col-md-12 col-xs-12 col-sm-12"><br><br></div>
										<div class="row">
										<div class="col-md-3">
										<b>Vehicle Type</b>
										</div>
                                        <div class="col-md-3">
                                       <div class="form-group">
														<select name="vehicleType" class="form-control"
															onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);">
															<option value="carServiceType.jsp">FOUR WHEELER</option>
															<option value="bikeServiceType.jsp">TWO WHEELER</option>
														</select>
													</div>
                                        </div>  
<!--                                         <input type ="hidden" name="service" value="cs"> -->
                                        <div class="col-md-6">
                                        </div>
                                        <div class="col-md-12">
                                        </div>
										<div class="col-md-3" >
										<b>Vehicle Brand</b>
										</div>
										<div class="col-md-3" align="left">
										<div class="form-group">
														<select name="make" id="make" class="form-control">
															<option value="">SELECT CAR BRAND</option>
															<optgroup label="Most Popular">
																<option>All</option>
																<option value="Maruti Suzuki">Maruti Suzuki</option>
																<option value="Hyundai">Hyundai</option>
																<option value="Volkswagen">Volkswagen</option>
																<option value="Tata">Tata</option>
																<option value="Toyota">Toyota</option>
																<option value="Honda">Honda</option>
																<option value="Ford">Ford</option>
																<option value="Nissan">Nissan</option>
																<option value="Mahindra">Mahindra</option>
																<option value="Renault">Renault</option>
															</optgroup>
															<optgroup label="Others">
																<option value="Audi">Audi</option>
																<option value="BMW">BMW</option>
																<option value="Mercedes Benz">Mercedes Benz</option>
																<option value="Skoda">Skoda</option>
																<option value="Chevrolet">Chevrolet</option>
																<option value="Aston Martin">Aston Martin</option>
																<option value="Bentley">Bentley</option>
																<option value="Bugatti">Bugatti</option>
																<option value="Datsun">Datsun</option>
																<option value="Ferrari">Ferrari</option>
																<option value="Fiat">Fiat</option>
																<option value="Force Motors">Force Motors</option>
																<option value="DC">DC</option>
																<option value="Isuzu">Isuzu</option>
																<option value="Jaguar">Jaguar</option>
																<option value="Lamborghini">Lamborghini</option>
																<option value="Land Rover">Land Rover</option>
																<option value="Maserati">Maserati</option>
																<option value="MINI">MINI</option>
																<option value="Mitsubishi">Mitsubishi</option>
																<option value="Porsche">Porsche</option>
																<option value="Rolls Royce">Rolls Royce</option>
																<option value="Ssangyong">Ssangyong</option>
																<option value="Volvo">Volvo</option>
																<option value="Jeep">Jeep</option>
																<option value="Eicher Polaris">Eicher Polaris</option>
																<option value="Lexus">Lexus</option>
															</optgroup></select></div>
										
										</div>
										
										<div class="col-md-6">
                                        
                                        
                                        </div>
                                        <div class="col-md-12">
                                        
                                        
                                        </div>
										<div class="col-md-3">
										<b>Service ID</b>
										
										</div>
										<div class="col-md-3">
										<div class="form-group">
														<input type="text" class="form-control "
															name="serviceId" required>
													</div>
										
										</div>
										<div class="col-md-6">
                                        
                                        
                                        </div>
                                        <div class="col-md-12">
                                        
                                        
                                        </div>
										<div class="col-md-3">
										<b>Service Type</b>
										
										</div>
										<div class="col-md-3">
										<div class="form-group">
														<input type="text" class="form-control "
															name="serviceType" required>
													</div>
										
										</div>
										<div class="col-md-6">
                                        </div>
                                        <div class="col-md-12">
                                        </div>
										<div class="col-md-3">
										<b>Service Description</b>
										</div>
										<div class="col-md-3">
										<div class="form-group">
														<textarea rows=5 columns=5 class="form-control "
															name="serviceDescription" required></textarea>
													</div>
										</div>
										<div class="col-md-6">
                                        </div>
										<div class="col-md-12">
                                        </div>
										<div class="col-md-12 col-sm-12 col-xs-12"><br><br></div>
										<div class="col-md-8" align="center">
										<button
														style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
											class="btn btn-primary">ADD SERVICE</button>
										
										</div>
										<div class="col-md-4">
                                        </div>
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