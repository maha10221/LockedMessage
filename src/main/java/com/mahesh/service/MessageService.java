package com.mahesh.service;

import com.mahesh.entity.Message;

import java.util.List;

public interface MessageService {
    String encryptMessage(String message, String password);
    String decryptMessage(String secret, String password);
    public List<Message> getAllEntry();
}
