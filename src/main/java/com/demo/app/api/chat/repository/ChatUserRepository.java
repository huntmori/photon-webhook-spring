 package com.demo.app.api.chat.repository;

import com.demo.app.api.chat.document.ChatUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatUserRepository {
    private final MongoTemplate mongoTemplate;

    public ChatUser getOneByAppIdAndPlatformId(String appId, String platformAccountId) {
        Criteria criteria = Criteria.where("appId").is(appId)
                .and("platformAccountId").is(platformAccountId);
        Query query = new Query(criteria);

        return this.mongoTemplate.findOne(query, ChatUser.class);
    }

    public ChatUser insert(ChatUser params) {
        return this.mongoTemplate.insert(params);
    }
}
