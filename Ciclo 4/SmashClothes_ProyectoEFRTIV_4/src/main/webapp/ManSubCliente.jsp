<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${titulo }</title>
 	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/estilosEnzo.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
<header></header>
    <div class="sub-content">
        <h2>${titulo }</h2>
        <form action="crudCliente" method="post" enctype='multipart/form-data'>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Codigo: </label>
                <input type="text" name="txtCodigoCli" style="grid-column: 2/3;" class="form-control" value="${cl.codigo }${codCli}" ${read } ${codRead }>
                
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Nombres: </label>
                <input name="txtNombre" id="" class="form-control" style="grid-column: 2/5; " ${read } value="${cl.nombre }">
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Apellidos: </label>
                <input name="txtApellido" id="" class="form-control" style="grid-column: 2/5; " ${read } value="${cl.apellido }"> 
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Tipo Doc: </label>
                <select class="form-control" style="grid-column: 2/3;" name="cmbTipoDoc" ${desactivar }>
                	 <c:forEach items="${tipoDoc }" var="tip">
	                		<c:if test="${cl.tipoDoc == tip.cod }">
	                			 <option value="${tip.cod }" selected>${tip.descrip }</option>
	                		</c:if>
	                		<c:if test="${cl.tipoDoc != tip.cod }">
	                			 <option value="${tip.cod }" >${tip.descrip }</option>
	                		</c:if>
	                	</c:forEach>
                	
                	
                </select>
                <label for="" name="" style="grid-column: 3/4; margin-left: 2rem;">Número Doc.: </label>
                <input type="text"  name="txtNumDoc" style="grid-column: 4/5;" class="form-control" value="${cl.numDoc }" ${read }>
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Sexo: </label>
                <select class="form-control" style="grid-column: 2/3;" name="cmbSexo" ${desactivar }>
                	
                    
                   	 <option value="Masculino" selected>Masculino</option>
                     <option value="Femenino" selected>Femenino</option>
                </select>
                <label for="" name="" style="grid-column: 3/4;">Estado: </label>
                <select class="form-control" style="grid-column: 4/5;" name="cmbEstado" ${desactivar } >
                	<c:forEach items="${estados }" var="es">
                		<c:if test="${cl.estado == es.idEstado }">
                			 <option value="${es.idEstado }" selected>${es.descrip }</option>
                		</c:if>
                		<c:if test="${cl.estado != es.idEstado }">
                			 <option value="${es.idEstado }" >${es.descrip }</option>
                		</c:if>
                	</c:forEach>
                	
                </select>
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Edad: </label>
                <input type="text" name="txtEdad" style="grid-column: 2/3;" class="form-control" value="${cl.edad }" ${read }>
                <label for="" name="" style="grid-column: 3/4; margin-left: 2rem;">Fecha Nacimiento: </label>
                <input type="date"  name="txtFechaNac" style="grid-column: 4/5;" class="form-control" value="${cl.fechaNa }" ${read }>
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Correo: </label>
                <input name="txtCorreo" id="" class="form-control" style="grid-column: 2/4; " value="${cl.correo }" ${read }>

            </div>
            <div class="form-posicion">
                <label for="formFile" name="" class="form-label" style="grid-column: 1/2;">Foto: </label>
                <input name="fileFoto" id="formFile" class="form-control" type="file" style="grid-column: 2/5;" ${desactivar }>
            </div>
            <div style="margin: 0 auto; display: flex; justify-content: center;">
                <button type="submit" name="btnAccion" value="${accion}" class="btn btn-primary">${accion}</button>
            </div>

        </form>
    </div>

</body>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
${msjError }
</html>