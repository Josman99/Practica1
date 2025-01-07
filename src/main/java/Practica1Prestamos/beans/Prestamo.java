package Practica1Prestamos.beans;

import java.sql.Date;

public class Prestamo {
	private int idprest;
	private Date fechPres;
	private double montPre;
	private int idCli;
	private int intePres;
	private int numCuot;
	
	public Prestamo(int idprest, Date fechPres, double montPre, int idCli, int intePres, int numCuot) {
		super();
		this.idprest = idprest;
		this.fechPres = fechPres;
		this.montPre = montPre;
		this.idCli = idCli;
		this.intePres = intePres;
		this.numCuot = numCuot;
	}

	public Prestamo() {
		this(0,null,0,0,0,0);
	}

	public int getIdprest() {
		return idprest;
	}

	public void setIdprest(int idprest) {
		this.idprest = idprest;
	}

	public Date getFechPres() {
		return fechPres;
	}

	public void setFechPres(Date fechPres) {
		this.fechPres = fechPres;
	}

	public double getMontPre() {
		return montPre;
	}

	public void setMontPre(double montPre) {
		this.montPre = montPre;
	}

	public int getIdCli() {
		return idCli;
	}

	public void setIdCli(int idCli) {
		this.idCli = idCli;
	}

	public int getIntePres() {
		return intePres;
	}

	public void setIntePres(int intePres) {
		this.intePres = intePres;
	}

	public int getNumCuot() {
		return numCuot;
	}

	public void setNumCuot(int numCuot) {
		this.numCuot = numCuot;
	}
	
}
