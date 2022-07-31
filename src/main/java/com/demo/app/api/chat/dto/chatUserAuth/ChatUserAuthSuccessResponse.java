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
@ToString(callSuper = true)
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class ChatUserAuthSuccessResponse implements PhotonResponse {
    private AuthResultCode ResultCode;
    private String UserId;

    @Override
    public void successResponse() {
        this.setResultCode(AuthResultCode.SUCCESS);
    }

    @Override
    public void errorResponse(String message) {

    }

    @Override
    public void errorResponse() {

    }
}
