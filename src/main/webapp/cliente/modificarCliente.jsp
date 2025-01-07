<%@page import="Practica1Prestamos.beans.Clientes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String url = "http://localhost:8080/MisPracticasPersonales/";
	Clientes cliente;
	HttpSession sesion = request.getSession();
	if (request.getAttribute("cliente") == null) {
		cliente = new Clientes();
	} else {
		cliente = (Clientes) request.getAttribute("cliente");
		System.out.println(cliente.getIdCli());
		System.out.println(cliente.getNombres());
		System.out.println(cliente.getApellidos());
		System.out.println(cliente.getDni());
		System.out.println(cliente.getFechNaci());
		System.out.println(cliente.getDireccion());
	}
	
%>

	<form role="form" action="<%=url%>AutoresController?op=ingresar" method="POST">
		<input  type="hidden" name="id" id="id" value="<%=cliente.getIdCli()%>">
		<label>Ingrese nombre</label><br>
		<input type="text" name="nombre" id="nombre" value="<%=cliente.getNombres()%>"><br>
		<label>Ingrese Apellidos</label><br>
		<input type="text" name="apellido" id="apellido" value="<%=cliente.getApellidos()%>"><br>
		<label>Ingrese dni</label><br>
		<input type="text" name="dni" id="dni" value="<%=cliente.getDni()%>"><br>
		<label>Ingrese Fecha de nacimiento</label><br>
		<input type="date" name="fechaNac" id="fechaNac" value="<%=cliente.getFechNaci()%>"><br>
		<label>Ingrese direccion</label><br>
		<input type="text" name="direccion" id="direccion" value="<%=cliente.getDireccion()%>"><br>
		<input type="submit" name="guardar" value="guardar"><br>
		<a href="<%=url%>ClientesController?op=listar">volver</a>
	</form>
</body>
</html>