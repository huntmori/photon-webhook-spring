package com.demo.app.api.chat.dto;

import com.demo.app.api.chat.enums.ChannelType;
import com.demo.app.api.chat.enums.ChatRegion;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class PhotonRequest {
    private String AppId;
    private String AppVersion;
    private ChatRegion Region;
    private ChannelType ChannelType;
    private String  ChannelName;
}
