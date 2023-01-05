<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrarse en Sistema | Ciberfarma</title>
<link rel="shortcut icon" href="img/logo.png" type="image/x-icon">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
	<link rel="stylesheet" href="/SmashClothes_ProyectoEFRTIV/css/estilos.css">
	<!-- <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet"> -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> 
</head>
<body>
	<form action="crudusu" method="post">
        <h1>Registro en Sistema </h1>
        <input type="text" placeholder="Ingrese sus Nombres" class="form-control" required="required" name="txtNombre" maxlength="15">
        <input type="text" placeholder="Ingrese sus Apellidos" class="form-control" required="required" name="txtApellido" maxlength="25">
        <input type="email" placeholder="Ingrese su Correo" class="form-control" required="required" name="txtUsuario">
        <input type="password" placeholder="Ingrese su Contraseña" id="exampleInputPassword1" class="form-control" required="required" name="txtClave" maxlength="5">
        <input type="date" placeholder="Ingrese su fecha de nacimiento" class="form-control" required="required" name="txtFecha">
        <p class="acuerdo">Estoy de acuerdo con terminos y condiciones</p>
        <button>Registrarse</button>
        <p class="link"><a href="/SmashClothes_ProyectoEFRTIV/login.jsp">¿Ya tienes cuenta?</a></p>
    </form>
    <br> ${mensaje } <br>
</body>
</html>