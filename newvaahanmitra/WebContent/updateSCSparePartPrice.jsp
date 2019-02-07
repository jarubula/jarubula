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
<%@page
	import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./carMenu.jsp" />
<jsp:include page="./topMenu.jsp" />
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
//         document.getElementById(textBoxID2).disabled = !bEnable
    }
    function myFunction(string) {
		var myWindow = window.open("./spDetails.jsp?skuId=" + string,
				"myWin", "left=250, top=150, width=1150, height=330");
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
	
</script>

<script>
	function getVehicleBrand(str) {
		if (str == "") {
			document.getElementById("txtHint10").innerHTML = "";
			return;
		}
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari  
			xmlhttp = new XMLHttpRequest();
		} else {
			// code for IE6, IE5  
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("txtHint10").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./getSpBrand.jsp?spBrand=" + str, true);
		xmlhttp.send();
	}
</script>
<script>
function getSpModel(str)
{
	if (str=="")  
	{  
		document.getElementById("txtHint11").innerHTML="";  
		return;  
		}  
	if (window.XMLHttpRequest)  
	{
		// code for IE7+, Firefox, Chrome, Opera, Safari  
		xmlhttp=new XMLHttpRequest();  
		}
	else  
	{
		// code for IE6, IE5  
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");  
		}
	xmlhttp.onreadystatechange=function()  
	{  
		if (xmlhttp.readyState==4 && xmlhttp.status==200)    
		{    
			document.getElementById("txtHint11").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./getSpModels.jsp?brand="+str,true);   
	xmlhttp.send();    
	}
	</script>
	<script type="text/javascript">
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
	function CheckNumeric(e) {
		 
	    if (window.event) // IE 
	    {
	        if ((e.keyCode < 48 || e.keyCode > 57) & e.keyCode != 8) {
	            event.returnValue = false;
	            return false;

	        }
	    }
	    else { // Fire Fox
	        if ((e.which < 48 || e.which > 57) & e.which != 8) {
	            e.preventDefault();
	            return false;

	        }
	    }
	}
</script>
<body>
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">
			<header class=""> </header>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<div class="col-md-12" align="center">
					<h3 style="">SERVICE CENTER DASHBOARD</h3>
				</div>
				<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745; border-radius: 10px">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive well">
								<form action="./UpdateSCSpareParts" method="GET">
								 <div class="col-md-12"
										style="text-align: center; background-color: #523f6d; color: #fff;border-radius: 10px"">
										<em>SEARCH SPARE PARTS</em>
									</div>
									<%
										String vehicleType = (String) request.getAttribute("vehicleType");
										String brandid = (String) request.getAttribute("vehicleBrand");
										String user_name = (String) request.getAttribute("user_name");
										String carModel = (String) request.getAttribute("vehicleModel");
										String sku = (String) request.getAttribute("sku");
										String partName = (String) request.getAttribute("partName");
										String category = (String) request.getAttribute("category"); 
									%>
									<div class="col-md-12">
										<br>
									</div>
									<div class="col-md-2" align="center">
									<label><b>Vehicle Type</b></label>
										<select name="vehicleType" class="form-control" id="spBrand"
											onchange="getVehicleBrand(this.value)">
											<option value="SELECT" style="display: none;">Vehicle
												Type</option>
											<option value="4,2,">All</option>
											<option value="2,">TWO WHEELER</option>
											<option value="4,">FOUR WHEELER</option>
										</select>

									</div>
									<div class="col-md-2" align="center">
									<label><b>Vehicle Brand</b></label>
									<div id="txtHint10">
										<select class="form-control" name="vehicleBrand">
											<option value="SELECT" style="display: none;">Vehicle Brand</option>
										</select>
									</div>
									</div>
									<div class="col-md-2" align="center" >
										<label><b>Vehicle Model</b></label>
										<div id="txtHint11">
											<select class="form-control" name="vehicleModel" >
												<option value="SELECT" style="display:none;">SELECT MODEL</option>
											</select>
										</div>
									</div>
									<div class="col-md-2" align="center" >
									<label><b>SKU</b></label>
										<%
											String message = (String) request.getAttribute("message");
											String email = (String) session.getAttribute("user");
											GetSparePartsDetails gsp = new GetSparePartsDetails();
											ArrayList<SpareParts> sp = gsp.getSparePartSku(email);
											Iterator it = sp.iterator();
										%>
										<select name="sku" class="form-control">
											<option value="SELECT" style="display:none;">Select SKU</option>
											<option value="All">All</option>
											<div class="form-group">
												<%
													while (it.hasNext()) {
														SpareParts sps = (SpareParts) it.next();
												%>
												<option><%=sps.getSKU()%></option>
												<%
													}
												%>
											</div>
										</select>

									</div>
									
									<div class="col-md-2" align="center" style="margin-bottom:4px;">
									<label><b>Spare Part Name</b></label>
										<select name="partName" class="form-control">
											<option value="SELECT" style="display:none;">Select Name</option>
											<option value="All">All</option>
											<div class="form-group">
												<%
													ArrayList<SpareParts> spn = gsp.getSparePartsNames(email);
													Iterator itn = spn.iterator();
													while (itn.hasNext()) {
														SpareParts spnn = (SpareParts) itn.next();
												%>
												<option><%=spnn.getSP_NAME()%></option>
												<%
													}
												%>
											</div>
										</select>

									</div>
									<div class="col-md-2" align="center">
									<label><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
										<button
											style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
											class="btn btn-primary">SEARCH</button>

									</div>
									<div class="col-md-12"><br></div>
								</form>
							</div>
							</section>
						</div>
					</div>
				</div>
			</div>
				<div class="row">
				<tr><td colspan="3"><center>
				<%if (message != null) {%>
				<h4 style="color: red"><%=message%></h4>
				<%} else {}%></center></td></tr>
				<%String message1 = (String)request.getAttribute("message1"); %>
				<center><%if (message1 != null) {%>
				<h5 style="color: red"><%=message1%></h5>
				<%} else {}%></center>
					<div class="col-md-12">
						<div class="card"
							style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745; border-radius: 10px">
							<div class="card-block"
								style="border-bottom: 3px solid #a3b745; border-radius: 10px">
								<section class="example">
								<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover">
											<%
									int page1 = 0, noofrecords = 0, maxrowsperpage = 0;
									ArrayList<SpareParts> al = new ArrayList<SpareParts>();
								%>

								<%
									String returnString = "";
									try {
										returnString = request.getAttribute("returnString").toString();
										out.println(" <font color=green>" + returnString + "</font>");
									} catch (Exception e) {
									}
								%>
								<br>
								<%
									try {
										if (request.getAttribute("currentPage") != null) {
											page1 = Integer.parseInt(request.getAttribute("currentPage").toString());
											maxrowsperpage = Integer.parseInt(request.getAttribute("maxrowsperpage").toString());
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
									int x = (maxrowsperpage * page1) - maxrowsperpage;
									
										ArrayList<SpareParts> spss = (ArrayList<SpareParts>) request.getAttribute("spdetails");
									%>
											<tr>
												<th style="text-align: center">IMAGE</th>
												<th style="text-align: center">SKU</th>
												<th style="text-align: center">PART NAME</th>
												<th style="text-align: center">CAR BRAND</th>
												<th style="text-align: center">CAR MODEL</th>
												<th style="text-align: center">PART NO</th>
												<th style="text-align: center">COMPANY NAME</th>
												<th style="text-align: center;padding-left:50px;padding-right: 50px">PRICE</th>
												<th style="text-align: center">DISCOUNT(%)</th>
												<th style="text-align: center;padding-left:50px;padding-right: 50px">FINAL PRICE</th>
												<th style="text-align: center"></th>
											</tr>
											
											<%
										int j = 1;
									%>
									<%
											if (spss!=null && spss.size() <= 0) {
										%>
										<tr>
											<td colspan="11" align="center"><font color=red>No
													Records Found</font></td>
										</tr>
										<%
											} else {
										%>
											<div class="container">
											<c:forEach var="spss1" items="${spdetails}">
											<form action="./UpdateSCSparePartPrice" method="post" name="radioForm" onsubmit="return evalGroup()">
												<tr>
													<td><img src="data:image/png;base64,${spss1.IMAGE}"
														border="0" width="85px" height="85px" alt="No image"
														class="img-responsive"></td>
												
												<td style="text-align: center">
												<abbr title="clickme"><a  onclick="myFunction('${spss1.SKU}')"><font size="4" style="color: red;" >
													<c:out value="${spss1.SKU}"></c:out></font></a>
													<input type="hidden" name="vehicleType" value="<%=vehicleType%>">
													<input type="hidden" name="vehicleBrand" value="<%=brandid%>">
													<input type="hidden" name="vehicleModel" value="<%=carModel%>">
													<input type="hidden" name="skuId" value="<%=sku%>">
													<input type="hidden" name="partName" value="<%=partName%>">
													<input type="hidden" name="category" value="<%=category%>">
													<input type="hidden" name="page" value="<%=page1%>">
												</abbr></td>		
													<td style="text-align: center"><c:out value="${spss1.SP_NAME}"></c:out></td>
													<td style="text-align: center"><c:out value="${spss1.VEHICLE_BRAND}"></c:out></td>
													<td style="text-align: center"><c:out value="${spss1.VEHICLE_MODEL}"></c:out></td>
													<td style="text-align: center"><c:out value="${spss1.PARTNO}"></c:out></td>
													<td style="text-align: center"><c:out value="${spss1.MANUFACTURE_COMPANY_NAME}"></c:out></td>
											
					<td align="center"><div id="selling2<%=j%>" style="display:display"><c:out value="${spss1.PRICE==''?'':spss1.PRICE=='0'?'':spss1.PRICE}" ></c:out></div>
   					<div id="selling1<%=j%>" style="display:none"><input type="text" class="form-control" name="selling" id="selling<%=j%>" value="${spss1.PRICE}" onkeyup="NumAndTwoDecimals(event , this);" size="5" ></input></div></td>
					
					<td align="center"><div id="discount2<%=j%>" style="display:display"><c:out value="${((empty spss1.DISCOUNT)?'-':spss1.DISCOUNT)}" ></c:out></div>
    				<div id="discount1<%=j%>" style="display:none"><input type="text" class="form-control" name="discount" id="discount<%=j%>" value="${spss1.DISCOUNT}" onkeyup="NumAndTwoDecimals(event , this);" size="3" onBlur="amountCalc(<%=j%>);"></input></div></td>
    				
   					<td><div id="final2<%=j%>" style="display:display"><c:out value="${spss1.PRICE==''?'0':spss1.PRICE=='0'?'0':spss1.PRICE-spss1.DISCOUNT}" ></c:out></div>
   					<div id="final1<%=j%>" style="display:none"><input type="text" class="form-control" name="finalamount" id="finalamount<%=j%>" size="3" value="${spss1.PRICE==''?'0':spss1.PRICE=='0'?'0':spss1.PRICE-spss1.DISCOUNT}" readonly="readonly"></input></div>
   </td>
									<td>
										<input type="hidden"  name="sku" value="${spss1.SKU}" />
										<input type="button" class="btn btn-primary" style="border-radious:10px;"  name="edit" onclick="javascript:yesornoCheck(<%=j%>);" id="sample<%=j%>" value="EDIT"/>
 									 </td>
<%-- 											</c:forEach> --%>
												
    										
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
									</div>
								</table>
								<table>
										<tr>
											<td>Pages<b>:</b>
											</td>
											<c:forEach begin="1" end="${noOfPages}" var="x">
												<td><a
													href="./UpdateSpareParts2?page=${x}&vehicleType=<%=vehicleType%>&vehicleBrand=<%=brandid%>&user_name=<%=user_name%>&vehicleModel=<%=carModel%>&sku=<%=sku%>&partName=<%=partName%>">&nbsp;${x}&nbsp;</a></td>
											</c:forEach>
										</tr>
										<%
											}
										%>
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
	<script language="javascript">
		populateBrands("brand", "model");
	</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>

</html>