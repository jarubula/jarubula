<%@ page language="java" import="com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	#ty{
	padding: 7px 11px;
    border-top: 3px solid #ff5a1f;
    background: #fff;
    border-bottom: 2px solid #f1f1f1;
	}
	.search12{
	background-color: white;
    width: 100%;
    height: 400px;
    overflow: auto;
    border:1px solid #fff;
    }
</style>
</head>
<body style="background: whitesmoke;">
<%
String sequenceno=request.getParameter("bikeid"); 
AddBike ab= new GetNewBikeDetails().getNewBikeCompleteDetails(sequenceno);
%>
                        
                                <div class="col-md-12" style="padding-left:0px;">
                                <div class="col-md-12" id="ty"> 
                                
                                 <button type="button" class="close" data-dismiss="alert" aria-label="close" data-dismiss="modal">&times;</button>
                                
                                <div class="col-md-10" style="padding:0px 0px;">
                                <span class="bi1"><%=ab.getBIKE_BRAND() %>> <%=ab.getBIKE_MODEL()%>> <%=ab.getVARIANT_NAME()%></span><br>
                                <span class="bi1">Bike ID :<%=ab.getNEW_BIKE_ID() %></span><br>
                                <span class="bi1">Ex-Showroom :</span>
	                   		    <span class="bi2"><i class="fa fa-inr"></i> <%=ab.getEX_SHOW_ROOM_PRICE()%> </span>
	                   			</div>
	                   			  
	                   			 <div class="col-md-1">
	                   			 <input type="checkbox" id="scales" name="scales" style="width:20px; height: 20px;">
	                   			 </div>
	                   			 
	                   			  <div class="col-md-12" style="padding:0px 0px;">
	                   			  <div class="control-group">
                                  <label class="col-md-1 control-label" for="username" style="padding:0px 0px;">City</label>
                                  <div class="col-md-5 controls">
                                  <select id="inputState" class="form-control" style="height: 25px;">
                                  <option selected>Hyderabad</option>
                                  <option> S.r nager</option>
                                  <option> Ameerpet</option>
                                  <option> JntuH</option>
                                  <option> Kphb</option>
                                  </select>
                                  </div>
                                  </div>
	                   			  </div>
	                   			  </div>
	                   			  
	                   			  
	                             <div class="col-md-12 search12">             			  
	                   			  <div class="col-md-12" style="padding:0 0px; margin: 7px 0;">
	                   			  <div class="panel-group" id="accordion">
                                  <div class="panel panel-default">
                                  <div class="panel-heading">
                                  <a class="bi3" data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                                  <h4 class="panel-title"> Engine</h4>   
                                  </a>
                                  </div>
                                  <div id="collapse1" class="panel-collapse collapse in">
                                  <div class="panel-body">
                                  <div class="col-md-12 bi4">
                                  <span class="one">Engine Type :</span>
                                  <span class="two"><%=ab.getENGINE_TYPE() %></span>
                                  </div>
                                     
                                  <div class="col-md-12 bi4">
                                  <span class="one">Displacement(cc) :</span>
                                  <span class="two"><%=ab.getDISPLACEMENT_CC() %></span>
                                  </div>
                                     
                                  <div class="col-md-12 bi4">
                                  <span class="one">Max Power :</span>
                                  <span class="two"><%=ab.getMAX_POWER() %></span>
                                  </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Maximum Torque :</span>
                                     <span class="two"><%=ab.getMAX_TORQUE() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Bore :</span>
                                     <span class="two"><%=ab.getBORE() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Stroke :</span>
                                     <span class="two"><%=ab.getSTROKE() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Ignition :</span>
                                     <span class="two"><%=ab.getIGNITION() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Electric Start :</span>
                                     <span class="two"><%=ab.getENGINE_STARTING() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">No Gears :</span>
                                     <span class="two"><%=ab.getNO_OF_GEARS() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Mileage : </span>
                                     <span class="two"><%=ab.getMILEAGE() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Top Speed :</span>
                                     <span class="two"><%=ab.getTOP_SPEED() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Color :</span>
                                     <span class="two"><%=ab.getCOLOR() %></span>
                                     </div>
                                     
                                     </div>
                                     </div>
                                     </div>
                                     
                                     <div class="panel panel-default">
                                     <div class="panel-heading">
                                     <a class="bi3" data-toggle="collapse" data-parent="#accordion" href="#collapse2">
                                     <h4 class="panel-title">Fuel </h4>
                                     </a>
                                     </div>
							         <div id="collapse2" class="panel-collapse collapse">
							         <div class="panel-body">
							         <div class="col-md-12 bi4">
                                     <span class="one">Fuel System :</span>
                                     <span class="two"><%=ab.getFUEL_SYSTEM() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Fuel Type :</span>
                                     <span class="two"><%=ab.getFUEL_TYPE() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Fuel Capacity :</span>
                                     <span class="two"><%=ab.getFUEL_CAPACITY() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Digital Fuel Indicator :</span>
                                     <span class="two"><%=ab.getDIGITAL_FUEL_INDICATOR() %></span>
                                     </div>
							         </div>
							         </div>
							         </div>
							         
                                     <div class="panel panel-default">
                                     <div class="panel-heading">
                                     <a class="bi3" data-toggle="collapse" data-parent="#accordion" href="#collapse3">
                                     <h4 class="panel-title"> Brakes </h4>
                                     </a>
                                     </div>
                                     <div id="collapse3" class="panel-collapse collapse">
                                     <div class="panel-body">
                                     <%-- <div class="col-md-12 bi4">
                                     <span class="one">Brake Light :</span>
                                     <span class="two"><%=ab.getBRAKE_LIGHT() %></span>
                                     </div> --%>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Front Brake :</span>
                                     <span class="two"><%=ab.getFRONT_BRAKE() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Rear Brake :</span>
                                     <span class="two"><%=ab.getREAR_BRAKE() %></span>
                                     </div>
                                     </div>
                                     </div>
								    </div>
								    
								    <div class="panel panel-default">
                                     <div class="panel-heading">
                                     <a class="bi3" data-toggle="collapse" data-parent="#accordion" href="#collapse4">
                                     <h4 class="panel-title">Tyres </h4>
                                     </a>
                                     </div>
                                     <div id="collapse4" class="panel-collapse collapse">
                                     <div class="panel-body">
                                     <div class="col-md-12 bi4">
                                     <span class="one">Tyre Type :</span>
                                     <span class="two"><%=ab.getTYRE_TYPE() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Front Tyre :</span>
                                     <span class="two"><%=ab.getFRONT_TYRE() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Rear Tyre :</span>
                                     <span class="two"><%=ab.getREAR_TYRE() %></span>
                                     </div>
                                     </div>
                                     </div>
								    </div>
								    
								    
								    <div class="panel panel-default">
                                     <div class="panel-heading">
                                     <a class="bi3" data-toggle="collapse" data-parent="#accordion" href="#collapse5">
                                     <h4 class="panel-title">Chassis</h4>
                                     </a>
                                     </div>
                                     <div id="collapse5" class="panel-collapse collapse">
                                     <div class="panel-body">
                                     <div class="col-md-12 bi4">
                                     <span class="one">Chassis Type :</span>
                                     <span class="two"><%=ab.getCHASSIS_TYPE() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Front Suspension :</span>
                                     <span class="two"><%=ab.getFRONT_SUSPENSION() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Rear Suspension :</span>
                                     <span class="two"><%=ab.getREAR_SUSPENSION() %></span>
                                     </div>
                                     </div>
                                     </div>
								    </div>
								    
								    <div class="panel panel-default">
                                     <div class="panel-heading">
                                     <a class="bi3" data-toggle="collapse" data-parent="#accordion" href="#collapse6">
                                     <h4 class="panel-title">Dimensions </h4>
                                     </a>
                                     </div>
                                     <div id="collapse6" class="panel-collapse collapse">
                                     <div class="panel-body">
                                     <div class="col-md-12 bi4">
                                     <span class="one">Length :</span>
                                     <span class="two"><%=ab.getLENGTH() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Width :</span>
                                     <span class="two"><%=ab.getWIDTH() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Height :</span>
                                     <span class="two"><%=ab.getHEIGHT() %></span>
                                     </div>
                                     </div>
                                     </div>
								    </div>
								    
								    <div class="panel panel-default">
                                     <div class="panel-heading">
                                     <a class="bi3" data-toggle="collapse" data-parent="#accordion" href="#collapse7">
                                     <h4 class="panel-title">Electricals </h4>
                                     </a>
                                     </div>
                                     <div id="collapse7" class="panel-collapse collapse">
                                     <div class="panel-body">
                                     <div class="col-md-12 bi4">
                                     <span class="one">Battery :</span>
                                     <span class="two"><%=ab.getBATTERY_CAPACITY() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Head Lamp :</span>
                                     <span class="two"><%=ab.getHEAD_LAMP() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Head Light Bulb :</span>
                                     <span class="two"><%=ab.getHEAD_LIGHT_BULB_TYPE() %></span>
                                     </div>
                                     </div>
                                     </div>
								    </div>
								    
								    <div class="panel panel-default">
                                     <div class="panel-heading">
                                     <a class="bi3" data-toggle="collapse" data-parent="#accordion" href="#collapse8">
                                     <h4 class="panel-title">Warranty </h4>
                                     </a>
                                     </div>
                                     <div id="collapse8" class="panel-collapse collapse">
                                     <div class="panel-body">
                                     <div class="col-md-12 bi4">
                                     <span class="one">Standard Warranty(Years) :</span>
                                     <span class="two"><%=ab.getSTANDARD_WARRANTY_YEARS() %></span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Standard Warranty(KMS) :</span>
                                     <span class="two"><%=ab.getSTANDARD_WARRANTY_KMS() %></span>
                                     </div>
                                     
                                     <!-- <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div> -->
                                     </div>
                                     </div>
								    </div>
								    
								    </div> 
								    </div>
	                   			    </div>
	                   			    </div>
</body>
</html>