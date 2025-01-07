<%@page import="java.util.List"%>
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
	String url = "http://localhost:8080/PrestamosWeb/";
	
%>
<form role="form" action="<%=url%>ClientesController?op=insertar" method="POST">
	<label>Ingrese nombre</label><br>
	<input type="text" name="nombre" id="nombre"><br>
	<label>Ingrese Apellidos</label><br>
	<input type="text" name="apellido" id="apellido"><br>
	<label>Ingrese dni</label><br>
	<input type="text" name="dni" id="dni"><br>
	<label>Ingrese Fecha de nacimiento</label><br>
	<input type="date" name="fechaNac" id="fechaNac"><br>
	<label>Ingrese direccion</label><br>
	<input type="text" name="direccion" id="direccion"><br>
	<input type="submit" name="guardar" value="guardar"><br>
</form>
<a href="<%=url%>ClientesController?op=listar">volver</a>
<%
	if(request.getAttribute("respuesta") !=null) {
		boolean res = (boolean) request.getAttribute("respuesta");
		if(res){
			List<String> listaError = (List<String>) request.getAttribute("listaError");
			for(String error : listaError) {
				%>
<span><%=error %></span>	
<br>	
			<%			
			}
		}
	}
%>
</body>
</html>