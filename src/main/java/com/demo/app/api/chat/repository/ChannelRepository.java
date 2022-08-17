package com.demo.app.api.chat.repository;

import com.demo.app.api.chat.document.ChatChannel;
import com.demo.app.api.chat.enums.ChatRegion;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChannelRepository {
    private final MongoTemplate mongoTemplate;

    public ChatChannel findOneByAppIdAndChannelName(String appId, ChatRegion region, String channelName) {
        Criteria criteria = Criteria.where("appId").is(appId)
                .and("region").is(region)
                .and("channelName").is(channelName);
        Query query = new Query(criteria);

        return this.mongoTemplate.findOne(query, ChatChannel.class);
    }


    public ChatChannel insert(ChatChannel params) {
        return this.mongoTemplate.insert(params);
    }

    public ChatChannel save(ChatChannel exist) {
        return this.mongoTemplate.save(exist);
    }
}
