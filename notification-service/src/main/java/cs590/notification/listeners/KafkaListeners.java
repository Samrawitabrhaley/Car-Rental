package cs590.notification.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "Notifications", groupId = "notifs")
    void notificationsListener(String data){
        System.out.println("Notification received: " + data + ": email notification will be sent from here.");
    }
}
