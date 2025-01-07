package Practica1Prestamos.beans;

import java.sql.Date;

public class Clientes {
	private int idCli;
	private String nombres;
	private String apellidos;
	private String dni;
	private Date fechNaci;
	private String direccion;
	
	//Date fechaActual = new Date();
	
	public Clientes(int idCli, String nombres, String apellidos, String dni, Date fechNaci, String direccion) {
		super();
		this.idCli = idCli;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechNaci = fechNaci;
		this.direccion = direccion;
	}

	public Clientes() {
		this(0,"","","", null,"");
	}

	public int getIdCli() {
		return idCli;
	}

	public void setIdCli(int idCli) {
		this.idCli = idCli;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechNaci() {
		return fechNaci;
	}

	public void setFechNaci(Date fechNaci) {
		this.fechNaci = fechNaci;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
