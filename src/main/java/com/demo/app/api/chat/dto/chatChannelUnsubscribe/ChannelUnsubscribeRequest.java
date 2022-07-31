package com.demo.app.api.chat.dto.chatChannelUnsubscribe;

import com.demo.app.api.chat.dto.PhotonRequest;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class ChannelUnsubscribeRequest extends PhotonRequest {
    private int HistoryCount;
    private String UserId;
}
