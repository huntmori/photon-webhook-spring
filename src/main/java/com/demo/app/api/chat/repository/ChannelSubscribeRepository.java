package com.demo.app.api.chat.repository;

import com.demo.app.api.chat.document.ChatSubscribe;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChannelSubscribeRepository {
    private final MongoTemplate mongoTemplate;

    public ChatSubscribe findOneByUserIdAndChannelId(ObjectId userId, ObjectId channelId) {
        Criteria criteria = Criteria
                .where("channelId").is(channelId)
                .and("userId").is(userId);
        Query query = new Query(criteria);

        return this.mongoTemplate.findOne(query, ChatSubscribe.class);
    }

    public ChatSubscribe updateToSubscribe(ChatSubscribe exist) {
        return this.save(exist);
    }

    public ChatSubscribe save(ChatSubscribe exist) {
        return this.mongoTemplate.save(exist);
    }
}
