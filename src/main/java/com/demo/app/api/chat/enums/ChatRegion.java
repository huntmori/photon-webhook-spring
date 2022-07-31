package com.demo.app.api.chat.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum ChatRegion {
    EU("EU"), ASIA("ASIA"), US("US");

    @Getter
    @JsonValue
    private final String value;
    ChatRegion(String value) {
        this.value = value.toUpperCase();
    }

    @Override
    public String toString() {
        return value;
    }
}
