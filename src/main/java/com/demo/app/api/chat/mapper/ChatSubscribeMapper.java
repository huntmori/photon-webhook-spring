package com.demo.app.api.chat.mapper;

import com.demo.app.api.chat.document.ChatChannel;
import com.demo.app.api.chat.document.ChatSubscribe;
import com.demo.app.api.chat.document.ChatUser;
import com.demo.app.api.chat.dto.chatUserAuth.ChatUserAuthRequest;
import com.demo.app.api.chat.enums.SubscribeState;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface ChatSubscribeMapper extends GenericMapper<ChatUserAuthRequest, ChatUser> {
    ChatSubscribeMapper INSTANCE = Mappers.getMapper(ChatSubscribeMapper.class);

    default void setUnsubscribe(ChatSubscribe subscribe) {
        subscribe.setState(SubscribeState.UNSUBSCRIBE);
        subscribe.setUpdatedAt(LocalDateTime.now());
    }

    default void setSubscribe(ChatSubscribe exist) {
        exist.setState(SubscribeState.SUBSCRIBE);
        exist.setUpdatedAt(LocalDateTime.now());
    }

    default  ChatSubscribe setCreate(ChatUser user, ChatChannel targetChannel) {
        ChatSubscribe.ChatSubscribeBuilder builder = ChatSubscribe.builder();
        builder.channelId(targetChannel.get_id())
                .userId(user.get_id())
                .state(SubscribeState.SUBSCRIBE)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now());
        return builder.build();
    }
}
