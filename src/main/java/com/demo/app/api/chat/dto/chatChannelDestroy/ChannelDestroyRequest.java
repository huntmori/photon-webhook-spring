package com.demo.app.api.chat.dto.chatChannelDestroy;

import com.demo.app.api.chat.dto.PhotonRequest;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class ChannelDestroyRequest extends PhotonRequest {
    private int HistoryCount;
}
