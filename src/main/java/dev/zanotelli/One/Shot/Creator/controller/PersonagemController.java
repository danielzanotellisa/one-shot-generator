package dev.zanotelli.One.Shot.Creator.controller;

import dev.zanotelli.One.Shot.Creator.model.Personagem;
import dev.zanotelli.One.Shot.Creator.service.PersonagemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    private final PersonagemService service;

    public PersonagemController(PersonagemService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Personagem>> getAll() {
        return ResponseEntity.ok(service.getAll);
    }

    //POST

    @PostMapping()
    public ResponseEntity<Personagem> save(@RequestBody Personagem request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
