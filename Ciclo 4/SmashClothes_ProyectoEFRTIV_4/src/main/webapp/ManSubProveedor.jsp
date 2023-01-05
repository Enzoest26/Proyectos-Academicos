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
        <h2 style="text-align: center;">${titulo }</h2>
        <form action="crudProve" method="post" enctype='multipart/form-data'>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Codigo: </label>
                <input type="text" name="txtCodigo" style="grid-column: 2/3;" class="form-control" ${read } value="${prov.codProv }${codPro}" ${codRead } readonly="readonly">
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Representante: </label>
                <input name="txtRepre" id="" class="form-control" style="grid-column: 2/5; " ${read } value="${prov.represe }"> 
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Empresa: </label>
                <input name="txtEmpresa" id="" class="form-control" style="grid-column: 2/5; " ${read } value="${prov.empresa }"> 
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">RUC: </label>
                <input name="txtRUC" id="" class="form-control" style="grid-column: 2/3; " ${read } value="${prov.ruc }"> 
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Pais: </label>
                <input name="txtPais" id="" class="form-control" style="grid-column: 2/3; " ${read  } value="${prov.pais }"> 
                <label for="" name="" style="grid-column: 3/4; margin-left: 2rem;">Estado: </label>
                <select class="form-control" style="grid-column: 4/5;" name="cmbEstado" ${desactivar}>
                <option >....</option >
                <c:forEach items="${estados }" var="es">
                	<c:if test="${es.idEstado == p.estado}">
                		<option value="${es.idEstado }" selected>${es.descrip }</option>
                	</c:if>
                	<c:if test="${es.idEstado != p.estado}">
                		<option value="${es.idEstado }">${es.descrip }</option>
                	</c:if>
                </c:forEach>
                    
                </select>
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Correo: </label>
                <input type="email" name="txtCorreo" style="grid-column: 2/3;" class="form-control" ${read } value=${prov.correo }>
                <label for="" name="" style="grid-column: 3/4; margin-left: 2rem;">Telefono: </label>
                <input type="text"  name="txtTelefono" style="grid-column: 4/5;" class="form-control" ${read } value="${prov.tele }">
            </div>
            <div class="form-posicion">
                <label for="formFile" name="" class="form-label" style="grid-column: 1/2;">Logo: </label>
                <input name="fileLogo" id="formLogo" class="form-control" type="file" style="grid-column: 2/5;" ${desactivar }>
            </div>
            <div style="margin: 0 auto; display: flex; justify-content: center;">
                <button type="submit" name="btnAccion" value="${accion }" class="btn btn-primary">${accion}</button>
            </div>

        </form>
    </div>
</body>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
${msjError }
</html>