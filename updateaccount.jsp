<!doctype html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.sport.model.UserBean, com.sport.dao.AccountDAO,com.sport.controller.AccountController, java.sql.*, java.util.*" %>
<head>  <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("account")==null)
      response.sendRedirect("userhome.jsp");
  else   if(session.getAttribute("account")!=null){
	  
	  AccountDAO dao = new AccountDAO();
	  int userid = (Integer)session.getAttribute("sessionId");
	  request.setAttribute("account",dao.getRecordById(userid));
	  
  }

%>
    <!-- Required meta tags -->
    <meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>BasketBall || About</title>
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
    <style>html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif}
</style>

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
                    </div>
                </div>
            </div>
        </div>
        <div class="main_menu">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <nav class="navbar navbar-expand-lg navbar-light">
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>

                            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                <ul class="navbar-nav mr-auto">
                        
                                <div class="header_social_icon d-none d-lg-block">
                                    <ul>
                                        <li><a href="#"><i class="ti-facebook"></i></a></li>
                                        <li>
                                            <a href="#"> <i class="ti-twitter"></i></a>
                                        </li>
                                        <li><a href="#"><i class="ti-instagram"></i></a></li>
                                        <li><a href="#"><i class="ti-skype"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </nav>
                        <div class="header_social_icon d-block d-lg-none">
                            <ul>
                                <li><a href="#"><i class="ti-facebook"></i></a></li>
                                <li>
                                    <a href="#"> <i class="ti-twitter"></i></a>
                                </li>
                                <li><a href="#"><i class="ti-instagram"></i></a></li>
                                <li><a href="#"><i class="ti-skype"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- Header part end-->

    <!--::breadcrumb part start::-->
    <section class="breadcrumb breadcrumb_bg">
         <div class="container">
             <div class="row">
               <div class="col-lg-12">
                  <div class="breadcrumb_iner">
                     <div class="breadcrumb_iner_item">
                        <h1>My Account</h1>
                        <p>Home<span>/</span>update Account</p>
                     </div>
                  </div>
               </div>
             </div>
         </div>
     </section>
     <!--::breadcrumb part start::-->

  


    <!-- social_connect_part part start-->
    <section class="social_connect_part">
        <div class="container-fluid">
            <div class="row justify-content-center ">
                <div class="col-xl-5">
       
                 
                 
                 <form action="AccountController" method="post">
			    <div id="main" class="wrapper style1" align="center">
			      <div class="container2" style="width:50%;" >
			      	<h2>Update Account</h2>
			      	<table> <input type="hidden" name="action" value="update" />
					              <input  type = "hidden" placeholder="userid"name="userid" value="<c:out value="${account.userid}"/>" readonly/>
			      		<tr>
					              <td style ="background-color:#F3FEDC;"><strong>No Matric: </strong></td>
			                     <td> <input type="text" name="no_matric" value="<c:out value="${account.no_matric}"/>" placeholder="No Matric"size="50" maxlength="40"  readonly/>
			                </td>
			      		</tr>
			      		<tr>
			      			<td style ="background-color:#F3FEDC;"><strong>FullName: </strong></td>
			                <td><input type="text" name="fullname" value="<c:out value="${account.fullname}"/>"  placeholder="fullname"size="50" maxlength="40" readonly/></td>
			      		</tr>
			      		<tr>
			      			<td style ="background-color:#F3FEDC;"><strong>Email: </strong></td>
			                <td><input type="text" name="email" value="<c:out value="${account.email}"/>"  placeholder="Email" size="50"  maxlength="40" /></td>
			      		</tr>
			      		<tr>
			      			<td style ="background-color:#F3FEDC;"><strong>Phone Number: </strong></td>
			                <td><input type="text" name="no_phone" value="<c:out value="${account.no_phone}"/>"  placeholder="Phone"size="50"  maxlength="40" /></td>
			      		</tr>
			      		<tr>
			      			<td style ="background-color:#F3FEDC;"><strong>Password: </strong></td>
			                <td><input type="password" name="password" value="<c:out value="${account.password}"/>"  placeholder="Password" size="50" maxlength="40" /></td>
			      		</tr>	
			      	</table>
	<br><br><input type="submit" value="Submit" class="primary fit">&nbsp
							<input type="reset" value="Cancel" class="fit"><br><a href="account.jsp">Back </a>
			      </div>
				</div>
              </form>  </div>
                </div>
            </div>
            </div>
        </div>
    </section>
    <!-- social_connect_part part end-->

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
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="ti-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Uitm Students</a>
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
    <script src="js/masonry.pkgd.js"></script>
    <!-- particles js -->
    <script src="js/owl.carousel.min.js"></script>
    <!-- carousel js -->
    <script src="js/swiper.min.js"></script>
    <!-- custom js -->
    <script src="js/custom.js"></script>

   
</body>

</html>