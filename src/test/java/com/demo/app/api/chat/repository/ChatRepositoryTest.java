package com.demo.app.api.chat.repository;

import com.demo.app.api.chat.document.ChatUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class ChatRepositoryTest {
    @Autowired
    private ChatUserRepository chatUserRepository;

    @Test
    @DisplayName("chat-user save test")
    void createChatUser() {
        ChatUser document = new ChatUser();
        document.setAppId("appid");
        document.setRegion("region");
        document.setLatestAppVersion("1.0.0");
        document.setPlatformId("platformId");
        document.setCreatedAt(LocalDateTime.now());
        document.setUpdatedAt(LocalDateTime.now());

        ChatUser saved = this.chatUserRepository.create(document);
        Assertions.assertThat(document).isEqualTo(saved);
        Assertions.assertThat(document.getAppId()).isEqualTo(saved.getAppId());
        Assertions.assertThat(document.getRegion()).isEqualTo(saved.getRegion());
        Assertions.assertThat(document.getLatestAppVersion()).isEqualTo(saved.getLatestAppVersion());
        Assertions.assertThat(document.getPlatformId()).isEqualTo(saved.getPlatformId());
        System.out.println("saved:" + saved.toString());
    }
}
