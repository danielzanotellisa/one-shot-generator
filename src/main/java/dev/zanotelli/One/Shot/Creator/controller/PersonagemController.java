package dev.zanotelli.One.Shot.Creator.controller;

import dev.zanotelli.One.Shot.Creator.service.PersonagemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    private final PersonagemService service;

    public PersonagemController(PersonagemService service) {
        this.service = service;
    }


}
