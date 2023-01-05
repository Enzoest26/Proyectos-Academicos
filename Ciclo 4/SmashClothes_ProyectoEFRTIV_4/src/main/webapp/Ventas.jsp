<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ventas de Producto</title>
<link rel="stylesheet" href="css/estilosEnzo.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
</head>

<body>

	<div class="buscar-flotante-0 quitar">
		<div class="buscar-vuelo-0 quitar" style="width: 80%;">
			<div class="buscar-header">
				<h3>Buscar Cliente</h3>
				<button class="btn btn-danger buscar-cerrar"
					onclick="cerrarBusqueda(0)">
					<i style="font-size: 1.5rem;" class="bi bi-x-square"></i>
				</button>
			</div>
			<table id="prod">
				<thead>
					<tr>
						<th scope="col">Codigo</th>
						<th scope="col">Nombre</th>
						<th scope="col">Stock</th>
						<th scope="col">Precio</th>
						<th scope="col">Accion</th>
					</tr>
				</thead>
				<tbody>

					<%
					int i = 0;
					%>
					<c:forEach items="${lstProdDispo }" var="pro">

						<tr>
							<td name="codigo">${pro.codProd }</td>
							<td name="nombre">${pro.nombre }</td>
							<td name="stock">${pro.getStock() }</td>
							<td name="precio">${pro.precio }</td>
							<td>
								<button name="btnEscoger-0" type="button"
									onclick="agregarProd(<%=i%>)" class="btn btn-primary" value="">
									Seleccionar</button>
							</td>
						</tr>
						<%
						if(i == 3){
							i = 0;
						}
						i += 1;
						%>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>


	<div class="buscar-flotante-1 quitar">
		<div class="buscar-vuelo-1 quitar"  style="width: 80%;">
			<div class="buscar-header">
				<h3>Buscar Producto</h3>
				<button class="btn btn-danger buscar-cerrar"
					onclick="cerrarBusqueda(1)">
					<i style="font-size: 1.5rem;" class="bi bi-x-square"></i>
				</button>
			</div>
			<table id="cliente">
				<thead>
					<tr>
						<th scope="col">Codigo</th>
						<th scope="col">Nombre</th>
						<th scope="col">Apellido</th>
						<th scope="col">Num.Doc.</th>
						<th scope="col">Accion</th>
					</tr>
				</thead>
				<tbody>

					<%
					int j = 0;
					%>
					<c:forEach items="${listadoCli }" var="c">

						<tr>
							<input type="hidden" value="${c.getCodigo() }"
								name="txtCodCliente">
							<td name="codCliente">${c.getCodigo() }</td>
							<td name="NombreCli">${c.nombre }</td>
							<td name="ApellidoCli">${c.apellido }</td>
							<td name="NumDocCli">${c.numDoc }</td>
							<td>
								<button name="btnEscoger-0" type="button"
									onclick="agregarCliente(<%=j%>)" class="btn btn-primary"
									value="">Seleccionar</button>
							</td>
						</tr>
						<%
						if(j == 3){
							j = 0;
						}
						j += 1;
						%>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
	<nav>
    	<jsp:include page="menu2.jsp"></jsp:include>
    </nav>

	<div style="width: 90%; margin: auto auto;">

		<h1>Ventas de Productos</h1>
		<form action="ventaController" method="post">
			<div style="background-color: white" class="back-venta-info">
				<div class="form-posicion">
					<label for="" name="" style="grid-column: 1/2;">Cliente: </label> <input
						name="txtNombreCli" id="" class="form-control"
						style="grid-column: 2/4;" readonly="readonly">
					<div style="grid-column: 4/5;">
						<button type="button" class="btn btn-primary btn-venta"
							onclick="buscarVuelo(1)">Buscar</button>
					</div>

				</div>
				<div class="form-posicion" style="" >
						<label for="" name="" style="grid-column: 1/2;">Tipo
							Boleta: </label> 
							<select name="cmbTipoBoleta" class="form-control" style="grid-column: 2/3;">
								<option>Boleta</option>
								<option>Factura</option>
							</select>
							 <label for="" name=""
							style="grid-column: 3/4; margin-left: 2rem;">N°
							Comprobante: </label> <input type="text" name="txtComprobante"
							style="grid-column: 4/5;" class="form-control" value="${codigo }" readonly="readonly">
					</div>
				</div>
				<div class="back-venta-info">
					
				<div class="form-posicion" name="cambiar">
					<label for="" name="" style="grid-column: 1/2;">Nombre
						Producto: </label> <input type="text" name="txtNombreProd"
						style="grid-column: 2/4;" class="form-control" readonly="readonly">
					<div style="grid-column: 4/5;">
						<button type="button" class="btn btn-primary btn-venta"
							style="grid-column: 4/5;" onclick="buscarVuelo(0)">Buscar</button>
					</div>

				</div>
				<div class="form-posicion-6">
					<input type="hidden" name="txtCodigo"> <label for=""
						name="" style="grid-column: 1/2;">Cantidad: </label> <input
						type="number" name="txtCantidad" style="grid-column: 2/3;"
						class="form-control"> <label for="" name=""
						style="grid-column: 3/4; margin-left: 2rem;">Stock: </label> <input
						type="text" name="txtStock" style="grid-column: 4/5;"
						class="form-control" readonly="readonly"> <label for=""
						name="" style="grid-column: 5/6; margin-left: 2rem;">Precio:
					</label> <input type="text" name="txtPrecio" style="grid-column: 6/7;"
						class="form-control" readonly="readonly">
				</div>
				<div class="form-posicion">
					<button type="button" onclick="agregarFila()"
						class="btn btn-primary" style="grid-column: 1/2;">Agregar</button>
				</div>
			
		</div>
			<div class="conteTabla" style="width: 100%">
				<table id="tablaProd"
					class="table tablaGeneral cell-border table-striped table-bordered"
					style="text-align: center;">
					<thead class="thead-dark">
						<tr>
							<th>Codigo</th>
							<th>Nombre</th>
							<th>Cantidad</th>
							<th>Precio Venta</th>
							<th style="text-align: center; width: 20%;">Accion</th>
						</tr>
					</thead>
					<tbody id="cuerpo">

					</tbody>
				</table>
			</div>
			<div class="form-posicion" style="margin-top: 4rem;">
				<button type="submit" class="btn btn-primary" name="btnAccion"
					value="Vender" style="grid-column: 3/3;">Vender</button>
			</div>
		</form>

	</div>

</body>

<script>
    $(document).ready(function () {
        $('#prod').DataTable({
            "pagingType": "simple_numbers",
            "pageLength": 3,
            "language": {
                "lengthMenu": "Mostrar por: _MENU_ ",
                "zeroRecords": "No hay registros a mostrar",
                "info": "Página _PAGE_ de _PAGES_",
                "infoEmpty": "Error de conexion",
                "infoFiltered": "(filtered from _MAX_ total records)",
                "search": "Buscar: ",
                "paginate": {
                    previous: "Antes",
                    next: "Despues"
                }
            },
            "sDom": '<"top"f>rt<"bottom"ip>'
        });
    });
    $(document).ready(function () {
        $('#cliente').DataTable({
            "pagingType": "simple_numbers",
            "pageLength": 3,
            "language": {
                "lengthMenu": "Mostrar por: _MENU_ ",
                "zeroRecords": "No hay registros a mostrar",
                "info": "Página _PAGE_ de _PAGES_",
                "infoEmpty": "Error de conexion",
                "infoFiltered": "(filtered from _MAX_ total records)",
                "search": "Buscar: ",
                "paginate": {
                    previous: "Antes",
                    next: "Despues"
                }
            },
            "sDom": '<"top"f>rt<"bottom"ip>'
        });
    });


</script>
<script>
    var codigo = "";
    var nombre = "";
    var stock = 0;
    var precio = 0.0;
    var cantidad = 0;
    function agregarCliente(index){
    	var codCliente =  document.getElementsByName("codCliente")[index].textContent;
    	var nombreCli =  document.getElementsByName("NombreCli")[index].textContent;
    	var apellidoCli =  document.getElementsByName("ApellidoCli")[index].textContent;
    	var numDoc =  document.getElementsByName("NumDocCli")[index].textContent;
    	 document.getElementsByName("txtNombreCli")[0].value = nombreCli;
    	 cerrarBusqueda(1);
    }
    function agregarProd(index) {
        codigo = document.getElementsByName("codigo")[index].textContent;
        nombre = document.getElementsByName("nombre")[index].textContent;
        stock = document.getElementsByName("stock")[index].textContent;
        precio = document.getElementsByName("precio")[index].textContent;


        document.getElementsByName("txtNombreProd")[0].value = nombre;
        document.getElementsByName("txtPrecio")[0].value = precio;
        document.getElementsByName("txtStock")[0].value = stock;
        document.getElementsByName("txtCodigo")[0].value = codigo;

        cerrarBusqueda(0);
    }

    //? Parte de las buscar vuelo

    function buscarVuelo(index) {
        if (index == 0) {
            let buscar_flotante = document.getElementsByClassName("buscar-flotante-" + index);
            let buscar_cont = document.getElementsByClassName("buscar-vuelo-" + index);
            if (buscar_cont[0].classList.contains("quitar")) {
                buscar_flotante[0].classList.remove("quitar");
                buscar_cont[0].classList.remove("quitar")
            } else {
            }
        }
        else {
            let buscar_flotante = document.getElementsByClassName("buscar-flotante-" + index);
            let buscar_cont = document.getElementsByClassName("buscar-vuelo-" + index);
            if (buscar_cont[0].classList.contains("quitar")) {
                buscar_flotante[0].classList.remove("quitar");
                buscar_cont[0].classList.remove("quitar")
            } else {

            }
        }
    }

    function cerrarBusqueda(index) {
        if (index == 0) {
            let buscar_flotante = document.getElementsByClassName("buscar-flotante-" + index);
            let buscar_cont = document.getElementsByClassName("buscar-vuelo-" + index);
            if (buscar_flotante[0].classList.contains("quitar")) {

            } else {
                buscar_flotante[0].classList.add("quitar");
                buscar_cont[0].classList.add("quitar")
            }
        } else {
            let buscar_flotante = document.getElementsByClassName("buscar-flotante-" + index);
            let buscar_cont = document.getElementsByClassName("buscar-vuelo-" + index);
            if (buscar_flotante[0].classList.contains("quitar")) {

            } else {
                buscar_flotante[0].classList.add("quitar");
                buscar_cont[0].classList.add("quitar")
            }
        }
    }
    var agregar = 0;
    function agregarFila() {
        cantidad = document.getElementsByName("txtCantidad")[0].value;
        var cuerpo = document.getElementById("cuerpo");
        cuerpo.innerHTML += "<tr id = 'fila" + agregar + "'> " +
        	"<input type='hidden' name='rowCodigo' value='"+codigo+"''>" + 
            "<td>" + codigo + " </ td>" +
            "<td>" + nombre + "</td>" +
            "<input type='hidden' name='rowCantidad' value='"+cantidad+"''>" +
            "<td>" + cantidad + " </td >" +
            "<td> " + precio + "</td >" +

            "<td> <button type='button' class='btn btn-primary' onclick='eliminarFila(" + agregar + ")'>Eliminar</button></td >" +
            "</tr > ";
        agregar += 1;
    }
    function eliminarFila(quitar) {
        var fila = document.getElementById("fila" + quitar);
        fila.remove();
    }
    let subMenu = document.getElementById("subMenu");

    function toggleMenu(){
        subMenu.classList.toggle("open-menu");
    }
</script>

<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
${mensaje }
</html>