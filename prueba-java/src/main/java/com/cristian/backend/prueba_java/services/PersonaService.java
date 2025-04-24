package com.cristian.backend.prueba_java.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.backend.prueba_java.models.PersonaModel;
import com.cristian.backend.prueba_java.repositories.IPersonaRepository;

@Service
public class PersonaService {
    @Autowired
    IPersonaRepository personaRepository;

    public ArrayList<PersonaModel> getPersonas() {
        return (ArrayList<PersonaModel>) personaRepository.findAll();
    }

    public PersonaModel savePersona(PersonaModel persona) {
        return personaRepository.save(persona);
    }

    public Optional<PersonaModel> getById(Long id) {
        return personaRepository.findById(id);
    }

    public Optional<PersonaModel> updateById(PersonaModel request, Long id) {
        Optional<PersonaModel> persona = personaRepository.findById(id);
        if (persona.isPresent()) {
            PersonaModel personaToUpdate = persona.get();
            personaToUpdate.setNombre(request.getNombre());
            personaToUpdate.setGenero(request.getGenero());
            personaToUpdate.setEdad(request.getEdad());
            personaToUpdate.setIdentificacion(request.getIdentificacion());
            personaToUpdate.setDireccion(request.getDireccion());
            personaToUpdate.setTelefono(request.getTelefono());
            return Optional.of(personaRepository.save(personaToUpdate));
        } else {
            return Optional.empty();
        }
    }

    public Boolean deletePerson(Long id) {
        try {
            personaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
