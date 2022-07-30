package com.demo.app.api.chat.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Document
@ToString
public class ChatUser {
    @MongoId
    @Id
    private ObjectId _id;
    private String  appId;
    private String  region;
    private String  latestAppVersion;
    private String  platformId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
