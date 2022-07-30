<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar productos</title>

<!-- BOOTSTRAP CSS -->
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body>

	<!-- BARRA DE NAVEGACION -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#">Productos</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Usuario: <c:out
								value="${requestLogin}"></c:out></a></li>
					<li class="nav-item"><a class="nav-link"
						href="listarProductos">Listar Productos</a></li>
					<li class="nav-item"><a class="nav-link"
						href="agregarProducto">Agregar Producto</a></li>
					<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- SECCION FORMULARIO MODIFICAR PRODUCTOS -->
	<section class="container mt-5">
	
	<form action="modificarProducto" method="POST">
		<input type="hidden" class="form-control" id="exampleInputId" name="id_producto" value="${producto.getId()}" aria-describedby="id" required>
		<div class="mb-3">
			<label for="exampleInputNombre" class="form-label">Nombre</label> 
			<input type="text" class="form-control" id="exampleInputNombre" name="nombre_producto" value="${producto.getNombre()}" aria-describedby="nombre" required>
		</div>
		<div class="mb-3">
			<label for="exampleInputDescripcion" class="form-label">Descripcion</label>
			<input type="text" class="form-control" id="exampleInputDescripcion" name="descripcion_producto" value="${producto.getDescripcion()}" required>
		</div>
		<div class="mb-3">
			<label for="exampleInputPrecio" class="form-label">Precio</label>
			<input type="text" class="form-control" id="exampleInputPrecio" name="precio_producto" value="${producto.getPrecio()}" required>
		</div>
		<div class="mb-3">
			<select name="id_categoria" required="required">
				<c:forEach items="${categorias}" var="temp">
					<option value="${temp.getId()}">
						<c:out value="${temp.getNombre()}"></c:out> 
					</option>
				</c:forEach>
			</select>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	
	</section>

	<!-- BOOTSTRAP POPPER -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
		integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
		crossorigin="anonymous"></script>
	<!-- BOOTSTRAP JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
		integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
		crossorigin="anonymous"></script>
</body>
</html>