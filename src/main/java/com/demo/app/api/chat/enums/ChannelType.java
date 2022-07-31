package com.demo.app.api.chat.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum ChannelType {
    PUBLIC("Public"), PRIVATE("Private");

    @Getter
    @JsonValue
    private final String value;
    ChannelType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
