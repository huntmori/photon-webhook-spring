package com.demo.app.api.chat.repository;

import com.demo.app.api.chat.entity.ChatUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatUserRepository {
    private final MongoTemplate mongoTemplate;

    public ChatUser create (ChatUser document) {
        return this.mongoTemplate.insert(document);
    }
}
