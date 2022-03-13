package com.fvilla.abmsoap.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name="personas", uniqueConstraints = @UniqueConstraint(columnNames = "dni"))
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class Persona {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(name="id", required=true)
	private int id;
	
	@XmlElement(name="nombre", required=true)
	private String nombre;
	
	@XmlElement(name="apellido", required=true)
	private String apellido;
	
	@XmlElement(name="dni", required=true)
	private int dni;
	
	@XmlElement(name="fechaNacimiento", required=true)
	@XmlSchemaType(name="date")
	private Date fechaNacimiento;
	
	@XmlElement(name="profesion", required=true)
	private String profesion;
	
	public Persona() {
		super();
	}

	public Persona(String nombre, String apellido, int dni, Date fechaNacimiento, String profesion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.profesion = profesion;
	}

	
	public int getId() {
		return id;
	}

	@XmlTransient
	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechaNacimiento=" + fechaNacimiento + ", profesion=" + profesion + "]";
	}
}
