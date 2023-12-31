package com.ISILSOFT_FINAL.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity // we define
@Table(name="Tienda") //we connect with the sql table
public class Tienda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	
	
	@Column(name="direccion")
	private String direccion;
	
	
	@Column(name="distrito")
	private String distrito;
	
	@Column(name="aforo")
	private int aforo;
	
	
	
	@ManyToOne
	@JoinColumn(name="codColaborador")
	private JefeTienda jefe;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getDistrito() {
		return distrito;
	}



	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}



	public int getAforo() {
		return aforo;
	}



	public void setAforo(int aforo) {
		this.aforo = aforo;
	}



	public JefeTienda getJefe() {
		return jefe;
	}



	public void setJefe(JefeTienda jefe) {
		this.jefe = jefe;
	}
	
	
	

	
	
	
	
	

}
