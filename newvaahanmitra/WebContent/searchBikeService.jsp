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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.SimpleDateFormat,java.io.*" %>  
<html>
<head>

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


<meta charset="utf-8">
<jsp:include page="./carMenu.jsp" />
<jsp:include page="./topMenu.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<!--  <link href="assets/css/modalForm.css" rel="stylesheet" type="text/css"/> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
<!-- <script type="text/javascript">
function callMe(myId) {

 	var popup1=window.open('./DisplayCarImage.jsp?photo='+myId,'mywindow','width=700,height=700,titlebar=0,status=no,toolbar=no,location=no,directories=no')
/* 	var n=window.open("DisplayCarImage.jsp?photo="+myId,"mywindow", " width=2000, height=1000"); */


}
</script> -->
<style>
.modal-backdrop {background: none;}
@media (min-width: 1200px){
.container {
    width: 100px;
}
}
/* .modal {
   position:fixed;
   top:0;
   right:0;
   left:auto;
   bottom:0;
} */
</style>

<style>
.td {
	font-size: small;
}
</style>
<script type="text/javascript">
function DisableNextButton(btnId) {
	btnId.disabled = 'true';
}
</script>


	<style>
.button {
  display: inline-block;
  border-radius: 4px;
  background-color: #4CAF50;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 14px;
  padding: 2px 2px;
  width: 120px;
  transition: all 1s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 1s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 20px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>


	<script>
	 function printPageArea(areaID){
    var printContent = document.getElementById(areaID);
    var WinPrint = window.open('', '', 'width=900,height=650');
    WinPrint.document.write(printContent.innerHTML);
    WinPrint.document.close();
    WinPrint.focus();
    WinPrint.print();
    WinPrint.close();
}
</script>



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
			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<center>
					<h3 style="">SERVICE CENTER DASHBOARD</h3>
				</center>
				<div class="col-md-12">
<!-- 					<div class="card" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;"> -->
<!-- 						<div class="card-block" style="border-bottom: 3px solid #a3b745;"> -->
							<section class="example">
							
								<div class="table-responsive well">
								<form action="./SearchBikeService" method="post">
								
								<div class="col-md-12" style="background: #523f6d;color: #f5f5f5;text-align: center;font-weight: bolder;height:44px;margin-top:8px;padding: 10px;">
										SEARCH APPOINTMENT</div>
										
										
										<%
										ArrayList<ServiceEndUser> endUserDetails=(ArrayList<ServiceEndUser>)request.getAttribute("serviceEndUser"); 
										String message=(String)request.getAttribute("message");
										String apptId1=(String)request.getAttribute("apptId");
										String bikeNo1=(String)request.getAttribute("bikeNo");
										String user=(String)session.getAttribute("user");
										GetServiceCenterDetails service=new  GetServiceCenterDetails();
										Set<String> apptId=service.getBikeApptId(user);
										Set<String> bikeNo=service.getBikeNo(user);
										%>
										
										<div class="col-md-12 col-xs-12 col-sm-12">
										<br>
										           </div>
										
											<div class="col-md-2 col-xs-12 col-sm-12">
										           <label for="exampleInputEmail1">APPOINTMENT ID</label>
										           </div>
										           
										           <div class="col-md-3 col-xs-12 col-sm-12" align="left">
													<div class="form-group">
										           
												<select name="apptId" class="form-control boxed">
												<option value="">Appointment Id</option>
												<option value="All">All</option>
												<%
												 Iterator apptIdList=apptId.iterator();
												while(apptIdList.hasNext()){
													String tApptId=(String)apptIdList.next();
												
												%>
												<option><%=tApptId %></option>
												<%} %>
												</select>
												
													</div>
													</div>

												<div class="col-md-2 col-xs-12 col-sm-12">
										           <label for="exampleInputEmail1">BIKE NO</label>
										           </div>
										           
										             <div class="col-md-3 col-xs-12 col-sm-12" align="left">
													<div class="form-group">
										           
												<select name="bikeNo" class="form-control boxed">
												
													<option value="">Bike Number</option>
													<option value="All">All</option>
												<%
												 Iterator bikeNoList=bikeNo.iterator();
												while(bikeNoList.hasNext()){
													String tBikeNo=(String)bikeNoList.next();
												
												%>
												<option><%=tBikeNo %></option>
												<%} %>
												
												</select>
												
												</div>
												</div>
												
												<div class="col-md-2 col-xs-12 col-sm-12" align="center">
															
															
											<div class="form-group"><input type="submit" value="Submit" class="btn btn-primary"/></div>
															
											</div>
											
											</form>
											</section>	
											<section class="example" style="margin-top:20px;">
											 <div style="overflow-x:auto;">
											 <%if(message!=null){ %>
											 <font color="red" size="3"><%=message %></font>
											 <%} %>
											 
											 <div id="printableArea">
											 
											<table class="table table-striped table-bordered table-hover" style="border: 1px solid #ccc;">	
											
											<tr>
											<td><b>NAME</b></td>
											<td><b>EMAIL</b></td>
											<td><b>MOBILE NO</b></td>
											<td><b>APPOINTMENT DATE</b></td>
											<td><b>CONFIRM DATE</b></td>
											<td><b>BIKE BRAND</b></td>
											<td><b>BIKE NO.</b></td>
											<td><b>APPOINTMENT ID</b></td>
											<td><b>YOUR FEEDBACK</b></td>
											</tr>
											<%if(endUserDetails!=null && endUserDetails.size()<=0){ %>
											<tr>
											<td colspan="11"><font color="red">DATA NOT FOUND.......</font></td>
											</tr>
											<%}else{ }%>
											
											<% int i=1; %>
											<c:forEach var="endUserDetails" items="${serviceEndUser}">
											
											<tr>
											<td><c:out value="${endUserDetails.NAME}"></c:out></td>
											<td><c:out value="${endUserDetails.EMAIL}"></c:out></td>
											<td><c:out value="${endUserDetails.MOBILE_NO}"></c:out></td>
											<td><c:out value="${endUserDetails.APPOINTMENT_DATE}"></c:out></td>
											<td><c:out value="${endUserDetails.CONFIRM_DATE}"></c:out></td>
											<td><c:out value="${endUserDetails.VEHICLE_BRAND}"></c:out></td>
											<td><c:out value="${endUserDetails.CAR_NO}"></c:out></td>
											<c:set var="test" value="${endUserDetails.APPOINTMENT_ID}"></c:set>
											<%
											String appt=null;
											appt =(String)pageContext.getAttribute("test"); 
											List<CarService> billId=service.getCarService(appt);
											%>
											
											<td>
											<%if(billId!=null && billId.size()>0){ %>
											<a onclick="window.open('./GetCarBillByApptId?id=${endUserDetails.APPOINTMENT_ID}','mywindow','width=2000,height=700')" style="cursor: pointer;"><b><u><c:out value="${endUserDetails.APPOINTMENT_ID}"></c:out></u></b></a>
											<%} else{%>
											<a href="#" style="cursor: pointer;color:#ff4444;"><b><u><abbr title="Bill is not available"><c:out value="${endUserDetails.APPOINTMENT_ID}"></c:out></abbr></u></b></a>
											
											<%} %>
											</td>
											
											<td>
											
<!-- 											<input type="submit" value="Give Your Feedback" class="btn btn-primary" style="background-color: #a3b745; border: 1px solid #a3b745;"/> -->
											<%if(billId!=null && billId.size()<=0){%>
											<a onclick="window.open('./carServiceBill.jsp?apptId=${endUserDetails.APPOINTMENT_ID}&vehicleType=2,','mywindow','width=2000,height=700')" class="btn btn-primary" style="background-color: #a3b745; border: 1px solid #a3b745;">Generate Your Bill</a>
											<%}else{ %>
											<a href="#" class="btn btn-primary" style="background-color: #ff4444; border: 1px solid #a3b745;"><abbr title="Allready Bill Is Available"> Generate Your Bill</abbr></a>
											
											<%} %>
											</td>
											</tr>
											<%i++; %>
											</c:forEach>
											
											
																<tr>
											
													<td colspan="11" align="left">
											Pages:&nbsp;
											
											
						                 	<c:forEach begin="1" end="${noOfPages}" var="k">
										
						<%-- 				<td style="float: left" ><a href="./SearchHDriver?page=${k}&state=<%=state%>&dist=<%=dist%>&permitType=<%=permitType%>&range=<%=range%>&licenseType=<%=licenseType%>">${k}&nbsp;&nbsp; </a></td> --%>
									
												<c:set var="currentPage" value="${currentPage}"></c:set>
						             			<c:set var="noOfPages" value="${k}"></c:set>
						             			<%
						             			Integer currentPage1=(Integer)pageContext.getAttribute("currentPage");
						             			Integer noOfPages=(Integer)pageContext.getAttribute("noOfPages");
						             			
						             			if(currentPage1.equals(noOfPages)){
						             			%>
												<a href="./SearchBikeService?page=${k}&apptId=<%=apptId1%>&bikeNo=<%=bikeNo1 %>" style="color:#fc6116;"><u>${k}&nbsp;</u></a>             			
												<%} else{%>
												             			
												<a href="./SearchBikeService?page=${k}&apptId=<%=apptId1%>&bikeNo=<%=bikeNo1 %>">${k}&nbsp;</a> 				
												<%} %>
									
									</c:forEach>
									</td>
										</tr>
											
											
											<tr>
											
											<td colspan="10" align="right">
 											<a href="javascript:void(0);" class="btn btn-primary" onclick="printPageArea('printableArea')"> Print</a>
<!--  														<button type="submit" value="Submit" onclick="document.getElementById('finRot').checked=!document.getElementById('finRot').checked;" class="btn btn-primary">Submit</button> -->
											</td>
											
											</tr>
											
											</table>
											
											</div>
											
											</div>
										</tbody>
									
							
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