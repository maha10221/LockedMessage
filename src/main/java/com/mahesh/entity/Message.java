package com.mahesh.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Transient
    @Column(length = 1000)
    private String message;
    private String password;
    private String secretkey;
    @Column(length = 2000)
    private String encryptmsg;

//    public int getId() { return id; }
//    public void setId(int id) { this.id = id; }
//
//    public String getMessage() { return message; }
//    public void setMessage(String message) { this.message = message; }
//
//    public String getPassword() { return password; }
//    public void setPassword(String password) { this.password = password; }
//
//    public String getSecretkey() { return secretkey; }
//    public void setSecretkey(String secretkey) { this.secretkey = secretkey; }
}
