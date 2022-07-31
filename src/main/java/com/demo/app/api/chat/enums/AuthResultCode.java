package com.demo.app.api.chat.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum AuthResultCode {
    SUCCESS(1), FAIL(2), INVALID_PARAMETER(3);
    @Getter
    @JsonValue
    private final int value;
    AuthResultCode(int value){
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
