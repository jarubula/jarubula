<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<style>
/* social */


#fa:hover {
  
} 

#fa {
  transition: 0.70s;
  -webkit-transition: 0.70s;
  -moz-transition: 0.70s;
  -ms-transition: 0.70s;
  -o-transition: 0.70s;
  padding: 15px;
  font-size: 18px;
  width: 41px;
  text-align: center;
  text-decoration: none;
  margin: 5px 2px;
}

#fa:hover {
   transition: 0.90s;
  -webkit-transition: 0.90s;
  -moz-transition: 0.90s;
  -ms-transition: 0.90s;
  -o-transition: 0.90s;
  -webkit-transform: rotate(360deg);
  -moz-transform: rotate(360deg);
  -o-transform: rotate(360deg);
  -ms-transform: rotate(360deg);
  transform: rotate(360deg);
    opacity: 0.7;
}

.fa-facebook {
  background: #3B5998;
  color: white;
}

.fa-twitter {
  background: #55ACEE;
  color: white;
}

.fa-google {
  background: #dd4b39;
  color: white;
}

.fa-linkedin {
  background: #007bb5;
  color: white;
}

.fa-youtube {
  background: #bb0000;
  color: white;
}

.fa-instagram {
  background: #125688;
  color: white;
}
.fa-skype {
  background: #00aff0;
  color: white;
}
/* end social */
.white1 li a{
color: #fff;
}
.white1 p{
color: #fff;
}
.sub-footer p {
    margin: 0;
    color: #fff;
    font-size: 15px;
    font-weight: normal;
    font-family: sans-serif;
    margin: 7px 10px;
}
.white1 p {
    color: #fff;
    line-height: 23px;
    letter-spacing: 0.25px;
    font-weight: 500;
    font-size: 14px;
}
.white1 li a {
    color: #fff;
    letter-spacing: 0.25px;
    font-weight: 500;
    font-size: 14px;
}
footer .footer-title {
    margin: 0 0 18px;
    font-size: 20px;
    font-weight: 700;
}
#fa {
    transition: 0.70s;
    -webkit-transition: 0.70s;
    -moz-transition: 0.70s;
    -ms-transition: 0.70s;
    -o-transition: 0.70s;
    padding: 15px;
    font-size: 18px;
    width: 40px;
    text-align: center;
    text-decoration: none;
    margin: 5px 3px;
    height: 40px;
    border-radius: 48px;
    margin: 0px 4px;
    padding: 12px 3px;
}
footer {
    background-color: #242121;
    color: #fff;
    width: 100%;
    position: relative;
    bottom: 0;
    z-index: 0;
    padding-top: 40px;
}
.footer-menu ul li a {
    color: #fff;
    padding: 0 10px;
    font-size: 15px;
    font-weight: normal;
    font-family: sans-serif;
    margin: 0 3px;
}
</style>

</head>
<body>
<div class="container">
                   

                <div class="row">
                    <!-- Address -->
                    <div class="col-sm-4 col-md-4">
                        <div class="footer-box address-inner">
                            <!-- <h4 style="color:#fff;">VaahanMitra</h4> -->
                            <h2 style="color:#fff;margin-top:0px;font-weight:600;">Vaahan<span style="margin-left:2px; color:#fec107;">Mitra</span></h2>
                            <div class="address white1">
                                <i class="flaticon-placeholder"></i>
                                <p>Plot No. 7-1-618, #306,<br> Annapurna Block,
Aditya Enclave,<br>Ameerpet, Hyderabad, 500038.<br>
                                    Telangana<br>
                                    India
                                </p>
                            </div>
                            <div class="address white1">
                                <i class="flaticon-customer-service"></i>
                                <p>040-48510133<!-- 040 - 40191909 --></p>
                            </div>
                            <div class="address white1">
                                <i class="flaticon-mail"></i>
                                <p>info@vaahanmitra.com</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-8 col-md-8 ">
                        <div class="row">
                            <div class="col-md-4 col-sm-4">
                                <div class="footer-box">
                                    <h4 class="footer-title">Information</h4>
                                    <ul class="categoty white1">
                                        
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
                                    <ul class="categoty white1">
                                        <li><a target="_blank" href="https://campusguide.in/">Campusguide</a></li>
                                        <li><a target="_blank" href="https://rythumitra.com/">Rythumitra</a></li>
                                        <li><a target="_blank" href="https://zorotrucks.com">Frytemate</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-4">
                                <div class="footer-box">
                                    <h4 class="footer-title">Links</h4>
                                    <ul class="categoty white1">
                                        <li><a href="#">cars&bike in Hyderabad</a></li>
                                        <li><a href="#">cars&bike in Bangalore</a></li>
                                        <li><a href="#">cars&bike in Chennai</a></li>
                                        
                                    </ul>
                                    
                                     
                                </div>
                               
                            </div>
                             <div class="col-md-12 " align="right">
                                <a href="#" class="fa fa-facebook" id="fa"></a>
                                <a href="#" class="fa fa-twitter" id="fa"></a>
                                <a href="#" class="fa fa-google" id="fa"></a>
                                <a href="#" class="fa fa-linkedin" id="fa"></a>
                                <a href="#" class="fa fa-youtube" id="fa"></a>
                                <a href="#" class="fa fa-skype" id="fa"></a>
                                </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            <div class="sub-footer">
                <div class="container-fluid" style="font-size: 12px;">
                    <div class="row">
                        <div class="col-sm-3">
                            <p>Copyright © 2017 . All rights reserved </p>
                        </div>
                        <div class="col-sm-5">
                            <p>Site Devloped & Maintained By <a href="http://kosurisoft.com/" target="_blank" style=" color: #ffc71e;
                    font-size: 17px; text-decoration: underline;">kosurisoft.com</a></p>
                        </div>
                        <div class="col-sm-4">
                            <div class="footer-menu">
                                <ul class="white1">
                                    <li><a href="#">Home</a></li>
                                    <li><a href="#">About</a></li>
                                    <li><a href="#">Service</a></li>
<!--                                     <li><a href="#">Blog</a></li> -->
                                    <li><a href="#">Shop</a></li>
                                    <li><a href="#">Forum</a></li> 
                                    
                                </ul>
                               
                            </div>
                        </div>
                    </div>
                </div>
            </div>

</body>
</html>