package com.cristian.backend.prueba_java.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristian.backend.prueba_java.models.PersonaModel;
import com.cristian.backend.prueba_java.services.PersonaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    // @GetMapping("/test")
    // public String Test() {
    // return "This works!";
    // }
    @GetMapping
    public ArrayList<PersonaModel> getAllPersonas() {
        return personaService.getPersonas();
    }

    @PostMapping
    public PersonaModel savePersona(@RequestBody PersonaModel persona) {
        return this.personaService.savePersona(persona);
    }

    @GetMapping(path = "/{id}")
    public Optional<PersonaModel> getPersonById(@PathVariable("id") Long id) {
        return this.personaService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Optional<PersonaModel> updatePersonaById(@RequestBody PersonaModel request, @PathVariable("id") Long id) {
        return this.personaService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.personaService.deletePerson(id);
        if (ok) {
            return "Persona eliminada con éxito";
        } else {
            return "Error al eliminar";
        }
    }
}
