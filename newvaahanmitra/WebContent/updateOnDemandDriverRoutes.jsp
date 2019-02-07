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
<%@ page language="java" import="com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*,java.io.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./DriverMenu.jsp" />
<jsp:include page="./topMenu1.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
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
	<script type="text/javascript">
	
	function validate(){
		
		if(document.getElementsByName("status").length<2){
			
			alert("Please select any checkboxes");
			
		}
		
	}
	
	
function yesno(thecheckbox, thelabel){
            var checkboxvar = document.getElementById(thecheckbox);
            var labelvar = document.getElementById(thelabel);
            if (checkboxvar.checked == false){
                labelvar.innerHTML = "ACTIVE";
                labelvar.style.color="black";
            }
            else{
                labelvar.innerHTML = "INACTIVE";
                labelvar.style.color="red";
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
							<%
								ArrayList<OnDemandDriverRoutes> al=(ArrayList<OnDemandDriverRoutes>)request.getAttribute("driverRts");
								%>
							<%if(al.size()<=0){out.write("you are not entered preffered routes..");}else{} %>
							

<table class="table table-striped table-bordered">
<thead>
<tr>
<th colspan="10" style="background: #052963;color: #fff;text-align: center;font-weight: bolder;">DRIVER PREFERRED ROUTES</th>
</tr>
</thead>
<tbody>
<tr>
<td>
<div class="form-group">
<div class="col-sm-12">FROM CITY</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">TO CITY</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">DATE</div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">TIME</div>
</div>
</td>
</tr>
<% int i=1,j=1; %>
<c:forEach var="driverRts" items="${driverRts}">
<tr>
<td>
<div class="form-group">
<div class="col-sm-12"><c:out value="${driverRts.FROM_CITY}" ></c:out></div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12"><c:out value="${driverRts.TO_CITY}" ></c:out></div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12"><c:out value="${driverRts.DATE}" ></c:out></div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12"><c:out value="${driverRts.TIME}" ></c:out></div>
</div>
</td>
<td>
<div class="form-group">
<div class="col-sm-12">
<form action="./UpdateOnDemandDriverRoutes" method="post">
<input type="hidden" name="id" value="${driverRts.ON_DEMAND_ROUTE_ID}"/>
<input type="hidden" name="status" value="${driverRts.STATUS}"/>
<input type="submit" value="<c:out value="${driverRts.STATUS}"></c:out>"  style="background-color: #a3b745;border: 1px solid #a3b745;" class="btn btn-primary"/>
</form>
</div>
</div>
</td>
<%-- <td>
<div class="form-group">
<div class="col-sm-12"><input type="checkbox" name="status" id="<%="smoking"+j %>" value="${driverRts.SEQ_DROUTE_ID}" onclick="yesno('<%="smoking"+j %>','<%="yesnos"+i %>');"/></div>
</div>
</td> --%>
</tr>
<%i++;j++; %>
</c:forEach>
<tr>

</tr>
</tbody>
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