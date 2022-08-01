package com.demo.app.api.chat.service;

import com.demo.app.api.chat.dto.PhotonResponse;
import com.demo.app.api.chat.dto.chatChannelCreate.ChannelCreateRequest;
import com.demo.app.api.chat.dto.chatChannelDestroy.ChannelDestroyRequest;
import com.demo.app.api.chat.dto.chatChannelSubscribe.ChannelSubscribeRequest;
import com.demo.app.api.chat.dto.chatChannelUnsubscribe.ChannelUnsubscribeRequest;
import com.demo.app.api.chat.dto.chatUserAuth.ChatUserAuthRequest;
import com.demo.app.api.chat.dto.publishMessage.PublishMessageRequest;
import com.demo.app.api.chat.entity.ChatChannel;
import com.demo.app.api.chat.entity.ChatSubscribe;
import com.demo.app.api.chat.entity.ChatUser;

public interface ChatService {
    ChatUser chatUserCreate(ChatUser document);

    PhotonResponse chatUserAuth(ChatUserAuthRequest request);

    PhotonResponse chatChannelCreate(ChannelCreateRequest request);

    PhotonResponse channelSubscribe(ChannelSubscribeRequest request);

    PhotonResponse channelUnsubscribe(ChannelUnsubscribeRequest request);

    PhotonResponse channelDestroy(ChannelDestroyRequest request);

    PhotonResponse publishMessage(PublishMessageRequest request);

    ChatUser chatUserExist(ChatUserAuthRequest request);

    ChatUser createOrGetChatUser(ChatUserAuthRequest request);

    ChatUser createUser(ChatUserAuthRequest request);

    ChatUser updateUser(ChatUser exist, ChatUserAuthRequest request);

    ChatChannel createOrGetChannel(ChannelCreateRequest request);

    ChatSubscribe createOrGetSubscribe(ChatUser user, ChatChannel exist);
}
