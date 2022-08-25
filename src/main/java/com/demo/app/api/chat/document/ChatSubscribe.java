package com.demo.app.api.chat.document;

import com.demo.app.api.chat.enums.SubscribeState;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Getter
@Setter
@Document
@Builder
public class ChatSubscribe {
    @MongoId
    private ObjectId _id;
    private ObjectId channelId;
    private ObjectId userId;

    private SubscribeState state;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
