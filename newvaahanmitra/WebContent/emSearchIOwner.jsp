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
<jsp:include page="./employeeMenu.jsp" />
<jsp:include page="./topMenu.jsp" />
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Vaahanmitra | AddCar</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
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
							ArrayList<IndividualOwnerRegister> al=new ArrayList<IndividualOwnerRegister>();
							al=(ArrayList<IndividualOwnerRegister>)request.getAttribute("individualOwnerDetails");
							Iterator itr= al.iterator();
							%>
							
							<%
						int page1 = 0, noofrecords = 0, maxrowsperpage = 0;
						try {
							if (request.getAttribute("currentPage") != null) {
								page1 = Integer.parseInt(request.getAttribute("currentPage").toString());
								maxrowsperpage = Integer.parseInt(request.getAttribute("maxrowsperpage").toString());
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						int x = (maxrowsperpage * page1) - maxrowsperpage;
					%>
							<div class="col-md-12 row" >
							<!-- Search ending -->
									<form action="./EMSearchIOwner" method="post">
									<div class="col-md-12">
								<h5 align="center" style="background:#7a98b1;color:#fff">SEARCH INDIVIDUAL OWNER</h5></div><br><br>
										<section class="col-md-2">
										 <jsp:include
											page="./IndividualOwnerCity.jsp">
											<jsp:param name="usertype" value="IO"></jsp:param>
										</jsp:include> </section>
										<input type="hidden" name="k" value="IO">
										<section class="col-md-3"> <select
											name="vehicletype" class="form-control underlined">
											<option>Vehicle Type</option>
											<option>All</option>
											<option value="2,">Two Wheeler</option>
											<option value="4,">Four Wheeler</option>
										</select> </section>
										
										<section class="col-md-2">
								<input type="text" name="mailid" id="mailid" class="form-control underlined" placeholder="e-mail">
								</section>
								<section class="col-md-2">
								<input type="text" name="mobile" id="mobile" class="form-control underlined" placeholder="mobile">
								</section>
										
										<section class="col-md-3"> <input
											class="btn-primary btn-sm" type="submit" value="Search">
										</section>
									</form>
									<!-- Search ending -->
						</div>
							<div class="col-md-12"
			style="font-family: 'Roboto', sans-serif; background-color: #fff; border-radius: 4px; margin-bottom: 7px; position: relative; right: 20px;">
			<br>
			<%
							String message = (String)request.getAttribute("message"); 
							String msgColor = (String)request.getAttribute("msgColor"); 
							if(message!=null && msgColor.equals("red")){
								%>
							<h5 style="color:red" align="center"><%=message%></h5>
						<%} else if(message!=null && msgColor.equals("green")){
							%>
						<h5 style="color:green" align="center"><%=message%></h5>
					<%}%><br>
			<section class="col-md-2"
				><strong>NAME</strong></section>
			<section class="col-md-2"
				><strong>EMAIL</strong></section>
			<section class="col-md-2"
				 ><strong>MOBILE</strong></section>
			<section class="col-md-2"
				><strong>ADDRESS</strong></section>
			<section class="col-md-2" ><strong>VEHICLE</strong>
			</section>
			<section class="col-md-2"  ><strong>
			STATUS</strong>
			</section>
		</div>
						<%
		while(itr.hasNext()){
			IndividualOwnerRegister bo=(IndividualOwnerRegister)itr.next();
		%>
						<div class="col-md-12"
		 style="font-family: 'Roboto', sans-serif; background-color: #fff; border-radius: 4px; margin-bottom: 7px; position: relative; right: 20px;">
			<section class="col-md-2"><u><a href="./emUpdateIOwner.jsp?k=IO&id=<%=bo.getEMAIL_ID()%>"><%=bo.getNAME()%></a></u></section>
			<section class="col-md-2"><%=bo.getEMAIL_ID()%></section>
			<section class="col-md-2"><%=bo.getMOBILE_NO()%></section>
			<section class="col-md-2"><%=bo.getCITY()%></br><%=bo.getPINCODE_NO()%></section>
			<section class="col-md-2"><%if(bo.getVEHICAL_TYPE()==null){ %>FOUR AND TWO WHEELER<%}else if(bo.getVEHICAL_TYPE().equals("4,"))
				 {%>FOUR WHEELER<%}else if(bo.getVEHICAL_TYPE().equals("2,")){ %>TWO WHEELER<%} else{ %>FOUR AND TWO WHEELER<%} %>
			</section>
			
			<section class="col-md-2">
			<form action="./EMAIIOwner" method="post">
								<input type="hidden" name="emailId" value="<%=bo.getEMAIL_ID()%>">
								<input type="hidden" name="userType" value="IO">
								<input type="hidden" name="status" value="<%=bo.getSTATUS()%>">
								<input type="hidden" name="page" value="<%=page1%>">
								<%
									if(bo.getSTATUS().equals("ACTIVE")){
								%>	
								<td colspan="25" align="right">
									<input type="submit" class="btn btn-primary active" style="border-radius: 10px" value="<%=new VerifyFieldsUtil().verifyString(bo.getSTATUS())%>">
								</td>
								<%	
									}else{%>
									<td colspan="25" align="right">
										<input type="submit" class="btn btn-warning" style="border-radius: 10px" value="<%=new VerifyFieldsUtil().verifyString(bo.getSTATUS())%>">
									</td>
								<% }%>
			</form></section>
			<%-- <section class="col-md-3"
			     style="padding:3px 0px;font-size: 14px;"><%=bo.getSTATUS() %></section> --%>
		</div>
		<%}%>
<div>Pages <c:forEach begin="1" end="${numofpages}" var="i">
<td><a href="././EMSearchIOwner?k=IO&page=${i}">${i}</a> </td>
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