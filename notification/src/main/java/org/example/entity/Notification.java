package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;
    @Column(name = "message")
    private String message;
    @Column(name = "sender")
    private String sender;
    @Column(name = "sendat")
    private LocalDateTime sendAt;

    public Notification(String product, String message, LocalDateTime now) {
    }
}
