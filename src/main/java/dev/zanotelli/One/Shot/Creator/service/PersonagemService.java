package dev.zanotelli.One.Shot.Creator.service;

import dev.zanotelli.One.Shot.Creator.model.Personagem;
import dev.zanotelli.One.Shot.Creator.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    private final PersonagemRepository repository;
    public List<Personagem> getAll;

    public PersonagemService(PersonagemRepository repository) {
        this.repository = repository;
    }

    public List<Personagem> getAll() {
        return repository.findAll();
    }


    public Personagem save(Personagem personagem) {
        return repository.save(personagem);
    }

    public void delete(Long id) {
        repository.deleteById(id);

    }
}
