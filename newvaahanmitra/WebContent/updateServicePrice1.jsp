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
function amountCalc(str)
{
	var selling=document.getElementById("selling"+str).value;
	var discount=document.getElementById("discount"+str).value;
	var finalamount=selling-discount;
	document.getElementById("finalamount"+str).value=finalamount;
} 
function NumAndTwoDecimals(event , obj){
	reg = /[^0-9.,]/g;
	obj.value =  obj.value.replace(reg,"");
}
function EnableDisableTextBox(bEnable, textBoxID) {
	document.getElementById(textBoxID).disabled = !bEnable
//    document.getElementById(textBoxID2).disabled = !bEnable
}
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
function yesornoCheck(str) {
if (document.getElementById('sample'+str).onclick) {
    document.getElementById('selling1'+str).style.display = 'block';
    document.getElementById('selling2'+str).style.display = 'none';
    document.getElementById('discount1'+str).style.display = 'block';
    document.getElementById('discount2'+str).style.display = 'none';
    document.getElementById('final1'+str).style.display = 'block';
    document.getElementById('final2'+str).style.display = 'none';
}
else
document.getElementById('selling1'+str).style.display = 'block';
document.getElementById('selling2'+str).style.display = 'display';
document.getElementById('discount1'+str).style.display = 'block';
document.getElementById('discount2'+str).style.display = 'display';
document.getElementById('final1'+str).style.display = 'block';
document.getElementById('final2'+str).style.display = 'display';

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
										<th>UPDATE PRICE</th>
									</tr>
									<tbody>

										<c:forEach var="purchase" items="${servicesList}">
											<form action="./updateServieTypePriceController" method="post" name="radioForm" onsubmit="return evalGroup()">
												<tr>
													<td align="center">
													<div class="form-group"><c:out value="${purchase.SERVICE_ID}"></c:out></td></div>
															<input type="hidden" value="${purchase.SERVICE_ID}" name="serviceId"/>
													<td align="center"><c:out value="${purchase.SERVICE_TYPE}"></c:out></td>
															<input type="hidden" value="${purchase.SERVICE_TYPE}" name="serviceType"/>
													<td align="center"><div id="selling2<%=j%>" style="display:display"><c:out value="${purchase.PRICE==''?'':purchase.PRICE=='0'?'':purchase.PRICE}" ></c:out></div>
   					<div id="selling1<%=j%>" style="display:none"><input type="text" class="form-control" name="selling" id="selling<%=j%>" value="${purchase.PRICE}" onkeyup="NumAndTwoDecimals(event , this);" size="5" ></input></div></td>
					<input type="hidden" name="page" value="<%=page1%>">
					<td align="center"><div id="discount2<%=j%>" style="display:display"><c:out value="${((empty purchase.DISCOUNT)?'-':purchase.DISCOUNT)}" ></c:out></div>
    				<div id="discount1<%=j%>" style="display:none"><input type="text" class="form-control" name="discount" id="discount<%=j%>" value="${purchase.DISCOUNT}" onkeyup="NumAndTwoDecimals(event , this);" size="3" onBlur="amountCalc(<%=j%>);"></input></div></td>
    				
   					<td><div id="final2<%=j%>" style="display:display"><c:out value="${purchase.PRICE==''?'0':purchase.PRICE=='0'?'0':purchase.PRICE-purchase.DISCOUNT}" ></c:out></div>
   					<div id="final1<%=j%>" style="display:none"><input type="text" class="form-control" name="finalamount" id="finalamount<%=j%>" size="3" value="${purchase.PRICE==''?'0':purchase.PRICE=='0'?'0':purchase.PRICE-purchase.DISCOUNT}" readonly="readonly"></input></div>
   </td>
   <td>
										<input type="hidden"  name="scId" value="${purchase.SERVICE_CENTER_ID}"/>
										<input type="button" class="btn btn-primary" style="border-radious:10px;"  name="edit" onclick="javascript:yesornoCheck(<%=j%>);" id="sample<%=j%>" value="EDIT"/>
 									 </td>
													</tr>
											<%
												j++;
											%>
										</c:forEach>
										<td align="right" colspan="11">
														<button type="submit" style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
													  class="btn btn-primary" class="form-control">UPDATE</button>
												</td>
												</form>
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