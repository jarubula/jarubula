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
<%@page
	import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./individualOwner.jsp" />
<jsp:include page="./topMenu.jsp" />
<script src="./css/countries.js" type="text/javascript"></script>
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
<script language="javascript">
 	function validate() {
 		
		if(document.getElementById("panNo").value.length >=0 ){
 		    
 		    if(document.getElementById("panNo").value.length==0){
 		     
 		    }else{
 		      var pan=document.getElementById("panNo").value;
 		      var panPat = /^([a-zA-Z]{5})(\d{4})([a-zA-Z]{1})$/;
 		      if(!panPat.test(pan)){
 		       alert("Invalid Pan Number");
 		       document.getElementById("panNo").focus();
 		       return false;
 		      }else{}
 		    }
 		}
 		if(document.getElementById("pinNo").value.length !=6 )
		 {
		  alert("Please enter 6 digits PINCODE No");
		  document.getElementById("pinNo").focus();
		  return false;
		 }
 		return true;
 	}
</script>

<script type="text/javascript">
         function checkSpcialChar(event){
            if(!((event.keyCode >= 65) && (event.keyCode <= 90) || (event.keyCode >= 97) && (event.keyCode <= 122) || (event.keyCode >= 48) && (event.keyCode <= 57))){
               event.returnValue = false;
               return;
            }
            event.returnValue = true;
         }
 </script>

<script>
	function RestrictSpace() {
		if (event.keyCode == 32) {
			event.returnValue = false;
			return false;
		}
	}
</script>
<script>
function NumAndTwoDecimals(event , obj){
	reg = /[^0-9.,]/g;
	obj.value =  obj.value.replace(reg,"");
 }
</script>
</head>
<body>
	<%
		String message = (String) request.getAttribute("success");
	%>
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
				<div> <h3 class="col-md-12" align="center">INDIVIDUAL OWNER DASHBOARD</h3></div>
				<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745; border-radius:4%">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive well" style="border-radius:4%">
										<form action="./UpdateIndividualProfileController"
											method="post" onSubmit="return validate()">
											<div class="col-md-12">
													<%
														if (message != null) {
													%>
													<h6 style="color: red">&nbsp;&nbsp;<%=message%>
													</h6>
													<%
														} else {
														}
													%>
										<div align="center" style="text-align: center; background-color: #523f6d; color: #fff;">
										VIEW PROFILE</div>
										</div>
										<br><br>
										<div class="col-md-12">
										<div align="center" style="text-align: center; background-color: #f9f9f9; color: #000;">
										<b>BASIC INFORMATION</b></div>
										</div><br><br>
												<%
													String email = (String) session.getAttribute("user");
													IndividualOwnerService profile = new IndividualOwnerService();
													IndividualOwnerRegister view = profile.getProfileDetails(email);
												%>
												<div class="col-md-3 pwell">
										<b>NAME</b>
										</div>
										<div class="col-md-3">
										<input type="text" name="name"
														value="<%=view.getNAME()%>"
														onkeypress="return checkSpcialChar(event)"
														class="form-control" required></input></div>
										<div class="col-md-3">
										<b>EMAIL ADDRESS</b>
										</div>
										<div class="col-md-3"><input type="text" name="email"
														class="form-control" value="<%=view.getEMAIL_ID()%>"
														required disabled></input></div>
														<div class="col-md-12 col-xs-12 col-sm-12"><br></div>
										<div class="col-md-3">
										<b>PANCARD</b>
										</div>
										<div class="col-md-3"><input type="text"
														value="<%=(view.getPANCARD_NO()== null || view.getPANCARD_NO().equals("null"))?"Enter Pan card":view.getPANCARD_NO()%>"
														class="form-control" name="pancardNo"
														id="panNo"></div>
										<div class="col-md-3">
										<b>MOBILE NO</b>
										</div>
										<div class="col-md-3"><input autocomplete="off"
														class="form-control" type="text"
														value="<%=view.getMOBILE_NO()%>" name="phoneNo"
														maxlength="10" required
														pattern="[1-9]{1}[0-9]{9}"
														title="Enter 10 digit mobile number"
														placeholder="Mobile Number" maxlength="10">
												</div>
												<div class="col-md-12 col-xs-12 col-sm-12"><br></div>
										<div class="col-md-3">
										<b>CITY</b>
										</div>
										<div class="col-md-3">
										<input type="text" class="form-control" id="city" name="city" value="<%=view.getCITY()%>" required>
										</div>
										<div class="col-md-3">
										<b>PINCODE</b>
										</div>
										<div class="col-md-3"><input type="text"
														value="<%=(view.getPINCODE_NO()==null || view.getPINCODE_NO().equals("null"))?"Enter Pincode":view.getPINCODE_NO()%>"
														class="form-control" name="pinNo" required
														onkeyup="NumAndTwoDecimals(event , this);" id="pinNo"
														maxlength="6"></div>
										
										<div class="col-md-6"><br><br>
										<div align="center">
										<button
											style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
											class="btn btn-primary">UPDATE</button>
										</div>
										</div>
										<div class="col-md-6"><br><br>
										<div align="center">
										<input
									    style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
									     type="reset" value="RESET" class="btn btn-primary" />
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

	<div class="ref" id="ref">
		<div class="color-primary"></div>
		<div class="chart">
			<div class="color-primary"></div>
			<div class="color-secondary"></div>
		</div>
	</div>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
	<pre>
 	</pre>
	<footer>Copyright &copy; vehicletracking.com</footer>
</body>
</html>