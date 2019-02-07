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

 	var popup=window.open('./displayBikeImage.jsp?photo='+myId);
/* 	var n=window.open("DisplayCarImage.jsp?photo="+myId,"mywindow", " width=2000, height=1000"); */
}

</script>
        <style>
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
         
            <section class="tour-details-inner"  id="top2">
                
                <div class="container">
                  <% 
                           ArrayList<UsedBike> compareCarDetails=(ArrayList<UsedBike>)request.getAttribute("compareBikeDetails");
                    		int i=0;
                           %> 
                
                    <div class="row">
                     <%-- <%
                                        if(i==0 || i==3){%> --%>
                      <div class="col-lg-12">
                     <h4 class="five">Compare Bikes</h4>
                     <br>
                     </div>
                     <div class="col-lg-12">
                     <c:forEach var="bikeDetails"  items="${compareBikeDetails}">
                        <div class="col-md-3">
                        <a href="#" onclick="callMe('${bikeDetails.BIKE_NUMBER}');"><img src="data:image/png;base64,${bikeDetails.PHOTO1}" alt="No image" class="img-responsive" style=" width: 100%; height: 190px;"></a>
                       
                       <div class="col-md-12 col-sm-12 four">
                        <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;">
                        <div class="col-md-6 col-xs-6 col-sm-6 bike1"><span>Price : </span></div>
                        <div class="col-md-6 col-xs-6 col-sm-6 bike2"><span><c:out value="${(bikeDetails.OFFER_PRICE==null)?'N/A':carDetails.OFFER_PRICE}"></c:out></span></div>
                        </div>
                        
                          <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;"> 
                         <div class="col-md-6 col-xs-6 col-sm-6 bike1"><span>Brand : </span></div>
                         <div class="col-md-6 col-xs-6 col-sm-6 bike2"><span><c:out value="${bikeDetails.BIKE_BRAND}"></c:out></span></div>
                         </div>
                        
                         <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;">
                         <div class="col-md-6 col-xs-6 col-sm-6 bike1"><span>Model : </span></div>
                         <div class="col-md-6 col-xs-6 col-sm-6 bike2"><span><c:out value="${bikeDetails.BIKE_MODEL}"></c:out></span></div>
                         </div>
                         
                         <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;">
                         <div class="col-md-6 col-xs-6 col-sm-6 bike1"><span>Kms : </span></div>
                         <div class="col-md-6 col-xs-6 col-sm-6 bike2"><span><c:out value="${bikeDetails.CURRENT_MILEAGE}"></c:out></span></div>
                         </div>
                         
                         <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;">
                         <div class="col-md-6 col-xs-6 col-sm-6 bike1"><span>Color : </span></div>
                         <div class="col-md-6 col-xs-6 col-sm-6 bike2"><span><c:out value="${bikeDetails.COLOR}"></c:out></span></div>
                         </div>
                         </div>
                         
                        </div>
                        
                       </c:forEach>
                     </div>
                     
                 
                     
                      <div class="col-lg-12"><br><br><br></div>
                     
                     
                    <%--  <div class="col-lg-12">
                     <h4>Compare Bikes</h4>
                      <div class="col-md-4" style=" padding: 0 0;">
                      <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;">
                         <div class="col-md-4 col-xs-6 col-sm-6 bike1"><span>Price :</span></div>
                         <div class="col-md-8 col-xs-6 col-sm-6 bike2"><span>1,00,000 </span></div>
                        </div> 
                         
                        <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;"> 
                         <div class="col-md-4 col-xs-6 col-sm-6 bike1"><span>Brand :</span></div>
                         <div class="col-md-8 col-xs-6 col-sm-6 bike2"><span>Bajuj</span></div>
                         </div>
                        
                         <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;">
                         <div class="col-md-4 col-xs-6 col-sm-6 bike1"><span>Model :</span></div>
                         <div class="col-md-8 col-xs-6 col-sm-6 bike2"><span>Pulsar</span></div>
                         </div>
                         
                         <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;">
                         <div class="col-md-4 col-xs-6 col-sm-6 bike1"><span>Kms :</span></div>
                         <div class="col-md-8 col-xs-6 col-sm-6 bike2"><span>10</span></div>
                         </div>
                         
                         <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;">
                         <div class="col-md-4 col-xs-6 col-sm-6 bike1"><span>Color :</span></div>
                         <div class="col-md-8 col-xs-6 col-sm-6 bike2"><span>Red</span></div>
                         </div>
                         
                          <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;">
                         <div class="col-md-4 col-xs-6 col-sm-6 bike1"><span>Color :</span></div>
                         <div class="col-md-8 col-xs-6 col-sm-6 bike2"><span>Red</span></div>
                         </div>
                         
                         <div class="col-md-12 col-xs-12 col-sm-12" style="padding: 0 0;">
                         <div class="col-md-4 col-xs-6 col-sm-6 bike1"><span>Color :</span></div>
                         <div class="col-md-8 col-xs-6 col-sm-6 bike2"><span>Red</span></div>
                         </div>
                         
                      </div>
                      <%  }
                           %>
                      <div class="col-md-4 col-xs-12 col-sm-12">
                      <div class="ribbon"><span>Popular</span></div>
                        <a href="#"><img src="assets/images/download.jpg" style="border: 1px solid #fff;
                           border-radius: 5px; "></a>
                      </div>
                       <div class="col-md-4"></div>
                     </div>
                 --%>
                        <div class="col-md-12">
                          
                 <%--       <div class="col-md-3 col-sm-6 col-xs-12 grid-item">
                      
                                   <%
                                        if(i==0 || i==3){%>
                                        	
                                       
                                    <div class="col-lg-12" style="background: #efefef;">
                                        <ul>
                                        <li style="padding:5px 0px;font-weight:bold;color:red;">PRICE<span style="float:right;">&rarr;</span></li>
                                        <li style="padding:5px 0px;font-weight:bold;color:red;">BRAND<span style="float:right;">&rarr;</span></li>
                                        <li style="padding:5px 0px;font-weight:bold;color:red;">MODEL<span style="float:right;">&rarr;</span></li>
                                        <li style="padding:5px 0px;font-weight:bold;color:red;">KMS<span style="float:right;">&rarr;</span></li>
                                        <li style="padding:5px 0px;font-weight:bold;color:red;">COLOR<span style="float:right;">&rarr;</span></li>
                                        </ul>
                                    </div>
                                    <%  }
                                        %>
                                    </div> 
                                    <c:forEach var="bikeDetails"  items="${compareBikeDetails}"> 
                        <div class="col-md-3 col-sm-6 col-xs-12 grid-item" style="margin-top:67px;">
                                        <div class="grid-item-inner">
                                            <div class="grid-img-thumb">
                                                <!-- ribbon -->
                                               <div class="ribbon"><span>Popular</span></div>
                                                <a href="#" onclick="callMe('${bikeDetails.BIKE_NUMBER}');"><img src="data:image/png;base64,${bikeDetails.PHOTO1}" alt="No image" class="img-responsive"></a>
                                            </div>
                                        </div>
                            <div class="col-lg-12" style="background: #efefef;">
                                        <ul>
                                        <li style="padding:5px 0px;font-weight:bold;"><c:out value="${(bikeDetails.OFFER_PRICE==null)?'N/A':carDetails.OFFER_PRICE}"></c:out></li>
                                        <li style="padding:5px 0px;font-weight:bold;"><c:out value="${bikeDetails.BIKE_BRAND}"></c:out></li>
                                        <li style="padding:5px 0px;font-weight:bold;"><c:out value="${bikeDetails.BIKE_MODEL}"></c:out></li>
                                        <li style="padding:5px 0px;font-weight:bold;"><c:out value="${bikeDetails.CURRENT_MILEAGE}"></c:out></li>
                                        <li style="padding:5px 0px;font-weight:bold;"><c:out value="${bikeDetails.COLOR}"></c:out></li>
                                        </ul>
                                       
                                    </div>
                                    </div>
                                    <%i++; %>
                         </c:forEach>   --%>
                    </div>
                       
               <!--      related tours
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="separator"></div>
                            <h3>Popular Cars</h3>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-12">
                            <div class="grid-item-inner">
                                <div class="grid-img-thumb">
                                    ribbon
                                    <div class="ribbon"><span>Popular</span></div>
                                    <a href="#"><img src="assets/images/tour-370x370-1.jpg" alt="1" class="img-responsive" /></a>
                                </div>
                                <div class="grid-content">
                                    <div class="grid-price text-right">
                                        Only <span><sub>$</sub>785</span>
                                    </div>
                                    <div class="grid-text">
                                        <div class="place-name">Audio</div>
                                        <div class="travel-times">
                                           
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> ../grid item
                        <div class="col-md-3 col-sm-6 col-xs-12">
                            <div class="grid-item-inner">
                                <div class="grid-img-thumb">
                                    ribbon
                                    <div class="ribbon"><span>Popular</span></div>
                                    <a href="#"><img src="assets/images/tour-370x370-2.jpg" alt="1" class="img-responsive" /></a>
                                </div>
                                <div class="grid-content">
                                    <div class="grid-price text-right">
                                        Only <span><sub>$</sub>785</span>
                                    </div>
                                    <div class="grid-text">
                                        <div class="place-name">BMW</div>
                                        <div class="travel-times">
                                          
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> ../grid item
                        <div class="col-md-3 col-sm-6 col-xs-12">
                            <div class="grid-item-inner">
                                <div class="grid-img-thumb">
                                    ribbon
                                    <div class="ribbon"><span>Popular</span></div>
                                    <a href="#"><img src="assets/images/tour-370x370-3.jpg" alt="1" class="img-responsive" /></a>
                                </div>
                                <div class="grid-content">
                                    <div class="grid-price text-right">
                                        Only <span><sub>$</sub>785</span>
                                    </div>
                                    <div class="grid-text">
                                        <div class="place-name">Hyundai</div>
                                        <div class="travel-times">
                                           
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> ../grid item
                        <div class="col-md-3 col-sm-6 col-xs-12">
                            <div class="grid-item-inner">
                                <div class="grid-img-thumb">
                                    ribbon
                                    <div class="ribbon"><span>Popular</span></div>
                                    <a href="#"><img src="assets/images/tour-370x370-4.jpg" alt="1" class="img-responsive" /></a>
                                </div>
                                <div class="grid-content">
                                    <div class="grid-price text-right">
                                        Only <span><sub>$</sub>785</span>
                                    </div>
                                    <div class="grid-text">
                                        <div class="place-name">volvo</div>
                                        <div class="travel-times">
                                           
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> ../grid item
                    </div> -->
                   
                </div>
                
                </div>
            </section>
            
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