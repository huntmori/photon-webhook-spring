package com.demo.app.api.chat.repository;

import com.demo.app.api.chat.entity.ChatChannel;
import com.demo.app.api.chat.entity.ChatSubscribe;
import com.demo.app.api.chat.entity.ChatUser;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatSubscribeRepository {
    private final MongoTemplate mongoTemplate;

    public ChatSubscribe find(ChatUser user, ChatChannel channel) {
        ObjectId userObjectId = user.get_id();
        ObjectId channelObjectId = channel.get_id();
        return this.findByForeignKey(userObjectId,channelObjectId);
    }

    private ChatSubscribe findByForeignKey(ObjectId userObjectId, ObjectId channelObjectId) {
        Criteria criteria = Criteria.where("userObjectId").is(userObjectId)
                .and("channelObjectId").is(channelObjectId);
        Query query = new Query(criteria);

        return this.mongoTemplate.findOne(query, ChatSubscribe.class);
    }
}
