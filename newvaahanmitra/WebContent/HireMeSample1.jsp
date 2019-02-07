<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>search mechanics</title>
        <!-- Base Css -->
        <link href="assets/css/base.css" rel="stylesheet" type="text/css"/>
        
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
function toggle_it(itemID,text){ 
    // Toggle visibility between none and ''
    var text=document.getElementById(text);
    if ((document.getElementById(itemID).style.display == 'none')) {
          document.getElementById(itemID).style.display = ''
          text.innerHTML="-"
          event.preventDefault()
    } else { 
          document.getElementById(itemID).style.display = 'none'; 
          text.innerHTML="+"
          event.preventDefault()
    }    
} 

</script>

    </head>
    <body>
        <!-- page loader -->
        <div class="se-pre-con"></div>
        <div id="page-content">
            <!-- navber -->
            <nav id="mainNav" class="navbar navbar-fixed-top" style="background:#523f6d;">
                <div class="container">
                    <!--Brand and toggle get grouped for better mobile display--> 
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span><i class="fa fa-bars"></i>
                        </button>
                        <a class="navbar-brand" href="index.html">
                           <h2 style="color:#fff;margin-top:0px;font-weight:600;">Vahana<span style="margin-left:2px; color:#fec107;">Mitra</span></h2>
                        </a>
                    </div>
                    <!--Collect the nav links, forms, and other content for toggling--> 
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="./index.jsp">Home</a></li>
                            <li><a href="#">About Us</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true">Services<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="./index.jsp">Home</a></li>
                                    <li><a href="#">About</a></li>
                                    <li><a href="#">Tours</a></li>
                                    <li><a href="#">Tours Details</a></li>
                                    <li><a href="#">Destination</a></li>
                                    <li><a href="#">Destination Details</a></li>
                                    <li class="dropdown-submenu">
                                        <a href="#" tabindex="-1" class="dropdown-toggle" data-toggle="dropdown">Blog</a>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">Blog Grid One</a></li>
                                            <li><a href="#">Blog Grid Two</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            
                            <li><a href="contact.html">Contact Us</a></li>
                            <li><a href="./login3.jsp">Login</a></li>
                            <li><a href="./register.jsp">Registration</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right hidden-sm">
                            <li><a class="nav-btn" href="#"><div class="thm-btn">Let's Talk!</div></a></li>
                        </ul>
                    </div> <!-- /.navbar-collapse --> 
                </div> <!-- /.container --> 
            </nav> 
            <!-- /.nav end -->
          
            <!-- service -->
            
            <section class="service-inner" style="margin-top: 40px; min-height:600px;background-color: #efefef;">
                <div class="container">
              <form action="./SearchHUsedVehicleDealer" method="post">
                    <div class="row" style="margin-top: 28px;">
                     <%
                     String city1=(String)request.getAttribute("city");
                     String vehicleType1=(String)request.getAttribute("vehicleType");
                   
                     String dealerName1=(String)request.getAttribute("dealerName");
                      
                     GetUsedVehicleDealerServices dservice=new GetUsedVehicleDealerServices();
                     ArrayList<BusinessOwnerRegister> dealerAl=dservice.getCity();
                      Iterator it= dealerAl.iterator();
                      %>
                 
                   <div class="col-md-3 col-sm-6 col-xsm-12">
                <label>Vehicle Type</label>
                       <!-- filters select -->
                 <div class="select-filters">
                   <select name="vehicleType" class="form-control">
                      <option value="SELECT" style="display:none;"><%=((vehicleType1.equals("2,")?"TWO WHEELER":vehicleType1.equals("4,")?"FOUR WHEELER":vehicleType1.equals("4,2,")?"All":vehicleType1)) %></option>
                       <option value="4,2,">All</option>
                       <option value="2,">TWO WHEELER</option>
                       <option value="4,">FOUR WHEELER</option>
                       

					</select>
                 </div>
                 </div>
                        <div class="col-md-3 col-sm-6 col-xsm-12">
                  <label>City</label>
                       <!-- filters select -->
                 <div class="select-filters">
                   <select name="city" class="form-control" id="dName" onChange="showDealerName(this.value)">
					<option value="SELECT" style="display:none"><%=((city1==null?"city":city1)) %></option>
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
                   <div class="col-md-3 col-sm-6 col-xsm-12">
                
                <label>Dealer Name</label>
                       <!-- filters select -->
                 <div class="select-filters" id="txtHint4">
                   <select name="dealerName" class="form-control">
                    <option value="SELECT" style="display:none"><%=((dealerName1==null?"Dealer Name":dealerName1)) %></option>
                    </select>
                 </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xsm-12" style="margin-top: 15px;">
                
                <input type="submit" class="thm-btn" value="Search">
                </div>
                </form>
                
                    </div>
                      <%
                      if(vehicleType1.equals("2,")){
                     	 vehicleType1="Two Wheeler";
                      } else if(vehicleType1.equals("4,")){
                     	 vehicleType1="Four Wheeler";
                      }else if(vehicleType1.equals("4,2,")){
                     	 vehicleType1="Two Wheeler & Four Wheeler";
                      }
                ArrayList<BusinessOwnerRegister> dealerDetails=(ArrayList<BusinessOwnerRegister>)request.getAttribute("dealerDetails");
                      System.out.println(dealerDetails);
                      if(dealerDetails.size()>0){
                Iterator itr= dealerDetails.iterator();
                int i=1;
                while(itr.hasNext()){
                	BusinessOwnerRegister bean1=(BusinessOwnerRegister)itr.next();
                	%>
                    <section class="col-lg-9 col-md-10 col-sm-10 col-xsm-10" style="background: #ffffff;box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-radius: 5px;margin-top: 20px;margin-bottom: 0px;padding-bottom:11px;">
                        <div class="col-md-8">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 18px;font-size: 12px;margin-bottom: 5px;"><span style="color:#f94141;font-weight:600;font-size:15px;"></span>&nbsp;&nbsp;<span style="font-weight:600;color:#000;font-size:15px;"><a href="./DealerUsedCar?dealerName=<%=bean1.getEMAIL_ID() %>&vehicleType=<%=bean1.getVEHICLE_TYPE() %>&name=<%=bean1.getNAME() %>"><u><%=bean1.getNAME() %></u></a>&nbsp;&nbsp;Inventory</span></div>
                  <%--      <%if(city1.equals("SELECT")){ %>
                         <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 10px;font-size: 12px;margin-bottom: 5px;"><span style="color:#f94141;font-weight:600;font-size:15px;">VEHICLE TYPE:</span>&nbsp;&nbsp;<span style="font-weight:600;color:#000;font-size:13px;"><%=(vehicleType1.equals("2,"))?"TWO WHEELER":(vehicleType1.equals("4,"))?"FOUR WHEELER":(vehicleType1.equals("4,2,"))?"TWO WHEELER & FOUR WHEELER":"N/A"%></span></div>
                        <% }else{%> --%>
                         <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 10px;font-size: 12px;margin-bottom: 5px;"><span style="color:#f94141;font-weight:600;font-size:15px;">VEHICLE TYPE:</span>&nbsp;&nbsp;<span style="font-weight:600;color:#000;font-size:13px;"><%=(bean1.getVEHICLE_TYPE()==null)?"N/A":bean1.getVEHICLE_TYPE().equals("2,")?"TWO WHEELER":(bean1.getVEHICLE_TYPE().equals("4,"))?"FOUR WHEELER":(bean1.getVEHICLE_TYPE().equals(vehicleType1))?"TWO WHEELER & FOUR WHEELER":vehicleType1 %></span></div> 
                       <%-- <%} %> --%>
                       <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 10px;font-size: 12px;margin-bottom: 5px;"><span style="color:#f94141;font-weight:600;font-size:15px;">ADDRESS:</span>&nbsp;&nbsp;<span style="font-weight:600;color:#000;font-size:13px;"><%=bean1.getADDRESS() %></span></div>
                       <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 10px;font-size: 12px;margin-bottom: 5px;"><span style="color:#f94141;font-weight:600;font-size:15px;">CITY:</span>&nbsp;&nbsp;<span style="font-weight:600;color:#000;font-size:13px;"><%=bean1.getB_CITY() %></span></div>
                       <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 10px;font-size: 12px;margin-bottom: 5px;"><span style="color:#f94141;font-weight:600;font-size:15px;">STATE:</span>&nbsp;&nbsp;<span style="font-weight:600;color:#000;font-size:13px;"><%=bean1.getSTATE() %></span></div>

                       </div>
                      
                      <div  class="col-md-4"><div>
                      <%if(bean1.getPHOTO()!=null){ %>
                      <a href="#" style="cursor: pointer;"><img src="data:image/png;base64,<%=bean1.getPHOTO() %>" alt="No image" class="img-responsive" style="margin-top: 13px;border-radius: 5px;height: 150px;width: 150px;margin-left: 100px;font-size: 36px; font-family: sans-serif; background: #000;text-align: center;margin-bottom: 3px;"></a>
                      <%}else{ %>
                      <a href="#" style="cursor: pointer;"><img src="./images/ServiceImage.png" alt="No image" class="img-responsive" style="margin-top: 13px;border-radius: 5px;height: 150px;width: 150px;margin-left: 100px;font-size: 36px; font-family: sans-serif; background: #000;text-align: center;margin-bottom: 3px;""></a>
             			
             			<%} %>
                      </div></div>
                    
                    </section>
       <%
       i++;}
        }else{%>
        <section class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="height:200px;background: #f5f5f5;border-radius: 5px;margin-top: 10px;margin-bottom: 10px;">
                      <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 10px;font-size: 18px;margin-bottom: 5px;"><span style="font-weight:600;color:red">Data not found.....</span></div>
                    </section>
        
        <%	
        }
       %>
       </section>
                </div>
            
            <!-- blog section -->
            
            <!-- Newsletter -->
            <section class="get-offer">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-5">
                            <span>Subscribe to our Newsletter</span>
                            <h2>& Discover the best offers!</h2>
                        </div>
                        <div class="col-sm-7">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Enter Your Email" name="q">
                                <div class="input-group-btn">
                                    <button class="btn btn-default" type="submit"><i class="flaticon-paper-plane"></i> Subscribe</button>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </section>
        </div>
        <!-- Footer Section -->
        <footer>
            <div class="container">
                <div class="row">
                    <!-- Address -->
                    <div class="col-sm-4 col-md-3">
                        <div class="footer-box address-inner">
                            <h4 style="color:#fff;">Vahana Mitra</h4>
                            <div class="address">
                                <i class="flaticon-placeholder"></i>
                                <p>Unit - 602, Level 6,<br>
                                    Manjeera Majestic Commercial,<br>
                                   Hi-Tech City Road,KPHB,<br>
                                    Hyderabad - 500072<br>
                                    Telangana<br>
                                    India
                                </p>
                            </div>
                            <div class="address">
                                <i class="flaticon-customer-service"></i>
                                <p>040 - 40191909</p>
                            </div>
                            <div class="address">
                                <i class="flaticon-mail"></i>
                                <p>info@vahanamitra.com</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-8 col-md-6">
                        <div class="row">
                            <div class="col-md-4 col-sm-4">
                                <div class="footer-box">
                                    <h4 class="footer-title">Information</h4>
                                    <ul class="categoty">
                                        
                                        <li><a href="#">About us</a></li>
                                        <li><a href="#">Online Enquiry</a></li>
                                        <li><a href="#">Call us</a></li>
                                        <li><a href="#">Terms and Conditions</a></li>
                                        <li><a href="#">Privacy & Cookies Policy</a></li>
                                        <li><a href="#">Become a partner</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-4">
                                <div class="footer-box">
                                    <h4 class="footer-title">Our Parteners</h4>
                                    <ul class="categoty">
                                        <li><a href="#">Campusguide.in</a></li>
                                        <li><a href="#">Rythumitra.in</a></li>
                                        <li><a href="#">Frytemate.com</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            <div class="sub-footer">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-5">
                            <p>Copyright © 2017. All rights reserved</p>
                        </div>
                        <div class="col-sm-7">
                            <div class="footer-menu">
                                <ul>
                                    <li><a href="#">Home</a></li>
                                    <li><a href="#">About</a></li>
                                    <li><a href="#">Service</a></li>
                                    <li><a href="#">Blog</a></li>
                                    <li><a href="#">Shop</a></li>
                                    <li><a href="#">Forum</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
    </body>
</html>