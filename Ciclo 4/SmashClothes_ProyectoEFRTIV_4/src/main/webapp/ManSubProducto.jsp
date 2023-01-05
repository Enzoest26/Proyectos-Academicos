<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
        <form action="crudProd" method= "post" enctype='multipart/form-data'>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Codigo: </label>
                <input type="text" name="txtCodigo" style="grid-column: 2/3;" class="form-control" value="${p.codProd }${codPro}" ${read } ${codRead } readonly="readonly">
                <label for="" name="" style="grid-column: 3/4; margin-left: 2rem;">Fecha: </label>
                <input type="date" name="txtFecha" style="grid-column: 4/5;" class="form-control" value="${p.fecha }" ${read } >
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Descripcion: </label>
                <textarea name="txtDescrip" id="" cols="60" rows="5" class="form-control" style="grid-column: 2/5; " ${read }> ${p.descrip }</textarea>
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Categoria: </label>
                <select class="form-control" style="grid-column: 2/3;" name="cmbCategoria" ${desactivar}>
                <option >....</option >
                
                <c:forEach items="${categorias }" var="cate">
                	<c:if test="${cate.idCate == p.idCate}">
                		<option value="${cate.idCate }" selected>${cate.descrip}</option>
                	</c:if>
                	<c:if test="${cate.idCate != p.idCate}">
                		<option value="${cate.idCate }">${cate.descrip}</option>
                	</c:if>
                </c:forEach>
                    
                </select>
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
                <label for="" name="" style="grid-column: 1/2;">Stock: </label>
                <input type="number" name="txtStock" style="grid-column: 2/3;" class="form-control" ${read } value="${p.stock }">
                <label for="" name="" style="grid-column: 3/4; margin-left: 2rem;">Precio: </label>
                
                <input type="text"  value="${p.precio }" name="txtPrecio" style="grid-column: 4/5;" class="form-control" ${read } >
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Nombre Corto: </label>
                <input name="txtNombre" id="" class="form-control" style="grid-column: 2/5; " ${read } value="${p.nombre }"> 
            </div>
            <div class="form-posicion">
                <label for="formFile" name="" class="form-label" style="grid-column: 1/2;">Fotos: </label>
                <input name="fileFoto" id="formFile" class="form-control" type="file" style="grid-column: 2/5;" ${desactivar}>
            </div>
            <div class="form-posicion">
                <label for="" name="" style="grid-column: 1/2;">Proveedor: </label>
                <select class="form-control" style="grid-column: 2/4;" name="cmbProveedor"   ${desactivar}>
                <option >....</option >
                <c:forEach items="${lstProve }" var="prov">
                	<c:if test="${prov.codProv == p.codProvee }">
                		<option value="${prov.codProv }" selected>${prov.empresa }</option>
                	</c:if>
                	<c:if test="${prov.codProv != p.codProvee }">
                		<option value="${prov.codProv }">${prov.empresa }</option>
                	</c:if>
                </c:forEach>
                </select>
            </div>
            <div style="margin: 0 auto; display: flex; justify-content: center;">
                <button type="submit" name="btnAccion" value="${accion }" class="btn btn-primary">${accion }</button>
            </div>

        </form>
    </div>

</body>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
${msjError }
</html>