<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalle Producto | SmashClothes</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="css/inicio.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<br>
    <main>
        <div class="container">
            <div class="row">
                <div class="col-md-6 order-md-1">
                    <div id="carouselImages" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <!--Imagen-->
                            <div class="carousel-item active">
                                <img alt="" src="img/productos/${p.codProd }.jpg" height="576px"> 
                            </div>
                        </div>
                    </div>
                </div>

				<div class="col-md-6 order-md-2">
				<form action="venta" method="post">
                    <h2>${p.nombre }</h2>
                	<label><strong>Cod producto</strong><p><del>${p.codProd }</del></p></label>
                    <fmt:setLocale value="es_PE"/>
                    <h2><fmt:formatNumber type="currency" value="${p.precio }"></fmt:formatNumber><small class=" text-success"> -20%</small></h2>
                	<br>
                	<p>
                		<b>Más detalles de este producto</b>
                	</p>
                	<ul>
                		<li>${p.descrip }</li>
                	</ul>
                
                	<div class="col-3 my-3">
                    	<input class="form-control" name="cantidad" type="number" min="1" max="10" value="1">
                	</div>
                
                	<div class="d-grid gap-3 col-7">
                    	<button class="btn btn-success" type="submit" name="opcion" value="agregar">
                    		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-fill" viewBox="0 0 16 16">
  								<path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
							</svg> 
						 	Agregar al carrito 
                    	</button>
                	</div>
                </form>
           		</div>
           	
           	
            </div>
        </div>
</main>

</body>
<script>
        let subMenu = document.getElementById("subMenu");

        function toggleMenu(){
            subMenu.classList.toggle("open-menu");
        }
    </script>
</html>