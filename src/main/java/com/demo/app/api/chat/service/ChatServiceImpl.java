package com.demo.app.api.chat.service;

import com.demo.app.api.chat.dto.PhotonResponse;
import com.demo.app.api.chat.dto.chatChannelCreate.ChannelCreateRequest;
import com.demo.app.api.chat.dto.chatChannelDestroy.ChannelDestroyRequest;
import com.demo.app.api.chat.dto.chatChannelSubscribe.ChannelSubscribeRequest;
import com.demo.app.api.chat.dto.chatChannelUnsubscribe.ChannelUnsubscribeRequest;
import com.demo.app.api.chat.dto.chatUserAuth.ChatUserAuthFailResponse;
import com.demo.app.api.chat.dto.chatUserAuth.ChatUserAuthRequest;
import com.demo.app.api.chat.dto.chatUserAuth.ChatUserAuthSuccessResponse;
import com.demo.app.api.chat.dto.publishMessage.PublishMessageRequest;
import com.demo.app.api.chat.document.ChatChannel;
import com.demo.app.api.chat.document.ChatSubscribe;
import com.demo.app.api.chat.document.ChatUser;
import com.demo.app.api.chat.enums.AuthResultCode;
import com.demo.app.api.chat.mapper.ChatUserMapperImpl;
import com.demo.app.api.chat.repository.ChatUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService{
    private final ChatUserRepository userRepository;
    private final ChatUserMapperImpl chatUserMapper;
    @Override
    public ChatUser chatUserCreate(ChatUser document) {

        return null;
    }

    @Override
    public PhotonResponse chatUserAuth(ChatUserAuthRequest request) {
        PhotonResponse response = null;
        try {
            ChatUser exist = this.userRepository.getOneByAppIdAndPlatformId(
                    request.getAppId(),
                    request.getPlatformAccountId()
            );
            if(exist == null) {
                ChatUser params = this.chatUserMapper.toEntityCreate(request);
                exist = this.userRepository.insert(params);
            } else {
                //update User

            }
            response = new ChatUserAuthSuccessResponse();
            ((ChatUserAuthSuccessResponse)response).setUserId(exist.getChatUserId());
        } catch (Exception e) {
            e.printStackTrace();
            response = new ChatUserAuthFailResponse(AuthResultCode.INVALID_PARAMETER, e.getMessage());
        }
        return response;
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
