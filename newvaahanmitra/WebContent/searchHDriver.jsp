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
        <title>Vaahanmitra | Search Driver</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
        <!-- Base Css -->
        <link href="assets/css/base.css" rel="stylesheet" type="text/css"/>
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

<script type="text/javascript">
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
</script>

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

	</script>
	
		<style>
	 :required:focus {
	   box-shadow: 0  0 6px rgba(255,0,0,0.5);
	   border: 1px red solid;
	   outline: 0;
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
            
            
            <section class="service-inner">
                <div class="container">
              <form action="./SearchHDriver" method="post" onsubmit="return validateForm()">
              <%
              
              	String state=(String)request.getAttribute("state");
         		String dist=(String)request.getAttribute("dist");
         		String permitType=(String)request.getAttribute("permitType");
         		String range=(String)request.getAttribute("range");
         		String licenseType=(String)request.getAttribute("licenseType");
              
              %>
   				 <div class="row top">
   				<div class="col-md-2 col-sm-6 col-xsm-10" id="top1">
   				<div class="select-filters">
				<jsp:include page="./state1.jsp" ></jsp:include>
				</div>
   				</div>
   				<div class="col-md-2 col-sm-6 col-xsm-10" id="top1">
   				<div class="select-filters">
                <div class="section_room" id="txtHint5">
				<select id="country" name="" onchange="change_country(this.value)" class="form-control">
				<option value="<%=((dist==null?"SELECT":dist.equals("null")?"SELECT":dist)) %>" style="display:none;"><%=((dist==null?"District":dist.equals("null")?"District":dist)) %></option>
				</select>
				</div>
				</div>
                </div>
               <div class="col-md-2 col-sm-6 col-xsm-10" id="top1">
                <div class="select-filters">  
                <select name ="permitType" class="form-control" class="preferenceSelect">
				<option value="<%=((permitType==null?"SELECT":permitType.equals("null")?"SELECT":permitType)) %>" style="display:none;"><%=((permitType==null?"Permit Type":permitType.equals("null")?"Permit Type":permitType)) %></option>
				<option value="All">All</option>
				<option value="WITHIN STATE">WITHIN STATE</option>
				<option value="OTHER STATE">OTHER STATE</option>         
				</select>
				</div>
                </div>
              <%--   <div class="col-md-2 col-sm-6 col-xsm-10" id="top1">
                <div class="select-filters"> 
                <input type="text" name="range" placeholder="Range in Km" value="<%=(range==null?"":range.equals("null")?"":range) %>" class="form-control" onkeypress="CheckNumeric(event)"/>
                </div>
                </div> --%>
                <div class="col-md-2 col-sm-6 col-xsm-10" id="top1">
                <div class="select-filters">  
                <select name="licenseType" onchange="change_country(this.value)" class="form-control">
                <option value="<%=(licenseType==null?"SELECT":licenseType.equals("null")?"SELECT":licenseType) %>" style="display:none;"><%=(licenseType==null?"License Type":licenseType.equals("null")?"License Type":licenseType) %></option>
                <option>All</option>
				<option>HEAVY VEHICLE</option>
				<option>LIGHT VEHICLE</option>
				</select>
				</div>
                </div>
                <div class="col-md-2 col-sm-6 col-xsm-10" id="top1">
                 <input type="submit" class="thm-btn" value="Search">
                </div>
                 </form>
                
                    </div>
               		 <%
							ArrayList driverAl=(ArrayList)request.getAttribute("driverAl"); 

							if(driverAl!=null && driverAl.size()>0){
							Iterator it1=driverAl.iterator();
							
							int i=1;
							while(it1.hasNext()){
								DriverBean bean1=(DriverBean)it1.next();
								InsertDriverPreRtsAndSal bean2=(InsertDriverPreRtsAndSal)it1.next();

					%>
      
    <section class="container" >
    <aside class="col-md-10" style="font-family: 'Roboto', sans-serif; background-color: #fff;box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15); border-radius: 4px; margin-bottom: 7px; position: relative; right: 17px;margin-top: 0px;">
	<aside class="col-md-8">
		<div class="row">
			<div class="col-md-12" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
				<h3><%=bean1.getFIRST_NAME()+" "+bean1.getLAST_NAME()+"  "+"/"+ "  "+bean1.getDRIVER_ID()%></h3>

				
			</div>

		</div>
		<div class="row">
		 <div class="col-md-3 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	<span style="color: #555;font-weight: 600;">State:</span>

		 </div>	
		 <div class="col-md-9 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	<span style="text-transform: lowercase;"><%=bean1.getSTATE() %></span>
		 	
		 </div>	
         

		</div>
		<div class="row">
		 <div class="col-md-3 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	<span style="color: #555;font-weight: 600;">Driving Exp:</span>

		 </div>	
		 <div class="col-md-9 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	
		 	<span style="text-transform: lowercase;"><%=bean1.getDRIVING_EXP() %>&nbsp;&nbsp;years</span>
		 </div>	
         

		</div>
		<div class="row" >
		 <div class="col-md-3 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	<span style="color: #555;font-weight: 600;">Permit Type:</span>

		 </div>	
		 <div class="col-md-9 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	<span style="text-transform: lowercase;"><%=bean1.getPERMIT_TYPE() %></span>
		 	
		 </div>	
         

		</div>
		
	 	<div class="row">
		 <div class="col-md-3 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	<span style="color: #555;font-weight: 600;">Driver Availability:</span>

		 </div>	
		 <div class="col-md-9 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	
		 	<span style="text-transform: lowercase;"><%=bean1.getDRIVER_AVAILABILITY() %></span>
		 </div>	
         

		</div> 
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
<!-- 				<a id="toggle" href="javascript:toggle_it('toggleText1')" style="padding:5px;color:#fec107;"><u>More Details</u></a> -->
				<a id="toggle" href="javascript:toggle_it('<%="toggleText"+i %>')"  style="padding:5px;color:#337ab7;font-weight: 600;"><u>More Details</u></a>
			
			<section id="<%="toggleText"+i %>" style="display: none">
			
			<div class="row">
		 <div class="col-md-3 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	<span style="color: #555;font-weight: 600;">License Type :</span>

		 </div>	
		 <div class="col-md-9 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	
		 	<span style="text-transform: lowercase;"><%=bean1.getLICENSE_TYPE()==null?"N/A":bean1.getLICENSE_TYPE() %></span>
		 </div>	
		</div>
			
		<%-- 	<div class="row">
		 <div class="col-md-3 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	<span style="color: #555;font-weight: 600;">Preferred State :</span>

		 </div>
		 <%
		 GetDriverDetails driver=new GetDriverDetails();
		 ArrayList<InsertDriverPreRtsAndSal> driverRoutesl=driver.getHDriverRoutes(bean1.getEMAIL());
		 Iterator driverRoutesit=driverRoutesl.iterator();
		 
		 InsertDriverPreRtsAndSal driverRoutes=null;
		 while(driverRoutesit.hasNext()){
			 
			driverRoutes=(InsertDriverPreRtsAndSal) driverRoutesit.next();
			
			%>
			
			<div class="col-md-9 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	
		 	<span style="text-transform: lowercase;"><%=driverRoutes.getFROM_LOCATION()==null?"N/A":driverRoutes.getFROM_LOCATION()+"  TO  " %><%=driverRoutes.getTO_LOCATION()==null?"":driverRoutes.getTO_LOCATION() %></span>
		 </div>	
			
		<%	 
		 }
		 
		 %>
		 <div class="col-md-9 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	
		 	<span style="text-transform: lowercase;"><%=bean2.getFROM_LOCATION()==null?"N/A":bean2.getFROM_LOCATION()+"  TO  " %><%=bean2.getTO_LOCATION()==null?"":bean2.getTO_LOCATION() %></span>
		 </div>	
		</div> --%>
			
			<div class="row">
		 <div class="col-md-3 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	<span style="color: #555;font-weight: 600;">Expected Salary:</span>

		 </div>	
		 <div class="col-md-9 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	
		 	<span style="text-transform: lowercase;">&#8377;&nbsp;<%=bean2.getDEXPECTED_SAL()==null?"N/A":bean2.getDEXPECTED_SAL() %></span>
		 </div>	
		</div>
		
			<div class="row">
		 <div class="col-md-3 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	<span style="color: #555;font-weight: 600;">Driver Email :</span>

		 </div>	
		 <div class="col-md-9 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	
		 	<span style="text-transform: lowercase;"><%=bean1.getEMAIL() %></span>
		 </div>	
		</div>
		
				<div class="row">
		 <div class="col-md-3 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	<span style="color: #555;font-weight: 600;">Driver Contact :</span>

		 </div>	
		 <div class="col-md-9 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	
		 	<span style="text-transform: lowercase;"><%=bean1.getMOBILE_NO()==null?"N/A":bean1.getMOBILE_NO() %></span>
		 </div>	
		</div>
			
			</section>
			</div>

		</div>
		<div class="row">
		 <div class="col-md-3 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">

		 </div>	
		 <div class="col-md-9 col-sm-6 col-xs-6" style="margin-top: 5px;font-size: 15px;font-weight: 500;color: #000;">
		 	
		 </div>	
		</div>

	</aside>
	
	<aside class="col-md-4" align="center">
		<figure>
<!-- 			<img width="100%" height="200px" src="http://globalcomment.com/wp-content/uploads/2009/12/avatarstill1.jpg"> -->
            <br>
            <%if(bean1.getPHOTO()!=null && !bean1.getPHOTO().equals("")){%>
            	
				<img class="img-thumbline" src="data:image/png;base64,<%=bean1.getPHOTO() %>" alt="No image" style=" width:50%;height:100%">
				<%}else{ %>
				<img class="img-thumbline" src="./images/driverImage.gif" alt="No image" style=" width:50%;height:100%">		
             	<%} %>
            <br>
            <caption><%=bean1.getLICENSE_NO()%></caption>

		</figure>



	</aside>

</aside>
<aside class="col-md-2"></aside>
</section>
    
    
    <%i++; %>
<%
}
%>

                 <div class="col-md-10" style="font-family: 'Roboto', sans-serif; background-color: #fff;box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15); border-radius: 4px; margin-bottom: 7px; position: relative; right: 0px;margin-top: 0px;">
             			Pages:&nbsp;
                 	<c:forEach begin="1" end="${noOfPages}" var="k">
				
<%-- 				<td style="float: left" ><a href="./SearchHDriver?page=${k}&state=<%=state%>&dist=<%=dist%>&permitType=<%=permitType%>&range=<%=range%>&licenseType=<%=licenseType%>">${k}&nbsp;&nbsp; </a></td> --%>
			
						<c:set var="currentPage" value="${currentPage}"></c:set>
             			<c:set var="noOfPages" value="${k}"></c:set>
             			
             			<%
             			Integer currentPage1=(Integer)pageContext.getAttribute("currentPage");
             			Integer noOfPages=(Integer)pageContext.getAttribute("noOfPages");
             			if(currentPage1.equals(noOfPages)){
             			%>
						<a href="./SearchHDriver?page=${k}&state=<%=state%>&dist=<%=dist%>&permitType=<%=permitType%>&range=<%=range%>&licenseType=<%=licenseType%>" style="color:#fc6116;"><u>${k}&nbsp;</u></a>             			
						<%} else{%>
						             			
						<a href="./SearchHDriver?page=${k}&state=<%=state%>&dist=<%=dist%>&permitType=<%=permitType%>&range=<%=range%>&licenseType=<%=licenseType%>">${k}&nbsp;</a> 				
						<%} %>
			
			</c:forEach>
			</div>

				<%}else{if(driverAl==null){}else{%> <section class="col-lg-10 col-md-12 col-sm-12 col-xsm-12" style="height:200px;background: #f5f5f5;border-radius: 5px;margin-top: 10px;margin-bottom: 10px;">
                       <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 10px;font-size: 18px;margin-bottom: 5px;"><span style="font-weight:600;color:red">Data not found.....</span></div> 
                     </section>
					<%
					}}
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
                               <!--  <input type="text" class="form-control" placeholder="Enter Your Email" name="q"> -->
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
        
<%-- <script type="text/javascript">
var state1="<%=state==null?"State":state%>";
$("select[name=state] option:first").val(state1);
$("select[name=state] option:first").text(state1);
</script>  --%>  
    </body>
</html>