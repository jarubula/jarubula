<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Comar</title>
        <!-- Favicons -->
        <link rel="shortcut icon" href="assets/images/favicon.png" type="image/x-icon">
        <link rel="apple-touch-icon" type="image/x-icon" href="assets/images/apple-touch-icon-57x57-precomposed.png">
        <link rel="apple-touch-icon" type="image/x-icon" sizes="72x72" href="assets/images/apple-touch-icon-72x72-precomposed.png">
        <link rel="apple-touch-icon" type="image/x-icon" sizes="114x114" href="assets/images/apple-touch-icon-114x114-precomposed.png">
        <!-- Base Css -->
        <link href="assets/css/base.css" rel="stylesheet" type="text/css"/>
        
        <script type="text/javascript">
function callMe(myId) {

 	var popup=window.open('./DisplayCarImage.jsp?photo='+myId);
/* 	var n=window.open("DisplayCarImage.jsp?photo="+myId,"mywindow", " width=2000, height=1000"); */
}

</script>
	<style type="text/css">
		
 a.darken {
    display: inline-block;
    background: black;
    padding: 0;
    position:relative;
	
}

a.darken img {
    display: block;
    
    -webkit-transition: all 0.2s linear;
       -moz-transition: all 0.2s linear;
        -ms-transition: all 0.2s linear;
         -o-transition: all 0.2s linear;
            transition: all 0.2s linear;
}

.g:hover a.darken img {
    opacity: 0.3;           
}
a.darken span{
    visibility:hidden; 
    font-size:16px;
      position: absolute;
      top: 50%;
      left: 50%;
      -webkit-transform: translate(-50%, -50%);
      transform: translate(-50%, -50%);
      line-height: 100%;
}
.g:hover a.darken span{color:#fff; visibility:visible;
    -webkit-transition: all 0.2s linear;
       -moz-transition: all 0.2s linear;
        -ms-transition: all 0.2s linear;
         -o-transition: all 0.2s linear;
            transition: all 0.2s linear;
}
  
        .bike1 span{
        font-size: 16px;
        color: #f94141;
         padding: 0 0;
        
        }
   
     .bike2{
        font-size: 14px;
        color: #1f1c1c;
         padding: 0 0;
      
        }
        .bike3{
            font-size: 18px;
             color: #1f1c1c;
           }
       .five{
             font-size: 30px;
    margin: 0px 12px;
    color: #9a2220;
    font-weight: 600;
    font-family: unset;
    text-align: center;
    }
    .four{
        background: #eee;
    padding: 4px 0px 6px 5px;
    border-radius: 4px;
    min-height: 148px;
    margin: 3px 0;
    }
       
	</style>
    </head>
    <body>
        <!-- page loader -->
        <div class="se-pre-con"></div>
        <div id="page-content">
               <jsp:include page="./homeTop.jsp"></jsp:include>
            <section class="tour-details-inner" id="top2">
                <div class="container">
                             <% 
                           ArrayList<UsedCar> compareCarDetails=(ArrayList<UsedCar>)request.getAttribute("compareCarDetails");
                    		int i=0;
                           %> 
                
                         <div class="row">
                                <div class="col-lg-12">
                     <h4 class="five">Compare Cars</h4>
                     <br>
                     </div>
                     <div class="col-lg-12">
                     <c:forEach var="carDetails"  items="${compareCarDetails}">
                        <div class="col-md-3">
                        <a href="#" onclick="callMe('${carDetails.CAR_NUMBER}');" style="cursor: pointer;" class="darken"><img src="data:image/png;base64,${carDetails.PHOTO1}" alt="No image" class="img-tumbline img-responsive" style=" width: 100%;height: 190px;"></a>
                        <div class="col-md-12 col-sm-12 four">
                        <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;">
                        <div class="col-md-6 col-xs-6 col-sm-6 bike1"><span>Price : </span></div>
                        <div class="col-md-6 col-xs-6 col-sm-6 bike2"><span><c:out value="${(carDetails.OFFER_PRICE==null)?'N/A':carDetails.OFFER_PRICE}"></c:out> </span></div>
                        </div>
                        
                         <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;"> 
                         <div class="col-md-6 col-xs-6 col-sm-6 bike1"><span>Brand : </span></div>
                         <div class="col-md-6 col-xs-6 col-sm-6 bike2"><span><c:out value="${carDetails.CAR_BRAND}"></c:out></span></div>
                         </div>
                        
                         <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;">
                         <div class="col-md-6 col-xs-6 col-sm-6 bike1"><span>Model : </span></div>
                         <div class="col-md-6 col-xs-6 col-sm-6 bike2"><span><c:out value="${carDetails.CAR_MODEL}"></c:out></span></div>
                         </div>
                         
                         <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;">
                         <div class="col-md-6 col-xs-6 col-sm-6 bike1"><span>Fuel Type : </span></div>
                         <div class="col-md-6 col-xs-6 col-sm-6 bike2"><span><c:out value="${carDetails.FUEL_TYPE}"></c:out></span></div>
                         </div>
                         
                         <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;">
                         <div class="col-md-6 col-xs-6 col-sm-6 bike1"><span>Kms : </span></div>
                         <div class="col-md-6 col-xs-6 col-sm-6 bike2"><span><c:out value="${carDetails.CURRENT_MILEAGE}"></c:out></span></div>
                         </div>
                         
                         <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;">
                         <div class="col-md-6 col-xs-6 col-sm-6 bike1"><span>Color : </span></div>
                         <div class="col-md-6 col-xs-6 col-sm-6 bike2"><span><c:out value="${carDetails.COLOR}"></c:out></span></div>
                         </div>
                         </div>
                        </div>
                     </c:forEach>
                     </div>
                     
                     
                      <div class="col-lg-12"><br><br><br></div>
                      
                         
                         
                      <%--    <div class="col-md-12 col-xs-12 col-md-12 col-sm-12"> 
                         <div class="col-md-3 col-sm-12 col-xs-12 grid-item">                                
                                   <%
                                        if(i==0 || i==3){%>
                                    <div class="col-lg-12" style="background: #efefef; margin-top: 204px;">
                                        <ul>
                                        <li style="padding:5px 0px;font-weight:bold;color:red;">PRICE<span style="float:right;">&rarr;</span></li>
                                        <li style="padding:5px 0px;font-weight:bold;color:red;">BRAND<span style="float:right;">&rarr;</span></li>
                                        <li style="padding:5px 0px;font-weight:bold;color:red;">MODEL<span style="float:right;">&rarr;</span></li>
                                        <li style="padding:5px 0px;font-weight:bold;color:red;">FUEL TYPE<span style="float:right;">&rarr;</span></li>
                                        <li style="padding:5px 0px;font-weight:bold;color:red;">KMS<span style="float:right;">&rarr;</span></li>
                                        <li style="padding:5px 0px;font-weight:bold;color:red;">COLOR<span style="float:right;">&rarr;</span></li>
                                        </ul>
                                    </div>
                                    <%  }
                                        %>
                                    </div>
                                    <c:forEach var="carDetails"  items="${compareCarDetails}"> 
                             <div class="col-md-3 col-sm-12 col-xs-12 grid-item" style="margin-top:67px;">
                                        <div class="grid-item-inner">
                                            <div class="grid-img-thumb">
                                                <!-- ribbon -->
                                                <a href="#" onclick="callMe('${carDetails.CAR_NUMBER}');" style="cursor: pointer;" class="darken"><img src="data:image/png;base64,${carDetails.PHOTO1}" alt="No image" class="img-tumbline img-responsive"></a>
                                            </div>
                                        </div>
                            <div class="col-lg-12 col-md-3 col-sm-12 col-xs-12" style="background: #efefef;">
                                        <ul>
                                        <li style="padding:5px 0px;font-weight:bold;"><c:out value="${(carDetails.OFFER_PRICE==null)?'N/A':carDetails.OFFER_PRICE}"></c:out></li>
                                        <li style="padding:5px 0px;font-weight:bold;"><c:out value="${carDetails.CAR_BRAND}"></c:out></li>
                                        <li style="padding:5px 0px;font-weight:bold;"><c:out value="${carDetails.CAR_MODEL}"></c:out></li>
                                        <li style="padding:5px 0px;font-weight:bold;"><c:out value="${carDetails.FUEL_TYPE}"></c:out></li>
                                        <li style="padding:5px 0px;font-weight:bold;"><c:out value="${carDetails.CURRENT_MILEAGE}"></c:out></li>
                                        <li style="padding:5px 0px;font-weight:bold;"><c:out value="${carDetails.COLOR}"></c:out></li>
                                        </ul>
                                       
                                    </div>
                                    </div>
                                    <%i++; %>
                     
                         </c:forEach>      
                    </div> --%>
                    </div>
                   
                </div>
                </section>
                </div>
            
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