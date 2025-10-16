package com.mahesh.serviceimplimentation;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class SecretKeyGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    // Generate a 16-character secret key (AES-128)
    public String Key() {
        StringBuilder secret = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 16; i++) {  // 16 chars for AES-128
            int index = random.nextInt(CHARACTERS.length());
            secret.append(CHARACTERS.charAt(index));
        }
        return secret.toString();
    }
}
