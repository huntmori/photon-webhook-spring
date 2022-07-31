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
import com.demo.app.api.chat.entity.ChatUser;
import com.demo.app.api.chat.enums.AuthResultCode;
import com.demo.app.api.chat.repository.ChatChannelRepository;
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
    private final ChatChannelRepository channelRepository;

    @Override
    public ChatUser chatUserCreate(ChatUser document) {
        return this.userRepository.create(document);
    }

    @Override
    public PhotonResponse chatUserAuth(ChatUserAuthRequest request) {
        PhotonResponse response = null;
        try {
            // 실제론 실제 서비스 유저인지 체크하는 로직도 들어가야함
            ChatUser exist = this.createOrGetChatUser(request);
            response = new ChatUserAuthSuccessResponse();
            ((ChatUserAuthSuccessResponse)response).setUserId(exist.getUserId());
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
        try {
            ChatChannel exist = this.createOrGetChannel(request);
            response.successResponse();
        } catch (Exception e ) {
            e.printStackTrace();
            response.errorResponse("unknown server error");
        }
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

    @Override
    public ChatUser chatUserExist(ChatUserAuthRequest request) {
        String appId = request.getAppId();
        String platformId = request.getPlatformAccountId();

        return this.userRepository.find(appId, platformId);
    }

    @Override
    public ChatUser createOrGetChatUser(ChatUserAuthRequest request) {
        ChatUser exist = this.chatUserExist(request);
        if (exist == null) {
            exist = this.createUser(request);
        } else {
            exist = this.updateUser(exist, request);
        }
        return exist;
    }

    @Override
    public ChatUser createUser(ChatUserAuthRequest request) {
        return this.userRepository.createFromRequest(request);
    }

    @Override
    public ChatUser updateUser(ChatUser user, ChatUserAuthRequest request) {
        return this.userRepository.updateFromRequest(user,request);
    }

    @Override
    public ChatChannel createOrGetChannel(ChannelCreateRequest request) {
        ChatChannel exist = this.channelRepository.findFromRequest(request);
        if (exist == null) {
            exist = this.channelRepository.createFromRequest(request);
        } else {
            exist = this.channelRepository.updateFromRequest(exist, request);
        }
        return exist;
    }
}
