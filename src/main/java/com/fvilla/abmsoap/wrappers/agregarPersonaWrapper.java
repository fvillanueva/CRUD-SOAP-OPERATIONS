package com.fvilla.abmsoap.wrappers;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class agregarPersonaWrapper {

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

	
	
	
}
