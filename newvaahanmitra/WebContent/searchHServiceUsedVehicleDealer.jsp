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
        <title>Vaahanmitra | Search Dealer</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
        <link href="http://www.vaahanmitra.com/searchHServiceUsedVehicleDealer.jsp" rel="canonical" />
        <!-- Base Css -->
        <link href="assets/css/base.css" rel="stylesheet" type="text/css"/>
         <link href="assets/css/modalForm.css" rel="stylesheet" type="text/css"/>
        
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
function toggle_it(itemID){ 
    // Toggle visibility between none and '' 
    if ((document.getElementById(itemID).style.display == 'none')) {
          document.getElementById(itemID).style.display = '' 
          event.preventDefault()
    } else { 
          document.getElementById(itemID).style.display = 'none'; 
          event.preventDefault()
    }    
} 

</script>

<style type="text/css">

.button1 {
    display: block;
    width: 180px;
    height: 40px;
    background: #356e9f;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
}
.content {
    padding: 0px;
    background: #fff;
}
.navbar {
    position: relative;
    min-height: 50px;
    margin-bottom: 0px !important;
    border: 1px solid transparent;
}
</style>

    </head>
    <body>
        <!-- page loader -->
        <div class="se-pre-con"></div>
        <div id="page-content">
            <!-- navber -->
        
                <jsp:include page="./homeTop.jsp"></jsp:include>
          
            <!-- /.nav end -->
          
            <!-- service -->
            
    <%
    int page1=0,noofrecords=0,maxrowsperpage=0;
    try{
    	page1=Integer.parseInt(request.getAttribute("currentPage").toString());
    	maxrowsperpage=Integer.parseInt(request.getAttribute("maxrowsperpage").toString());
    }
    catch(Exception e)
    {
    
    }
    int k=(maxrowsperpage*page1)-maxrowsperpage;
    %>
            
            <section class="service-inner" >
                <div class="container">
              <form action="./SearchHServiceUsedVehicleDealer" method="post">
                    <div class="row top">
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
                 <div>
                   <select name="vehicleType" class="form-control">
                      <option value="SELECT" style="display:none;"><%=((vehicleType1==null?"Vehicle Type":vehicleType1.equals("null")?"Vehicle Type": vehicleType1.equals("2,")?"TWO WHEELER":vehicleType1.equals("4,")?"FOUR WHEELER":vehicleType1.equals("4,2,")?"All":vehicleType1)) %></option>
                       <option value="4,2,">All</option>
                       <option value="2,">TWO WHEELER</option>
                       <option value="4,">FOUR WHEELER</option>
                       

					</select>
                 </div>
                 </div>
                        <div class="col-md-3 col-sm-6 col-xsm-12">
                  <label>City</label>
                       <!-- filters select -->
                 <div>
                   <select name="city" class="form-control" id="dName" onchange="showDealerName(this.value)">
					<option value="SELECT" style="display:none"><%=((city1==null?"city":city1.equals("null")?"city":city1.equals("SELECT")?"city":city1)) %></option>
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
                   <div class="col-md-3 col-sm-6 col-xsm-12">
                
                <label>Dealer Name</label>
                       <!-- filters select -->
                 <div id="txtHint4">
                   <select name="dealerName" class="form-control">
                    <option value="SELECT" style="display:none"><%=((dealerName1==null?"Dealer Name":dealerName1.equals("null")?"Dealer Name":dealerName1.equals("SELECT")?"Dealer Name":dealerName1)) %></option>
                    </select>
                 </div>
                </div>
                 <div class="col-md-2 col-sm-6 col-xsm-12" style="margin-top:24px;">
                <button type="submit" class="btn btn-danger btn-block">Search</button>
                </div>
                </form>
                
                    </div>
                      <%
                    
                ArrayList<BusinessOwnerRegister> dealerDetails=(ArrayList<BusinessOwnerRegister>)request.getAttribute("dealerDetails");
                      if(dealerDetails!=null && dealerDetails.size()>0){
                Iterator itr= dealerDetails.iterator();
                int i=1;
                while(itr.hasNext()){
                	BusinessOwnerRegister bean1=(BusinessOwnerRegister)itr.next();
                	%>
                    <section class="col-lg-9 col-md-10 col-sm-10 col-xsm-10" style="background: #ffffff;box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-radius: 5px;margin-top: 5px;margin-bottom: 0px;padding-bottom:11px;">
                        <div class="col-md-6">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 18px;font-size: 12px;margin-bottom: 5px;">
                        
                        <%if(bean1.getEMAIL_ID()!=null && !bean1.getEMAIL_ID().equals("NA") && !bean1.getVERIFIED().equals("NO")){ %>
                        <%if(vehicleType1!=null && vehicleType1.equals("4,2,")){ %>
  
						  <span style="color:#337ab7;font-weight:600;font-size:15px;"><a href="./DealerWebsite.jsp?name=<%=bean1.getNAME() %>" target="_blank" style="cursor: pointer;"><u><%=bean1.getNAME() %></u></a></span>

                       
                 		<%} else{%>
                 		

						  <span style="color:#337ab7;font-weight:600;font-size:15px;"><a href="./DealerWebsite.jsp?name=<%=bean1.getNAME() %>" target="_blank" style="cursor: pointer;"><u><%=bean1.getNAME() %></u></a></span>

                 		
                 		<%} }else{%>
                 		

						
						 <span style="color:#337ab7;font-weight:600;font-size:15px;"><a href="#" style="cursor: pointer;"><u><abbr title="Not Verified"><%=bean1.getNAME() %></abbr></u></a></span>

						
                 		<%} %>
                 		  </div>
                       <%-- <%if(city1.equals("SELECT")){ %>
                         <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 10px;font-size: 12px;margin-bottom: 5px;"><span style="color:#f94141;font-weight:600;font-size:15px;">VEHICLE TYPE:</span>&nbsp;&nbsp;<span style="font-weight:600;color:#000;font-size:13px;"><%=(vehicleType1.equals("2,"))?"TWO WHEELER":(vehicleType1.equals("4,"))?"FOUR WHEELER":(vehicleType1.equals("4,2,"))?"TWO WHEELER & FOUR WHEELER":"N/A"%></span></div>
                        <% }else{%>  --%>
                     <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 10px;font-size: 12px;margin-bottom: 5px;">
                     
                 <%--     <%if(vehicleType1==null){ %>
                     
                      <span style="color:#f94141;font-weight:600;font-size:15px;">VEHICLE TYPE:</span>&nbsp;&nbsp;<span style="font-weight:600;color:#000;font-size:13px;"><%=(bean1.getVEHICLE_TYPE()==null)?"N/A":bean1.getVEHICLE_TYPE().equals("2,")?"TWO WHEELER":(bean1.getVEHICLE_TYPE().equals("4,"))?"FOUR WHEELER":(bean1.getVEHICLE_TYPE().equals("4,2,"))?"TWO WHEELER AND FOUR WHEELER":"N/A"%></span>
                     
                     
                    <%}else{ %>  --%>
                     
                        <span style="color: #555;font-weight: 600;">Vehicle Type:</span>&nbsp;&nbsp;<span style="text-transform: lowercase;"><%=(bean1.getVEHICLE_TYPE()==null)?"N/A":bean1.getVEHICLE_TYPE().equals("2,")?"TWO WHEELER":(bean1.getVEHICLE_TYPE().equals("4,"))?"FOUR WHEELER":(bean1.getVEHICLE_TYPE().equals(vehicleType1))?"TWO WHEELER AND FOUR WHEELER":vehicleType1.equals("2,")?"TWO WHEELER":vehicleType1.equals("4,")?"FOUR WHEELER":"TWO WHEELER AND FOUR WHEELER" %></span>
                        <%-- <%} %> --%>
                        </div> 
                       <%-- <%} %> --%>
                       <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;"><span style="color: #555;font-weight: 600;">Address:</span>&nbsp;&nbsp;<span style="text-transform: lowercase;"><%=bean1.getADDRESS() %></span></div>
                       
<%--                        <a id="toggle" href="javascript:toggle_it('<%="toggleText"+i %>')"  style="padding:5px;color:#8a6d3b;font-size:15px;"><u><b>For More Details Click Here</b></u></a> --%>
<%--                        <div id="<%="toggleText"+i %>" style="display: none"> --%>
                       <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;"><span style="color: #555;font-weight: 600;">City:</span>&nbsp;&nbsp;<span style="text-transform: lowercase;"><%=bean1.getB_CITY() %></span></div><br><br>
                       <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;"><span style="color: #555;font-weight: 600;">State:</span>&nbsp;&nbsp;<span style="text-transform: lowercase;"><%=bean1.getSTATE() %></span></div>
                       <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;"><span style="color: #555;font-weight: 600;">Email Address:</span>&nbsp;&nbsp;<span style="text-transform: lowercase;"><%=bean1.getEMAIL_ID() %></span></div>
                       <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;"><span style="color: #555;font-weight: 600;">Phone Number:</span>&nbsp;&nbsp;<span style="text-transform: lowercase;"><%=bean1.getMOBILE_NO() %></span></div>
						<div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;"><span style="color: #555;font-weight: 600;">Verified:</span>&nbsp;&nbsp;<span style="text-transform: lowercase;"><%=bean1.getVERIFIED() %></span></div>
<!-- 						</div> -->
                       </div>
                      
                      
                      <%if(bean1.getEMAIL_ID()!=null && !bean1.getEMAIL_ID().equals("NA") && !bean1.getVERIFIED().equals("NO")){ %>
                        <%if(vehicleType1.equals("4,2,")){ %>
                        <div  class="col-md-3">
                        <form id="myfor<%=i %>" method="post" action="./DealerUsedCar">
						  <input type="hidden" name="dealerName" value="<%=bean1.getEMAIL_ID() %>" />
						  <input type="hidden" name="vehicleType" value="<%=bean1.getVEHICLE_TYPE() %>" />
						  <input type="hidden" name="name" value="<%=bean1.getNAME() %>" /> 
						  <span style="position: relative;top: 14px;"><a onclick="document.getElementById('myfor<%=i %>').submit();" class="button1" style="cursor: pointer;">Show Inventory</a><br><br></span>
						</form>
                        </div>
<%--                        <span style="position: relative;top: 14px;font-size: medium;margin: -26px;"><a href="./DealerUsedCar?dealerName=<%=bean1.getEMAIL_ID() %>&vehicleType=<%=bean1.getVEHICLE_TYPE() %>&name=<%=bean1.getNAME() %>" class="thm-btn" style="padding-left: 10px;padding-right: 10px;"><u>Show Inventory</u></a></span> --%>
                      <%} else{%>
                      <div  class="col-md-3">
                       <form id="myfor<%=i %>" method="post" action="./DealerUsedCar">
						  <input type="hidden" name="dealerName" value="<%=bean1.getEMAIL_ID() %>" />
						  <input type="hidden" name="vehicleType" value="<%=vehicleType1.equals("SELECT")?bean1.getVEHICLE_TYPE() :bean1.getVEHICLE_TYPE().equals("4,2,")?vehicleType1:bean1.getVEHICLE_TYPE() %>" />
						  <input type="hidden" name="name" value="<%=bean1.getNAME() %>" /> 
						  <span style="position: relative;top: 14px;"><a onclick="document.getElementById('myfor<%=i %>').submit();" class="button1" style="cursor: pointer;">Show Inventory</a><br><br></span>
						</form>
                      </div>
<%--                       <span style="position: relative;top: 14px;font-size: medium;margin: -26px;"><a href="./DealerUsedCar?dealerName=<%=bean1.getEMAIL_ID() %>&vehicleType=<%=vehicleType1.equals("SELECT")?bean1.getVEHICLE_TYPE() :bean1.getVEHICLE_TYPE().equals("4,2,")?vehicleType1:bean1.getVEHICLE_TYPE() %>&name=<%=bean1.getNAME() %>" class="thm-btn" style="padding-left: 10px;padding-right: 10px;"><u>Show Inventory</u></a></span> --%>
                      
                      <%} }else{%>
                      
<!--                       <span style="position: relative;top: 14px;font-size: medium;margin: -26px;" ><a class="thm-btn" style="padding-left: 10px;padding-right: 10px;"><u>Show Inventory</u></a></span> -->
     
     
     <div  class="col-md-3">
<span style="position: relative;top: 14px;font-size: medium;" >    
 <button onclick="document.getElementById('idr<%=i %>').style.display='block'" class="button1" style="padding-left: 5px;padding-right: 5px;font-size:14px;"><b style="color: #fff;">Show Inventory</b></button><br><br>

  <div id="idr<%=i %>" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:1000px">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('idr<%=i %>').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
      </div>
		It is not verified Dealer if its yours then please verified your email and upload your services
      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('idr<%=i %>').style.display='none'" type="button" class="w3-button w3-red">ok</button>
<!--         <span class="w3-right w3-padding w3-hide-small">Forgot <a href="#">password?</a></span> -->
      </div>
    </div>
  </div>
  </span>               
    </div>                
                     
                      <%} %>
                       <div  class="col-md-3">
                      <span>
                      <%if(bean1.getPHOTO()!=null && !bean1.getPHOTO().equals("null") ){ %>
                      <a href="#" style="cursor: pointer;"><img src="data:image/png;base64,<%=bean1.getPHOTO() %>" alt="No image" class="img-responsive" style="margin-top: 14px;border-radius: 5px;height: 150px;width: 150px;font-size: 36px; font-family: sans-serif;text-align: center;margin-bottom: 3px;"></a>
                      <%}else{ %>
                      <a href="#" style="cursor: pointer;"><img src="./images/ServiceImage.png" alt="No image" class="img-responsive" style="margin-top: 14px;border-radius: 5px;height: 150px;width: 150px;font-size: 36px; font-family: sans-serif;text-align: center;margin-bottom: 3px;""></a>
             			
             			<%} %>
                    </span>
                    </div>
                    </section>
       <%
       i++;}
        %> 
        
            <section class="col-lg-9 col-md-10 col-sm-10 col-xsm-10" style="background: #ffffff;box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-radius: 5px;margin-top: 5px;margin-bottom: 0px;padding-bottom:11px;">

                Pages:&nbsp;
             			<c:forEach begin="1" end="${noOfPages}" var="m">
<%--  				<td style="float: left" ><a href="./SearchHUsedVehicleDealer?page=${m}&dealerName=<%=dealerName1%>&vehicleType=<%=vehicleType1%>&city=<%=city1%>">${m}&nbsp;&nbsp; </a></td> --%>
 						
 						<c:set var="currentPage" value="${currentPage}"></c:set>
             			<c:set var="noOfPages" value="${m}"></c:set>
             			
             			<%
             			Integer currentPage=(Integer)pageContext.getAttribute("currentPage");
             			Integer noOfPages=(Integer)pageContext.getAttribute("noOfPages");
             			if(currentPage.equals(noOfPages)){
             			%>
 				<a href="./SearchHUsedVehicleDealer?page=${m}&dealerName=<%=dealerName1%>&vehicleType=<%=vehicleType1%>&city=<%=city1%>" style="color:#fc6116;"><u>${m}&nbsp;</u></a>
             			<%} else{%>
             			
 				<a href="./SearchHUsedVehicleDealer?page=${m}&dealerName=<%=dealerName1%>&vehicleType=<%=vehicleType1%>&city=<%=city1%>">${m}&nbsp;</a>
 				<%} %>
				
			</c:forEach>
			
			
			</section>
               
        <%}else{if(dealerDetails==null){%>
        <!-- <section class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="height:200px;background: #f5f5f5;border-radius: 5px;margin-top: 10px;margin-bottom: 10px;">
                      <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 10px;font-size: 18px;margin-bottom: 5px;"></div>
                    </section> -->
        
        
        <%}else{ %>
        
          <section class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="height:200px;background: #f5f5f5;border-radius: 5px;margin-top: 10px;margin-bottom: 10px;">
                      <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 10px;font-size: 18px;margin-bottom: 5px;"><span style="font-weight:600;color:red">Data not found.....</span></div>
                    </section>
        
        <%	
        }}
       %>
        <div class="col-md-12 col-xs-12">
            <br>
            </div>
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
<!--                                 <input type="text" class="form-control" placeholder="Enter Your Email" name="q"> -->
                                <div class="input-group-btn">
<!--                                     <button class="btn btn-default" type="submit"><i class="flaticon-paper-plane"></i> Subscribe</button> -->
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
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
        
 
    </body>
</html>