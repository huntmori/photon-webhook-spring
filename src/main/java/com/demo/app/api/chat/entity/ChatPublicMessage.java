package com.demo.app.api.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatPublicMessage {
    @MongoId
    @Id
    private ObjectId _id;
    private ObjectId chatUserId;
    private ObjectId channelId;
    private String appVersion;
    private LinkedHashMap<String, Object> message;
    private LocalDateTime createdAt;
}
