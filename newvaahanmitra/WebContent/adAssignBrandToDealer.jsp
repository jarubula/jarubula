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
<script src="./css/countries.js" type="text/javascript"></script>
<jsp:include page="./AdminMenu.jsp" />
<jsp:include page="./Admin-right-side.jsp" />
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>VaahanMitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
        <meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<!-- Theme initialization -->
<script language="javascript">
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
<script src="./css/countries.js" type="text/javascript"></script>
<script language="javascript">
 	function validate() {
 		if(document.getElementById("pincodeNo").value!="")
 			{
 		if(document.getElementById("pincodeNo").value.length !=6 )
		 {
		  alert("Please enter 6 digits PINCODE No");
		  document.getElementById("pincodeNo").focus();
		  return false;
		 }
 			}
 		if(document.getElementById("phoneNo").value.length !=11 )
		 {
		  alert("Please enter 11 digits PHONE No.");
		  document.getElementById("phoneNo").focus();
		  return false;
		 }
 		if(document.getElementById("bpincodeNo").value.length !=6 )
		 {
		  alert("Please enter 6 digits BUSINESS PINCODE No");
		  document.getElementById("bpincodeNo").focus();
		  return false;
		 }
 		if(document.getElementById("mobileNo").value!="" )
		 {
 		if(document.getElementById("mobileNo").value.length !=10 )
		 {
		  alert("Please enter 10 digits PHONE No.");
		  document.getElementById("mobileNo").focus();
		  return false;
		 }
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
	</script>
<style type="text/css">
.r_1 {
	border-radius: 10%;
	margin-top: 10px;
}

  /* .multiselect {
  width: 200px;
} */

.selectBox {
  position: relative;
 /*  min-height: 36px; */
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
  /* border: 1px #dadada solid; */
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

function showCheckboxes1() {
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
					<!-- <div class="card" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-bottom: 3px solid #a3b745;">
                                    <div class="card-block" style="border-bottom: 3px solid #a3b745;">
                                    </div>
                                </div> -->
					<section class="example">
					<div class="table-responsive">
						<form name="frm" action="./AdAssignBrandsToDealer" method="post"
							onSubmit="return validate()">
							<div class="container col-lg-10 col-md-10 col-sm-12 col-xsm-12">
								<div class="form-group">
									<div class="col-sm-12">
										<h5 align="center">
											<u>Assign Brand To Dealer</u>
										</h5>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-12">
										<label for="email"> <%try{if(request.getAttribute("message")!=null){out.println(request.getAttribute("message"));}}catch(Exception e){} %>
										</label>
									</div>
									<%
                            		String email = request.getParameter("boid");
                            		if(email==null){
                            			email = (String)request.getAttribute("email");
                            		}
               					%>
								</div>


								<div class="form-group">
									<div class="col-sm-12">
										<label for="email">Email Id</label>
											<input class="form-control underlined" type="text" placeholder="Enter Name" name="email" id="name" value="<%=email%>" readonly>
									</div>
									
								</div>
								<%	
									BusinessOwnerService bos = new BusinessOwnerService();
									BusinessOwnerRegister bor = bos.getAddressDetails(email);	
								%>
								<div class="form-group">
									<div class="col-sm-6">
										<label for="email">City</label>
											<select class="form-control underlined" name="city" id="city" required>
											<option value="<%=bor.getB_CITY()%>"><%=bor.getB_CITY()%></option>
										</select>
									</div>
									<div class="col-sm-6">
										<label for="email">Vechicle Type</label> 
										<select class="form-control underlined" name="vType" id="vBrand" onchange="getUsedVcleBrand(this.value)" required>
											<option value="">Select</option>
											<option value="2,">Two Wheeler</option>
											<option value="4,">Four Wheeler</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-6">
										<label for="email">Brand</label>
										<div class="select-filters" id="txtHint2">
											<select name="vehicleBrand" class="form-control underlined" id="vModel">
												<option value="SELECT" style="display: none;">SELECT
													BRAND</option>
											</select>
										</div>
									</div>
									<div class="col-sm-6">
										<label>Model</label>
										<div class="select-filters" id="txtHintH">
											<select name="vehicleModel" class="form-control underlined">
												<option value="SELECT" style="display: none;">SELECT MODEL</option>
											</select>
										</div>
										
										<!-- <div class="multiselect">
    <div class="selectBox" onclick="showCheckboxes1()">
      <select class="form-control">
        <option>Select an option</option>
      </select>
      <div class="overSelect "></div>
    </div>
    <div id="checkboxes">
      <label for="one" id="size">
        <input type="checkbox" id="one" />First checkbox</label>
      <label for="two">
        <input type="checkbox" id="two" />Second checkbox</label>
      <label for="three">
        <input type="checkbox" id="three" />Third checkbox</label>
    </div>
  </div> -->
									</div>
								</div>
<div class="col-md-12 col-xs-12"></div>
								<div class="form-group">
									<div class="col-sm-4" align="center"></div>
									<div class="col-sm-4" align="center">
										<button type="submit" class="btn btn-primary r_1">Submit</button>
									</div>
									<div class="col-sm-4" align="center"></div>
								</div>
							</div>
						</form>
					</div>
					</section>
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
	<script>
function getUsedVcleBrand(str)
{
	if (str=="")  
	{  
		document.getElementById("txtHint2").innerHTML="";  
		return;  
		}  
	if (window.XMLHttpRequest)  
	{
		// code for IE7+, Firefox, Chrome, Opera, Safari  
		xmlhttp=new XMLHttpRequest();  
		}
	else  
	{
		// code for IE6, IE5  
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
	xmlhttp.onreadystatechange=function()  
	{  
		if (xmlhttp.readyState==4 && xmlhttp.status==200)    
		{    
			document.getElementById("txtHint2").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./getADNewVecleBrand.jsp?vType="+str,true);   
	xmlhttp.send();    
	}
	</script>
	<script>
	function getVehicleModels(str) {
		alert(str);
		var vType = document.getElementById("vBrand").value;
		alert(vType);
		if (str == "") {
			document.getElementById("txtHintH").innerHTML = "";
			return;
		}
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari  
			xmlhttp = new XMLHttpRequest();
		} else {
			// code for IE6, IE5  
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("txtHintH").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./getADNewVecleModel.jsp?vBrand="+str+ "&vType="+ vType, true);
		xmlhttp.send();
	}
</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>
</html>