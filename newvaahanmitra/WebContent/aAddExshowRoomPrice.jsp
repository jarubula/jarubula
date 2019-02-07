<%
try {
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
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
	import="com.vaahanmitra.dao.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<jsp:include page="./AdminMenu.jsp" />
<jsp:include page="./Admin-right-side.jsp" />

<script src="./css/countries.js" type="text/javascript"></script>

<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<!-- Theme initialization -->
<script>
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
/* ~~~~~~~~~~~~~~~~~~~~ validation~~~~~~~~~~~~~~~ */
   
   /* ~~~~~~~~~~~~~~~~~~~~end validation~~~~~~~~~~~~~~~ */			
        </script>
        
       <script type="text/javascript">
       function valid(){
			
			var x= document.forms["update"]["userType"].value;
			
			if (x == ""){
				alert("please enter the userType");
				return false;
			}
			
		}</script> 
      
						
					
  <style>
 #baki1{
     background: #fff;
    box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15);
    border-bottom: 3px solid #a3b745;
    border-radius: 5px;
    padding-left: 0;
    }
      .baki2{
    font-size: 23px;
    color: #efa844;
    font-weight: 500;
    font-family: sans-serif;
        text-align: center;
    }
    label {
    display: inline-block;
    margin-bottom: .2rem;
    font-weight: 500 !important;
    font-size: 16px;
    color: #000;
}
 .form-control.underlined {
        padding-left: 5px;
    padding-right: 0;
    }
.form-control {
    padding: 0 5px;
    display: block;
    width: 100%;
    font-size: 1rem;
    line-height: 1.5;
    color: #55595c;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: .25rem;
    height:29px !important;
    font-size: 15px !important;
}
/* .form-control.underlined {
    padding-left: 0;
    padding-right: 0;
    border-radius: 0;
    border: none;
    border-radius: 0;
    box-shadow: none;
    border-bottom: 1px solid #ffffff;
   
} */

app.css:842
.
.select-filters select {
    background: 0 0;
    width: 100%;
    padding: 7px 0px 0px 10px;
    border: 0;
    border-radius: 0;
    height: 28px;
    margin: 0;
    /* font-size: 12px; */
    color: #888;
    font-weight: 400;
    -moz-appearance: window;
    -webkit-appearance: none;
    cursor: pointer;
}
.select-filters {
       width: 100%;
    overflow: hidden;
    height: 29px;
    background: url(../images/down-arrow.png) right center no-repeat #fff;
    margin: 0;
    padding: 0;
    border: 1px solid #ddd;
    display: block;
    border-radius: 3px;
}
#b1{
    border-radius: 5px;
    border: 1px solid #fff;
    line-height: 19px;
    }

 </style>
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">

			<header class="">
			
			<div class="header-block header-block-nav">
			</div>
			</header>
			<br>

			<article class="content responsive-tables-page"
				style="background-color:#fff">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div align="center" style="font-size: 25px">ADMIN DASHBOARD</div>
			</div>
			<section class="section">

			<div class="row">

				<div class="col-md-12 col-sm-12 col-xs-12" id="baki1">
					<div class="">
						<div class="">
						
						
						
							<section class="example">
							<form action="./AdminGetExshowPriceByVarient" method="post" name="update" onsubmit="return valid()">
							<div class="table-responsive">
								<%
									String message = (String) request.getAttribute("success");
								%>
								
									<div class="col-md-12 col-xs-12">
										<p></p>
										<div class="col-md-12 baki2">
											<h4>Select Car Variant </h4>
											
										</div>
										</div>
										<br>
										<input type="hidden" name="userType" value="AD" required>
										
										<div class="col-md-12"><br></div>
									<div class="col-md-3 col-sm-6 col-xsm-12">
							<label>Vehicle Brand :</label>
								<div class="select-filters" id="txtHint20">
									<jsp:include page="./getADNewVecleBrand.jsp"><jsp:param name="vType" value="4,"/></jsp:include>
								</div>
						</div>
						<div class="col-md-3 col-sm-6 col-xsm-12">
							<div class="form-group">
									<label for="email">Vehicle Model :</label>
									
									<div class="select-filters" id="txtHintD">
										<select name="vehicleModel" class="form-control"  style="border: 1px solid #fff;"  required>
											<option value="" style="display: none;">Vehicle Model</option>
										</select>
									</div>
								</div></div>
								<div class="col-md-3 col-sm-6 col-xsm-12">
							<div class="form-group">
									<label for="email">Vehicle Variant :</label>
									
									<div class="select-filters" id="txtHintV">
										<select name="vehicleVariant" class="form-control" style="border: 1px solid #fff;"  required>
											<option value="" style="display: none;">Vehicle Variant</option>
										</select >
										
									</div>
								</div></div>
								
								
								
								<div class="col-md-2 col-sm-6 col-xsm-12 " style="margin: 25px 0px;">
								 <input type="hidden" value="jsp" name="v_page">
												<button type="submit" class="btn btn-primary btn-block" id="b1" >SUBMIT</button>
											</div>
											<div class="col-md-1 col-sm-6 col-xsm-12 " style="margin: 25px 0px;"></div>
												<!-- <button TYPE="submit"
													style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
													class="btn btn-primary">SUBMIT</button> -->
											</div>
										
											<div class="col-md-2 "></div>
											
											<div class="col-md-12 col-xs-12" align="center">
										<%
												if (message != null) {
											%>
											<h5 style="color: red"><%=message%>
											</h5>
											<%
												} else {
												}
											%>
									</div></form>
									</section>
									
									</div>
						</div></div>
					</div>
					</section>
					</article>
				</div>
			
         </div>
         
        <!-- /page content -->
        <!-- footer content -->
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
	<!-- </div>
	</div> -->
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
	
	
	      <script>
	function getVehicleModels(str) {
		var vType ="4,";
		if (str == "") {
			document.getElementById("txtHintD").innerHTML = "";
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
				document.getElementById("txtHintD").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./getADNewVecleModel.jsp?vBrand="+str+ "&vType="+ vType, true);
		xmlhttp.send();
	}
</script>

	      <script>
	function getVehicleVariant(str) {
		
		var vType ="4,";
		if (str == "") {
			document.getElementById("txtHintV").innerHTML = "";
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
				document.getElementById("txtHintV").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./getADNewCarVariant.jsp?vmodel="+str+ "&vType="+ vType, true);
		xmlhttp.send();
	}
</script>
<script type="text/javascript">
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


<script>
function toggle_it(itemID){ 
    // Toggle visibility between none and '' 
    if ((document.getElementById(itemID).style.display == 'none')) {
          document.getElementById(itemID).style.display = '' 
          event.preventDefault()
    } else { 
          document.getElementById(itemID).style.display = 'none'; 
          event.preventDefault()
    }    
} 

</script>
</body>
</html>