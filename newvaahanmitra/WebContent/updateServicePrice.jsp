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
								<%
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
								%>
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th colspan="7"
												style="text-align: center; background-color: #523f6d; color: #fff;">UPDATE
												SERVICE PRICE</th>
										</tr>
										<%
											if (al.size() <= 0) {
										%>
										<tr>
											<td colspan="11" align="center"><font color=red>No
													Records Found</font></td>
										</tr>
										<%
											} else {
										%>
									</thead>
									<tr>
										<th>Service ID</th>
										<th>Service Type</th>
										<th>Price</th>
										<th>Discount(%)</th>
										<th>Final Price</th>
										<th></th>
									</tr>
									<tbody>

										<c:forEach var="purchase" items="${servicesList}">
											<form action="./updateServieTypePriceController" method="post" name="radioForm" onsubmit="return evalGroup()">

												<tr>
													<td align="center">
													<div class="form-group"><c:out
															value="${purchase.SERVICE_ID}"></c:out></td></div>
															<input type="hidden" value="${purchase.SERVICE_ID}" name="serviceId">
													<td align="center"><c:out
															value="${purchase.SERVICE_TYPE}"></c:out></td>
															<input type="hidden" value="${purchase.SERVICE_TYPE}" name="serviceType">
															
													<td><div class="form-group">
															<input type="text" class="form-control boxed" name="price" value="${purchase.PRICE}" id="price<%=j%>" required>
														</div></td>
													<td><div class="form-group">
															<input type="text" onkeyup="CalcDiscount(<%=j%>);" name="discount" value="${purchase.DISCOUNT}"  id="discount<%=j%>" name="discount" class="form-control boxed"
																required>
														</div></td>
													<td><div class="form-group">
															<input type="text"  id="total-price<%=j%>"  name="totalPrice" value="${purchase.FINAL_PRICE}" class="form-control boxed" required>
														</div></td>
													<td colspan="4" style="text-align: center;">
														<button
															style="background-color: #a3b745; border: 1px solid #a3b745;"
															class="btn btn-primary">UPDATE</button>
													</td>
												</tr><%
												j++;%>
											</form>
										</c:forEach>
									</tbody>

									<table>
										<tr>
											<td>Pages<b>:</b>
											</td>
											<c:forEach begin="1" end="${noOfPages}" var="i">
												<td><a href="./getServiceType?page=${i}">&nbsp;${i}&nbsp;</a></td>
											</c:forEach>
										</tr>
										<%
											}
										%>
									</table>
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