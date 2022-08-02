package com.demo.app.api.chat.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatPrivateMessageRepository {
    private final MongoTemplate mongoTemplate;
}
