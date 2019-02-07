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
<head><title>VaahanMitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./carMenu.jsp" />
<jsp:include page="./right-side.jsp" />
<script language="javascript">
	function CheckNumeric(e) {	  
	    if (window.event) // IE 
	    {
	        if ((e.keyCode < 48 || e.keyCode > 57) & e.keyCode != 8) {
	            event.returnValue = false;
	            return false;
	        }
	    }
	    else { // Fire Fox
	        if ((e.which < 48 || e.which > 57) & e.which != 8) {
	            e.preventDefault();
	            return false;
	        }
	    }
	}
	</script>
</head>
<body>
	<center>
		<div class="main-wrapper">
			<div class="app" id="app">


				<header class="header">
				<div class="header-block header-block-collapse hidden-lg-up">
					<button class="collapse-btn" id="sidebar-collapse-btn">
						<i class="fa fa-bars"></i>
					</button>
				</div>

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
				<article class="content responsive-tables-page" style="background-color:#fff">
				<section class="section">
				<div class="row">
					<div class="col-md-12">
						<div class="card" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-bottom: 3px solid #a3b745;">
							<div class="card-block" style="border-bottom: 3px solid #a3b745;">
								<section class="example">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover">
										<form action="./addCarController" method="post" enctype="multipart/form-data">
											<thead>
												<tr>
													<th colspan="4"
														style="text-align: center; background-color: #523f6d; color: #fff;">ADD CAR</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td
														style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;"
														colspan="4">BRAND & MODEL</td>
												</tr>
												<tr>
													<td>Car Brand</td>
													<td><input type="text" name="carBrand"
														class="form-control boxed" placeholder="Enter Car Brand"
														required></input></td>
													<td>Car Model</td>
													<td><input type="text" name="carModel"
														class="form-control boxed" placeholder="Enter Car Model"
														required></input></td>
													</td>
												</tr>
												</tr>
												<tr>
													<td
														style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;"
														colspan="4">ENGINE</td>
												</tr>
												<tr>
													<td>Engine CC</td>
													<td><input type="text" name="engineCC"
														class="form-control boxed" placeholder="Enter Engine CC"
														required></input></td>
													<td>Fuel Type</td>
													<td><select required class="form-control boxed" name="fuelType">
															<option value="">Select</option>
															<option value="petrol">PETROL</option>
															<option value="diesel">DIESEL</option>
															<option value="cng">CNG</option>
															<option value="lpg">LPG</option>
															<option value="electic">ELECTIC</option>
													</select></td>
												</tr>
												<tr>
													<td>City(mpg)</td>
													<td><input type="text" name="city"
														class="form-control boxed"
														placeholder="Enter City Mileage" required></input></td>
													<td>HighWay(mpg)</td>
													<td><input type="text" name="highway"
														class="form-control boxed"
														placeholder="Enter HighWay Mileage" required></input></td>
												</tr>
												<tr>
													<td
														style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;"
														colspan="4">BODY</td>
												</tr>
												<tr>
													<td>Length(In.)</td>
													<td><input type="text" name="length"
														class="form-control boxed" placeholder="Enter Length"
														required></input></td>
													<td>Width(In.)</td>
													<td><input type="text" name="width"
														class="form-control boxed" placeholder="Enter Width"
														required></input></td>
												</tr>
												<tr>
													<td>Height(In.)</td>
													<td><input type="text" name="height"
														class="form-control boxed" class="form-control boxed"
														placeholder="Enter Height" required></input></td>
													<td>Seating Capacity</td>
													<td><input type="text" name="seatingCapacity"
														class="form-control boxed"
														placeholder="Enter Seating Capacity"
														onkeypress="CheckNumeric(event)" required></td>
												</tr>
												<tr>
													<td>Fuel Tank Capacity</td>
													<td><input type="text" name="tankCapacity"
														class="form-control boxed"
														placeholder="Enter Tank Capacity in Liters" required></td>
													<td>Wheelbase</td>
													<td><input type="text" name="wheelBase"
														class="form-control boxed" placeholder="Enter Wheelbase"
														required></td>
												</tr>
												<tr>
													<td>Gross Vehicle Weight</td>
													<td><input type="text" name="vehicleWeight"
														class="form-control boxed"
														placeholder="Enter Vehicle Weight" required></td>
												</tr>
												<tr>
													<td
														style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;"
														colspan="4">TRANSMISSION</td>
												</tr>
												<tr>
													<td>Transmission Type</td>
													<td><select required class="form-control boxed" name="transmissionType">
															<option value="">Select</option>
															<option value="automatic">AUTOMATIC</option>
															<option value="manual">MANUAL</option>
													</select></td>
													<td>No of Gears</td>
													<td><input type="text" name="gears"
														class="form-control boxed" placeholder="Enter No of Gears"
														onkeypress="CheckNumeric(event)" required></td>
												</tr>

												<tr>
													<td
														style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;"
														colspan="4">WARRANTY</td>
												</tr>
												<tr>
													<td>Basic Warranty</td>
													<td><input type="text" name="basicWarranty"
														class="form-control boxed"
														placeholder="Enter Basic Warranty" required></td>
												</tr>
												<tr>
													<td>Extended Warranty</td>
													<td><input type="text" name="extendedWarranty"
														class="form-control boxed"
														placeholder="Enter Extended Warranty" required></td>
														<td>Photo</td>
												<td>
													<div class="form-group">
														<input type="file" name="photo" accept="image/*"
															placeholder="Select Image" required>
													</div>
												</td>
												
												<tr>
                                                    <td colspan="2" style="text-align: center;">
                                                    <button TYPE="submit" style="background-color: #a3b745;border: 1px solid #a3b745;" class="btn btn-primary">ADD CAR</button>   
                                                    </td>
                                                    <td colspan="2" style="text-align: center;">
                                                    <input style="background-color: #a3b745;border: 1px solid #a3b745;" type="reset" value="RESET" class="btn btn-primary"/>   
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
	</center>
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