package dev.zanotelli.One.Shot.Creator.service;

import dev.zanotelli.One.Shot.Creator.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonagemService {

    private final PersonagemRepository repository;

    public PersonagemService(PersonagemRepository repository) {
        this.repository = repository;
    }
}
