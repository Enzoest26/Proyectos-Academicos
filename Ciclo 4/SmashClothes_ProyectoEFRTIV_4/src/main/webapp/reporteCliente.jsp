<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Reporte de Clientes</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/estilosReportes.css">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

<body>
    <nav>
    	<jsp:include page="menu2.jsp"></jsp:include>
    </nav>
    <form style="width: 95%; margin: 2rem auto;" class="contenedor-repo" action="reportes" action="post">
        <h2 style="text-align: center;">REPORTE DE CLIENTES</h2>
        <div class="cont-general">
            <div class="condi-cont">
                <label for="">Nombre: </label>
                <input type="text" name="txtNombreCondi" class="form-control">
                <label for="">F. Nacimiento: </label>
                <input type="date" name="txtFechaNa" class="form-control">
            </div>
            <div class="botones-grid">
                <div class="btn-repor" style="align-items: center;">
                    <button class="btn btn-primary" type="submit" name="btnCondi" value="cliente">Reportar</button>
                </div>
                <div class="btn-repor">
                    <button class="btn btn-default" type="submit" name="btnCondi" value="clientePdf"><i class="bi bi-filetype-pdf"></i></button>
                </div>

            </div>
        </div>

        <div style="margin: 2rem auto;">
            <table class="table table-dark">
                <thead>
                    <tr style="text-align: center;">
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Fecha Nacimiento</th>
                        <th>Sexo</th>
                    </tr>

                </thead>
                <tbody style="text-align: center;">
                    <!--codigo java-->
					<c:forEach items="${listadoCli }" var="c">
						<tr>
							<th class="align-middle" scope="row">${c.getCodigo() }</th>
							<td class="align-middle">${c.nombre }</td>
							<td class="align-middle">${c.apellido }</td>
							<td class="align-middle">${c.fechaNa }</td>
							<td class="align-middle">${c.sexo }</td>
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