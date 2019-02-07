<%@ page language="java" import="com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*,java.io.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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


<meta charset="utf-8">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./DriverMenu.jsp" />
<jsp:include page="./topMenu1.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Vaahanmitra | DriverProfile</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<script type= "text/javascript" src = "./js/countries.js"></script>
<link rel="stylesheet" type="text/css" href="./css/myStyle.css" />
<link rel="stylesheet" type="text/css" href="./css/tcal.css" />
<script type="text/javascript" src="./js/tcal.js"></script>
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
<style>
	.td{
	 font-size: small;
	}
	</style>
	
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

	<style>
	 :required:focus {
	   box-shadow: 0  0 6px rgba(255,0,0,0.5);
	   border: 1px red solid;
	   outline: 0;
	 }
	</style>
	
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">


			<header class="">
			<div class="header-block header-block-collapse hidden-lg-up">
				<button class="collapse-btn" id="sidebar-collapse-btn">
					<i class="fa fa-bars"></i>
				</button>
			</div>

			<div class="header-block header-block-nav">
<!-- 				<ul class="nav-profile"> -->

<!-- 					<li class="profile dropdown"><a -->
<!-- 						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" -->
<!-- 						role="button" aria-haspopup="true" aria-expanded="false"> -->
<!-- 							<div class="img" style=""></div> <span class="name"> Mohan -->
<!-- 								Amasa</span> -->
<!-- 					</a> -->
<!-- 						<div class="dropdown-menu profile-dropdown-menu" -->
<!-- 							aria-labelledby="dropdownMenu1"> -->

<!-- 							<a class="dropdown-item" href="#"> <i -->
<!-- 								class="fa fa-power-off icon"></i> Logout -->
<!-- 							</a> -->
<!-- 						</div></li> -->
<!-- 				</ul> -->
			</div>
			</header>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content responsive-tables-page" style="background-color:#fff"> 
			<section class="section">
			<div class="row">
				<div class="col-md-12">
					<div class="card" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive">
					 		<form action="./UpdateDriverAvailabilityD" method="post">
<%
String message=(String)request.getAttribute("message");
if(message!=null){
	%><%=message %>
<%	
}else{
	
}
%>
<%
ArrayList<DriverBean> driverAl=(ArrayList<DriverBean>)request.getAttribute("driverAl"); 

%>
<%
String state=(String)request.getAttribute("state");
String dist=(String)request.getAttribute("dist");
String permitType=(String)request.getAttribute("permitType");
String range=(String)request.getAttribute("range");
%>
<table class="table table-striped table-bordered">
<tr style="color: #e65c00;">
<td></td>
<td>
<div class="form-group">
<div class="col-sm-12">DRIVER NAME</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">LICENSE NO</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">LICENSE TYPE</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">EXPIRY DATE</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">DRIVING EXP</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">PERMIT TYPE</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">WITHIN RANGE</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">DRIVER AVAILABILITY</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">LICENSE DOC</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">PHOTO</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">UPDATE DRIVER</br>AVAILABILITY</div>
</div>
</td>
</tr>

<c:forEach var="driverDet" items="${driverAl}">
<%! int i=0, j=1; %>
<tr style="color: #f38504;">
<td>
<a id="toggle" onClick="toggle_it('<%="tr"+i %>');toggle_it('<%="tf"+j%>')" class="btn btn-primary" style="padding:5px">More Details</a>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<c:out value="${driverDet.FIRST_NAME}"></c:out>&nbsp;&nbsp;<c:out value="${driverDet.LAST_NAME}"></c:out>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<c:out value="${driverDet.LICENSE_NO}"></c:out>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<c:out value="${driverDet.LICENSE_TYPE}"></c:out>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<c:out value="${driverDet.EXPIRY_DATE}"></c:out>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<c:out value="${driverDet.DRIVING_EXP}"></c:out>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<c:out value="${driverDet.PERMIT_TYPE}"></c:out>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<c:out value="${driverDet.WITHIN_RANGE}"></c:out>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<c:out value="${driverDet.DRIVER_AVAILABILITY}"></c:out>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<img src="data:image/jpeg;base64,${driverDet.LICENSE_DOC}" alt="No image" width="100%" height="100%">
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<img src="data:image/jpeg;base64,${driverDet.PHOTO}" alt="No image" width="100%" height="100%">
</div>
</div>
</td>
<td align="center">
<div class="form-group">
<div class="col-sm-12">
<input type="checkbox" name="availability" value="${driverDet.SEQ_DRIVER_ID}" align="middle" required/>
</div>
</div>
</td>
</tr>
<tr id="<%="tr"+i %>" style="color: #5074b8;display:none">
<td>
<div class="form-group">
<div class="col-sm-12"><b>EMAIL</b></div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12"><b>MOBILE NO</b></div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12"><b>DOB</b></div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12"><b>ADDRESS</b></div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12"><b>STREET</b></div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12"><b>CITY</b></div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12"><b>STATE</b></div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12"><b>DISTRICT</b></div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12"><b>MANDAL</b></div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12"><b>REGISTERED STATE</b></div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12"><b>ADHAR NO</b></div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12"><b>PAN NO</b></div>
</div>
</td>
</tr>
<tr id="<%="tf"+j %>" style="color: #5074b8;display:none">
<td>
<div class="form-group">
<div class="col-sm-12">
<b><c:out value="${driverDet.EMAIL}"></c:out></b>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<b><c:out value="${driverDet.MOBILE_NO}"></c:out></b>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<b><c:out value="${driverDet.DOB}"></c:out></b>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<b><c:out value="${driverDet.ADDRESS}"></c:out></b>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<b><c:out value="${driverDet.STREET}"></c:out></b>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<b><c:out value="${driverDet.CITY}"></c:out></b>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<b><c:out value="${driverDet.STATE}"></c:out></b>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<b><c:out value="${driverDet.DISTRICT}"></c:out></b>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<b><c:out value="${driverDet.MANDAL}"></c:out></b>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<b><c:out value="${driverDet.REGISTERED_STATE}"></c:out></b>
</div>
</div>
</td>

<td>
<div class="form-group">
<div class="col-sm-12">
<b><c:out value="${driverDet.ADHAR_NO}"></c:out></b>
</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<b><c:out value="${driverDet.PAN_NO}"></c:out></b>
</div>
</div>
</td>
<td><input type="hidden" name="state" value="<%=state %>"/>
<input type="hidden" name="dist" value="<%=dist %>"/>
<input type="hidden" name="permitType" value="<%=permitType %>"/>
<input type="hidden" name="range" value="<%=range %>"/></td>

<%-- <td> <img src="http://localhost:8887/FryteMate/SearchDriver?id=${driverDet.LICENSE_DOC}" width="100px" hight="100px"/></td> --%>
<%-- <td class="font"><c:out value="${driverDet.LICENSE_DOC}" ${pageContext.servletContext.contextPath }></c:out></td>
<td class="font"><c:out value="${driverDet.PHOTO}"></c:out></td> --%>
</tr>
<%i++;j++; %>
</c:forEach>
<tr>
<td colspan="12" align="center"><input type="submit" value="Submit" align="middle"/></td>
</tr>
</table>
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
	<script language="javascript">
		populateBrands("brand", "model");
 	</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>

</html>