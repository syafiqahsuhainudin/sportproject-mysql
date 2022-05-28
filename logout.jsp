
<%@ page language="java" 
      contentType="text/html; charset=windows-1256"
      pageEncoding="windows-1256"
   %>
   <% 
    response.setHeader("Cache-Control","no-store,must-revalidate"); 
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", 0);
    session.invalidate();
    %> 
<html>
<head>
<meta charset="ISO-8859-1">
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Sport || Home</title>
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
                       
                      </div>
                      <div class="sub_header_social_icon float-right">
               
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
                        <a href="userhome.jsp" class="btn_1">STUDENT <span class="ti-angle-right"></span> </a>  &nbsp <a href="loginStaff.jsp" class="btn_1">STAFF <span class="ti-angle-right"></span> </a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- banner part start-->


    
    

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



</body>

</html>