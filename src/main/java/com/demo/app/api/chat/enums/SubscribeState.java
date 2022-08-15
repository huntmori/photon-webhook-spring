package com.demo.app.api.chat.enums;

public enum SubscribeState {
    SUBSCRIBE(1), UNSUBSCRIBE(0);

    private final int value;
    SubscribeState(int value) {
        this.value = value;
    }

    public int getValue() {  return this.value;  }
}
