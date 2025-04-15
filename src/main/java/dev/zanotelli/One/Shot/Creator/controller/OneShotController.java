package dev.zanotelli.One.Shot.Creator.controller;

import dev.zanotelli.One.Shot.Creator.model.Personagem;
import dev.zanotelli.One.Shot.Creator.service.ChatGptService;
import dev.zanotelli.One.Shot.Creator.service.PersonagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/adventure/generate")
public class OneShotController {

    private final ChatGptService service;
    private final PersonagemService personagemService;

    public OneShotController(ChatGptService service, PersonagemService personagemService) {
        this.service = service;
        this.personagemService = personagemService;
    }

    @GetMapping()
    public Mono<ResponseEntity<String>> generate() {
        List<Personagem> personagens = personagemService.getAll();
        return service.generateOneShot(personagens)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
