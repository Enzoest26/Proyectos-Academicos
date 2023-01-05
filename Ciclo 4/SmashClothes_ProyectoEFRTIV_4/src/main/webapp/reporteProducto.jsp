<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">


<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Reporte de Productos</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/estilosReportes.css">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

<body>
    <nav>
    	<jsp:include page="menu2.jsp"></jsp:include>
    </nav>
    <form style="width: 95%; margin: 2rem auto;" class="contenedor-repo" action="reportes" method="post">
        <h2 style="text-align: center;">REPORTE DE PRODUCTOS</h2>
        <div class="cont-general">
            <div class="condi-cont">
                <label for="">F. Publicacion: </label>
                <input type="date" name="txtFechaCondi" class="form-control">
                <label for="">Categoria: </label>
                <select name="cmbCategoriaCondi" id="" class="form-control">
                    <!--Codigo Java-->
                    <option value="1">...</option>
						<c:forEach items="${listadoCate }" var="ca">
							<option value="${ca.idCate }">${ca.descrip }</option>
						</c:forEach>
                </select>
            </div>
            <div class="botones-grid">
                <div class="btn-repor" style="align-items: center;">
                    <button class="btn btn-primary" type="submit" name="btnCondi" value="producto"><i class="bi bi-clipboard-fill"></i></button>
                </div>
                <div class="btn-repor">
                    <button class="btn btn-default" type="submit" name="btnCondi" value="productopdf"><i class="bi bi-filetype-pdf"></i></button>
                </div>

            </div>
        </div>

        <div style="margin: 2rem auto;">
            <table class="table table-dark">
                <thead>
                    <tr style="text-align: center;">
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>Fecha Publi.</th>
                        <th>Categoria</th>
                        <th>Stock</th>
                        <th>Proveedor</th>
                    </tr>
                </thead>
                <tbody>
                    <!--codigo java-->
						<c:forEach items="${ listadoProd}" var="p">
							<tr>
								<td>${p.codProd }</td>
								<td>${p.nombre}</td>
								<td>${p.fecha}</td>
								<c:forEach items="${listadoCate }" var="ca">
									<c:if test="${ca.idCate == p.idCate }">
										<td>${ca.descrip }</td>
									</c:if>
								</c:forEach>
								
								<td>${p.stock }</td>
								<c:forEach items="${listadoProv }" var="pr">
									<c:if test="${pr.codProv == p.codProvee }">
										<td>${pr.empresa }</td>
									</c:if>
								</c:forEach>
							</tr>
						</c:forEach>
                </tbody>
            </table>
        </div>
    </form>
</body>
<script>
let subMenu = document.getElementById("subMenu");
function toggleMenu(){
    subMenu.classList.toggle("open-menu");
}
</script>
</html>