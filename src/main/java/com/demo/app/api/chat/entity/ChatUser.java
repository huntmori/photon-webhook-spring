package com.demo.app.api.chat.entity;

import com.demo.app.api.chat.dto.chatUserAuth.ChatUserAuthRequest;
import com.demo.app.api.chat.enums.ChatRegion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Document
@ToString
public class ChatUser {

}
