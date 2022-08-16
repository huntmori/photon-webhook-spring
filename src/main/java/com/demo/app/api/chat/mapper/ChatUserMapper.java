package com.demo.app.api.chat.mapper;

import com.demo.app.api.chat.document.ChatUser;
import com.demo.app.api.chat.dto.chatUserAuth.ChatUserAuthRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChatUserMapper extends GenericMapper<ChatUserAuthRequest, ChatUser> {
    ChatUserMapper INSTANCE = Mappers.getMapper(ChatUserMapper.class);

    @Mappings({
            @Mapping(target = "_id", ignore = true),
            @Mapping(source = "platformAccountId", target = "platformId"),
            @Mapping(source = "appVersion", target = "lastAppVersion"),
            @Mapping(target = "chatUserId", expression = "java(java.util.UUID.randomUUID().toString())"),
            @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())"),
            @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    })
    ChatUser toEntityCreate(ChatUserAuthRequest request);
}
