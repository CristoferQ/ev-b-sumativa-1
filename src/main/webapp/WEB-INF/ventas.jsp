<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Tienda virtual</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="/">Inicio</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/usuarios">Usuarios</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/productos">Productos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="/ventas">Ventas</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
 <div class="row justify-content-center text-center">
        <div class="col-md-5">
            <h1>Modificar venta</h1><br>
            <table class="table">
			  <thead>
			    <tr>
			      <th>Id</th>
			      <th>Producto</th>
			      <th>Cantidad</th>
			      <th>Total</th>
			      <th>Editar</th>
			      <th>Eliminar</th>
			    </tr>
			  </thead>
			  <tbody>
<c:forEach items="${ventasLIST}" var="i">
	<tr>
		<td>${i.id}</td>
		<td>${i.producto}</td>
		<td>${i.cantidad}</td>
		<td>${i.total}</td>
		<td><form method="get" action="/ventas/traer/${i.id}">
    <button type="submit" class="btn btn-warning">Rellenar campos para edicion</button>
</form></td>
		<td><form method="get" action="/ventas/eliminar/${i.id}">
    <button type="submit" class="btn btn-danger">Eliminar</button>
</form></td>
	</tr>
</c:forEach>
			  </tbody>
			</table>
			</div>
			<div class="row">
			<div class="col-md-6">
			<h1>Agregar venta</h1><br>
            <form action="/ventas/agregar" method="POST">
                <div class="mb-3">
                    <label for="productoForm" class="form-label" >Producto</label>
                    <input class="form-control" type="text" id="productoForm" name="productoForm" placeholder="Ingresa el producto" required>
                </div>
                <div class="mb-3">
                    <label for="cantidadForm" class="form-label" >Cantidad</label>
                    <input class="form-control" type="number" id="cantidadForm" name="cantidadForm" placeholder="Ingresa la cantidad" required>
                </div>
                <div class="mb-3">
                    <label for="totalForm" class="form-label" >Total</label>
                    <input class="form-control" type="number" id="totalForm" name="totalForm" placeholder="Ingresa el total" required>
                </div>
                 <input type="reset" value="Limpiar" class="btn btn-warning">
                <button type="submit" class="btn btn-primary">Añadir</button>
              </form>
              </div>
              <div class="col-md-6">
              
             <c:if test="${traerProducto != null && traerCantidad != null && traerTotal != null}">
             	<h1>Editar venta</h1><br>
            <form action="/ventas/editar" method="POST">
            <div class="mb-3">
                    <label for="IdEdit" class="form-label" >Id</label>
                    <input class="form-control" type="text" id="IdEdit" name="IdEdit" value="<c:out value="${traerId}"></c:out>" readonly>
                </div>
                <div class="mb-3">
                    <label for="productoEdit" class="form-label" >Editar producto</label>
                    <input class="form-control" type="text" id="productoEdit" name="productoEdit" value="<c:out value="${traerProducto}"></c:out>" required>
                </div>
                <div class="mb-3">
                    <label for="cantidadEdit" class="form-label" >Editar cantidad</label>
                    <input class="form-control" type="number" id="cantidadEdit" name="cantidadEdit" value="<c:out value="${traerCantidad}"></c:out>" required>
                </div>
                <div class="mb-3">
                    <label for="totalEdit" class="form-label" >Editar total</label>
                    <input class="form-control" type="number" id="totalEdit" name="totalEdit" value="<c:out value="${traerTotal}"></c:out>" required>
                </div>
                <button type="submit" class="btn btn-primary">Editar</button>
              </form>
             
             </c:if>
			
              </div>
             </div>
              
            


</body>
</html>