package com.demo.app.api.chat.dto;

public interface PhotonResponse {
    void successResponse();
    void errorResponse(String message);
    void errorResponse();
}
