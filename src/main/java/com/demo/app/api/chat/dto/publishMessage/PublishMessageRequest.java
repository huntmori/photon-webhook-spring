package com.demo.app.api.chat.dto.publishMessage;

import com.demo.app.api.chat.dto.PhotonRequest;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class PublishMessageRequest extends PhotonRequest {
    private int HistoryCount;
    private String UserId;
    private Object Message;
    private List<String> UsersPair;
}
