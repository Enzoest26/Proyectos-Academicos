<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="css/estilo_listado.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>


	<main style="width: 95%;margin: 90px 90px;display:flex; flex-direction: row;">
		
		<%-- validar si hay informacion en el carro de compras --%>
		<c:if test="${carro.size() == 0 }">
		<div class="container">
			<h1><strong>Tu carrito esta vacío</strong></h1>
			<p>Haga clic en Catálogo para buscar productos</p>
			<img alt="" src="img/iconos/vacio.jpg" style="width: 300px;height: 300px;display: flex;margin-bottom: 20px">
			<a href="verCatalogo" class="btn btn-dark">
				Catálogo
			</a>
		</div>
		</c:if>
		
		<c:if test="${carro.size() != 0 }">
			<div style="margin-top: 10px;width: 70%;display: flex;flex-direction: column;">
				<h1 style="margin-left: 50px;margin-bottom: 30px"><strong>Carrito de compra</strong></h1>
				<%-- tabla con el listado del carro de compra --%>
				<table class="table table-hover">
					<thead class="thead-dark">
						<tr>
							<th scope="col"></th>
							<th scope="col">Producto</th>
							<th scope="col">Precio</th>
							<th scope="col">Cantidad</th>
							<th scope="col">SubTotal</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<fmt:setLocale value="es_PE" />
						<c:forEach items="${carro }" var="d">
							<tr>
								<th>
									<img alt="" src="img/productos/${d.idprod }.jpg" class="imglst">
								</th>
								<td>${d.nomprod }</td>
								<td><fmt:formatNumber type="currency" value="${d.preciovta }"></fmt:formatNumber></td>
								<td>${d.cantidad }</td>
								<td><fmt:formatNumber type="currency" value="${d.importe }"></fmt:formatNumber></td>
								<td>
									<form action="venta" method="post">
										<input type="hidden" name="codigo" value="${d.idprod}">
										<button name="opcion" value="eliminar" class="btn btn-outline-dark btn-sm">
											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
  												<path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
											</svg>
										</button>
									</form>
								</td>
							</tr>
						</c:forEach>
						</tbody>
				</table>
				
				
				<br> 
				<a href="verCatalogo" class="btn btn-dark" style="width: 20%;margin-left: 40%">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-counterclockwise" viewBox="0 0 16 16">
  					<path fill-rule="evenodd" d="M8 3a5 5 0 1 1-4.546 2.914.5.5 0 0 0-.908-.417A6 6 0 1 0 8 2v1z"/>
  					<path d="M8 4.466V.534a.25.25 0 0 0-.41-.192L5.23 2.308a.25.25 0 0 0 0 .384l2.36 1.966A.25.25 0 0 0 8 4.466z"/>
				</svg>
					Continuar comprando
				</a>
			</div>
		
			<div class="lista2" style="margin-top: 20px;height: 120vh;position: sticky;top: 0;right: 0;">
			<div class="total" style="margin: 70px 50px;width: 80%;border: 1px solid #dddddd;display: flex;flex-direction: column;border-radius: 10px;">
				<div class="compra" style="margin: 10px 20px;display: flex;flex-direction: column;align-items: flex-start;justify-content: center;">
					<h3 style="margin-bottom: 20px;"><strong>Resumen de tu pedido</strong></h3>
					<p>Envío: <strong>GRATIS</strong></p>
					<p>Total de artículos: <strong>(${cantArticulos })</strong></p>
					<p>Total a pagar: </p>
					<p style="font-size: 30px;"><strong><fmt:formatNumber type="currency" value="${subTotalVenta }"></fmt:formatNumber></strong></p>
					<form action="venta" method="post">
					<button name="opcion" value="finalizar" class="btn btn-outline-success" style="margin-bottom: 15px">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle" viewBox="0 0 16 16">
  											<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
  											<path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z"/>
										</svg> Procesar compra 
					</button>
					</form>
				</div>
				<br>
			</div>

		</div>
			
		</c:if>
		${mensaje }
		</main>
	
</body>
</html>