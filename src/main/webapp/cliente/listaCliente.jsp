<%@page import="Practica1Prestamos.beans.Clientes"%>
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
	<a href="<%=url%>ClientesController?op=nuevo">Nuevo</a>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre </th>
				<th>Apellidos </th>
				<th>Dni </th>
				<th>Fecha de Nacimiento </th>
				<th>Direccion</th>
				<th>operaciones</th>
			</tr>
		</thead>
		<tbody>
		<%
		List<Clientes> listaClientes=(List<Clientes>) request.getAttribute("listaClientes");
			//verificamos si la lista esta vacia
			if(listaClientes != null){
				//creamos un iterador sobre la lista
				for(Clientes cliente: listaClientes){
					%>
					<tr>
						<td><%=cliente.getIdCli()%></td>
						<td><%=cliente.getNombres()%></td>
						<td><%=cliente.getApellidos()%></td>
						<td><%=cliente.getDni()%></td>
						<td><%=cliente.getFechNaci()%></td>
						<td><%=cliente.getDireccion()%></td>
						<td>
						<a type="button" href="<%=url%>ClientesController?op=obtener&id=<%=cliente.getIdCli()%>">Modificar</a>
						<a type="button" href="<%=url%>ClientesController?op=eliminar&id=<%=cliente.getIdCli()%>">Eliminar</a>
						<a type="button" href="<%=url%>ClientesController?op=prestamos&id=<%=cliente.getIdCli()%>">Prestamos</a>
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