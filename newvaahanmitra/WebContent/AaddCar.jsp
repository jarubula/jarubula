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
<title>VaahanMitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<link href="./images/icone.jpg" type="icon/img" rel="icon">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./AdminMenu.jsp" />
<jsp:include page="./Admin-right-side.jsp" />
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
	<style>
	label, .control-label {
       font-weight: inherit;
    float: left;
    font-size: 17px;
    font-family: sans-serif;
    color: #5e6061;
        line-height: 11px;
    
}
#b1{
    border: 1px solid #fff;
    border-radius: 5px;
    }
    h4{
    font-size:23px;
    color: #efa844;
    font-weight: 500;
    font-family: sans-serif;
    
    }
    .form-control.boxed {
    border-radius: 0;
    box-shadow: none;
    border-radius: 3px;
    line-height: 18px;
}
	</style>
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
				</div>
				</header>
				<article class="content responsive-tables-page" style="background-color:#fff">
				<section class="section">
				<div class="row">
					<div class="col-md-12">
								<h3>ADD CAR</h3>
								 <%
 	String str = (String) request.getAttribute("success");
 if(str!=null){%> <%=str%><%}else{} %>
						<div class="card" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-bottom: 3px solid #a3b745;">
							<div class="card-block" style="border-bottom: 3px solid #a3b745;">
								<section class="example">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover">
										<form action="./AdminAddCar" method="post" enctype="multipart/form-data">
											<div class="col-md-12">
												<h4>Basic Specifications</h4>
											</div>
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span> Car Brand : </label>
                                               <input type="text" name="carBrand" class="form-control boxed" placeholder="Enter Car Brand" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"> </span> Car Model : </label>
                                               <input type="text" name="carModel" class="form-control boxed" placeholder="Enter Car Model" required>   
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Model Variant Name: </label>
                                               <input type="text" name="variantName" class="form-control boxed" placeholder="Enter Variant Name" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>No of Gears : </label>
                                             <input type="text" name="gears" class="form-control boxed" placeholder="Enter No of Gears" onkeypress="CheckNumeric(event)" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"> </span> Car Production Year : </label>
                                               <input type="text" name="pYear" class="form-control boxed" placeholder="Car Production Year" required>   
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"> </span>End of year : </label>
                                               <input type="text" name="eYear" class="form-control boxed" placeholder="End of Year" required>   
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Transmission Type : </label>
                                             <select  class="form-control boxed" name="transmissionType" style=" height: 34px;" required>
															<option value="">Select</option>
															<option value="automatic">AUTOMATIC</option>
															<option value="manual">MANUAL</option>
													</select>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"> </span> Seating Capacity : </label>
                                               <input type="text" name="seatingCapacity" class="form-control boxed" placeholder="Enter Seating Capacity" required>   
                                                </div>
											</div>
											
											<div class="col-md-4"></div>
											<div class="col-md-4"></div>
											
											<div class="col-md-12">
											  <h4>Fuel Engine</h4>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Engine CC : </label>
                                               <input type="text" name="engineCC" class="form-control boxed" placeholder="Enter Engine CC" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Cylinders : </label>
                                               <input type="text" name="cylinders" class="form-control boxed" placeholder="Enter Cylinders" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Valves per cylinder : </label>
                                               <input type="text" name="vpCylinders" class="form-control boxed" placeholder="Enter Valves per cylinder" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Displacement : </label>
                                               <input type="text" name="displacement" class="form-control boxed" placeholder="Displacement" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Engine Type : </label>
                                               <input type="text" name="engineType" class="form-control boxed" placeholder="Enter Engine Type" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Fuel Type : </label>
                                               <select  class="form-control boxed" name="fuelType" style=" height: 34px;" required>
															<option value="">Select</option>
															<option value="petrol">PETROL</option>
															<option value="diesel">DIESEL</option>
															<option value="cng">CNG</option>
															<option value="lpg">LPG</option>
															<option value="electic">ELECTIC</option>
													</select>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>City(mpg) : </label>
                                              <input type="text" name="city" class="form-control boxed" placeholder="Enter City Mileage" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>HighWay(mpg) : </label>
                                              <input type="text" name="highway" class="form-control boxed" placeholder="Enter HighWay Mileage" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Fuel Tank : </label>
                                              <input type="text" name="fuelTank" class="form-control boxed" placeholder="Enter Fuel Tank" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Max Power : </label>
                                              <input type="text" name="maxPower" class="form-control boxed" placeholder="Enter Max Power" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Max Torque : </label>
                                              <input type="text" name="maxTorque" class="form-control boxed" placeholder="Enter Max Torque" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Fuel Tank Capacity : </label>
                                             <input type="text" name="tankCapacity" class="form-control boxed" placeholder="Enter Tank Capacity in Liters" required>
                                                </div>
											</div>
											
											<div class="col-md-12">
											  <h4>Drive</h4>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Wheel Drive : </label>
                                               <input type="text" name="wDrive" class="form-control boxed" placeholder="Enter Wheel Drive" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Total Max Power : </label>
                                               <input type="text" name="tmPower" class="form-control boxed" placeholder="Total Max Power" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Total Max Torque : </label>
                                               <input type="text" name="tmTorque" class="form-control boxed" placeholder="Total Max Torque" required>
                                                </div>
											</div>
											
											<div class="col-md-12">
											  <h4>Body</h4>
											</div>
											
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Length(In.) : </label>
                                               <input type="text" name="length" class="form-control boxed" placeholder="Enter Length" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Width(In.) : </label>
                                             <input type="text" name="width" class="form-control boxed" placeholder="Enter Width" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Height(In.) : </label>
                                            <input type="text" name="height" class="form-control boxed" class="form-control boxed" placeholder="Enter Height" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Wheelbase : </label>
                                              <input type="text" name="wheelBase" class="form-control boxed" placeholder="Enter Wheelbase" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Gross Vehicle Weight : </label>
                                           <input type="text" name="vehicleWeight" class="form-control boxed" placeholder="Enter Vehicle Weight" required>
                                                </div>
											</div>
											
											<div class="col-md-12">
											  <h4>Electric Engine Performance</h4>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Top Speed : </label>
                                             <input type="text" name="topSpeed" class="form-control boxed" placeholder="Enter Top Speed" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Average Consumption (kms) : </label>
                                             <input type="text" name="avgConsumption" class="form-control boxed" placeholder="Enter Arerage Consumption (kms)" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Co2 Emission : </label>
                                             <input type="text" name="co2Emission" class="form-control boxed" placeholder="Enter Co2 Emission" required>
                                                </div>
											</div>
											
											<div class="col-md-12">
											  <h4>Sample Warranty</h4>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Maintenance : </label>
                                           <input type="text" name="maintenance" class="form-control boxed" placeholder="Enter maintenance" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Basic Warranty : </label>
                                           <input type="text" name="basicWarranty" class="form-control boxed" placeholder="Enter Basic Warranty" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Car Body Warranty  : </label>
                                           <input type="text" name="crbWarranty" class="form-control boxed" placeholder="Enter Car Body Warranty" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Extended Warranty : </label>
                                           <input type="text" name="extendedWarranty" class="form-control boxed" placeholder="Enter Extended Warranty" required>
                                                </div>
											</div>
											
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Photo : </label>
                                               <input type="file" class="form-control boxed" name="photo" accept="image/*" placeholder="Select Image" required>
                                                </div>
											</div>
											<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Price : </label>
                                           <input type="text" name="price" class="form-control boxed" 	placeholder="Enter Price" required>
                                                </div>
											</div>
											
													<div class="col-md-12">
											  <h4>Security</h4>
											</div>
											
												<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Driver Air Bag : </label>
                                               <select  class="form-control boxed" name="dab" style="height: 34px;" required>
															<option value="">Select</option>
															<option value="yes">Yes</option>
															<option value="no">No</option>
													</select>
                                                </div>
											</div>
											
												<div class="col-md-4">
											  <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Passenger Air Bag : </label>
                                               <select  class="form-control boxed" name="bab" style="height: 34px;" required>
															<option value="">Select</option>
															<option value="yes">Yes</option>
															<option value="no">No</option>
													</select>
                                                </div>
											</div>
											
											<div class="col-md-12">
											   <div class="col-md-4"></div>
											   <div class="col-md-3"><button type="submit" class="btn btn-primary  btn-block" id="b1">ADD CAR</button></div>
											   <div class="col-md-2"><button type="reset" class="btn btn-danger  btn-block" id="b1">RESET</button></div>
											   <div class="col-md-5"></div>
											</div>
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