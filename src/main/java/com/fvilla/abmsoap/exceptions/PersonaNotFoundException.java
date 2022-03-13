package com.fvilla.abmsoap.exceptions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.ws.WebFault;

@WebFault (name="PersonaNotFound")
@XmlAccessorType( XmlAccessType.FIELD )
public class PersonaNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PersonaNotFoundException (int idPersona) {
		this("El id " + idPersona + " no corresponde a ninguna persona.");
	}
	
	public PersonaNotFoundException(String message) {
		super(message);
	}

}
