package com.mahesh.serviceimplimentation;

import com.mahesh.entity.Message;// import repository
import com.mahesh.repository.MessageRepo;
import com.mahesh.service.MessageService;
import com.mahesh.util.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageDAO implements MessageService {

    @Autowired
    private SecretKeyGenerator sg;
    @Autowired
    private MessageRepo messageRepo;

    // <-- Autowired repository

    @Override
    public String encryptMessage(String message, String password) {
        try {
            if (message.length() > 1000) {
                return "⚠️ Message cannot exceed 1000 characters!";
            }
            if (password.length() > 255) {
                return "⚠️ Password cannot exceed 255 characters!";
            }

            // Generate AES key
            String secretKey = sg.Key(); // must be 16 chars

            // Encrypt message using AES
            String encryptedMessage = AESUtil.encrypt(message, secretKey);

            // Hash password using BCrypt
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

            // Save to database
            Message m = new Message();
            m.setMessage(message);           // optional: store original
            m.setEncryptmsg(encryptedMessage);
            m.setPassword(hashedPassword);
            m.setSecretkey(secretKey);
            messageRepo.save(m);  // <-- repository now available

            return  secretKey;

        } catch (Exception e) {
            return "❌ Encryption failed: " + e.getMessage();
        }
    }

    @Override
    public String decryptMessage(String secret, String password) {
        try {
            List<Message> list = messageRepo.findBySecretkey(secret);
            if (list.isEmpty()) return "❌ Invalid Secret Key!";

            Message m = null;
            for (Message msg : list) {
                if (BCrypt.checkpw(password, msg.getPassword())) {
                    m = msg;
                    break;
                }
            }
            if (m == null) return "❌ Invalid Password!";

            // Decrypt message using AES
            String decryptedMessage = AESUtil.decrypt(m.getEncryptmsg(), secret);
            return "✅ Decrypted Message: " + decryptedMessage;

        } catch (Exception e) {
            return "❌ Decryption failed: " + e.getMessage();
        }
    }

    // For Postman testing
    public List<Message> getAllEntry() {
        return messageRepo.findAll();
    }
}
