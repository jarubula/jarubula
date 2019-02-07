<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*,java.util.*,com.vaahanmitra.utilities.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<jsp:include page="./DriverMenu.jsp" />
<jsp:include page="./topMenu1.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Driver reports</title>
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

<!-- 
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
</script> -->


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
<!--  					<h3 style="">INDIVIDUAL OWNER DASHBOARD</h3> -->
				</center>
				<div class="col-md-12">
<!-- 					<div class="card" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;"> -->
<!-- 						<div class="card-block" style="border-bottom: 3px solid #a3b745;"> -->
							<section class="example">
							
								<div class="table-responsive well">
								
								<form action="./DriverEndUserReports" method="post">
								
								<input type="hidden" name="userType" value="DR"/>

										<div class="col-md-12" style="background: #523f6d;color: #f5f5f5;text-align: center;font-weight: bolder;height:44px;margin-top:8px;padding: 10px;">
										SEARCH TRIP ID</div>
										
										<%
												HttpSession dsession=request.getSession(false);
												String userId=(String)dsession.getAttribute("user");
												GetDriverDetails driverDtls=new GetDriverDetails();
												Set<String> tripSet=driverDtls.getUserTripId(userId);
												Iterator tripIt=tripSet.iterator();
												%>
										<div class="col-md-12 col-xs-12 col-sm-12">
										<br>
										           </div>
												
												<div class="col-md-2 col-xs-12 col-sm-12">
										           <label for="exampleInputEmail1">DATE</label>
										           </div>
										           
										           <div class="col-md-3 col-xs-12 col-sm-12" align="left">
													<div class="form-group">
													
												<input type="date" name="date" class="form-control boxed" placeholder="Date"></input>
													</div>
												</div>
												
												
												
												
												<div class="col-md-2 col-xs-12 col-sm-12">
										           <label for="exampleInputEmail1">TRIP ID</label>
										           </div>
										           
										              <div class="col-md-3 col-xs-12 col-sm-12" align="left">
													<div class="form-group">
													
														<select name="tripId" class="form-control boxed">
												<option value="">Trip Id</option>
												<%
												while(tripIt.hasNext()){
													String tripId=(String)tripIt.next();
													%>
													<option><%=tripId %></option>
												<%	
												}
												%>
												</select>
													</div>
												</div>
										           
												
											<div class="col-md-2 col-xs-12 col-sm-12" align="center">
															
															
											<div class="form-group"><input type="submit" value="Search" class="btn btn-primary"/></div>
															
											</div>
											
											</form>

											</section> 
												<%
										ArrayList<ServiceEndUser> endUserDetails=(ArrayList<ServiceEndUser>)request.getAttribute("endUserDetails"); 
										
										String date=(String)request.getAttribute("date");
										String tripId=(String)request.getAttribute("tripId");
										String message=(String)request.getAttribute("message");
										String userType=(String)request.getAttribute("userType");
										%>
											<section class="example" style="margin-top:20px;">
<!-- 											<div id="printableArea"> -->
											 <div style="overflow-x:auto;">
											 <%if(message!=null){ %>
											 <font color="red" size="3"><%=message %></font>
											 <%}else{ %>
											 
											 <font color="red" size="3">Reports</font>
											 
											 <%} %>
											<table class="table table-striped table-bordered table-hover" style="border: 1px solid #ccc;">	
											<tr>
											<!-- <td><b>NAME</b></td>
											<td><b>EMAIL</b></td>
											<td><b>MOBILE NO</b></td> -->
											<td><b>From Address</b></td>
											<td><b>To Address</b></td>
											<td><b>Appointment Date</b></td>
											<td><b>Appointment Time</b></td>
											<td><b>Appointment Id</b></td>
											<td><b>Trip Id</b></td>
											<td><b>Show Driver</b></td>
											<td><b>Show Bill</b></td>
											<!-- <td><b>Confirm</b></td>
											<td><b>Change Appointment Date</b></td> -->
											</tr>
											<%if(endUserDetails!=null && endUserDetails.size()<=0){ %>
											<tr>
											<td colspan="11"><font color="red">DATA NOT FOUND.......</font></td>
											</tr>
											<%}else{ }%>
											
											<% int i=1; %>
											<c:forEach var="endUserDetails" items="${endUserDetails}">
											
											<c:set var="test" value="${endUserDetails.APPOINTMENT_DATE}"></c:set>
											<c:set var="test1" value="${endUserDetails.APPOINTMENT_ID}"></c:set>
											<c:set var="test2" value="${endUserDetails.DRIVER_TRIP_ID}"></c:set>
											<c:set var="test3" value="${endUserDetails.DRIVER_EMAIL}"></c:set>
											<%
												String apptDate=null;
												String apptId=null;
												String dtripId=null;
												String demail=null;
												apptDate =(String)pageContext.getAttribute("test"); 
												apptId =(String)pageContext.getAttribute("test1"); 
												dtripId =(String)pageContext.getAttribute("test2"); 
												demail =(String)pageContext.getAttribute("test3");
												
												SQLDate sqlDate=new SQLDate();
												String apptdate=sqlDate.getInDate(apptDate);
												
												List<DriverBean> driverBean=driverDtls.getDriverName(demail);
												/* List<DriverFeedBack> driverFD=driverDtls.getDriverFeedBack(apptId, dtripId);
												Iterator driverFDIt=driverFD.iterator(); */
												Iterator driverBeanIt=driverBean.iterator();
												
												DriverBean driverDetails=null;
												while(driverBeanIt.hasNext()){
													
													driverDetails=(DriverBean)driverBeanIt.next();
													
												}
												/* DriverFeedBack driverFeedBack=null;
												while(driverFDIt.hasNext()){
													
													driverFeedBack=(DriverFeedBack)driverFDIt.next();
													
												} */
												
												%>
											
											<tr>
											<td><c:out value="${endUserDetails.ADDRESS}"></c:out></td>
											<td><c:out value="${endUserDetails.DESTINATION}"></c:out></td>
											<td><%=apptdate %></td>
											<td><c:out value="${endUserDetails.APPOINTMENT_TIME}"></c:out></td>
											<td><c:out value="${endUserDetails.APPOINTMENT_ID}"></c:out></td>
											<td><c:out value="${endUserDetails.DRIVER_TRIP_ID}"></c:out></td>
											
											<td>
<%-- 											<c:out value="${endUserDetails.DRIVER_TRIP_ID}"></c:out> --%>

											
<div class="container-fluid">
  <!-- Trigger the modal with a button -->
  
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal<%=i %>" style="background-color: #a3b745;width:100%;">Show Driver</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal<%=i %>" role="dialog">
    <div class="modal-dialog "> <!-- modal-sm -->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Driver Details</h4>
        </div>
        <div class="modal-body" align="center">
      <table>
      <tr>
      <td>Name</td>
      <td><%=driverDetails.getFIRST_NAME()+" "+driverDetails.getLAST_NAME() %></td>
      </tr>
      <tr>
      <td>Email</td>
      <td><%=driverDetails.getEMAIL() %></td>
      </tr>
      <tr>
      <td>Mobile Number</td>
      <td><%=driverDetails.getMOBILE_NO() %></td>
      </tr>
       <tr>
      <td>Driver Id</td>
      <td><%=driverDetails.getDRIVER_ID() %></td>
      </tr>
      <%--  <tr>
      <td>Traveling Hour</td>
      <td><%=driverFeedBack.getTRAVELLING_HOUR()+"  "%>hour</td>
      </tr>
      <tr>
      <td>Waiting Hour</td>
      <td><%=driverFeedBack.getWAITING_HOUR()+"  "%>hour</td>
      </tr> --%>
      <tr>
      <td>Driver Charges</td>
      <td>${endUserDetails.DRIVER_CHARGES} RS</td>
      </tr>
      <tr>
      <td>Waiting Charges</td>
      <td>${endUserDetails.DRIVER_WAITING_CHARGES} RS</td>
      </tr>
      </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</div> 
											
											
											</td>
											
											
											<form action="./ShowDriverEndUserBill" method="post" target="_blank">
											
											<input type="hidden" name="apptId" value="${endUserDetails.APPOINTMENT_ID}"/>
											<input type="hidden" name="tripId" value="${endUserDetails.DRIVER_TRIP_ID}"/>
											<input type="hidden" name="demail" value="${endUserDetails.DRIVER_EMAIL}"/>
											
											<%
											String billId=driverDtls.getDriverBillId(apptId, dtripId, demail);
											if(billId!=null){
											%>
											
											<td><input type="submit" name="submit" value="Show Bill" class="btn btn-info btn-lg" style="background-color: #a3b745;padding-top: 5px;padding-bottom: 5px;width:100%;"/></td>
											
											<%}else{ %>
											
											<td><input type="submit" name="submit" value="No Bill" class="btn btn-info btn-lg" disabled="disabled" style="background-color: #a3b745;padding-top: 5px;padding-bottom: 5px;width:100%;"/></td>
											
											
											<%} %>
											
											</form>

										<%-- 	<c:set var="test" value="${endUserDetails.APPOINTMENT_ID}"></c:set>
											<%
											GetServiceCenterDetails service=new  GetServiceCenterDetails();
											String appt=null;
											appt =(String)pageContext.getAttribute("test"); 
											
											List<CarService> billId=service.getCarService(appt);
											%> --%>
											
										
										<%-- 	<td>

<!-- 											<a href="#" class="btn btn-primary">Your Bill</a> -->
											
											<%if(billId!=null && billId.size()>0){ %>
											<a onclick="window.open('./GetCarBillByApptId?id=${endUserDetails.APPOINTMENT_ID}','mywindow','width=2000,height=700')" style="cursor: pointer;background-color: #a3b745;" class="btn btn-primary"><b><u>${endUserDetails.DRIVER_TRIP_ID}</u></b></a>
											<%} else{%>
											<a href="#" style="cursor: pointer;color:#ff4444;background-color: #a3b745;" class="btn btn-primary"><b><u><abbr title="Bill is not available">${endUserDetails.DRIVER_TRIP_ID}</abbr></u></b></a>
											
											<%} %>
											
											</td> --%>
										<%-- 	<form action="./ChangeServiceApptDateAndConfirmRequest" method="post">
											<input type="hidden" name="fdate" value="<%=date1 %>"/>
											<input type="hidden" name="sdate" value="<%=date2 %>"/>
											<input type="hidden" name="apptId" value="${endUserDetails.APPOINTMENT_ID}"/>
											<td><button type="submit" class="btn btn-primary" style="background-color: #a3b745;"/><c:out value="${(endUserDetails.STATUS=='INACTIVE')?'Confirmed':'Confirm'}"></c:out></button></td>

											<c:choose>
											<c:when test="${endUserDetails.STATUS=='Confirm'}">
											<td><button type="submit" class="btn btn-primary" style="background-color: #a3b745;"/><c:out value="${endUserDetails.STATUS}"></c:out></button></td>
											</c:when>
											<c:otherwise>
											<td><button type="submit" class="btn btn-primary" style="background-color: #a3b745;" disabled/><c:out value="${endUserDetails.STATUS}"></c:out></button></td>
											</c:otherwise>
											</c:choose>
											</form> --%>
<!-- 											<td> -->
<!-- 											<input type="submit" value="Change Appt Date" class="btn btn-primary" style="background-color: #a3b745; border: 1px solid #a3b745;"/> -->
											
<%--  <div class="container" style="margin-right: 100px;">
  <!-- Trigger the modal with a button -->
  
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" style="background-color: #a3b745;padding-top: 5px;padding-bottom: 5px;">Change Appt Date</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Change Appointment Date</h4>
        </div>
        <div class="modal-body">
        <form action="./ChangeServiceApptDateAndConfirmRequest" method="post">
        <input type="hidden" name="apptId" value="${endUserDetails.APPOINTMENT_ID}"/>
        <input type="hidden" name="fdate" value="<%=date1 %>"/>
		<input type="hidden" name="sdate" value="<%=date2 %>"/>
        <c:out value="${endUserDetails.APPOINTMENT_ID}"></c:out>
          <div><input type="text" name="apptId" placeholder="Appointment Id" required/></div>
          <div style="padding-top: 10px;"><input type="date" name="mdate" required/></div>
          <div style="padding-top: 10px;"><input type="submit" value="submit" style="background-color: #a3b745; border: 1px solid #a3b745;"/></div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</div> --%>

											
<!-- 											</td> -->
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
												<a href="./DriverEndUserReports?page=${k}&date=<%=date%>&userType=<%=userType %>&tripId=<%=tripId %>" style="color:#fc6116;"><u>${k}&nbsp;</u></a>             			
												<%} else{%>
												             			
												<a href="./DriverEndUserReports?page=${k}&date=<%=date%>&userType=<%=userType %>&tripId=<%=tripId %>">${k}&nbsp;</a> 				
												<%} %>
									
									</c:forEach>
									</td>
										</tr>
										
									<!-- 	<tr>
											
											<td colspan="12" align="right">
 											<a href="javascript:void(0);" class="btn btn-primary" onclick="printPageArea('printableArea')"> Print</a>
 														<button type="submit" value="Submit" onclick="document.getElementById('finRot').checked=!document.getElementById('finRot').checked;" class="btn btn-primary">Submit</button>
											</td>
											
											</tr>	 -->
											
											
											</table>
											</div>
<!-- 											</div> -->
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