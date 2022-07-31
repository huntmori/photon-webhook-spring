package com.demo.app.api.chat.dto.chatUserAuth;

import com.demo.app.api.chat.dto.PhotonResponse;
import com.demo.app.api.chat.enums.AuthResultCode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class ChatUserAuthFailResponse implements PhotonResponse {
    private AuthResultCode ResultCode;
    private String Message;

    public ChatUserAuthFailResponse(AuthResultCode resultCode, String message) {
        this.setResultCode(resultCode);
        this.setMessage(message);
    }
    public ChatUserAuthFailResponse() {}

    @Override
    public void successResponse() {

    }

    @Override
    public void errorResponse(String message) {

    }

    @Override
    public void errorResponse() {

    }
}
