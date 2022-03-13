package com.fvilla.abmsoap.wrappers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fvilla.abmsoap.entity.Persona;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class editarPersonaWrapper {

	@XmlElement(name = "persona", required = true)
	Persona persona;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
