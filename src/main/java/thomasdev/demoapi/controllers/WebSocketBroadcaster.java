package thomasdev.demoapi.controllers;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class WebSocketBroadcaster {

    private static SimpMessagingTemplate messagingTemplate;

    public WebSocketBroadcaster(SimpMessagingTemplate messagingTemplate) {
        WebSocketBroadcaster.messagingTemplate = messagingTemplate;
    }

    public static void broadcast(String destination, Object message) {
        messagingTemplate.convertAndSend(destination, message);
    }
}
