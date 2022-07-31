package com.demo.app.api.chat.dto.chatUserAuth;

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
public class ChatUserAuthRequest {
    private String PlatformAccountId;
    private String AuthorizationToken;
    private String AppVersion;
    private String AppId;
    private ChatRegion FixedRegion;
}
