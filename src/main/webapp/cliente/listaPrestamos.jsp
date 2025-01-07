<%@page import="Practica1Prestamos.beans.Prestamo"%>
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
	<h2>Lista Prestamos del cliente</h2>
	<a href="<%=url%>ClientesController?op=nuevo">Nuevo</a>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Fecha </th>
				<th>Monto </th>
				<th>Cliente </th>
				<th>Interes</th>
				<th>NumCuotas</th>
				<th>operaciones</th>
			</tr>
		</thead>
		<tbody>
		<%
		List<Prestamo> listaPrestamos=(List<Prestamo>) request.getAttribute("listaPrestamos");
			//verificamos si la lista esta vacia
			if(listaPrestamos != null){
				//creamos un iterador sobre la lista
				for(Prestamo prestamo: listaPrestamos){
					%>
					<tr>
						<td><%=prestamo.getIdprest()%></td>
						<td><%=prestamo.getFechPres()%></td>
						<td><%=prestamo.getIntePres()%></td>
						<td><%=prestamo.getIdCli()%></td>
						<td><%=prestamo.getIntePres()%></td>
						<td><%=prestamo.getNumCuot()%></td>
						<td>
						<a type="button" href="<%=url%>ClientesController?op=obtener">Modificar</a>
						</td>
					</tr>
					<%
				}
			} else { %>
				<tr>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td></td>
				</tr>
			
			<%	
			}
		%>	
		</tbody>
	</table>
</body>
</html>