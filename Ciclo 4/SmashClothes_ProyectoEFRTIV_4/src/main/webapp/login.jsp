<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar Sesión | SmashClothes</title>
<link rel="shortcut icon" href="img/logo.png" type="image/x-icon">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
	<link rel="stylesheet" href="/SmashClothes_ProyectoEFRTIV/css/style.css">
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
	<section class="login">
		<div class="login_box">

            <!-- parte izquierda de la pagina principal -->
			<div class="left">
			
				<div class="top_link">
                    <a href="principal.jsp">
                        <img src="https://drive.google.com/u/0/uc?id=16U__U5dJdaTfNGobB_OpwAJ73vM50rPV&export=download" alt="#">
                        Ingresar como invitado
                    </a>
                </div>
				
                <!-- contenedor del formulario de ingreso -->
                <div class="contact">
                    <!-- formulario de ingreso -->
					<form action="ingreso" method="post">
						<h3>Acceso al sistema</h3>
						<input name="txtUsuario" required="required" type="text" placeholder="Usuario o correo electrónico"
						class="form-control">
						<small id="emailHelp" class="form-text text-muted"> Nunca
					compartiremos tus datos personales</small>
						<input name="txtClave" type="password" placeholder="Contraseña" class="form-control">
						<small id="emailHelp" class="form-text text-muted">Para registrar su cuenta pulse <a href="/SmashClothes_ProyectoEFRTIV/registro.jsp">aquí</a></small>
						<button class="submit" >Ingresar</button>
					</form>
					<br> ${mensaje } <br>
				</div>

			</div>

            <!-- parte derecha de la pagina principal -->
			<div class="right">

				<div class="right-text">
					<h2>SMASH CLOTHES</h2>
					<h5>Vístete como si fuera tu día !</h5>
				</div>
                <!--<div class="right-inductor"><img alt="" src=""></div>-->
			</div>

		</div>
	</section>
</body>
</html>