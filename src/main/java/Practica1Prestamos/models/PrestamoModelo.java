package Practica1Prestamos.models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import Practica1Prestamos.beans.Clientes;
import Practica1Prestamos.beans.Prestamo;
import Practica1Prestamos.controller.ClientesController;

public class PrestamoModelo extends Conexion {
	CallableStatement cs;
	ResultSet rs;
	
	public List<Prestamo> listaPrestamos(int idCli) throws SQLException{
		try {
			List<Prestamo> lista = new ArrayList<>();
			String sql = "CALL sp_listarPrestamos(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idCli);
			rs = cs.executeQuery();
			while (rs.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setIdprest(rs.getInt("id_prestamo"));
				prestamo.setFechPres(rs.getDate("fecha_prestamo"));
				prestamo.setMontPre(rs.getDouble("id_Cliente"));
				prestamo.setIdCli(rs.getInt("id_Cliente"));
				prestamo.setIntePres(rs.getInt("interes_prestamo"));
				prestamo.setNumCuot(rs.getInt("numeroCuotas_prestamo"));
				lista.add(prestamo);
			}
			this.cerrarConexion();
			return lista;
			
		} catch (SQLException ex) {
			Logger.getLogger(ClientesController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			this.cerrarConexion();
			return null;
		}
	}
}
