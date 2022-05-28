<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>User Login || Home</title>
    <link rel="icon" href="img/favicon.png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- animate CSS -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- owl carousel CSS -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <!-- themify CSS -->
    <link rel="stylesheet" href="css/themify-icons.css">
    <!-- flaticon CSS -->
    <link rel="stylesheet" href="css/flaticon.css">
    <!-- font awesome CSS -->
    <link rel="stylesheet" href="css/magnific-popup.css">
    <!-- swiper CSS -->
    <link rel="stylesheet" href="css/swiper.min.css">
    <!-- style CSS -->
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <!--::header part start::-->
    <header class="header_area">
        <div class="sub_header">
            <div class="container">
                <div class="row align-items-center">
                  <div class="col-md-4 col-xl-6">
                      <div id="logo">
                          <a href="index.html"><img src="img/Logo.png" alt="" title="" /></a>
                      </div>
                  </div>
                  <div class="col-md-8 col-xl-6">
                      <div class="sub_header_social_icon float-right">
                        <a href="#"><i class="flaticon-phone"></i>+02 213 - 256 (365)</a>
                        <a href="#signin" class="register_icon"><i class="ti-arrow-right"></i>SIGNIN</a>
                      </div>
                      <div class="sub_header_social_icon float-right">
                        <a href="#signout" class="register_icon"><i class="ti-arrow-right"></i>SIGNUP</a>
                      </div>
                    </div>
                </div>
            </div>
        </div>
        
    </header>
    <!-- Header part end-->

    <!-- banner part start-->
    <section class="banner_part">
        <div class="container">
            <div class="row align-content-center">
                <div class="col-lg-7 col-xl-5">
                    <div class="banner_text">
                        <h1><span>Sport Equipment</span><br> 
                    Booking</h1>
                        <p>Welcome to Equipment system of UiTM Jasin. You can booking all the equipments here !!!</p>

                        <br><c:if test="${requestScope.status== false}">


<body onload="alertUser('Register failed!Your Matric Number  might already exist')">
<div style="text-align:center;padding:10px;">

<p><a href="JavaScript:self.close();"></a></p>
</div>


</c:if>

<c:if test="${requestScope.status== true}">


	<h2><c:out value="${mssg}"/></h2>
					<p><img src="success.png" class="w3-border w3-padding" alt="Success"style="padding:8px;width:20%"></p>

</c:if>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- banner part start-->

    
    
    <!-- ================ signout section start ================= -->
  <section class="contact-section section_padding" id="signout">
    <div class="container">
      <div class="d-none d-sm-block mb-5 pb-4">
      
      <div class="row">
        <div class="col-12">
          <h2 class="contact-title">SIGN UP</h2>
        </div>
        <div class="col-lg-8">
          <form class="form-contact contact_form" action="RegisterAction" method="post" id="contactForm">
            <div class="row">
           
              <div class="col-sm-6">
                <div class="form-group">
                  <input class="form-control" name="no_matric"  type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter your matric number'" placeholder = 'Enter your matric number'required>
                </div>
              </div>
              <div class="col-12">
                <div class="form-group">
                  <input class="form-control" name="fullname"  type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter your fullname'" placeholder = 'Enter your fullname'required>
                </div>
              </div>
              <div class="col-12">
                <div class="form-group">
                  <input class="form-control" name="email" id="email" type="email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'" placeholder = 'Enter email address'required>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <input class="form-control" name="no_phone"  type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Phone Number'" placeholder = 'Enter Phone Number'required>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <input class="form-control" name="password"  type="password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Your Password'" placeholder = 'Enter Your Password'required>
                </div>
              </div>
            </div>
            <div class="form-group mt-3">
              <button type="submit" class="button button-contactForm">Sign Up</button>
            </div>
          </form>
         
        </div>
        <div class="col-lg-4">
          <div class="media contact-info">
            <span class="contact-info__icon"><i class="ti-home"></i></span>
            <div class="media-body">
              <h3>Uitm  Kampus Jasin </h3>
              <p>Merlimau, Melaka</p>
            </div>
          </div>
          <div class="media contact-info">
            <span class="contact-info__icon"><i class="ti-tablet"></i></span>
            <div class="media-body">
              <h3>096099768</h3>
              <p>Mon to Fri 9am to 6pm</p>
            </div>
          </div>
          <div class="media contact-info">
            <span class="contact-info__icon"><i class="ti-email"></i></span>
            <div class="media-body">
              <h3>support@UITM.com</h3>
              <p>Send us your query anytime!</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- ================ signout section end ================= -->
  
  
    <!-- ================ signin section start ================= -->
  <section class="contact-section section_padding"id="signin">
    <div class="container">
      <div class="d-none d-sm-block mb-5 pb-4">
      
      <div class="row">
        <div class="col-12">
          <h2 class="contact-title">SIGN IN</h2>
          
           <c:if test="${requestScope.fail==true }">
		

<body onload="alertUser('Invalid matric number or password!')">
<div style="text-align:center;padding:10px;">

<p><a href="JavaScript:self.close();"></a></p>
</div>
	</c:if>
        </div>
        <div class="col-lg-8">
          <form class="form-contact contact_form" action="LoginAction" method="post" id="contactForm">
            <div class="row">
           
              <div class="col-sm-6">
                <div class="form-group">
                  <input class="form-control" name="no_matric"  type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter your matric number'" placeholder = 'Enter your matric number'required>
                </div>
              </div>
              
              <div class="col-sm-6">
                <div class="form-group">
                  <input class="form-control" name="password"  type="password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Your Password'" placeholder = 'Enter Your Password'required>
                </div>
              </div>
            </div>
            <div class="form-group mt-3">
              <button type="submit" class="button button-contactForm">Sign In</button>
            </div>
          </form>
        </div>
        <div class="col-lg-4">
          <div class="media contact-info">
            <span class="contact-info__icon"><i class="ti-home"></i></span>
            <div class="media-body">
              <h3>Uitm  Kampus Jasin </h3>
              <p>Merlimau, Melaka</p>
            </div>
          </div>
          <div class="media contact-info">
            <span class="contact-info__icon"><i class="ti-tablet"></i></span>
            <div class="media-body">
              <h3>096099768</h3>
              <p>Mon to Fri 9am to 6pm</p>
            </div>
          </div>
          <div class="media contact-info">
            <span class="contact-info__icon"><i class="ti-email"></i></span>
            <div class="media-body">
              <h3>support@UITM.com</h3>
              <p>Send us your query anytime!</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- ================ signin section end ================= -->
    <!-- footer part start-->
    <section class="footer-area section_padding">
        <div class="container">
            <div class="row">
                <div class="col-xl-2 col-sm-4 mb-4 mb-xl-0 single-footer-widget">
        <h4>Top Products</h4>
                    <ul>
                        <li><a href="#">Managed Website</a></li>
                        <li><a href="#">Manage Reputation</a></li>
                        
                    </ul>
                </div>
                <div class="col-xl-2 col-sm-4 mb-4 mb-xl-0 single-footer-widget">
                    <h4>Quick Links</h4>
                    <ul>
                        <li><a href="#">Account</a></li>
                        <li><a href="#">Booking equipment</a></li>
                      
                    </ul>
                </div>
                <div class="col-xl-2 col-sm-4 mb-4 mb-xl-0 single-footer-widget">
                    <h4>Features</h4>
                    <ul>
                        <li><a href="#">Booking equipment</a></li>
                       
                        <li><a href="#">Terms of Service</a></li>
                    </ul>
                </div>
                
             

                            <div class="info"></div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <footer class="copyright_part">
        <div class="container">
            <div class="row align-items-center">
                <p class="footer-text m-0 col-lg-8 col-md-12"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="ti-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Uitm Jasin</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                <div class="col-lg-4 col-md-12 text-center text-lg-right footer-social">
                    <a href="#"><i class="ti-facebook"></i></a>
                    <a href="#"> <i class="ti-twitter"></i> </a>
                    <a href="#"><i class="ti-instagram"></i></a>
                    <a href="#"><i class="ti-skype"></i></a>
                </div>
            </div>
        </div>
    </footer>
    <!-- footer part end-->

    <!-- jquery plugins here-->
    <!-- jquery -->
    <script src="js/jquery-1.12.1.min.js"></script>
    <!-- popper js -->
    <script src="js/popper.min.js"></script>
    <!-- bootstrap js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- aos js -->
    <script src="js/aos.js"></script>
    <!-- easing js -->
    <script src="js/jquery.magnific-popup.js"></script>
    <!-- swiper js -->
    <script src="js/swiper.min.js"></script>
    <!-- swiper js -->
    <script src="js/masonry.pkgd.js"></script>
    <!-- particles js -->
    <script src="js/owl.carousel.min.js"></script>
    <!-- carousel js -->
    <script src="js/swiper.min.js"></script>
    <!-- swiper js -->
    <script src="js/swiper_custom.js"></script>
    <!-- custom js -->
    <script src="js/custom.js"></script>

<script>
function alertUser(msg) {
alert(msg);
}
</script>

</body>

</html>