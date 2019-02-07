<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%response.setHeader("Cache-Control", "private,no-store,no-cache"); %>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>VaahanMitra | Home</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        
        <script type="text/javascript" src="http://cdn.jsdelivr.net/hammerjs/2.0.3/hammer.min.js"></script>
        
        <script type="text/javascript" language="javascript" src="assets/js/FlameViewportScale.js"></script>
      
        <link href="assets/css/base.css" rel="stylesheet" type="text/css"/>
        
        <script type="text/javascript">
		
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
       <style>
       .form-control:focus {
    border-color: #ffffff;
    outline: 0;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075), 0 0 8px rgb(255, 255, 255);
    /* box-shadow: inset 0 1px 1px rgba(0,0,0,.075), 0 0 8px rgba(102,175,233,.6); */
     }
 
	 :focus {
	 outline: -webkit-focus-ring-color auto 0px; !important;
	 }      </style> 
	    </head>
	    <body onscroll="myFunction()">
	        <!-- page loader -->
	        <div class="se-pre-con"></div>
	        <div id="page-content" style="background: #fff">
	            <!-- navber -->
	           
	           <jsp:include page="./homeTop.jsp"></jsp:include>
	       
	            <!-- /.nav end -->
	            <div class="slider-wrapper ">
	            <div class="col-md-12 ">
	                
                 <div id="myCarousel" class="carousel slide text-center" data-ride="carousel">
                 
      <div class="carousel-inner " role="listbox">
      <div class="item active">
        <h4 class="box3 gfont">Free Posting Cars And Bikes</h4>
        <h5 class="box4 gfont">Vaahan Mitra</h5>
      </div>
      <div class="item">
        <h4 class="box3 gfont">Search</h4>
        <h5 class="box4 gfont">Sell Your Used Cars And Bikes</h5>
      </div>
      <div class="item">
        <h4 class="box3 gfont">Search</h4>
        <h5 class="box4 gfont">Used Cars And  Bikes</h5>
      </div>
 
       <div class="item">
        <h4 class="box3 gfont">Free posting your service Center and Spareparts Shop  </h4>
      </div>
     </div>
     </div>

                </div>
                <div class="responisve-container">
                    <div class="slider">
                    
                    </div>
                </div>
            </div>
            <!-- booking -->
            <div class="container boking-inner">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="panel">
                            <div class="panel-heading">
                                <ul class="nav nav-tabs">
                                    
                                    <li align="center"  class="active col-md-2 col-sm-6 col-xs-12" id="p-well"><a id="show" href="#tab1default" data-toggle="tab"><i class="fa fa-car"></i> New Vehicles </a></li>
                                    <li align="center" class= "col-md-2 col-sm-6 col-xs-12" id="p-well"><a id="hide" href="#tab2default" data-toggle="tab"><i class="fa fa-motorcycle"></i> Used Vehicles</a></li>
                                  <!--   <li align="center" class= "col-md-2 col-sm-6 col-xs-12" id="p-well"><a href="#tab4default" data-toggle="tab"><i class="fa fa-male"></i> Used Vehicle Dealer</a></li> -->
                                     <li align="center" class= "col-md-2 col-sm-6 col-xs-12" id="p-well" ><a href="#tab3default" data-toggle="tab"><i class="fa fa-cogs"></i> Service Center</a></li>
                                     <li align="center" class= "col-md-2 col-sm-6 col-xs-12" id="p-well"><a href="#tab5default" data-toggle="tab"><i class="fa fa-wrench"></i> Spare Parts</a></li>
                                    
                             
                                </ul>
                            </div>
                            <div class="panel-body" >
                                <div class="tab-content">
                                    <div class="tab-pane fade in active" id="tab1default">
                                    <div class="panel-body1">
                                        <div class="row">
                                        <form action="./SearchNewVehicle" method="post">
                                            <div class="col-md-12 col-sm-12 col-xs-12">
                                                <div class="row panel-margin">
                                                <div class="col-md-3 col-sm-6 col-xsm-12 hidden-sm panel-padding">
                                                        <label>VEHICLE TYPE</label>
                                                        <!-- filters select -->
                                                        <div class="select-filters">
                                                             <select class="form-control" name="vType" id="vType" onchange="getNewVcleBrand(this.value)" required>
																	<option value="" style="display: none;">VEHICLE TYPE</option>
																	<option value="2,">TWO WHEELER</option>
																	<option value="4,">FOUR WHEELER(Light Vehicle)</option>
																</select>
                                                        </div>
                                                    </div>
                                                     <div class="col-md-3 col-sm-6 col-xsm-12 hidden-sm panel-padding">
                                                        <label>VEHICLE BRAND</label>
                                                        <!-- filters select -->
                                                        <div class="select-filters" id="txtHint20">
                                                            <select name="vehicleBrand" class="form-control">
                                                                <option value="SELECT" style="display:none;">VEHICLE BRAND</option>
                                                                
                                                            </select>
                                                        </div>
                                                    </div>
                                                     <div class="col-md-3 col-sm-6 col-xsm-12 hidden-sm panel-padding">
                                                        <label>VEHICLE MODEL</label>
                                                        <!-- filters select -->
                                                        <div class="select-filters" id="txtHintD">
                                                            <select name="vehicleModel" class="form-control" >
                                                                <option value="SELECT" style="display:none;">VEHICLE MODEL</option>
                                                            </select>
                                                        </div>
                                                    </div>
														 <div class="col-xs-12 col-sm-6 col-md-1 hidden-sm panel-padding"></div>
                                                      <div class="col-xs-12 col-sm-2 col-md-2 hidden-sm panel-padding">
                                                     <input  type="submit" value="Search" class="thm-btn">
                                                    </div>
                                                    <div class="col-md-2">
                                                    </div>
                                                </div>
                                            </div>
                                            </form>
                                            </div>
                                         </div>
                                         <br>
                                         <iframe class="col-md-12 col-sm-12 col-xs-12 media" marginheight="50" frameBorder="0"  src="car.html" width="100%" height="310px" scrolling="no" style="padding: 0 0;">
                                         </iframe>
                                    </div>
                                    <div class="tab-pane fade" id="tab2default">
                                    <div class="panel-body1">
                                        <div class="row">
                                        <form action="./SearchHUsedVehicle" method="post">
                                            <div class="col-xs-12 col-sm-12 col-md-12">
                                                <div class="row panel-margin">
                                                <div class="col-xs-12 col-sm-3 col-md-3 hidden-sm panel-padding">
                                                        <label>Vehicle Type</label>
                                                        <!-- filters select -->
                                                        <div class="select-filters">
                                                             <select name="vType" class="form-control" id="vBrand" onchange="getUsedVcleBrand(this.value)" required>
                                                             <option value="" style="display:none;">VEHICLE TYPE</option>
                                                             <option value="2,">TWO WHEELER</option>
                                                              <option value="4,">FOUR WHEELER</option>
                                                             </select>
                                                        </div>
                                                    </div>
                                                <div class="col-xs-12 col-sm-3 col-md-3 hidden-sm panel-padding" >
                                                        <label>Brand</label>
                                                        <!-- filters select -->
                                                        <div class="select-filters" id="txtHint2">
                                                           <select name="vehicleBrand" class="form-control" id="vModel">
                                                             	<option value="SELECT" style="display:none;">SELECT BRAND</option>
                                                             </select>
                                                        </div>
                                                    </div>
                                                     <div class="col-xs-12 col-sm-2 col-md-2 hidden-sm panel-padding">
                                                        <label>Model</label>
                                                        <!-- filters select -->
                                                        <div class="select-filters" id="txtHintH" >
                                                          <select name="vehicleModel" class="form-control" >
                                                               <option value="SELECT" style="display:none;">SELECT MODEL</option>
                                                               	<option value="Any">Any</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                      <%
                                                     	 	GetUsedVehicleDetails city2 = new GetUsedVehicleDetails();
                                                      		Set<String> vCity = city2.getVehicleCity();
                                                    	 	Iterator itr1 = vCity.iterator();
                                                    %>
                                                    <div class="col-xs-12 col-sm-2 col-md-2 hidden-sm panel-padding">
                                                        <label>City</label>
                                                        <!-- filters select -->
                                                        <div class="select-filters">
                                                                <select name="city" class="form-control">
                                                                <option value="SELECT" style="display:none;">SELECT CITY</option>
                                                                <option value="All">All</option>
                                                                <%
                                                                while(itr1.hasNext()){
                                                                	String ub = (String)itr1.next();
                                                                	%>
                                                                	<option value="<%=ub%>"><%=ub%></option>
                                                                <%
                                                                }
                                                                %>
                                                            </select>
                                                            
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-12 col-sm-2 col-md-2 hidden-sm panel-padding">
                                                     <input type="submit" value="&nbsp;&nbsp;&nbsp;&nbsp;Search&nbsp;&nbsp;&nbsp;&nbsp;" class="thm-btn">
                                                    </div>
                                                </div>
                                            </div>
                                            </form>
                                            </div>
                                        </div>
                                        <br>
                                        <!--slider-->
                                            <iframe frameBorder="0" class="col-md-12 col-sm-12 col-xs-12" src="bike.html" width="100%" height="310px" scrolling="no" style="padding: 0 0;">
                                             </iframe>
                                            <!--slider ends-->                                      
                                               </div>
                                                    <div class="tab-pane fade" id="tab4default">
                                    <div class="panel-body1">
                                        <div class="row">
                                        <form action="./SearchHUsedVehicleDealer" method="post">
                                            <div class="col-xs-12 col-sm-12 col-md-12">
                                                <div class="row panel-margin">
                                                <div class="col-xs-12 col-sm-6 col-md-3 hidden-sm panel-padding">
                                                        <label>Vehicle Type</label>
                                                        <!-- filters select -->
                                                        <div class="select-filters">
                                                         <select name="vehicleType" class="form-control">
                                                             <option value="SELECT" style="display:none;">Vehicle Type</option>
                                                             <option value="4,2,">All</option>
                                                             <option value="2,">Two Wheeler</option>
                                                             <option value="4,">Four Wheeler</option>
                                                             
                                                             </select>
                                                        </div>
                                                    </div>
                                                    
                                                      <%
                                                    GetUsedVehicleDealerServices dservice=new GetUsedVehicleDealerServices();
                                                    ArrayList<BusinessOwnerRegister> dealerAl=dservice.getCity();
                                                    Iterator dit=dealerAl.iterator();
                                                    %>
                                                   
                                                <div class="col-xs-12 col-sm-6 col-md-3 hidden-sm panel-padding">
                                                        <label>City</label>
                                                        <!-- filters select -->
                                                        <div class="select-filters">
                                                           <!--   <select name="city" class="form-control" id="dName" onchange="showDealerName(this.value)">
                                                             <option value="SELECT" style="display:none;">City</option>
                                                              
                                                            <option value="Bangalore">Bangalore</option>
                                                            
                                                            <option value="Hyderabad">Hyderabad</option>
                                                            
                                                             </select> -->
                                                             
                                                              <select name="city" class="form-control" id="dName" onchange="showDealerName(this.value)">
															 <option value="SELECT" style="display:none;">City</option>
															 <option value="All">All</option>
															  <%
                                                    		while(dit.hasNext()){
                                                    			BusinessOwnerRegister dealerCity=(BusinessOwnerRegister)dit.next();
                                                    		%>
                                                    		<option value="<%=dealerCity.getB_CITY()%>"><%=dealerCity.getB_CITY()%></option>
                                                    		<%} %>
															 </select>
                                                             
                                                             
                                                        </div>
                                                    </div>
                                                     <div class="col-xs-12 col-sm-6 col-md-3 hidden-sm panel-padding">
                                                        <label>Dealer Name</label>
                                                        <!-- filters select -->
                                                        <div class="select-filters" id="txtHint4">
                                                            <select name="dealerName" class="form-control">
                                                                <option value="SELECT" style="display:none;">Dealer Name</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="col-xs-12 col-sm-6 col-md-3 hidden-sm panel-padding">
                                                     <input type="submit" value="&nbsp;&nbsp;&nbsp;&nbsp;Search&nbsp;&nbsp;&nbsp;&nbsp;" class="thm-btn">
                                                    </div>
                                                    

                                                </div>
                                            </div>
                                           
                                            </form>
                                            </div>
                                        </div>
                                        
                                        <br>
                                         <iframe class="col-md-12 col-sm-12 col-xs-12 media" marginheight="50" frameBorder="0"  src="car.html" width="100%" height="310px" scrolling="no" style="padding: 0 0;">
                                         </iframe>
                                    </div>
                                       <%
                                    GetMechanicDetails mdetails=new GetMechanicDetails();
                                    ArrayList<BusinessOwnerRegister> city=mdetails.getCity();
                                    ArrayList<ServiceMechanic> vehicaleType=mdetails.getVehicleType();
                                    Iterator typeit=vehicaleType.iterator();
                                    Iterator it= city.iterator();
                                    %>
                                               
                                            <div class="tab-pane fade" id="tab3default">
                                            <div class="panel-body1">
                                             <div class="row">
                                               <form action="./SearchHMechanic" method="post">
                                            <div class="col-xs-12 col-sm-12 col-md-12">
                                                <div class="row panel-margin">
                                                <div class="col-md-3 col-sm-6 col-xsm-12 hidden-sm panel-padding">
                                                        <label>City</label>
                                                        <!-- filters select -->
                                                        <div class="select-filters">
                                                         <!--  <select name="city" class="form-control" id="">
                                                             <option value="SELECT" style="display:none;">City</option>
                                                             
                                                                <option value="Hyderabad">Hyderabad</option>
                                                            
                                                                <option value="Karimnagar">Karimnagar</option>
                                                            
                                                        
                                                             </select> -->
                                                             
                                                             <select name="city" class="form-control" id="" onchange="showServiceStreet(this.value)">
															 <option value="SELECT" style="display:none;">City</option>
															 <option value="All">All</option>
															 <%
															 while(it.hasNext()){
																 BusinessOwnerRegister bean=(BusinessOwnerRegister)it.next(); 
																%>
																<option value="<%=bean.getB_CITY() %>"><%=bean.getB_CITY() %></option>
															<% 
															 }
															 %>
														
															 </select>
                                                             
                                                             
                                                        </div>
                                                    </div>
                                                     <div class="col-xs-12 col-sm-4 col-md-3 hidden-sm panel-padding">
                                                        <label>Location</label>
                                                        <!-- filters select -->
                                                        <div class="select-filters" id="txtHint6">
                                                          <select name="street" class="form-control" id="">
															 <option value="SELECT" style="display:none;">Location</option>
															 </select>
                                                        </div>
                                                    </div>
                                                <div class="col-md-2 col-sm-6 col-xsm-12 hidden-sm panel-padding">
                                                        <label>Vehicle Type</label>
                                                        <!-- filters select -->
                                                        <div class="select-filters">
                                                             <select name="vehicleType" class="form-control" id="vBrand" onchange="showVehicleBrand(this.value)">
                                                             <option value="SELECT" style="display:none;">Vehicle Type</option>
                                                             <option value="4,2,">All</option>
                                                             <option value="2,">TWO WHEELER</option>
                                                              <option value="4,">FOUR WHEELER</option>
                                                              

                                                             </select>
                                                        </div>
                                                    </div>
                                                     <div class="col-md-2 col-sm-6 col-xsm-12 hidden-sm panel-padding">
                                                        <label>Vehicle Brand</label>
                                                        <!-- filters select -->
                                                        <div class="select-filters" id="txtHint3">
                                                            <select name="vehicleBrand" class="form-control">
                                                                <option value="SELECT" style="display:none;">Vehicle Brand</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                   <div class="col-md-2 col-sm-6 col-xsm-12 hidden-sm panel-padding">
                                                        <input style="width:100%"" type="submit" class="thm-btn" value="&nbsp;&nbsp;&nbsp;&nbsp;Search&nbsp;&nbsp;&nbsp;&nbsp;">
                                                    </div>
                                                </div>
                                            </div>
                                          
                                            </form>
                                        </div>
                                        </div>
                                        <br>
                                           <iframe frameBorder="0" class="col-md-12 col-sm-12 col-xs-12" src="service.html" width="100%" height="250px" scrolling="no" style="padding: 0 0;">
                                           
                                             </iframe>
                                    </div>
                                   
                               
                                      <div class="tab-pane fade" id="tab5default">
                                    <div class="panel-body1">
                                        <div class="row">
                                        <form action="./SearchHSpareParts" method="post">
                                             <div class="col-xs-12 col-sm-9 col-md-12">
                                                <div class="row panel-margin">
                                                  <div class="col-md-2 col-sm-6 col-xsm-12 hidden-sm panel-padding">
                                                        <label>Vehicle Type</label>
                                                        <!-- filters select -->
                                                        <div class="select-filters">
                                                             <select name="vehicleType" class="form-control" id="spBrand" onchange="getVehicleBrand(this.value)">
                                                             <option value="SELECT" style="display:none;">Vehicle Type</option>
                                                             <option value="4,2,">All</option>
                                                             <option value="2,">TWO WHEELER</option>
                                                              <option value="4,">FOUR WHEELER</option>
                                                             </select>
                                                        </div>
                                                    </div>
                                                    <input type="hidden" value="SELECT" name="subCategory"/>
                                                     <div class="col-md-2 col-sm-6 col-xsm-12 hidden-sm panel-padding">
                                                        <label>Brand</label>
                                                        <!-- filters select -->
                                                         <div class="select-filters" id="txtHint10">
                                                            <select name="vehicleBrand" class="form-control">
                                                                <option value="SELECT" style="display:none;">Vehicle Brand</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    
                                                     <div class="col-md-2 col-sm-6 col-xsm-12 hidden-sm panel-padding">
                                                        <label>Model</label>
                                                        <!-- filters select -->
                                                       <div class="select-filters" id="txtHint11">
                                                            <select name="vehicleModel" class="form-control" >
                                                                <option value="SELECT" style="display:none;">Vehicle Model</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    
                                                    <%
                                                    GetSparePartsDetails spd = new GetSparePartsDetails();
                                                     ArrayList<SpareParts> spC= spd.getCategory();
                                                     Iterator itspc = spC.iterator();
                                                    %>
                                                    
                                                     <div class="col-xs-12 col-sm-4 col-md-2 hidden-sm panel-padding">
                                                        <label>Category</label>
                                                        <!-- filters select -->
                                                      <div class="select-filters">
                                                      
										                <select name="category" class="form-control">
										                <option value="SELECT" style="display:none;">Category</option>
										                <option value="All">All</option>
										                <%
                                                        while(itspc.hasNext()){
                                                       SpareParts category = (SpareParts)itspc.next();
                                                       %>
                                                      <option value="<%=category.getCATEGORY()%>"><%=category.getCATEGORY()%></option>
                                                      <%} %>
                									</select>
                									
                                                        </div>
                                                    </div>
                                                
                                                
                                                 <%
                                                    ArrayList<BusinessOwnerRegister> spdAl = spd.getCity();
                                                    Iterator itsp = spdAl.iterator();
                                                    %>
                                                
                                                <div class="col-md-2 col-sm-6 col-xsm-12 hidden-sm panel-padding">
                                                        <label>City</label>
                                                        <!-- filters select -->
                                                       <div class="select-filters">
                                                       
                                                         <select name="city" class="form-control">
										                <option value="SELECT" style="display:none;">City</option>
										                <option value="All">All</option>
										                 <%
                                                      while(itsp.hasNext()){
                                                       BusinessOwnerRegister spCity = (BusinessOwnerRegister)itsp.next();
                                                      %>
                                                      <option value="<%=spCity.getB_CITY()%>"><%=spCity.getB_CITY()%></option>
                                                      <%} %>
                										</select>
                										
                                                        </div>
                                                    </div>
                                                     
                                                   <div class="col-md-2 col-sm-6 col-xsm-12 hidden-sm panel-padding">
                                                        <input style="width:100%"" type="submit" class="thm-btn" value="Search">
                                                    </div>
                                                </div>
                                            </div>
                                           
                                            </form>
                                            </div>
                                        </div>
                                        
                                          <br>
                                         <iframe frameBorder="0" class="col-md-12 col-sm-12 col-xs-12" src="service.html" width="100%" height="250px" scrolling="no" style="padding: 0 0;">
                                           
                                             </iframe>

                                    </div>
                                    
                            
                                </div>
                            </div>
                        </div>

                       <div class="container">
                           <div class="col-md-12">
                               <p></p>
                           </div>

                       </div>
                       <div  class="container">
                        
                       </div>
                        
                    </div>
                </div>
            </div>
            <!-- popular tour -->
            
            <!-- service -->
            <section class="service-inner">
                <div class="container ">
                    <div class="row bg-success" style="height:50px; margin: 0px 30px 0px 8px;">
                        <div class="col-md-6 col-md-offset-3">
                            <div class="title">
                                <h2 style="margin-top:5px;">Our Service</h2>
                                
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 col-md-12">
                            <div class="col-sm-3 inner-box">
                                <article>
                                    <img style="width:46px;" src="assets/images/car.png" alt="Smiley face" width="42" height="42">
                                    <div class="content-text">
                                        <h5>Used Car</h5>
                                        <p>
                                        Vaahanmitra.com - One of the most trusted automobile portals in the country provides very useful information on buying new cars. It also contains useful information related to spare parts and vehicles service,insurance
                                        <br><!-- <div class="col-md-12 btn-primary " align="center" >
                                         <a  class="whits" href="./register.jsp">Register</a> 
                                        
                                        </div> -->
                                        <a type="submit" class="btn btn-primary btn-block" href="./register.jsp">Register</a>
                                        </p>
                                    </div>
                                </article>
                            </div>
                            <div class="col-sm-3 inner-box">
                                <article>
                                    <img style="width:70px;" src="assets/images/motorbycle.png" alt="Smiley face" width="42" height="42">
                                    <div class="content-text">
                                        <h5>Used Bike</h5>
                                         <p>
                                        Vaahanmitra.com - One of the most trusted automobile portals in the country provides very useful information on buying new Bikes. It also contains useful information related to, spare parts and vehicles service, insurance
                                         <br><!-- <div class="col-md-12 btn-primary "><a  class="whits" href="./register.jsp">Register</a></div> -->
                                         <a type="submit" class="btn btn-primary btn-block" href="./register.jsp">Register</a>
                                        </p>
                                    </div>
                                </article>
                            </div>
                            <div class="col-sm-2 inner-box">
                                <article>
                                    <img style="width:46px;" src="assets/images/service.png" alt="Smiley face" width="42" height="42">
                                    <div class="content-text">
                                        <h5>Service Center</h5>
                                       <p>
               Vaahanmitra.com - One of the most trusted Rely on the industry's largest customer service network for 24/7 product and field support.
                       
                        <br><!-- <div class="col-md-12 btn-primary "><a class="whits" href="./register.jsp">Register</a></div> -->
                        <a type="submit" class="btn btn-primary btn-block" href="./register.jsp">Register</a>
                                        </p>
                                    </div>
                                </article>
                            </div>
                            <div class="col-sm-2 inner-box">
                                <article>
                                    <img style="width:82px;" src="assets/images/used-cars.png" alt="Smiley face" width="42" height="42">
                                    <div class="content-text">
                                        <h5>Spare Parts</h5>
                                        <p>
Vaahanmitra.com Supports the digitalization of your inventory and enable on-demand production and rapid delivery of your spare parts.
 <br><!-- <div class="col-md-12 btn-primary"><a class="whits"  href="./register.jsp">Register</a></div> -->
 <a type="submit" class="btn btn-primary btn-block" href="./register.jsp">Register</a>
                                        </p>
                                    </div>
                                </article>
                            </div>
                            <div class="col-sm-2 inner-box">
                                <article>
                                <span style="font-size:36px;"><i class="fa fa-car" aria-hidden="true"></i></span>
                                   <!--  <img style="width:70px;" src="assets/images/driver.png" alt="Smiley face" width="42" height="42"> -->
                                    <div class="content-text">
                                        <h5 style="margin: 0px 0; margin-bottom: 10px;">New Vehicles</h5>
                                        <p>
										 Vaahanmitra.com will assign you the best matched professional to fulfill your requirements.
										 <br><br><br>											 
										 <a type="submit" class="btn btn-primary btn-block" href="./register.jsp">Register</a>
										 
                                        </p>
                                    </div>
                                </article>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </section>
            
            
            <!-- blog section -->
            <section class="blog-inner">
                <div class="container">
                    <div class="row bg-success" style="height:50px; margin: 0px 30px 0px 8px;">
                        <div class="col-md-6 col-md-offset-3">
                            <div class="title">
                                <h2 style="margin-top:10px;">New Cars</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row thm-margin">
                        <div id="blog-slide" class="owl-carousel">
                            <!-- blog post item -->
                            <div class="item">
                                <div class="blog-content">
                                    <div class="blog-img image-hover f">
                                        <a href="#"><img src="assets/images/c1.jpg" class="img-responsive" alt=""></a>
                                        <!-- <span class="post-date">14 November 2016</span> -->
                                        <!-- <div class="overlay">
                                        <div class="text" style=" background: #9a2220; padding: 4px 12px 4px 12px; border: 2px solid #dff0d8; border-radius: 3px;">14 November 2016</div>
                                        </div> -->
                                    </div>
                                   
                                </div>
                            </div>
                            <!-- blog post item -->
                            <div class="item">
                                <div class="blog-content">
                                    <div class="blog-img image-hover f">
                                        <a href="#"><img src="assets/images/c2.jpg" class="img-responsive" alt=""></a>
                                        <!-- <span class="post-date">14 November 2016</span> -->
                                        <!-- <div class="overlay">
                                               <div class="text" style=" background: #9a2220; padding: 4px 12px 4px 12px; border: 2px solid #dff0d8; border-radius: 3px;">14 November 2016</div>
                                                    </div> -->
                                    </div>
                                   
                                </div>
                            </div>
                            <!-- blog post item -->
                            <div class="item">
                                <div class="blog-content">
                                    <div class="blog-img image-hover f">
                                        <a href="#"><img src="assets/images/c5.jpg" class="img-responsive" alt=""></a>
                                        <!-- <span class="post-date">14 November 2016</span> -->
                                       <!--  <div class="overlay">
                                               <div class="text" style=" background: #9a2220; padding: 4px 12px 4px 12px; border: 2px solid #dff0d8; border-radius: 3px;">14 November 2016</div>
                                                    </div> -->
                                    </div>
                                    <!-- <h4><a href="#">It is a long established fact that</a></h4>
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p> -->
                                </div>
                            </div>
                            <!-- blog post item -->
                            <div class="item">
                                <div class="blog-content">
                                    <div class="blog-img image-hover f">
                                        <a href="#"><img src="assets/images/c6.jpg" class="img-responsive" alt=""></a>
                                        <!-- <span class="post-date">14 November 2016</span> -->
                                      <!--   <div class="overlay">
                                               <div class="text" style=" background: #9a2220; padding: 4px 12px 4px 12px; border: 2px solid #dff0d8; border-radius: 3px;">14 November 2016</div>
                                                    </div> -->
                                    </div>
                                  
                                </div>
                            </div>
                            <!-- blog post item -->
                            <div class="item">
                                <div class="blog-content">
                                    <div class="blog-img image-hover f">
                                        <a href="#"><img src="assets/images/c3.jpg" class="img-responsive" alt=""></a>
                                        <!-- <span class="post-date">14 November 2016</span> -->
                                        <!-- <div class="overlay">
                                               <div class="text" style=" background: #9a2220; padding: 4px 12px 4px 12px; border: 2px solid #dff0d8; border-radius: 3px;">14 November 2016</div>
                                                    </div> -->
                                    </div>
                                    <!-- <h4><a href="#">It is a long established fact that</a></h4>
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="container">
                
                   <div class="row bg-success" style="height:50px; margin: 0px 30px 0px 8px;">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="title">
                                <h2 style="margin-top:6px;">Service center</h2>
                            </div>
                        </div>
                        
                    </div> 
                    <br>      
           <iframe frameBorder="0" class="col-md-12 col-sm-12 col-xs-12" src="service.html" width="100%" height="270px" scrolling="no" style="padding: 0 0;"></iframe>
            </section>

            
        </div>
        <!-- Footer Section -->
        <footer>
            <jsp:include page="footer.jsp"></jsp:include>
        </footer>
        <!-- jQuery -->
        <script src="assets/js/jquery.min.js" type="text/javascript"></script>
        <!-- jquery ui js -->
        <script src="assets/js/jquery-ui.min.js" type="text/javascript"></script>
        <!-- bootstrap js -->
        <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- fraction slider js -->
        <script src="assets/js/jquery.fractionslider.js" type="text/javascript"></script>
        <!-- owl carousel js --> 
        <script src="assets/owl-carousel/owl.carousel.min.js" type="text/javascript"></script>
        <!-- counter -->
        <script src="assets/js/jquery.counterup.min.js" type="text/javascript"></script>
        <script src="assets/js/waypoints.js" type="text/javascript"></script>
        <!-- filter portfolio -->
        <script src="assets/js/jquery.shuffle.min.js" type="text/javascript"></script>
        <script src="assets/js/portfolio.js" type="text/javascript"></script>
        <!-- magnific popup -->
        <script src="assets/js/jquery.magnific-popup.min.js" type="text/javascript"></script>
        <!-- range slider -->
        <script src="assets/js/ion.rangeSlider.min.js" type="text/javascript"></script>
        <script src="assets/js/jquery.easing.min.js" type="text/javascript"></script>
        <!-- custom -->
        <script src="assets/js/custom.js" type="text/javascript"></script>
        
        
<!--         
                		 <script>
function showState(str)
{
	if (str=="")  
	{  
		document.getElementById("txtHint5").innerHTML="";  
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
			document.getElementById("txtHint5").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./district1.jsp?state="+str,true);   
	xmlhttp.send();    
	}
	</script> -->
	<script>
	function getVehicleModels(str) {
		var vType = document.getElementById("vType").value;
		if (str == "") {
			document.getElementById("txtHintD").innerHTML = "";
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
				document.getElementById("txtHintD").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./getADNewVecleModel.jsp?vBrand="+str+ "&vType="+ vType, true);
		xmlhttp.send();
	}
</script>
	
	<script>
function getNewVcleBrand(str)
{
	if (str=="")  
	{  
		document.getElementById("txtHint20").innerHTML="";  
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
			document.getElementById("txtHint20").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./getADNewVecleBrand.jsp?vType="+str,true);   
	xmlhttp.send();    
	}
	</script>
	<script>
	function getUsedVcleModel(str) {
		var vType = document.getElementById("vBrand").value;
		if (str == "") {
			document.getElementById("txtHintH").innerHTML = "";
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
				document.getElementById("txtHintH").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./getUsedVcleModel.jsp?vModel="+str+ "&vType="+ vType, true);
		xmlhttp.send();
	}
</script>

	        	 <script>
function showDealerName(str)
{
	if (str=="")  
	{  
		document.getElementById("txtHint4").innerHTML="";  
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
			document.getElementById("txtHint4").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./getDealerName.jsp?city="+str,true);   
	xmlhttp.send();    
	}
	</script>
	<script>
function getUsedVcleBrand(str)
{
	if (str=="")  
	{  
		document.getElementById("txtHint2").innerHTML="";  
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
			document.getElementById("txtHint2").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./getUsedVecleBrand.jsp?vBrand="+str,true);   
	xmlhttp.send();    
	}
	</script>
<!-- 	<script type="text/javascript">
function validateForm()
{
if( document.getElementById("state").value == "SELECT" )
   {
     alert( "Please select State!" );
     document.getElementById("state").focus();
     return false;
   }
return true;
}
</script> -->
       	 <script>
function showBrand(str)
{
	if (str=="")  
	{  
		document.getElementById("txtHint1").innerHTML="";  
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
			document.getElementById("txtHint1").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./getCarModels.jsp?brand="+str,true);   
	xmlhttp.send();    
	}
	</script>

		        	 <script>
function showVehicleBrand(str)
{
	if (str=="")  
	{  
		document.getElementById("txtHint3").innerHTML="";  
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
			document.getElementById("txtHint3").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./vehicleBrand.jsp?vBrand="+str,true);   
	xmlhttp.send();    
	}
	</script>
	
	      <script>
function showServiceStreet(str)
{
 	// var city=document.getElementById("mcity").value;
	if (str=="")  
	{  
		document.getElementById("txtHint6").innerHTML="";  
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
			document.getElementById("txtHint6").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./getServiceStreet.jsp?street="+str,true);   
	xmlhttp.send();    
	}
	</script>
        
        
        
        
        <script>
function getVehicleBrand(str)
{
 if (str=="")  
 {  
  document.getElementById("txtHint10").innerHTML="";  
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
   document.getElementById("txtHint10").innerHTML=xmlhttp.responseText;    
   }  
  }
 xmlhttp.open("GET","./vehicleSpBrand.jsp?spBrand="+str,true);   
 xmlhttp.send();    
 }
 </script>  
  <script>
function getVehicleModel(str)
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
 xmlhttp.open("GET","./getVehicleModels.jsp?brand="+str,true);   
 xmlhttp.send();    
 }
 </script>
 <script type="text/javascript">

 document.getElementById('index').className = 'active';

 </script>
        
        
       <!--  <script type="text/javascript">
        $(".uc").css("position", "relative","top","-15","left","20%");
        		
        		
        	
        </script> -->
        
    </body>
</html>