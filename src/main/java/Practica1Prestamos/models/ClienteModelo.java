package Practica1Prestamos.models;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import Practica1Prestamos.beans.Clientes;
import Practica1Prestamos.controller.ClientesController;

public class ClienteModelo extends Conexion {
	CallableStatement cs;
	ResultSet rs;
	
	public List<Clientes> listarClientes() throws SQLException{
		try {
			List<Clientes> lista = new ArrayList<>();
			String sql = "CALL sp_listarClientes()";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Clientes clientes = new Clientes();
				clientes.setIdCli(rs.getInt("id_cliente"));
				clientes.setNombres(rs.getString("nombres_cliente"));
				clientes.setApellidos(rs.getString("apellidos_cliente"));
				clientes.setDni(rs.getString("dni_cliente"));
				clientes.setFechNaci(rs.getDate("fechNaci_cliente"));
				clientes.setDireccion(rs.getString("direccion_cliente"));
				lista.add(clientes);
			}
			this.cerrarConexion();
			return lista;
			
		} catch (SQLException ex) {
			Logger.getLogger(ClientesController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			this.cerrarConexion();
			return null;
		}
	}
	
	public int insertar(Clientes cliente) throws SQLException{
		int filasAfectadas = 0;
		try {
			String sql = "CALL sp_insertarCliente(?,?,?,?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setString(1, cliente.getNombres());
			cs.setString(2, cliente.getApellidos());
			cs.setString(3, cliente.getDni());
			cs.setDate(4, cliente.getFechNaci());
			cs.setString(5, cliente.getDireccion());
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
		} catch (Exception e) {
			System.out.println("Error al  insertar desde modelos: "+e.getMessage());
			return 0;
		}
	}

}
