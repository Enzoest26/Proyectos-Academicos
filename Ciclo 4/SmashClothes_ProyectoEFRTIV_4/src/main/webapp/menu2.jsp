<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css/inicio.css">
<img src="img/logo-texto.png" class="logo">
            <ul>
            	<c:if test="${u!=null }">
            		<c:if test="${u.tipo == 1 }">
		            		<li>
							<form action="irA" method="get">
								<button type="submit" value="usuario" name="btnEnlace" style="margin-left: 10px; border: none" class="btn btn-outline-light">
									Usuario
								</button>
							</form>
						</li>
						<li>
							<form action="irA" method="get">
								<button type="submit" value="proveedor" name="btnEnlace" style="margin-left: 10px; border: none" class="btn btn-outline-light">
									Proveedor
								</button>
							</form>
						</li>
						<li>
							<form action="irA" method="get">
								<button type="submit" value="clientes" name="btnEnlace" style="margin-left: 10px; border: none" class="btn btn-outline-light">
									Clientes
								</button>
							</form>
						</li>
						<li>
							<form action="irA" method="get">
								<button type="submit" value="productos" name="btnEnlace" style="margin-left: 10px; border: none" class="btn btn-outline-light">
									Productos
								</button>
							</form>
						</li>
						<li>
							<form action="irA" method="get">
								<button type="submit" value="reporteCliente" name="btnEnlace" style="margin-left: 10px; border: none" class="btn btn-outline-light">
									Reporte Cliente
								</button>
							</form>
						</li>
						<li>
							<form action="irA" method="get">
								<button type="submit" value="reporteProducto" name="btnEnlace" style="margin-left: 10px; border: none" class="btn btn-outline-light">
									Reporte Producto
								</button>
							</form>
						</li>
						<li>
							<form action="irA" method="get">
								<button type="submit" value="ventas" name="btnEnlace" style="margin-left: 10px; border: none" class="btn btn-outline-light">
									Nueva Venta
								</button>
							</form>
						</li>
            		</c:if>
            	
            		<c:if test="${u.tipo == 5 }">
	            		<li>
						<form action="irA" method="get">
							<button type="submit" value="ventas" name="btnEnlace" style="margin-left: 10px; border: none" class="btn btn-outline-light">
								Nueva Venta
							</button>
						</form>
						</li>
						<li>
                		<a href="carrito.jsp" target="myFrame">
							<img src="img/iconos/delivery_logo.png" style="width: 20px;cursor: pointer;margin-top: 9px">
							<span class="badge badge-light">${cantArticulos }</span>
						</a> 
                	</li>
            		</c:if>
            		<c:if test="${u.tipo == 4 }">
            		<li>
						<form action="irA" method="get">
							<button type="submit" value="ventas" name="btnEnlace" style="margin-left: 10px; border: none" class="btn btn-outline-light">
								Nueva Venta
							</button>
						</form>
						</li>
						<li>
                		<a href="carrito.jsp" target="myFrame">
							<img src="img/iconos/delivery_logo.png" style="width: 20px;cursor: pointer;margin-top: 9px">
							<span class="badge badge-light">${cantArticulos }</span>
						</a> 
                	</li>
            		</c:if>
            		<c:if test="${u.tipo == 3 }">
            			<li>
							<form action="irA" method="get">
								<button type="submit" value="reporteProducto" name="btnEnlace" style="margin-left: 10px; border: none" class="btn btn-outline-light">
									Reporte Producto
								</button>
							</form>
						</li>
						<li>
							<form action="irA" method="get">
								<button type="submit" value="reporteCliente" name="btnEnlace" style="margin-left: 10px; border: none" class="btn btn-outline-light">
									Reporte Clientes
								</button>
							</form>
						</li>
            		</c:if>
            		<c:if test="${u.tipo == 2 }">
	            		<li><a href="inicio.jsp" target="myFrame">Inicio</a></li>
	            		<li><a href="verCatalogo" target="myFrame">Catálogo Oficial</a></li>
	            		<li>
                		<a href="carrito.jsp" target="myFrame">
							<img src="img/iconos/delivery_logo.png" style="width: 20px;cursor: pointer;margin-top: 9px">
							<span class="badge badge-light">${cantArticulos }</span>
						</a> 
                	</li>
            		</c:if>
            	</c:if>
            
            
				<c:if test="${u == null }">
						<li><a href="inicio.jsp" target="myFrame">Inicio</a></li>
	            		<li><a href="catalogo.jsp" target="myFrame">Catálogo</a></li>
				</c:if>
	<!--  
				<c:if test="${u.tipo != 1 && u!=null}">
                	<li>
                		<a href="carrito.jsp" target="myFrame">
							<img src="img/iconos/delivery_logo.png" style="width: 20px;cursor: pointer;margin-top: 9px">
							<span class="badge badge-light">${cantArticulos }</span>
						</a> 
                	</li>
                	
                </c:if>
                -->
            </ul>
            
            <img src="img/user.png" class="user-pic" onclick="toggleMenu()">

            <div class="sub-menu-wrap" id="subMenu">
                <div class="sub-menu">
                    <div class="user-info">
                        <img src="img/perfil/${u.codigo }.png">
                        <h3>${u.nombre} ${u.apellido}</h3>
                        <br>
                    </div>
                    <hr>
                    
					<%-- validar que solo se muestre la opcion de actualizacion si hay un usuario --%>
					<h4 style="text-align: center;margin-left: 10px">${u.usuario }</h4>
					
					<c:if test="${u != null }">
	                    <a href="#" class="sub-menu-link">
	                        <img src="img/iconos/profile.png" >
	                        <p>Editar Perfil</p>
	                        <span>></span>
	                    </a>
                    </c:if>
                    
                    <c:if test="${u != null }">
	                    <a href="https://support.google.com/?hl=es" class="sub-menu-link">
	                        <img src="img/iconos/help.png" >
	                        <p>Ayuda</p>
	                        <span>></span>
	                    </a>
                    </c:if>
                    
                    <c:if test="${u == null }">
	                    <a href="logout" class="sub-menu-link">
	                        <img src="img/inicio.png" >
	                        <p> Iniciar Sesión</p>
	                        <span>></span>
	                    </a>
                    </c:if>
                    
                    <c:if test="${u != null }">
	                    <a href="logout" class="sub-menu-link">
	                        <img src="img/iconos/logout.png" >
	                        <p> Cerrar Sesión</p>
	                        <span>></span>
	                    </a>
                    </c:if>
                    
                </div>
            </div>