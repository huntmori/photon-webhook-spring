package com.demo.app.api.chat.service;

import com.demo.app.api.chat.entity.ChatUser;
import com.demo.app.api.chat.repository.ChatUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService{

    private final ChatUserRepository userRepository;

    @Override
    public ChatUser chatUserCreate(ChatUser document) {
        return this.userRepository.create(document);
    }
}
