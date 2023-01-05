<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- <meta charset="ISO-8859-1"> -->
    <title> Inicio | SmashClothes</title>
<link rel="shortcut icon" href="img/logo.png" type="image/x-icon">
<link rel="stylesheet" href="css/inicio.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

    <div class="scroll-arriba">
        <i class="fas fa-angle-up"></i>
    </div>
   
	
    <!-- seccion = inicio de página banner -->
    <section class="home" id="home">
    	<jsp:include page="cabecera.jsp"></jsp:include>
    </section>
	
	<img alt="" src="/img/banner_ind.png">
    <!--sección = acerca de nosotros-->
    <section class="about" id="about">
        <div class="max-width">
            <h2 class="title">Acerca de nosotros</h2>
            <div class="about-content">
                <div class="column left">
                    <img src="img/nosotros1.jpg">
                </div>
                <div class="column right">
                    <div class="text">Nuestro Orígen</div>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempora quibusdam deserunt natus 
                    cupiditate maxime assumenda incidunt dolorem laudantium aliquid vel doloremque hic, animi, minus
                     veritatis architecto inventore esse quam omnis eos illo nemo cum sint. Harum asperiores autem rem culpa!</p>
                </div>
            </div>
        </div>
    </section>

    <!--sección = servicios-->
    <section class="servicios" id="servicios">
        <div class="max-width">
             <h2 class="title">Nuestros servicios</h2>
             <div class="serv-content">
                 <div class="card">
                     <div class="box">
                         <img src="img/pie/trabajador_mes.jpg" >
                        <div class="text">TRABAJORA DEL MES</div>
                        <p>Agradecemos y admiramos la dedicación, disciplina y buen humor en SmashClothes.</p>
                     </div>
                 </div>
                 <div class="card">
                    <div class="box">
                        <img src="img/pie/cantante.jpg" alt="">
                       <div class="text">NUEVOS TALENTOS</div>
                       <p>Cada semana presentamos artistas revelación para presentar nueva colección.</p>
                    </div>
                </div>
                <div class="card">
                    <div class="box">
                        <img src="img/pie/diversion.jpg" alt="">
                       <div class="text">DIVERSIÓN ASEGURADA </div>
                       <p>Invitamos a pasar momentos inolvidables lejos del estrés y con las medidas de bioseguridad</p>
                    </div>
                </div>
             </div>
         </div>
     </section>
    <!-- Sección ubicación del restaurante-->
            <section class="ubicacion" id="ubicacion">
                <div class="max-width">
                  <h2 class="title">Ubicación</h2>
                  <div class="ubi-content">
                    <div class="column left">
                    <div class="text">Para nuestros clientes</div>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempora quibusdam deserunt natus 
                    cupiditate maxime.</p>
                    <div class="row">
                        <i class="fab fa-whatsapp"></i>
                        <div class="info">
                            <div class="head">Teléfono</div>
                            <div class="sub-title">376-0303 | WhatsApp: (+51) 909-123-220</div>
                        </div>
                    </div>
                    <div class="row">
                        <i class="fas fa-map-marked-alt"></i>
                        <div class="info">
                            <div class="head">Dirección</div>
                            <div class="sub-title">Av. Augusto Pérez Araníbar 1010, San Isidro 20, Lima, Perú.</div>
                        </div>
                    </div>
                    <div class="row">
                        <i class="fas fa-envelope"></i>
                        <div class="info">
                            <div class="head">Email</div>
                            <div class="sub-title">info@smashclothes.com</div>
                        </div>
                    </div>
                    <div class="row">
                        <i class="fab fa-instagram"></i>
                        <div class="info">
                            <div class="head">Instagram</div>
                            <div class="sub-title">smcl_oficial</div>
                        </div>
                    </div>
                  </div>
                   <div class="column right">
                        <div class="text2">Horario de Atención</div>
                        <div class="field">
                            <div>
                                <img src="img/pie/banner horario2.png" id="ban-hor">
                            </div>
                        </div>
                   </div>
                </div>
                <div id="mapa">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15605.612254546792!2d-77.10460433267242!3d-12.084535441984642!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9105c97e17a97a9f%3A0x6ea77039f4d60c1!2sCosta%20Verde!5e0!3m2!1ses!2spe!4v1633798853251!5m2!1ses!2spe" width="100%" height="500" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
                </div>  
                </div>
            </section>
    <!--footer final-->
        <footer>
            <div class="footer-content">
                <img src="img/logo.png" class="footer-logo">
                <p>Aquí encontrarás, lo mejor del Perú en un solo lugar </p>
                <br>
                <p>¡Gracias por tu visita!</p>   
                <ul class="socials">
                    <li><a href="https://www.facebook.com"><i class="fab fa-facebook"></i></a></li>
                    <li><a href="https://www.twitter.com"><i class="fab fa-twitter"></i></a></li>
                    <li><a href="https://www.youtube.com"><i class="fab fa-youtube"></i></a></li>
                    <li><a href="https://www.instagram.com"><i class="fab fa-instagram"></i></a></li>
                    <li><a href="https://www.whatsapp.com"><i class="fab fa-whatsapp"></i></a></li>
                </ul>
            </div>
            <div class="footer-boton">
                <p>copyright &copy;2022 SmashClothes. diseñado por <span>Nicolas-Enzo-Marco-Mauricio</span> </p>
            </div>
        </footer>
        <script>
        let subMenu = document.getElementById("subMenu");

        function toggleMenu(){
            subMenu.classList.toggle("open-menu");
        }
    </script>
</body>
<script src="js/index.js"></script>
</html>