package com.demo.app.api.chat.mapper;

import com.demo.app.api.chat.document.ChatChannel;
import com.demo.app.api.chat.document.ChatUser;
import com.demo.app.api.chat.dto.chatChannelCreate.ChannelCreateRequest;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface ChatChannelMapper extends GenericMapper<ChannelCreateRequest, ChatChannel> {

    default ChatChannel toCreate(ChannelCreateRequest request, ChatUser user) {
        ChatChannel.ChatChannelBuilder builder = ChatChannel.builder();
        builder.appId(request.getAppId())
                .appVersion(request.getAppVersion())
                .region(request.getRegion())
                .channelType(request.getChannelType())
                .channelName(request.getChannelName())
                .createdUserId(user.get_id())
                .createdUserNickname("")
                .channelState("CREATED")
                .maxSubscribers(request.getMaxSubscribers())
                .publishSubscribers(request.isPublishSubscribers())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now());
        return builder.build();
    }

    default void toUpdate(ChatChannel exist, ChannelCreateRequest request, ChatUser user) {
        exist.setUpdatedAt(LocalDateTime.now());
        exist.setAppId(request.getAppVersion());
        exist.setChannelType(request.getChannelType());
        exist.setCreatedUserId(user.get_id());
        exist.setChannelState("CREATED");
        exist.setMaxSubscribers(request.getMaxSubscribers());
        exist.setPublishSubscribers(request.isPublishSubscribers());
    }
}
