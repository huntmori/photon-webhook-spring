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
import com.demo.app.api.chat.entity.ChatUser;
import com.demo.app.api.chat.enums.AuthResultCode;
import com.demo.app.api.chat.repository.ChatUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService{

    private final ChatUserRepository userRepository;

    @Override
    public ChatUser chatUserCreate(ChatUser document) {
        return this.userRepository.create(document);
    }

    @Override
    public PhotonResponse chatUserAuth(ChatUserAuthRequest request) {
        PhotonResponse response = null;
        try {

            response = new ChatUserAuthSuccessResponse();
            ((ChatUserAuthSuccessResponse)response).setUserId(UUID.randomUUID().toString());
            response.successResponse();
        } catch (Exception e) {
            e.printStackTrace();
            response = new ChatUserAuthFailResponse(AuthResultCode.FAIL, "Unknown server error");
        }
        log.info("response:"+response.toString());
        return response;
    }

    @Override
    public PhotonResponse chatChannelCreate(ChannelCreateRequest request) {
        PhotonResponse response = new PhotonDefaultResponse();

        response.successResponse();
        log.info("response:"+response.toString());
        return response;
    }

    @Override
    public PhotonResponse channelSubscribe(ChannelSubscribeRequest request) {
        PhotonResponse response = new PhotonDefaultResponse();

        response.successResponse();
        log.info("response:"+response.toString());
        return response;
    }

    @Override
    public PhotonResponse channelUnsubscribe(ChannelUnsubscribeRequest request) {
        PhotonResponse response = new PhotonDefaultResponse();

        response.successResponse();
        log.info("response:"+response.toString());
        return response;
    }

    @Override
    public PhotonResponse channelDestroy(ChannelDestroyRequest request) {
        PhotonResponse response = new PhotonDefaultResponse();

        response.successResponse();
        log.info("response:"+response.toString());
        return response;
    }

    @Override
    public PhotonResponse publishMessage(PublishMessageRequest request) {
        PhotonResponse response = new PhotonDefaultResponse();

        response.successResponse();
        log.info("response:"+response.toString());
        return response;
    }
}
