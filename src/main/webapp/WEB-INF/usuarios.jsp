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
          <a class="nav-link active" href="/usuarios">Usuarios</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/productos">Productos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/ventas">Ventas</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
 <div class="row justify-content-center text-center">
        <div class="col-md-5">
            <h1>Modificar usuarios</h1><br>
            <table class="table">
			  <thead>
			    <tr>
			      <th>Id</th>
			      <th>Nombre</th>
			      <th>Contrase�a</th>
			      <th>Email</th>
			      <th>Editar</th>
			      <th>Eliminar</th>
			    </tr>
			  </thead>
			  <tbody>
<c:forEach items="${usuariosLIST}" var="i">
	<tr>
		<td>${i.id}</td>
		<td>${i.nombre}</td>
		<td>${i.password}</td>
		<td>${i.email}</td>
		<td><form method="get" action="/usuarios/traer/${i.id}">
    <button type="submit" class="btn btn-warning">Rellenar campos para edicion</button>
</form></td>
		<td><form method="get" action="/usuarios/eliminar/${i.id}">
    <button type="submit" class="btn btn-danger">Eliminar</button>
</form></td>
	</tr>
</c:forEach>
			  </tbody>
			</table>
			</div>
			<div class="row">
			<div class="col-md-6">
			<h1>Agregar usuario</h1><br>
            <form action="/usuarios/agregar" method="POST">
                <div class="mb-3">
                    <label for="nombreForm" class="form-label" >Nombre</label>
                    <input class="form-control" type="text" id="nombreForm" name="nombreForm" placeholder="Ingresa tu nombre" required>
                </div>
                <div class="mb-3">
                    <label for="passwordForm" class="form-label" >Password</label>
                    <input class="form-control" type="password" id="passwordForm" name="passwordForm" placeholder="Ingresa tu contrase�a" required>
                </div>
                <div class="mb-3">
                    <label for="emailForm" class="form-label" >Email</label>
                    <input class="form-control" type="email" id="emailForm" name="emailForm" placeholder="Ingresa tu email" required>
                </div>
                 <input type="reset" value="Limpiar" class="btn btn-warning">
                <button type="submit" class="btn btn-primary">A�adir</button>
              </form>
              </div>
              <div class="col-md-6">
              
             <c:if test="${traerNombre != null && traerPassword != null && traerEmail != null}">
             	<h1>Editar usuario</h1><br>
            <form action="/usuarios/editar" method="POST">
            <div class="mb-3">
                    <label for="IdEdit" class="form-label" >Id</label>
                    <input class="form-control" type="text" id="IdEdit" name="IdEdit" value="<c:out value="${traerId}"></c:out>" readonly>
                    

                </div>
                <div class="mb-3">
                    <label for="nombreEdit" class="form-label" >Editar nombre</label>
                    <input class="form-control" type="text" id="nombreEdit" name="nombreEdit" value="<c:out value="${traerNombre}"></c:out>" required>
                </div>
                <div class="mb-3">
                    <label for="passwordEdit" class="form-label" >Editar password</label>
                    <input class="form-control" type="text" id="passwordEdit" name="passwordEdit" value="<c:out value="${traerPassword}"></c:out>" required>
                </div>
                <div class="mb-3">
                    <label for="emailEdit" class="form-label" >Editar email</label>
                    <input class="form-control" type="email" id="emailEdit" name="emailEdit" value="<c:out value="${traerEmail}"></c:out>" required>
                </div>
                <button type="submit" class="btn btn-primary">Editar</button>
              </form>
             
             </c:if>
			
              </div>
             </div>
              
            


</body>
</html>