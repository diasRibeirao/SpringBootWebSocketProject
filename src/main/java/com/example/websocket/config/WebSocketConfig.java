package com.example.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // topic é o prefixo usado para os destinos em que os clientes podem se inscrever para receber atualizações em tempo real.
        // Por exemplo, um cliente pode se inscrever no tópico /topic/approvals para receber mensagens.
        config.enableSimpleBroker("/topic");
        // Habilita o Simple Broker:


        // Isso significa que as mensagens enviadas pelo cliente ao servidor terão o prefixo /app e serão roteadas ao controller correto.
        // Por exemplo:
        // Cliente envia mensagem para /app/approvals
        // O servidor a processa e publica no /topic/approvals
        config.setApplicationDestinationPrefixes("/app");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Define o endpoint /ws para os clientes STOMP se conectarem ao servidor WebSocket.
        // Permite origens de qualquer lugar (para testes e desenvolvimento).
        // Em Prod: .setAllowedOriginPatterns("https://example.com") // Restringe a origem específica
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }
}