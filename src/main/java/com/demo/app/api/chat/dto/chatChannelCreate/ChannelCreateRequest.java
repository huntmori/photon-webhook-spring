package com.demo.app.api.chat.dto.chatChannelCreate;

import com.demo.app.api.chat.dto.PhotonRequest;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class ChannelCreateRequest extends PhotonRequest {
    private String UserId;
    private int MaxSubscribers;
    private boolean PublishSubscribers;
}
