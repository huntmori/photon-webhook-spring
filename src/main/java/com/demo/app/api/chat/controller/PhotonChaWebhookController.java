package com.demo.app.api.chat.controller;

import com.demo.app.api.chat.dto.PhotonResponse;
import com.demo.app.api.chat.dto.chatChannelCreate.ChannelCreateRequest;
import com.demo.app.api.chat.dto.chatChannelDestroy.ChannelDestroyRequest;
import com.demo.app.api.chat.dto.chatChannelSubscribe.ChannelSubscribeRequest;
import com.demo.app.api.chat.dto.chatChannelUnsubscribe.ChannelUnsubscribeRequest;
import com.demo.app.api.chat.dto.chatUserAuth.ChatUserAuthRequest;
import com.demo.app.api.chat.dto.publishMessage.PublishMessageRequest;
import com.demo.app.api.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class PhotonChaWebhookController {
    private final ChatService chatService;

    @PostMapping("/v1/chat/user/auth")
    public PhotonResponse chatUserAuth(@RequestBody ChatUserAuthRequest request) {
        log.info("request: "+request.toString());
        return this.chatService.chatUserAuth(request);
    }

    @PostMapping("/v1/chat/channel/create")
    public PhotonResponse chatChannelCreate(@RequestBody ChannelCreateRequest request) {
        log.info("request: "+request.toString());
        return this.chatService.chatChannelCreate(request);
    }

    @PostMapping("/v1/chat/channel/subscribe")
    public PhotonResponse chatChannelSubscribe(@RequestBody ChannelSubscribeRequest request) {
        log.info("request: "+request.toString());
        return this.chatService.channelSubscribe(request);
    }

    @PostMapping("/v1/chat/channel/unsubscribe")
    public PhotonResponse chatChannelUnsubscribe(@RequestBody ChannelUnsubscribeRequest request) {
        log.info("request: "+request.toString());
        return this.chatService.channelUnsubscribe(request);
    }

    @PostMapping("/v1/chat/channel/destroy")
    public PhotonResponse chatChannelDestroy(@RequestBody ChannelDestroyRequest request) {
        log.info("request: "+request.toString());
        return this.chatService.channelDestroy(request);
    }

    @PostMapping("/v1/chat/channel/publish-message")
    public PhotonResponse publishMessage(@RequestBody PublishMessageRequest request) {
        log.info("request: "+request.toString());
        return this.chatService.publishMessage(request);
    }
}
