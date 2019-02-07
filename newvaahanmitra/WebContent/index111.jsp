<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
		<%response.setHeader("Cache-Control", "private,no-store,no-cache"); %>
		<title>VaahanMitra | cars for sale - sell my car</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <meta name="keywords" CONTENT="cars for sale, used cars, cheap cars, old cars for sale, cheap cars for sale, sell my car, second hand cars, used cars for sale near me, cheap used cars, buy used cars, used car sales, buy a car, second hand cars for sale, old cars, car rentals">
        <meta name="description" CONTENT="vaahanmitra is the website for cars to sell,either new or new cars our searchengine displays diffent showrooms arround india u can choose which shop you want and spare part shops and old cars.">

        <!-- Global site tag (gtag.js) - Google Analytics -->
		<script async src="https://www.googletagmanager.com/gtag/js?id=UA-120521027-1"></script>
		<script>
		  window.dataLayer = window.dataLayer || [];
		  function gtag(){dataLayer.push(arguments);}
		  gtag('js', new Date());
		
		  gtag('config', 'UA-120521027-1');
		</script>
        <link href="assets/images/cg1.png" type="icon/img" rel="icon">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script type="text/javascript" src="https://cdn.jsdelivr.net/hammerjs/2.0.3/hammer.min.js"></script>
        
        <script type="text/javascript" language="javascript" src="assets/js/FlameViewportScale.js"></script>
      
        <link href="assets/css/base.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style1.css" rel="stylesheet" type="text/css"/>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js"></script>
       
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
	 }  
	 .sticky + .content {
    padding-top: 70px;
}
.in1{
     font-size:32px;
    color: #9a2220;
    font-family: sans-serif;
    }
   .in2 p{
    font-family: cursive;
    font-size:36px !important;
    color: #fff !important;
    margin: 0 4px;
    line-height: 2em;
    text-align: center;
    }
    .in1 {
    font-size:40px;
    color: #ffffff;
    font-family: sans-serif;
}
 .content {
    padding: 8px;
}
.autocomplete{
    position: absolute;
    background: #fff;
    z-index: 1;
    padding: 0 9px;
    line-height: 22px;
    font-size: 15px;
    font-weight: 500;
    padding-right: 0px;
    border: 1px solid #e0dede;
    border-bottom-left-radius: 5px;
    border-bottom-right-radius: 5px;
    width: 91%;
}
.car1{
    color: #000;
    font-size: 26px;
    text-align: center;
    line-height: 0px;
    margin-bottom: 4%;
    }
   label {
    display: inline-block;
    max-width: 100%;
    margin-bottom:0px !important;
    font-weight: 700;
} 

    </style> 
       
       <link href="https://www.vaahanmitra.com/" rel="canonical" />
       <meta name="google-site-verification" content="cELf32NYuRK6al5EyOSC58DIhbHAATfwVpNIkq7rKfU" />
	    </head>
	    
	    <body onscroll="myFunction()">
	    <%!String bocities =""; %>
	        <!-- page loader -->
	        <div class="se-pre-con"></div>
	        <div id="page-content" style="background: #fff">  
	           <jsp:include page="./homeTop.jsp"></jsp:include>
	            <div class="slider-wrapper ">
	            <div class="col-md-12 ">  
                 <div id="myCarousel" class="carousel slide text-center" data-ride="carousel">
        <div class="carousel-inner " role="listbox">
        
        <div class="item active">
        <h4 class="box3 gfont">Free Posting Cars And Bikes Vaahan Mitra</h4>
        </div>
      
        <div class="item">
        <h4 class="box3 gfont">Search Sell Your Used Cars And Bikes</h4>
        </div>
        
        <div class="item">
        <h4 class="box3 gfont">Search Used Cars And  Bikes</h4>
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
            
       <!-- <a href="#menu" id="toggle"><span></span></a>   -->   
   


            <!--=============================== booking =========================-->
               <!--  <div class="container boking-inner"> -->
                <div class="boking-inner" id="hero-image">
                  <div class="container">
                <div class="row">
                <p><br></p>
                <div class="col-sm-12">
                   <div class="col-md-5 col-xs-12">
                     
         <div class="containe">
            <div class="row">
                <div class="board">
                    <div class="board-inner">
                    <ul class="nav nav-tabs1" id="myTab">
                      <div class="liner"></div>
                      <li class="active">
                      <a href="#doner" data-toggle="tab" title="Spare Parts">
                      <span class="round-tabs1 five1">
                      <i class="fa fa-wrench"></i>
                      </span> 
                      </a>
                      </li>
                      
                      <li><a href="#messages" data-toggle="tab" title="Service Center">
                      <span class="round-tabs1 three1">
                      <i class="fa fa-cogs"></i>
                      </span>
                      </a></li>

                      <li><a href="#home" data-toggle="tab" title="New Bikes">
                      <span class="round-tabs1 one1">
                       <span style="font-size:21px; font-weight: 500; font-family: sans-serif;">NEW</span>
                      <!-- <i class="fa fa-motorcycle"></i> -->
                      </span> 
                      </a></li>
                     
                      <li><a href="#profile" data-toggle="tab" title="Used Cars">
                      <span class="round-tabs1 two1">
                      <span style="font-size:20px; font-weight: 500; font-family: sans-serif;">USED</span>
                     <!--  <i class="fa fa-car"></i> -->
                      </span> 
                      </a></li>
                      
                     </ul>
                     </div>

                     <div class="tab-content">
                     
                         <!--================== new SpareParts section ===================-->
                                    <div class="tab-pane fade in active" id="doner">
                                            <p class="car1">Search spare parts </p>
                                            <form autocomplete="off" action="./SearchHSpareParts" method="post">
                                             <div class="col-xs-12 col-sm-9 col-md-12">
                                              <div class="row panel-margin">
                                                 
                                               <div class="col-md-6 col-sm-6 col-xsm-12 hidden-sm panel-padding form-group">
	                                           <label class="lable1">Vehicle Type</label>
	                                           <div class="select-filters">
	                                           <select class="form-control" name="vehicleType" id="spBrand" onchange="getVehicleBrand(this.value)" required>
											   <option value="" style="display: none;">Vehicle Type</option>
											   <option value="2,">Two Wheeler</option>
											   <option value="4,">Four Wheeler(Light Vehicle)</option>
											   </select>
	                                           </div>
	                                           </div>
                                                 
                                                 <input type="hidden" value="SELECT" name="subCategory" required>
                                                 
                                                  <div class="col-md-6 col-sm-6 col-xsm-12 hidden-sm panel-padding form-group">
                                                  <label class="lable1">Brand</label>
                                                  <div class="select-filters" id="txtHint10">
                                                  <select name="vehicleBrand" class="form-control" id="vehicleBrand" required>
                                                  <option value="SELECT" style="display:none;">Vehicle Brand</option>
                                                  </select>
                                                  </div>
                                                  </div>
                                                    
                                                  <div class="col-md-6 col-sm-6 col-xsm-12 hidden-sm panel-padding form-group">
                                                  <label class="lable1">Model</label>
                                                  <div class="select-filters" id="txtHint11">
                                                  <select name="vehicleModel" class="form-control" id="vehicleModel" required>
                                                  <option value="SELECT" style="display:none;">Vehicle Model</option>
                                                  </select>
                                                  </div>
                                                  </div>
                                                    
                                                  <%
                                                  GetSparePartsDetails spd = new GetSparePartsDetails();
                                                  ArrayList<SpareParts> spC= spd.getCategory();
                                                  Iterator itspc = spC.iterator();
                                                  %>
                                                    
                                                <%--   <div class="col-xs-12 col-sm-6 col-md-6 hidden-sm panel-padding form-group">
                                                  <label class="lable1">Variant</label>
                                                  <div  class="select-filters">
										          <select name="category" class="form-control" id="category" required>
										          <option value="SELECT" style="display:none;">Variant Name</option>
										          <option value="All">All</option>
										          <%
                                                   while(itspc.hasNext()){
                                                   SpareParts category = (SpareParts)itspc.next();
                                                   %>
                                                   <option value="<%=category.getCATEGORY()%>"><%=category.getCATEGORY()%></option>
                                                   <%} %>
                								   </select>
                									
                                                    </div>
                                                    </div> --%>
                                                
                                                    <%
                                                    ArrayList<BusinessOwnerRegister> spdAl = spd.getCity();
                                                    Iterator itsp = spdAl.iterator();
                                                    
                                                    StringBuffer sb = new StringBuffer();
                									sb.append("[");
                									for(int i=0;i<spdAl.size();i++)
                									{
                										BusinessOwnerRegister bocity = (BusinessOwnerRegister) spdAl.get(i);
                										sb.append("\"").append(bocity.getB_CITY()).append("\"");
                							            if (i + 1 < spdAl.size()) {
                							                sb.append(",");
                							            }
                									}
                									sb.append("]");
                							        bocities = sb.toString();
                                                    %>
                                                
                                                     <%-- <div class="col-md-6 col-sm-6 col-xsm-12 hidden-sm panel-padding form-group">
                                                     <label class="lable1">City</label>
                                                     <!-- filters select -->
                                                     <div  class="select-filters">
                                                     <select name="city" class="form-control" id="city" required>
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
                                                     </div> --%>
                                                     
                                                     <div class="col-md-6 col-sm-6 col-xsm-12 hidden-sm panel-padding form-group">
                                                     <label class="lable1">Make Year</label>
                                                     <div class="select-filters">
										             <div class="autocomplete">
													 <input id="myInput" type="text" name="city" placeholder="Make Year" style=" border: 1px solid #fff; margin: 3px 0;">
                                                     </div>
                                                     </div>
                                                     </div>
                                                     
                                                     
                                                <div class="col-xs-12 col-sm-12 col-md-12 hidden-sm panel-padding form-group">
												<div class="col-xs-12 col-sm-6 col-md-4 hidden-sm panel-padding form-group"></div>
												<div class="col-xs-12 col-sm-6 col-md-4 hidden-sm panel-padding form-group">
                                                <button type="submit" class="btn btn-danger btn-block">Search</button>
                                                </div>
                                                <div class="col-xs-12 col-sm-6 col-md-4 hidden-sm panel-padding form-group"></div>
												</div>
                                                </div>
                                            </div>
                                           
                                            </form>
                                          </div>
                      <!--======================= end SpareParts center section ===================-->
                      
                             <!--=================== new service center section ====================-->
                                <div class="tab-pane fade" id="messages">
                                           <p class="car1">Search service center </p>
                                          <form action="./SearchHMechanic" method="post">
                                               <div class="col-xs-12 col-sm-12 col-md-12">
                                               <div class="row panel-margin">
                                          
                                                   <div class="col-xs-12 col-sm-6 col-md-6 hidden-sm panel-padding form-group">
                                                  <label class="lable1">City</label>
                                                 <div  class="select-filters">
                                                 <select name="city" class="form-control" id="city" onchange="showServiceStreet(this.value)" required>
                                                 <option value="SELECT" style="display:none;">City</option>
                                                 <option value="All">All</option>
                                                 <%
                                                 GetMechanicDetails mdetails=new GetMechanicDetails();
                                                 ArrayList<BusinessOwnerRegister> city=mdetails.getCity();
                                                 ArrayList<ServiceMechanic> vehicaleType=mdetails.getVehicleType();
                                                 Iterator typeit=vehicaleType.iterator();
                                                 Iterator it= city.iterator();
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
                                                 
                                                   <div class="col-xs-12 col-sm-6 col-md-6 hidden-sm panel-padding form-group">
                                                    <label class="lable1">Location</label>
                                                    <div  class="select-filters" id="txtHint6">
                                                    <select name="street" class="form-control" id="street" required>
													<option value="SELECT" style="display:none;">Location</option>
												    </select>
                                                    </div>
                                                    </div>
                                                    
                                                    <div class="col-md-6 col-sm-6 col-xsm-12 hidden-sm panel-padding form-group">
                                                      <label class="lable1">Vehicle Type</label>
                                                    <div  class="select-filters">
                                                     <select name="vehicleType" class="form-control" id="vBrand" onchange="showVehicleBrand(this.value)" >
                                                     <option value="SELECT" style="display:none;">Vehicle Type</option>
                                                     <option value="4,2,">All</option>
                                                     <option value="2,">Two Wheeler</option>
                                                     <option value="4,">Four Wheeler</option>
                                                     </select>
                                                     </div>
                                                    </div>
                                                    
                                                     <div class="col-md-6 col-sm-6 col-xsm-12 hidden-sm panel-padding form-group">
                                                      <label class="lable1">Vehicle Brand</label>
                                                     <div  class="select-filters" id="txtHint3">
                                                     <select name="vehicleBrand" class="form-control" required> 
                                                     <option value="SELECT" style="display:none;">Vehicle Brand</option>
                                                     </select>
                                                     </div>
                                                    </div>
                                                    
                                                <div class="col-xs-12 col-sm-12 col-md-12 hidden-sm panel-padding form-group">
												<div class="col-xs-12 col-sm-6 col-md-4 hidden-sm panel-padding form-group"></div>
												<div class="col-xs-12 col-sm-6 col-md-4 hidden-sm panel-padding form-group">
                                                <button type="submit" class="btn btn-danger btn-block">Search</button>
                                                </div>
                                                <div class="col-xs-12 col-sm-6 col-md-4 hidden-sm panel-padding"></div>
												</div>
                                                </div>
                                              </div>
                                          
                                            </form>
                      </div>
                      <!--=================== end new service center section ================-->
                      
                     <!--==================== new car section ==================-->
                      <div class="tab-pane fade" id="home">
                          <p class="car1">Search new vehicles </p>
                             <form action="./SearchNewVehicle" method="post">
                                   <div class="col-md-12 col-sm-12 col-xs-12">
                                   <div class="row panel-margin">
	                                           <div class="col-md-6 col-sm-6 col-xsm-12 hidden-sm panel-padding form-group">
	                                           <label class="lable1">Vehicle Type</label>
	                                           <div class="select-filters">
	                                           <select class="form-control" name="vType" id="vType" onchange="getNewVcleBrand(this.value)" required>
											   <option value="" style="display: none;">Vehicle Type</option>
											   <option value="2,">Two Wheeler</option>
											   <option value="4,">Four Wheeler(Light Vehicle)</option>
											   </select>
	                                           </div>
	                                           </div>
	                                           
	                                           <div class="col-md-6 col-sm-6 col-xsm-12 hidden-sm panel-padding form-group">
	                                           <label class="lable1">Vehicle Brand</label>
	                                           <div class="select-filters" id="txtHint20">
	                                           <select name="vehicleBrand" class="form-control">
	                                           <option value="SELECT" style="display:none;">Vehicle Brand</option>
	                                           </select>
	                                           </div>
	                                           </div>
	                                           
	                                           <div class="col-md-6 col-sm-6 col-xsm-12 hidden-sm panel-padding form-group">
	                                           <label class="lable1">Vehicle Model</label>
	                                           <div  class="select-filters" id="txtHintD">
	                                            <select name="vehicleModel" class="form-control" >
	                                            <option value="SELECT" style="display:none;">Vehicle Model</option>
	                                            </select>
	                                            </div>
	                                            </div>
	                                            
	                                             <div class="col-md-6 col-sm-6 col-xsm-12 hidden-sm panel-padding form-group">
	                                           <label class="lable1">Make Year </label>
	                                           <div  class="select-filters">
	                                            <select name="makeYear" class="form-control">
	                                            <%
	                                            Date today = new Date();
	                                            Calendar cal = Calendar.getInstance();
	                                            cal.setTime(today);
	                                            int currentyear = cal.get(Calendar.YEAR);
	                                            int previous =currentyear-1;
	                                            %>
	                                            <option value="SELECT" style="display:none;">Make Year</option>
	                                            <option value="<%=currentyear%>">Current Year</option>
	                                            <option value="<%=previous%>">Previous Year</option>
	                                            </select>
	                                            <input type="hidden" name="vvariant" value="SELECT">
	                                            <input type="hidden" name="spage" value="home">
	                                            <input type="hidden" name="bodyType" value="SELECT">
	                                            <input type="hidden" name="fuelType" value="SELECT">
	                                            <input type="hidden" name="transmission" value="SELECT">
	                                            <input type="hidden" name="color" value="SELECT">
	                                            <input type="hidden" name="budget" value="SELECT">
	                                            
	                                            </div>
	                                            </div>
	          
	                                             <div class="col-md-6 col-sm-6 col-xsm-12 hidden-sm panel-padding form-group"></div>
	                                           
												<div class="col-xs-12 col-sm-12 col-md-12 hidden-sm panel-padding form-group" id="">
												<div class="col-xs-12 col-sm-6 col-md-4 hidden-sm panel-padding form-group"></div>
												<div class="col-xs-12 col-sm-6 col-md-4 hidden-sm panel-padding form-group">
                                                <button type="submit" class="btn btn-danger btn-block">Search</button>
                                                </div>
                                                <div class="col-xs-12 col-sm-6 col-md-4 hidden-sm panel-padding form-group"></div>
												</div>
                                               
                                                   
                                                </div>
                                            </div>
                                            </form>
                            </div>
                        <!--================ end new car section ==================-->
                        
                        <!--==================== new bike section ==================-->
                      <div class="tab-pane fade" id="profile">
                                <p class="car1">Search used vehicles</p>
                                <form action="./SearchHUsedVehicle" method="post">
                                            <div class="col-xs-12 col-sm-12 col-md-12">
                                             <div class="row panel-margin">
                                                <div class="col-xs-12 col-sm-6 col-md-6 hidden-sm panel-padding form-group">
                                                  <label class="lable1">Vehicle Type</label>
                                                 <div  class="select-filters">
                                                 <select name="vType" class="l" id="vBrand" onchange="getUsedVcleBrand(this.value)" required>
                                                 <option value="" style="display:none;">Vehicle Type</option>
                                                 <option value="2,">Two Wheeler</option>
                                                 <option value="4,">Four Wheeler</option>
                                                 </select>
                                                 </div>
                                                 </div>
                                                 
                                                <div class="col-xs-12 col-sm-6 col-md-6 hidden-sm panel-padding form-group" >
                                                 <label class="lable1">Brand</label>
                                                <div  class="select-filters" id="txtHint2">
                                                <select name="vehicleBrand" class="" id="vModel">
                                                <option value="SELECT" style="display:none;">Select Brand</option>
                                                </select>
                                                </div>
                                                </div>
                                                
                                               <div class="col-xs-12 col-sm-6 col-md-6 hidden-sm panel-padding form-group">
                                               <label class="lable1">Model</label>
                                               <div  class="select-filters" id="txtHintH" >
                                               <select name="vehicleModel" class="form-control" >
                                               <option value="SELECT" style="display:none;">Select Model</option>
                                               <option value="Any">Any</option>
                                               </select>
                                               
                                               </div>
                                               </div>
                                                <%
                                               	GetUsedVehicleDetails city2 = new GetUsedVehicleDetails();
                                                Set<String> vCity = city2.getVehicleCity();
                                               	Iterator itr1 = vCity.iterator();
                                                %>
                                                
                                                <div class="col-xs-12 col-sm-6 col-md-6 hidden-sm panel-padding form-group">
                                                <label class="lable1">City</label>
                                                <div  class="select-filters">
                                                <select name="city" class="form-control">
                                                <option value="SELECT" style="display:none;">Select City</option>
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
                                                       <input type="hidden" name="vVariant" value="SELECT">     
                                                  </div>
                                                    </div>
                                                <div class="col-xs-12 col-sm-12 col-md-12 hidden-sm panel-padding form-group">
												<div class="col-xs-12 col-sm-6 col-md-4 hidden-sm panel-padding form-group"></div>
												<div class="col-xs-12 col-sm-6 col-md-4 hidden-sm panel-padding form-group">
                                                <button type="submit" class="btn btn-danger btn-block">Search</button>
                                                </div>
                                                <div class="col-xs-12 col-sm-6 col-md-4 hidden-sm panel-padding form-group"></div>
												</div>
                                                </div>
                                            </div>
                                            </form>
                                </div>
                      
                      <!--=================== end new bike section =================-->
                      <div class="clearfix"></div>
				</div>
				
				</div>
				</div>
				</div>
                </div> 
         <!--================================= new section ============================================-->
                   <div class="col-md-7 col-xs-12">
                   <div class="col-md-12 col-xs-12" style=" text-align: center;"> 
                  
                   <span class="in1">Coming soon................</span>
                   
                   <h1 class="ml6" style="float: left;">
                   <span class="text-wrapper">
                   <span class="letters">Spare parts shop  kandukuru</span>
                   </span>
                   </h1>
                   
                   <h1 class="ml6" style="float: right;">
                   <span class="text-wrapper">
                   <span class="letters">Available two and three wheeler spare parts</span>
                   </span>
                   </h1>
                   
                   <h1 class="ml6" style="float: left;">
                   <span class="text-wrapper">
                   <span class="letters">Kandukuru Prakasam dist AP</span>
                   </span>
                   </h1>
                   
                   <h1 class="ml6" style="float: right;">
                   <span class="text-wrapper">
                   <span class="letters">Super discounts on spare parts</span>
                   </span>
                   </h1>

                   </div>
                   </div>
                   
            <!--=================================== new section ======================================-->
                </div>
                </div>
                </div>
                  <p><br></p>
               </div>
            <!--===================== new section ========================-->
                 <p></p>
              
                 <div class="container boking-inner">
                 <dtiv class="row">
                    <div class="col-sm-12">
                        <div class="panel" >  <!-- style="z-index: -1;" -->
                               <div class="panel-heading">
                               <ul class="nav nav-tabs">
                                 <li align="center" class="active col-md-2 col-sm-6 col-xs-12" id="p-well"><a id="show" href="#tab5default5" data-toggle="tab"><i class="fa fa-wrench"></i> Spare Parts</a></li>
                                 <li align="center" class="col-md-2 col-sm-6 col-xs-12" id="p-well" ><a id="hide" href="#tab3default3" data-toggle="tab"><i class="fa fa-cogs"></i> Service Center</a></li>
                                 <li align="center" class="col-md-2 col-sm-6 col-xs-12" id="p-well"><a href="#tab2default2" data-toggle="tab"><i class="fa fa-motorcycle"></i> New Bikes</a></li>
                                 <li align="center" class="col-md-2 col-sm-6 col-xs-12" id="p-well"><a href="#tab1default1" data-toggle="tab"><i class="fa fa-car"></i> New Cars </a></li>
                                </ul>
                                </div>
                            
                                <div class="panel-body" >
                                <div class="tab-content">
                                          <div class="tab-pane fade" id="tab1default1" style="padding-top: 4px;">
                                          <iframe class="embed-responsive-item col-md-12 col-sm-12 col-xs-12 media" marginheight="50" frameBorder="0"  src="car.html" width="100%" height="280px" scrolling="no" style="padding: 0 0;">
                                          </iframe>
                                          </div>
                                    
                                          <div class="tab-pane fade" id="tab2default2" style="padding-top: 4px;">
                                          <iframe frameBorder="0" class="col-md-12 col-sm-12 col-xs-12" src="bike.html" width="100%" height="280px" scrolling="no" style="padding: 0 0;">
                                          </iframe>                               
                                          </div>
                                               
                                         <!--  <div class="tab-pane fade" id="tab4default4" style="padding-top: 4px;">
                                          <iframe class="col-md-12 col-sm-12 col-xs-12 media" marginheight="50" frameBorder="0"  src="car.html" width="100%" height="310px" scrolling="no" style="padding: 0 0;">
                                          </iframe>
                                          </div> -->
                                         
                                          <div class="tab-pane fade" id="tab3default3" style="padding-top: 4px;">
                                          <iframe frameBorder="0" class="col-md-12 col-sm-12 col-xs-12" src="service1.html" width="100%" height="270px" scrolling="no" style="padding: 0 0;">
                                          </iframe>
                                          </div>
                               
                                          <div class="tab-pane fade in active" id="tab5default5" style="padding-top:8px;">
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
            <!--================== end new section =================== -->
    
            <section class="service-inner">
                <div class="container ">
                    <div class="row bg-success" style="height: 37px;margin: 0px 28px 0px 10px; border: 1px solid #fff; border-radius: 5px;">
                        <div class="col-md-6 col-md-offset-3">
                            <div class="title">
                                <h2 style="margin: 0 0;">Our Service</h2>
                                
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
                                        Vaahanmitra.com - one of the most trusted automobile portals in the country provides very useful information on buying new cars. It also contains useful information related to spare parts and vehicles service,insurance
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
                                        Vaahanmitra.com - one of the most trusted automobile portals in the country provides very useful information on buying new Bikes. It also contains useful information related to, spare parts and vehicles service, insurance
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
               Vaahanmitra.com - one of the most trusted Rely on the industry's largest customer service network for 24/7 product and field support.
                       
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
Vaahanmitra.com - supports the digitalization of your inventory and enable on-demand production and rapid delivery of your spare parts.
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
										 Vaahanmitra.com - will assign you the best matched professional to fulfill your requirements.
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
                    <div class="row bg-success" style="height: 37px;margin: 0px 28px 0px 10px; border: 1px solid #fff; border-radius: 5px;">
                        <div class="col-md-6 col-md-offset-3">
                            <div class="title">
                                <h2 style="margin: 0 0;">Used Cars</h2>
                            </div>
                        </div>
                    </div>
                     <iframe frameBorder="0" class="col-md-12 col-sm-12 col-xs-12" src="used-cars.html" width="100%" height="260px" scrolling="no" style="padding: 0 0;">
                      </iframe>
                    
                   <!--  <div class="row thm-margin">
                        <div id="blog-slide" class="owl-carousel">
                            blog post item
                            <div class="item">
                                <div class="blog-content">
                                    <div class="blog-img image-hover f">
                                        <a href="#"><img src="assets/images/c1.jpg" class="img-responsive" alt=""></a>
                                        <span class="post-date">14 November 2016</span>
                                        <div class="overlay">
                                        <div class="text" style=" background: #9a2220; padding: 4px 12px 4px 12px; border: 2px solid #dff0d8; border-radius: 3px;">14 November 2016</div>
                                        </div>
                                    </div>
                                   
                                </div>
                            </div>
                            blog post item
                            <div class="item">
                                <div class="blog-content">
                                    <div class="blog-img image-hover f">
                                        <a href="#"><img src="assets/images/c2.jpg" class="img-responsive" alt=""></a>
                                    </div>
                                   
                                </div>
                            </div>
                            blog post item
                            <div class="item">
                                <div class="blog-content">
                                    <div class="blog-img image-hover f">
                                        <a href="#"><img src="assets/images/c5.jpg" class="img-responsive" alt=""></a>
                                        <span class="post-date">14 November 2016</span>
                                        <div class="overlay">
                                               <div class="text" style=" background: #9a2220; padding: 4px 12px 4px 12px; border: 2px solid #dff0d8; border-radius: 3px;">14 November 2016</div>
                                                    </div>
                                    </div>
                                    <h4><a href="#">It is a long established fact that</a></h4>
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                </div>
                            </div>
                            blog post item
                            <div class="item">
                                <div class="blog-content">
                                    <div class="blog-img image-hover f">
                                        <a href="#"><img src="assets/images/c6.jpg" class="img-responsive" alt=""></a>
                                        <span class="post-date">14 November 2016</span>
                                        <div class="overlay">
                                               <div class="text" style=" background: #9a2220; padding: 4px 12px 4px 12px; border: 2px solid #dff0d8; border-radius: 3px;">14 November 2016</div>
                                                    </div>
                                    </div>
                                  
                                </div>
                            </div>
                            blog post item
                            <div class="item">
                                <div class="blog-content">
                                    <div class="blog-img image-hover f">
                                        <a href="#"><img src="assets/images/c3.jpg" class="img-responsive" alt=""></a>
                                        <span class="post-date">14 November 2016</span>
                                        <div class="overlay">
                                               <div class="text" style=" background: #9a2220; padding: 4px 12px 4px 12px; border: 2px solid #dff0d8; border-radius: 3px;">14 November 2016</div>
                                                    </div>
                                    </div>
                                    <h4><a href="#">It is a long established fact that</a></h4>
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                </div>
                            </div>
                        </div>
                    </div> -->
                </div>
            </section>
            <section class="container">
                
                   <div class="row bg-success" style="height: 37px;margin: 0px 28px 0px 10px; border: 1px solid #fff; border-radius: 5px;">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="title">
                                <h2 style="margin: 0 0;">Service center</h2>
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
		xmlhttp.open("GET", "./getADNewHVecleModel.jsp?vBrand="+str+ "&vType="+ vType, true);
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
 /~~~~~~~~~~~~ tooltip~~~~~~~~~~ /
 $(document).ready(function(){
 $('[data-toggle="tab"]').tooltip();
 
 });
 </script>
 <script type="text/javascript">

 document.getElementById('index').className = 'active';

 </script>
      <script>
	var start = 2017;
var end = new Date().getFullYear();
var options = "";
for(var year = start ; year <=end; year++){
  options += "<option>"+ year +"</option>";
}
document.getElementById("makeYear").innerHTML = options;
</script> 
        
       <!--  <script type="text/javascript">
        $(".uc").css("position", "relative","top","-15","left","20%");

        </script> -->
     <script>
  // Wrap every letter in a span
     $('.ml6 .letters').each(function(){
       $(this).html($(this).text().replace(/([^\x00-\x80]|\w)/g, "<span class='letter'>$&</span>"));
     });

     anime.timeline({loop: true})
       .add({
         targets: '.ml6 .letter',
         translateY: ["1.1em", 0],
         translateZ: 0,
         duration: 750,
         delay: function(el, i) {
           return 50 * i;
         }
       }).add({
         targets: '.ml6',
         opacity: 0,
         duration: 1000,
         easing: "easeOutExpo",
         delay: 1000
       });
        </script>
        
<script>
function autocomplete(inp, arr) {
  /*the autocomplete function takes two arguments,
  the text field element and an array of possible autocompleted values:*/
  var currentFocus;
  /*execute a function when someone writes in the text field:*/
  inp.addEventListener("input", function(e) {
      var a, b, i, val = this.value;
      /*close any already open lists of autocompleted values*/
      closeAllLists();
      if (!val) { return false;}
      currentFocus = -1;
      /*create a DIV element that will contain the items (values):*/
      a = document.createElement("DIV");
      a.setAttribute("id", this.id + "autocomplete-list");
      a.setAttribute("class", "autocomplete-items");
      /*append the DIV element as a child of the autocomplete container:*/
      this.parentNode.appendChild(a);
      /*for each item in the array...*/
      for (i = 0; i < arr.length; i++) {
        /*check if the item starts with the same letters as the text field value:*/
        if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
          /*create a DIV element for each matching element:*/
          b = document.createElement("DIV");
          /*make the matching letters bold:*/
          b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
          b.innerHTML += arr[i].substr(val.length);
          /*insert a input field that will hold the current array item's value:*/
          b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
          /*execute a function when someone clicks on the item value (DIV element):*/
          b.addEventListener("click", function(e) {
              /*insert the value for the autocomplete text field:*/
              inp.value = this.getElementsByTagName("input")[0].value;
              /*close the list of autocompleted values,
              (or any other open lists of autocompleted values:*/
              closeAllLists();
          });
          a.appendChild(b);
        }
      }
  });
  /*execute a function presses a key on the keyboard:*/
  inp.addEventListener("keydown", function(e) {
      var x = document.getElementById(this.id + "autocomplete-list");
      if (x) x = x.getElementsByTagName("div");
      if (e.keyCode == 40) {
        /*If the arrow DOWN key is pressed,
        increase the currentFocus variable:*/
        currentFocus++;
        /*and and make the current item more visible:*/
        addActive(x);
      } else if (e.keyCode == 38) { //up
        /*If the arrow UP key is pressed,
        decrease the currentFocus variable:*/
        currentFocus--;
        /*and and make the current item more visible:*/
        addActive(x);
      } else if (e.keyCode == 13) {
        /*If the ENTER key is pressed, prevent the form from being submitted,*/
        e.preventDefault();
        if (currentFocus > -1) {
          /*and simulate a click on the "active" item:*/
          if (x) x[currentFocus].click();
        }
      }
  });
  function addActive(x) {
    /*a function to classify an item as "active":*/
    if (!x) return false;
    /*start by removing the "active" class on all items:*/
    removeActive(x);
    if (currentFocus >= x.length) currentFocus = 0;
    if (currentFocus < 0) currentFocus = (x.length - 1);
    /*add class "autocomplete-active":*/
    x[currentFocus].classList.add("autocomplete-active");
  }
  function removeActive(x) {
    /*a function to remove the "active" class from all autocomplete items:*/
    for (var i = 0; i < x.length; i++) {
      x[i].classList.remove("autocomplete-active");
    }
  }
  function closeAllLists(elmnt) {
    /*close all autocomplete lists in the document,
    except the one passed as an argument:*/
    var x = document.getElementsByClassName("autocomplete-items");
    for (var i = 0; i < x.length; i++) {
      if (elmnt != x[i] && elmnt != inp) {
        x[i].parentNode.removeChild(x[i]);
      }
    }
  }
  /*execute a function when someone clicks in the document:*/
  document.addEventListener("click", function (e) {
      closeAllLists(e.target);
  });
}

/*An array containing all the country names in the world:*/
var bocities1 =<%=bocities%>;//["Afghanistan","Albania","Algeria","Andorra","Angola","Anguilla","Antigua & Barbuda","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia & Herzegovina","Botswana","Brazil","British Virgin Islands","Brunei","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Cayman Islands","Central Arfrican Republic","Chad","Chile","China","Colombia","Congo","Cook Islands","Costa Rica","Cote D Ivoire","Croatia","Cuba","Curacao","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Falkland Islands","Faroe Islands","Fiji","Finland","France","French Polynesia","French West Indies","Gabon","Gambia","Georgia","Germany","Ghana","Gibraltar","Greece","Greenland","Grenada","Guam","Guatemala","Guernsey","Guinea","Guinea Bissau","Guyana","Haiti","Honduras","Hong Kong","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Isle of Man","Israel","Italy","Jamaica","Japan","Jersey","Jordan","Kazakhstan","Kenya","Kiribati","Kosovo","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macau","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro","Montserrat","Morocco","Mozambique","Myanmar","Namibia","Nauro","Nepal","Netherlands","Netherlands Antilles","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","North Korea","Norway","Oman","Pakistan","Palau","Palestine","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Puerto Rico","Qatar","Reunion","Romania","Russia","Rwanda","Saint Pierre & Miquelon","Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Korea","South Sudan","Spain","Sri Lanka","St Kitts & Nevis","St Lucia","St Vincent","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Timor L'Este","Togo","Tonga","Trinidad & Tobago","Tunisia","Turkey","Turkmenistan","Turks & Caicos","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States of America","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Virgin Islands (US)","Yemen","Zambia","Zimbabwe"];
/*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
autocomplete(document.getElementById("myInput"), bocities1);
</script>
        
    </body>
</html>