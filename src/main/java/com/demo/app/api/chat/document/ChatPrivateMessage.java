package com.demo.app.api.chat.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.json.JsonObject;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatPrivateMessage {
    @MongoId
    private ObjectId _id;
    private ObjectId chatChannelId;
    private ObjectId chatUserId;
    private ObjectId receiveUserId;

    private JsonObject message;

    private List<String> usersPair = new ArrayList<>();

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
