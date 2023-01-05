<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compra</title>

    <link rel="stylesheet" href="css/estilosIntranet.css">
    
<link rel="icon" href="img/logo/Logo-sinfondo.png">
    <link rel="stylesheet" href="css/dark.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>

  
</head>

<body>

 
<!--  
    <div class="wrapper">

        <div class="notification_wrap">
            <div class="notification_icon">

                <i class="fas fa-bell"></i>
            </div>
            <div class="dropdown">
                <div class="notify_item">
                    <div class="notify_img">
                        <img src="https://www.geekmi.news/__export/1627357347774/sites/debate/img/2021/07/26/mikeytokyo1.jpg_375108060.jpg"
                            alt="profile_pic" style="width: 50px">
                    </div>
                    <div class="notify_info">
                        <p>Alex commented on<span>Timeline Share</span></p>
                        <span class="notify_time">10 minutes ago</span>
                    </div>
                </div>
                <div class="notify_item">
                    <div class="notify_img">
                        <img src="https://www.geekmi.news/__export/1627357347774/sites/debate/img/2021/07/26/mikeytokyo1.jpg_375108060.jpg"
                            alt="profile_pic" style="width: 50px">
                    </div>
                    <div class="notify_info">
                        <p>Ben hur commented on your<span>Timeline Share</span></p>
                        <span class="notify_time">55 minutes ago</span>
                    </div>
                </div>
                <div class="notify_item">
                    <div class="notify_img">
                        <img src="https://www.geekmi.news/__export/1627357347774/sites/debate/img/2021/07/26/mikeytokyo1.jpg_375108060.jpg"
                            alt="profile_pic" style="width: 50px">
                    </div>
                    <div class="notify_info">
                        <p>Meryn trant liked your<span>Cover Picture</span></p>
                        <span class="notify_time">2 hours ago</span>
                    </div>
                </div>
                <div class="notify_item">
                    <div class="notify_img">
                        <img src="https://www.geekmi.news/__export/1627357347774/sites/debate/img/2021/07/26/mikeytokyo1.jpg_375108060.jpg"
                            alt="profile_pic" style="width: 50px">
                    </div>
                    <div class="notify_info">
                        <p>John wick commented on your<span>Profile Picture</span></p>
                        <span class="notify_time">6 hours ago</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

-->
    <div class="boton">
        <button class="switchDark active" id="switch"></button>
    </div>


   <div class="header">

 		<c:if test="${usu == null }">
        <figure>
        <img class="avatar" alt=""
            src="https://img2.freepng.es/20180329/zue/kisspng-computer-icons-user-profile-person-5abd85306ff7f7.0592226715223698404586.jpg">
        <figcaption>
       
        	<h1> Bienvenido : Invitado</h1> 
        	 </figcaption>
        </figure>
        </c:if>
        <c:if test="${usu != null }">
        <figure>
        <img class="avatar" alt=""
            src="perfiles/${usu.codigo }.${usu.extension}">
        <figcaption>
       
        	<h1> Bienvenido : ${tipo}</h1>
        	 </figcaption>
        </figure>
        	  
        </c:if>
         
       



    </div>
    
    <main class="dark">

     <div class="grid-container">

  
        <div class="grid-item  wide " style="background-image: url(img/icono\ principal.png);">
            <a href="IntranetPrincipal.jsp" style="text-decoration:none ;"><p>MEN� PRINCIPAL</p></a>

            <!-- <h1>Cerrar Sesi�n </h1>-->
        </div>

    
          
         <div class="grid-item  wide " style="background-image: url(img/icono\ de\ reserva\ hotel.png);">
          <a href="verReserva" style="text-decoration:none ;"><p>RESERVA DE HABITACI�N</p></a>


          <!--  <h1>Cliente - Vuelos - Promociones <br> Proveedores</h1>-->
        </div>
 
         
         
   
 

     </div>

    </main>
       <div class="social">
        <ul>
            <li><a href="https://www.facebook.com/" target="_blank" class="icon-facebook"> <img src="img/iconFb.png"
                        alt=""></a></li>
            <li><a href="https://web.whatsapp.com/" target="_blank" class="icon-wasap"> <img src="img/iconWasap.png"
                        alt=""> </a></li>
            <li><a href="https://www.instagram.com/" target="_blank" class="icon-ig"> <img src="img/iconIg.png"
                        alt=""></a></li>

        </ul>
    </div>

  

</body>
<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="js/notificacion.js"></script>
<script src="js/ModoOscuro.js">  </script>

</html>