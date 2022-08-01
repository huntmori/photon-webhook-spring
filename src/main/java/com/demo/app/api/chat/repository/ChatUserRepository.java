package com.demo.app.api.chat.repository;

import com.demo.app.api.chat.dto.chatChannelCreate.ChannelCreateRequest;
import com.demo.app.api.chat.dto.chatUserAuth.ChatUserAuthRequest;
import com.demo.app.api.chat.entity.ChatChannel;
import com.demo.app.api.chat.entity.ChatUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatUserRepository {
    private final MongoTemplate mongoTemplate;

    public ChatUser create (ChatUser document) {
        return this.mongoTemplate.insert(document);
    }

    public ChatUser find(String appId, String platformId) {
        Criteria criteria = Criteria.where("appId").is(appId).and("platformId").is(platformId);
        Query query = new Query(criteria);

        return this.mongoTemplate.findOne(query, ChatUser.class);
    }

    public ChatUser createFromRequest(ChatUserAuthRequest request) {
        ChatUser document = new ChatUser();
        document.setCreateFromRequest(request);
        return this.mongoTemplate.insert(document);
    }

    public ChatUser updateFromRequest(ChatUser user, ChatUserAuthRequest request) {
        user.setUpdateFromRequest(request);
        return this.mongoTemplate.save(user);
    }

    public ChatUser findByChatUserId(String appId, String userId) {
        Criteria condition = Criteria.where("appId").is(appId)
                .and("userId").is("userId");
        Query query = new Query(condition);
        return this.mongoTemplate.findOne(query, ChatUser.class);
    }
}
