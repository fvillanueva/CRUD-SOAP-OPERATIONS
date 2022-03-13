package com.fvilla.abmsoap.cxf;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;

import org.apache.cxf.annotations.SchemaValidation;

import com.fvilla.abmsoap.entity.Persona;
import com.fvilla.abmsoap.exceptions.PersonaNotFoundException;

@WebService(targetNamespace = "http://ws.cxf.fvilla.org/")
public interface OperacionesAbm {

	@WebMethod(operationName = "listarPersonas")
	@WebResult(name = "listaPersonas")
	List<Persona> listarPersonas();
	
	@WebMethod(operationName = "agregarPersona")
	@RequestWrapper(localName = "inputAgregarPersona", className = "com.fvilla.abmsoap.wrappers.agregarPersonaWrapper")
	@WebResult(name = "personaAgregada")
	@SchemaValidation
	Persona agregarPersona(
			@WebParam(name = "nombre") String nombre,
			@WebParam(name = "apellido") String apellido,
			@WebParam(name = "dni") int dni,
			@WebParam(name = "fechaNacimiento") Date fechaNacimiento,
			@WebParam(name = "profesion") String profesion);
	
	@WebMethod(operationName = "eliminarPersona")
	@RequestWrapper(localName = "inputEliminarPersona", className = "com.fvilla.abmsoap.wrappers.eliminarPersonaWrapper")
	@WebResult(name = "personaEliminada")
	@SchemaValidation	
	Persona eliminarPersona(@WebParam(name = "idPersona") int idPersona) throws PersonaNotFoundException;
	
	@WebMethod(operationName = "editarPersona")
	@RequestWrapper(localName = "inputEditarPersona", className = "com.fvilla.abmsoap.wrappers.editarPersonaWrapper")
	@WebResult(name = "personaEditada")
	@SchemaValidation
	Persona editarPersona(@WebParam(name = "persona") Persona persona) throws PersonaNotFoundException;
	
	
	
}
