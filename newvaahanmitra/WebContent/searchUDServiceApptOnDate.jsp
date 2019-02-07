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
<html>
<head>
<meta charset="utf-8">
<jsp:include page="./carsandBikes.jsp" />
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
 					<h3 style="">USED VEHICLE DEALER DASHBOARD</h3> 
				</center>
				<div class="col-md-12">
<!-- 					<div class="card" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;"> -->
<!-- 						<div class="card-block" style="border-bottom: 3px solid #a3b745;"> -->
							<section class="example">
							
								<div class="table-responsive well">
							
											
												<form action="./SearchINOServiceApptOnDate" method="post">
												
												<input type="hidden" value="UD" name="userType"/>

										<div class="col-md-12" style="background: #523f6d;color: #f5f5f5;text-align: center;font-weight: bolder;height:44px;margin-top:8px;padding: 10px;">
										SEARCH APPOINTMENT</div>
										<div class="col-md-12 col-xs-12 col-sm-12">
										<br>
										           </div>
												
												<div class="col-md-2 col-xs-12 col-sm-12">
										           <label for="exampleInputEmail1">FROM DATE</label>
										           </div>
										           
										           <div class="col-md-3 col-xs-12 col-sm-12" align="left">
													<div class="form-group">
													
												<input type="date" name="fdate" class="form-control boxed" placeholder="From DATE"></input>
													</div>
												</div>
												
												
												
												
												<div class="col-md-2 col-xs-12 col-sm-12">
										           <label for="exampleInputEmail1">TO DATE</label>
										           </div>
										           
										              <div class="col-md-3 col-xs-12 col-sm-12" align="left">
													<div class="form-group">
													
												<input type="date" name="sdate" class="form-control boxed" placeholder="To DATE"></input>
													</div>
												</div>
										           
												
											<div class="col-md-2 col-xs-12 col-sm-12" align="center">
															
															
											<div class="form-group"><input type="submit" value="Search" class="btn btn-primary"/></div>
															
											</div>
											
											</form>
											
											</section> 
												<%
										ArrayList<ServiceEndUser> endUserDetails=(ArrayList<ServiceEndUser>)request.getAttribute("endUserDetails"); 
										
										String date1=(String)request.getAttribute("fdate");
										String date2=(String)request.getAttribute("sdate");
										String message=(String)request.getAttribute("message");
										String userType=(String)request.getAttribute("userType");
										
										%>
											<section class="example" style="margin-top:20px;">
											 <div style="overflow-x:auto;">
											 <%if(message!=null){ %>
											 <font color="red" size="3"><%=message %></font>
											 <%} %>
											 
											 <font color="red" size="3">Your Request To Service Center</font>
											<table class="table table-striped table-bordered table-hover" style="border: 1px solid #ccc;">	
											
											<tr>
											<!-- <td><b>NAME</b></td>
											<td><b>EMAIL</b></td>
											<td><b>MOBILE NO</b></td> -->
											<td><b>APPOINTMENT DATE</b></td>
											<td><b>CONFIRM DATE</b></td>
											<td><b>VEHICLE TYPE</b></td>
											<td><b>VEHICLE BRAND</b></td>
											<td><b>VEHICLE NO.</b></td>
											<td><b>APPOINTMENT ID</b></td>
											<td><b>SERVICE CENTER NAME</b></td>
											<td><b>SERVICE CENTER EMAIL</b></td>
											<td><b>SERVICE CENTER CONTACT</b></td>
											<td><b>BILL</b></td>
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
											
											<tr>
										<%-- 	<td><c:out value="${endUserDetails.NAME}"></c:out></td>
											<td><c:out value="${endUserDetails.EMAIL}"></c:out></td>
											<td><c:out value="${endUserDetails.MOBILE_NO}"></c:out></td> --%>
											<td><c:out value="${endUserDetails.APPOINTMENT_DATE}"></c:out></td>
											<td><c:out value="${endUserDetails.CONFIRM_DATE}"></c:out></td>
											<td><c:out value="${(endUserDetails.VEHICLE_TYPE=='2,')?'TWO WHEELER':(endUserDetails.VEHICLE_TYPE=='4,')?'FOUR WHEELER':'N/A'}"></c:out></td>
											<td><c:out value="${endUserDetails.VEHICLE_BRAND}"></c:out></td>
											<td><c:out value="${endUserDetails.CAR_NO}"></c:out></td>
											<td><c:out value="${endUserDetails.APPOINTMENT_ID}"></c:out></td>
											

											<c:set var="test" value="${endUserDetails.APPOINTMENT_ID}"></c:set>
											<c:set var="serviceCenterEmail" value="${endUserDetails.SERVICE_CENTER}"></c:set>
											<%
											GetServiceCenterDetails service=new  GetServiceCenterDetails();
											String appt=null;
											String serviceCenterEmail=null;
											appt =(String)pageContext.getAttribute("test"); 
											serviceCenterEmail =(String)pageContext.getAttribute("serviceCenterEmail"); 
											
											List<BusinessOwnerRegister> serviceCenter=service.showServiceCenterToAllDsb(serviceCenterEmail);
											Iterator it=serviceCenter.iterator();
											
											BusinessOwnerRegister bean=null;
											while(it.hasNext()){
												
												bean=(BusinessOwnerRegister)it.next();
												
											}
											List<CarService> billId=service.getCarService(appt);
											%>
											
											<td><%=bean.getBUSINESS_NAME() %></td>
											<td><%=bean.getEMAIL_ID() %></td>
											<td><%=bean.getMOBILE_NO() %></td>
											<td>

<!-- 											<a href="#" class="btn btn-primary">Your Bill</a> -->
											
											<%if(billId!=null && billId.size()>0){ %>
											<a onclick="window.open('./GetCarBillByApptId?id=${endUserDetails.APPOINTMENT_ID}','mywindow','width=2000,height=700')" style="cursor: pointer;background-color: #a3b745;" class="btn btn-primary"><b><u>Your Bill</u></b></a>
											<%} else{%>
											<a href="#" style="cursor: pointer;color:#ff4444;background-color: #a3b745;" class="btn btn-primary"><b><u><abbr title="Bill is not available">Your Bill</abbr></u></b></a>
											
											<%} %>
											
											</td>
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
												<a href="./SearchINOServiceApptOnDate?page=${k}&fdate=<%=date1%>&sdate=<%=date2%>&userType=<%=userType %>" style="color:#fc6116;"><u>${k}&nbsp;</u></a>             			
												<%} else{%>
												             			
												<a href="./SearchINOServiceApptOnDate?page=${k}&fdate=<%=date1%>&sdate=<%=date2%>&userType=<%=userType %>">${k}&nbsp;</a> 				
												<%} %>
									
									</c:forEach>
									</td>
										</tr>
											
											</table>
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