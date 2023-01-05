<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%-- importar la libreria JSTL para FORMATOS --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catálogo | SmashClothes</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!--  estilos de Datatable -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/inicio.css">
<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<section style="width: 90%; margin-left: 100px">
	<h1>Catálogo 2022-2023</h1>
	<br>
		<fmt:setLocale value="es_PE" />
		<div class="row">
		<c:forEach items="${lstProductos }" var="p">
		<div class="col-sm-4">
			<div class="col">
				<div class="card shadow-sm">
					<img class="card-img-top" src="img/productos/${p.codProd}.jpg" height="576px" style="padding: 10%">
					<div class="card-body">
						<h5 class="card-title">${p.nombreProduct }</h5>
						<p class="card-text">
						${p.descripcion }
						<br>
						<strong>
							<fmt:formatNumber type="currency" value="${p.precio }"></fmt:formatNumber>
						</strong>
						</p>
						<form action="add" method="post">
							<input type="hidden" name="codigo" value="${p.codProd }">
							<button type="submit" name="btnAccion" value="add" class="btn btn-outline-success">Ver Artículo</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		</c:forEach>
		</div>
	</section>
		
<jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script>
	$(document).ready(function() {
		$('#myTable').DataTable({
			"language" : {
				"lengthMenu" : "Mostrando _MENU_ ",
				"zeroRecords" : "No hay registros a mostrar",
				"info" : "Pág _PAGE_ de _PAGES_",
				"infoEmpty" : "No records available",
				"infoFiltered" : "(filtered from _MAX_ total records)"
			}
		});
	});
</script>
<script type="text/javascript">
	var x = document.getElementById('editar');
	// x.addEventListener('mouseover', cambia);
	x.setAttribute('onmouseover', 'cambia()');
	x.setAttribute('onmouseover', 'regresa()');
	function cambia(){
		x.setAttribute('src', 'img/iconos/carro2.png');
	}
	function regresa(){
		x.setAttribute('src', 'img/iconos/carro1.png');
	}
</script>
</html>