package com.demo.app.api.chat.service;

import com.demo.app.api.chat.dto.PhotonDefaultResponse;
import com.demo.app.api.chat.dto.PhotonResponse;
import com.demo.app.api.chat.dto.chatChannelCreate.ChannelCreateRequest;
import com.demo.app.api.chat.dto.chatChannelDestroy.ChannelDestroyRequest;
import com.demo.app.api.chat.dto.chatChannelSubscribe.ChannelSubscribeRequest;
import com.demo.app.api.chat.dto.chatChannelUnsubscribe.ChannelUnsubscribeRequest;
import com.demo.app.api.chat.dto.chatUserAuth.ChatUserAuthFailResponse;
import com.demo.app.api.chat.dto.chatUserAuth.ChatUserAuthRequest;
import com.demo.app.api.chat.dto.chatUserAuth.ChatUserAuthSuccessResponse;
import com.demo.app.api.chat.dto.publishMessage.PublishMessageRequest;
import com.demo.app.api.chat.entity.ChatChannel;
import com.demo.app.api.chat.entity.ChatSubscribe;
import com.demo.app.api.chat.entity.ChatUser;
import com.demo.app.api.chat.enums.AuthResultCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService{

    @Override
    public ChatUser chatUserCreate(ChatUser document) {
        return null;
    }

    @Override
    public PhotonResponse chatUserAuth(ChatUserAuthRequest request) {
        return null;
    }

    @Override
    public PhotonResponse chatChannelCreate(ChannelCreateRequest request) {
        return null;
    }

    @Override
    public PhotonResponse channelSubscribe(ChannelSubscribeRequest request) {
        return null;
    }

    @Override
    public PhotonResponse channelUnsubscribe(ChannelUnsubscribeRequest request) {
        return null;
    }

    @Override
    public PhotonResponse channelDestroy(ChannelDestroyRequest request) {
        return null;
    }

    @Override
    public PhotonResponse publishMessage(PublishMessageRequest request) {
        return null;
    }

    @Override
    public ChatUser chatUserExist(ChatUserAuthRequest request) {
        return null;
    }

    @Override
    public ChatUser createOrGetChatUser(ChatUserAuthRequest request) {
        return null;
    }

    @Override
    public ChatUser createUser(ChatUserAuthRequest request) {
        return null;
    }

    @Override
    public ChatUser updateUser(ChatUser exist, ChatUserAuthRequest request) {
        return null;
    }

    @Override
    public ChatChannel createOrGetChannel(ChannelCreateRequest request) {
        return null;
    }

    @Override
    public ChatSubscribe createOrGetSubscribe(ChatUser user, ChatChannel exist) {
        return null;
    }
}
