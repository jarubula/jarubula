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
<%@ page language="java"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<jsp:include page="./AdminMenu.jsp" />
<jsp:include page="./Admin-right-side.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>AddCar</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<!-- Theme initialization -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>

<script language="javascript">
function evalGroup()
{
	var group = document.radioForm.check;
	var discount = document.radioForm.discount;
	for (var i=0,j=0; i<group.length ; i++,j++) {
	if (group[i].checked )
		break;
	}
	if (i==group.length){
	alert("Select atleast one check box! and Enter Discout!");
		return false;
	}
}
	function CheckNumeric(e) {
  
    if (window.event) // IE 
    {
        if ((e.keyCode < 48 || e.keyCode > 57) & e.keyCode != 20) {
            event.returnValue = false;
            return false;

        }
    }
    else { // Fire Fox
        if ((e.which < 48 || e.which > 57) & e.which != 20) {
            e.preventDefault();
            return false;

        }
    }
}
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
            
            
            
            // Discount caluculation
            function CalcDiscount(str)
            {
            	var total = document.getElementById("price"+str).value;
//             	var value = document.getElementById("item-price").innerText;
            	var discount = document.getElementById("discount"+str).value;
//             	var total =  value * qty;
            	var gtotal =  total - discount;
            	//document.getElementById("total-price").value = gtotal;	
            	$("#total-price"+str).val(gtotal);
            }
            
        </script>
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">


			<header class="">
			<!-- <div class="header-block header-block-collapse hidden-lg-up">
				<button class="collapse-btn" id="sidebar-collapse-btn">
					<i class="fa fa-bars"></i>
				</button>
			</div>
 -->
			<div class="header-block header-block-nav">
			</div>
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
								<%-- <%
									int page1 = 0, noofrecords = 0, maxrowsperpage = 0;
									try {
										page1 = Integer.parseInt(request.getAttribute("currentPage").toString());
										maxrowsperpage = Integer.parseInt(request.getAttribute("maxrowsperpage").toString());
									} catch (Exception e) {
										out.print("Exception is raised");
									}
									int i = (maxrowsperpage * page1) - maxrowsperpage;
								%>
								<%
									ArrayList<ServiceType> al = new ArrayList<ServiceType>();
									try {
										al = (ArrayList<ServiceType>) request.getAttribute("servicesList");
									} catch (Exception e) {
										e.printStackTrace();
									}
									int j = 1;
								%> --%>
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th colspan="25"
												style="text-align: center; background-color: #523f6d; color: #fff;">EmployeeList</th>
										</tr>
										<%-- <%
											if (al.size() <= 0) {
										%>
										<tr>
											<td colspan="11" align="center"><font color=red>No
													Records Found</font></td>
										</tr>
										<%
											} else {
										%> --%>
									</thead>
									<tr>
										<th>First Name</th>
										<th>Last Name</th>
										<th>Gender</th>
										<th>EmailId</th>
										<th>Mobile No</th>
										<th>Adhar No</th>
										<th>Pancard No</th>
										<th>Address</th>
										<th>City</th>
										<th>State</th>
										<th>District</th>
										<th>Pincode</th>
										<th>Division</th>
										<th>State</th>
										<th>User Id</th>
										<th colspan="10" style="text-align: center">Role</th>
									</tr>
									<tbody>

										<c:forEach var="employee" items="${employeeList}">
											<form action="" method="post" name="radioForm" onsubmit="return evalGroup()">

												<tr>
													<td align="center">
														<div class="form-group">
														<c:out value="${employee.FIRST_NAME}"></c:out>
														</div>
													</td>
													<td align="center">
														<div class="form-group">
														<c:out value="${employee.LAST_NAME}"></c:out>
														</div>
													</td>
													<td align="center">
														<c:out value="${employee.GENDER}"></c:out></td>
													<td align="center">
													<div class="form-group">
														<c:out value="${employee.EMAIL_ID}"></c:out>
														</div></td>
													<td align="center">
													<div class="form-group">
															<c:out value="${employee.MOBILE_NO}"></c:out>
														</div></td>
													<td align="center">
													<div class="form-group">
															<c:out value="${employee.ADHAR_NO}"></c:out>
														</div></td>
													<td align="center">
													<div class="form-group">
															<c:out value="${employee.PANCARD_NO}"></c:out>
														</div></td>
													<td align="center">
													<div class="form-group">
															<c:out value="${employee.ADDRESS}"></c:out>
														</div></td>
													<td align="center">
													<div class="form-group">
															<c:out value="${employee.CITY}"></c:out>
														</div></td>
													<td align="center">
													<div class="form-group">
															<c:out value="${employee.STATE}"></c:out>
														</div></td>
													<td align="center">
													<div class="form-group">
															<c:out value="${employee.DISTRICT}"></c:out>
														</div></td>
													<td align="center">
													<div class="form-group">
															<c:out value="${employee.PINCODE}"></c:out>
														</div></td>
													<td align="center">
													<div class="form-group">
															<c:out value="${employee.DIVISION}"></c:out>
														</div></td>
													<td align="center">
													<div class="form-group">
															<c:out value="${employee.DSTATE}"></c:out>
														</div></td>
													<td align="center">
													<div class="form-group">
															<c:out value="${employee.EMPLOYEE_ID}"></c:out>
														</div></td>
													<td colspan="4" style="text-align: center;">
														<a href="./updateAdEmployee.jsp?eid=${employee.EMAIL_ID}&empId=${employee.EMPLOYEE_ID}">ASSIGN ROLE</a>
													</td>
													<!-- <td colspan="4" style="text-align: center;">
														<button
															style="background-color: #a3b745; border: 1px solid #a3b745;border-radius:10px;"
															class="btn btn-primary">ACTIVE</button>
													</td>
													<td colspan="4" style="text-align: center;">
														<button
															style="background-color: #a3b745; border: 1px solid #a3b745;border-radius:10px;"
															class="btn btn-primary">INCATIVE</button>
													</td> -->
												</tr>
											</form>
										</c:forEach>
									</tbody>
								</table>
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