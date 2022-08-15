package com.demo.app.api.chat.document;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
@ToString
public class ChatUser {
    @MongoId
    @Id
    private ObjectId _id;

    private String chatUserId;
    private String platformId;

    private String lastAppVersion;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
