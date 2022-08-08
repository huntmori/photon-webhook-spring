package com.demo.app.api.chat.document;

import com.demo.app.api.chat.enums.ChannelType;
import com.demo.app.api.chat.enums.ChatRegion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Document
@ToString
@CompoundIndexes({
        @CompoundIndex(
                name = "chat_channel_unique",
                def="{'appId':1, 'region':1, 'channelName':1}"
        )
})
public class ChatChannel {
        @MongoId
        private ObjectId _id;
        private String appId;
        private String appVersion;
        private ChatRegion region;
        private ChannelType channelType;
        private String channelName;
        private ObjectId createdUserId;
        private String createdUserNickname;
        private String channelState;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
}
