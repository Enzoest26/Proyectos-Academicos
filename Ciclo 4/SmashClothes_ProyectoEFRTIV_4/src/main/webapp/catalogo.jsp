<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Smash Clothes</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="css/inicio.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
        
   
    <%-- 
    <header>
        <div class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container" >
                <a href="#" class="navbar-brand">
                    <strong>Smash Clothes</strong>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarHeader">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a href="#" class="nav-link active">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a href="#" class="nav-link">Nosotros</a>
                        </li>
                    </ul>
                    <a href="carrito.php" class="btn btn-primary">Catalogo</a>
                </div>
            </div>
        </div>
    </header>--%>
    <br> 
	<div class="container mt-1">
		<h1>Colecciones</h1>
	</div>
	<main>
		<div class="container" >
            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-2">
                <div class="col">
                    <div  class="card shadow-sm">
                       <a href="camisa.jsp"> <img src="img/camisetas.jpg"  margin-bottom="10px" height="650px" width="425px" ></a>
                        <div class="card-body">
                            <h5 class="card-title">Camisas Oversize -></h5>                                                        
                        </div> 
                    </div>
                </div> 
                
                <div class="col">
                    <div class="card shadow-sm">
                        <a href="gorra.jsp"><img src="img/gorras.jpg" margin-bottom="10px" height="650px" width="425px"></a>
                        <div class="card-body">
                            <h5 class="card-title">Gorras -></h5>                                                   
                        </div>
                    </div>
                </div>
                
                <div class="col">
                    <div class="card shadow-sm">
                        <a href="polo.jsp"><img src="img/polos.jpg" margin-bottom="10px" height="650px" width="425px"></a>
                        <div class="card-body">
                            <h5 class="card-title">Polos Oversize -></h5>                                             
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow-sm">
                        <a href="jeans.jsp"><img src="img/jeans.jpg" margin-bottom="10px" height="650px" width="425px"></a>
                        <div class="card-body">
                            <h5 class="card-title">Jeans -></h5>                                             
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow-sm">
                        <a href="pantalon.jsp"><img src="img/pantalones.jpg" margin-bottom="10px" height="650px" width="425px"></a>
                        <div class="card-body">
                            <h5 class="card-title">Pantalones -></h5>                                             
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow-sm">
                        <a href="short.jsp"><img src="img/shorts.jpg" margin-bottom="10px" height="650px" width="425px"></a>
                        <div class="card-body">
                            <h5 class="card-title">Shorts -></h5>                                             
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    
	<jsp:include page="footer.jsp"></jsp:include>
	
    <script>
        let subMenu = document.getElementById("subMenu");

        function toggleMenu(){
            subMenu.classList.toggle("open-menu");
        }
    </script>
   
	<script src="js/index.js"></script>
  <%-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>--%>
    

    
</body>

</html>