package dev.zanotelli.One.Shot.Creator.service;

import dev.zanotelli.One.Shot.Creator.model.Personagem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChatGptService {

    private final WebClient webClient;
    private final String api_key = System.getenv("openai_api_key");
    public ChatGptService(WebClient webClient) {
        this.webClient = webClient;
    }
    public Mono<String> generateOneShot(List<Personagem> personagem) {


        String personagens = personagem.stream()
                .map(item-> String.format("nome: %s, idade: %d, raça: %s, classe: %s, nivel: %d", item.getName(), item.getAge(), item.getSpecies(), item.getCharacterClass(), item.getLevel()))
                .collect(Collectors.joining("\n"));

        String prompt = "Crie uma aventura com os seguintes personagens:\n" + personagens + "\n crie cenários, encontros, combates e missões para o grupo ";

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4o",
                "messages", List.of(
                        Map.of("role", "developer", "content", "Se baseie no universo de D&D"),
                        Map.of("role", "user", "content", prompt)

                )
        );

        return webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + api_key)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {

                    var choices = (List<Map<String, Object>>) response.get("choices");
                    if (choices != null && !choices.isEmpty()) {
                        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
                        return message.get("content").toString();
                    }
                    return "Nenhuma aventura foi gerada";
                });

    }
}
