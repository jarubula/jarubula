<%@page import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*,java.util.*,com.vaahanmitra.dbutil.*,com.vaahanmitra.utilities.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Driver Bill</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<style type="text/css">
			.text-danger strong {
    		color: #9f181c;
		}
		.receipt-main {
			background: #ffffff none repeat scroll 0 0;
			border-bottom: 12px solid #333333;
			border-top: 12px solid #9f181c;
			margin-top: 50px;
			margin-bottom: 50px;
			padding: 40px 30px !important;
			position: relative;
			box-shadow: 0 1px 21px #acacac;
			color: #333333;
			font-family: open sans;
		}
		.receipt-main p {
			color: #333333;
			font-family: open sans;
			line-height: 1.42857;
		}
		.receipt-footer h1 {
			font-size: 15px;
			font-weight: 400 !important;
			margin: 0 !important;
		}
		.receipt-main::after {
			background: #414143 none repeat scroll 0 0;
			content: "";
			height: 5px;
			left: 0;
			position: absolute;
			right: 0;
			top: -13px;
		}
		.receipt-main thead {
			background: #414143 none repeat scroll 0 0;
		}
		.receipt-main thead th {
			color:#fff;
		}
		.receipt-right h5 {
			font-size: 16px;
			font-weight: bold;
			margin: 0 0 7px 0;
		}
		.receipt-right p {
			font-size: 12px;
			margin: 0px;
		}
		.receipt-right p i {
			text-align: center;
			width: 18px;
		}
		.receipt-main td {
			padding: 9px 20px !important;
		}
		.receipt-main th {
			padding: 13px 20px !important;
		}
		.receipt-main td {
			font-size: 13px;
			font-weight: initial !important;
		}
		.receipt-main td p:last-child {
			margin: 0;
			padding: 0;
		}	
		.receipt-main td h2 {
			font-size: 20px;
			font-weight: 900;
			margin: 0;
			text-transform: uppercase;
		}
		.receipt-header-mid .receipt-left h1 {
			font-weight: 100;
			margin: 34px 0 0;
			text-align: right;
			text-transform: uppercase;
		}
		.receipt-header-mid {
			margin: 24px 0;
			overflow: hidden;
		}
		
		#container {
			background-color: #dcdcdc;
		}
		</style>
		
		<%-- <jsp:include page="./DriverMenu.jsp" />
		<jsp:include page="./topMenu1.jsp" /> --%>
		
		
		
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
		<div class="container">
		<div id="printableArea">
	<div class="row">
		
        <div class="receipt-main col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
            <div class="row">
    			<div class="receipt-header">
					
                  
<%

DriverBean driverBean=(DriverBean)request.getAttribute("driverDetails");
DriverEndUser driverEndUser=(DriverEndUser)request.getAttribute("driverEndUserDetails");
DriverFeedBack driverBill=(DriverFeedBack)request.getAttribute("driverBillDetails");
String message=(String)request.getAttribute("message");
String apptId=(String)request.getAttribute("apptId");
String tripId=(String)request.getAttribute("tripId");

SQLDate sqlDate=new SQLDate();
String billDate=sqlDate.getInDate(driverBill.getDRIVER_BILL_DATE());

%>

<%
if(message!=null){
%>
<%=message %>
<%} %>

					<div class="col-xs-12 col-sm-12 col-md-12 text-right">
						<div class="receipt-right">
							<h5>Vaahanmitra</h5>
							<p>+91 12345-6789 <i class="fa fa-phone"></i></p>
							<p>info@gmail.com <i class="fa fa-envelope-o"></i></p>
							<p>Jntu <i class="fa fa-location-arrow"></i></p>
							<p>Date:<%="  "+billDate%> <i class="fa fa-location-arrow"></i></p>
							<p>Bill Id:<%="  "+driverBill.getDRIVER_BILL_ID() %><em></em> </p>
						</div>
					</div>
				</div>
            </div>
			
			<div class="row">
				<div class="receipt-header receipt-header-mid">
					<div class="col-xs-12 col-sm-4 col-md-4 text-left">
						<div class="receipt-right">
                              <h4 class="text-info">Driver Details</h4>
                              <br>

<!-- 							<img class="img-responsive" alt="iamgurdeeposahan" src="https://lh3.googleusercontent.com/-nDyLYRJVbQA/AAAAAAAAAAI/AAAAAAAAAr4/5I0Wkvwhwv0/s640/photo.jpg" style="width: 71px; border-radius: 43px;"> -->
					     
							<h5><%=driverBean.getFIRST_NAME()+"  "+driverBean.getLAST_NAME() %> </h5>
							<p><b>Mobile :</b> <%=driverBean.getMOBILE_NO() %></p>
							<p><b>Email :</b> <%=driverBean.getEMAIL() %></p>
							<p><b>From Address :</b> <%=driverEndUser.getADDRESS() %></p>
							<p><b>To Address :</b> <%=driverEndUser.getDESTINATION() %></p>
							<p><b>Trip Id :</b> <%=driverBill.getTRIP_ID() %></p>
<!-- 							<p><b>Address :</b> Jntu</p> -->
						</div>
					</div>
					<div class="col-xs-12 col-sm-4 col-md-4 text-left">
						<div class="receipt-right">
                             <h4 class="text-info">User Details</h4>
                             <br>
<!-- 							<img class="img-responsive" alt="iamgurdeeposahan" src="https://lh3.googleusercontent.com/-nDyLYRJVbQA/AAAAAAAAAAI/AAAAAAAAAr4/5I0Wkvwhwv0/s640/photo.jpg" style="width: 71px; border-radius: 43px;"> -->
				
							<h5><%=driverEndUser.getNAME() %> </h5>
							<p><b>Mobile :</b> <%=driverEndUser.getMOBILE_NO() %></p>
							<p><b>Email :</b> <%=driverEndUser.getEMAIL() %></p>
<%-- 							<p><b>Address :</b> <%=driverEndUser.getADDRESS() %></p> --%>
						</div>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-12">
						<div class="receipt-left">
							<h3 align="right">Payment Receipt</h3>
						</div>
					</div>
				</div>
            </div>
			
            <div style="overflow-x:auto;">
                
                 <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Description</th>
                            <th>Hours</th>
                            <th class="text-center">Charges</th>
                            <th class="text-center">Total</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    <%
                    int hour=Integer.parseInt(driverBill.getTRAVELLING_HOUR());
                    int charges=Integer.parseInt(driverEndUser.getDRIVER_CHARGES());
                    int whour=Integer.parseInt(driverBill.getWAITING_HOUR());
                    int wcharges=Integer.parseInt(driverEndUser.getDRIVER_WAITING_CHARGES());
                    
                    int totalCharges=charges*hour;
                    int totalWaiting=wcharges*whour;
                    
                    int totalAmount=totalCharges+totalWaiting;
                    
                    %>
                    
                        <tr>
                            <td class="col-md-9 col-xs-12"><em>Traveling charges</em></h4></td>
                            <td class="col-md-1 col-xs-12" style="text-align: center"> <%=driverBill.getTRAVELLING_HOUR() %> </td>
                            <td class="col-md-1 col-xs-12 text-center"><%=driverEndUser.getDRIVER_CHARGES() %></td>
                            <td class="col-md-1 col-xs-12 text-center"><%=totalCharges %></td>
                        </tr>
                        <tr>
                            <td class="col-md-9 col-xs-12"><em>Waiting charges</em></h4></td>
                            <td class="col-md-1 col-xs-12" style="text-align: center"> <%=driverBill.getWAITING_HOUR() %> </td>
                            <td class="col-md-1 col-xs-12 text-center"><%=driverEndUser.getDRIVER_WAITING_CHARGES() %></td>
                            <td class="col-md-1 col-xs-12 text-center"><%=totalWaiting %></td>
                        </tr>
                        
                      <!--   <tr>
                            <td> Â  </td>
                            <td> Â  </td>
                            <td class="text-right">
                            <p>
                                <strong>Subtotal:Â </strong>
                            </p>
                            </td>
                            <td class="text-center">
                            
                            <p>
                                <strong>$6.94</strong>
                            </p></td>
                        </tr> -->
                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td class="text-right"><h4><strong>Total:Âmount </strong></h4></td>
                            <td class="text-center text-danger"><h4><strong><%=totalAmount %></strong></h4></td>
                        </tr>
                    </tbody>
                </table>


            </div>
			
			<div class="row">
				<div class="receipt-header receipt-header-mid receipt-footer">
					<div class="col-xs-12 col-sm-8 col-md-8 text-left">
						<div class="receipt-right">
							<p><b>Date :</b> </p>
							<h5 style="color: rgb(140, 140, 140);">Thank you for your traveling!</h5>
						</div>
					</div>
					<div class="col-xs-12 col-sm-4 col-md-4">
						<div class="receipt-left">
							<h1>Signature</h1>
						</div>
					</div>
				</div>
            </div>
            
            	<div class="row">
				<div class="receipt-header receipt-header-mid receipt-footer">
					
					<div class="col-xs-12 col-sm-8 col-md-8 text-left">
						<div class="receipt-right">
						<form action="./DriverBillToUser" method="post">
						<input type="hidden" name="apptId" value="<%=apptId%>"/>
						<input type="hidden" name="tripId" value="<%=tripId%>"/>
						<input type="hidden" name="userId" value="<%=driverEndUser.getEMAIL()%>"/>
						<input type="submit" value="Send To Mail" class="btn btn-primary"/>
<!-- 							<h5 style="color: rgb(140, 140, 140);">Send To Mail</h5> -->
							</form>
						</div>
					</div>
					<div class="col-xs-12 col-sm-4 col-md-4">
						<div class="receipt-left">
							<a href="javascript:void(0);" class="btn btn-primary" onclick="printPageArea('printableArea')"> Print</a>
						</div>
					</div>
					
				</div>
            </div>
			
        </div>    
	</div>
	</div>
</div>



	
	</body>
</html>