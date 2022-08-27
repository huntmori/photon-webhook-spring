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
import com.demo.app.api.chat.document.ChatChannel;
import com.demo.app.api.chat.document.ChatSubscribe;
import com.demo.app.api.chat.document.ChatUser;
import com.demo.app.api.chat.enums.AuthResultCode;
import com.demo.app.api.chat.mapper.ChatChannelMapperImpl;
import com.demo.app.api.chat.mapper.ChatSubscribeMapper;
import com.demo.app.api.chat.mapper.ChatUserMapperImpl;
import com.demo.app.api.chat.repository.ChannelRepository;
import com.demo.app.api.chat.repository.ChannelSubscribeRepository;
import com.demo.app.api.chat.repository.ChatUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService{
    private final ChatUserRepository userRepository;

    private final ChannelSubscribeRepository subscribeRepository;
    private final ChannelRepository channelRepository;

    private final ChatUserMapperImpl chatUserMapper;
    private final ChatChannelMapperImpl channelMapper;
    private final ChatSubscribeMapper subscribeMapper;
    @Override
    public ChatUser chatUserCreate(ChatUser document) {

        return null;
    }

    @Override
    public PhotonResponse chatUserAuth(ChatUserAuthRequest request) {
        PhotonResponse response;
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
                this.chatUserMapper.updateFromDto(request, exist);
                exist = this.userRepository.save(exist);
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
        PhotonResponse response;
        try {
            ChatChannel exist = this.channelRepository.findOneByAppIdAndChannelName(
                    request.getAppId(),
                    request.getRegion(),
                    request.getChannelName()
            );
            ChatUser user = this.userRepository.findOneByAppIdAndUserId(
                    request.getAppId(),
                    request.getUserId()
            );

            if (exist == null) {
                ChatChannel params = this.channelMapper.toCreate(request, user);
                this.channelRepository.insert(params);
            } else {
                this.channelMapper.toUpdate(exist, request, user);
                this.channelRepository.save(exist);
            }
            response = new PhotonDefaultResponse();
            response.successResponse();
        } catch (Exception e) {
            e.printStackTrace();
            response = new PhotonDefaultResponse();
            response.errorResponse(e.getMessage());
        }
        return response;
    }

    @Override
    public PhotonResponse channelSubscribe(ChannelSubscribeRequest request) {
        PhotonResponse response = new PhotonDefaultResponse();
        try {
            ChatUser user = this.userRepository.findOneByAppIdAndUserId(
                    request.getAppId(),
                    request.getUserId()
            );
            ChatChannel targetChannel = this.channelRepository.findOneByAppIdAndChannelName(
                    request.getAppId(),
                    request.getRegion(),
                    request.getChannelName()
            );
            ChatSubscribe exist = this.subscribeRepository.findOneByUserIdAndChannelId(
                    user.get_id(),
                    targetChannel.get_id()
            );

            if (exist!=null) {
                //update
                subscribeMapper.setSubscribe(exist);
                exist = this.subscribeRepository.updateToSubscribe(exist);
            } else {
                //create
                ChatSubscribe subscribe = this.subscribeMapper.setCreate(user,targetChannel);
                exist = this.subscribeRepository.save(subscribe);
            }
            response.successResponse();
        } catch (Exception e) {
            e.printStackTrace();
            response = new PhotonDefaultResponse();
            response.errorResponse(e.getMessage());
        }
        return response;
    }

    @Override
    public PhotonResponse channelUnsubscribe(ChannelUnsubscribeRequest request) {
        PhotonResponse response = new PhotonDefaultResponse();
        try {
            ChatUser user = this.userRepository.findOneByAppIdAndUserId(
                    request.getAppId(),
                    request.getUserId()
            );
            ChatChannel targetChannel = this.channelRepository.findOneByAppIdAndChannelName(
                    request.getAppId(),
                    request.getRegion(),
                    request.getChannelName()
            );
            ChatSubscribe exist = this.subscribeRepository.findOneByUserIdAndChannelId(
                    user.get_id(),
                    targetChannel.get_id()
            );

            if (exist !=null) {
                //update unsubscribe
                this.subscribeMapper.setUnsubscribe(exist);
                exist = this.subscribeRepository.save(exist);
            } else {
                // 구독해제를 하는데 구독엔티티가 없다..?
                log.info("there is no subscribe");
            }

            response.successResponse();
        } catch(Exception e) {
            response.errorResponse(e.getMessage());
        }
        return response;
    }

    @Override
    public PhotonResponse channelDestroy(ChannelDestroyRequest request) {
        PhotonResponse response = new PhotonDefaultResponse();
        try {
            ChatChannel targetChannel = this.channelRepository.findOneByAppIdAndChannelName(
                    request.getAppId(),
                    request.getRegion(),
                    request.getChannelName()
            );

            if(targetChannel != null) {
                targetChannel = this.channelMapper.toDestroy(targetChannel);
            } else {
                //채널 파괴인데 채널이 없다..?
                log.info("target channel missing.");
            }
            response.successResponse();
        } catch(Exception e) {
            response.errorResponse(e.getMessage());
        }
        return response;
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
