package com.demo.app.api.chat.repository;

import com.demo.app.api.chat.dto.chatChannelCreate.ChannelCreateRequest;
import com.demo.app.api.chat.entity.ChatChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
        Criteria criteria = this.findFromRequestCriteria(request);
        Update update = new Update();
        update.set("appVersion", request.getAppVersion());
        update.set("channelType", request.getChannelType());
        update.set("userId", request.getUserId());
        update.set("maxSubscribers", request.getMaxSubscribers());
        update.set("publishSubscribers", request.isPublishSubscribers());

        mongoTemplate.updateMulti(new Query(criteria), update, ChatChannel.class);
        return exist;
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
