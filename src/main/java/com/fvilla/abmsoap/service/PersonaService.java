package com.fvilla.abmsoap.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fvilla.abmsoap.entity.Persona;
import com.fvilla.abmsoap.exceptions.PersonaNotFoundException;
import com.fvilla.abmsoap.repository.PersonaRepository;

@Service
public class PersonaService {

	private PersonaRepository personaRepository;
	
	@Autowired
	public PersonaService(PersonaRepository personaRepository) {
		super();
		this.personaRepository = personaRepository;
	}
	
	
	public Persona findByIdPersona (int id) throws PersonaNotFoundException {
		Optional<Persona> resultado = personaRepository.findById(id);
		
		Persona persona = null;
		
		if(resultado.isPresent()) {
			persona = resultado.get();
		} else {
			throw new PersonaNotFoundException(id);
        }
		
		return persona;
	}
	

	public Persona save (Persona persona) {return personaRepository.save(persona);}

	public void deleteById (int id) {personaRepository.deleteById(id);}
	
	public List<Persona> findAll () {return personaRepository.findAll();}
	
	@Transactional
	public Persona editarPersona (Persona persona) throws PersonaNotFoundException {
		Persona personaAux = this.findByIdPersona(persona.getId());
		personaAux.setId(persona.getId());
		personaAux.setNombre(persona.getNombre());
		personaAux.setApellido(persona.getApellido());
		personaAux.setDni(persona.getDni());
		personaAux.setFechaNacimiento(persona.getFechaNacimiento());
		personaAux.setProfesion(persona.getProfesion());
		personaRepository.save(personaAux);
		return personaAux;
	}
	
}
