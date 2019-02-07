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
										<form action="./addBikeController" method="post" enctype="multipart/form-data">
											<thead>
												<tr>
													<th colspan="4"
														style="text-align: center; background-color: #523f6d; color: #fff;">ADD BIKE</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td
														style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;"
														colspan="4">BRAND & MODEL</td>
												</tr>
												<tr>
													<td>Bike Brand</td>
													<td><input type="text" name="bikeBrand"
														class="form-control boxed" placeholder="Enter Bike Brand"
														required></input></td>
													<td>Bike Model</td>
													<td><input type="text" name="bikeModel"
														class="form-control boxed" placeholder="Enter Bike Model"
														required></input></td>
													</td>
												</tr>
												<tr>
													<td>Engine Capacity</td>
													<td><input type="text" name="engineCapacity"
														class="form-control boxed" placeholder="Enter Engine Capacity"
														required></input></td>
												
													<td>Engine Type</td>
													<td><input type="text" name="engineType"
														class="form-control boxed"
														placeholder="Enter Engine Type" required></input></td>
												</tr>
												<tr>
													<td>Cooling System</td>
													<td><input type="text" name="coolingSystem"
														class="form-control boxed"
														placeholder="Enter Cooling System" required></input></td>
													<td>Max Power</td>
													<td><input type="text" name="maxPower"
														class="form-control boxed"
														placeholder="Enter Max Power" required></input></td>
												</tr>
												
												<tr>
													<td> Mileage </td>
													<td><input type="text" name="mileage"
														class="form-control boxed" placeholder="Enter Mileage"
														required></input></td>
													<td>Max Torque</td>
													<td><input type="text" name="maxTorque"
														class="form-control boxed" class="form-control boxed"
														placeholder="Enter Engine Starting" required></input></td>
												</tr>
												<tr>
													<td>Engine Starting</td>
													<td><input type="text" name="engineStarting"
														class="form-control boxed" class="form-control boxed"
														placeholder="Enter Engine Starting" required></input></td>
													<td>Transmission Type</td>
													<td><select required class="form-control boxed" name="transmissionType">
															<option value="">Select</option>
															<option value="automatic">AUTOMATIC</option>
															<option value="manual">MANUAL</option>
													</select></td>
												</tr>
												<tr>
													<td
														style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;"
														colspan="4">ELECTRICALS</td>
												</tr>
												<tr>
													<td>Battery Capacity</td>
													<td><input type="text" name="batteryCapacity"
														class="form-control boxed"
														placeholder="Enter Battery Capacity" required></td>
													<td>Head Lamp</td>
													<td><input type="text" name="headLamp"
														class="form-control boxed"
														placeholder="Enter Head Lamp" required></td>
												</tr>
												<tr>
													<td
														style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;"
														colspan="4">BRAKES</td>
												</tr>
												
												<tr>
													<td>Front Brake</td>
													<td><input type="text" name="frontBrake"
														class="form-control boxed"
														placeholder="Enter Front Brake" required></td>
													<td>Rear Brake</td>
													<td><input type="text" name="rearBrake"
														class="form-control boxed" placeholder="Enter Rear Brake" required></td>
												</tr>
												<tr>
													<td
														style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;"
														colspan="4">CHASSIS & DIMENSION</td>
												</tr>
												<tr>
													<td>Front Suspension</td>
													<td><input type="text" name="frontSuspenssion"
														class="form-control boxed"
														placeholder="Enter Front Suspension" required></td>
													<td>Rear Suspension</td>
													<td><input type="text" name="rearSuspenssion"
														class="form-control boxed" placeholder="Enter Rear Suspension" required></td>
												</tr>
												<tr>
													<td>Frame</td>
													<td><input type="text" name="frame"
														class="form-control boxed"
														placeholder="Enter Frame" required></td>
												</tr>
												
												<tr>
													<td
														style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;"
														colspan="4">TYRES</td>
												</tr>
												<tr>
													<td>Front Tyre</td>
													<td><input type="text" name="frontTyre"
														class="form-control boxed" placeholder="Enter Front Tyre" required></td>
													<td>Rear Tyre</td>
													<td><input type="text" name="rearTyre"
														class="form-control boxed"
														placeholder="Enter Rear Tyre" required></td>
												</tr>
												<tr>
													<td>Tyre Type</td>
													<td><input type="text" name="tyreType"
														class="form-control boxed"
														placeholder="Enter Tyre Type" required></td>
												</tr>
												<tr>
													<td
														style="font-weight: 700; font-size: 700; color: #523f6d; text-align: center;"
														colspan="4">DIMENSIONS</td>
												</tr>
												<tr>
													<td>Length</td>
													<td><input type="text" name="length"
														class="form-control boxed" placeholder="Enter Length" required></td>
													<td>Width</td>
													<td><input type="text" name="width"
														class="form-control boxed"
														placeholder="Enter Width" required></td>
												</tr>
												<tr>
													<td>Height</td>
													<td><input type="text" name="height"
														class="form-control boxed" placeholder="Enter Height" required></td>
													<td>Weight</td>
													<td><input type="text" name="weight"
														class="form-control boxed"
														placeholder="Enter Weight" required></td>
												</tr>
												<tr>
													<td>Ground Clearance</td>
													<td><input type="text" name="groundClearance"
														class="form-control boxed" placeholder="Enter Ground Clearance" required></td>
													<td>Petrol Tank Capacity</td>
													<td><input type="text" name="tankCapacity"
														class="form-control boxed"
														placeholder="Enter Petrol Tank Capacity" required></td>
												</tr>
												<tr>
												<td>Photo</td>
												<td>
													<div class="form-group">
														<input type="file" name="photo" accept="image/*"
															placeholder="Select Image" required>
													</div>
												</td>
												<tr>
                                                 <td> BIKE Description</td>
                                                 <td>
                                                      <div class="form-group">
                                                      		<textarea rows="4" cols="50" class="form-control boxed" name="bikeDescription" required></textarea> 
                        							  </div>
                                                 </td>
                                            	</tr>
												</tr>
												<tr>
                                                    <td colspan="2" style="text-align: center;">
                                                    <button TYPE="submit" style="background-color: #a3b745;border: 1px solid #a3b745;" class="btn btn-primary">ADD BIKE</button>   
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