<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<script src="./css/countries.js" type="text/javascript"></script>
<jsp:include page="./carMenu.jsp" />
<%-- <jsp:include page="./right-side.jsp" /> --%>
<jsp:include page="./topMenu.jsp" />
<link rel="stylesheet" href="css/vendor.css">
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
function NumAndTwoDecimals(event , obj){
	reg = /[^0-9.,]/g;
	obj.value =  obj.value.replace(reg,"");
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
 		if(document.getElementById("pincodeNo").value.length !=6 )
		 {
		  alert("Please enter 6 digits PINCODE No");
		  document.getElementById("pincodeNo").focus();
		  return false;
		 }

 		if(document.getElementById("bPhoneNo").value.length !=11 )
 		{
 		  alert("Please enter 11 digits Office Phone No.");
 		  document.getElementById("bPhoneNo").focus();
 		  return false;
 		}
 		if(document.getElementById("bpincodeNo").value.length !=6 )
 		{
 		  alert("Please enter 6 digits PINCODE No");
 		  document.getElementById("bpincodeNo").focus();
 		  return false;
 		}
 		return true;
 	}

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
#two1{
    border: 1px solid #ccc;
    width: 100%;
    min-height: 36px;
    border-radius: 3px;
    padding: 5px 3px;
    }
      </style>
</head>
<body>


	<div class="main-wrapper">
		<div class="app" id="app">
			<header class="" style="font-family: 'Oswald', sans-serif;">
			<div class="header-block header-block-nav">
			</div>
			</header>
			<article class="content responsive-tables-page"
					style="background-color:#fff"> <section class="section">
				<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
		<%String message =(String)request.getAttribute("success"); %>
		<div  align="center"><h3>SERVICE CENTER DASHBOARD</h3></div>
		</div>
					<div class="col-md-12 col-xs-12 col-sm-12">
						<div class="card" id="individual1"> 
							<div class="card-block">
								<div class="">
									<form action="./UpdateServiceCenterController"
										method="post" onSubmit="return validate()"
									enctype="multipart/form-data">
										<% if(message!=null){%>
										<h6 style="color: red"><%= message %>
										</h6>
										<%}else{}%>
										
		<!--  <div class="col-md-12 col-sm-12 col-xs-12" align="center" style="text-align: center; background-color: #523f6d; color: #fff;">
										UPDATE SERVICE CENTER
										
										</div> -->
									
										 <%
												String email = (String) session.getAttribute("user");
												BusinessOwnerService profile = new BusinessOwnerService();
												BusinessOwnerRegister view = profile.getProfileDetails(email);
											%> 
							<div class="col-md-12" id="one1">CONTACT ADDRESS</div>
											
							<div class="row">
							<div class="col-sm-4 form-group">
							<label>Name : </label>
							<input type="text" name="name" class="form-control"
															onkeypress="return checkSpcialChar(event)" value="<%=view.getNAME()%>"placeholder="Enter First Name" required>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>Email :</label>
							<input type="email" autocomplete="off" name="emailId"
															value="<%=view.getEMAIL_ID()%>" class="form-control" placeholder="Enter Email" required disabled>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>Pancard No :</label>
							<input type="text" class="form-control" id="panNo"
														value="<%=view.getPANCARD_NO()%>" maxlength="10" placeholder="Enter Pancard No" name="panno" required>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>Mobile No :</label>
							<input autocomplete="off" type="text" class="form-control" name="phoneNo"
														id="mobileNo" pattern="[1-9]{1}[0-9]{9}" title="Enter 10 digit mobile number" placeholder="Mobile Number" maxlength="10" required
														value="<%=view.getMOBILE_NO()%>">
							</div>
							
							<div class="col-sm-4 form-group">
							<label>City :</label>
							<input type="text" class="form-control" id="city" name="city" value="<%=view.getCITY()%>" required>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>Pincode No :</label>
							<input type="text" class="form-control"
														value="<%=view.getPINCODE_NO()%>"
														placeholder="Enter Pincode NO" name="pinNo" required maxlength="6"
														id="pincodeNo" onkeyup="NumAndTwoDecimals(event , this);">
							</div>
							
							<div class="col-sm-4 form-group">
							<label>Photo :</label>
							<img src="data:image/png;base64,<%=view.getPHOTO()%>"
														alt="No image"  width="150px" height="120px" class="img-rounded"> <input
														id="two1"  type="file" value="update" name="photo" accept="image/*"required">
							            <input type="hidden" class="form-control" id="two1" name="image"
														value="<%=view.getPHOTO()%>">
														</div>
						    </div>
						    
						    <div class="col-md-12" id="one1">BUSINESS ADDRESS</div>
							
						    <div class="row">
							<div class="col-sm-4 form-group">
							<label>Business Name : </label>
							 	<input type="text" class="form-control" name="bName"
															value="<%=view.getBUSINESS_NAME()%>" onkeypress="return checkSpcialChar(event)"
															placeholder="Enter Business Name" required>
														<div id="msg3" style="color: #FF0000"></div>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>Address :</label>
						    <input type="text" name="businessAddress" value="<%=view.getADDRESS()%>"
									placeholder="Enter Business Address" class="form-control" required>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>City :</label>
							<input type="text" class="form-control" id="panNo"
														value="<%=view.getPANCARD_NO()%>" maxlength="10" placeholder="Enter Pancard No" name="panno" required>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>Mobile No :</label>
							<input autocomplete="off" type="text" class="form-control" name="phoneNo"
														id="mobileNo" pattern="[1-9]{1}[0-9]{9}" title="Enter 10 digit mobile number" placeholder="Mobile Number" maxlength="10" required
														value="<%=view.getMOBILE_NO()%>">
							</div>
							
							<div class="col-sm-4 form-group">
							<label>City :</label>
							<input type="text" class="form-control" id="city" name="bcity" value="<%=view.getB_CITY()%>" required>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>State :</label>
							<div class="form-group">
							<select id="country1" required name="state1"
															class="form-control form-control-sm" required>
														</select>
							</div>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>District :</label>
							<div class="form-group">
														<select id="state1" required name="district1"
															class="form-control form-control-sm" required>
															<option value="<%=view.getDISTRICT()%>"><%=view.getDISTRICT()%></option>
														</select>
													</div>
														</div>
														
														
							<div class="col-sm-4 form-group">
							<label>Office Phone No :</label>
							<input type="text" onkeypress="CheckNumeric(event)"
															value="<%=view.getOFFICE_PHONE_NO()%>" maxlength="11"
															placeholder="Enter Office Phone No" name="bPhoneNo"
															id="bPhoneNo" class="form-control" required>
							</div>
							
							<div class="col-sm-4 form-group">
							<label>Pincode :</label>
							<input type="text" class="form-control"
															placeholder="Enter Pincode No" name="bpincodeNo"
															value="<%=view.getOFFICE_PINCODE_NO()%>" id="bpincodeNo" maxlength="6"
															onkeyup="NumAndTwoDecimals(event , this);" required>
							</div>
							
						    </div>			 
								
							<div class="row">
							<div class="col-sm-4 form-group"></div>
							<div class="col-sm-4 form-group">
							 <div class="col-sm-6 form-group"><button type="submit" onclick="return(svalidate1())" class="btn btn-danger btn-block" style="border: 1px solid #fff; border-radius: 6px;">UPDATE</button></div>
							 <div class="col-sm-6 form-group"> <button type="reset" value="RESET" class="btn btn-info btn-block" style="border: 1px solid #fff; border-radius: 6px;">RESET</button></div>
							</div>
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
	<script language="javascript">
			populateCountries("country1", "state1");
		</script>

	<pre>
 	</pre>
	<footer>Copyright &copy; vehicletracking.com</footer>
	<script>
			var state1="<%=view.getSTATE()%>";
$("select[name=state1] option:first").val(state1);
$("select[name=state1] option:first").text(state1);
</script></body>
</html>
