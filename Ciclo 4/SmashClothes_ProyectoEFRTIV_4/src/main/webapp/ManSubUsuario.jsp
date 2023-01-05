<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title >${titulo }</title>
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
        <h2 style="font-size: xx-large;">${titulo }</h2>
        <form action="crudUsuario" method="post" enctype='multipart/form-data'>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Codigo: </label>
                <input type="text" name="txtCodigo"  style="grid-column: 2/3;" class="form-control" ${read } value="${usu.codUsu }${codUsu}" ${codRead } readonly="readonly">
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Nombres: </label>
                <input type="text" name="txtNombre" style="grid-column: 2/5;" class="form-control" ${read } value="${usu.nombre }">
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Apellidos: </label>
                <input type="text" name="txtApellido" style="grid-column: 2/5;" class="form-control" ${read } value="${usu.apellido }">
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Tipo Doc: </label>
                <select class="form-control" style="grid-column: 2/3;" name="cmbTipoDoc" ${desactivar }>
                <c:forEach items="${tipoDoc }" var="tipo">
                	<c:if test="${tipo.cod == usu.tipoDoc }">
                		<option value="${tipo.cod }" selected>${tipo.descrip }</option>
                	</c:if>
                	<c:if test="${tipo.cod != usu.tipoDoc }">
                		 <option value="${tipo.cod }">${tipo.descrip }</option>
                	</c:if>
                </c:forEach>

                </select>

                <label for="" name="" style="grid-column: 3/4; margin-left: 2rem;">Num. Doc.: </label>
                <input type="text"  name="txtNumDoc" style="grid-column: 4/5;" class="form-control" ${read } value="${usu.numDoc }">
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Sexo: </label>
                <select class="form-control" style="grid-column: 2/3;" name="cmbSexo" ${desactivar }>
                  <c:if test="${cl.sexo == 'Masculino' }">
                		<option value="Masculino" selected>Masculino</option>
                		<option value="Femenino">Femenino</option>
                	</c:if>
                	<c:if test="${cl.sexo == 'Femenino' }">
                		<option value="Femenino" selected>Femenino</option>
                		<option value="Masculino" >Masculino</option>
                	</c:if>
                	<c:if test="${cl.sexo == null}">
                		<option value="Femenino">Femenino</option>
                		<option value="Masculino">Masculino</option>
                	</c:if>
                </select>
                <label for="" name="" style="grid-column: 3/4; margin-left: 2rem;">Edad: </label>
                <input type="number"  name="txtEdad" style="grid-column: 4/5;" class="form-control" ${read } value="${usu.edad }">
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Cargo: </label>
                 <select class="form-control" style="grid-column: 2/3;" name="cmbCargo" ${desactivar }>
                  <c:forEach items="${tipoUsu }" var="tipUs">
                	<c:if test="${tipUs.cod == usu.idtipo }">
                		<option value="${tipUs.cod }" selected>${tipUs.descrip }</option>
                	</c:if>
                	<c:if test="${tipUs.cod != usu.tipoDoc }">
                		 <option value="${tipUs.cod }">${tipUs.descrip }</option>
                	</c:if>
                </c:forEach>
                </select>
                <label for="" name="" style="grid-column: 3/4; margin-left: 2rem">Departamento: </label>
                 <input type="text"  name="txtDepa" style="grid-column: 4/5;" class="form-control" ${read } value="${usu.depa }">
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Domicilio: </label>
                <input type="text" name="txtDomicilio" style="grid-column: 2/5;" class="form-control" value="${usu.domici }" ${read }>
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Distrito: </label>
                <input type="text" name="txtDistrito" style="grid-column: 2/3;" class="form-control" ${read } value="${usu.distrito }">
                <label for="" name="" style="grid-column: 3/4; margin-left: 2rem;">Provincia: </label>
                <input type="text" name="txtProvincia" style="grid-column: 4/5;" class="form-control" ${read } value="${usu.provi }">
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Pais: </label>
                <input type="text" name="txtPais" style="grid-column: 2/3;" class="form-control" ${read } value="${usu.pais }">
                <label for="" name="" style="grid-column: 3/4; margin-left: 2rem;">Nacionalidad: </label>
                <input type="text"  name="txtNacionalidad" style="grid-column: 4/5;" class="form-control" ${read } value="${usu.nacio }">
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Correo: </label>
                <input type="email" name="txtCorreo" style="grid-column: 2/3;" class="form-control" ${read } value="${usu.correo }">
                 <label for="" name="" style="grid-column: 3/4;">Estado: </label>
                <select class="form-control" style="grid-column: 4/5;" name="cmbEstado" ${desactivar } >
                	<c:forEach items="${estados }" var="es">
                		<c:if test="${us.estado == es.idEstado }">
                			 <option value="${es.idEstado }" selected>${es.descrip }</option>
                		</c:if>
                		<c:if test="${us.estado != es.idEstado }">
                			 <option value="${es.idEstado }" >${es.descrip }</option>
                		</c:if>
                	</c:forEach>
                	
                </select>
            </div>
            <div class="form-posicion">
                <label for="formFile" name="" class="form-label" style="grid-column: 1/2;">Foto: </label>
                <input name="fileFoto" id="formFile" class="form-control" type="file" style="grid-column: 2/5;" ${desactivar }>
            </div>
            <div style="margin: 0 auto; display: flex; justify-content: center;">
                <button type="submit" name="btnAccion" value="${accion }" class="btn btn-primary">${accion }</button>
            </div>
 
    </form>
    </div>
    
</body>
</html>