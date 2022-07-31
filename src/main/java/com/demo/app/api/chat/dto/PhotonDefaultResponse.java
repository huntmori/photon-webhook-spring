package com.demo.app.api.chat.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString()
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class PhotonDefaultResponse implements PhotonResponse{
    private int ResultCode;
    private String ResultMessage;

    @Override
    public void successResponse() {
        this.setResultCode(0);
        this.setResultMessage("OK");
    }

    @Override
    public void errorResponse(String message) {
        this.setResultCode(1);
        this.setResultMessage(message);
    }

    @Override
    public void errorResponse() {
        this.errorResponse("Unknown ServerError");
    }
}
