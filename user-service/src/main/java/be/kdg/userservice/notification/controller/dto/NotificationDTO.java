package be.kdg.userservice.notification.controller.dto;

import be.kdg.userservice.notification.model.NotificationType;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {
    private int id;
    @Valid
    private String message;
    @Valid
    private NotificationType type;
    private boolean read;
    private String timestamp;
    private String ref;
}
