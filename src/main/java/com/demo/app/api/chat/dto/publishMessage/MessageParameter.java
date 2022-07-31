package com.demo.app.api.chat.dto.publishMessage;

import com.demo.app.api.chat.enums.MessageMainType;
import com.demo.app.api.chat.enums.MessageSubType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class MessageParameter {
    private MessageMainType MainType;
    private MessageSubType SubType;
    private String  Nickname;
    private Object MessageData;
}
