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
<%@ page language="java" import="java.util.*,com.vaahanmitra.model.*,com.vaahanmitra.utilities.*" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vehicletracking</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<jsp:include page="./AdminMenu.jsp" />
<jsp:include page="./Admin-right-side.jsp" />
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>AddCar</title>
<meta name="description" content="Vaahanmitra, service center, used cars, mechanics">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//geodata.solutions/includes/statecity.js"></script>
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
	var usertype="SC";
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
							String state=new VerifyFieldsUtil().verifyString(request.getParameter("tstate"));
							String city=new VerifyFieldsUtil().verifyString(request.getParameter("tcity"));
							String mailid=new VerifyFieldsUtil().verifyString(request.getParameter("mailid"));
							String mobile=new VerifyFieldsUtil().verifyString(request.getParameter("mobile"));
							ArrayList<IndividualOwnerRegister> al=new ArrayList<IndividualOwnerRegister>();
							al=(ArrayList<IndividualOwnerRegister>)request.getAttribute("IndividualOwnerDetails");
							Iterator itr= al.iterator();
							%>
							<div class="col-md-12 row" >
								<form action="./AdSearchInOwner" method="post">
								<section class="col-md-3">
								<input type="hidden" name="country" id="countryId" value="IN" />
								<select name="tstate" class="form-control states order-alpha underlined" id="stateId">
								<%
								if(!state.equals("NA"))
								{%>
									<option><%=state%></option>
								<%}else
								{
								%>
									<option value="">Select State</option>
									<%} %>
								</select>
								</section>
								<section class="col-md-3">
								<abbr title="Type Your City">
								<select name="tcity" class="form-control cities order-alpha underlined" id="cityId">
									<%
								if(!city.equals("NA"))
								{%>
									<option><%=city%></option>
								<%}else
								{
								%>
									<option value="">Select City</option>
									<%} %>
								</select>
								</abbr>
								</section>
								<section class="col-md-2">
								<input type="text" name="mailid" id="mailid" class="form-control underlined" placeholder="e-mail">
								</section>
								<section class="col-md-2">
								<input type="text" name="mobile" id="mobile" class="form-control underlined" placeholder="mobile">
								</section>
								<section class="col-md-2">
								<input class="btn-primary btn-sm" type="submit" value="Search">
								</section>
								</form>
							<!-- Search ending -->
						</div>
							<div class="col-md-12"
							style="font-family: 'Roboto', sans-serif; background-color: #fff; border-radius: 4px; margin-bottom: 7px; position: relative; right: 20px;">
							<section class="col-md-3"
								 style="font-size: 14px;text-align:center;"><strong>NAME</strong></section>
							<section class="col-md-3"
								 style="font-size: 14px;text-align:center;"><strong>EMAIL ID</strong></section>
							<section class="col-md-3"
								 style="font-size: 14px;text-align:center;"><strong>MOBILE</strong></section>
							<section class="col-md-3"  style="font-size: 14px;text-align:center;"><strong>PANCARD NO.</strong>
							</section>
							
							
						</div>
						<%
						while(itr.hasNext()){
							IndividualOwnerRegister bo=(IndividualOwnerRegister)itr.next();
						%>
						<div class="col-md-12"
							style="font-family: 'Roboto', sans-serif; border-radius: 4px; margin-bottom: 7px; position: relative; right: 20px;">
							<section class="col-md-3"
								 style="font-size: 14px;"><a href="./AdUpdateBusinessOwner.jsp?k=SC&boid=<%=bo.getSEQUENTIAL_NO()%>"><%=bo.getNAME()%></a></section>
							<section class="col-md-3"
								 style="font-size: 14px;"><strong><%=bo.getEMAIL_ID()%></strong></section>
							<section class="col-md-3"
								 style="font-size: 14px;"><%=bo.getMOBILE_NO()%></section>
							<section class="col-md-3"  style="font-size: 14px;text-align:center;"><%=new VerifyFieldsUtil().verifyString(bo.getPANCARD_NO())%>
							</section>
						</div>
						<%} %>
						<div>Pages <c:forEach begin="1" end="${numofpages}" var="i">
				<td><a href="./AdSearchInOwner?tstate=<%=state%>&tcity=<%=city%>&mailid=<%=mailid%>&mobile=<%=mobile%>&page=${i}">${i}</a></td>
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
	
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>

</html>