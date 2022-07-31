package com.demo.app.api.chat.entity;

import com.demo.app.api.chat.dto.chatChannelCreate.ChannelCreateRequest;
import com.demo.app.api.chat.enums.ChannelType;
import com.demo.app.api.chat.enums.ChatRegion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String appId;
    private String appVersion;
    private ChatRegion region;
    private ChannelType channelType;
    private String channelName;
    private String userId;
    private int maxSubscribers;
    private boolean publishSubscribers;

    public void setFromCreateRequest(ChannelCreateRequest request) {
        this.appId = request.getAppId();
        this.appVersion = request.getAppVersion();
        this.region = request.getRegion();
        this.channelType = request.getChannelType();
        this.channelName = request.getChannelName();
        this.userId = request.getUserId();
        this.maxSubscribers = request.getMaxSubscribers();
        this.publishSubscribers = request.isPublishSubscribers();
    }

    public void setUpdateFromCreateRequest(ChannelCreateRequest request) {
        this.appVersion = request.getAppVersion();
        this.channelType = request.getChannelType();
        this.userId = request.getUserId();
        this.maxSubscribers = request.getMaxSubscribers();
        this.publishSubscribers = request.isPublishSubscribers();
    }
}
