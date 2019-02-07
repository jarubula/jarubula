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
<%@ page language="java" import="java.util.*,com.vaahanmitra.model.*" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<jsp:include page="./AdminMenu.jsp" />
<jsp:include page="./Admin-right-side.jsp" />
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="description" content="Vaahanmitra, service center, used cars, mechanics">
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
        </script>
<script type="text/javascript">
function getBusinessName(str)
{
	var usertype="UD";
if (str=="")
  {
  document.getElementById("txtHint").innerHTML="";
  return;
  }  
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","BusinessOwnersBNames.jsp?bcity="+str+"&usertype="+usertype,true);
xmlhttp.send();
  
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

			<!-- <div class="header-block header-block-nav">
				<ul class="nav-profile"> <li class="profile dropdown">
				 <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"> 
				   <div class="img" style=""> </div> <span class="name"> Mohan Amasa</span> </a> 
				     <div class="dropdown-menu profile-dropdown-menu" aria-labelledby="dropdownMenu1"> 
				     <a class="dropdown-item" href="#"> <i class="fa fa-power-off icon"></i> Logout </a> 
				         </div> 
				             </li>
				               </ul>
			</div> -->
			</header>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive">
							<%
							ArrayList<BusinessOwnerRegister> al=new ArrayList<BusinessOwnerRegister>();
							al=(ArrayList<BusinessOwnerRegister>)request.getAttribute("businessOwnerDetails");
							Iterator itr= al.iterator();
							%>
							<div class="col-md-12 row" >
							<section class="col-md-3"
								 style="font-size: 16px; text-align:left;"><strong><u><i>Used Vehicle Dealers</i></u></strong></section>
								<form action="./SearchBusinessOwners" method="post">
								<section class="col-md-2">
								<input type="hidden" name="k" value="UD">
								<jsp:include page="./BusinessOwnerBCity.jsp">
								<jsp:param name="usertype" value="UD"></jsp:param>
								</jsp:include>
								</section>
								<section class="col-md-2">
								<select name="vehicletype" class="form-control underlined">
								<option>Vehicle Type</option>
								<option>All</option>
								<option value="2">Two Wheeler</option>
								<option value="4">Four Wheeler</option>
								</select>
								</section>
								<section class="col-md-3">
								<div id="txtHint">
								<select name="bname" class="form-control underlined">
								<option>Business Name</option>
								</select>
								</div>
								</section>
								<section class="col-md-2">
								<input class="btn-primary btn-sm" type="submit" value="Search">
								</section>
								</form>
						</div>
							<div class="col-md-12"
							style="font-family: 'Roboto', sans-serif; background-color: #fff; border-radius: 4px; margin-bottom: 7px; position: relative; right: 20px;">
							<section class="col-md-3"
								 style="font-size: 14px;text-align:center;"><strong>BUSINESS NAME</strong></section>
							<section class="col-md-3"
								 style="font-size: 14px;text-align:center;"><strong>ADDRESS</strong></section>
							<section class="col-md-2"
								 style="font-size: 14px;text-align:center;"><strong>STATE</strong></section>
							<section class="col-md-2"  style="font-size: 14px;text-align:center;"><strong>PHONE NO.</strong>
							</section>
							<section class="col-md-2"  style="font-size: 14px;text-align:center;"><strong>POSTED BY</strong>
							</section>
						</div>
						<%
						while(itr.hasNext()){
							BusinessOwnerRegister bo=(BusinessOwnerRegister)itr.next();
						%>
						<div class="col-md-12"
							style="font-family: 'Roboto', sans-serif; border-radius: 4px; margin-bottom: 7px; position: relative; right: 20px;">
							<section class="col-md-3"
								 style="font-size: 14px;"><a href="./AdUpdateBusinessOwner.jsp?k=SC&boid=<%=bo.getSEQUENTIAL_NO()%>"><%=bo.getBUSINESS_NAME()%></a></section>
							<section class="col-md-3"
								 style="font-size: 14px;"><%=bo.getADDRESS()%>,&nbsp;<strong><%=bo.getB_CITY()%></strong></section>
							<section class="col-md-2"
								 style="font-size: 14px;"><%=bo.getSTATE()%></section>
							<section class="col-md-2"  style="font-size: 14px;text-align:center;"><%=bo.getOFFICE_PHONE_NO()%>
							</section>
							<section class="col-md-2"  style="font-size: 14px;text-align:center;">
							<%if(bo.getEMAIL_ID().equals("NA"))
								{%>
								<img src="./assets/user-admin-gear.png" width="15px" height="20px"></img>
								<%}else
								{%>
								<img src="./assets/blue-user-icon.png" width="15px" height="20px"></img>
								<%} %>
							</section>
						</div>
						<%} %>
						<div class="col-md-12">
						<section style="font-size: 11px;">
						<img src="./assets/user-admin-gear.png" width="15px" height="20px">Admin Posted</img>
						&nbsp;<img src="./assets/blue-user-icon.png" width="15px" height="20px">Own Registered</img>
						</section>
						</div>
						<div>Pages <c:forEach begin="1" end="${numofpages}" var="i">
				<td><a href="./SearchBusinessOwners?k=UsedVehicleDealer&page=${i}">${i}</a></td>
			</c:forEach></div>
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
			populateCountries("country", "state");
		</script>
	<script language="javascript">
		populateBrands("brand", "model");
 	</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>

</html>