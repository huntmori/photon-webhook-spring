package com.demo.app.api.chat.repository;

import com.demo.app.api.chat.dto.chatChannelCreate.ChannelCreateRequest;
import com.demo.app.api.chat.entity.ChatChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatChannelRepository {
    private final MongoTemplate mongoTemplate;

    public ChatChannel createFromRequest(ChannelCreateRequest request) {
        ChatChannel document = new ChatChannel();
        document.setFromCreateRequest(request);
        return this.insert(document);
    }

    private ChatChannel insert(ChatChannel document) {
        return this.mongoTemplate.insert(document);
    }

    public ChatChannel updateFromRequest(ChatChannel exist, ChannelCreateRequest request) {
        exist.setUpdateFromCreateRequest(request);
        return this.mongoTemplate.save(exist);
    }

    private ChatChannel save(ChatChannel exist) {
        return this.mongoTemplate.save(exist);
    }

    public Criteria findFromRequestCriteria(ChannelCreateRequest request) {
        return Criteria.
                where("appId").is(request.getAppId())
                .and("region").is(request.getRegion())
                .and("channelName").is(request.getChannelName());
    }

    public ChatChannel findFromRequest(ChannelCreateRequest request) {
        Criteria criteria = this.findFromRequestCriteria(request);
        Query query = new Query(criteria);
        return this.mongoTemplate.findOne(query, ChatChannel.class);
    }
}
