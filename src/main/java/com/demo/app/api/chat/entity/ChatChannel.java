package com.demo.app.api.chat.entity;

import com.demo.app.api.chat.dto.chatChannelCreate.ChannelCreateRequest;
import com.demo.app.api.chat.enums.ChannelType;
import com.demo.app.api.chat.enums.ChatRegion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
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
    
}
