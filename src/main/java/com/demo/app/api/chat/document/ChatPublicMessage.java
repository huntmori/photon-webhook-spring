package com.demo.app.api.chat.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.json.JsonObject;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatPublicMessage {
    @MongoId
    private ObjectId _id;
    private ObjectId chatChannelId;
    private ObjectId chatUserId;

    private String appVersion;

    private JsonObject message;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
