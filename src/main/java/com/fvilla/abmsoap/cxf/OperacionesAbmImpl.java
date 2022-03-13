package com.fvilla.abmsoap.cxf;

import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fvilla.abmsoap.entity.Persona;
import com.fvilla.abmsoap.exceptions.PersonaNotFoundException;
import com.fvilla.abmsoap.service.PersonaService;

@Service
@WebService(serviceName = "OperacionesAbm",
	targetNamespace = "http://ws.cxf.fvilla.org/",
	endpointInterface = "com.fvilla.abmsoap.cxf.OperacionesAbm"
)
public class OperacionesAbmImpl implements OperacionesAbm{

	@Autowired
	private PersonaService personaService;
	
	@Override
	public List<Persona> listarPersonas() {
		return personaService.findAll();
	}



	@Override
	public Persona eliminarPersona(int idPersona) throws PersonaNotFoundException {
		Persona persona = personaService.findByIdPersona(idPersona);
		personaService.deleteById(idPersona);
		return persona;
	}

	@Override
	public Persona editarPersona(Persona persona) throws PersonaNotFoundException {
		return personaService.editarPersona(persona);
	}


	@Override
	public Persona agregarPersona(String nombre, String apellido, int dni, Date fechaNacimiento, String profesion) {
		Persona persona = new Persona(nombre, apellido, dni, fechaNacimiento, profesion);
		return personaService.save(persona);
	}

}
