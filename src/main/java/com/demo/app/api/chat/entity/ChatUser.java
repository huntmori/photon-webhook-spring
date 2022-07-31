package com.demo.app.api.chat.entity;

import com.demo.app.api.chat.dto.chatUserAuth.ChatUserAuthRequest;
import com.demo.app.api.chat.enums.ChatRegion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Document
@ToString
@CompoundIndexes({
        @CompoundIndex(
                name = "chat_user_unique",
                def = "{'appId':1, 'platformId':1}"
        )
})
public class ChatUser {
    @MongoId
    @Id
    private ObjectId _id;
    private String  appId;
    private ChatRegion region;
    private String userId;
    private String  latestAppVersion;
    private String  platformId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void setCreateFromRequest(ChatUserAuthRequest request) {
        this.appId = (request.getAppId());
        this.region = (request.getFixedRegion());
        this.latestAppVersion = (request.getAppVersion());
        this.platformId = (request.getPlatformAccountId());
        this.userId = (UUID.randomUUID().toString());
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = (now);
        this.updatedAt = (now);
    }

    public void setUpdateFromRequest(ChatUserAuthRequest request) {
        this.region = (request.getFixedRegion());
        this.latestAppVersion = (request.getAppVersion());
        this.updatedAt = (LocalDateTime.now());
    }
}
