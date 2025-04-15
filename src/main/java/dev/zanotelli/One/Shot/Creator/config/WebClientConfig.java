package dev.zanotelli.One.Shot.Creator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${chatgpt_api_url:https://api.openai.com/v1/chat/completions}")
    private String chatGptApiUrl;

    @Bean
    public WebClient webClient (WebClient.Builder builder) {
        return builder.baseUrl(chatGptApiUrl)
                .build();
    }
}
