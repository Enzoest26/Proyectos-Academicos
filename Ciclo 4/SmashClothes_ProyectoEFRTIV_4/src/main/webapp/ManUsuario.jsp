<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuario</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <link rel="stylesheet" href="css/estilosEnzo.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
</head>
<body>
<nav>
    	<jsp:include page="menu2.jsp"></jsp:include>
    </nav>    <div>
        <h2 style="text-align: center; margin: 2rem auto">Mantenimiento de Usuario</h2>
        <form class="cont-bus-agre" action="accionUsuario" method="post">
			<button class="btn btn-primary" name="btnAccion" value="Registrar" style="font-size: larger;">
				<i class="bi bi-plus-circle"></i>
				    Agregar Usuario
			</button>
		</form>
        <div class="conteTabla">
            <table id="tablaProd" class="table tablaGeneral cell-border table-striped table-bordered"
                style="text-align: center;">
                <thead class="thead-dark">
                    <tr>
                        <th>Codigo</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>DNI</th>
                        <th>Edad</th>
                        <th>Tipo</th>
                        <th>Departamento</th>
                        <th>Correo</th>
                        <th style="text-align: center; width: 20%;">Accion</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${listadoUsu }" var="us">
                <tr>
                        <th scope="row">${us.codUsu }</th>
                        <td>${us.nombre }</td>
                        <td>${us.apellido }</td>
                        <td>${us.numDoc }</td>
                        <td>${us.edad }</td>
                        <td>${us.idtipo }</td>
                        <td>${us.depa }</td>
                        <td>${us.correo }</td>
                        <td style="margin: 0 auto;display: flex;justify-content: center;">
                            <form action="accionUsuario" method="post">
                                <input type="hidden" value="${us.codUsu }" name="txtCodigo">
                                <button class="btn btn-outline-primary" type="submit" value="Consultar" name="btnAccion"><i
                                        class="bi bi-search"></i></button>
                                <button class="btn btn-outline-warning" type="submit" value="Editar" name="btnAccion"><i
                                        class="bi bi-pencil-square"></i></button>
                                
                            </form>
                            <form action="crudUsuario" method="post">
                            <input type="hidden" value="${us.codUsu }" name="txtCodigo">
                            <button class="btn btn-outline-danger" type="submit" value="Eliminar" name="btnAccion"><i
                                        class="bi bi-trash-fill"></i></button>
                            </form>
                        </td>

                    </tr>
                
                </c:forEach>
                    

                </tbody>
            </table>
        </div>
    </div>
</body>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
${msjError }
<script>
    $(document).ready(function () {
        $('#tablaProd').DataTable({
            "pagingType": "simple_numbers",
            "language": {
                "lengthMenu": "Mostrar por: _MENU_ ",
                "zeroRecords": "No hay registros a mostrar",
                "info": "P�gina _PAGE_ de _PAGES_",
                "infoEmpty": "Error de conexion",
                "infoFiltered": "(filtered from _MAX_ total records)",
                "search": "Buscar: ",
                "paginate": {
                    previous: "Antes",
                    next: "Despues"
                }
            },
            "sDom": '<"top"fl>rt<"bottom"ip>'
        });
    });



</script>
<script>
let subMenu = document.getElementById("subMenu");
function toggleMenu(){
    subMenu.classList.toggle("open-menu");
}
</script>
</html>